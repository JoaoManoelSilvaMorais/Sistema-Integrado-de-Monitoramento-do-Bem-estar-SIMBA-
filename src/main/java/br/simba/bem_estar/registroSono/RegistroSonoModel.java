package br.simba.bem_estar.registroSono;

import java.time.LocalDateTime;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity(name = "registro_sono")
public class RegistroSonoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horaDormir;
    private LocalDateTime horaAcordar;
    private Integer tempoRemMinutos;
    private Integer tempoProfundoMinutos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    // Versao antiga (incorreta): mappedBy nao existe em @ManyToOne.
    // @ManyToOne(mappedBy = "registroSono")
    // private UserModel usuario;

    public RegistroSonoModel(){

    }

    public RegistroSonoModel(Long id, LocalDateTime horaDormir, LocalDateTime horaAcordar, Integer tempoRemMinutos,
            Integer tempoProfundoMinutos, UserModel usuario) {
        this.id = id;
        this.horaDormir = horaDormir;
        this.horaAcordar = horaAcordar;
        this.tempoRemMinutos = tempoRemMinutos;
        this.tempoProfundoMinutos = tempoProfundoMinutos;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraDormir() {
        return horaDormir;
    }

    public void setHoraDormir(LocalDateTime horaDormir) {
        this.horaDormir = horaDormir;
    }

    public LocalDateTime getHoraAcordar() {
        return horaAcordar;
    }

    public void setHoraAcordar(LocalDateTime horaAcordar) {
        this.horaAcordar = horaAcordar;
    }

    public Integer getTempoRemMinutos() {
        return tempoRemMinutos;
    }

    public void setTempoRemMinutos(Integer tempoRemMinutos) {
        this.tempoRemMinutos = tempoRemMinutos;
    }

    public Integer getTempoProfundoMinutos() {
        return tempoProfundoMinutos;
    }

    public void setTempoProfundoMinutos(Integer tempoProfundoMinutos) {
        this.tempoProfundoMinutos = tempoProfundoMinutos;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    
}
