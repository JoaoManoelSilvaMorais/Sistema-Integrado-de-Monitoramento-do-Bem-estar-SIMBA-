package br.simba.bem_estar.conquista;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "conquistas",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_conquista_usuario_codigo",
            columnNames = {"username", "codigo"}
        )
    }
)
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 250)
    private String descricao;

    @Column(nullable = false, length = 60)
    private String icone;

    @Column(nullable = false, length = 150)
    private String username;

    @Column(nullable = false)
    private boolean desbloqueada = false;

    private LocalDateTime dataDesbloqueio;

    public Conquista() {
    }

    public Conquista(
            String codigo,
            String titulo,
            String descricao,
            String icone,
            String username) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.icone = icone;
        this.username = username;
    }

    public void desbloquear() {
        if (!this.desbloqueada) {
            this.desbloqueada = true;
            this.dataDesbloqueio = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIcone() {
        return icone;
    }

    public String getUsername() {
        return username;
    }

    public boolean isDesbloqueada() {
        return desbloqueada;
    }

    public LocalDateTime getDataDesbloqueio() {
        return dataDesbloqueio;
    }
}