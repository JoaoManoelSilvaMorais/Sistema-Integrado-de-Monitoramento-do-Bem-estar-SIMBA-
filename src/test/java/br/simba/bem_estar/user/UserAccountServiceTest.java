package br.simba.bem_estar.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import br.simba.bem_estar.conquista.ConquistaUsuarioRepository;
import br.simba.bem_estar.lembrete.LembreteRepository;
import br.simba.bem_estar.meta.MetaAguaRepository;
import br.simba.bem_estar.meta.MetaRepository;
import br.simba.bem_estar.perfil.PerfilModel;
import br.simba.bem_estar.perfil.PerfilRepository;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.rotina.RotinaRepository;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private PerfilRepository perfilRepository;
    @Mock private RegistroAguaRepository aguaRepository;
    @Mock private RegistroSonoRepository sonoRepository;
    @Mock private RegistroExercicioRepository exercicioRepository;
    @Mock private MetaRepository metaRepository;
    @Mock private MetaAguaRepository metaAguaRepository;
    @Mock private ConquistaUsuarioRepository conquistaRepository;
    @Mock private RotinaRepository rotinaRepository;
    @Mock private LembreteRepository lembreteRepository;

    @InjectMocks
    private UserAccountService userAccountService;

    private UserModel usuario;

    @BeforeEach
    void preparar() {
        usuario = new UserModel();
        usuario.setId(7L);
        usuario.setUsername("joao");
        usuario.setPassword("$2a$hash");
    }

    @Test
    void excluirContaValidaExistenciaSenhaEmBrancoESenhaIncorreta() {
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());
        ResponseStatusException notFound = assertThrows(ResponseStatusException.class,
                () -> userAccountService.excluirConta("desconhecido", "123"));
        assertEquals(HttpStatus.NOT_FOUND, notFound.getStatusCode());

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        ResponseStatusException badRequest = assertThrows(ResponseStatusException.class,
                () -> userAccountService.excluirConta("joao", "   "));
        assertEquals(HttpStatus.BAD_REQUEST, badRequest.getStatusCode());

        when(passwordEncoder.matches("errada", "$2a$hash")).thenReturn(false);
        ResponseStatusException unauthorized = assertThrows(ResponseStatusException.class,
                () -> userAccountService.excluirConta("joao", "errada"));
        assertEquals(HttpStatus.UNAUTHORIZED, unauthorized.getStatusCode());
    }

    @Test
    void excluirContaComPerfilRemoveTodosDadosEmOrdemSegura() {
        PerfilModel perfil = new PerfilModel();
        usuario.setPerfil(perfil);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("certa", "$2a$hash")).thenReturn(true);

        userAccountService.excluirConta("joao", "certa");

        InOrder ordem = inOrder(
                aguaRepository, sonoRepository, exercicioRepository,
                metaRepository, metaAguaRepository, conquistaRepository,
                lembreteRepository, rotinaRepository, userRepository, perfilRepository);
        ordem.verify(aguaRepository).deleteByUsuarioId(7L);
        ordem.verify(sonoRepository).deleteByUsuarioId(7L);
        ordem.verify(exercicioRepository).deleteByUsuarioId(7L);
        ordem.verify(metaRepository).deleteByUsuarioId(7L);
        ordem.verify(metaAguaRepository).deleteByUsuarioId(7L);
        ordem.verify(conquistaRepository).deleteByUsuarioId(7L);
        ordem.verify(lembreteRepository).deleteByUsuarioId(7L);
        ordem.verify(rotinaRepository).deleteByUsuarioId(7L);
        ordem.verify(userRepository).delete(usuario);
        ordem.verify(perfilRepository).delete(perfil);
    }

    @Test
    void excluirContaSemPerfilNaoChamaDeleteDePerfil() {
        usuario.setPerfil(null);
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("certa", "$2a$hash")).thenReturn(true);

        userAccountService.excluirConta("joao", "certa");

        verify(userRepository).delete(usuario);
        verify(perfilRepository, never()).delete(any());
    }
}
