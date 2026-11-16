package br.simba.bem_estar.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.simba.bem_estar.security.JWTService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private JWTService jwtService;
    @Mock private UserAccountService userAccountService;

    @InjectMocks
    private UserController controller;

    private UserModel usuario;
    private Authentication auth;

    @BeforeEach
    void preparar() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setName("João");
        usuario.setUsername("joao");
        usuario.setEmail("joao@simba.com");
        usuario.setPassword("$2a$atual");

        auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");
    }

    @Test
    void getCurrentUserRetornaDtoDoUsuarioLogado() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        UserDto dto = controller.getCurrentUser(auth);

        assertEquals(1L, dto.getId());
        assertEquals("João", dto.getName());
        assertEquals("joao", dto.getUsername());
        assertEquals("joao@simba.com", dto.getEmail());
    }

    @Test
    void atualizarUsuarioSalvaDadosEEmiteNovoToken() {
        AtualizarUsuarioDto dados = new AtualizarUsuarioDto();
        dados.setName("  João Manoel  ");
        dados.setUsername("  joao_novo  ");
        dados.setEmail("  novo@simba.com  ");

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(userRepository.findByUsername("joao_novo")).thenReturn(Optional.empty());
        when(userRepository.findByEmail("novo@simba.com")).thenReturn(Optional.empty());
        when(userRepository.save(usuario)).thenReturn(usuario);
        when(jwtService.generateToken(any(UserDetails.class))).thenReturn("novo-jwt");

        AtualizarUsuarioResponseDto resposta = controller.atualizarUsuario(auth, dados);

        assertEquals("João Manoel", resposta.getUsuario().getName());
        assertEquals("joao_novo", resposta.getUsuario().getUsername());
        assertEquals("novo@simba.com", resposta.getUsuario().getEmail());
        assertEquals("novo-jwt", resposta.getToken());
    }

    @Test
    void atualizarUsuarioRejeitaCamposVaziosOuDuplicados() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        AtualizarUsuarioDto semNome = new AtualizarUsuarioDto();
        semNome.setName(" ");
        semNome.setUsername("joao");
        semNome.setEmail("joao@simba.com");
        assertThrows(RuntimeException.class, () -> controller.atualizarUsuario(auth, semNome));

        UserModel outro = new UserModel();
        outro.setId(99L);
        when(userRepository.findByUsername("duplicado")).thenReturn(Optional.of(outro));
        AtualizarUsuarioDto usernameEmUso = new AtualizarUsuarioDto();
        usernameEmUso.setName("João");
        usernameEmUso.setUsername("duplicado");
        usernameEmUso.setEmail("joao@simba.com");
        assertThrows(RuntimeException.class, () -> controller.atualizarUsuario(auth, usernameEmUso));

        when(userRepository.findByEmail("usado@simba.com")).thenReturn(Optional.of(outro));
        AtualizarUsuarioDto emailEmUso = new AtualizarUsuarioDto();
        emailEmUso.setName("João");
        emailEmUso.setUsername("joao");
        emailEmUso.setEmail("usado@simba.com");
        assertThrows(RuntimeException.class, () -> controller.atualizarUsuario(auth, emailEmUso));
    }

    @Test
    void alterarSenhaValidaRegrasEAtualizaHashQuandoValida() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        AlterarSenhaDto incompleto = new AlterarSenhaDto();
        incompleto.setSenhaAtual(" ");
        assertEquals(HttpStatus.BAD_REQUEST, controller.alterarSenha(auth, incompleto).getStatusCode());

        AlterarSenhaDto errada = new AlterarSenhaDto();
        errada.setSenhaAtual("errada");
        errada.setNovaSenha("nova123");
        errada.setConfirmarSenha("nova123");
        when(passwordEncoder.matches("errada", "$2a$atual")).thenReturn(false);
        assertEquals("Senha atual incorreta", controller.alterarSenha(auth, errada).getBody());

        AlterarSenhaDto divergente = new AlterarSenhaDto();
        divergente.setSenhaAtual("atual123");
        divergente.setNovaSenha("nova123");
        divergente.setConfirmarSenha("outra");
        when(passwordEncoder.matches("atual123", "$2a$atual")).thenReturn(true);
        assertEquals("As novas senhas não coincidem", controller.alterarSenha(auth, divergente).getBody());

        AlterarSenhaDto igualAtual = new AlterarSenhaDto();
        igualAtual.setSenhaAtual("atual123");
        igualAtual.setNovaSenha("atual123");
        igualAtual.setConfirmarSenha("atual123");
        assertEquals("A nova senha deve ser diferente da senha atual",
                controller.alterarSenha(auth, igualAtual).getBody());

        AlterarSenhaDto valida = new AlterarSenhaDto();
        valida.setSenhaAtual("atual123");
        valida.setNovaSenha("nova123");
        valida.setConfirmarSenha("nova123");
        when(passwordEncoder.matches("nova123", "$2a$atual")).thenReturn(false);
        when(passwordEncoder.encode("nova123")).thenReturn("$2a$nova");

        ResponseEntity<String> ok = controller.alterarSenha(auth, valida);
        assertEquals(HttpStatus.OK, ok.getStatusCode());
        assertEquals("Senha alterada com sucesso", ok.getBody());
        assertEquals("$2a$nova", usuario.getPassword());
        verify(userRepository).save(usuario);
    }

    @Test
    void excluirContaDelegaParaUserAccountServiceERetorna204() {
        ExcluirContaDto dto = new ExcluirContaDto();
        dto.setSenha("minhaSenha");

        ResponseEntity<Void> resp = controller.excluirConta(auth, dto);

        assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
        verify(userAccountService).excluirConta("joao", "minhaSenha");
    }
}
