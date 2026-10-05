package br.simba.bem_estar.progresso;

import java.time.LocalDate;

public class AguaProgressoDTO {

    private LocalDate data;
    private Double quantidadeMl;

    public AguaProgressoDTO(
            LocalDate data,
            Double quantidadeMl) {

        this.data = data;
        this.quantidadeMl = quantidadeMl;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getQuantidadeMl() {
        return quantidadeMl;
    }
}