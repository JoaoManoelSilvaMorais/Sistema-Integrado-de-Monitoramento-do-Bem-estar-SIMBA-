package br.simba.bem_estar.sintoma;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Questionário diário "Sinais Corporais". Tudo é sempre do usuário autenticado. */
@RestController
@RequestMapping("/api/sintomas")
public class RegistroSintomaController {

    private final RegistroSintomaService service;

    public RegistroSintomaController(RegistroSintomaService service) {
        this.service = service;
    }

    // Salva o questionário de hoje (se já respondeu hoje, atualiza).
    @PostMapping
    public ResponseEntity<RegistroSintomaResponseDTO> salvar(
            @RequestBody RegistroSintomaDTO dados, Authentication authentication) {
        return ResponseEntity.ok(service.salvarHoje(authentication.getName(), dados));
    }

    // Histórico dos últimos 30 dias (mais recente primeiro) + resumo da semana.
    @GetMapping
    public ResponseEntity<SintomaHistoricoDTO> listar(Authentication authentication) {
        return ResponseEntity.ok(service.historico(authentication.getName()));
    }

    // Diz se hoje já foi respondido (a tela decide entre formulário e resumo).
    @GetMapping("/hoje")
    public ResponseEntity<SintomaHojeDTO> hoje(Authentication authentication) {
        return ResponseEntity.ok(service.hoje(authentication.getName()));
    }
}
