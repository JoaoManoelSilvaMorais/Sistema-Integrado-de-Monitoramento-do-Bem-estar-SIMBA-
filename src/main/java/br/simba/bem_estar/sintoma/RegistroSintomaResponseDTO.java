package br.simba.bem_estar.sintoma;

import java.time.LocalDate;
import java.util.List;

/** Um dia do histórico. Os códigos são os nomes dos enums; o front traduz para o texto. */
public record RegistroSintomaResponseDTO(
        Long id,
        LocalDate data,
        int energia,
        int humor,
        int estresse,
        String dor,
        List<String> locaisDor,
        List<String> sintomas,
        String observacao) {
}
