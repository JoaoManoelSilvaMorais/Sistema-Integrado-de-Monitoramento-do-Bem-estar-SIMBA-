package br.simba.bem_estar.sintoma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.simba.bem_estar.exceptions.RegraDeNegocioException;

/**
 * Regras do questionário "Sinais Corporais", em Java puro (sem Spring) para ser fácil de testar.
 * - validar(): confere e normaliza as respostas antes de gravar;
 * - resumirSemana(): médias e padrões dos últimos 7 dias.
 */
public final class SintomaCalculator {

    public static final int NOTA_MIN = 1;
    public static final int NOTA_MAX = 5;
    public static final int OBSERVACAO_MAX = 300;
    public static final int DIAS_SEMANA = 7;

    private SintomaCalculator() {
    }

    /** Respostas já validadas e normalizadas (sem repetição, listas nunca nulas). */
    public record Respostas(
            int energia,
            int humor,
            int estresse,
            NivelDor dor,
            List<LocalDor> locaisDor,
            List<Sintoma> sintomas,
            String observacao) {
    }

    /** Um dia já gravado, só com o que o resumo precisa. */
    public record Dia(
            LocalDate data,
            int energia,
            int humor,
            int estresse,
            NivelDor dor,
            List<Sintoma> sintomas) {
    }

    // ------------------------------------------------------------------ validação

    public static Respostas validar(RegistroSintomaDTO dados) {
        if (dados == null) {
            throw new RegraDeNegocioException("Responda o questionário antes de enviar.");
        }
        int energia = nota(dados.energia(), "energia");
        int humor = nota(dados.humor(), "humor");
        int estresse = nota(dados.estresse(), "estresse/ansiedade");

        if (dados.dor() == null || dados.dor().isBlank()) {
            throw new RegraDeNegocioException("Informe se está sentindo dor (pode ser \"nenhuma\").");
        }
        NivelDor dor = converter(NivelDor.class, dados.dor(), "Nível de dor inválido");

        List<LocalDor> locais = new ArrayList<>();
        if (dor != NivelDor.NENHUMA) {
            locais = converterLista(LocalDor.class, dados.locaisDor(), "Local de dor inválido");
            if (locais.isEmpty()) {
                throw new RegraDeNegocioException("Escolha onde está doendo.");
            }
        }
        // Com dor "nenhuma", os locais enviados são ignorados.

        List<Sintoma> sintomas = converterLista(Sintoma.class, dados.sintomas(), "Sintoma inválido");
        if (sintomas.isEmpty()) {
            sintomas = List.of(Sintoma.NENHUM);
        } else if (sintomas.contains(Sintoma.NENHUM) && sintomas.size() > 1) {
            throw new RegraDeNegocioException("\"Nenhum\" não pode ser marcado junto com outros sintomas.");
        }

        String observacao = dados.observacao() == null ? null : dados.observacao().trim();
        if (observacao != null && observacao.isEmpty()) {
            observacao = null;
        }
        if (observacao != null && observacao.length() > OBSERVACAO_MAX) {
            throw new RegraDeNegocioException(
                    "A observação pode ter no máximo " + OBSERVACAO_MAX + " caracteres.");
        }

        return new Respostas(energia, humor, estresse, dor, List.copyOf(locais), List.copyOf(sintomas), observacao);
    }

    private static int nota(Integer valor, String campo) {
        if (valor == null) {
            throw new RegraDeNegocioException("Responda a nota de " + campo + ".");
        }
        if (valor < NOTA_MIN || valor > NOTA_MAX) {
            throw new RegraDeNegocioException(
                    "A nota de " + campo + " deve ser de " + NOTA_MIN + " a " + NOTA_MAX + ".");
        }
        return valor;
    }

    private static <E extends Enum<E>> E converter(Class<E> tipo, String valor, String erro) {
        try {
            return Enum.valueOf(tipo, valor.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RegraDeNegocioException(erro + ": " + valor);
        }
    }

    private static <E extends Enum<E>> List<E> converterLista(Class<E> tipo, List<String> valores, String erro) {
        Set<E> resultado = new LinkedHashSet<>();
        if (valores != null) {
            for (String v : valores) {
                if (v == null || v.isBlank()) {
                    continue;
                }
                resultado.add(converter(tipo, v, erro));
            }
        }
        return new ArrayList<>(resultado);
    }

    // ------------------------------------------------------------------ texto <-> lista (banco)

    /** Junta os enums em "A,B,C" para gravar no banco. */
    public static String paraTexto(List<? extends Enum<?>> itens) {
        if (itens == null || itens.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Enum<?> e : itens) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(e.name());
        }
        return sb.toString();
    }

    /** Lê "A,B,C" do banco. Valores desconhecidos são ignorados (não quebram o histórico). */
    public static <E extends Enum<E>> List<E> deTexto(Class<E> tipo, String texto) {
        List<E> lista = new ArrayList<>();
        if (texto == null || texto.isBlank()) {
            return lista;
        }
        for (String parte : texto.split(",")) {
            try {
                E e = Enum.valueOf(tipo, parte.trim());
                if (!lista.contains(e)) {
                    lista.add(e);
                }
            } catch (IllegalArgumentException ignorado) {
                // valor antigo/inválido: pula
            }
        }
        return lista;
    }

    // ------------------------------------------------------------------ resumo da semana

    /** Resumo dos últimos 7 dias (de hoje-6 até hoje). Dias fora da janela são ignorados. */
    public static SintomaResumoDTO resumirSemana(List<Dia> dias, LocalDate hoje) {
        LocalDate inicio = hoje.minusDays(DIAS_SEMANA - 1L);
        List<Dia> semana = new ArrayList<>();
        if (dias != null) {
            for (Dia d : dias) {
                if (d != null && d.data() != null && !d.data().isBefore(inicio) && !d.data().isAfter(hoje)) {
                    semana.add(d);
                }
            }
        }

        int n = semana.size();
        if (n == 0) {
            return new SintomaResumoDTO(0, null, null, null, 0, null, 0,
                    "Responda o questionário por alguns dias para ver seus padrões aqui.");
        }

        double somaEnergia = 0, somaHumor = 0, somaEstresse = 0;
        int diasComDor = 0;
        Map<Sintoma, Integer> contagem = new EnumMap<>(Sintoma.class);
        for (Dia d : semana) {
            somaEnergia += d.energia();
            somaHumor += d.humor();
            somaEstresse += d.estresse();
            if (d.dor() != null && d.dor() != NivelDor.NENHUMA) {
                diasComDor++;
            }
            if (d.sintomas() != null) {
                for (Sintoma s : new LinkedHashSet<>(d.sintomas())) {
                    if (s != Sintoma.NENHUM) {
                        contagem.merge(s, 1, Integer::sum);
                    }
                }
            }
        }

        // Empate: vale a ordem do enum (EnumMap já itera nessa ordem).
        Sintoma maisFrequente = null;
        int vezes = 0;
        for (Map.Entry<Sintoma, Integer> e : contagem.entrySet()) {
            if (e.getValue() > vezes) {
                maisFrequente = e.getKey();
                vezes = e.getValue();
            }
        }

        double mediaEnergia = arredondar(somaEnergia / n);
        double mediaHumor = arredondar(somaHumor / n);
        double mediaEstresse = arredondar(somaEstresse / n);

        String mensagem = mensagem(n, mediaEnergia, mediaHumor, mediaEstresse, diasComDor, maisFrequente, vezes);

        return new SintomaResumoDTO(n, mediaEnergia, mediaHumor, mediaEstresse, diasComDor,
                maisFrequente == null ? null : maisFrequente.name(), vezes, mensagem);
    }

    /** Uma frase curta sobre o padrão mais importante da semana (sem dar diagnóstico). */
    static String mensagem(int dias, double energia, double humor, double estresse,
            int diasComDor, Sintoma maisFrequente, int vezes) {
        if (estresse >= 4) {
            return "Seu estresse ficou alto nesta semana. Que tal reservar um momento para descansar?";
        }
        if (maisFrequente != null && vezes >= 3) {
            return maisFrequente.getRotulo() + " apareceu em " + vezes
                    + " dias nesta semana. Fique de olho e, se continuar, procure um profissional de saúde.";
        }
        if (diasComDor >= 3) {
            return "Você sentiu dor em " + diasComDor
                    + " dias nesta semana. Se continuar, vale procurar um profissional de saúde.";
        }
        if (energia <= 2.5) {
            return "Sua energia andou baixa nesta semana. Vale conferir como está o seu sono.";
        }
        if (energia >= 4 && humor >= 4) {
            return "Semana boa! Energia e humor em alta. Continue assim.";
        }
        return "Você respondeu " + dias + " de " + DIAS_SEMANA
                + " dias. Continue registrando para perceber seus padrões.";
    }

    private static double arredondar(double valor) {
        return Math.round(valor * 10) / 10.0;
    }
}
