package br.simba.bem_estar.perfil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    // CREATE (Criar perfil do usuário autenticado)
    @PostMapping
    public ResponseEntity<PerfilModel> createPerfil(
            @RequestBody PerfilModel perfilModel,
            Authentication authentication
    ) {
        String username = authentication.getName();
        PerfilModel novoPerfil = perfilService.criarPerfil(perfilModel, username);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPerfil);
    }

    // READ (Buscar o próprio perfil sem expor IDs vulneráveis na URL)
    @GetMapping("/me")
    public ResponseEntity<PerfilModel> getPerfilLogado(
            Authentication authentication
    ) {
        String username = authentication.getName();
        PerfilModel perfil = perfilService.buscarPerfilDoUsuarioLogado(username);

        return ResponseEntity.ok(perfil);
    }

    // UPDATE (Atualizar o próprio perfil)
    @PutMapping("/me")
    public ResponseEntity<PerfilModel> updatePerfil(
            @RequestBody PerfilModel perfilAtualizado,
            Authentication authentication
    ) {
        String username = authentication.getName();
        PerfilModel perfilAtual =
                perfilService.atualizarPerfilDoUsuarioLogado(perfilAtualizado, username);

        return ResponseEntity.ok(perfilAtual);
    }

    // Peso e altura do usuário logado (campos nulos = ainda não informados)
    @GetMapping("/me/medidas")
    public ResponseEntity<MedidasResponseDTO> getMedidas(Authentication authentication) {
        return ResponseEntity.ok(perfilService.buscarMedidas(authentication.getName()));
    }

    // Adiciona ou edita peso (kg) e altura (m); cria o perfil se ainda não existir
    @PutMapping("/me/medidas")
    public ResponseEntity<MedidasResponseDTO> salvarMedidas(
            @RequestBody MedidasDTO dados,
            Authentication authentication
    ) {
        return ResponseEntity.ok(perfilService.salvarMedidas(authentication.getName(), dados));
    }

    // Prévia: IMC e sugestões de metas para os valores digitados no popup (não salva nada)
    @GetMapping("/me/medidas/previa")
    public ResponseEntity<MedidasResponseDTO> previaMedidas(
            @RequestParam(required = false) Double peso,
            @RequestParam(required = false) Double altura
    ) {
        MedidasCalculator.validar(peso, altura);
        return ResponseEntity.ok(MedidasResponseDTO.de(peso, altura));
    }
}