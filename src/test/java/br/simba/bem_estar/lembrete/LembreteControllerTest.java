package br.simba.bem_estar.lembrete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class LembreteControllerTest {

    @Mock
    private LembreteRepository lembreteRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private LembreteController controller;

    private UserModel usuario;
    private Authentication auth;

    @BeforeEach
    void preparar() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
        auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");
    }

    @Test
    void criarSalvaLembreteVinculadoAoUsuario() {
        LembreteModel lembrete = new LembreteModel();
        lembrete.setTitulo("Tomar vitamina");
        lembrete.setMensagem("Após o almoço");
        lembrete.setHorario(LocalDateTime.of(2026, 11, 10, 13, 0));

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(lembreteRepository.save(lembrete)).thenReturn(lembrete);

        ResponseEntity<LembreteModel> resp = controller.criar(lembrete, auth);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertSame(usuario, resp.getBody().getUsuario());
        verify(lembreteRepository).save(lembrete);
    }

    @Test
    void criarComTituloEmBrancoOuUsuarioInexistenteLancaExcecao() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        LembreteModel semTitulo = new LembreteModel();
        semTitulo.setTitulo("   ");
        assertThrows(RegraDeNegocioException.class, () -> controller.criar(semTitulo, auth));

        when(userRepository.findByUsername("joao")).thenReturn(Optional.empty());
        LembreteModel valido = new LembreteModel();
        valido.setTitulo("Água");
        assertThrows(DadoNaoEncontradoException.class, () -> controller.criar(valido, auth));
    }

    @Test
    void listarRetornaApenasDoUsuarioLogado() {
        LembreteModel l = new LembreteModel();
        l.setTitulo("Dormir");
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(lembreteRepository.findByUsuario(usuario)).thenReturn(List.of(l));

        ResponseEntity<List<LembreteModel>> resp = controller.listar(auth);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(1, resp.getBody().size());
    }

    @Test
    void deletarVerificaProprietarioEExistencia() {
        LembreteModel meu = new LembreteModel();
        meu.setId(1L);
        meu.setUsuario(usuario);

        when(lembreteRepository.findById(1L)).thenReturn(Optional.of(meu));
        ResponseEntity<Void> resp = controller.deletar(1L, auth);
        assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
        verify(lembreteRepository).delete(meu);

        UserModel outro = new UserModel();
        outro.setUsername("maria");
        LembreteModel alheio = new LembreteModel();
        alheio.setId(2L);
        alheio.setUsuario(outro);
        when(lembreteRepository.findById(2L)).thenReturn(Optional.of(alheio));
        assertThrows(AcessoNegadoException.class, () -> controller.deletar(2L, auth));

        when(lembreteRepository.findById(3L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> controller.deletar(3L, auth));
    }
}
