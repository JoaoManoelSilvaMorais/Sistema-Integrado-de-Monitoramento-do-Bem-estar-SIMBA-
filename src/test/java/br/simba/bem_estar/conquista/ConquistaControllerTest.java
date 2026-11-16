package br.simba.bem_estar.conquista;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

@ExtendWith(MockitoExtension.class)
class ConquistaControllerTest {

    @Mock
    private ConquistaService conquistaService;

    @InjectMocks
    private ConquistaController controller;

    @Test
    void listarRetornaConquistasDoUsuarioLogado() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");

        ConquistasResponseDTO esperado = new ConquistasResponseDTO(3, 26, List.of());
        when(conquistaService.listar("joao")).thenReturn(esperado);

        ResponseEntity<ConquistasResponseDTO> resp = controller.listar(auth);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(esperado, resp.getBody());
    }
}
