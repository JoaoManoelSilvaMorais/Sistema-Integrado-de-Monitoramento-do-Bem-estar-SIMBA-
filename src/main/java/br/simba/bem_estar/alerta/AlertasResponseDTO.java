package br.simba.bem_estar.alerta;

import java.util.List;

/** aviso = texto fixo de que o SIMBA é preventivo e não substitui um profissional de saúde. */
public record AlertasResponseDTO(List<AlertaDTO> alertas, String aviso) {
}
