package br.simba.bem_estar.rotina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class RotinaServiceTest {

    @Mock
    private RotinaRepository rotinaRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RotinaService rotinaService;

    private UserModel usuario;

    @BeforeEach
    void prepararUsuario() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
    }

    @Test
    void criarNormalizaTextoEDefineAtivaPadraoComoTrue() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(rotinaRepository.save(any(RotinaModel.class))).thenAnswer(inv -> {
            RotinaModel r = inv.getArgument(0);
            ReflectionTestUtils.setField(r, "id", UUID.randomUUID());
            return r;
        });

        RotinaResponseDTO padrao = rotinaService.criar(new RotinaDTO("  Treinos  ", "  Academia ", null), "joao");
        assertEquals("Treinos", padrao.nome());
        assertEquals("Academia", padrao.descricao());
        assertTrue(padrao.ativa());

        RotinaResponseDTO inativa = rotinaService.criar(new RotinaDTO("Meditação", null, false), "joao");
        assertEquals("", inativa.descricao());
        assertFalse(inativa.ativa());
    }

    @Test
    void criarSemNomeLancaIllegalArgumentException() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        assertThrows(IllegalArgumentException.class, () -> rotinaService.criar(new RotinaDTO("  ", "desc", true), "joao"));
        assertThrows(IllegalArgumentException.class, () -> rotinaService.criar(null, "joao"));
    }

    @Test
    void listarOrdenaLembretesPorHorario() {
        UUID rotinaId = UUID.randomUUID();
        RotinaModel rotina = new RotinaModel();
        ReflectionTestUtils.setField(rotina, "id", rotinaId);
        rotina.setNome("Dia");
        rotina.setDescricao("");
        rotina.setAtiva(true);

        RotinaLembreteModel tarde = new RotinaLembreteModel();
        ReflectionTestUtils.setField(tarde, "id", UUID.randomUUID());
        tarde.setTitulo("Tarde");
        tarde.setHora(LocalTime.of(18, 0));
        tarde.setDiasSemana("1,3");

        RotinaLembreteModel manha = new RotinaLembreteModel();
        ReflectionTestUtils.setField(manha, "id", UUID.randomUUID());
        manha.setTitulo("Manhã");
        manha.setHora(LocalTime.of(7, 0));
        manha.setDiasSemana("1,2,3,4,5");

        rotina.getLembretes().add(tarde);
        rotina.getLembretes().add(manha);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(rotinaRepository.findByUsuarioId(1L)).thenReturn(List.of(rotina));

        List<RotinaResponseDTO> lista = rotinaService.listar("joao");

        assertEquals(1, lista.size());
        assertEquals("Manhã", lista.get(0).lembretes().get(0).titulo());
        assertEquals("Tarde", lista.get(0).lembretes().get(1).titulo());
        assertEquals(List.of(1, 2, 3, 4, 5), lista.get(0).lembretes().get(0).diasSemana());
    }

    @Test
    void atualizarPreservaEstadoAtivaQuandoNuloEValidaExistencia() {
        UUID rotinaId = UUID.randomUUID();
        RotinaModel rotina = new RotinaModel();
        ReflectionTestUtils.setField(rotina, "id", rotinaId);
        rotina.setNome("Antiga");
        rotina.setAtiva(false);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(rotinaRepository.findByIdAndUsuarioId(rotinaId, 1L)).thenReturn(Optional.of(rotina));
        when(rotinaRepository.save(rotina)).thenReturn(rotina);

        RotinaResponseDTO atualizada = rotinaService.atualizar(rotinaId, new RotinaDTO("Nova", "desc", null), "joao");
        assertEquals("Nova", atualizada.nome());
        assertFalse(atualizada.ativa());

        UUID inexistente = UUID.randomUUID();
        when(rotinaRepository.findByIdAndUsuarioId(inexistente, 1L)).thenReturn(Optional.empty());
        assertThrows(RotinaNaoEncontradaException.class,
                () -> rotinaService.atualizar(inexistente, new RotinaDTO("X", "", true), "joao"));
    }

    @Test
    void excluirRemoveRotinaDoUsuario() {
        UUID rotinaId = UUID.randomUUID();
        RotinaModel rotina = new RotinaModel();
        ReflectionTestUtils.setField(rotina, "id", rotinaId);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(rotinaRepository.findByIdAndUsuarioId(rotinaId, 1L)).thenReturn(Optional.of(rotina));

        rotinaService.excluir(rotinaId, "joao");

        verify(rotinaRepository).delete(rotina);
    }

    @Test
    void adicionarERemoverLembreteValidamEDeduplicamDias() {
        UUID rotinaId = UUID.randomUUID();
        RotinaModel rotina = new RotinaModel();
        ReflectionTestUtils.setField(rotina, "id", rotinaId);
        rotina.setNome("Treinos");
        rotina.setAtiva(true);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(rotinaRepository.findByIdAndUsuarioId(rotinaId, 1L)).thenReturn(Optional.of(rotina));
        when(rotinaRepository.save(rotina)).thenAnswer(inv -> {
            for (RotinaLembreteModel l : rotina.getLembretes()) {
                if (l.getId() == null) {
                    ReflectionTestUtils.setField(l, "id", UUID.randomUUID());
                }
            }
            return rotina;
        });

        assertThrows(IllegalArgumentException.class, () -> rotinaService.adicionarLembrete(
                rotinaId, new RotinaLembreteDTO("", "", LocalTime.of(8, 0), List.of(1)), "joao"));
        assertThrows(IllegalArgumentException.class, () -> rotinaService.adicionarLembrete(
                rotinaId, new RotinaLembreteDTO("Treino", "", null, List.of(1)), "joao"));
        assertThrows(IllegalArgumentException.class, () -> rotinaService.adicionarLembrete(
                rotinaId, new RotinaLembreteDTO("Treino", "", LocalTime.of(8, 0), List.of()), "joao"));
        assertThrows(IllegalArgumentException.class, () -> rotinaService.adicionarLembrete(
                rotinaId, new RotinaLembreteDTO("Treino", "", LocalTime.of(8, 0), List.of(8)), "joao"));

        RotinaResponseDTO res = rotinaService.adicionarLembrete(
                rotinaId,
                new RotinaLembreteDTO(" Academia ", " Bora ", LocalTime.of(18, 30), List.of(5, 1, 3, 1)),
                "joao");

        assertEquals(1, res.lembretes().size());
        assertEquals("Academia", res.lembretes().get(0).titulo());
        assertEquals(List.of(1, 3, 5), res.lembretes().get(0).diasSemana());

        UUID lembreteId = res.lembretes().get(0).id();
        RotinaResponseDTO aposRemover = rotinaService.removerLembrete(rotinaId, lembreteId, "joao");
        assertTrue(aposRemover.lembretes().isEmpty());

        assertThrows(RotinaNaoEncontradaException.class,
                () -> rotinaService.removerLembrete(rotinaId, UUID.randomUUID(), "joao"));
    }
}
