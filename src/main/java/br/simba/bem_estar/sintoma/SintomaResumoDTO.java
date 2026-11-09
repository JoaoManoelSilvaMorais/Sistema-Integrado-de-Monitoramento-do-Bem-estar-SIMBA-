package br.simba.bem_estar.sintoma;

/**
 * Resumo dos últimos 7 dias (hoje incluído). Médias vêm nulas quando não há resposta na semana;
 * sintomaMaisFrequente vem nulo quando só houve "nenhum".
 */
public record SintomaResumoDTO(
        int diasRespondidos,
        Double mediaEnergia,
        Double mediaHumor,
        Double mediaEstresse,
        int diasComDor,
        String sintomaMaisFrequente,
        int vezesSintomaMaisFrequente,
        String mensagem) {
}
