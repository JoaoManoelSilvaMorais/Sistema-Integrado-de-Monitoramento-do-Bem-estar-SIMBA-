package br.simba.bem_estar.registroExercicio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;



@RestController 
@RequestMapping("/registroexercicio")
public class RegistroExercicioController {

private final RegistroExercicioRepository registroExercicioRepository;
private final UserRepository userRepository;

public RegistroExercicioController(RegistroExercicioRepository registroExercicioRepository, UserRepository userRepository) {
    this.registroExercicioRepository = registroExercicioRepository;
    this.userRepository = userRepository;
}

@PostMapping({"", "/"})
public RegistroExercicioModel registroExercicio(@RequestBody RegistroExercicioModel registroExercicio, Authentication authentication) {
    validarRegistroExercicio(registroExercicio);
    registroExercicio.setUsuario(usuarioAutenticado(authentication));
    
    return registroExercicioRepository.save(registroExercicio);
}
//pegar um registro pelo id
@GetMapping("/{id}")
public RegistroExercicioModel getRegistroExecicioById(@PathVariable long id, Authentication authentication) {
    RegistroExercicioModel registro = buscarRegistro(id);
    validarProprietario(registro, authentication);
    return registro;
}

@GetMapping({"", "/"})
public List<RegistroExercicioModel> getAllRegistroExercicio(Authentication authentication) {
    return registroExercicioRepository.findByUsuario(usuarioAutenticado(authentication));
}
@DeleteMapping("/{id}")
public void deleteRegistroExercicio(@PathVariable Long id, Authentication authentication){
    RegistroExercicioModel registro = buscarRegistro(id);
    validarProprietario(registro, authentication);
    registroExercicioRepository.delete(registro);
}

//atualizar dados 
@PutMapping("/{id}")
    public RegistroExercicioModel updateRegistroExercicio(@PathVariable Long id, @RequestBody RegistroExercicioModel exercioAtualizado, Authentication authentication) {
        RegistroExercicioModel exercicio = buscarRegistro(id);
        validarProprietario(exercicio, authentication);

        validarRegistroExercicio(exercioAtualizado);
        
       exercicio.setDataHora(exercioAtualizado.getDataHora());
       exercicio.setDuracaominutos(exercioAtualizado.getDuracaominutos());
       exercicio.setGastoCaloricoExtimado(exercioAtualizado.getGastoCaloricoExtimado());
       exercicio.setModalidade(exercioAtualizado.getModalidade());
        
        return registroExercicioRepository.save(exercicio);
    }

    private UserModel usuarioAutenticado(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new DadoNaoEncontradoException("Usuário não encontrado"));
    }

    private RegistroExercicioModel buscarRegistro(Long id) {
        return registroExercicioRepository.findById(id)
                .orElseThrow(() -> new DadoNaoEncontradoException("Registro não encontrado"));
    }

    private void validarProprietario(RegistroExercicioModel registro, Authentication authentication) {
        if (!registro.getUsuario().getUsername().equals(authentication.getName())) {
            throw new AcessoNegadoException("Registro não pertence ao usuário");
        }
    }

    //metodo que faz as validaçoes do  registros de exercicio,analisando se os valores sao validos
    private void validarRegistroExercicio(
        RegistroExercicioModel registroExercicio) {

    if (registroExercicio.getDataHora() == null) {
        throw new RegraDeNegocioException(
                "A data e hora do exercício são obrigatórias"
        );
    }

    if (registroExercicio.getDuracaominutos() <= 0) {
        throw new RegraDeNegocioException(
                "A duração do exercício deve ser maior que zero"
        );
    }

    if (registroExercicio.getModalidade() == null
            || registroExercicio.getModalidade().trim().isEmpty()) {
        throw new RegraDeNegocioException(
                "A modalidade do exercício é obrigatória"
        );
    }
}


}
