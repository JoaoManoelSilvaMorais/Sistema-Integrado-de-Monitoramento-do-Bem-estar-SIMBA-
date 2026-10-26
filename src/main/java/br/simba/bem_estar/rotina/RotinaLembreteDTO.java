package br.simba.bem_estar.rotina;

import java.time.LocalTime;
import java.util.List;

public record RotinaLembreteDTO(
        String titulo,
        String mensagem,
        LocalTime hora,
        List<Integer> diasSemana) {
}
