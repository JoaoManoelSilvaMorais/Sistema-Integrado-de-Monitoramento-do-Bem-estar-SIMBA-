package br.simba.bem_estar.Lembrete;

import br.simba.bem_estar.model.LembreteModel;
import br.simba.bem_estar.model.UserModel;
import br.simba.bem_estar.repository.LembreteRepository;
import br.simba.bem_estar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE (Criar)
    @PostMapping
    public ResponseEntity<LembreteModel> criar(@RequestBody LembreteModel lembrete, Authentication authentication) {
        String email = authentication.getName();
        UserModel usuario = userRepository.findByEmail(email).orElseThrow();
        
        lembrete.setUsuario(usuario);
        LembreteModel novoLembrete = lembreteRepository.save(lembrete);
        return ResponseEntity.ok(novoLembrete);
    }

    // READ (Listar do utilizador logado)
    @GetMapping
    public ResponseEntity<List<LembreteModel>> listar(Authentication authentication) {
        String email = authentication.getName();
        UserModel usuario = userRepository.findByEmail(email).orElseThrow();
        
        List<LembreteModel> lembretes = lembreteRepository.findByUsuario(usuario);
        return ResponseEntity.ok(lembretes);
    }

    // DELETE (Apagar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, Authentication authentication) {
        LembreteModel lembrete = lembreteRepository.findById(id).orElseThrow();
        
        // Validação simples para garantir que o lembrete pertence ao utilizador logado
        String email = authentication.getName();
        if (!lembrete.getUsuario().getEmail().equals(email)) {
            return ResponseEntity.status(403).build();
        }

        lembreteRepository.delete(lembrete);
        return ResponseEntity.noContent().build();
    }
}