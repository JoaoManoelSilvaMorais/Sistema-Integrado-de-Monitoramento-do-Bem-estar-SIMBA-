package br.simba.bem_estar.historico;

import java.time.LocalDateTime;
import java.util.List;

/** Registros do usuário já convertidos para tipos simples (fáceis de testar). */
public record Historico(List<Agua> agua, List<Sono> sono, List<Treino> treinos) {

    public record Agua(LocalDateTime dataHora, double ml) { }

    public record Sono(LocalDateTime dormir, LocalDateTime acordar, Integer nota) { }

    public record Treino(String modalidade, int minutos, double kcal, LocalDateTime dataHora) { }
}
