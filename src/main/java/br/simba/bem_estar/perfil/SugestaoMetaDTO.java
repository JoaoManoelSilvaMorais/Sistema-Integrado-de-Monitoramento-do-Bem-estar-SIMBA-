package br.simba.bem_estar.perfil;

/**
 * Uma sugestão de meta feita a partir do peso e da altura.
 * tipo: PESO, AGUA ou ATIVIDADE · icone: classe do Font Awesome.
 */
public record SugestaoMetaDTO(
        String tipo,
        String icone,
        String titulo,
        String descricao) {
}
