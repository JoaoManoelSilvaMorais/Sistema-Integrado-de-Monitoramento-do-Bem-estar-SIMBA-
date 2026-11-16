package br.simba.bem_estar.conquista;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.historico.Historico;

class ConquistaCalculatorTest {

    private static final LocalDate BASE = LocalDate.of(2026, 11, 1);

    @Test
    void metaDeUsaMetaPersonalizadaApenasParaAguaMetaDia() {
        assertEquals(3200, ConquistaCalculator.metaDe(Conquista.AGUA_META_DIA, 3200));
        assertEquals(Conquista.AGUA_SEMANA.getMeta(), ConquistaCalculator.metaDe(Conquista.AGUA_SEMANA, 3200));
        assertEquals(Conquista.TREINO_10.getMeta(), ConquistaCalculator.metaDe(Conquista.TREINO_10, 3200));
    }

    @Test
    void historicoVazioRetornaZeroEmTodasConquistas() {
        Historico vazio = new Historico(List.of(), List.of(), List.of());
        Map<Conquista, Integer> resultado = ConquistaCalculator.calcular(
                vazio, new ConquistaCalculator.Rotinas(0, 0, 0), 0, 2000);

        assertEquals(Conquista.values().length, resultado.size());
        for (int valor : resultado.values()) {
            assertEquals(0, valor);
        }
    }

    @Test
    void calculaConquistasDeAguaComMetaPersonalizadaEIgnoraInvalidos() {
        List<Historico.Agua> aguas = new ArrayList<>();
        // 8 dias seguidos bebendo 2500 ml (em 2 registros por dia) + 1 registro extra de 30000 ml (para somar 50 L)
        for (int i = 0; i < 8; i++) {
            LocalDate dia = BASE.plusDays(i);
            aguas.add(new Historico.Agua(dia.atTime(9, 0), 1500));
            aguas.add(new Historico.Agua(dia.atTime(15, 0), 1000));
        }
        aguas.add(new Historico.Agua(BASE.plusDays(10).atTime(12, 0), 30000));
        aguas.add(new Historico.Agua(null, 5000));
        aguas.add(new Historico.Agua(BASE.atTime(20, 0), -100));

        Historico historico = new Historico(aguas, List.of(), List.of());
        Map<Conquista, Integer> resultado = ConquistaCalculator.calcular(
                historico, new ConquistaCalculator.Rotinas(0, 0, 0), 0, 2500);

        assertEquals(17, resultado.get(Conquista.AGUA_PRIMEIRO_GOLE));
        assertEquals(30000, resultado.get(Conquista.AGUA_META_DIA));
        assertEquals(8, resultado.get(Conquista.AGUA_SEMANA));
        assertEquals(9, resultado.get(Conquista.AGUA_10_DIAS));
        assertEquals(50, resultado.get(Conquista.AGUA_50L));
        assertEquals(50, resultado.get(Conquista.AGUA_200L));
    }

    @Test
    void calculaConquistasDeSonoTreinoRotinaStreakEDiaCompleto() {
        List<Historico.Agua> aguas = List.of(
                new Historico.Agua(BASE.atTime(10, 0), 500)
        );
        List<Historico.Sono> sonos = List.of(
                new Historico.Sono(BASE.minusDays(1).atTime(22, 0), BASE.atTime(6, 30), 5),  // 8.5h, nota 5 -> acorda em BASE
                new Historico.Sono(BASE.atTime(23, 0), BASE.plusDays(1).atTime(6, 0), 99),     // 7.0h, nota inválida
                new Historico.Sono(null, BASE.plusDays(2).atTime(7, 0), 4)                     // incompleto -> ignorado
        );
        List<Historico.Treino> treinos = List.of(
                new Historico.Treino("Corrida", 40, 400, BASE.atTime(18, 0)),
                new Historico.Treino("  corrida  ", 30, 300, BASE.plusDays(1).atTime(18, 0)), // mesma modalidade normalizada
                new Historico.Treino("Musculação", 50, 350, BASE.plusDays(2).atTime(18, 0)),
                new Historico.Treino("Ciclismo", 25, -50, BASE.plusDays(3).atTime(18, 0)),    // kcal negativa vira 0
                new Historico.Treino("   ", 10, 50, BASE.plusDays(4).atTime(18, 0)),          // modalidade em branco ignorada
                new Historico.Treino("Yoga", 30, 100, null)                                   // sem data -> ignorado
        );

        Historico historico = new Historico(aguas, sonos, treinos);
        ConquistaCalculator.Rotinas rotinas = new ConquistaCalculator.Rotinas(4, 2, 3);
        Map<Conquista, Integer> resultado = ConquistaCalculator.calcular(historico, rotinas, 15, 2000);

        assertEquals(2, resultado.get(Conquista.SONO_PRIMEIRA));
        assertEquals(8, resultado.get(Conquista.SONO_8H));
        assertEquals(5, resultado.get(Conquista.SONO_NOTA_5));
        assertEquals(2, resultado.get(Conquista.SONO_7_BOAS));

        assertEquals(5, resultado.get(Conquista.TREINO_PRIMEIRO));
        assertEquals(5, resultado.get(Conquista.TREINO_10));
        assertEquals(1100, resultado.get(Conquista.TREINO_KCAL));
        assertEquals(3, resultado.get(Conquista.TREINO_VARIADO));

        assertEquals(4, resultado.get(Conquista.ROTINA_PRIMEIRA));
        assertEquals(2, resultado.get(Conquista.ROTINA_LEMBRETE));
        assertEquals(3, resultado.get(Conquista.ROTINA_3_ATIVAS));

        assertEquals(15, resultado.get(Conquista.STREAK_3));
        assertEquals(15, resultado.get(Conquista.STREAK_30));

        // Apenas BASE tem água + sono (acordar) + treino no mesmo dia
        assertEquals(1, resultado.get(Conquista.DIA_COMPLETO));
    }
}
