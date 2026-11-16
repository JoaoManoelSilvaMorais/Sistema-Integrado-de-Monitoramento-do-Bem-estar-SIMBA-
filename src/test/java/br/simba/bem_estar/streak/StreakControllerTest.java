package br.simba.bem_estar.streak;

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
class StreakControllerTest {

    @Mock
    private StreakService streakService;

    @InjectMocks
    private StreakController controller;

    @Test
    void obterRetornaStreakDoUsuarioLogado() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");

        StreakDTO esperado = new StreakDTO(5, 10, true, false, 0, false, true, true, false);
        when(streakService.obter("joao")).thenReturn(esperado);

        ResponseEntity<StreakDTO> resp = controller.obter(auth);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(esperado, resp.getBody());
    }
}
