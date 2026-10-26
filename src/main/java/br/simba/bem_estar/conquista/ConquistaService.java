package br.simba.bem_estar.conquista;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.meta.MetaAguaService;
import br.simba.bem_estar.rotina.RotinaModel;
import br.simba.bem_estar.rotina.RotinaRepository;
import br.simba.bem_estar.streak.StreakService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class ConquistaService {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    private final UserRepository userRepository;
    private final HistoricoService historicoService;
    private final MetaAguaService metaAguaService;
    private final RotinaRepository rotinaRepository;
    private final ConquistaUsuarioRepository conquistaRepository;
    private final StreakService streakService;

    public ConquistaService(
            UserRepository userRepository,
            HistoricoService historicoService,
            MetaAguaService metaAguaService,
            RotinaRepository rotinaRepository,
            ConquistaUsuarioRepository conquistaRepository,
            StreakService streakService) {
        this.userRepository = userRepository;
        this.historicoService = historicoService;
        this.metaAguaService = metaAguaService;
        this.rotinaRepository = rotinaRepository;
        this.conquistaRepository = conquistaRepository;
        this.streakService = streakService;
    }

    /**
     * Confere as conquistas do usuário, grava as que acabaram de ser cumpridas
     * e devolve a lista completa (desbloqueadas, progresso das bloqueadas e quais são novas).
     * Uma conquista desbloqueada nunca é perdida, mesmo que o registro seja apagado depois.
     */
    @Transactional
    public ConquistasResponseDTO listar(String username) {
        return avaliar(username, true);
    }

    /** Mesma lista, mas sem gravar nada (usado para sugerir o "próximo passo"). */
    @Transactional
    public ConquistasResponseDTO consultar(String username) {
        return avaliar(username, false);
    }

    private ConquistasResponseDTO avaliar(String username, boolean gravar) {
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));

        var historico = historicoService.carregar(usuario);

        List<RotinaModel> rotinas = rotinaRepository.findByUsuarioId(usuario.getId());
        var resumoRotinas = new ConquistaCalculator.Rotinas(
                rotinas.size(),
                (int) rotinas.stream().filter(r -> !r.getLembretes().isEmpty()).count(),
                (int) rotinas.stream().filter(RotinaModel::isAtiva).count());

        int maiorStreak = streakService.obter(username).maior();
        int metaAguaMl = metaAguaService.resolver(usuario).metaMl();

        Map<Conquista, Integer> valores =
                ConquistaCalculator.calcular(historico, resumoRotinas, maiorStreak, metaAguaMl);

        Map<String, ConquistaUsuarioModel> existentes = new HashMap<>();
        for (ConquistaUsuarioModel c : conquistaRepository.findByUsuarioId(usuario.getId())) {
            existentes.putIfAbsent(c.getCodigo(), c);
        }

        LocalDateTime agora = LocalDateTime.now(FUSO);
        List<ConquistaDTO> lista = new ArrayList<>();
        int desbloqueadas = 0;

        for (Conquista c : Conquista.values()) {
            int valor = valores.getOrDefault(c, 0);
            int meta = ConquistaCalculator.metaDe(c, metaAguaMl);
            ConquistaUsuarioModel registro = existentes.get(c.name());
            boolean cumprida = valor >= meta;
            boolean nova = false;

            if (registro == null && cumprida && gravar) {
                registro = new ConquistaUsuarioModel();
                registro.setUsuario(usuario);
                registro.setCodigo(c.name());
                registro.setDataDesbloqueio(agora);
                registro = conquistaRepository.save(registro);
                nova = true;
            }

            // Sem gravar, uma conquista cumprida ainda aparece como desbloqueada (sem data).
            boolean desbloqueada = registro != null || cumprida;
            if (desbloqueada) {
                desbloqueadas++;
            }
            int atual = desbloqueada ? meta : Math.min(valor, meta);

            lista.add(new ConquistaDTO(
                    c.name(), c.getNome(), c.getDescricao(), c.getCategoria(), c.getIcone(),
                    desbloqueada,
                    registro == null ? null : registro.getDataDesbloqueio(),
                    atual, meta, c.getUnidade(), nova));
        }

        return new ConquistasResponseDTO(desbloqueadas, lista.size(), lista);
    }
}
