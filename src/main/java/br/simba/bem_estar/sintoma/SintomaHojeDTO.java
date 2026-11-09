package br.simba.bem_estar.sintoma;

import java.time.LocalDate;

/** Diz se o questionário de hoje já foi respondido (registro vem nulo se não foi). */
public record SintomaHojeDTO(
        boolean respondido,
        LocalDate data,
        RegistroSintomaResponseDTO registro) {
}
