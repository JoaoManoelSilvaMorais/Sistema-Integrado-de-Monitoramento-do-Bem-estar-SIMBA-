package br.simba.bem_estar.comparativo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comparativo")
public class ComparativoController {

    private final ComparativoService comparativoService;

    public ComparativoController(ComparativoService comparativoService) {
        this.comparativoService = comparativoService;
    }

    @GetMapping
    public ResponseEntity<ComparativoDTO> obter(Authentication authentication) {
        return ResponseEntity.ok(comparativoService.obter(authentication.getName()));
    }
}
