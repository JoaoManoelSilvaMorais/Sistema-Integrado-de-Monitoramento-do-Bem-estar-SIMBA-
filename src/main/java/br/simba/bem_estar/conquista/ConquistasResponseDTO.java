package br.simba.bem_estar.conquista;

import java.util.List;

public record ConquistasResponseDTO(
        int desbloqueadas,
        int total,
        List<ConquistaDTO> conquistas) {
}
