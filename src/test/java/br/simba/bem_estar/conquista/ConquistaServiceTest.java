package br.simba.bem_estar.conquista;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.meta.MetaAguaDTO;
import br.simba.bem_estar.meta.MetaAguaService;
import br.simba.bem_estar.rotina.RotinaLembreteModel;
import br.simba.bem_estar.rotina.RotinaModel;
import br.simba.bem_estar.rotina.RotinaRepository;
import br.simba.bem_estar.streak.StreakDTO;
import br.simba.bem_estar.streak.StreakService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class ConquistaServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private HistoricoService historicoService;

    @Mock
    private MetaAguaService metaAguaService;

    @Mock
    private RotinaRepository rotinaRepository;

    @Mock
    private ConquistaUsuarioRepository conquistaRepository;

    @Mock
    private StreakService streakService;

    @InjectMocks
    private ConquistaService conquistaService;

    private UserModel usuario;

    @BeforeEach
    void prepararUsuario() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
    }

    @Test
    void usuarioInexistenteLancaExcecao() {
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());

        assertThrows(DadoNaoEncontradoException.class, () -> conquistaService.listar("desconhecido"));
    }

    @Test
    void listarGravaNovasConquistasEPreservaJaDesbloqueadas() {
        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 12, 0);
        Historico historico = new Historico(
                List.of(new Historico.Agua(agora, 500)),
                List.of(),
                List.of()
        );

        RotinaModel rotina = new RotinaModel();
        rotina.setAtiva(true);
        rotina.getLembretes().add(new RotinaLembreteModel());

        // TREINO_PRIMEIRO foi desbloqueada no passado, mesmo sem treinos atuais no histórico
        ConquistaUsuarioModel antiga = new ConquistaUsuarioModel();
        antiga.setCodigo(Conquista.TREINO_PRIMEIRO.name());
        antiga.setDataDesbloqueio(agora.minusDays(5));
        antiga.setUsuario(usuario);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(historicoService.carregar(usuario)).thenReturn(historico);
        when(rotinaRepository.findByUsuarioId(1L)).thenReturn(List.of(rotina));
        when(streakService.obter("joao")).thenReturn(new StreakDTO(1, 1, true, false, 0, false, true, false, false));
        when(metaAguaService.resolver(usuario)).thenReturn(new MetaAguaDTO(2000, false, 2000, 0));
        when(conquistaRepository.findByUsuarioId(1L)).thenReturn(List.of(antiga));
        when(conquistaRepository.save(any(ConquistaUsuarioModel.class)))
                .thenAnswer(inv -> inv.getArgument(0));

        ConquistasResponseDTO resposta = conquistaService.listar("joao");

        assertEquals(Conquista.values().length, resposta.total());
        // AGUA_PRIMEIRO_GOLE, ROTINA_PRIMEIRA, ROTINA_LEMBRETE (novas) + TREINO_PRIMEIRO (antiga)
        assertEquals(4, resposta.desbloqueadas());
        verify(conquistaRepository, times(3)).save(any(ConquistaUsuarioModel.class));

        ConquistaDTO primeiroGole = buscar(resposta, Conquista.AGUA_PRIMEIRO_GOLE);
        assertTrue(primeiroGole.desbloqueada());
        assertTrue(primeiroGole.nova());
        assertNotNull(primeiroGole.dataDesbloqueio());

        ConquistaDTO treinoAntigo = buscar(resposta, Conquista.TREINO_PRIMEIRO);
        assertTrue(treinoAntigo.desbloqueada());
        assertFalse(treinoAntigo.nova());
        assertEquals(agora.minusDays(5), treinoAntigo.dataDesbloqueio());
    }

    @Test
    void consultarNaoGravaNoBanco() {
        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 12, 0);
        Historico historico = new Historico(
                List.of(new Historico.Agua(agora, 500)),
                List.of(),
                List.of()
        );

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(historicoService.carregar(usuario)).thenReturn(historico);
        when(rotinaRepository.findByUsuarioId(1L)).thenReturn(List.of());
        when(streakService.obter("joao")).thenReturn(new StreakDTO(1, 1, true, false, 0, false, true, false, false));
        when(metaAguaService.resolver(usuario)).thenReturn(new MetaAguaDTO(2000, false, 2000, 0));
        when(conquistaRepository.findByUsuarioId(1L)).thenReturn(List.of());

        ConquistasResponseDTO resposta = conquistaService.consultar("joao");

        verify(conquistaRepository, never()).save(any());
        ConquistaDTO primeiroGole = buscar(resposta, Conquista.AGUA_PRIMEIRO_GOLE);
        assertTrue(primeiroGole.desbloqueada());
        assertFalse(primeiroGole.nova());
        assertNull(primeiroGole.dataDesbloqueio());
    }

    private static ConquistaDTO buscar(ConquistasResponseDTO resposta, Conquista c) {
        return resposta.conquistas().stream()
                .filter(item -> item.codigo().equals(c.name()))
                .findFirst()
                .orElseThrow();
    }
}
