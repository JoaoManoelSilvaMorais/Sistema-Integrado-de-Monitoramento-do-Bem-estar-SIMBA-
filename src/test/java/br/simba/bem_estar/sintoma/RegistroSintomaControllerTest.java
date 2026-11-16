package br.simba.bem_estar.sintoma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

@ExtendWith(MockitoExtension.class)
class RegistroSintomaControllerTest {

    @Mock
    private RegistroSintomaService service;

    @InjectMocks
    private RegistroSintomaController controller;

    private Authentication auth;

    @BeforeEach
    void preparar() {
        auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");
    }

    @Test
    void salvarListarEHojeDelegamParaService() {
        LocalDate hoje = LocalDate.of(2026, 11, 10);
        RegistroSintomaDTO entrada = new RegistroSintomaDTO(4, 4, 2, "NENHUMA", null, List.of("NENHUM"), null);
        RegistroSintomaResponseDTO respostaDto = new RegistroSintomaResponseDTO(
                1L, hoje, 4, 4, 2, "NENHUMA", List.of(), List.of("NENHUM"), null);

        when(service.salvarHoje("joao", entrada)).thenReturn(respostaDto);
        ResponseEntity<RegistroSintomaResponseDTO> salvo = controller.salvar(entrada, auth);
        assertEquals(HttpStatus.OK, salvo.getStatusCode());
        assertEquals(respostaDto, salvo.getBody());

        SintomaHistoricoDTO historico = new SintomaHistoricoDTO(
                List.of(respostaDto), new SintomaResumoDTO(1, 4.0, 4.0, 2.0, 0, null, 0, "ok"));
        when(service.historico("joao")).thenReturn(historico);
        assertEquals(historico, controller.listar(auth).getBody());

        SintomaHojeDTO hojeDto = new SintomaHojeDTO(true, hoje, respostaDto);
        when(service.hoje("joao")).thenReturn(hojeDto);
        assertEquals(hojeDto, controller.hoje(auth).getBody());
    }
}
