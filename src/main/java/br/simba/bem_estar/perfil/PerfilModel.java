package br.simba.bem_estar.perfil;

import org.springframework.boot.security.autoconfigure.SecurityProperties.User;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity 
public class PerfilModel {
    

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserModel user;
    private double peso;
    private double altura;
    private Integer idade;
    public PerfilModel(Long id, UserModel user, double peso, double altura, Integer idade) {
        this.id = id;
        this.user = user;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    
}
