package br.simba.bem_estar.historico;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Definições compartilhadas por conquistas, metas e comparativo, para que
 * "dia de meta de água" ou "boa noite" signifiquem a mesma coisa em todo o sistema.
 */
public final class HistoricoCalculos {

    public static final double HORAS_BOA_NOITE = 7.0;

    private HistoricoCalculos() {
    }

    /** Soma de água por dia (ignora registros sem data ou com quantidade <= 0). */
    public static Map<LocalDate, Double> aguaPorDia(List<Historico.Agua> agua) {
        Map<LocalDate, Double> porDia = new HashMap<>();
        for (Historico.Agua a : agua) {
            if (a.dataHora() != null && a.ml() > 0) {
                porDia.merge(a.dataHora().toLocalDate(), a.ml(), Double::sum);
            }
        }
        return porDia;
    }

    public static Set<LocalDate> diasComMeta(Map<LocalDate, Double> aguaPorDia, int metaMl) {
        Set<LocalDate> dias = new HashSet<>();
        for (Map.Entry<LocalDate, Double> e : aguaPorDia.entrySet()) {
            if (e.getValue() >= metaMl) {
                dias.add(e.getKey());
            }
        }
        return dias;
    }

    /** Horas dormidas (nunca negativas). */
    public static double horas(Historico.Sono s) {
        if (s.dormir() == null || s.acordar() == null) {
            return 0;
        }
        return Math.max(0, Duration.between(s.dormir(), s.acordar()).toMinutes() / 60.0);
    }

    /** O sono conta no dia em que a pessoa acordou, como no resto do sistema. */
    public static Set<LocalDate> diasSono(List<Historico.Sono> sono) {
        Set<LocalDate> dias = new HashSet<>();
        for (Historico.Sono s : sono) {
            if (s.dormir() != null && s.acordar() != null) {
                dias.add(s.acordar().toLocalDate());
            }
        }
        return dias;
    }

    public static Set<LocalDate> diasBoaNoite(List<Historico.Sono> sono) {
        Set<LocalDate> dias = new HashSet<>();
        for (Historico.Sono s : sono) {
            if (s.dormir() != null && s.acordar() != null && horas(s) >= HORAS_BOA_NOITE) {
                dias.add(s.acordar().toLocalDate());
            }
        }
        return dias;
    }

    public static Set<LocalDate> diasTreino(List<Historico.Treino> treinos) {
        Set<LocalDate> dias = new HashSet<>();
        for (Historico.Treino t : treinos) {
            if (t.dataHora() != null) {
                dias.add(t.dataHora().toLocalDate());
            }
        }
        return dias;
    }

    /** Maior quantidade de dias consecutivos dentro do conjunto. */
    public static int maiorSequencia(Set<LocalDate> dias) {
        int maior = 0;
        int sequencia = 0;
        LocalDate anterior = null;
        for (LocalDate dia : new TreeSet<>(dias)) {
            sequencia = (anterior != null && dia.equals(anterior.plusDays(1))) ? sequencia + 1 : 1;
            maior = Math.max(maior, sequencia);
            anterior = dia;
        }
        return maior;
    }

    /** Sequência que ainda está viva: termina hoje ou ontem (hoje ainda pode ser registrado). */
    public static int sequenciaAtual(Set<LocalDate> dias, LocalDate hoje) {
        LocalDate cursor = dias.contains(hoje) ? hoje : hoje.minusDays(1);
        int atual = 0;
        while (dias.contains(cursor)) {
            atual++;
            cursor = cursor.minusDays(1);
        }
        return atual;
    }

    public static Set<LocalDate> doIntervalo(Set<LocalDate> dias, LocalDate inicio, LocalDate fim) {
        Set<LocalDate> filtrados = new HashSet<>();
        for (LocalDate d : dias) {
            if (!d.isBefore(inicio) && !d.isAfter(fim)) {
                filtrados.add(d);
            }
        }
        return filtrados;
    }
}
