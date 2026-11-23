package br.simba.bem_estar.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import br.simba.bem_estar.exceptions.MuitasTentativasException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JWTService jwtService;

    private AuthController authController;
    private final MockHttpServletRequest http = new MockHttpServletRequest();

    @BeforeEach
    void criarController() {
        // limites: 5 erros de senha em 15 min e 10 cadastros por hora (mesmos valores do application.properties)
        authController = new AuthController(authenticationManager, userRepository, passwordEncoder, jwtService, 5, 15, 10);
    }

    @Test
    void registerCodificaSenhaESalvaUsuario() {
        UserModel request = new UserModel();
        request.setUsername("joao");
        request.setPassword("senha123");

        when(passwordEncoder.encode("senha123")).thenReturn("$2a$hash");
        when(userRepository.save(request)).thenReturn(request);

        ResponseEntity<String> resposta = authController.register(request, http);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals("Usuário cadastrado com sucesso!", resposta.getBody());
        assertEquals("$2a$hash", request.getPassword());
        verify(userRepository).save(request);
    }

    @Test
    void loginAutenticaERetornaTokenJwt() {
        UserModel request = new UserModel();
        request.setUsername("joao");
        request.setPassword("senha123");

        UserDetails principal = User.withUsername("joao").password("hash").authorities("USER").build();
        Authentication auth = mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn(principal);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(auth);
        when(jwtService.generateToken(principal)).thenReturn("jwt-gerado");

        ResponseEntity<String> resposta = authController.authenticate(request, http);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals("jwt-gerado", resposta.getBody());
    }

    @Test
    void loginBloqueiaDepoisDeCincoSenhasErradas() {
        UserModel request = new UserModel();
        request.setUsername("joao");
        request.setPassword("errada");
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("senha errada"));

        for (int i = 0; i < 5; i++) {
            assertThrows(BadCredentialsException.class, () -> authController.authenticate(request, http));
        }
        // a 6ª tentativa nem chega a conferir a senha
        assertThrows(MuitasTentativasException.class, () -> authController.authenticate(request, http));
        verify(authenticationManager, times(5)).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }
}
