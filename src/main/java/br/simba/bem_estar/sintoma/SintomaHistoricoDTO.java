package br.simba.bem_estar.sintoma;

import java.util.List;

/** Resposta de GET /api/sintomas: últimos 30 dias (mais recente primeiro) + resumo da semana. */
public record SintomaHistoricoDTO(
        List<RegistroSintomaResponseDTO> registros,
        SintomaResumoDTO semana) {
}
