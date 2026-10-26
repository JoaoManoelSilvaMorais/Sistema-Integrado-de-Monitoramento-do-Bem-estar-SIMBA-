package br.simba.bem_estar.streak;

/**
 * atual        = dias de ofensiva (dias com registro dentro da sequência).
 * maior        = maior ofensiva já alcançada.
 * ativoHoje    = já registrou algo hoje.
 * emRisco      = a pessoa faltou e a ofensiva ainda pode ser salva (dura até 2 dias).
 * diaRisco     = 1 ou 2 (2 = última chance); 0 quando não está em risco.
 * ultimaChance = se hoje passar sem registro, a ofensiva acaba.
 * aguaHoje/sonoHoje/treinoHoje = o que já foi registrado hoje.
 */
public record StreakDTO(
        int atual,
        int maior,
        boolean ativoHoje,
        boolean emRisco,
        int diaRisco,
        boolean ultimaChance,
        boolean aguaHoje,
        boolean sonoHoje,
        boolean treinoHoje) {

    public StreakDTO comRegistrosDeHoje(boolean agua, boolean sono, boolean treino) {
        return new StreakDTO(atual, maior, ativoHoje, emRisco, diaRisco, ultimaChance, agua, sono, treino);
    }
}
