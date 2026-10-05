package br.simba.bem_estar.Lembrete;

import jakarta.persistence.*;
import br.simba.bem_estar.user.UserModel;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_lembretes")
public class LembreteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime horario;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel usuario;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public LocalDateTime getHorario() { return horario; }
    public void setHorario(LocalDateTime horario) { this.horario = horario; }
    public UserModel getUsuario() { return usuario; }
    public void setUsuario(UserModel usuario) { this.usuario = usuario; }
}