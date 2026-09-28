package br.simba.bem_estar.registroExercicio;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity (name = "tb_registroExercicio")
public class RegistroExercicioModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modalidade;
    private Integer duracaominutos;
    private float gastoCaloricoExtimado;
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private UserModel usuario;

    public RegistroExercicioModel(){

    }

    public RegistroExercicioModel(Long id, String modalidade, Integer duracaominutos, float gastoCaloricoExtimado,
            LocalDateTime dataHora, UserModel usuario) {
        this.id = id;
        this.modalidade = modalidade;
        this.duracaominutos = duracaominutos;
        this.gastoCaloricoExtimado = gastoCaloricoExtimado;
        this.dataHora = dataHora;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Integer getDuracaominutos() {
        return duracaominutos;
    }

    public void setDuracaominutos(Integer duracaominutos) {
        this.duracaominutos = duracaominutos;
    }

    public float getGastoCaloricoExtimado() {
        return gastoCaloricoExtimado;
    }

    public void setGastoCaloricoExtimado(float gastoCaloricoExtimado) {
        this.gastoCaloricoExtimado = gastoCaloricoExtimado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }


}
