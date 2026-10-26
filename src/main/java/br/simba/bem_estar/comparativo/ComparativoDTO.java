package br.simba.bem_estar.comparativo;

/**
 * Últimos 7 dias comparados com os 7 dias anteriores.
 * tendencia: "subiu", "caiu", "igual", "novo" (antes não havia nada) ou "sem" (nada nos dois períodos).
 * variacaoPct é nulo quando o período anterior está zerado.
 */
public record ComparativoDTO(Metrica agua, Metrica sono, Metrica treinos, Metrica diasAtivos) {

    public record Metrica(double atual, double anterior, Integer variacaoPct, String tendencia) { }
}
