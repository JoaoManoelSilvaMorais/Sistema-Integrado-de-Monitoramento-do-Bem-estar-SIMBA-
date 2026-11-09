package br.simba.bem_estar.perfil;

/**
 * Peso (kg) e altura (m) enviados pela tela de perfil. Nulo = em branco.
 * Nunca traz id: o perfil é sempre o do usuário autenticado.
 */
public record MedidasDTO(Double peso, Double altura) {
}
