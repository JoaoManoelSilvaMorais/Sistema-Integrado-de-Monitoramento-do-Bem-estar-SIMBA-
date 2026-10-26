package br.simba.bem_estar.comparativo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoCalculos;

/** Comparativo semanal, sem dependência de banco ou Spring. */
public final class ComparativoCalculator {

    private ComparativoCalculator() {
    }

    public static ComparativoDTO calcular(Historico historico, LocalDate hoje) {
        LocalDate iniAtual = hoje.minusDays(6);
        LocalDate iniAnterior = hoje.minusDays(13);
        LocalDate fimAnterior = hoje.minusDays(7);

        // Água: média diária de ml nos 7 dias (dia sem registro conta como zero).
        Map<LocalDate, Double> aguaPorDia = HistoricoCalculos.aguaPorDia(historico.agua());
        double aguaAtual = somaNoIntervalo(aguaPorDia, iniAtual, hoje) / 7.0;
        double aguaAnterior = somaNoIntervalo(aguaPorDia, iniAnterior, fimAnterior) / 7.0;

        // Sono: média de horas por noite registrada.
        double sonoAtual = mediaSono(historico, iniAtual, hoje);
        double sonoAnterior = mediaSono(historico, iniAnterior, fimAnterior);

        // Treinos: quantos dias teve treino.
        Set<LocalDate> diasTreino = HistoricoCalculos.diasTreino(historico.treinos());
        int treinoAtual = HistoricoCalculos.doIntervalo(diasTreino, iniAtual, hoje).size();
        int treinoAnterior = HistoricoCalculos.doIntervalo(diasTreino, iniAnterior, fimAnterior).size();

        // Dias ativos: dias com qualquer registro.
        Set<LocalDate> todos = new HashSet<>(aguaPorDia.keySet());
        todos.addAll(HistoricoCalculos.diasSono(historico.sono()));
        todos.addAll(diasTreino);
        int ativosAtual = HistoricoCalculos.doIntervalo(todos, iniAtual, hoje).size();
        int ativosAnterior = HistoricoCalculos.doIntervalo(todos, iniAnterior, fimAnterior).size();

        return new ComparativoDTO(
                metrica(Math.round(aguaAtual), Math.round(aguaAnterior)),
                metrica(arredondar1(sonoAtual), arredondar1(sonoAnterior)),
                metrica(treinoAtual, treinoAnterior),
                metrica(ativosAtual, ativosAnterior));
    }

    static ComparativoDTO.Metrica metrica(double atual, double anterior) {
        if (anterior == 0) {
            return new ComparativoDTO.Metrica(atual, anterior, null, atual == 0 ? "sem" : "novo");
        }
        int variacao = (int) Math.round((atual - anterior) / anterior * 100);
        String tendencia = variacao > 0 ? "subiu" : (variacao < 0 ? "caiu" : "igual");
        return new ComparativoDTO.Metrica(atual, anterior, variacao, tendencia);
    }

    private static double somaNoIntervalo(Map<LocalDate, Double> porDia, LocalDate ini, LocalDate fim) {
        double soma = 0;
        for (Map.Entry<LocalDate, Double> e : porDia.entrySet()) {
            if (!e.getKey().isBefore(ini) && !e.getKey().isAfter(fim)) {
                soma += e.getValue();
            }
        }
        return soma;
    }

    private static double mediaSono(Historico historico, LocalDate ini, LocalDate fim) {
        double soma = 0;
        int noites = 0;
        for (Historico.Sono s : historico.sono()) {
            if (s.dormir() == null || s.acordar() == null) {
                continue;
            }
            LocalDate dia = s.acordar().toLocalDate();
            if (!dia.isBefore(ini) && !dia.isAfter(fim)) {
                soma += HistoricoCalculos.horas(s);
                noites++;
            }
        }
        return noites == 0 ? 0 : soma / noites;
    }

    private static double arredondar1(double valor) {
        return Math.round(valor * 10) / 10.0;
    }
}
