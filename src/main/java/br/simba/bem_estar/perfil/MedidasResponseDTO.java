package br.simba.bem_estar.perfil;

import java.util.List;

/** Medidas do usuário. Campos nulos = ainda não informados. */
public record MedidasResponseDTO(
        Double peso,
        Double altura,
        Double imc,
        String classificacaoImc,
        List<SugestaoMetaDTO> sugestoes) {

    public static MedidasResponseDTO de(Double peso, Double altura) {
        Double imc = MedidasCalculator.imc(peso, altura);
        return new MedidasResponseDTO(peso, altura, imc, MedidasCalculator.classificar(imc),
                SugestoesCalculator.sugerir(peso, altura));
    }
}
