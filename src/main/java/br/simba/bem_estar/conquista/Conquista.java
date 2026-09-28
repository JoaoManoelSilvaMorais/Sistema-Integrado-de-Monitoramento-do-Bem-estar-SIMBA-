package br.simba.bem_estar.conquista;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "conquistas")
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 250)
    private String descricao;

    @Column(nullable = false)
    private int metaNecessaria;

    @OneToMany(
        mappedBy = "conquista",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<UsuarioConquista> usuariosConquistas = new ArrayList<>();

    public Conquista() {
    }

    public Conquista(String nome, String descricao, int metaNecessaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.metaNecessaria = metaNecessaria;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getMetaNecessaria() {
        return metaNecessaria;
    }

    public void setMetaNecessaria(int metaNecessaria) {
        this.metaNecessaria = metaNecessaria;
    }

    public List<UsuarioConquista> getUsuariosConquistas() {
        return usuariosConquistas;
    }

    public void setUsuariosConquistas(List<UsuarioConquista> usuariosConquistas) {
        this.usuariosConquistas = usuariosConquistas;
    }

    public void adicionarUsuarioConquista(UsuarioConquista usuarioConquista) {
        usuariosConquistas.add(usuarioConquista);
        usuarioConquista.setConquista(this);
    }

    public void removerUsuarioConquista(UsuarioConquista usuarioConquista) {
        usuariosConquistas.remove(usuarioConquista);
        usuarioConquista.setConquista(null);
    }
}
