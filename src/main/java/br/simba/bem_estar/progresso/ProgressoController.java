package br.simba.bem_estar.progresso;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;


@RestController
@RequestMapping("/progresso")
public class ProgressoController {

    private final ProgressoService progressoService;

    private final UserRepository userRepository;


    public ProgressoController(
            ProgressoService progressoService,
            UserRepository userRepository) {

        this.progressoService =
            progressoService;

        this.userRepository =
            userRepository;
    }


    @GetMapping({"", "/"})
    public ProgressoDTO obterProgresso(

            Authentication authentication,

            @RequestParam(required = false)
            @DateTimeFormat(
                iso = DateTimeFormat.ISO.DATE
            )
            LocalDate inicio,

            @RequestParam(required = false)
            @DateTimeFormat(
                iso = DateTimeFormat.ISO.DATE
            )
            LocalDate fim) {


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


        LocalDate fimReal =
            fim != null
                ? fim
                : LocalDate.now();


        LocalDate inicioReal =
            inicio != null
                ? inicio
                : fimReal.minusDays(29);


        if (inicioReal.isAfter(fimReal)) {

            throw new RuntimeException(
                "A data inicial não pode ser posterior à data final."
            );
        }


        return progressoService
            .obterProgresso(
                usuario,
                inicioReal,
                fimReal
            );
    }
}