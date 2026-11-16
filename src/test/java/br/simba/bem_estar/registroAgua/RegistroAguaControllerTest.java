package br.simba.bem_estar.registroAgua;

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
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class RegistroAguaControllerTest {

    @Mock
    private RegistroAguaRepository aguaRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RegistroAguaController controller;

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
    void criarEListarRegistrosDoUsuario() {
        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 9, 0);
        RegistroAguaModel novo = new RegistroAguaModel(null, 250.0, agora, null);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(aguaRepository.save(novo)).thenReturn(novo);

        RegistroAguaModel salvo = controller.createRegistroAgua(novo, auth);
        assertSame(usuario, salvo.getUsuario());
        assertEquals(250.0, salvo.getQuantidadeMl());

        when(aguaRepository.findByUsuario(usuario)).thenReturn(List.of(salvo));
        assertEquals(1, controller.getAllRegistroAgua(auth).size());
    }

    @Test
    void buscarAtualizarEDeletarValidamProprietarioEExistencia() {
        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 9, 0);
        RegistroAguaModel meu = new RegistroAguaModel(1L, 300.0, agora, usuario);
        when(aguaRepository.findById(1L)).thenReturn(Optional.of(meu));
        when(aguaRepository.save(meu)).thenReturn(meu);

        assertSame(meu, controller.getRegistroAgua(1L, auth));

        RegistroAguaModel atualizado = new RegistroAguaModel(null, 500.0, agora.plusHours(1), null);
        RegistroAguaModel salvo = controller.putRegistroAgua(1L, atualizado, auth);
        assertEquals(500.0, salvo.getQuantidadeMl());
        assertEquals(agora.plusHours(1), salvo.getDataHora());

        controller.deleteRegistroAgua(1L, auth);
        verify(aguaRepository).delete(meu);

        UserModel outro = new UserModel();
        outro.setUsername("maria");
        RegistroAguaModel alheio = new RegistroAguaModel(2L, 300.0, agora, outro);
        when(aguaRepository.findById(2L)).thenReturn(Optional.of(alheio));
        assertThrows(AcessoNegadoException.class, () -> controller.getRegistroAgua(2L, auth));
        assertThrows(AcessoNegadoException.class, () -> controller.deleteRegistroAgua(2L, auth));

        when(aguaRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(DadoNaoEncontradoException.class, () -> controller.getRegistroAgua(99L, auth));
    }
}
