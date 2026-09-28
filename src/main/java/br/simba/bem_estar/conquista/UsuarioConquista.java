package br.simba.bem_estar.conquista;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_conquista")
public class UsuarioConquista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private int progressoAtual;

    @Column(nullable = false)
    private boolean concluida;

    private LocalDateTime dataConclusao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conquista_id", nullable = false)
    private Conquista conquista;

    public UsuarioConquista() {
    }

    public UsuarioConquista(int progressoAtual, boolean concluida, LocalDateTime dataConclusao) {
        this.progressoAtual = progressoAtual;
        this.concluida = concluida;
        this.dataConclusao = dataConclusao;
    }

    public UUID getId() {
        return id;
    }

    public int getProgressoAtual() {
        return progressoAtual;
    }

    public void setProgressoAtual(int progressoAtual) {
        this.progressoAtual = progressoAtual;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
        if (concluida && this.dataConclusao == null) {
            this.dataConclusao = LocalDateTime.now();
        }
        if (!concluida) {
            this.dataConclusao = null;
        }
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public Conquista getConquista() {
        return conquista;
    }

    public void setConquista(Conquista conquista) {
        this.conquista = conquista;
    }
}
