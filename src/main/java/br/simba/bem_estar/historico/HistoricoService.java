package br.simba.bem_estar.historico;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.user.UserModel;

/** Carrega os registros do usuário (água, sono e treinos) em tipos simples. */
@Service
public class HistoricoService {

    private final RegistroAguaRepository aguaRepository;
    private final RegistroSonoRepository sonoRepository;
    private final RegistroExercicioRepository exercicioRepository;

    public HistoricoService(
            RegistroAguaRepository aguaRepository,
            RegistroSonoRepository sonoRepository,
            RegistroExercicioRepository exercicioRepository) {
        this.aguaRepository = aguaRepository;
        this.sonoRepository = sonoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    @Transactional(readOnly = true)
    public Historico carregar(UserModel usuario) {
        var agua = aguaRepository.findByUsuario(usuario).stream()
                .map(r -> new Historico.Agua(r.getDataHora(), r.getQuantidadeMl()))
                .toList();

        var sono = sonoRepository.findByUsuario_IdOrderByHoraDormirDesc(usuario.getId()).stream()
                .map(r -> new Historico.Sono(r.getHoraDormir(), r.getHoraAcordar(), r.getNotaSono()))
                .toList();

        var treinos = exercicioRepository.findByUsuario(usuario).stream()
                .map(r -> new Historico.Treino(
                        r.getModalidade(),
                        r.getDuracaominutos() == null ? 0 : r.getDuracaominutos(),
                        r.getGastoCaloricoExtimado(),
                        r.getDataHora()))
                .toList();

        return new Historico(agua, sono, treinos);
    }
}
