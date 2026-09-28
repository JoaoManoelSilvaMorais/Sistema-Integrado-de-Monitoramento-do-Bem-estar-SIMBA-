package br.simba.bem_estar.registroSono;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.simba.bem_estar.user.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private Integer notaSono;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    public RegistroSonoModel() {
    }

    public RegistroSonoModel(
            Long id,
            LocalDateTime horaDormir,
            LocalDateTime horaAcordar,
            Integer notaSono,
            UserModel usuario) {

        this.id = id;
        this.horaDormir = horaDormir;
        this.horaAcordar = horaAcordar;
        this.notaSono = notaSono;
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

    public Integer getNotaSono() {
        return notaSono;
    }

    public void setNotaSono(Integer notaSono) {
        this.notaSono = notaSono;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }
}