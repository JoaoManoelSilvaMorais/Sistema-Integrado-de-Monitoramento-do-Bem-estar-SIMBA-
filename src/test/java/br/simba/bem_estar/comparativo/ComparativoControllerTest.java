package br.simba.bem_estar.comparativo;

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
class ComparativoControllerTest {

    @Mock
    private ComparativoService comparativoService;

    @InjectMocks
    private ComparativoController controller;

    @Test
    void obterRetornaComparativoDoUsuarioLogado() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");

        var m = new ComparativoDTO.Metrica(2000, 1000, 100, "subiu");
        ComparativoDTO esperado = new ComparativoDTO(m, m, m, m);
        when(comparativoService.obter("joao")).thenReturn(esperado);

        ResponseEntity<ComparativoDTO> resp = controller.obter(auth);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(esperado, resp.getBody());
    }
}
