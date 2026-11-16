package br.simba.bem_estar.historico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
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
class HistoricoServiceTest {

    @Mock
    private RegistroAguaRepository aguaRepository;

    @Mock
    private RegistroSonoRepository sonoRepository;

    @Mock
    private RegistroExercicioRepository exercicioRepository;

    @InjectMocks
    private HistoricoService historicoService;

    @Test
    void carregaEMapeiaRegistrosDoUsuario() {
        UserModel usuario = new UserModel();
        usuario.setId(42L);

        LocalDateTime agora = LocalDateTime.of(2026, 11, 10, 10, 0);
        RegistroAguaModel agua = new RegistroAguaModel(1L, 350.0, agora, usuario);
        RegistroSonoModel sono = new RegistroSonoModel(2L, agora.minusHours(8), agora, 5, usuario);
        RegistroExercicioModel treinoComDuracao = new RegistroExercicioModel(3L, "Corrida", 40, 320f, agora, usuario);
        RegistroExercicioModel treinoSemDuracao = new RegistroExercicioModel(4L, "Alongamento", null, 50f, agora, usuario);

        when(aguaRepository.findByUsuario(usuario)).thenReturn(List.of(agua));
        when(sonoRepository.findByUsuario_IdOrderByHoraDormirDesc(42L)).thenReturn(List.of(sono));
        when(exercicioRepository.findByUsuario(usuario)).thenReturn(List.of(treinoComDuracao, treinoSemDuracao));

        Historico historico = historicoService.carregar(usuario);

        assertEquals(1, historico.agua().size());
        assertEquals(350.0, historico.agua().get(0).ml());

        assertEquals(1, historico.sono().size());
        assertEquals(5, historico.sono().get(0).nota());

        assertEquals(2, historico.treinos().size());
        assertEquals(40, historico.treinos().get(0).minutos());
        assertEquals(0, historico.treinos().get(1).minutos());
        assertEquals(320.0, historico.treinos().get(0).kcal(), 0.01);
    }
}
