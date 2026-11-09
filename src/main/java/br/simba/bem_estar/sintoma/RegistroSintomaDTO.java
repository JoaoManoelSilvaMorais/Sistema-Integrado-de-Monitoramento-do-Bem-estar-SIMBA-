package br.simba.bem_estar.sintoma;

import java.util.List;

/**
 * O que o front envia ao responder o questionário. Os valores de texto são os nomes
 * dos enums (ex.: dor = "LEVE", locaisDor = ["CABECA"], sintomas = ["CANSACO"]).
 * Nunca traz id de usuário: o dono é sempre o usuário autenticado.
 */
public record RegistroSintomaDTO(
        Integer energia,
        Integer humor,
        Integer estresse,
        String dor,
        List<String> locaisDor,
        List<String> sintomas,
        String observacao) {
}
