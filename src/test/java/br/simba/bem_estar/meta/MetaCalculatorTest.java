package br.simba.bem_estar.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.historico.Historico;

class MetaCalculatorTest {

    private static final LocalDate INICIO = LocalDate.of(2026, 11, 1);
    private static final LocalDate HOJE = LocalDate.of(2026, 11, 10);

    @Test
    void treinoTotalContaApenasEntreInicioEHoje() {
        Historico historico = new Historico(
                List.of(),
                List.of(),
                List.of(
                        new Historico.Treino("Corrida", 30, 200, INICIO.minusDays(1).atTime(8, 0)), // antes -> fora
                        new Historico.Treino("Corrida", 30, 200, INICIO.atTime(8, 0)),              // dentro
                        new Historico.Treino("Musculação", 45, 250, INICIO.atTime(18, 0)),          // dentro (mesmo dia)
                        new Historico.Treino("Ciclismo", 40, 300, HOJE.atTime(9, 0)),               // dentro
                        new Historico.Treino("Natação", 30, 250, HOJE.plusDays(1).atTime(9, 0)),    // futuro -> fora
                        new Historico.Treino("Yoga", 30, 100, null)                                 // nulo -> fora
                )
        );

        MetaCalculator.Progresso p = MetaCalculator.calcular(TipoMeta.TREINO_TOTAL, INICIO, HOJE, historico, 2000);

        assertEquals(3, p.atual());
        assertEquals(3, p.melhor());
    }

    @Test
    void treinoSeguidosDiferenciaSequenciaAtualDaMelhor() {
        Historico historico = new Historico(
                List.of(),
                List.of(),
                List.of(
                        new Historico.Treino("Corrida", 30, 200, INICIO.minusDays(1).atTime(8, 0)), // ignorado
                        new Historico.Treino("Corrida", 30, 200, INICIO.atTime(8, 0)),
                        new Historico.Treino("Corrida", 30, 200, INICIO.plusDays(1).atTime(8, 0)),
                        new Historico.Treino("Corrida", 30, 200, INICIO.plusDays(2).atTime(8, 0)),  // bloco de 3
                        new Historico.Treino("Corrida", 30, 200, HOJE.minusDays(1).atTime(8, 0)),   // sequência viva de 1 (ontem)
                        new Historico.Treino("Corrida", 30, 200, HOJE.plusDays(1).atTime(8, 0))     // futuro -> ignorado
                )
        );

        MetaCalculator.Progresso p = MetaCalculator.calcular(TipoMeta.TREINO_SEGUIDOS, INICIO, HOJE, historico, 2000);

        assertEquals(1, p.atual());
        assertEquals(3, p.melhor());
    }

    @Test
    void aguaSeguidosUsaMetaPersonalizada() {
        Historico historico = new Historico(
                List.of(
                        new Historico.Agua(HOJE.minusDays(2).atTime(10, 0), 2500),
                        new Historico.Agua(HOJE.minusDays(1).atTime(10, 0), 1500),
                        new Historico.Agua(HOJE.minusDays(1).atTime(16, 0), 1000),
                        new Historico.Agua(HOJE.atTime(9, 0), 2000) // abaixo de 2500
                ),
                List.of(),
                List.of()
        );

        MetaCalculator.Progresso p = MetaCalculator.calcular(TipoMeta.AGUA_SEGUIDOS, INICIO, HOJE, historico, 2500);

        assertEquals(2, p.atual()); // terminou ontem com 2 dias seguidos
        assertEquals(2, p.melhor());
    }

    @Test
    void sonoSeguidosContaApenasNoitesComPeloMenosSeteHoras() {
        Historico historico = new Historico(
                List.of(),
                List.of(
                        new Historico.Sono(HOJE.minusDays(3).atTime(22, 0), HOJE.minusDays(2).atTime(6, 0), 4), // 8h
                        new Historico.Sono(HOJE.minusDays(2).atTime(23, 0), HOJE.minusDays(1).atTime(6, 0), 4), // 7h
                        new Historico.Sono(HOJE.minusDays(1).atTime(23, 30), HOJE.atTime(6, 0), 3)              // 6.5h (não conta)
                ),
                List.of()
        );

        MetaCalculator.Progresso p = MetaCalculator.calcular(TipoMeta.SONO_SEGUIDOS, INICIO, HOJE, historico, 2000);

        assertEquals(2, p.atual());
        assertEquals(2, p.melhor());
    }
}
