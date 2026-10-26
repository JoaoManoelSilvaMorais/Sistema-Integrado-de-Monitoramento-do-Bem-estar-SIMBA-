package br.simba.bem_estar.meta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MetaDTO(
        Long id,
        String tipo,
        String titulo,
        String icone,
        int alvo,
        int progressoAtual,
        int melhor,
        String unidade,
        boolean concluida,
        LocalDate dataInicio,
        LocalDateTime concluidaEm,
        boolean nova,
        int alvoSugerido) {
}
