package br.simba.bem_estar.rotina;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class RotinaService {

    private final RotinaRepository rotinaRepository;
    private final UserRepository userRepository;

    public RotinaService(
            RotinaRepository rotinaRepository,
            UserRepository userRepository) {
        this.rotinaRepository = rotinaRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public RotinaResponseDTO criar(RotinaDTO dados, String username) {
        UserModel usuario = buscarUsuario(username);
        RotinaModel rotina = new RotinaModel();
        rotina.setUsuario(usuario);
        atualizarDados(rotina, dados, true);
        return RotinaResponseDTO.from(rotinaRepository.save(rotina));
    }

    @Transactional(readOnly = true)
    public List<RotinaResponseDTO> listar(String username) {
        Long usuarioId = buscarUsuario(username).getId();
        return rotinaRepository.findByUsuarioId(usuarioId).stream()
                .map(RotinaResponseDTO::from)
                .toList();
    }

    @Transactional
    public RotinaResponseDTO atualizar(UUID id, RotinaDTO dados, String username) {
        Long usuarioId = buscarUsuario(username).getId();
        RotinaModel rotina = buscarRotina(id, usuarioId);
        atualizarDados(rotina, dados, false);
        return RotinaResponseDTO.from(rotinaRepository.save(rotina));
    }

    @Transactional
    public void excluir(UUID id, String username) {
        Long usuarioId = buscarUsuario(username).getId();
        rotinaRepository.delete(buscarRotina(id, usuarioId));
    }

    private UserModel buscarUsuario(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RotinaNaoEncontradaException("Usuário não encontrado."));
    }

    private RotinaModel buscarRotina(UUID id, Long usuarioId) {
        return rotinaRepository.findByIdAndUsuarioId(id, usuarioId)
                .orElseThrow(() -> new RotinaNaoEncontradaException("Rotina não encontrada."));
    }

    private void atualizarDados(RotinaModel rotina, RotinaDTO dados, boolean criacao) {
        if (dados == null || dados.nome() == null || dados.nome().isBlank()) {
            throw new IllegalArgumentException("O nome da rotina é obrigatório.");
        }

        rotina.setNome(dados.nome().trim());
        rotina.setDescricao(dados.descricao() == null ? "" : dados.descricao().trim());
        if (criacao || dados.ativa() != null) {
            rotina.setAtiva(criacao ? dados.ativa() == null || dados.ativa() : dados.ativa());
        }
    }
}
