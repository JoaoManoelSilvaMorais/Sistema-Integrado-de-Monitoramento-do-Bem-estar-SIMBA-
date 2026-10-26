package br.simba.bem_estar.conquista;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoCalculos;

/**
 * Regras das conquistas, sem dependência de banco ou Spring (por isso é fácil de testar).
 * Recebe os registros do usuário e devolve, para cada conquista, o valor atual
 * dele (ex.: 7 treinos). A conquista está cumprida quando valor >= meta.
 */
public final class ConquistaCalculator {

    /** Meta de água usada quando o usuário não definiu uma (a sugestão por peso é calculada em outro ponto). */
    public static final int META_AGUA_PADRAO_ML = 2000;
    public static final int NOTA_MIN = 1;
    public static final int NOTA_MAX = 5;

    public record Rotinas(int total, int comLembrete, int ativas) { }

    private ConquistaCalculator() {
    }

    /** A meta de "Hidratado" acompanha a meta de água do usuário; as demais são fixas. */
    public static int metaDe(Conquista conquista, int metaAguaMl) {
        return conquista == Conquista.AGUA_META_DIA ? metaAguaMl : conquista.getMeta();
    }

    public static Map<Conquista, Integer> calcular(
            Historico historico, Rotinas rotinas, int maiorStreak, int metaAguaMl) {

        // ---------- Água ----------
        int registrosAgua = 0;
        double totalMl = 0;
        for (Historico.Agua a : historico.agua()) {
            if (a.dataHora() != null && a.ml() > 0) {
                registrosAgua++;
                totalMl += a.ml();
            }
        }
        Map<LocalDate, Double> aguaPorDia = HistoricoCalculos.aguaPorDia(historico.agua());
        double melhorDiaMl = 0;
        for (double total : aguaPorDia.values()) {
            melhorDiaMl = Math.max(melhorDiaMl, total);
        }
        Set<LocalDate> diasMetaAgua = HistoricoCalculos.diasComMeta(aguaPorDia, metaAguaMl);

        // ---------- Sono ----------
        int noites = 0;
        double melhorHoras = 0;
        int melhorNota = 0;
        for (Historico.Sono s : historico.sono()) {
            if (s.dormir() == null || s.acordar() == null) {
                continue;
            }
            noites++;
            melhorHoras = Math.max(melhorHoras, HistoricoCalculos.horas(s));
            if (s.nota() != null && s.nota() >= NOTA_MIN && s.nota() <= NOTA_MAX) {
                melhorNota = Math.max(melhorNota, s.nota());
            }
        }
        Set<LocalDate> diasSono = HistoricoCalculos.diasSono(historico.sono());
        Set<LocalDate> diasBoaNoite = HistoricoCalculos.diasBoaNoite(historico.sono());

        // ---------- Treinos ----------
        int totalTreinos = 0;
        double totalKcal = 0;
        Set<String> modalidades = new HashSet<>();
        for (Historico.Treino t : historico.treinos()) {
            if (t.dataHora() == null) {
                continue;
            }
            totalTreinos++;
            totalKcal += Math.max(0, t.kcal());
            if (t.modalidade() != null && !t.modalidade().isBlank()) {
                modalidades.add(t.modalidade().trim().toLowerCase());
            }
        }
        Set<LocalDate> diasTreino = HistoricoCalculos.diasTreino(historico.treinos());

        // ---------- Dias completos (água + sono + treino no mesmo dia) ----------
        Set<LocalDate> completos = new HashSet<>(aguaPorDia.keySet());
        completos.retainAll(diasSono);
        completos.retainAll(diasTreino);

        Map<Conquista, Integer> r = new EnumMap<>(Conquista.class);
        r.put(Conquista.AGUA_PRIMEIRO_GOLE, registrosAgua);
        r.put(Conquista.AGUA_META_DIA, (int) melhorDiaMl);
        r.put(Conquista.AGUA_SEMANA, HistoricoCalculos.maiorSequencia(diasMetaAgua));
        r.put(Conquista.AGUA_50L, (int) (totalMl / 1000));
        r.put(Conquista.AGUA_10_DIAS, diasMetaAgua.size());
        r.put(Conquista.AGUA_200L, (int) (totalMl / 1000));
        r.put(Conquista.AGUA_30_DIAS, diasMetaAgua.size());

        r.put(Conquista.SONO_PRIMEIRA, noites);
        r.put(Conquista.SONO_8H, (int) melhorHoras);
        r.put(Conquista.SONO_NOTA_5, melhorNota);
        r.put(Conquista.SONO_7_BOAS, HistoricoCalculos.maiorSequencia(diasBoaNoite));

        r.put(Conquista.TREINO_PRIMEIRO, totalTreinos);
        r.put(Conquista.TREINO_10, totalTreinos);
        r.put(Conquista.TREINO_30, totalTreinos);
        r.put(Conquista.TREINO_KCAL, (int) totalKcal);
        r.put(Conquista.TREINO_KCAL_5000, (int) totalKcal);
        r.put(Conquista.TREINO_VARIADO, modalidades.size());

        r.put(Conquista.ROTINA_PRIMEIRA, rotinas.total());
        r.put(Conquista.ROTINA_LEMBRETE, rotinas.comLembrete());
        r.put(Conquista.ROTINA_3_ATIVAS, rotinas.ativas());

        r.put(Conquista.STREAK_3, maiorStreak);
        r.put(Conquista.STREAK_7, maiorStreak);
        r.put(Conquista.STREAK_30, maiorStreak);
        r.put(Conquista.STREAK_60, maiorStreak);
        r.put(Conquista.STREAK_100, maiorStreak);

        r.put(Conquista.DIA_COMPLETO, completos.size());
        return r;
    }
}
