package br.simba.bem_estar.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
class MetaControllerTest {

    @Mock
    private MetaService metaService;

    @Mock
    private MetaAguaService metaAguaService;

    @InjectMocks
    private MetaController controller;

    private Authentication auth;

    @BeforeEach
    void preparar() {
        auth = mock(Authentication.class);
        when(auth.getName()).thenReturn("joao");
    }

    @Test
    void listarCriarEExcluirMetas() {
        MetaDTO meta = new MetaDTO(1L, "TREINO_TOTAL", "Fazer 10 treinos", "fa-person-running",
                10, 2, 2, "treinos", false, LocalDate.now(), null, false, 15);
        when(metaService.listar("joao", true)).thenReturn(List.of(meta));

        ResponseEntity<List<MetaDTO>> listagem = controller.listar(auth);
        assertEquals(HttpStatus.OK, listagem.getStatusCode());
        assertEquals(1, listagem.getBody().size());

        MetaCriarDTO criarDto = new MetaCriarDTO("TREINO_TOTAL", 10);
        when(metaService.criar("joao", criarDto)).thenReturn(meta);
        ResponseEntity<MetaDTO> criada = controller.criar(criarDto, auth);
        assertEquals(HttpStatus.CREATED, criada.getStatusCode());
        assertEquals(meta, criada.getBody());

        ResponseEntity<Void> excluida = controller.excluir(1L, auth);
        assertEquals(HttpStatus.NO_CONTENT, excluida.getStatusCode());
        verify(metaService).excluir("joao", 1L);
    }

    @Test
    void obterEDefinirMetaDeAgua() {
        MetaAguaDTO agua = new MetaAguaDTO(2500, true, 2450, 70.0);
        when(metaAguaService.obter("joao")).thenReturn(agua);
        assertEquals(agua, controller.obterAgua(auth).getBody());

        when(metaAguaService.definir("joao", 2500)).thenReturn(agua);
        assertEquals(agua, controller.definirAgua(new MetaAguaAtualizarDTO(2500), auth).getBody());
    }
}
