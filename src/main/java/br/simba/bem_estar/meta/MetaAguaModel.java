package br.simba.bem_estar.meta;

import br.simba.bem_estar.user.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/** Meta diária de água definida pelo usuário. Sem registro aqui, vale a sugestão pelo peso. */
@Entity
@Table(name = "tb_meta_agua", uniqueConstraints = @UniqueConstraint(columnNames = "usuario_id"))
public class MetaAguaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int metaMl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    public MetaAguaModel() {
    }

    public Long getId() { return id; }
    public int getMetaMl() { return metaMl; }
    public void setMetaMl(int metaMl) { this.metaMl = metaMl; }
    public UserModel getUsuario() { return usuario; }
    public void setUsuario(UserModel usuario) { this.usuario = usuario; }
}
