package br.simba.bem_estar.sintoma;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Column;
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
import jakarta.persistence.UniqueConstraint;

/**
 * Respostas do questionário diário "Sinais Corporais".
 * Um registro por usuário por dia: responder de novo no mesmo dia atualiza este registro.
 */
@Entity
@Table(
        name = "tb_registro_sintoma",
        uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "data_registro"}))
public class RegistroSintomaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    private int energia;
    private int humor;
    private int estresse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelDor dor;

    /** Locais separados por vírgula, ex.: "CABECA,COSTAS". Vazio quando não há dor. */
    @Column(length = 200)
    private String locaisDor;

    /** Sintomas separados por vírgula, ex.: "CANSACO,TONTURA" ou "NENHUM". */
    @Column(length = 200)
    private String sintomas;

    @Column(length = 300)
    private String observacao;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    public RegistroSintomaModel() {
    }

    public Long getId() { return id; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
    public int getHumor() { return humor; }
    public void setHumor(int humor) { this.humor = humor; }
    public int getEstresse() { return estresse; }
    public void setEstresse(int estresse) { this.estresse = estresse; }
    public NivelDor getDor() { return dor; }
    public void setDor(NivelDor dor) { this.dor = dor; }
    public String getLocaisDor() { return locaisDor; }
    public void setLocaisDor(String locaisDor) { this.locaisDor = locaisDor; }
    public String getSintomas() { return sintomas; }
    public void setSintomas(String sintomas) { this.sintomas = sintomas; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
    public UserModel getUsuario() { return usuario; }
    public void setUsuario(UserModel usuario) { this.usuario = usuario; }
}
