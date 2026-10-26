package br.simba.bem_estar.meta;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoCalculos;

/**
 * Progresso de uma meta, sem dependência de banco ou Spring.
 *
 * Só contam os registros a partir do dia em que a meta foi criada.
 * atual  = situação de agora (nas metas "seguidos", a sequência que ainda está viva).
 * melhor = o melhor resultado desde o início; a meta é concluída quando melhor >= alvo.
 */
public final class MetaCalculator {

    public record Progresso(int atual, int melhor) { }

    private MetaCalculator() {
    }

    public static Progresso calcular(
            TipoMeta tipo, LocalDate inicio, LocalDate hoje, Historico historico, int metaAguaMl) {

        if (tipo == TipoMeta.TREINO_TOTAL) {
            int total = 0;
            for (Historico.Treino t : historico.treinos()) {
                if (t.dataHora() != null) {
                    LocalDate dia = t.dataHora().toLocalDate();
                    if (!dia.isBefore(inicio) && !dia.isAfter(hoje)) {
                        total++;
                    }
                }
            }
            return new Progresso(total, total);
        }

        Set<LocalDate> dias = switch (tipo) {
            case TREINO_SEGUIDOS -> HistoricoCalculos.diasTreino(historico.treinos());
            case AGUA_SEGUIDOS -> {
                Map<LocalDate, Double> porDia = HistoricoCalculos.aguaPorDia(historico.agua());
                yield HistoricoCalculos.diasComMeta(porDia, metaAguaMl);
            }
            case SONO_SEGUIDOS -> HistoricoCalculos.diasBoaNoite(historico.sono());
            default -> new HashSet<>();
        };

        Set<LocalDate> desdeInicio = HistoricoCalculos.doIntervalo(dias, inicio, hoje);
        return new Progresso(
                HistoricoCalculos.sequenciaAtual(desdeInicio, hoje),
                HistoricoCalculos.maiorSequencia(desdeInicio));
    }
}
