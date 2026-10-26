package br.simba.bem_estar.streak;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.historico.Historico;
import br.simba.bem_estar.historico.HistoricoCalculos;
import br.simba.bem_estar.historico.HistoricoService;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class StreakService {

    // Fixa o fuso: se o servidor rodar em UTC, o "hoje" não vira o dia errado à noite.
    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    private final UserRepository userRepository;
    private final HistoricoService historicoService;

    public StreakService(UserRepository userRepository, HistoricoService historicoService) {
        this.userRepository = userRepository;
        this.historicoService = historicoService;
    }

    @Transactional(readOnly = true)
    public StreakDTO obter(String username) {
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException(
                        "Usuário não encontrado com o username: " + username));

        Historico historico = historicoService.carregar(usuario);
        LocalDate hoje = LocalDate.now(FUSO);

        Set<LocalDate> diasAgua = HistoricoCalculos.aguaPorDia(historico.agua()).keySet();
        Set<LocalDate> diasSono = HistoricoCalculos.diasSono(historico.sono());
        Set<LocalDate> diasTreino = HistoricoCalculos.diasTreino(historico.treinos());

        Set<LocalDate> todos = new HashSet<>(diasAgua);
        todos.addAll(diasSono);
        todos.addAll(diasTreino);

        return StreakCalculator.calcular(todos, hoje)
                .comRegistrosDeHoje(diasAgua.contains(hoje), diasSono.contains(hoje), diasTreino.contains(hoje));
    }
}
