package br.simba.bem_estar.conquista;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.user.UserModel;

class UsuarioConquistaTest {

    @Test
    void deveRelacionarUsuarioEConquista() {
        UserModel usuario = new UserModel();
        Conquista conquista = new Conquista("Água", "Beba 2L por dia", 2);
        UsuarioConquista usuarioConquista = new UsuarioConquista();

        usuarioConquista.setUsuario(usuario);
        usuarioConquista.setConquista(conquista);

        assertSame(usuario, usuarioConquista.getUsuario());
        assertSame(conquista, usuarioConquista.getConquista());

        conquista.adicionarUsuarioConquista(usuarioConquista);

        assertTrue(conquista.getUsuariosConquistas().contains(usuarioConquista));
        assertSame(conquista, usuarioConquista.getConquista());
    }
}
