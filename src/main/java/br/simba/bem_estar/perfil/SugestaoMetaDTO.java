package br.simba.bem_estar.perfil;

/**
 * Uma sugestão de meta feita a partir do peso e da altura.
 * tipo: PESO, AGUA ou ATIVIDADE · icone: classe do Font Awesome.
 *
 * metaTipo / metaAlvo / metaTitulo: a meta do app (TipoMeta, aba Conquistas) que o botão
 * "Criar meta" grava via POST /api/metas. Nulos quando não existe meta equivalente (ex.: peso).
 */
public record SugestaoMetaDTO(
        String tipo,
        String icone,
        String titulo,
        String descricao,
        String metaTipo,
        Integer metaAlvo,
        String metaTitulo) {
}
