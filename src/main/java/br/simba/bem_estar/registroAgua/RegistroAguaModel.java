package br.simba.bem_estar.registroAgua;

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

@Entity(name = "tb_registroAgua") 
public class RegistroAguaModel {
    

@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
private long id;
private double quantidadeMl;
private LocalDateTime dataHora;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="usuario")
private UserModel usuario;

public RegistroAguaModel(){
    
}

public RegistroAguaModel(long id, double quantidadeMl, LocalDateTime dataHora, UserModel usuario) {
    this.id = id;
    this.quantidadeMl = quantidadeMl;
    this.dataHora = dataHora;
    this.usuario = usuario;
}


public long getId() {
    return id;
}


public void setId(long id) {
    this.id = id;
}


public double getQuantidadeMl() {
    return quantidadeMl;
}


public void setQuantidadeMl(double quantidadeMl) {
    this.quantidadeMl = quantidadeMl;
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
