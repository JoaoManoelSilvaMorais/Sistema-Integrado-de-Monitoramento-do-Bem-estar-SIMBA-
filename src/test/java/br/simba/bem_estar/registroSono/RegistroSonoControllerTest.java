package br.simba.bem_estar.registroSono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class RegistroSonoControllerTest {

    @Mock
    private RegistroSonoRepository registroSonoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistroSonoController controller;

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
    void listarFiltraApenasRegistrosDoUsuarioAutenticado() {
        UserModel outro = new UserModel();
        outro.setUsername("maria");

        LocalDateTime dormir = LocalDateTime.of(2026, 11, 9, 23, 0);
        LocalDateTime acordar = LocalDateTime.of(2026, 11, 10, 7, 0);

        RegistroSonoModel meu = new RegistroSonoModel(1L, dormir, acordar, 5, usuario);
        RegistroSonoModel alheio = new RegistroSonoModel(2L, dormir, acordar, 3, outro);
        RegistroSonoModel semDono = new RegistroSonoModel(3L, dormir, acordar, 4, null);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(registroSonoRepository.findAll()).thenReturn(List.of(meu, alheio, semDono));

        List<RegistroSonoModel> lista = controller.getAllRegistroSono(auth);

        assertEquals(1, lista.size());
        assertSame(meu, lista.get(0));
    }

    @Test
    void criarValidaCamposObrigatoriosEOrdemDasHoras() {
        LocalDateTime dormir = LocalDateTime.of(2026, 11, 9, 23, 0);
        LocalDateTime acordar = LocalDateTime.of(2026, 11, 10, 7, 0);

        assertThrows(RegraDeNegocioException.class,
                () -> controller.criarRegistroSono(new RegistroSonoModel(null, null, acordar, 4, null), auth));
        assertThrows(RegraDeNegocioException.class,
                () -> controller.criarRegistroSono(new RegistroSonoModel(null, dormir, null, 4, null), auth));
        assertThrows(RegraDeNegocioException.class,
                () -> controller.criarRegistroSono(new RegistroSonoModel(null, dormir, acordar, null, null), auth));
        assertThrows(RegraDeNegocioException.class,
                () -> controller.criarRegistroSono(new RegistroSonoModel(null, acordar, dormir, 4, null), auth));

        RegistroSonoModel valido = new RegistroSonoModel(null, dormir, acordar, 5, null);
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(registroSonoRepository.save(valido)).thenReturn(valido);

        RegistroSonoModel salvo = controller.criarRegistroSono(valido, auth);
        assertSame(usuario, salvo.getUsuario());
    }

    @Test
    void buscarAtualizarEDeletarValidamProprietarioEExistencia() {
        LocalDateTime dormir = LocalDateTime.of(2026, 11, 9, 23, 0);
        LocalDateTime acordar = LocalDateTime.of(2026, 11, 10, 7, 0);
        RegistroSonoModel meu = new RegistroSonoModel(1L, dormir, acordar, 4, usuario);

        when(registroSonoRepository.findById(1L)).thenReturn(Optional.of(meu));
        when(registroSonoRepository.save(meu)).thenReturn(meu);

        assertSame(meu, controller.getRegistroSonoById(1L, auth));

        RegistroSonoModel novosDados = new RegistroSonoModel(null, dormir.minusHours(1), acordar, 5, null);
        RegistroSonoModel atualizado = controller.atualizarRegistro(1L, novosDados, auth);
        assertEquals(5, atualizado.getNotaSono());
        assertEquals(dormir.minusHours(1), atualizado.getHoraDormir());

        controller.deleteRegistro(1L, auth);
        verify(registroSonoRepository).delete(meu);

        UserModel outro = new UserModel();
        outro.setUsername("maria");
        RegistroSonoModel alheio = new RegistroSonoModel(2L, dormir, acordar, 3, outro);
        when(registroSonoRepository.findById(2L)).thenReturn(Optional.of(alheio));
        assertThrows(AcessoNegadoException.class, () -> controller.getRegistroSonoById(2L, auth));

        when(registroSonoRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(DadoNaoEncontradoException.class, () -> controller.getRegistroSonoById(99L, auth));
    }
}
