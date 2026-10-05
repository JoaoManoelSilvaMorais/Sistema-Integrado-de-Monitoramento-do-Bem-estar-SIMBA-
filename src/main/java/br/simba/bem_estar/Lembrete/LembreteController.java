package br.simba.bem_estar.lembrete;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    private final LembreteRepository lembreteRepository;
    private final UserRepository userRepository;

    LembreteController(LembreteRepository lembreteRepository, UserRepository userRepository) {
        this.lembreteRepository = lembreteRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<LembreteModel> criar(@RequestBody LembreteModel lembrete, Authentication authentication) {
        String username = authentication.getName();
        UserModel usuario = userRepository.findByUsername(username).orElseThrow();
        
        lembrete.setUsuario(usuario);
        LembreteModel novoLembrete = lembreteRepository.save(lembrete);
        return ResponseEntity.ok(novoLembrete);
    }

    @GetMapping
    public ResponseEntity<List<LembreteModel>> listar(Authentication authentication) {
        String username = authentication.getName();
        UserModel usuario = userRepository.findByUsername(username).orElseThrow();
        
        List<LembreteModel> lembretes = lembreteRepository.findByUsuario(usuario);
        return ResponseEntity.ok(lembretes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, Authentication authentication) {
        LembreteModel lembrete = lembreteRepository.findById(id).orElseThrow();
        
        String username = authentication.getName();
        if (!lembrete.getUsuario().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }

        lembreteRepository.delete(lembrete);
        return ResponseEntity.noContent().build();
    }
}