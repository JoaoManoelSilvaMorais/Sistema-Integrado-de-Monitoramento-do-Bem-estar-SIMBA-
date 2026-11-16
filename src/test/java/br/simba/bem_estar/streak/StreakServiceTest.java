package br.simba.bem_estar.streak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class StreakServiceTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Mock
    private UserRepository userRepository;

    @Mock
    private HistoricoService historicoService;

    @InjectMocks
    private StreakService streakService;

    @Test
    void usuarioNaoEncontradoLancaExcecao() {
        when(userRepository.findByUsername("inexistente")).thenReturn(Optional.empty());

        assertThrows(DadoNaoEncontradoException.class, () -> streakService.obter("inexistente"));
    }

    @Test
    void combinaAguaSonoETreinoEMarcaRegistrosDeHoje() {
        UserModel usuario = new UserModel();
        usuario.setUsername("joao");

        LocalDate hoje = LocalDate.now(FUSO);
        Historico historico = new Historico(
                List.of(new Historico.Agua(hoje.atTime(9, 0), 500)),
                List.of(new Historico.Sono(hoje.minusDays(2).atTime(23, 0), hoje.minusDays(1).atTime(7, 0), 4)),
                List.of(new Historico.Treino("Corrida", 30, 250, hoje.atTime(18, 0)))
        );

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(historicoService.carregar(usuario)).thenReturn(historico);

        StreakDTO dto = streakService.obter("joao");

        assertEquals(2, dto.atual());
        assertEquals(2, dto.maior());
        assertTrue(dto.ativoHoje());
        assertTrue(dto.aguaHoje());
        assertFalse(dto.sonoHoje());
        assertTrue(dto.treinoHoje());
    }
}
