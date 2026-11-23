package br.simba.bem_estar.security;

import br.simba.bem_estar.exceptions.MuitasTentativasException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Duration;
import java.util.Locale;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    // Erros de senha por usuário + IP, e cadastros novos por IP (ver application.properties)
    private final LimiteTentativas falhasLogin;
    private final LimiteTentativas cadastros;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          PasswordEncoder passwordEncoder, JWTService jwtService,
                          @Value("${simba.login.max-falhas:5}") int maxFalhas,
                          @Value("${simba.login.janela-minutos:15}") int janelaMinutos,
                          @Value("${simba.cadastro.max-por-hora:10}") int maxCadastrosPorHora) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.falhasLogin = new LimiteTentativas(maxFalhas, Duration.ofMinutes(janelaMinutos), Clock.systemUTC());
        this.cadastros = new LimiteTentativas(maxCadastrosPorHora, Duration.ofHours(1), Clock.systemUTC());
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserModel request, HttpServletRequest http) {
        String chave = "cadastro:" + http.getRemoteAddr();
        long espera = cadastros.segundosParaLiberar(chave);
        if (espera > 0) {
            throw new MuitasTentativasException(
                    "Muitas contas criadas a partir deste computador. Tente de novo em " + minutos(espera) + ".");
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(request);
        cadastros.registrar(chave);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody UserModel request, HttpServletRequest http) {
        String usuario = request.getUsername() == null ? "" : request.getUsername().trim().toLowerCase(Locale.ROOT);
        String chave = "login:" + usuario + "|" + http.getRemoteAddr();

        long espera = falhasLogin.segundosParaLiberar(chave);
        if (espera > 0) {
            throw new MuitasTentativasException(
                    "Muitas tentativas de login erradas. Tente de novo em " + minutos(espera) + ".");
        }

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (AuthenticationException erro) {
            falhasLogin.registrar(chave);
            throw erro; // continua sendo tratado como antes pelo RestExceptionHandler
        }

        falhasLogin.limpar(chave);
        UserDetails user = (UserDetails) authentication.getPrincipal();
        var jwtToken = jwtService.generateToken(user);
        return ResponseEntity.ok(jwtToken);
    }

    private static String minutos(long segundos) {
        long min = Math.max(1, (segundos + 59) / 60);
        return min == 1 ? "1 minuto" : min + " minutos";
    }
}
