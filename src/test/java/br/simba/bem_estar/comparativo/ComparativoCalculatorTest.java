package br.simba.bem_estar.comparativo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.historico.Historico;

class ComparativoCalculatorTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 11, 14);

    @Test
    void historicoVazioRetornaTendenciaSemEVariacaoNula() {
        ComparativoDTO dto = ComparativoCalculator.calcular(
                new Historico(List.of(), List.of(), List.of()), HOJE);

        assertEquals("sem", dto.agua().tendencia());
        assertNull(dto.agua().variacaoPct());
        assertEquals("sem", dto.sono().tendencia());
        assertEquals("sem", dto.treinos().tendencia());
        assertEquals("sem", dto.diasAtivos().tendencia());
    }

    @Test
    void apenasSemanaAtualRetornaTendenciaNovoEVariacaoNula() {
        Historico historico = new Historico(
                List.of(new Historico.Agua(HOJE.atTime(10, 0), 1400)), // 1400 / 7 = 200 ml/dia
                List.of(new Historico.Sono(HOJE.minusDays(1).atTime(23, 0), HOJE.atTime(7, 0), 4)),
                List.of(new Historico.Treino("Corrida", 30, 300, HOJE.atTime(18, 0)))
        );

        ComparativoDTO dto = ComparativoCalculator.calcular(historico, HOJE);

        assertEquals(200.0, dto.agua().atual());
        assertEquals(0.0, dto.agua().anterior());
        assertEquals("novo", dto.agua().tendencia());
        assertNull(dto.agua().variacaoPct());

        assertEquals(8.0, dto.sono().atual());
        assertEquals("novo", dto.sono().tendencia());

        assertEquals(1.0, dto.treinos().atual());
        assertEquals("novo", dto.treinos().tendencia());

        assertEquals(1.0, dto.diasAtivos().atual());
        assertEquals("novo", dto.diasAtivos().tendencia());
    }

    @Test
    void comparaSeteDiasAtuaisContraSeteAnterioresEIgnoraForaDaJanela() {
        // Atual: HOJE-6 (8) .. HOJE (14)
        // Anterior: HOJE-13 (1) .. HOJE-7 (7)
        // Ignorados: HOJE-14 (31/10) e HOJE+1 (15/11)
        Historico historico = new Historico(
                List.of(
                        // Atual: 7000 ml total -> média 1000 ml/dia
                        new Historico.Agua(HOJE.minusDays(6).atTime(10, 0), 3500),
                        new Historico.Agua(HOJE.atTime(10, 0), 3500),
                        // Anterior: 3500 ml total -> média 500 ml/dia (+100%)
                        new Historico.Agua(HOJE.minusDays(13).atTime(10, 0), 3500),
                        // Fora da janela:
                        new Historico.Agua(HOJE.minusDays(14).atTime(10, 0), 9999)
                ),
                List.of(
                        // Atual: 6.0h
                        new Historico.Sono(HOJE.minusDays(1).atTime(23, 0), HOJE.atTime(5, 0), 3),
                        // Anterior: 8.0h (-25%)
                        new Historico.Sono(HOJE.minusDays(8).atTime(22, 0), HOJE.minusDays(7).atTime(6, 0), 5),
                        // Incompleto ignorado:
                        new Historico.Sono(null, HOJE.atTime(7, 0), 4)
                ),
                List.of(
                        // Atual: 2 treinos no mesmo dia + 1 em outro dia = 2 dias
                        new Historico.Treino("Corrida", 30, 300, HOJE.atTime(8, 0)),
                        new Historico.Treino("Alongamento", 15, 50, HOJE.atTime(19, 0)),
                        new Historico.Treino("Ciclismo", 40, 350, HOJE.minusDays(2).atTime(17, 0)),
                        // Anterior: 2 dias
                        new Historico.Treino("Corrida", 30, 300, HOJE.minusDays(7).atTime(8, 0)),
                        new Historico.Treino("Musculação", 45, 250, HOJE.minusDays(10).atTime(18, 0)),
                        // Fora da janela:
                        new Historico.Treino("Natação", 40, 400, HOJE.minusDays(14).atTime(9, 0))
                )
        );

        ComparativoDTO dto = ComparativoCalculator.calcular(historico, HOJE);

        assertEquals(1000.0, dto.agua().atual());
        assertEquals(500.0, dto.agua().anterior());
        assertEquals(100, dto.agua().variacaoPct());
        assertEquals("subiu", dto.agua().tendencia());

        assertEquals(6.0, dto.sono().atual());
        assertEquals(8.0, dto.sono().anterior());
        assertEquals(-25, dto.sono().variacaoPct());
        assertEquals("caiu", dto.sono().tendencia());

        assertEquals(2.0, dto.treinos().atual());
        assertEquals(2.0, dto.treinos().anterior());
        assertEquals(0, dto.treinos().variacaoPct());
        assertEquals("igual", dto.treinos().tendencia());

        // Dias ativos atual: HOJE, HOJE-2, HOJE-6 -> 3; anterior: HOJE-7, HOJE-10, HOJE-13 -> 3
        assertEquals(3.0, dto.diasAtivos().atual());
        assertEquals(3.0, dto.diasAtivos().anterior());
        assertEquals("igual", dto.diasAtivos().tendencia());
    }
}
