package br.simba.bem_estar.rotina;

import java.util.UUID;

public record RotinaResponseDTO(
        UUID id,
        String nome,
        String descricao,
        boolean ativa) {

    public static RotinaResponseDTO from(RotinaModel rotina) {
        return new RotinaResponseDTO(
                rotina.getId(),
                rotina.getNome(),
                rotina.getDescricao(),
                rotina.isAtiva());
    }
}
