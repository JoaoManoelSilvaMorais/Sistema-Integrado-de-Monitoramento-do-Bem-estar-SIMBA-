package br.simba.bem_estar.perfil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import br.simba.bem_estar.exceptions.RegraDeNegocioException;

@ExtendWith(MockitoExtension.class)
class PerfilControllerTest {

    @Mock
    private PerfilService perfilService;

    @InjectMocks
    private PerfilController controller;

    @Test
    void crudPerfilEBuscaESalvamentoDeMedidas() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");

        PerfilModel perfil = new PerfilModel();
        perfil.setPeso(75.0);
        when(perfilService.criarPerfil(perfil, "joao")).thenReturn(perfil);
        ResponseEntity<PerfilModel> criado = controller.createPerfil(perfil, auth);
        assertEquals(HttpStatus.CREATED, criado.getStatusCode());

        when(perfilService.buscarPerfilDoUsuarioLogado("joao")).thenReturn(perfil);
        assertEquals(perfil, controller.getPerfilLogado(auth).getBody());

        when(perfilService.atualizarPerfilDoUsuarioLogado(perfil, "joao")).thenReturn(perfil);
        assertEquals(perfil, controller.updatePerfil(perfil, auth).getBody());

        MedidasResponseDTO esperado = MedidasResponseDTO.de(75.0, 1.80);
        when(perfilService.buscarMedidas("joao")).thenReturn(esperado);
        assertEquals(esperado, controller.getMedidas(auth).getBody());

        MedidasDTO entrada = new MedidasDTO(75.0, 1.80);
        when(perfilService.salvarMedidas("joao", entrada)).thenReturn(esperado);
        assertEquals(esperado, controller.salvarMedidas(entrada, auth).getBody());
    }

    @Test
    void previaMedidasCalculaSemSalvarEValidaLimites() {
        ResponseEntity<MedidasResponseDTO> resp = controller.previaMedidas(72.5, 1.75);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(23.7, resp.getBody().imc());
        assertEquals("Peso adequado", resp.getBody().classificacaoImc());

        assertThrows(RegraDeNegocioException.class, () -> controller.previaMedidas(70.0, 3.5));
    }
}
