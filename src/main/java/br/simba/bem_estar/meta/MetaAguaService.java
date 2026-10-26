package br.simba.bem_estar.meta;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class MetaAguaService {

    private final UserRepository userRepository;
    private final MetaAguaRepository metaAguaRepository;

    public MetaAguaService(UserRepository userRepository, MetaAguaRepository metaAguaRepository) {
        this.userRepository = userRepository;
        this.metaAguaRepository = metaAguaRepository;
    }

    /** Meta em vigor do usuário: a que ele definiu ou, se não houver, a sugerida pelo peso. */
    @Transactional(readOnly = true)
    public MetaAguaDTO resolver(UserModel usuario) {
        double peso = usuario.getPerfil() == null ? 0 : usuario.getPerfil().getPeso();
        int sugerida = MetaAguaCalculator.sugerida(peso);
        Optional<MetaAguaModel> propria = metaAguaRepository.findByUsuarioId(usuario.getId());
        return new MetaAguaDTO(
                propria.map(MetaAguaModel::getMetaMl).orElse(sugerida),
                propria.isPresent(),
                sugerida,
                peso);
    }

    @Transactional(readOnly = true)
    public MetaAguaDTO obter(String username) {
        return resolver(buscarUsuario(username));
    }

    @Transactional
    public MetaAguaDTO definir(String username, Integer metaMl) {
        UserModel usuario = buscarUsuario(username);
        Optional<MetaAguaModel> propria = metaAguaRepository.findByUsuarioId(usuario.getId());

        if (metaMl == null || metaMl <= 0) {
            propria.ifPresent(metaAguaRepository::delete);
            metaAguaRepository.flush();
            return resolver(usuario);
        }
        if (!MetaAguaCalculator.valida(metaMl)) {
            throw new RegraDeNegocioException("A meta de água deve ficar entre "
                    + MetaAguaCalculator.MIN_ML + " ml e " + MetaAguaCalculator.MAX_ML + " ml.");
        }

        MetaAguaModel registro = propria.orElseGet(() -> {
            MetaAguaModel novo = new MetaAguaModel();
            novo.setUsuario(usuario);
            return novo;
        });
        registro.setMetaMl(metaMl);
        metaAguaRepository.save(registro);
        return resolver(usuario);
    }

    private UserModel buscarUsuario(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));
    }
}
