package br.simba.bem_estar.conquista;

import java.time.LocalDateTime;

public record ConquistaDTO(
        String codigo,
        String nome,
        String descricao,
        String categoria,
        String icone,
        boolean desbloqueada,
        LocalDateTime dataDesbloqueio,
        int progressoAtual,
        int progressoMeta,
        String unidade,
        boolean nova) {
}
