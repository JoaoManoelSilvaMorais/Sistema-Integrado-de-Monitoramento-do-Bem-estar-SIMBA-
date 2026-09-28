package br.simba.bem_estar.perfil;



import org.hibernate.annotations.JoinColumnOrFormula;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;




@Entity(name = "tb_perfil")
public class PerfilModel {
    

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double peso;
    private double altura;
    private Integer idade;
    private Integer streak;
    @OneToOne(mappedBy = "perfil")
    private UserModel Usuario;

    public PerfilModel(){

    }

    public PerfilModel(Integer streak) {
        this.streak = streak;
    }
    public Integer getStreak() {
        return streak;
    }
    public void setStreak(Integer streak) {
        this.streak = streak;
    }
    public PerfilModel(Long id, UserModel Usuario, double peso, double altura, Integer idade,Integer streak) {
        this.id = id;
        this.Usuario = Usuario;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.streak = streak;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserModel getUsuario() {
        return Usuario;
    }
    public void setUsuario(UserModel Usuario) {
        this.Usuario = Usuario;
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
