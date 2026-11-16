package br.simba.bem_estar.perfil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class PerfilServiceTest {

    @Mock
    private PerfilRepository perfilRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PerfilService perfilService;

    private UserModel usuario;

    @BeforeEach
    void prepararUsuario() {
        usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
    }

    @Test
    void buscarPerfilDoUsuarioLogadoRetornaPerfilOuLancaExcecao() {
        when(userRepository.findByUsername("desconhecido")).thenReturn(Optional.empty());
        assertThrows(DadoNaoEncontradoException.class,
                () -> perfilService.buscarPerfilDoUsuarioLogado("desconhecido"));

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        assertThrows(DadoNaoEncontradoException.class,
                () -> perfilService.buscarPerfilDoUsuarioLogado("joao"));

        PerfilModel perfil = new PerfilModel();
        perfil.setPeso(72.5);
        usuario.setPerfil(perfil);

        assertSame(perfil, perfilService.buscarPerfilDoUsuarioLogado("joao"));
    }

    @Test
    void criarEAtualizarPerfilPersistemAlteracoes() {
        PerfilModel novo = new PerfilModel();
        novo.setPeso(70.0);
        novo.setAltura(1.75);
        novo.setIdade(25);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(perfilRepository.save(any(PerfilModel.class))).thenAnswer(inv -> inv.getArgument(0));

        PerfilModel criado = perfilService.criarPerfil(novo, "joao");
        assertSame(usuario, criado.getUsuario());

        PerfilModel existente = new PerfilModel();
        existente.setPeso(70.0);
        existente.setAltura(1.75);
        existente.setIdade(25);
        usuario.setPerfil(existente);

        PerfilModel atualizado = new PerfilModel();
        atualizado.setPeso(75.0);
        atualizado.setAltura(1.76);
        atualizado.setIdade(26);

        PerfilModel salvo = perfilService.atualizarPerfilDoUsuarioLogado(atualizado, "joao");
        assertEquals(75.0, salvo.getPeso());
        assertEquals(1.76, salvo.getAltura());
        assertEquals(26, salvo.getIdade());
    }

    @Test
    void buscarMedidasConverteZeroEmNuloECalculaImc() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));

        MedidasResponseDTO semPerfil = perfilService.buscarMedidas("joao");
        assertNull(semPerfil.peso());
        assertNull(semPerfil.altura());
        assertNull(semPerfil.imc());
        assertTrue(semPerfil.sugestoes().isEmpty());

        PerfilModel perfil = new PerfilModel();
        perfil.setPeso(72.5);
        perfil.setAltura(0); // não informada
        usuario.setPerfil(perfil);

        MedidasResponseDTO soPeso = perfilService.buscarMedidas("joao");
        assertEquals(72.5, soPeso.peso());
        assertNull(soPeso.altura());
        assertNull(soPeso.imc());
        assertEquals(2, soPeso.sugestoes().size());

        perfil.setAltura(1.75);
        MedidasResponseDTO completo = perfilService.buscarMedidas("joao");
        assertEquals(23.7, completo.imc());
        assertEquals("Peso adequado", completo.classificacaoImc());
        assertEquals(3, completo.sugestoes().size());
    }

    @Test
    void salvarMedidasCriaEVinculaPerfilQuandoInexistente() {
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(perfilRepository.save(any(PerfilModel.class))).thenAnswer(inv -> inv.getArgument(0));

        MedidasResponseDTO dto = perfilService.salvarMedidas("joao", new MedidasDTO(80.0, 1.80));

        assertEquals(80.0, dto.peso());
        assertEquals(1.80, dto.altura());
        assertEquals(24.7, dto.imc());
        verify(userRepository).save(usuario);
        assertEquals(80.0, usuario.getPerfil().getPeso());
    }

    @Test
    void salvarMedidasAtualizaExistenteEConverteNuloParaZero() {
        PerfilModel existente = new PerfilModel();
        existente.setPeso(75.0);
        existente.setAltura(1.75);
        usuario.setPerfil(existente);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(perfilRepository.save(any(PerfilModel.class))).thenAnswer(inv -> inv.getArgument(0));

        MedidasResponseDTO dto = perfilService.salvarMedidas("joao", new MedidasDTO(70.0, null));

        assertEquals(70.0, dto.peso());
        assertNull(dto.altura());
        assertEquals(70.0, existente.getPeso());
        assertEquals(0.0, existente.getAltura());
        verify(userRepository, never()).save(usuario);
    }

    @Test
    void salvarMedidasRecusaValoresInvalidos() {
        assertThrows(RegraDeNegocioException.class,
                () -> perfilService.salvarMedidas("joao", new MedidasDTO(10.0, 1.75)));
        assertThrows(RegraDeNegocioException.class,
                () -> perfilService.salvarMedidas("joao", new MedidasDTO(70.0, 3.5)));
        verify(perfilRepository, never()).save(any());
    }
}
