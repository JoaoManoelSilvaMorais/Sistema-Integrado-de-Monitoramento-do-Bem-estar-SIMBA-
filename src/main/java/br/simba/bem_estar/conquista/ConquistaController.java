package br.simba.bem_estar.conquista;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conquistas")
public class ConquistaController {

    private final ConquistaService conquistaService;

    public ConquistaController(ConquistaService conquistaService) {
        this.conquistaService = conquistaService;
    }

    @GetMapping
    public ResponseEntity<ConquistasResponseDTO> listar(Authentication authentication) {
        return ResponseEntity.ok(conquistaService.listar(authentication.getName()));
    }
}
