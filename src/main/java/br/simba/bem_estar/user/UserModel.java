package br.simba.bem_estar.user;


import java.util.List;

import br.simba.bem_estar.perfil.PerfilModel;
import br.simba.bem_estar.registroSono.RegistroSonoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user")
public class UserModel {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    
    //referencia o perfil do usuario
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id",nullable = false)
    private PerfilModel perfil;

    //referencia os registros de  sono do usuario
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<RegistroSonoModel> registroSono;

    // Versao antiga: a chave estrangeira era definida no lado inverso.
    // @OneToMany(fetch = FetchType.LAZY)
    // @JoinColumn(name = "registrosono_id")
    // private List<RegistroSonoModel> registroSono;


    public UserModel(){

    }


    public UserModel(Long id, String name, String username, String email, String password, PerfilModel perfil) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.perfil = perfil;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public PerfilModel getPerfil() {
        return perfil;
    }
    public void setPerfil(PerfilModel perfil) {
        this.perfil = perfil;
    }

    public List<RegistroSonoModel> getRegistroSono() {
        return registroSono;
    }

    public void setRegistroSono(List<RegistroSonoModel> registroSono) {
        this.registroSono = registroSono;
    }


    
}
