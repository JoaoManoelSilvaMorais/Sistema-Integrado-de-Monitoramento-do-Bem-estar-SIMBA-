package br.simba.bem_estar.rotina;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public record RotinaResponseDTO(
        UUID id,
        String nome,
        String descricao,
        boolean ativa,
        List<RotinaLembreteResponseDTO> lembretes) {

    public static RotinaResponseDTO from(RotinaModel rotina) {
        List<RotinaLembreteResponseDTO> lembretes = rotina.getLembretes().stream()
                .map(RotinaLembreteResponseDTO::from)
                .sorted(Comparator.comparing(RotinaLembreteResponseDTO::hora,
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
        return new RotinaResponseDTO(
                rotina.getId(),
                rotina.getNome(),
                rotina.getDescricao(),
                rotina.isAtiva(),
                lembretes);
    }
}
