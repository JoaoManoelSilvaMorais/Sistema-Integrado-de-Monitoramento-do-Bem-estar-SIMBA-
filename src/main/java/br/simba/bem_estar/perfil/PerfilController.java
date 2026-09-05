package br.simba.bem_estar.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired 
    private PerfilRepository perfilRepository;


    @PostMapping("/perfil")
    public PerfilModel createPerfil(@RequestBody PerfilModel perfilModel){
        return perfilRepository.save(perfilModel);

    }
    
    @GetMapping("/perfil/{id}")
    public PerfilModel getPerflById(@PathVariable Long id){

        return perfilRepository.findById(id).orElseThrow(()->new RuntimeException("Perfil não encrontrado"));
    }
}
