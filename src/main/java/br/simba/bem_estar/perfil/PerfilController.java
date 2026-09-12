package br.simba.bem_estar.perfil;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @PostMapping("/")
    public PerfilModel createPerfil(@RequestBody PerfilModel perfilModel){
        return perfilRepository.save(perfilModel);

    }
    
    @GetMapping("/{id}")
    public PerfilModel getPerflById(@PathVariable Long id){

        return perfilRepository.findById(id).orElseThrow(()->new RuntimeException("Perfil não encrontrado"));
    }
}
