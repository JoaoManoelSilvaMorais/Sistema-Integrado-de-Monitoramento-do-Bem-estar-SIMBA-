package br.simba.bem_estar.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.simba.bem_estar.meta.MetaModel;
import br.simba.bem_estar.meta.MetaRepository;
import br.simba.bem_estar.perfil.PerfilModel;
import br.simba.bem_estar.perfil.PerfilRepository;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.rotina.RotinaModel;
import br.simba.bem_estar.rotina.RotinaRepository;
import br.simba.bem_estar.sintoma.RegistroSintomaModel;
import br.simba.bem_estar.sintoma.RegistroSintomaRepository;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class DemoDataSeederTest {

    @Mock private UserRepository userRepository;
    @Mock private PerfilRepository perfilRepository;
    @Mock private RegistroSonoRepository sonoRepository;
    @Mock private RegistroAguaRepository aguaRepository;
    @Mock private RegistroExercicioRepository exercicioRepository;
    @Mock private RotinaRepository rotinaRepository;
    @Mock private MetaRepository metaRepository;
    @Mock private RegistroSintomaRepository sintomaRepository;
    @Mock private PasswordEncoder passwordEncoder;

    @InjectMocks
    private DemoDataSeeder seeder;

    @Test
    void naoCriaDadosSeUsuarioDemoJaExistir() {
        when(userRepository.findByUsername("demo")).thenReturn(Optional.of(new UserModel()));

        seeder.run();

        verify(userRepository, never()).save(any());
        verify(perfilRepository, never()).save(any());
    }

    @Test
    void populaUsuarioDemoPerfilRotinasMetasESintomasQuandoNaoExiste() {
        when(userRepository.findByUsername("demo")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("demo123")).thenReturn("$2a$demo");
        when(perfilRepository.save(any(PerfilModel.class))).thenAnswer(inv -> inv.getArgument(0));
        when(userRepository.save(any(UserModel.class))).thenAnswer(inv -> inv.getArgument(0));

        seeder.run();

        verify(perfilRepository).save(any(PerfilModel.class));
        verify(userRepository).save(any(UserModel.class));
        // 31 dias (30..0) menos 5 dias vazios (14, 13, 22, 1, 0) = 26 registros de sono
        verify(sonoRepository, times(26)).save(any());
        verify(rotinaRepository, times(4)).save(any(RotinaModel.class));
        verify(metaRepository, times(2)).save(any(MetaModel.class));
        // Dias 20..2 menos dias 14 e 13 = 17 registros de sintomas
        verify(sintomaRepository, times(17)).save(any(RegistroSintomaModel.class));
    }
}
