package br.simba.bem_estar.rotina;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/rotinas")
public class RotinaController {

    private final RotinaService rotinaService;

    public RotinaController(RotinaService rotinaService) {
        this.rotinaService = rotinaService;
    }

    @PostMapping
    public ResponseEntity<RotinaResponseDTO> criar(
            @RequestBody RotinaDTO dados,
            Authentication authentication) {
        RotinaResponseDTO resposta = rotinaService.criar(dados, authentication.getName());
        URI local = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resposta.id())
                .toUri();
        return ResponseEntity.created(local).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<RotinaResponseDTO>> listar(Authentication authentication) {
        return ResponseEntity.ok(rotinaService.listar(authentication.getName()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotinaResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody RotinaDTO dados,
            Authentication authentication) {
        return ResponseEntity.ok(
                rotinaService.atualizar(id, dados, authentication.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable UUID id,
            Authentication authentication) {
        rotinaService.excluir(id, authentication.getName());
        return ResponseEntity.noContent().build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RotinaNaoEncontradaException.class)
    public ResponseEntity<String> tratarNaoEncontrada(RotinaNaoEncontradaException erro) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarDadosInvalidos(IllegalArgumentException erro) {
        return ResponseEntity.badRequest().body(erro.getMessage());
    }
}
