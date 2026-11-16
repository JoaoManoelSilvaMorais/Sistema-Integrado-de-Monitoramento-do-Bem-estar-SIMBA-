package br.simba.bem_estar.streak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class StreakCalculatorTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 11, 10);

    @Test
    void semRegistrosRetornaTudoZerado() {
        StreakDTO dto = StreakCalculator.calcular(Set.of(), HOJE);

        assertEquals(0, dto.atual());
        assertEquals(0, dto.maior());
        assertFalse(dto.ativoHoje());
        assertFalse(dto.emRisco());
        assertEquals(0, dto.diaRisco());
        assertFalse(dto.ultimaChance());
    }

    @Test
    void ignoraDatasFuturasENulas() {
        Set<LocalDate> dias = new HashSet<>();
        dias.add(null);
        dias.add(HOJE.plusDays(1));
        dias.add(HOJE.plusDays(5));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(0, dto.atual());
        assertEquals(0, dto.maior());
        assertFalse(dto.ativoHoje());
    }

    @Test
    void sequenciaContinuaAteHojeSemRisco() {
        Set<LocalDate> dias = Set.of(HOJE.minusDays(2), HOJE.minusDays(1), HOJE);

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(3, dto.atual());
        assertEquals(3, dto.maior());
        assertTrue(dto.ativoHoje());
        assertFalse(dto.emRisco());
        assertEquals(0, dto.diaRisco());
        assertFalse(dto.ultimaChance());
    }

    @Test
    void ativoOntemEHojeEmAbertoAindaNaoEstaEmRisco() {
        Set<LocalDate> dias = Set.of(HOJE.minusDays(3), HOJE.minusDays(2), HOJE.minusDays(1));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(3, dto.atual());
        assertFalse(dto.ativoHoje());
        assertFalse(dto.emRisco());
        assertEquals(0, dto.diaRisco());
        assertFalse(dto.ultimaChance());
    }

    @Test
    void umaFaltaEntraEmRiscoDia1() {
        // Registrou anteontem e antes; ontem faltou; hoje ainda em aberto
        Set<LocalDate> dias = Set.of(HOJE.minusDays(3), HOJE.minusDays(2));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(2, dto.atual());
        assertFalse(dto.ativoHoje());
        assertTrue(dto.emRisco());
        assertEquals(1, dto.diaRisco());
        assertFalse(dto.ultimaChance());
    }

    @Test
    void duasFaltasSeguidasEntraEmUltimaChanceDia2() {
        // Registrou há 3 dias; faltou -2 e -1
        Set<LocalDate> dias = Set.of(HOJE.minusDays(4), HOJE.minusDays(3));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(2, dto.atual());
        assertTrue(dto.emRisco());
        assertEquals(2, dto.diaRisco());
        assertTrue(dto.ultimaChance());
    }

    @Test
    void tresFaltasSeguidasQuebraOfensivaMasPreservaMaior() {
        // 4 dias seguidos (-7..-4), depois faltou -3, -2, -1
        Set<LocalDate> dias = Set.of(
                HOJE.minusDays(7), HOJE.minusDays(6), HOJE.minusDays(5), HOJE.minusDays(4));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(0, dto.atual());
        assertEquals(4, dto.maior());
        assertFalse(dto.emRisco());
        assertFalse(dto.ultimaChance());
    }

    @Test
    void toleranciaDeDuasFaltasNaSemanaEntraEmUltimaChanceNaSegundaFolga() {
        // Faltou em -5 e -2 (2 faltas dentro dos últimos 7 dias); ontem (-1) registrou!
        // Hoje ainda sem registro, mas já esgotou as 2 folgas da janela de 7 dias -> em risco e última chance!
        Set<LocalDate> dias = Set.of(
                HOJE.minusDays(6),
                HOJE.minusDays(4),
                HOJE.minusDays(3),
                HOJE.minusDays(1));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(4, dto.atual());
        assertFalse(dto.ativoHoje());
        assertTrue(dto.emRisco());
        assertTrue(dto.ultimaChance());
        assertEquals(2, dto.diaRisco());
    }

    @Test
    void terceiraFaltaNaMesmaSemanaQuebraOfensiva() {
        // Faltas em -5, -3 e -1 (3 faltas dentro de uma janela de 7 dias) -> quebra em -1
        Set<LocalDate> dias = Set.of(
                HOJE.minusDays(6),
                HOJE.minusDays(4),
                HOJE.minusDays(2));

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(0, dto.atual());
        assertEquals(3, dto.maior());
    }

    @Test
    void faltaForaDaJanelaDeSeteDiasNaoImpedeNovaFolga() {
        // Falta antiga em -10 já saiu da janela quando falta de novo em -2
        Set<LocalDate> dias = Set.of(
                HOJE.minusDays(12), HOJE.minusDays(11),
                HOJE.minusDays(9), HOJE.minusDays(8), HOJE.minusDays(7),
                HOJE.minusDays(6), HOJE.minusDays(5), HOJE.minusDays(4), HOJE.minusDays(3),
                HOJE.minusDays(1), HOJE);

        StreakDTO dto = StreakCalculator.calcular(dias, HOJE);

        assertEquals(11, dto.atual());
        assertEquals(11, dto.maior());
        assertTrue(dto.ativoHoje());
        assertFalse(dto.emRisco());
    }

    @Test
    void comRegistrosDeHojePreencheFlagsSemPerderDados() {
        StreakDTO base = StreakCalculator.calcular(Set.of(HOJE), HOJE);
        StreakDTO completo = base.comRegistrosDeHoje(true, false, true);

        assertEquals(1, completo.atual());
        assertTrue(completo.aguaHoje());
        assertFalse(completo.sonoHoje());
        assertTrue(completo.treinoHoje());
    }
}
