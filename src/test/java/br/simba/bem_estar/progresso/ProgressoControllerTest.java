package br.simba.bem_estar.progresso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class ProgressoControllerTest {

    @Mock
    private ProgressoService progressoService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProgressoController progressoController;

    @Test
    void usaDatasPadraoUltimos30DiasQuandoParametrosNulos() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");
        UserModel usuario = new UserModel();
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        LocalDate hoje = LocalDate.now();
        ProgressoDTO esperado = new ProgressoDTO(List.of(), List.of(), List.of());
        when(progressoService.obterProgresso(usuario, hoje.minusDays(29), hoje)).thenReturn(esperado);

        ProgressoDTO resposta = progressoController.obterProgresso(auth, null, null);

        assertSame(esperado, resposta);
        verify(progressoService).obterProgresso(usuario, hoje.minusDays(29), hoje);
    }

    @Test
    void rejeitaDataInicialPosteriorAFinal() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(new UserModel()));

        LocalDate inicio = LocalDate.of(2026, 11, 10);
        LocalDate fim = LocalDate.of(2026, 11, 5);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> progressoController.obterProgresso(auth, inicio, fim));

        assertEquals("A data inicial não pode ser posterior à data final.", ex.getMessage());
    }

    @Test
    void usuarioNaoEncontradoLancaExcecao() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("desconhecido");
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> progressoController.obterProgresso(auth, null, null));
    }
}
