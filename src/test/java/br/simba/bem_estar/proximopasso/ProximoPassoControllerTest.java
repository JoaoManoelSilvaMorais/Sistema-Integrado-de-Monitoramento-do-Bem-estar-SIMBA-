package br.simba.bem_estar.proximopasso;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@ExtendWith(MockitoExtension.class)
class ProximoPassoControllerTest {

    @Mock
    private ProximoPassoService proximoPassoService;

    @InjectMocks
    private ProximoPassoController controller;

    @Test
    void obterRetornaSugestaoDoUsuarioLogado() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");

        ProximoPassoDTO esperado = new ProximoPassoDTO("ok", "Tudo em dia por hoje. Continue assim!", null, "fa-circle-check");
        when(proximoPassoService.obter("joao")).thenReturn(esperado);

        ResponseEntity<ProximoPassoDTO> resp = controller.obter(auth);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(esperado, resp.getBody());
    }
}
