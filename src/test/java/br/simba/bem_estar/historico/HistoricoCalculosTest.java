package br.simba.bem_estar.historico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class HistoricoCalculosTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 11, 10);

    @Test
    void aguaPorDiaSomaNoMesmoDiaEIgnoraInvalidos() {
        List<Historico.Agua> registros = List.of(
                new Historico.Agua(HOJE.atTime(8, 0), 300),
                new Historico.Agua(HOJE.atTime(14, 0), 450),
                new Historico.Agua(HOJE.minusDays(1).atTime(10, 0), 1000),
                new Historico.Agua(HOJE.atTime(16, 0), 0),
                new Historico.Agua(HOJE.atTime(18, 0), -200),
                new Historico.Agua(null, 500)
        );

        Map<LocalDate, Double> porDia = HistoricoCalculos.aguaPorDia(registros);

        assertEquals(2, porDia.size());
        assertEquals(750.0, porDia.get(HOJE));
        assertEquals(1000.0, porDia.get(HOJE.minusDays(1)));
    }

    @Test
    void diasComMetaConsideraLimiteExato() {
        Map<LocalDate, Double> aguaPorDia = Map.of(
                HOJE, 2000.0,
                HOJE.minusDays(1), 1999.9,
                HOJE.minusDays(2), 2500.0
        );

        Set<LocalDate> dias = HistoricoCalculos.diasComMeta(aguaPorDia, 2000);

        assertEquals(Set.of(HOJE, HOJE.minusDays(2)), dias);
    }

    @Test
    void horasDeSonoCalculaCorretamenteENuncaNegativo() {
        var oitoHoras = new Historico.Sono(
                HOJE.minusDays(1).atTime(23, 0),
                HOJE.atTime(7, 0),
                4);
        var seteHorasEMeia = new Historico.Sono(
                HOJE.minusDays(1).atTime(23, 30),
                HOJE.atTime(7, 0),
                5);
        var invertido = new Historico.Sono(
                HOJE.atTime(8, 0),
                HOJE.atTime(6, 0),
                3);
        var incompleto = new Historico.Sono(null, HOJE.atTime(7, 0), 3);

        assertEquals(8.0, HistoricoCalculos.horas(oitoHoras), 0.001);
        assertEquals(7.5, HistoricoCalculos.horas(seteHorasEMeia), 0.001);
        assertEquals(0.0, HistoricoCalculos.horas(invertido));
        assertEquals(0.0, HistoricoCalculos.horas(incompleto));
    }

    @Test
    void diasSonoEDiasBoaNoiteContamNoDiaDeAcordar() {
        List<Historico.Sono> registros = List.of(
                new Historico.Sono(HOJE.minusDays(2).atTime(23, 0), HOJE.minusDays(1).atTime(6, 0), 4), // 7h exatamente -> dia -1
                new Historico.Sono(HOJE.minusDays(1).atTime(23, 1), HOJE.atTime(6, 0), 3),              // 6h59 -> dia hoje, não é boa noite
                new Historico.Sono(HOJE.atTime(1, 0), null, 3)                                           // incompleto -> ignorado
        );

        assertEquals(Set.of(HOJE.minusDays(1), HOJE), HistoricoCalculos.diasSono(registros));
        assertEquals(Set.of(HOJE.minusDays(1)), HistoricoCalculos.diasBoaNoite(registros));
    }

    @Test
    void diasTreinoExtraiDatasUnicasEIgnoraNulos() {
        List<Historico.Treino> treinos = List.of(
                new Historico.Treino("Corrida", 30, 300, HOJE.atTime(7, 0)),
                new Historico.Treino("Musculação", 45, 250, HOJE.atTime(18, 0)),
                new Historico.Treino("Caminhada", 20, 100, HOJE.minusDays(2).atTime(8, 0)),
                new Historico.Treino("Yoga", 30, 90, null)
        );

        assertEquals(Set.of(HOJE, HOJE.minusDays(2)), HistoricoCalculos.diasTreino(treinos));
    }

    @Test
    void maiorSequenciaEncontraMaiorBlocoConsecutivo() {
        assertEquals(0, HistoricoCalculos.maiorSequencia(Set.of()));
        assertEquals(1, HistoricoCalculos.maiorSequencia(Set.of(HOJE)));

        Set<LocalDate> dias = Set.of(
                HOJE.minusDays(10), HOJE.minusDays(9), HOJE.minusDays(8), // 3 dias
                HOJE.minusDays(5), HOJE.minusDays(4),                    // 2 dias
                HOJE.minusDays(1), HOJE                                  // 2 dias
        );
        assertEquals(3, HistoricoCalculos.maiorSequencia(dias));
    }

    @Test
    void sequenciaAtualAceitaTerminandoHojeOuOntemEQuebraAntesDisso() {
        assertEquals(0, HistoricoCalculos.sequenciaAtual(Set.of(), HOJE));

        Set<LocalDate> ateHoje = Set.of(HOJE, HOJE.minusDays(1), HOJE.minusDays(2), HOJE.minusDays(4));
        assertEquals(3, HistoricoCalculos.sequenciaAtual(ateHoje, HOJE));

        Set<LocalDate> ateOntem = Set.of(HOJE.minusDays(1), HOJE.minusDays(2));
        assertEquals(2, HistoricoCalculos.sequenciaAtual(ateOntem, HOJE));

        Set<LocalDate> quebrada = Set.of(HOJE.minusDays(2), HOJE.minusDays(3));
        assertEquals(0, HistoricoCalculos.sequenciaAtual(quebrada, HOJE));
    }

    @Test
    void doIntervaloFiltraComBordasInclusivas() {
        LocalDate ini = HOJE.minusDays(5);
        LocalDate fim = HOJE.minusDays(1);
        Set<LocalDate> dias = Set.of(
                HOJE.minusDays(6),
                HOJE.minusDays(5),
                HOJE.minusDays(3),
                HOJE.minusDays(1),
                HOJE
        );

        Set<LocalDate> filtrados = HistoricoCalculos.doIntervalo(dias, ini, fim);

        assertEquals(Set.of(HOJE.minusDays(5), HOJE.minusDays(3), HOJE.minusDays(1)), filtrados);
        assertTrue(HistoricoCalculos.doIntervalo(Set.of(), ini, fim).isEmpty());
    }
}
