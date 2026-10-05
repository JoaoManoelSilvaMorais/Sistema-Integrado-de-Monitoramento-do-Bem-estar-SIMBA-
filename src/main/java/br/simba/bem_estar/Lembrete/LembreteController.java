package br.simba.bem_estar.lembrete;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
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
        UserModel usuario = userRepository.findByUsername(username).orElseThrow(()-> new DadoNaoEncontradoException("Usuário não encontrado com o username: " + username));
        //se o titulo tiver em branco retorna um erro
        if (lembrete.getTitulo() == null || lembrete.getTitulo().isBlank()) {
             throw new RegraDeNegocioException("O título do lembrete não pode ficar em branco.");
             }


        lembrete.setUsuario(usuario);
        LembreteModel novoLembrete = lembreteRepository.save(lembrete);
        return ResponseEntity.ok(novoLembrete);
    }

    @GetMapping
    public ResponseEntity<List<LembreteModel>> listar(Authentication authentication) {
        String username = authentication.getName();
        UserModel usuario = userRepository.findByUsername(username).orElseThrow(()-> new DadoNaoEncontradoException("usuario não encontrado com o username:"+ username));
        
        List<LembreteModel> lembretes = lembreteRepository.findByUsuario(usuario);
        return ResponseEntity.ok(lembretes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, Authentication authentication) {
        LembreteModel lembrete = lembreteRepository.findById(id).orElseThrow();
        
        // Validação simples para garantir que o lembrete pertence ao utilizador logado
        String username = authentication.getName();
        if (!lembrete.getUsuario().getUsername().equals(username)) {
            throw new AcessoNegadoException("Você não tem permissão para apagar este lembrete.");
        }

        lembreteRepository.delete(lembrete);
        return ResponseEntity.noContent().build();
    }
}