package br.simba.bem_estar.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.DadosDuplicadosException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class MetaServiceTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Mock
    private UserRepository userRepository;

    @Mock
    private MetaRepository metaRepository;

    @Mock
    private HistoricoService historicoService;

    @Mock
    private MetaAguaService metaAguaService;

    @InjectMocks
    private MetaService metaService;

    private UserModel usuario;

    @BeforeEach
    void prepararUsuario() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
    }

    @Test
    void listarMarcaConcluidasComGravarTrueEOrdenaAtivasAntesDasConcluidas() {
        LocalDate hoje = LocalDate.now(FUSO);

        MetaModel ativaEmAndamento = new MetaModel();
        ReflectionTestUtils.setField(ativaEmAndamento, "id", 10L);
        ativaEmAndamento.setTipo(TipoMeta.TREINO_TOTAL);
        ativaEmAndamento.setAlvo(4);
        ativaEmAndamento.setDataInicio(hoje.minusDays(5));
        ativaEmAndamento.setUsuario(usuario);

        MetaModel recemCumprida = new MetaModel();
        ReflectionTestUtils.setField(recemCumprida, "id", 11L);
        recemCumprida.setTipo(TipoMeta.AGUA_SEGUIDOS);
        recemCumprida.setAlvo(2);
        recemCumprida.setDataInicio(hoje.minusDays(3));
        recemCumprida.setUsuario(usuario);

        Historico historico = new Historico(
                List.of(
                        new Historico.Agua(hoje.minusDays(1).atTime(10, 0), 2000),
                        new Historico.Agua(hoje.atTime(10, 0), 2000)
                ),
                List.of(),
                List.of(new Historico.Treino("Corrida", 30, 250, hoje.atTime(8, 0)))
        );

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(historicoService.carregar(usuario)).thenReturn(historico);
        when(metaAguaService.resolver(usuario)).thenReturn(new MetaAguaDTO(2000, false, 2000, 0));
        when(metaRepository.findByUsuarioId(1L)).thenReturn(List.of(recemCumprida, ativaEmAndamento));

        List<MetaDTO> lista = metaService.listar("joao", true);

        assertEquals(2, lista.size());
        // Ativa primeiro, depois recém-concluída
        assertEquals(10L, lista.get(0).id());
        assertFalse(lista.get(0).concluida());
        assertEquals(1, lista.get(0).progressoAtual());

        assertEquals(11L, lista.get(1).id());
        assertTrue(lista.get(1).concluida());
        assertTrue(lista.get(1).nova());
        assertNotNull(lista.get(1).concluidaEm());
        verify(metaRepository).save(recemCumprida);
    }

    @Test
    void criarUsaAlvoPadraoQuandoNuloERetornaMetaCriada() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        MetaModel metaSalva = new MetaModel();
        ReflectionTestUtils.setField(metaSalva, "id", 55L);
        metaSalva.setTipo(TipoMeta.TREINO_TOTAL);
        metaSalva.setAlvo(TipoMeta.TREINO_TOTAL.getPadrao());
        metaSalva.setDataInicio(LocalDate.now(FUSO));
        metaSalva.setUsuario(usuario);

        when(metaRepository.findByUsuarioId(1L))
                .thenReturn(List.of())
                .thenReturn(List.of(metaSalva));
        when(metaRepository.save(any(MetaModel.class))).thenAnswer(inv -> {
            MetaModel m = inv.getArgument(0);
            ReflectionTestUtils.setField(m, "id", 55L);
            return m;
        });
        when(historicoService.carregar(usuario)).thenReturn(new Historico(List.of(), List.of(), List.of()));
        when(metaAguaService.resolver(usuario)).thenReturn(new MetaAguaDTO(2000, false, 2000, 0));

        MetaDTO criada = metaService.criar("joao", new MetaCriarDTO("treino_total", null));

        assertEquals(55L, criada.id());
        assertEquals(TipoMeta.TREINO_TOTAL.getPadrao(), criada.alvo());
        assertEquals("Fazer 10 treinos", criada.titulo());
    }

    @Test
    void criarValidaTipoInvalidoAlvoForaDosLimitesLimiteDeAtivasEDuplicidade() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        assertThrows(RegraDeNegocioException.class,
                () -> metaService.criar("joao", new MetaCriarDTO("INEXISTENTE", 5)));
        assertThrows(RegraDeNegocioException.class,
                () -> metaService.criar("joao", new MetaCriarDTO("TREINO_TOTAL", 1)));
        assertThrows(RegraDeNegocioException.class,
                () -> metaService.criar("joao", new MetaCriarDTO("TREINO_TOTAL", 301)));

        MetaModel ativa = new MetaModel();
        ativa.setTipo(TipoMeta.TREINO_TOTAL);
        when(metaRepository.findByUsuarioId(1L)).thenReturn(List.of(ativa));

        assertThrows(DadosDuplicadosException.class,
                () -> metaService.criar("joao", new MetaCriarDTO("TREINO_TOTAL", 5)));

        List<MetaModel> cincoAtivas = List.of(ativa, ativa, ativa, ativa, ativa);
        when(metaRepository.findByUsuarioId(1L)).thenReturn(cincoAtivas);

        assertThrows(RegraDeNegocioException.class,
                () -> metaService.criar("joao", new MetaCriarDTO("AGUA_SEGUIDOS", 5)));
    }

    @Test
    void excluirRemoveMetaExistenteELancaSeNaoEncontrada() {
        MetaModel meta = new MetaModel();
        ReflectionTestUtils.setField(meta, "id", 99L);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(metaRepository.findByIdAndUsuarioId(99L, 1L)).thenReturn(Optional.of(meta));
        when(metaRepository.findByIdAndUsuarioId(100L, 1L)).thenReturn(Optional.empty());

        metaService.excluir("joao", 99L);
        verify(metaRepository).delete(meta);

        assertThrows(DadoNaoEncontradoException.class, () -> metaService.excluir("joao", 100L));
        verify(metaRepository, never()).deleteById(any());
    }
}
