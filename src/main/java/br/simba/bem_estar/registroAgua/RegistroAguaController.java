package br.simba.bem_estar.registroAgua;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.core.Authentication;




@RestController 
@RequestMapping("/registroAgua")
public class RegistroAguaController {

    private final RegistroAguaRepository aguaRepository;
    private final UserRepository userRepository;

    public RegistroAguaController(RegistroAguaRepository aguaRepository, UserRepository userRepository) {
        this.aguaRepository = aguaRepository;
        this.userRepository = userRepository;
    }


    
    //postar dados
    @PostMapping({"", "/"})
    public RegistroAguaModel createRegistroAgua(@RequestBody RegistroAguaModel registroAgua, Authentication authentication) {
        UserModel usuario = usuarioAutenticado(authentication);
        registroAgua.setUsuario(usuario);
        return aguaRepository.save(registroAgua);
    }
    


    //pegar todos os item
    @GetMapping({"", "/"})
    public List<RegistroAguaModel> getAllRegistroAgua(Authentication authentication){
        return aguaRepository.findByUsuario(usuarioAutenticado(authentication));
    }
    //pegar item por id
    @GetMapping("/{id}")
    public RegistroAguaModel getRegistroAgua(@PathVariable Long id, Authentication authentication) {
        RegistroAguaModel registro = buscarRegistro(id);
        validarProprietario(registro, authentication);
        return registro;
    }

    //deletar item
    @DeleteMapping("/{id}")
    public void deleteRegistroAgua(@PathVariable Long id, Authentication authentication){
        RegistroAguaModel registro = buscarRegistro(id);
        validarProprietario(registro, authentication);
        aguaRepository.delete(registro);
    }

    //atualizar os dados

    @PutMapping("/{id}")
    public RegistroAguaModel putRegistroAgua(@PathVariable Long id, @RequestBody RegistroAguaModel registroAguaAtualizado, Authentication authentication) {
        RegistroAguaModel registroAgua = buscarRegistro(id);
        validarProprietario(registroAgua, authentication);
        
        registroAgua.setDataHora(registroAguaAtualizado.getDataHora());
        registroAgua.setQuantidadeMl(registroAguaAtualizado.getQuantidadeMl());
        return aguaRepository.save(registroAgua);
    }

    private UserModel usuarioAutenticado(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private RegistroAguaModel buscarRegistro(Long id) {
        return aguaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    private void validarProprietario(RegistroAguaModel registro, Authentication authentication) {
        if (!registro.getUsuario().getUsername().equals(authentication.getName())) {
            throw new org.springframework.security.access.AccessDeniedException("Registro não pertence ao usuário");
        }
    }
    
}