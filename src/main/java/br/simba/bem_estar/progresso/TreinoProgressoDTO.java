package br.simba.bem_estar.progresso;

import java.time.LocalDate;

public class TreinoProgressoDTO {

    private LocalDate data;
    private boolean treinou;
    private Integer quantidadeTreinos;

    public TreinoProgressoDTO(
            LocalDate data,
            boolean treinou,
            Integer quantidadeTreinos) {

        this.data = data;
        this.treinou = treinou;
        this.quantidadeTreinos = quantidadeTreinos;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isTreinou() {
        return treinou;
    }

    public Integer getQuantidadeTreinos() {
        return quantidadeTreinos;
    }
}