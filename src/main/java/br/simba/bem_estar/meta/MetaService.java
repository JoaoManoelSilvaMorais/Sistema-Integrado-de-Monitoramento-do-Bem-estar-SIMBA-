package br.simba.bem_estar.meta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.DadosDuplicadosException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class MetaService {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");
    static final int MAX_METAS_ATIVAS = 5;

    private final UserRepository userRepository;
    private final MetaRepository metaRepository;
    private final HistoricoService historicoService;
    private final MetaAguaService metaAguaService;

    public MetaService(
            UserRepository userRepository,
            MetaRepository metaRepository,
            HistoricoService historicoService,
            MetaAguaService metaAguaService) {
        this.userRepository = userRepository;
        this.metaRepository = metaRepository;
        this.historicoService = historicoService;
        this.metaAguaService = metaAguaService;
    }

    /**
     * Lista as metas com o progresso atualizado. Com gravar = true, as que acabaram
     * de ser cumpridas são marcadas como concluídas (e voltam com nova = true uma vez).
     */
    @Transactional
    public List<MetaDTO> listar(String username, boolean gravar) {
        UserModel usuario = buscarUsuario(username);
        Historico historico = historicoService.carregar(usuario);
        int metaAguaMl = metaAguaService.resolver(usuario).metaMl();
        LocalDate hoje = LocalDate.now(FUSO);
        LocalDateTime agora = LocalDateTime.now(FUSO);

        List<MetaDTO> lista = new ArrayList<>();
        for (MetaModel meta : metaRepository.findByUsuarioId(usuario.getId())) {
            MetaCalculator.Progresso p =
                    MetaCalculator.calcular(meta.getTipo(), meta.getDataInicio(), hoje, historico, metaAguaMl);

            boolean cumprida = meta.getConcluidaEm() != null || p.melhor() >= meta.getAlvo();
            boolean nova = false;
            if (cumprida && meta.getConcluidaEm() == null && gravar) {
                meta.setConcluidaEm(agora);
                metaRepository.save(meta);
                nova = true;
            }

            TipoMeta tipo = meta.getTipo();
            lista.add(new MetaDTO(
                    meta.getId(), tipo.name(), tipo.titulo(meta.getAlvo()), tipo.getIcone(),
                    meta.getAlvo(),
                    cumprida ? meta.getAlvo() : Math.min(p.atual(), meta.getAlvo()),
                    Math.min(p.melhor(), meta.getAlvo()),
                    tipo.getUnidade(), cumprida, meta.getDataInicio(), meta.getConcluidaEm(), nova,
                    Math.min(tipo.getMax(), meta.getAlvo() + tipo.getPasso())));
        }

        // Ativas primeiro (a mais adiantada no topo); depois as concluídas, da mais recente à mais antiga.
        lista.sort(Comparator
                .comparing(MetaDTO::concluida)
                .thenComparingDouble(m -> m.concluida() ? 0.0 : -(double) m.progressoAtual() / m.alvo())
                .thenComparing(MetaDTO::concluidaEm, Comparator.nullsLast(Comparator.reverseOrder())));
        return lista;
    }

    @Transactional
    public MetaDTO criar(String username, MetaCriarDTO dados) {
        UserModel usuario = buscarUsuario(username);

        TipoMeta tipo;
        try {
            tipo = TipoMeta.valueOf(dados.tipo() == null ? "" : dados.tipo().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RegraDeNegocioException("Tipo de meta inválido.");
        }

        int alvo = dados.alvo() == null ? tipo.getPadrao() : dados.alvo();
        if (alvo < tipo.getMin() || alvo > tipo.getMax()) {
            throw new RegraDeNegocioException(
                    "O alvo deve ficar entre " + tipo.getMin() + " e " + tipo.getMax() + ".");
        }

        List<MetaModel> existentes = metaRepository.findByUsuarioId(usuario.getId());
        long ativas = existentes.stream().filter(m -> m.getConcluidaEm() == null).count();
        if (ativas >= MAX_METAS_ATIVAS) {
            throw new RegraDeNegocioException(
                    "Você já tem " + MAX_METAS_ATIVAS + " metas ativas. Conclua ou exclua uma para criar outra.");
        }
        boolean jaTemDoTipo = existentes.stream()
                .anyMatch(m -> m.getConcluidaEm() == null && m.getTipo() == tipo);
        if (jaTemDoTipo) {
            throw new DadosDuplicadosException("Você já tem uma meta ativa desse tipo.");
        }

        MetaModel meta = new MetaModel();
        meta.setUsuario(usuario);
        meta.setTipo(tipo);
        meta.setAlvo(alvo);
        meta.setDataInicio(LocalDate.now(FUSO));
        meta = metaRepository.save(meta);

        Long id = meta.getId();
        return listar(username, false).stream()
                .filter(m -> m.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new DadoNaoEncontradoException("Meta não encontrada."));
    }

    @Transactional
    public void excluir(String username, Long id) {
        UserModel usuario = buscarUsuario(username);
        MetaModel meta = metaRepository.findByIdAndUsuarioId(id, usuario.getId())
                .orElseThrow(() -> new DadoNaoEncontradoException("Meta não encontrada."));
        metaRepository.delete(meta);
    }

    private UserModel buscarUsuario(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));
    }
}
