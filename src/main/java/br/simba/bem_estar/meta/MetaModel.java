package br.simba.bem_estar.meta;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/** Meta criada pelo usuário. Enquanto concluidaEm for nulo, a meta está ativa. */
@Entity
@Table(name = "tb_meta")
public class MetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMeta tipo;

    private int alvo;
    private LocalDate dataInicio;
    private LocalDateTime concluidaEm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    public MetaModel() {
    }

    public Long getId() { return id; }
    public TipoMeta getTipo() { return tipo; }
    public void setTipo(TipoMeta tipo) { this.tipo = tipo; }
    public int getAlvo() { return alvo; }
    public void setAlvo(int alvo) { this.alvo = alvo; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDateTime getConcluidaEm() { return concluidaEm; }
    public void setConcluidaEm(LocalDateTime concluidaEm) { this.concluidaEm = concluidaEm; }
    public UserModel getUsuario() { return usuario; }
    public void setUsuario(UserModel usuario) { this.usuario = usuario; }
}
