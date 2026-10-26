package br.simba.bem_estar.streak;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.TreeSet;

/**
 * Regra do streak (ofensiva), sem dependência de banco ou Spring.
 *
 * Dia ativo = dia com pelo menos um registro (água, sono ou treino).
 *
 * A ofensiva aguenta pequenas faltas, mas é honesta: os dias sem registro
 * não entram na contagem. Ela só quebra se a pessoa:
 *  - ficar mais de 2 dias seguidos sem registrar; ou
 *  - faltar em mais de 2 dias dentro de uma mesma semana (janela de 7 dias).
 *
 * Depois da primeira falta a ofensiva fica "em risco" por até 2 dias
 * (o leão mostra medo) e volta ao normal assim que a pessoa registra.
 */
public final class StreakCalculator {

    public static final int TOLERANCIA_SEGUIDOS = 2;
    public static final int FOLGAS_POR_SEMANA = 2;

    private StreakCalculator() {
    }

    public static StreakDTO calcular(Set<LocalDate> diasAtivos, LocalDate hoje) {
        // Registros com data futura não contam: não podem inflar nem alterar a ofensiva.
        TreeSet<LocalDate> dias = new TreeSet<>();
        for (LocalDate dia : diasAtivos) {
            if (dia != null && !dia.isAfter(hoje)) {
                dias.add(dia);
            }
        }
        boolean ativoHoje = dias.contains(hoje);
        if (dias.isEmpty()) {
            return new StreakDTO(0, 0, false, false, 0, false, false, false, false);
        }

        int atual = 0;
        int maior = 0;
        int seguidos = 0; // dias inteiros sem registro, em sequência
        Deque<LocalDate> folgas = new ArrayDeque<>(); // faltas da sequência viva, na última semana

        for (LocalDate dia = dias.first(); !dia.isAfter(hoje); dia = dia.plusDays(1)) {
            if (dias.contains(dia)) {
                atual++;
                seguidos = 0;
            } else if (dia.isBefore(hoje)) { // hoje ainda pode ser registrado: não é falta
                seguidos++;
                if (atual > 0) {
                    folgas.addLast(dia);
                    podar(folgas, dia);
                    if (seguidos > TOLERANCIA_SEGUIDOS || folgas.size() > FOLGAS_POR_SEMANA) {
                        atual = 0;
                        folgas.clear();
                    }
                }
            }
            maior = Math.max(maior, atual);
        }
        podar(folgas, hoje);

        boolean emRisco = false;
        boolean ultimaChance = false;
        int diaRisco = 0;
        if (!ativoHoje && atual > 0) {
            boolean semFolgaSeguida = seguidos >= TOLERANCIA_SEGUIDOS;
            boolean semFolgaNaSemana = folgas.size() >= FOLGAS_POR_SEMANA;
            emRisco = seguidos >= 1 || semFolgaNaSemana;
            ultimaChance = emRisco && (semFolgaSeguida || semFolgaNaSemana);
            diaRisco = !emRisco ? 0 : (ultimaChance ? TOLERANCIA_SEGUIDOS : seguidos);
        }

        return new StreakDTO(atual, maior, ativoHoje, emRisco, diaRisco, ultimaChance, false, false, false);
    }

    /** Mantém só as faltas dos últimos 7 dias (contando o dia de referência). */
    private static void podar(Deque<LocalDate> folgas, LocalDate referencia) {
        while (!folgas.isEmpty() && folgas.peekFirst().isBefore(referencia.minusDays(6))) {
            folgas.removeFirst();
        }
    }
}
