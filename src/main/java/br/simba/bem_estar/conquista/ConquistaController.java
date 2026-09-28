package br.simba.bem_estar.conquista;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conquistas")
public class ConquistaController {

    private final ConquistaService service;

    public ConquistaController(ConquistaService service) {
        this.service = service;
    }

    public record ConquistaResponse(
            Long id,
            String codigo,
            String titulo,
            String descricao,
            String icone,
            boolean desbloqueada,
            LocalDateTime dataDesbloqueio) {

        public static ConquistaResponse from(Conquista conquista) {
            return new ConquistaResponse(
                conquista.getId(),
                conquista.getCodigo(),
                conquista.getTitulo(),
                conquista.getDescricao(),
                conquista.getIcone(),
                conquista.isDesbloqueada(),
                conquista.getDataDesbloqueio()
            );
        }
    }

    @GetMapping
    public ResponseEntity<List<ConquistaResponse>> listar(
            Authentication authentication) {

        List<ConquistaResponse> conquistas =
                service.listar(authentication.getName())
                    .stream()
                    .map(ConquistaResponse::from)
                    .toList();

        return ResponseEntity.ok(conquistas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ConquistaResponse> buscar(
            @PathVariable String codigo,
            Authentication authentication) {

        try {
            Conquista conquista = service.buscarPorCodigo(
                authentication.getName(), codigo
            );

            return ResponseEntity.ok(
                ConquistaResponse.from(conquista)
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{codigo}/desbloquear")
    public ResponseEntity<?> desbloquear(
            @PathVariable String codigo,
            Authentication authentication) {

        try {
            Conquista conquista = service.desbloquear(
                authentication.getName(), codigo
            );

            return ResponseEntity.ok(
                ConquistaResponse.from(conquista)
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(java.util.Map.of("erro", e.getMessage()));
        }
    }
}