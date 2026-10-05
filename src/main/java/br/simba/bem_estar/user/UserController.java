package br.simba.bem_estar.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.security.JWTService;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;


    public UserController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JWTService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @GetMapping("/me")
    public UserDto getCurrentUser(
            Authentication authentication) {

        UserModel usuario =
            userRepository
                .findByUsername(
                    authentication.getName()
                )
                .orElseThrow(
                    () -> new RuntimeException(
                        "Usuário não encontrado"
                    )
                );


        return new UserDto(
            usuario.getId(),
            usuario.getName(),
            usuario.getUsername(),
            usuario.getEmail(),
            null
        );
    }

    @PutMapping("/me")
    public AtualizarUsuarioResponseDto atualizarUsuario(
            Authentication authentication,
            @RequestBody AtualizarUsuarioDto dados) {

        UserModel usuario =
            userRepository
                .findByUsername(
                    authentication.getName()
                )
                .orElseThrow(
                    () -> new RuntimeException(
                        "Usuário não encontrado"
                    )
                );

        String novoNome =
            dados.getName() != null
                ? dados.getName().trim()
                : "";


        String novoUsername =
            dados.getUsername() != null
                ? dados.getUsername().trim()
                : "";


        String novoEmail =
            dados.getEmail() != null
                ? dados.getEmail().trim()
                : "";

        if (novoNome.isEmpty()) {

            throw new RuntimeException(
                "O nome não pode ficar vazio"
            );
        }


        if (novoUsername.isEmpty()) {

            throw new RuntimeException(
                "O nome de usuário não pode ficar vazio"
            );
        }


        if (novoEmail.isEmpty()) {

            throw new RuntimeException(
                "O e-mail não pode ficar vazio"
            );
        }

        userRepository
            .findByUsername(novoUsername)
            .ifPresent(outroUsuario -> {

                if (
                    !outroUsuario
                        .getId()
                        .equals(
                            usuario.getId()
                        )
                ) {

                    throw new RuntimeException(
                        "Este nome de usuário já está em uso"
                    );
                }

            });

        userRepository
            .findByEmail(novoEmail)
            .ifPresent(outroUsuario -> {

                if (
                    !outroUsuario
                        .getId()
                        .equals(
                            usuario.getId()
                        )
                ) {

                    throw new RuntimeException(
                        "Este e-mail já está em uso"
                    );
                }

            });

        usuario.setName(novoNome);
        usuario.setUsername(novoUsername);
        usuario.setEmail(novoEmail);


        UserModel usuarioSalvo =
            userRepository.save(usuario);

        UserDetails userDetails =
            org.springframework.security
                .core
                .userdetails
                .User
                .withUsername(
                    usuarioSalvo.getUsername()
                )
                .password(
                    usuarioSalvo.getPassword()
                )
                .authorities("USER")
                .build();


        String novoToken =
            jwtService.generateToken(
                userDetails
            );


        UserDto usuarioDto =
            new UserDto(
                usuarioSalvo.getId(),
                usuarioSalvo.getName(),
                usuarioSalvo.getUsername(),
                usuarioSalvo.getEmail(),
                null
            );


        return new AtualizarUsuarioResponseDto(
            usuarioDto,
            novoToken
        );
    }

    @PutMapping("/me/password")
    public ResponseEntity<String> alterarSenha(
            Authentication authentication,
            @RequestBody AlterarSenhaDto dados) {


        UserModel usuario =
            userRepository
                .findByUsername(
                    authentication.getName()
                )
                .orElseThrow(
                    () -> new RuntimeException(
                        "Usuário não encontrado"
                    )
                );

        if (
            dados.getSenhaAtual() == null ||
            dados.getSenhaAtual().isBlank() ||
            dados.getNovaSenha() == null ||
            dados.getNovaSenha().isBlank() ||
            dados.getConfirmarSenha() == null ||
            dados.getConfirmarSenha().isBlank()
        ) {

            return ResponseEntity
                .badRequest()
                .body(
                    "Preencha todos os campos"
                );
        }

        boolean senhaCorreta =
            passwordEncoder.matches(
                dados.getSenhaAtual(),
                usuario.getPassword()
            );


        if (!senhaCorreta) {

            return ResponseEntity
                .badRequest()
                .body(
                    "Senha atual incorreta"
                );
        }

        if (
            !dados
                .getNovaSenha()
                .equals(
                    dados.getConfirmarSenha()
                )
        ) {

            return ResponseEntity
                .badRequest()
                .body(
                    "As novas senhas não coincidem"
                );
        }

        if (
            passwordEncoder.matches(
                dados.getNovaSenha(),
                usuario.getPassword()
            )
        ) {

            return ResponseEntity
                .badRequest()
                .body(
                    "A nova senha deve ser diferente da senha atual"
                );
        }

        String novaSenhaCriptografada =
            passwordEncoder.encode(
                dados.getNovaSenha()
            );


        usuario.setPassword(
            novaSenhaCriptografada
        );


        userRepository.save(usuario);


        return ResponseEntity.ok(
            "Senha alterada com sucesso"
        );
    }
}