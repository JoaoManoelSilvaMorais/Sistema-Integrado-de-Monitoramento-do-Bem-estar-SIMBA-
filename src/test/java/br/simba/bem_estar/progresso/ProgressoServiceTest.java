package br.simba.bem_estar.progresso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.simba.bem_estar.registroAgua.RegistroAguaModel;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioModel;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoModel;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.user.UserModel;

@ExtendWith(MockitoExtension.class)
class ProgressoServiceTest {

    @Mock
    private RegistroSonoRepository sonoRepository;
    @Mock
    private RegistroAguaRepository aguaRepository;
    @Mock
    private RegistroExercicioRepository exercicioRepository;

    @InjectMocks
    private ProgressoService progressoService;

    @Test
    void montaSerieDiariaContinuaDeSonoAguaETreinos() {
        UserModel usuario = new UserModel();
        usuario.setId(1L);

        LocalDate dia1 = LocalDate.of(2026, 11, 1);
        LocalDate dia2 = LocalDate.of(2026, 11, 2);

        RegistroSonoModel sono1 = new RegistroSonoModel(1L, dia1.minusDays(1).atTime(23, 0), dia1.atTime(7, 0), 4, usuario); // 8h
        RegistroSonoModel sono2 = new RegistroSonoModel(2L, dia1.atTime(13, 0), dia1.atTime(14, 0), 2, usuario);              // 1h (média 4.5h, nota 3.0)
        RegistroSonoModel sonoIncompleto = new RegistroSonoModel(3L, null, dia2.atTime(7, 0), 5, usuario);

        RegistroAguaModel agua1 = new RegistroAguaModel(1L, 350.0, dia1.atTime(9, 0), usuario);
        RegistroAguaModel agua2 = new RegistroAguaModel(2L, 400.0, dia1.atTime(14, 0), usuario);

        RegistroExercicioModel treino1 = new RegistroExercicioModel(1L, "Corrida", 30, 300f, dia2.atTime(7, 0), usuario);
        RegistroExercicioModel treino2 = new RegistroExercicioModel(2L, "Alongamento", 15, 50f, dia2.atTime(18, 0), usuario);

        when(sonoRepository.findByUsuario_IdAndHoraAcordarBetweenOrderByHoraAcordarAsc(eq(1L), any(), any()))
                .thenReturn(List.of(sono1, sono2, sonoIncompleto));
        when(aguaRepository.findByUsuarioAndDataHoraBetweenOrderByDataHoraAsc(eq(usuario), any(), any()))
                .thenReturn(List.of(agua1, agua2));
        when(exercicioRepository.findByUsuarioAndDataHoraBetweenOrderByDataHoraAsc(eq(usuario), any(), any()))
                .thenReturn(List.of(treino1, treino2));

        ProgressoDTO dto = progressoService.obterProgresso(usuario, dia1, dia2);

        // Sono
        assertEquals(2, dto.getSono().size());
        assertEquals(4.5, dto.getSono().get(0).getHorasSono());
        assertEquals(3.0, dto.getSono().get(0).getNotaSono());
        assertNull(dto.getSono().get(1).getHorasSono());
        assertNull(dto.getSono().get(1).getNotaSono());

        // Hidratação
        assertEquals(2, dto.getHidratacao().size());
        assertEquals(750.0, dto.getHidratacao().get(0).getQuantidadeMl());
        assertEquals(0.0, dto.getHidratacao().get(1).getQuantidadeMl());

        // Treinos
        assertEquals(2, dto.getTreinos().size());
        assertFalse(dto.getTreinos().get(0).isTreinou());
        assertEquals(0, dto.getTreinos().get(0).getQuantidadeTreinos());
        assertTrue(dto.getTreinos().get(1).isTreinou());
        assertEquals(2, dto.getTreinos().get(1).getQuantidadeTreinos());
    }
}
