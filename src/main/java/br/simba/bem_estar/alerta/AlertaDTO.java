package br.simba.bem_estar.alerta;

/**
 * tipo       = métrica (sono, água ou treino).
 * titulo     = frase curta do alerta.
 * mensagem   = o que foi percebido nos registros, em linguagem simples.
 * orientacao = sugestão de procurar um profissional de saúde (RF17).
 */
public record AlertaDTO(TipoAlerta tipo, String titulo, String mensagem, String orientacao) {
}
