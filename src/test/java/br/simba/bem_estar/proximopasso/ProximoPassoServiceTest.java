package br.simba.bem_estar.proximopasso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.simba.bem_estar.conquista.ConquistaService;
import br.simba.bem_estar.conquista.ConquistasResponseDTO;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.meta.MetaAguaDTO;
import br.simba.bem_estar.meta.MetaAguaService;
import br.simba.bem_estar.meta.MetaService;
import br.simba.bem_estar.streak.StreakDTO;
import br.simba.bem_estar.streak.StreakService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class ProximoPassoServiceTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Mock
    private UserRepository userRepository;
    @Mock
    private HistoricoService historicoService;
    @Mock
    private StreakService streakService;
    @Mock
    private MetaAguaService metaAguaService;
    @Mock
    private MetaService metaService;
    @Mock
    private ConquistaService conquistaService;

    @InjectMocks
    private ProximoPassoService proximoPassoService;

    @Test
    void usuarioInexistenteLancaExcecao() {
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());

        assertThrows(DadoNaoEncontradoException.class, () -> proximoPassoService.obter("desconhecido"));
    }

    @Test
    void somaAguaDeHojeEConsultaMetasEConquistasSemGravar() {
        UserModel usuario = new UserModel();
        usuario.setUsername("joao");
        LocalDate hoje = LocalDate.now(FUSO);

        Historico historico = new Historico(
                List.of(
                        new Historico.Agua(hoje.atTime(8, 0), 500),
                        new Historico.Agua(hoje.atTime(12, 0), 700),
                        new Historico.Agua(hoje.minusDays(1).atTime(12, 0), 2000), // ontem -> ignorado
                        new Historico.Agua(hoje.atTime(15, 0), -100)               // negativo -> ignorado
                ),
                List.of(),
                List.of()
        );

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(historicoService.carregar(usuario)).thenReturn(historico);
        when(streakService.obter("joao"))
                .thenReturn(new StreakDTO(2, 2, true, false, 0, false, true, false, false));
        when(metaAguaService.resolver(usuario)).thenReturn(new MetaAguaDTO(2000, false, 2000, 0));
        when(metaService.listar("joao", false)).thenReturn(List.of());
        when(conquistaService.consultar("joao")).thenReturn(new ConquistasResponseDTO(0, 0, List.of()));

        ProximoPassoDTO dto = proximoPassoService.obter("joao");

        assertEquals("agua", dto.tipo());
        assertTrue(dto.texto().contains("800 ml")); // 2000 - (500 + 700)
        verify(metaService).listar("joao", false);
        verify(conquistaService).consultar("joao");
    }
}
