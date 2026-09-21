package br.simba.bem_estar.registroSono;

import br.simba.bem_estar.user.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController 
@RequestMapping("/registrosono")
@CrossOrigin ("*")
public class RegistroSonoController {
    
    private final RegistroSonoRepository registroSonoRepository;

    public RegistroSonoController(RegistroSonoRepository registroSonoRepository){

        this.registroSonoRepository = registroSonoRepository;
        
    }
    //listar os registros de sono
    @GetMapping("/")
    public List<RegistroSonoModel> getAllRegistroSono(){
        return registroSonoRepository.findAll();
    }
    //puxar um registro especifico por id 
    @GetMapping("/{id}")
    public RegistroSonoModel getRegiaRegistroSonoById(@PathVariable Long id) {
        return registroSonoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Nenhum registro de sono encontrado"));
    }


    //postar um novo registro de sono
    @PostMapping("/")
    public RegistroSonoModel creaRegistroSono(@RequestBody RegistroSonoModel registroSono) {
        //TODO: process POST request
        
        return registroSonoRepository.save(registroSono);
    }

    //deletar um registro
    @DeleteMapping("/")
        public void deleteRegistro(@PathVariable Long id){

        registroSonoRepository.deleteById(id);
        }
    
        //atualizar os registros de sono(precisa?)
    
    
}
