package br.simba.bem_estar.registroExercicio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
        
       exercicio.setDataHora(exercioAtualizado.getDataHora());
       exercicio.setDuracaominutos(exercioAtualizado.getDuracaominutos());
       exercicio.setGastoCaloricoExtimado(exercioAtualizado.getGastoCaloricoExtimado());
       exercicio.setModalidade(exercioAtualizado.getModalidade());
        
        return registroExercicioRepository.save(exercicio);
    }

    private UserModel usuarioAutenticado(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private RegistroExercicioModel buscarRegistro(Long id) {
        return registroExercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    private void validarProprietario(RegistroExercicioModel registro, Authentication authentication) {
        if (!registro.getUsuario().getUsername().equals(authentication.getName())) {
            throw new org.springframework.security.access.AccessDeniedException("Registro não pertence ao usuário");
        }
    }


}
