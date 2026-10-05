package br.simba.bem_estar.progresso;

import java.time.LocalDate;

public class SonoProgressoDTO {

    private LocalDate data;
    private Double horasSono;
    private Double notaSono;

    public SonoProgressoDTO(
            LocalDate data,
            Double horasSono,
            Double notaSono) {

        this.data = data;
        this.horasSono = horasSono;
        this.notaSono = notaSono;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getHorasSono() {
        return horasSono;
    }

    public Double getNotaSono() {
        return notaSono;
    }
}