package br.simba.bem_estar.progresso;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.simba.bem_estar.registroAgua.RegistroAguaModel;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;

import br.simba.bem_estar.registroExercicio.RegistroExercicioModel;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;

import br.simba.bem_estar.registroSono.RegistroSonoModel;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;

import br.simba.bem_estar.user.UserModel;


@Service
public class ProgressoService {

    private final RegistroSonoRepository sonoRepository;

    private final RegistroAguaRepository aguaRepository;

    private final RegistroExercicioRepository exercicioRepository;


    public ProgressoService(
            RegistroSonoRepository sonoRepository,
            RegistroAguaRepository aguaRepository,
            RegistroExercicioRepository exercicioRepository) {

        this.sonoRepository = sonoRepository;

        this.aguaRepository = aguaRepository;

        this.exercicioRepository =
            exercicioRepository;
    }


    public ProgressoDTO obterProgresso(
            UserModel usuario,
            LocalDate inicio,
            LocalDate fim) {

        List<SonoProgressoDTO> sono =
            obterSono(usuario, inicio, fim);

        List<AguaProgressoDTO> hidratacao =
            obterHidratacao(usuario, inicio, fim);

        List<TreinoProgressoDTO> treinos =
            obterTreinos(usuario, inicio, fim);


        return new ProgressoDTO(
            sono,
            hidratacao,
            treinos
        );
    }


    // =========================================
    // SONO
    // =========================================

    private List<SonoProgressoDTO> obterSono(
            UserModel usuario,
            LocalDate inicio,
            LocalDate fim) {

        LocalDateTime dataInicio =
            inicio.atStartOfDay();

        LocalDateTime dataFim =
            fim.atTime(LocalTime.MAX);


        List<RegistroSonoModel> registros =
            sonoRepository
                .findByUsuario_IdAndHoraAcordarBetweenOrderByHoraAcordarAsc(
                    usuario.getId(),
                    dataInicio,
                    dataFim
                );


        Map<LocalDate, List<RegistroSonoModel>>
            registrosPorDia = registros
                .stream()
                .filter(registro ->
                    registro.getHoraDormir() != null &&
                    registro.getHoraAcordar() != null
                )
                .collect(
                    Collectors.groupingBy(
                        registro ->
                            registro
                                .getHoraAcordar()
                                .toLocalDate()
                    )
                );


        List<SonoProgressoDTO> resultado =
            new ArrayList<>();


        LocalDate dataAtual = inicio;


        while (!dataAtual.isAfter(fim)) {

            List<RegistroSonoModel> registrosDia =
                registrosPorDia.get(dataAtual);


            if (
                registrosDia == null ||
                registrosDia.isEmpty()
            ) {

                resultado.add(
                    new SonoProgressoDTO(
                        dataAtual,
                        null,
                        null
                    )
                );

            } else {

                double mediaHoras =
                    registrosDia
                        .stream()
                        .mapToDouble(
                            this::calcularHorasSono
                        )
                        .average()
                        .orElse(0);


                double mediaNota =
                    registrosDia
                        .stream()
                        .filter(registro ->
                            registro.getNotaSono() != null
                        )
                        .mapToInt(
                            registro -> registro.getNotaSono()
                        )
                        .average()
                        .orElse(0);


                resultado.add(
                    new SonoProgressoDTO(
                        dataAtual,
                        arredondar(mediaHoras),
                        arredondar(mediaNota)
                    )
                );
            }


            dataAtual =
                dataAtual.plusDays(1);
        }


        return resultado;
    }


    private double calcularHorasSono(
            RegistroSonoModel registro) {

        long minutos =
            Duration
                .between(
                    registro.getHoraDormir(),
                    registro.getHoraAcordar()
                )
                .toMinutes();


        if (minutos <= 0) {
            return 0;
        }


        return minutos / 60.0;
    }


    // =========================================
    // HIDRATAÇÃO
    // =========================================

    private List<AguaProgressoDTO> obterHidratacao(
            UserModel usuario,
            LocalDate inicio,
            LocalDate fim) {

        LocalDateTime dataInicio =
            inicio.atStartOfDay();

        LocalDateTime dataFim =
            fim.atTime(LocalTime.MAX);


        List<RegistroAguaModel> registros =
            aguaRepository
                .findByUsuarioAndDataHoraBetweenOrderByDataHoraAsc(
                    usuario,
                    dataInicio,
                    dataFim
                );


        Map<LocalDate, Double> aguaPorDia =
            registros
                .stream()
                .collect(
                    Collectors.groupingBy(

                        registro ->
                            registro
                                .getDataHora()
                                .toLocalDate(),

                        Collectors.summingDouble(
                            registro -> registro.getQuantidadeMl()
                        )
                    )
                );


        List<AguaProgressoDTO> resultado =
            new ArrayList<>();


        LocalDate dataAtual = inicio;


        while (!dataAtual.isAfter(fim)) {

            double quantidade =
                aguaPorDia.getOrDefault(
                    dataAtual,
                    0.0
                );


            resultado.add(
                new AguaProgressoDTO(
                    dataAtual,
                    arredondar(quantidade)
                )
            );


            dataAtual =
                dataAtual.plusDays(1);
        }


        return resultado;
    }


    // =========================================
    // TREINOS
    // =========================================

    private List<TreinoProgressoDTO> obterTreinos(
            UserModel usuario,
            LocalDate inicio,
            LocalDate fim) {

        LocalDateTime dataInicio =
            inicio.atStartOfDay();

        LocalDateTime dataFim =
            fim.atTime(LocalTime.MAX);


        List<RegistroExercicioModel> registros =
            exercicioRepository
                .findByUsuarioAndDataHoraBetweenOrderByDataHoraAsc(
                    usuario,
                    dataInicio,
                    dataFim
                );


        Map<LocalDate, Long> treinosPorDia =
            registros
                .stream()
                .collect(
                    Collectors.groupingBy(

                        registro ->
                            registro
                                .getDataHora()
                                .toLocalDate(),

                        Collectors.counting()
                    )
                );


        List<TreinoProgressoDTO> resultado =
            new ArrayList<>();


        LocalDate dataAtual = inicio;


        while (!dataAtual.isAfter(fim)) {

            int quantidade =
                treinosPorDia
                    .getOrDefault(
                        dataAtual,
                        0L
                    )
                    .intValue();


            resultado.add(
                new TreinoProgressoDTO(
                    dataAtual,
                    quantidade > 0,
                    quantidade
                )
            );


            dataAtual =
                dataAtual.plusDays(1);
        }


        return resultado;
    }


    private double arredondar(
            double valor) {

        return Math.round(
            valor * 100.0
        ) / 100.0;
    }
}