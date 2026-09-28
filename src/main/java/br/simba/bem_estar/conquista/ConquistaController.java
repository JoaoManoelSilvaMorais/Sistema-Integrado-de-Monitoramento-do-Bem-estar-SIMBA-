package br.simba.bem_estar.conquista;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            UUID id,
            String nome,
            String descricao,
            int metaNecessaria) {

        public static ConquistaResponse from(Conquista conquista) {
            return new ConquistaResponse(
                    conquista.getId(),
                    conquista.getNome(),
                    conquista.getDescricao(),
                    conquista.getMetaNecessaria());
        }
    }

    @GetMapping
    public ResponseEntity<List<ConquistaResponse>> listar() {
        List<ConquistaResponse> conquistas = service.listar()
                .stream()
                .map(ConquistaResponse::from)
                .toList();

        return ResponseEntity.ok(conquistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConquistaResponse> buscar(@PathVariable UUID id) {
        try {
            Conquista conquista = service.buscarPorId(id);
            return ResponseEntity.ok(ConquistaResponse.from(conquista));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
