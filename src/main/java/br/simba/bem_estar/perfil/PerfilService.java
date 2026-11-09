package br.simba.bem_estar.perfil;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final UserRepository userRepository;

    public PerfilService(
            PerfilRepository perfilRepository,
            UserRepository userRepository
    ) {
        this.perfilRepository = perfilRepository;
        this.userRepository = userRepository;
    }

    // 1. Busca o perfil do usuário atualmente autenticado (Prevenção contra IDOR)
    @Transactional(readOnly = true)
    public PerfilModel buscarPerfilDoUsuarioLogado(String username) {

        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username
                ));

        if (usuario.getPerfil() == null) {
            throw new DadoNaoEncontradoException(
                    "Perfil ainda não cadastrado para o usuário atual."
            );
        }

        return usuario.getPerfil();
    }

    // 2. Cria o perfil associado ao usuário logado
    @Transactional
    public PerfilModel criarPerfil(PerfilModel perfilModel, String username) {

        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username
                ));

        perfilModel.setUsuario(usuario);

        return perfilRepository.save(perfilModel);
    }

    // 3. Atualiza os dados biométricos do perfil do usuário logado
    @Transactional
    public PerfilModel atualizarPerfilDoUsuarioLogado(
            PerfilModel perfilAtualizado,
            String username
    ) {

        PerfilModel perfilExistente = buscarPerfilDoUsuarioLogado(username);

        // Atualiza apenas os campos permitidos
        perfilExistente.setAltura(perfilAtualizado.getAltura());
        perfilExistente.setIdade(perfilAtualizado.getIdade());
        perfilExistente.setPeso(perfilAtualizado.getPeso());

        return perfilRepository.save(perfilExistente);
    }

    // 4. Peso e altura do usuário logado (usado na tela de perfil).
    //    Quem ainda não tem perfil recebe tudo nulo.
    @Transactional(readOnly = true)
    public MedidasResponseDTO buscarMedidas(String username) {
        UserModel usuario = buscarUsuario(username);
        PerfilModel perfil = usuario.getPerfil();
        if (perfil == null) {
            return MedidasResponseDTO.de(null, null);
        }
        return MedidasResponseDTO.de(
                MedidasCalculator.ouNulo(perfil.getPeso()),
                MedidasCalculator.ouNulo(perfil.getAltura()));
    }

    // 5. Adiciona ou edita peso e altura. Se o usuário ainda não tem perfil, cria e liga
    //    ao usuário (quem guarda a ligação é UserModel.perfil). Campo nulo = em branco.
    @Transactional
    public MedidasResponseDTO salvarMedidas(String username, MedidasDTO dados) {
        Double peso = dados == null ? null : dados.peso();
        Double altura = dados == null ? null : dados.altura();
        MedidasCalculator.validar(peso, altura);

        UserModel usuario = buscarUsuario(username);
        PerfilModel perfil = usuario.getPerfil();
        boolean novo = perfil == null;
        if (novo) {
            perfil = new PerfilModel();
        }

        perfil.setPeso(peso == null ? 0 : peso);
        perfil.setAltura(altura == null ? 0 : altura);
        perfil = perfilRepository.save(perfil);

        if (novo) {
            usuario.setPerfil(perfil);
            userRepository.save(usuario);
        }

        return MedidasResponseDTO.de(peso, altura);
    }

    private UserModel buscarUsuario(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username
                ));
    }
}