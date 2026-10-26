package br.simba.bem_estar.meta;

/** metaMl = a meta em vigor; personalizada = o usuário definiu; sugeridaMl = cálculo pelo peso. */
public record MetaAguaDTO(int metaMl, boolean personalizada, int sugeridaMl, double pesoKg) {
}
