package br.simba.bem_estar.registroSono;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@RestController
@RequestMapping("/registrosono")
@CrossOrigin("*")
public class RegistroSonoController {

    private final RegistroSonoRepository registroSonoRepository;
    private final UserRepository userRepository;

    public RegistroSonoController(
            RegistroSonoRepository registroSonoRepository,
            UserRepository userRepository) {

        this.registroSonoRepository = registroSonoRepository;
        this.userRepository = userRepository;
    }

    // listar os registros de sono do usuário autenticado
    @GetMapping("/")
    public List<RegistroSonoModel> getAllRegistroSono(
            Authentication authentication) {

        return registroSonoRepository.findByUsuario(
                usuarioAutenticado(authentication)
        );
    }

    // puxar um registro específico por id
    @GetMapping("/{id}")
    public RegistroSonoModel getRegistroSonoById(
            @PathVariable Long id,
            Authentication authentication) {

        RegistroSonoModel registro = buscarRegistro(id);

        validarProprietario(registro, authentication);

        return registro;
    }

    // postar um novo registro de sono
    @PostMapping("/")
    public RegistroSonoModel criarRegistroSono(
            @RequestBody RegistroSonoModel registroSono,
            Authentication authentication) {

        validarRegistroSono(registroSono);

        registroSono.setUsuario(
                usuarioAutenticado(authentication)
        );

        return registroSonoRepository.save(registroSono);
    }

    // deletar registro
    @DeleteMapping("/{id}")
    public void deleteRegistro(
            @PathVariable Long id,
            Authentication authentication) {

        RegistroSonoModel registro = buscarRegistro(id);

        validarProprietario(registro, authentication);

        registroSonoRepository.delete(registro);
    }

    // atualizar registro
    @PutMapping("/{id}")
    public RegistroSonoModel atualizarRegistro(
            @PathVariable Long id,
            @RequestBody RegistroSonoModel novoRegistro,
            Authentication authentication) {

        RegistroSonoModel registro = buscarRegistro(id);

        validarProprietario(registro, authentication);

        validarRegistroSono(novoRegistro);

        registro.setHoraDormir(
                novoRegistro.getHoraDormir()
        );

        registro.setHoraAcordar(
                novoRegistro.getHoraAcordar()
        );

        registro.setNotaSono(
                novoRegistro.getNotaSono()
        );

        return registroSonoRepository.save(registro);
    }

    // buscar usuário autenticado
    private UserModel usuarioAutenticado(
            Authentication authentication) {

        return userRepository.findByUsername(authentication.getName())
                .orElseThrow(() ->
                        new DadoNaoEncontradoException(
                                "Usuário não encontrado"
                        )
                );
    }

    // buscar registro pelo id
    private RegistroSonoModel buscarRegistro(Long id) {

        return registroSonoRepository.findById(id)
                .orElseThrow(() ->
                        new DadoNaoEncontradoException(
                                "Registro de sono não encontrado"
                        )
                );
    }

    // verificar se o registro pertence ao usuário
    private void validarProprietario(
            RegistroSonoModel registro,
            Authentication authentication) {

        if (registro.getUsuario() == null ||
                !registro.getUsuario().getUsername()
                        .equals(authentication.getName())) {

            throw new AcessoNegadoException(
                    "Registro não pertence ao usuário"
            );
        }
    }

    // validar dados do registro de sono
    private void validarRegistroSono(
            RegistroSonoModel registroSono) {

        if (registroSono.getHoraDormir() == null) {
            throw new RegraDeNegocioException(
                    "A hora de dormir é obrigatória"
            );
        }

        if (registroSono.getHoraAcordar() == null) {
            throw new RegraDeNegocioException(
                    "A hora de acordar é obrigatória"
            );
        }

        if (registroSono.getNotaSono() == null) {
            throw new RegraDeNegocioException(
                    "A nota do sono é obrigatória"
            );
        }
        if (registroSono.getHoraAcordar()
            .isBefore(registroSono.getHoraDormir())) {

        throw new RegraDeNegocioException(
                "A hora de acordar não pode ser anterior à hora de dormir"
        );
    }

    }
}