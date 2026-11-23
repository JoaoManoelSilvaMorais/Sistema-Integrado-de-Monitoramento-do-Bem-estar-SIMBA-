package br.simba.bem_estar.alerta;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.meta.MetaAguaService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class AlertaService {

    // Fixa o fuso: se o servidor rodar em UTC, o "hoje" não vira o dia errado à noite.
    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    private final UserRepository userRepository;
    private final HistoricoService historicoService;
    private final MetaAguaService metaAguaService;

    public AlertaService(
            UserRepository userRepository,
            HistoricoService historicoService,
            MetaAguaService metaAguaService) {
        this.userRepository = userRepository;
        this.historicoService = historicoService;
        this.metaAguaService = metaAguaService;
    }

    @Transactional(readOnly = true)
    public AlertasResponseDTO obter(String username) {
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));

        Historico historico = historicoService.carregar(usuario);
        int metaAguaMl = metaAguaService.resolver(usuario).metaMl();

        List<AlertaDTO> alertas = AlertaCalculator.calcular(historico, metaAguaMl, LocalDate.now(FUSO));
        return new AlertasResponseDTO(alertas, AlertaCalculator.AVISO);
    }
}
