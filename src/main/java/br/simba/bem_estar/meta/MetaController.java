package br.simba.bem_estar.meta;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    private final MetaService metaService;
    private final MetaAguaService metaAguaService;

    public MetaController(MetaService metaService, MetaAguaService metaAguaService) {
        this.metaService = metaService;
        this.metaAguaService = metaAguaService;
    }

    // Lista as metas e marca como concluídas as que acabaram de ser cumpridas.
    @GetMapping
    public ResponseEntity<List<MetaDTO>> listar(Authentication authentication) {
        return ResponseEntity.ok(metaService.listar(authentication.getName(), true));
    }

    @PostMapping
    public ResponseEntity<MetaDTO> criar(@RequestBody MetaCriarDTO dados, Authentication authentication) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(metaService.criar(authentication.getName(), dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id, Authentication authentication) {
        metaService.excluir(authentication.getName(), id);
        return ResponseEntity.noContent().build();
    }

    // Meta diária de água (a do usuário ou a sugerida pelo peso).
    @GetMapping("/agua")
    public ResponseEntity<MetaAguaDTO> obterAgua(Authentication authentication) {
        return ResponseEntity.ok(metaAguaService.obter(authentication.getName()));
    }

    @PutMapping("/agua")
    public ResponseEntity<MetaAguaDTO> definirAgua(
            @RequestBody MetaAguaAtualizarDTO dados, Authentication authentication) {
        return ResponseEntity.ok(metaAguaService.definir(authentication.getName(), dados.metaMl()));
    }
}
