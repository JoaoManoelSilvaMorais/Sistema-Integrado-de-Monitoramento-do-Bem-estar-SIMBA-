package br.simba.bem_estar.conquista;

import java.time.LocalDateTime;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/** Conquista já desbloqueada por um usuário (guarda o código do catálogo e a data). */
@Entity
@Table(name = "tb_conquista_usuario",
        uniqueConstraints = @UniqueConstraint(columnNames = { "usuario_id", "codigo" }))
public class ConquistaUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private LocalDateTime dataDesbloqueio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    public ConquistaUsuarioModel() {
    }

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public LocalDateTime getDataDesbloqueio() { return dataDesbloqueio; }
    public void setDataDesbloqueio(LocalDateTime dataDesbloqueio) { this.dataDesbloqueio = dataDesbloqueio; }
    public UserModel getUsuario() { return usuario; }
    public void setUsuario(UserModel usuario) { this.usuario = usuario; }
}
