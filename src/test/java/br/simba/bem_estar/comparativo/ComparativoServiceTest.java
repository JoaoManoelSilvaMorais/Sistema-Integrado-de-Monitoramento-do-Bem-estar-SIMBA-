package br.simba.bem_estar.comparativo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
class ComparativoServiceTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Mock
    private UserRepository userRepository;

    @Mock
    private HistoricoService historicoService;

    @InjectMocks
    private ComparativoService comparativoService;

    @Test
    void usuarioNaoEncontradoLancaExcecao() {
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());

        assertThrows(DadoNaoEncontradoException.class, () -> comparativoService.obter("desconhecido"));
    }

    @Test
    void carregaHistoricoECalculaComparativo() {
        UserModel usuario = new UserModel();
        usuario.setUsername("joao");
        LocalDate hoje = LocalDate.now(FUSO);

        Historico historico = new Historico(
                List.of(new Historico.Agua(hoje.atTime(9, 0), 700)),
                List.of(),
                List.of()
        );

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(historicoService.carregar(usuario)).thenReturn(historico);

        ComparativoDTO dto = comparativoService.obter("joao");

        assertEquals(100.0, dto.agua().atual());
        assertEquals("novo", dto.agua().tendencia());
    }
}
