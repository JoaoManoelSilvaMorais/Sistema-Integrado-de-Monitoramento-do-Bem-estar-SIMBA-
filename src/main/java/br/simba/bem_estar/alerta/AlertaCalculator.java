package br.simba.bem_estar.alerta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoCalculos;

/**
 * Regra dos alertas preventivos (RF16 e RF17). Java puro, sem Spring.
 *
 * Os limites abaixo são pontos de partida da equipe e ficam todos nas constantes, para
 * serem ajustados num lugar só. Eles não são critério clínico: o alerta apenas sugere
 * conversar com um profissional de saúde.
 *
 * - Sono:   nas últimas 4 noites registradas, todas ruins (menos de 7 h ou nota 1-2).
 * - Água:   nos últimos 3 dias com registro (sem contar hoje), todos abaixo de 50% da meta.
 * - Treino: 14 dias sem nenhum treino, para quem já usa o app há pelo menos 14 dias.
 *
 * Sono e água só alertam se o último dia avaliado for recente (até 3 dias atrás), para não
 * avisar sobre um problema antigo que a pessoa já pode ter superado.
 */
public final class AlertaCalculator {

    public static final String AVISO =
            "O SIMBA tem finalidade preventiva e de autocuidado. Estas orientações não substituem "
                    + "a avaliação nem o diagnóstico de um profissional de saúde.";

    public static final int NOITES_AVALIADAS = 4;
    public static final int NOTA_NOITE_RUIM = 2;
    public static final int DIAS_AGUA_AVALIADOS = 3;
    public static final double FRACAO_AGUA_BAIXA = 0.5;
    public static final int DIAS_SEM_TREINO = 14;
    public static final int DIAS_DE_RECENCIA = 3;

    private AlertaCalculator() {
    }

    public static List<AlertaDTO> calcular(Historico historico, int metaAguaMl, LocalDate hoje) {
        List<AlertaDTO> alertas = new ArrayList<>();
        sono(historico.sono(), hoje).ifPresent(alertas::add);
        agua(historico.agua(), metaAguaMl, hoje).ifPresent(alertas::add);
        treino(historico, hoje).ifPresent(alertas::add);
        return alertas;
    }

    static Optional<AlertaDTO> sono(List<Historico.Sono> registros, LocalDate hoje) {
        // Uma noite por dia (o sono conta no dia em que a pessoa acordou); se houver mais de um
        // registro no dia (ex.: um cochilo), vale o mais longo, para o cochilo não virar "noite ruim".
        Map<LocalDate, Historico.Sono> porDia = new TreeMap<>(Comparator.reverseOrder());
        for (Historico.Sono s : registros) {
            if (s.dormir() == null || s.acordar() == null) {
                continue;
            }
            LocalDate dia = s.acordar().toLocalDate();
            if (dia.isAfter(hoje)) {
                continue;
            }
            porDia.merge(dia, s, (a, b) -> HistoricoCalculos.horas(a) >= HistoricoCalculos.horas(b) ? a : b);
        }
        if (porDia.size() < NOITES_AVALIADAS || ehAntigo(porDia, hoje)) {
            return Optional.empty();
        }

        boolean todasRuins = porDia.values().stream()
                .limit(NOITES_AVALIADAS)
                .allMatch(AlertaCalculator::ehNoiteRuim);
        if (!todasRuins) {
            return Optional.empty();
        }
        return Optional.of(new AlertaDTO(
                TipoAlerta.SONO,
                "Seu sono precisa de atenção",
                "Nas suas últimas " + NOITES_AVALIADAS + " noites registradas você dormiu menos de "
                        + (int) HistoricoCalculos.HORAS_BOA_NOITE + " horas ou avaliou o sono com nota baixa.",
                "Se isso continuar, vale conversar com um médico ou outro profissional de saúde."));
    }

    static Optional<AlertaDTO> agua(List<Historico.Agua> registros, int metaAguaMl, LocalDate hoje) {
        if (metaAguaMl <= 0) {
            return Optional.empty();
        }
        // Só dias fechados: hoje ainda está em andamento e não pode ser julgado.
        Map<LocalDate, Double> porDia = new TreeMap<>(Comparator.reverseOrder());
        HistoricoCalculos.aguaPorDia(registros).forEach((dia, ml) -> {
            if (dia.isBefore(hoje)) {
                porDia.put(dia, ml);
            }
        });
        if (porDia.size() < DIAS_AGUA_AVALIADOS || ehAntigo(porDia, hoje)) {
            return Optional.empty();
        }

        double limite = metaAguaMl * FRACAO_AGUA_BAIXA;
        boolean todosBaixos = porDia.values().stream()
                .limit(DIAS_AGUA_AVALIADOS)
                .allMatch(ml -> ml < limite);
        if (!todosBaixos) {
            return Optional.empty();
        }
        return Optional.of(new AlertaDTO(
                TipoAlerta.AGUA,
                "Hidratação abaixo do esperado",
                "Nos seus últimos " + DIAS_AGUA_AVALIADOS + " dias com registro, você bebeu menos da metade da sua meta de água.",
                "Se também sentir tontura, cansaço excessivo ou dor de cabeça frequente, procure um profissional de saúde."));
    }

    static Optional<AlertaDTO> treino(Historico historico, LocalDate hoje) {
        Set<LocalDate> diasDeUso = new HashSet<>(HistoricoCalculos.aguaPorDia(historico.agua()).keySet());
        diasDeUso.addAll(HistoricoCalculos.diasSono(historico.sono()));
        Set<LocalDate> diasTreino = HistoricoCalculos.diasTreino(historico.treinos());
        diasDeUso.addAll(diasTreino);

        LocalDate inicio = hoje.minusDays(DIAS_SEM_TREINO - 1L);
        // Quem começou a usar o app há pouco ainda não teve tempo de "ficar parado".
        boolean usaHaPouco = diasDeUso.stream().noneMatch(d -> !d.isAfter(inicio));
        if (usaHaPouco) {
            return Optional.empty();
        }
        if (!HistoricoCalculos.doIntervalo(diasTreino, inicio, hoje).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new AlertaDTO(
                TipoAlerta.TREINO,
                "Muitos dias sem atividade física",
                "Você não registrou nenhum treino nos últimos " + DIAS_SEM_TREINO + " dias.",
                "Retome aos poucos e, se sentir desconforto ou tiver alguma condição de saúde, "
                        + "converse com um profissional de saúde."));
    }

    /** Noite ruim = menos de 7 h ou nota 1-2 (a mesma ideia de "boa noite" do resto do sistema). */
    static boolean ehNoiteRuim(Historico.Sono s) {
        boolean curta = HistoricoCalculos.horas(s) < HistoricoCalculos.HORAS_BOA_NOITE;
        boolean notaBaixa = s.nota() != null && s.nota() > 0 && s.nota() <= NOTA_NOITE_RUIM;
        return curta || notaBaixa;
    }

    /** O dia mais recente avaliado (primeira chave, ordem decrescente) já ficou para trás? */
    private static boolean ehAntigo(Map<LocalDate, ?> porDiaDecrescente, LocalDate hoje) {
        LocalDate maisRecente = porDiaDecrescente.keySet().iterator().next();
        return maisRecente.isBefore(hoje.minusDays(DIAS_DE_RECENCIA));
    }
}
