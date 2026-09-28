package br.simba.bem_estar.registroAgua;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
@RequestMapping("/registroAgua")
public class RegistroAguaController {

    public final RegistroAguaRepository aguaRepository = null;


    
    //postar dados
    @PostMapping("/")
    public RegistroAguaModel  createRegistroAgua(@RequestBody RegistroAguaModel registroAgua) {
        //TODO: process POST request
        return aguaRepository.save(registroAgua);
    }
    


    //pegar todos os item
    @GetMapping("/")
    public List<RegistroAguaModel> getAllRegistroAgua(){
        return  aguaRepository.findAll();
    }
    //pegar item por id
    @GetMapping("/{id}")
    public RegistroAguaModel getRegistroAgua(@PathVariable Long id) {
        return aguaRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Registro não encontrado"));
    }

    //deletar item
    @DeleteMapping("/{id}")
    public void deleteRegistroAgua(@PathVariable Long id){
        aguaRepository.deleteById(id);
    }

    //atualizar os dados

    @PutMapping("/{id}")
    public RegistroAguaModel putRegistroAgua(@PathVariable Long id, @RequestBody RegistroAguaModel registroAguaAtualizado) {
        RegistroAguaModel registroAgua = aguaRepository.findById(id).orElseThrow(()-> new RuntimeException("Erro ao atualizar o registro"));
        
        registroAgua.setDataHora(registroAguaAtualizado.getDataHora());
        registroAgua.setQuantidadeMl(registroAguaAtualizado.getQuantidadeMl());
        return aguaRepository.save(registroAgua);
    }
    
}