package br.simba.bem_estar.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.simba.bem_estar.meta.MetaModel;
import br.simba.bem_estar.meta.MetaRepository;
import br.simba.bem_estar.meta.TipoMeta;
import br.simba.bem_estar.perfil.PerfilModel;
import br.simba.bem_estar.perfil.PerfilRepository;
import br.simba.bem_estar.registroAgua.RegistroAguaModel;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioModel;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoModel;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.rotina.RotinaLembreteModel;
import br.simba.bem_estar.rotina.RotinaModel;
import br.simba.bem_estar.rotina.RotinaRepository;
import br.simba.bem_estar.user.UserModel;
import br.simba.bem_estar.user.UserRepository;

/**
 * Cria um usuário de demonstração com ~30 dias de uso simulado.
 * Só roda com o perfil "demo" ativo, então nunca afeta o uso normal.
 *
 * Login: demo / demo123
 */
@Component
@Profile("demo")
public class DemoDataSeeder implements CommandLineRunner {

    private static final String USERNAME = "demo";
    private static final String SENHA = "demo123";
    private static final int DIAS = 30;

    private final UserRepository userRepository;
    private final PerfilRepository perfilRepository;
    private final RegistroSonoRepository sonoRepository;
    private final RegistroAguaRepository aguaRepository;
    private final RegistroExercicioRepository exercicioRepository;
    private final RotinaRepository rotinaRepository;
    private final MetaRepository metaRepository;
    private final PasswordEncoder passwordEncoder;

    public DemoDataSeeder(
            UserRepository userRepository,
            PerfilRepository perfilRepository,
            RegistroSonoRepository sonoRepository,
            RegistroAguaRepository aguaRepository,
            RegistroExercicioRepository exercicioRepository,
            RotinaRepository rotinaRepository,
            MetaRepository metaRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.perfilRepository = perfilRepository;
        this.sonoRepository = sonoRepository;
        this.aguaRepository = aguaRepository;
        this.exercicioRepository = exercicioRepository;
        this.rotinaRepository = rotinaRepository;
        this.metaRepository = metaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.findByUsername(USERNAME).isPresent()) {
            return;
        }

        Random random = new Random(42); // semente fixa: os dados são os mesmos a cada execução

        PerfilModel perfil = new PerfilModel();
        perfil.setPeso(72.5);
        perfil.setAltura(1.75);
        perfil.setIdade(24);
        perfil.setStreak(14);
        perfil = perfilRepository.save(perfil);

        UserModel usuario = new UserModel();
        usuario.setName("Usuário Demo");
        usuario.setUsername(USERNAME);
        usuario.setEmail("demo@simba.com");
        usuario.setPassword(passwordEncoder.encode(SENHA));
        usuario.setPerfil(perfil);
        usuario = userRepository.save(usuario);

        LocalDate hoje = LocalDate.now();
        for (int i = DIAS; i >= 0; i--) {
            LocalDate dia = hoje.minusDays(i);
            boolean ehHoje = i == 0;
            // Dias sem nenhum registro. A ofensiva tolera até 2 faltas seguidas (e até 2 por
            // semana), então estes dias mostram a regra funcionando: a ofensiva NÃO quebra.
            // Ontem (i == 1) e hoje (i == 0) também ficam vazios: a ofensiva abre "em risco"
            // (leão com medo) e volta ao normal assim que o usuário registrar algo hoje.
            if (i == 14 || i == 13 || i == 22 || i == 1 || i == 0) {
                continue;
            }
            gerarSono(usuario, dia, random);
            gerarAgua(usuario, dia, random, ehHoje);
            gerarTreino(usuario, dia, random, ehHoje);
        }
        gerarRotinas(usuario);
        gerarMetas(usuario, hoje);

        System.out.println(">>> [demo] Usuário criado: " + USERNAME + " / " + SENHA);
    }

    private void gerarSono(UserModel usuario, LocalDate dia, Random random) {
        // Dormiu na noite anterior e acordou na manhã deste dia.
        LocalDateTime dormir = dia.minusDays(1).atTime(22, 0)
                .plusMinutes(random.nextInt(150));
        LocalDateTime acordar = dia.atTime(6, 0).plusMinutes(random.nextInt(90));
        RegistroSonoModel sono = new RegistroSonoModel();
        sono.setHoraDormir(dormir);
        sono.setHoraAcordar(acordar);
        sono.setNotaSono(2 + random.nextInt(4)); // 2 a 5
        sono.setUsuario(usuario);
        sonoRepository.save(sono);
    }

    private void gerarAgua(UserModel usuario, LocalDate dia, Random random, boolean ehHoje) {
        int[] horas = {8, 10, 12, 14, 16, 18, 20};
        int limite = ehHoje ? Math.min(horas.length, 1 + LocalTime.now().getHour() / 4) : horas.length;
        int copos = ehHoje ? limite : 4 + random.nextInt(4);
        for (int c = 0; c < copos && c < horas.length; c++) {
            if (ehHoje && horas[c] > LocalTime.now().getHour()) break;
            RegistroAguaModel agua = new RegistroAguaModel();
            agua.setQuantidadeMl(300 + 50 * random.nextInt(5)); // 300 a 500 ml
            agua.setDataHora(dia.atTime(horas[c], random.nextInt(50)));
            agua.setUsuario(usuario);
            aguaRepository.save(agua);
        }
    }

    private void gerarTreino(UserModel usuario, LocalDate dia, Random random, boolean ehHoje) {
        // Treina em ~4 de cada 7 dias; hoje fica sem treino para o dashboard mostrar "pendente".
        if (ehHoje || random.nextInt(7) >= 4) {
            return;
        }
        String[] modalidades = {"Musculação", "Corrida", "Caminhada", "Ciclismo", "Alongamento"};
        int[] kcalPorMin = {6, 11, 4, 8, 3};
        int m = random.nextInt(modalidades.length);
        int minutos = 25 + random.nextInt(50);
        RegistroExercicioModel treino = new RegistroExercicioModel();
        treino.setModalidade(modalidades[m]);
        treino.setDuracaominutos(minutos);
        treino.setGastoCaloricoExtimado((float) (minutos * kcalPorMin[m]));
        treino.setDataHora(dia.atTime(17 + random.nextInt(3), random.nextInt(60)));
        treino.setUsuario(usuario);
        exercicioRepository.save(treino);
    }

    private void gerarMetas(UserModel usuario, LocalDate hoje) {
        // Meta começando há 10 dias: o progresso já nasce parcial e continua sendo atualizado sozinho.
        MetaModel treinos = new MetaModel();
        treinos.setUsuario(usuario);
        treinos.setTipo(TipoMeta.TREINO_TOTAL);
        treinos.setAlvo(10);
        treinos.setDataInicio(hoje.minusDays(10));
        metaRepository.save(treinos);

        MetaModel agua = new MetaModel();
        agua.setUsuario(usuario);
        agua.setTipo(TipoMeta.AGUA_SEGUIDOS);
        agua.setAlvo(5);
        agua.setDataInicio(hoje.minusDays(7));
        metaRepository.save(agua);
    }

    private void gerarRotinas(UserModel usuario) {
        criarRotina(usuario, "Treinos", "Academia e corrida durante a semana", true,
                lembrete("Hora de treinar", "Bora pra academia!", LocalTime.of(18, 0), "1,3,5"),
                lembrete("Corrida leve", "30 minutos de corrida", LocalTime.of(7, 0), "6"));
        criarRotina(usuario, "Leitura", "Ler um pouco antes de dormir", true,
                lembrete("Ler 20 páginas", "", LocalTime.of(21, 30), "1,2,3,4,5,6,7"));
        criarRotina(usuario, "Estudo", "Revisar matérias da faculdade", true,
                lembrete("Estudar Spring Boot", "", LocalTime.of(19, 30), "2,4"));
        criarRotina(usuario, "Meditação", "Pausa para respirar", false);
    }

    private RotinaLembreteModel lembrete(String titulo, String mensagem, LocalTime hora, String dias) {
        RotinaLembreteModel l = new RotinaLembreteModel();
        l.setTitulo(titulo);
        l.setMensagem(mensagem);
        l.setHora(hora);
        l.setDiasSemana(dias);
        return l;
    }

    private void criarRotina(UserModel usuario, String nome, String descricao, boolean ativa,
            RotinaLembreteModel... lembretes) {
        RotinaModel rotina = new RotinaModel();
        rotina.setUsuario(usuario);
        rotina.setNome(nome);
        rotina.setDescricao(descricao);
        rotina.setAtiva(ativa);
        for (RotinaLembreteModel l : List.of(lembretes)) {
            l.setRotina(rotina);
            rotina.getLembretes().add(l);
        }
        rotinaRepository.save(rotina);
    }
}
