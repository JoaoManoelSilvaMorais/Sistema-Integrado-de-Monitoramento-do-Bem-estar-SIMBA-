package br.simba.bem_estar.registroExercicio;

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
class RegistroExercicioControllerTest {

    @Mock
    private RegistroExercicioRepository registroExercicioRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistroExercicioController controller;

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
    void criarValidaCamposObrigatoriosESalva() {
        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 18, 0);

        assertThrows(RegraDeNegocioException.class, () -> controller.registroExercicio(
                new RegistroExercicioModel(null, "Corrida", 30, 300f, null, null), auth));
        assertThrows(RegraDeNegocioException.class, () -> controller.registroExercicio(
                new RegistroExercicioModel(null, "Corrida", 0, 300f, agora, null), auth));
        assertThrows(RegraDeNegocioException.class, () -> controller.registroExercicio(
                new RegistroExercicioModel(null, "   ", 30, 300f, agora, null), auth));

        RegistroExercicioModel valido = new RegistroExercicioModel(null, "Corrida", 40, 350f, agora, null);
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(registroExercicioRepository.save(valido)).thenReturn(valido);

        RegistroExercicioModel salvo = controller.registroExercicio(valido, auth);
        assertSame(usuario, salvo.getUsuario());

        when(registroExercicioRepository.findByUsuario(usuario)).thenReturn(List.of(salvo));
        assertEquals(1, controller.getAllRegistroExercicio(auth).size());
    }

    @Test
    void buscarAtualizarEDeletarValidamProprietarioEExistencia() {
        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 18, 0);
        RegistroExercicioModel meu = new RegistroExercicioModel(1L, "Corrida", 30, 300f, agora, usuario);

        when(registroExercicioRepository.findById(1L)).thenReturn(Optional.of(meu));
        when(registroExercicioRepository.save(meu)).thenReturn(meu);

        assertSame(meu, controller.getRegistroExecicioById(1L, auth));

        RegistroExercicioModel atualizacao = new RegistroExercicioModel(null, "Ciclismo", 50, 420f, agora.plusDays(1), null);
        RegistroExercicioModel atualizado = controller.updateRegistroExercicio(1L, atualizacao, auth);
        assertEquals("Ciclismo", atualizado.getModalidade());
        assertEquals(50, atualizado.getDuracaominutos());
        assertEquals(420f, atualizado.getGastoCaloricoExtimado());

        controller.deleteRegistroExercicio(1L, auth);
        verify(registroExercicioRepository).delete(meu);

        UserModel outro = new UserModel();
        outro.setUsername("maria");
        RegistroExercicioModel alheio = new RegistroExercicioModel(2L, "Yoga", 30, 100f, agora, outro);
        when(registroExercicioRepository.findById(2L)).thenReturn(Optional.of(alheio));
        assertThrows(AcessoNegadoException.class, () -> controller.getRegistroExecicioById(2L, auth));

        when(registroExercicioRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(DadoNaoEncontradoException.class, () -> controller.getRegistroExecicioById(99L, auth));
    }
}
