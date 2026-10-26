package br.simba.bem_estar.proximopasso;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proximo-passo")
public class ProximoPassoController {

    private final ProximoPassoService proximoPassoService;

    public ProximoPassoController(ProximoPassoService proximoPassoService) {
        this.proximoPassoService = proximoPassoService;
    }

    @GetMapping
    public ResponseEntity<ProximoPassoDTO> obter(Authentication authentication) {
        return ResponseEntity.ok(proximoPassoService.obter(authentication.getName()));
    }
}
