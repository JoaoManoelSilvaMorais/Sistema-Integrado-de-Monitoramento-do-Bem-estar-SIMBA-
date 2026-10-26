package br.simba.bem_estar.proximopasso;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.conquista.ConquistaService;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.meta.MetaAguaService;
import br.simba.bem_estar.meta.MetaService;
import br.simba.bem_estar.streak.StreakService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class ProximoPassoService {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    private final UserRepository userRepository;
    private final HistoricoService historicoService;
    private final StreakService streakService;
    private final MetaAguaService metaAguaService;
    private final MetaService metaService;
    private final ConquistaService conquistaService;

    public ProximoPassoService(
            UserRepository userRepository,
            HistoricoService historicoService,
            StreakService streakService,
            MetaAguaService metaAguaService,
            MetaService metaService,
            ConquistaService conquistaService) {
        this.userRepository = userRepository;
        this.historicoService = historicoService;
        this.streakService = streakService;
        this.metaAguaService = metaAguaService;
        this.metaService = metaService;
        this.conquistaService = conquistaService;
    }

    /**
     * Só consulta: não grava conquistas nem metas, para que o aviso de "desbloqueada"
     * continue aparecendo no momento certo (ao registrar ou ao abrir a tela de conquistas).
     */
    @Transactional
    public ProximoPassoDTO obter(String username) {
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));

        LocalDate hoje = LocalDate.now(FUSO);
        Historico historico = historicoService.carregar(usuario);
        int aguaHojeMl = (int) historico.agua().stream()
                .filter(a -> a.dataHora() != null && a.ml() > 0 && a.dataHora().toLocalDate().equals(hoje))
                .mapToDouble(Historico.Agua::ml)
                .sum();

        return ProximoPassoCalculator.escolher(new ProximoPassoCalculator.Entrada(
                streakService.obter(username),
                aguaHojeMl,
                metaAguaService.resolver(usuario).metaMl(),
                metaService.listar(username, false),
                conquistaService.consultar(username).conquistas()));
    }
}
