package br.simba.bem_estar.perfil;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity(name = "tb_perfil")
public class PerfilModel {
    

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private double peso;
    private double altura;
    private Integer idade;
    public PerfilModel(Long id, Long idUser, double peso, double altura, Integer idade) {
        this.id = id;
        this.idUser = idUser;
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
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
