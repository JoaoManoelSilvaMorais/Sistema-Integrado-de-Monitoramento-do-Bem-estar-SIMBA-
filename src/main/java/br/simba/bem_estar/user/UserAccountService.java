package br.simba.bem_estar.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.simba.bem_estar.conquista.ConquistaUsuarioRepository;
import br.simba.bem_estar.lembrete.LembreteRepository;
import br.simba.bem_estar.meta.MetaAguaRepository;
import br.simba.bem_estar.meta.MetaRepository;
import br.simba.bem_estar.perfil.PerfilModel;
import br.simba.bem_estar.perfil.PerfilRepository;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.rotina.RotinaRepository;

@Service
public class UserAccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PerfilRepository perfilRepository;

    private final RegistroAguaRepository aguaRepository;
    private final RegistroSonoRepository sonoRepository;
    private final RegistroExercicioRepository exercicioRepository;

    private final MetaRepository metaRepository;
    private final MetaAguaRepository metaAguaRepository;

    private final ConquistaUsuarioRepository conquistaRepository;
    private final RotinaRepository rotinaRepository;
    private final LembreteRepository lembreteRepository;

    public UserAccountService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            PerfilRepository perfilRepository,
            RegistroAguaRepository aguaRepository,
            RegistroSonoRepository sonoRepository,
            RegistroExercicioRepository exercicioRepository,
            MetaRepository metaRepository,
            MetaAguaRepository metaAguaRepository,
            ConquistaUsuarioRepository conquistaRepository,
            RotinaRepository rotinaRepository,
            LembreteRepository lembreteRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.perfilRepository = perfilRepository;
        this.aguaRepository = aguaRepository;
        this.sonoRepository = sonoRepository;
        this.exercicioRepository = exercicioRepository;
        this.metaRepository = metaRepository;
        this.metaAguaRepository = metaAguaRepository;
        this.conquistaRepository = conquistaRepository;
        this.rotinaRepository = rotinaRepository;
        this.lembreteRepository = lembreteRepository;
    }

    @Transactional
    public void excluirConta(String username, String senha) {

        UserModel usuario = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado."
                ));

        if (senha == null || senha.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Informe sua senha atual."
            );
        }

        if (!passwordEncoder.matches(
                senha,
                usuario.getPassword())) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Senha incorreta."
            );
        }

        Long usuarioId = usuario.getId();

        // Guardar o perfil para excluí-lo depois do usuário.
        PerfilModel perfil = usuario.getPerfil();

        // 1. Excluir registros de monitoramento.
        aguaRepository.deleteByUsuarioId(usuarioId);
        sonoRepository.deleteByUsuarioId(usuarioId);
        exercicioRepository.deleteByUsuarioId(usuarioId);

        // 2. Excluir metas.
        metaRepository.deleteByUsuarioId(usuarioId);
        metaAguaRepository.deleteByUsuarioId(usuarioId);

        // 3. Excluir conquistas.
        conquistaRepository.deleteByUsuarioId(usuarioId);

        // 4. Excluir lembretes independentes.
        lembreteRepository.deleteByUsuarioId(usuarioId);

        // 5. Excluir rotinas e seus lembretes associados.
        rotinaRepository.deleteByUsuarioId(usuarioId);

        // 6. Excluir a conta.
        userRepository.delete(usuario);

        // 7. Excluir o perfil pessoal.
        if (perfil != null) {
            perfilRepository.delete(perfil);
        }
    }
}