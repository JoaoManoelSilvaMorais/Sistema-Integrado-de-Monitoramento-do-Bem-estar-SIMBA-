package br.simba.bem_estar.rotina;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public record RotinaLembreteResponseDTO(
        UUID id,
        String titulo,
        String mensagem,
        LocalTime hora,
        List<Integer> diasSemana) {

    public static RotinaLembreteResponseDTO from(RotinaLembreteModel lembrete) {
        List<Integer> dias = lembrete.getDiasSemana() == null || lembrete.getDiasSemana().isBlank()
                ? List.of()
                : Arrays.stream(lembrete.getDiasSemana().split(","))
                        .map(String::trim)
                        .map(Integer::valueOf)
                        .toList();
        return new RotinaLembreteResponseDTO(
                lembrete.getId(),
                lembrete.getTitulo(),
                lembrete.getMensagem(),
                lembrete.getHora(),
                dias);
    }
}
