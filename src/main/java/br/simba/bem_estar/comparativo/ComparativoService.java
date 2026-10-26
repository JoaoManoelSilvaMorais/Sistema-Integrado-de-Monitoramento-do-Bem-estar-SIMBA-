package br.simba.bem_estar.comparativo;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class ComparativoService {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    private final UserRepository userRepository;
    private final HistoricoService historicoService;

    public ComparativoService(UserRepository userRepository, HistoricoService historicoService) {
        this.userRepository = userRepository;
        this.historicoService = historicoService;
    }

    @Transactional(readOnly = true)
    public ComparativoDTO obter(String username) {
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));
        return ComparativoCalculator.calcular(historicoService.carregar(usuario), LocalDate.now(FUSO));
    }
}
