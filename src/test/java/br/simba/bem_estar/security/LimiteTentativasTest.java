package br.simba.bem_estar.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LimiteTentativasTest {

    /** Relógio que o teste avança na mão. */
    static class RelogioManual extends Clock {
        Instant agora = Instant.parse("2026-11-23T12:00:00Z");
        @Override public ZoneOffset getZone() { return ZoneOffset.UTC; }
        @Override public Clock withZone(java.time.ZoneId zone) { return this; }
        @Override public Instant instant() { return agora; }
        void avancar(Duration d) { agora = agora.plus(d); }
    }

    private RelogioManual relogio;
    private LimiteTentativas limite;

    @BeforeEach
    void criar() {
        relogio = new RelogioManual();
        limite = new LimiteTentativas(5, Duration.ofMinutes(15), relogio);
    }

    @Test
    void chaveSemTentativasNaoFicaBloqueada() {
        assertFalse(limite.bloqueada("login:joao"));
        assertEquals(0, limite.segundosParaLiberar("login:joao"));
    }

    @Test
    void quatroErrosAindaDeixamTentar() {
        for (int i = 0; i < 4; i++) limite.registrar("login:joao");
        assertFalse(limite.bloqueada("login:joao"));
    }

    @Test
    void cincoErrosBloqueiamAteOPrimeiroSairDaJanela() {
        for (int i = 0; i < 5; i++) {
            limite.registrar("login:joao");
            relogio.avancar(Duration.ofMinutes(1));
        }
        // primeiro erro foi às 12:00; agora são 12:05 → libera às 12:15 (10 minutos)
        assertTrue(limite.bloqueada("login:joao"));
        assertEquals(600, limite.segundosParaLiberar("login:joao"));

        relogio.avancar(Duration.ofMinutes(10));
        assertFalse(limite.bloqueada("login:joao"));
    }

    @Test
    void chavesDiferentesNaoSeMisturam() {
        for (int i = 0; i < 5; i++) limite.registrar("login:joao");
        assertTrue(limite.bloqueada("login:joao"));
        assertFalse(limite.bloqueada("login:maria"));
    }

    @Test
    void limparEsqueceAsTentativas() {
        for (int i = 0; i < 5; i++) limite.registrar("login:joao");
        limite.limpar("login:joao");
        assertFalse(limite.bloqueada("login:joao"));
    }

    @Test
    void errosAntigosForaDaJanelaNaoContam() {
        for (int i = 0; i < 4; i++) limite.registrar("login:joao");
        relogio.avancar(Duration.ofMinutes(16));
        limite.registrar("login:joao");
        assertFalse(limite.bloqueada("login:joao"));
    }

    @Test
    void parametrosInvalidosSaoRecusados() {
        assertThrows(IllegalArgumentException.class, () -> new LimiteTentativas(0, Duration.ofMinutes(1), relogio));
        assertThrows(IllegalArgumentException.class, () -> new LimiteTentativas(5, Duration.ZERO, relogio));
    }

    @Test
    void chaveJwtVaziaCurtaOuAntigaImpedeOAppDeIniciar() {
        assertThrows(IllegalStateException.class, () -> JWTService.validarChave(""));
        assertThrows(IllegalStateException.class, () -> JWTService.validarChave("curta"));
        assertThrows(IllegalStateException.class,
                () -> JWTService.validarChave("simba-development-secret-key-change-in-production-2026"));
        JWTService.validarChave("uma-chave-aleatoria-com-mais-de-32-caracteres-123");
    }
}
