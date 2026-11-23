package br.simba.bem_estar.security;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Regra pura (sem Spring) que limita tentativas repetidas, como erros de senha no login.
 *
 * Cada chave (ex.: "login:joao|127.0.0.1") guarda os horários das últimas tentativas. Se houver
 * {@code maximo} tentativas dentro da {@code janela}, a chave fica bloqueada até a mais antiga
 * delas sair da janela. Fica em memória: reiniciar o app zera os contadores (suficiente aqui).
 */
public class LimiteTentativas {

    private final int maximo;
    private final Duration janela;
    private final Clock relogio;
    private final Map<String, Deque<Instant>> tentativas = new ConcurrentHashMap<>();

    public LimiteTentativas(int maximo, Duration janela, Clock relogio) {
        if (maximo < 1) throw new IllegalArgumentException("maximo deve ser 1 ou mais");
        if (janela == null || janela.isZero() || janela.isNegative()) throw new IllegalArgumentException("janela inválida");
        this.maximo = maximo;
        this.janela = janela;
        this.relogio = relogio == null ? Clock.systemUTC() : relogio;
    }

    /** Segundos que faltam para liberar a chave; 0 quando não está bloqueada. */
    public long segundosParaLiberar(String chave) {
        Deque<Instant> lista = tentativas.get(chave);
        if (lista == null) return 0;
        synchronized (lista) {
            Instant agora = relogio.instant();
            limparAntigas(lista, agora);
            if (lista.size() < maximo) return 0;
            Instant libera = lista.peekFirst().plus(janela);
            long segundos = Duration.between(agora, libera).getSeconds();
            return Math.max(1, segundos);
        }
    }

    public boolean bloqueada(String chave) {
        return segundosParaLiberar(chave) > 0;
    }

    /** Anota uma tentativa (um erro de senha, um cadastro novo...). */
    public void registrar(String chave) {
        Deque<Instant> lista = tentativas.computeIfAbsent(chave, k -> new ArrayDeque<>());
        synchronized (lista) {
            Instant agora = relogio.instant();
            limparAntigas(lista, agora);
            lista.addLast(agora);
        }
    }

    /** Esquece as tentativas da chave (ex.: depois de um login certo). */
    public void limpar(String chave) {
        tentativas.remove(chave);
    }

    private void limparAntigas(Deque<Instant> lista, Instant agora) {
        Instant limite = agora.minus(janela);
        while (!lista.isEmpty() && !lista.peekFirst().isAfter(limite)) {
            lista.pollFirst();
        }
    }
}
