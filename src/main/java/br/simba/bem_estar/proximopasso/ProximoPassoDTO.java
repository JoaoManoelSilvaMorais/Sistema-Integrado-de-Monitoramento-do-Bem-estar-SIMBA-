package br.simba.bem_estar.proximopasso;

/**
 * Uma única sugestão, a mais útil para o usuário agora.
 * tipo: "risco", "quase", "agua", "meta", "conquista" ou "ok". link pode ser nulo.
 */
public record ProximoPassoDTO(String tipo, String texto, String link, String icone) {
}
