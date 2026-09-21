package br.simba.bem_estar.registroExercicio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.user.UserModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/registroexercicio")
public class RegistroExercicioController {

private RegistroExercicioRepository registroExercicioRepository;

@PostMapping("/")
public RegistroExercicioModel registroExercicio(@RequestBody RegistroExercicioModel registroExercicio) {
    //TODO: process POST request
    
    return registroExercicioRepository.save(registroExercicio);
}
//pegar um registro pelo id
@GetMapping("/{id}")
public  RegistroExercicioModel getRegistroExecicioById(@PathVariable long id) {
    return registroExercicioRepository.findById(id)
    .orElseThrow(()-> new RuntimeException("usuario não encontrado"));
}

@GetMapping("/")
public List<RegistroExercicioModel> getAllRegistroExercicio() {
    return registroExercicioRepository.findAll();
}
@DeleteMapping("/")
public void deleteRegistroExercicio(@PathVariable Long id){
    registroExercicioRepository.deleteById(id);
}

//atualizar dados 
@PutMapping("/{id}")
    public RegistroExercicioModel updateRegistroExercicio(@PathVariable Long id, @RequestBody RegistroExercicioModel exercioAtualizado) {
        RegistroExercicioModel exercicio = registroExercicioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        
       exercicio.setDataHora(exercioAtualizado.getDataHora());
       exercicio.setDuracaominutos(exercioAtualizado.getDuracaominutos());
       exercicio.setGastoCaloricoExtimado(exercioAtualizado.getGastoCaloricoExtimado());
       exercicio.setModalidade(exercioAtualizado.getModalidade());
        
        return registroExercicioRepository.save(exercicio);
    }


}
