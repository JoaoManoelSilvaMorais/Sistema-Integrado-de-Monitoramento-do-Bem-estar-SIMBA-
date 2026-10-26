package br.simba.bem_estar.rotina;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_rotina_lembrete")
public class RotinaLembreteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String mensagem;
    private LocalTime hora;

    // Dias da semana no padrão ISO (1 = segunda ... 7 = domingo), separados por vírgula. Ex.: "1,3,5"
    private String diasSemana;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rotina_id", nullable = false)
    private RotinaModel rotina;

    public RotinaLembreteModel() {
    }

    public UUID getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getDiasSemana() { return diasSemana; }
    public void setDiasSemana(String diasSemana) { this.diasSemana = diasSemana; }
    public RotinaModel getRotina() { return rotina; }
    public void setRotina(RotinaModel rotina) { this.rotina = rotina; }
}
