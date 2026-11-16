package br.simba.bem_estar.sintoma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class RegistroSintomaServiceTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Mock
    private UserRepository userRepository;

    @Mock
    private RegistroSintomaRepository repository;

    @InjectMocks
    private RegistroSintomaService service;

    private UserModel usuario;

    @BeforeEach
    void prepararUsuario() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
    }

    @Test
    void salvarHojeCriaNovoRegistroQuandoAindaNaoRespondido() {
        LocalDate hoje = LocalDate.now(FUSO);
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(repository.findByUsuarioIdAndDataRegistro(1L, hoje)).thenReturn(Optional.empty());
        when(repository.save(any(RegistroSintomaModel.class))).thenAnswer(inv -> {
            RegistroSintomaModel m = inv.getArgument(0);
            ReflectionTestUtils.setField(m, "id", 10L);
            return m;
        });

        RegistroSintomaDTO dados = new RegistroSintomaDTO(
                4, 5, 2, "LEVE", List.of("CABECA"), List.of("CANSACO"), "  Dormi tarde  ");

        RegistroSintomaResponseDTO resposta = service.salvarHoje("joao", dados);

        assertEquals(10L, resposta.id());
        assertEquals(hoje, resposta.data());
        assertEquals("LEVE", resposta.dor());
        assertEquals(List.of("CABECA"), resposta.locaisDor());
        assertEquals(List.of("CANSACO"), resposta.sintomas());
        assertEquals("Dormi tarde", resposta.observacao());
    }

    @Test
    void salvarHojeAtualizaRegistroExistenteMantendoCriadoEm() {
        LocalDate hoje = LocalDate.now(FUSO);
        LocalDateTime criadoAntes = hoje.atTime(8, 0);

        RegistroSintomaModel existente = new RegistroSintomaModel();
        ReflectionTestUtils.setField(existente, "id", 10L);
        existente.setUsuario(usuario);
        existente.setDataRegistro(hoje);
        existente.setCriadoEm(criadoAntes);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(repository.findByUsuarioIdAndDataRegistro(1L, hoje)).thenReturn(Optional.of(existente));
        when(repository.save(existente)).thenReturn(existente);

        RegistroSintomaDTO dados = new RegistroSintomaDTO(
                2, 3, 4, "NENHUMA", null, List.of("NENHUM"), null);

        RegistroSintomaResponseDTO resposta = service.salvarHoje("joao", dados);

        assertSame(criadoAntes, existente.getCriadoEm());
        assertNotNull(existente.getAtualizadoEm());
        assertEquals("NENHUMA", resposta.dor());
        assertTrue(resposta.locaisDor().isEmpty());
        assertEquals(List.of("NENHUM"), resposta.sintomas());
    }

    @Test
    void salvarHojeValidaEntradaEPropagaoErro() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        assertThrows(RegraDeNegocioException.class,
                () -> service.salvarHoje("joao", new RegistroSintomaDTO(0, 3, 3, "NENHUMA", null, null, null)));
        verify(repository, never()).save(any());
    }

    @Test
    void hojeRetornaEstadoRespondidoOuNao() {
        LocalDate hoje = LocalDate.now(FUSO);
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(repository.findByUsuarioIdAndDataRegistro(1L, hoje)).thenReturn(Optional.empty());

        SintomaHojeDTO naoRespondido = service.hoje("joao");
        assertFalse(naoRespondido.respondido());
        assertNull(naoRespondido.registro());

        RegistroSintomaModel reg = new RegistroSintomaModel();
        ReflectionTestUtils.setField(reg, "id", 7L);
        reg.setDataRegistro(hoje);
        reg.setEnergia(4);
        reg.setHumor(4);
        reg.setEstresse(2);
        reg.setDor(NivelDor.NENHUMA);
        reg.setLocaisDor("");
        reg.setSintomas("NENHUM");

        when(repository.findByUsuarioIdAndDataRegistro(1L, hoje)).thenReturn(Optional.of(reg));

        SintomaHojeDTO respondido = service.hoje("joao");
        assertTrue(respondido.respondido());
        assertEquals(7L, respondido.registro().id());
    }

    @Test
    void historicoRetornaRegistrosEResumoSemanal() {
        LocalDate hoje = LocalDate.now(FUSO);
        RegistroSintomaModel reg = new RegistroSintomaModel();
        ReflectionTestUtils.setField(reg, "id", 1L);
        reg.setDataRegistro(hoje);
        reg.setEnergia(5);
        reg.setHumor(5);
        reg.setEstresse(1);
        reg.setDor(NivelDor.NENHUMA);
        reg.setLocaisDor("");
        reg.setSintomas("NENHUM");

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(repository.findByUsuarioIdAndDataRegistroGreaterThanEqualOrderByDataRegistroDesc(
                eq(1L), eq(hoje.minusDays(29))))
                .thenReturn(List.of(reg));

        SintomaHistoricoDTO hist = service.historico("joao");

        assertEquals(1, hist.registros().size());
        assertEquals(1, hist.semana().diasRespondidos());
        assertEquals(5.0, hist.semana().mediaEnergia());
    }

    @Test
    void usuarioNaoEncontradoLancaExcecao() {
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());

        assertThrows(DadoNaoEncontradoException.class, () -> service.hoje("desconhecido"));
    }
}
