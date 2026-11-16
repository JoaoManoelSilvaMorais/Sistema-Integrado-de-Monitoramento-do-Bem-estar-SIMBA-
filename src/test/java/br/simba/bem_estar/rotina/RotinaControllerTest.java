package br.simba.bem_estar.rotina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
class RotinaControllerTest {

    @Mock
    private RotinaService rotinaService;

    @InjectMocks
    private RotinaController rotinaController;

    private Authentication auth;

    @BeforeEach
    void prepararContexto() {
        auth = mock(Authentication.class);
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/api/rotinas");
        request.setScheme("http");
        request.setServerName("localhost");
        request.setServerPort(8080);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @AfterEach
    void limparContexto() {
        RequestContextHolder.resetRequestAttributes();
    }

    @Test
    void criarRetorna201ComLocationEBody() {
        when(auth.getName()).thenReturn("joao");
        UUID id = UUID.randomUUID();
        RotinaDTO dto = new RotinaDTO("Treinos", "Semana", true);
        RotinaResponseDTO esperado = new RotinaResponseDTO(id, "Treinos", "Semana", true, List.of());

        when(rotinaService.criar(dto, "joao")).thenReturn(esperado);

        ResponseEntity<RotinaResponseDTO> resp = rotinaController.criar(dto, auth);

        assertEquals(HttpStatus.CREATED, resp.getStatusCode());
        assertNotNull(resp.getHeaders().getLocation());
        assertEquals("http://localhost:8080/api/rotinas/" + id, resp.getHeaders().getLocation().toString());
        assertEquals(esperado, resp.getBody());
    }

    @Test
    void listarAtualizarExcluirEGerenciarLembretes() {
        when(auth.getName()).thenReturn("joao");
        UUID id = UUID.randomUUID();
        UUID lembreteId = UUID.randomUUID();
        RotinaResponseDTO rotina = new RotinaResponseDTO(id, "Leitura", "Noite", true, List.of());

        when(rotinaService.listar("joao")).thenReturn(List.of(rotina));
        assertEquals(List.of(rotina), rotinaController.listar(auth).getBody());

        RotinaDTO atualizarDto = new RotinaDTO("Leitura", "Antes de dormir", false);
        when(rotinaService.atualizar(id, atualizarDto, "joao")).thenReturn(rotina);
        assertEquals(HttpStatus.OK, rotinaController.atualizar(id, atualizarDto, auth).getStatusCode());

        ResponseEntity<Void> excluido = rotinaController.excluir(id, auth);
        assertEquals(HttpStatus.NO_CONTENT, excluido.getStatusCode());
        verify(rotinaService).excluir(id, "joao");

        RotinaLembreteDTO lembreteDto = new RotinaLembreteDTO("Ler", "", LocalTime.of(21, 0), List.of(1, 2));
        when(rotinaService.adicionarLembrete(id, lembreteDto, "joao")).thenReturn(rotina);
        assertEquals(HttpStatus.CREATED, rotinaController.adicionarLembrete(id, lembreteDto, auth).getStatusCode());

        when(rotinaService.removerLembrete(id, lembreteId, "joao")).thenReturn(rotina);
        assertEquals(HttpStatus.OK, rotinaController.removerLembrete(id, lembreteId, auth).getStatusCode());
    }

    @Test
    void exceptionHandlersRetornam404E400() {
        ResponseEntity<String> naoEncontrada = rotinaController.tratarNaoEncontrada(
                new RotinaNaoEncontradaException("Rotina não encontrada."));
        assertEquals(HttpStatus.NOT_FOUND, naoEncontrada.getStatusCode());
        assertEquals("Rotina não encontrada.", naoEncontrada.getBody());

        ResponseEntity<String> invalida = rotinaController.tratarDadosInvalidos(
                new IllegalArgumentException("O nome da rotina é obrigatório."));
        assertEquals(HttpStatus.BAD_REQUEST, invalida.getStatusCode());
        assertEquals("O nome da rotina é obrigatório.", invalida.getBody());
    }
}
