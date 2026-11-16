package br.simba.bem_estar.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.perfil.PerfilModel;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class MetaAguaServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private MetaAguaRepository metaAguaRepository;

    @InjectMocks
    private MetaAguaService metaAguaService;

    @Test
    void obterUsaSugestaoQuandoNaoHaMetaPersonalizada() {
        PerfilModel perfil = new PerfilModel();
        perfil.setPeso(80.0);
        UserModel usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
        usuario.setPerfil(perfil);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(metaAguaRepository.findByUsuarioId(1L)).thenReturn(Optional.empty());

        MetaAguaDTO dto = metaAguaService.obter("joao");

        assertEquals(2800, dto.metaMl());
        assertEquals(2800, dto.sugeridaMl());
        assertFalse(dto.personalizada());
        assertEquals(80.0, dto.pesoKg());
    }

    @Test
    void obterUsaMetaPersonalizadaQuandoExistente() {
        UserModel usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");

        MetaAguaModel propria = new MetaAguaModel();
        propria.setMetaMl(3500);
        propria.setUsuario(usuario);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(metaAguaRepository.findByUsuarioId(1L)).thenReturn(Optional.of(propria));

        MetaAguaDTO dto = metaAguaService.obter("joao");

        assertEquals(3500, dto.metaMl());
        assertEquals(2000, dto.sugeridaMl());
        assertTrue(dto.personalizada());
    }

    @Test
    void definirSalvaNovaMetaValida() {
        UserModel usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");

        MetaAguaModel salva = new MetaAguaModel();
        salva.setMetaMl(3000);
        salva.setUsuario(usuario);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(metaAguaRepository.findByUsuarioId(1L))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(salva));

        MetaAguaDTO dto = metaAguaService.definir("joao", 3000);

        verify(metaAguaRepository).save(any(MetaAguaModel.class));
        assertEquals(3000, dto.metaMl());
        assertTrue(dto.personalizada());
    }

    @Test
    void definirComValorNuloOuZeroRemoveMetaPersonalizadaEVoltaParaSugerida() {
        PerfilModel perfil = new PerfilModel();
        perfil.setPeso(70.0);
        UserModel usuario = new UserModel();
        usuario.setId(1L);
        usuario.setUsername("joao");
        usuario.setPerfil(perfil);

        MetaAguaModel existente = new MetaAguaModel();
        existente.setMetaMl(3200);
        existente.setUsuario(usuario);

        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(metaAguaRepository.findByUsuarioId(1L))
                .thenReturn(Optional.of(existente))
                .thenReturn(Optional.empty());

        MetaAguaDTO dto = metaAguaService.definir("joao", 0);

        verify(metaAguaRepository).delete(existente);
        verify(metaAguaRepository).flush();
        assertEquals(2450, dto.metaMl());
        assertFalse(dto.personalizada());
    }

    @Test
    void definirForaDosLimitesLancaRegraDeNegocioException() {
        UserModel usuario = new UserModel();
        usuario.setId(1L);
        when(userRepository.findByUsername("joao")).thenReturn(Optional.of(usuario));
        when(metaAguaRepository.findByUsuarioId(1L)).thenReturn(Optional.empty());

        assertThrows(RegraDeNegocioException.class, () -> metaAguaService.definir("joao", 300));
        assertThrows(RegraDeNegocioException.class, () -> metaAguaService.definir("joao", 9000));
    }

    @Test
    void usuarioInexistenteLancaExcecao() {
        when(userRepository.findByUsername("naoexiste")).thenReturn(Optional.empty());

        assertThrows(DadoNaoEncontradoException.class, () -> metaAguaService.obter("naoexiste"));
    }
}
