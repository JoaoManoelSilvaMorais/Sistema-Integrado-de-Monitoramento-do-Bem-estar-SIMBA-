package br.simba.bem_estar.proximopasso;

import java.util.List;

import br.simba.bem_estar.conquista.ConquistaDTO;
import br.simba.bem_estar.meta.MetaDTO;
import br.simba.bem_estar.streak.StreakDTO;

/**
 * Escolhe a sugestão do card de boas-vindas, sem dependência de banco ou Spring.
 * Ordem de prioridade: ofensiva em risco > "quase lá" > água de hoje > meta ativa > conquista próxima > tudo em dia.
 */
public final class ProximoPassoCalculator {

    private static final double RAZAO_QUASE_LA = 0.8;
    private static final double RAZAO_CONQUISTA_PROXIMA = 0.5;

    public record Entrada(
            StreakDTO streak,
            int aguaHojeMl,
            int metaAguaMl,
            List<MetaDTO> metas,
            List<ConquistaDTO> conquistas) { }

    private ProximoPassoCalculator() {
    }

    public static ProximoPassoDTO escolher(Entrada e) {
        StreakDTO s = e.streak();

        // 1) Ofensiva em risco: é o que a pessoa mais perde se ignorar.
        if (s.emRisco()) {
            String dias = s.atual() + (s.atual() == 1 ? " dia" : " dias");
            String texto = s.ultimaChance()
                    ? "Última chance! Registre algo hoje para salvar sua ofensiva de " + dias + "."
                    : "Sua ofensiva de " + dias + " está em risco. Registre algo hoje!";
            return new ProximoPassoDTO("risco", texto, paginaParaRegistrar(s), "fa-fire");
        }

        // 2) "Quase lá": algo que está a um passo de ser concluído.
        MetaDTO metaQuase = null;
        for (MetaDTO m : e.metas()) {
            if (!m.concluida() && quaseLa(m.progressoAtual(), m.alvo())
                    && (metaQuase == null || razao(m) > razao(metaQuase))) {
                metaQuase = m;
            }
        }
        ConquistaDTO conquistaQuase = null;
        for (ConquistaDTO c : e.conquistas()) {
            if (!c.desbloqueada() && c.progressoMeta() > 1 && quaseLa(c.progressoAtual(), c.progressoMeta())
                    && (conquistaQuase == null || razao(c) > razao(conquistaQuase))) {
                conquistaQuase = c;
            }
        }
        if (metaQuase != null && (conquistaQuase == null || razao(metaQuase) >= razao(conquistaQuase))) {
            return faltaParaMeta("quase", metaQuase);
        }
        if (conquistaQuase != null) {
            return faltaParaConquista("quase", conquistaQuase);
        }

        // 3) Água de hoje.
        if (e.aguaHojeMl() < e.metaAguaMl()) {
            int falta = e.metaAguaMl() - e.aguaHojeMl();
            String texto = e.aguaHojeMl() <= 0
                    ? "Comece o dia com água: sua meta de hoje é de " + ml(e.metaAguaMl()) + "."
                    : "Faltam " + ml(falta) + " para bater sua meta de água hoje.";
            return new ProximoPassoDTO("agua", texto, "hidratacao.html", "fa-droplet");
        }

        // 4) Meta ativa mais adiantada.
        MetaDTO melhorMeta = null;
        for (MetaDTO m : e.metas()) {
            if (!m.concluida() && (melhorMeta == null || razao(m) > razao(melhorMeta))) {
                melhorMeta = m;
            }
        }
        if (melhorMeta != null) {
            String texto = "Continue sua meta: " + melhorMeta.titulo() + " ("
                    + melhorMeta.progressoAtual() + "/" + melhorMeta.alvo() + " " + melhorMeta.unidade() + ").";
            return new ProximoPassoDTO("meta", texto, "conquistas.html#metas", melhorMeta.icone());
        }

        // 5) Conquista mais próxima.
        ConquistaDTO proxima = null;
        for (ConquistaDTO c : e.conquistas()) {
            if (!c.desbloqueada() && c.progressoMeta() > 1 && razao(c) >= RAZAO_CONQUISTA_PROXIMA
                    && (proxima == null || razao(c) > razao(proxima))) {
                proxima = c;
            }
        }
        if (proxima != null) {
            return faltaParaConquista("conquista", proxima);
        }

        return new ProximoPassoDTO("ok", "Tudo em dia por hoje. Continue assim!", null, "fa-circle-check");
    }

    private static ProximoPassoDTO faltaParaMeta(String tipo, MetaDTO m) {
        int falta = m.alvo() - m.progressoAtual();
        return new ProximoPassoDTO(tipo,
                faltam(falta, m.unidade()) + " para sua meta: " + m.titulo() + ".",
                "conquistas.html#metas", m.icone());
    }

    private static ProximoPassoDTO faltaParaConquista(String tipo, ConquistaDTO c) {
        int falta = c.progressoMeta() - c.progressoAtual();
        return new ProximoPassoDTO(tipo,
                faltam(falta, c.unidade()) + " para a conquista " + c.nome() + ".",
                "conquistas.html", "fa-trophy");
    }

    private static boolean quaseLa(int atual, int meta) {
        return meta > 0 && atual < meta && ((meta - atual) == 1 || (double) atual / meta >= RAZAO_QUASE_LA);
    }

    private static double razao(MetaDTO m) {
        return m.alvo() == 0 ? 0 : (double) m.progressoAtual() / m.alvo();
    }

    private static double razao(ConquistaDTO c) {
        return c.progressoMeta() == 0 ? 0 : (double) c.progressoAtual() / c.progressoMeta();
    }

    /** "Falta 1 dia" / "Faltam 3 dias" / "Faltam 650 ml". */
    static String faltam(int n, String unidade) {
        String verbo = n == 1 ? "Falta" : "Faltam";
        String u = unidade == null ? "" : unidade;
        if (n == 1 && u.length() > 3 && u.endsWith("s")) {
            u = u.substring(0, u.length() - 1);
        }
        return verbo + " " + n + (u.isEmpty() ? "" : " " + u);
    }

    static String ml(int valor) {
        return valor < 1000 ? valor + " ml" : (valor / 1000) + "." + String.format("%03d", valor % 1000) + " ml";
    }

    /** Leva para onde o registro é mais rápido: água, depois sono, depois treino. */
    static String paginaParaRegistrar(StreakDTO s) {
        if (!s.aguaHoje()) {
            return "hidratacao.html";
        }
        return !s.sonoHoje() ? "sono.html" : "treinos.html";
    }
}
