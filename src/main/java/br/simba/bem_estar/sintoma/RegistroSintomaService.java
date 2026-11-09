package br.simba.bem_estar.sintoma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

@Service
public class RegistroSintomaService {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");
    /** Quantos dias o histórico devolve (hoje incluído). */
    static final int DIAS_HISTORICO = 30;

    private final UserRepository userRepository;
    private final RegistroSintomaRepository repository;

    public RegistroSintomaService(UserRepository userRepository, RegistroSintomaRepository repository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    /** Salva o questionário de hoje. Se hoje já foi respondido, atualiza o mesmo registro. */
    @Transactional
    public RegistroSintomaResponseDTO salvarHoje(String username, RegistroSintomaDTO dados) {
        UserModel usuario = buscarUsuario(username);
        SintomaCalculator.Respostas r = SintomaCalculator.validar(dados);
        LocalDate hoje = LocalDate.now(FUSO);
        LocalDateTime agora = LocalDateTime.now(FUSO);

        RegistroSintomaModel registro = repository
                .findByUsuarioIdAndDataRegistro(usuario.getId(), hoje)
                .orElseGet(() -> {
                    RegistroSintomaModel novo = new RegistroSintomaModel();
                    novo.setUsuario(usuario);
                    novo.setDataRegistro(hoje);
                    novo.setCriadoEm(agora);
                    return novo;
                });

        registro.setEnergia(r.energia());
        registro.setHumor(r.humor());
        registro.setEstresse(r.estresse());
        registro.setDor(r.dor());
        registro.setLocaisDor(SintomaCalculator.paraTexto(r.locaisDor()));
        registro.setSintomas(SintomaCalculator.paraTexto(r.sintomas()));
        registro.setObservacao(r.observacao());
        registro.setAtualizadoEm(agora);

        return paraDTO(repository.save(registro));
    }

    @Transactional(readOnly = true)
    public SintomaHojeDTO hoje(String username) {
        UserModel usuario = buscarUsuario(username);
        LocalDate hoje = LocalDate.now(FUSO);
        return repository.findByUsuarioIdAndDataRegistro(usuario.getId(), hoje)
                .map(r -> new SintomaHojeDTO(true, hoje, paraDTO(r)))
                .orElseGet(() -> new SintomaHojeDTO(false, hoje, null));
    }

    /** Últimos 30 dias, do mais recente para o mais antigo, mais o resumo da semana. */
    @Transactional(readOnly = true)
    public SintomaHistoricoDTO historico(String username) {
        UserModel usuario = buscarUsuario(username);
        LocalDate hoje = LocalDate.now(FUSO);
        List<RegistroSintomaModel> registros = repository
                .findByUsuarioIdAndDataRegistroGreaterThanEqualOrderByDataRegistroDesc(
                        usuario.getId(), hoje.minusDays(DIAS_HISTORICO - 1L));

        List<RegistroSintomaResponseDTO> lista = new ArrayList<>();
        List<SintomaCalculator.Dia> dias = new ArrayList<>();
        for (RegistroSintomaModel r : registros) {
            lista.add(paraDTO(r));
            dias.add(new SintomaCalculator.Dia(
                    r.getDataRegistro(), r.getEnergia(), r.getHumor(), r.getEstresse(), r.getDor(),
                    SintomaCalculator.deTexto(Sintoma.class, r.getSintomas())));
        }
        return new SintomaHistoricoDTO(lista, SintomaCalculator.resumirSemana(dias, hoje));
    }

    private RegistroSintomaResponseDTO paraDTO(RegistroSintomaModel r) {
        return new RegistroSintomaResponseDTO(
                r.getId(),
                r.getDataRegistro(),
                r.getEnergia(),
                r.getHumor(),
                r.getEstresse(),
                r.getDor().name(),
                nomes(SintomaCalculator.deTexto(LocalDor.class, r.getLocaisDor())),
                nomes(SintomaCalculator.deTexto(Sintoma.class, r.getSintomas())),
                r.getObservacao());
    }

    private static List<String> nomes(List<? extends Enum<?>> itens) {
        List<String> lista = new ArrayList<>();
        for (Enum<?> e : itens) {
            lista.add(e.name());
        }
        return lista;
    }

    private UserModel buscarUsuario(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new DadoNaoEncontradoException("Usuário não encontrado"));
    }
}
