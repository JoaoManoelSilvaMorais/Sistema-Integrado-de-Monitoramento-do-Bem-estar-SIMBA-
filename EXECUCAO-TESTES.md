# Execução Completa dos Testes — SIMBA

- **Comando executado:** `.\mvnw.cmd test`
- **Data e hora de término:** `2026-11-16T20:16:02-03:00`
- **Resultado final:** `BUILD SUCCESS` (`Tests run: 188, Failures: 0, Errors: 0, Skipped: 0`)
- **Tempo total:** `02:22 min`
- **Escopo:** Testes de unidade, integração (`@AutoConfigureMockMvc`) e Ponta a Ponta com Selenium WebDriver + Microsoft Edge headless (`*E2ETest`).

## Resumo por Classe de Teste

```text
BemEstarApplicationTests .................... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (16.72 s)
ComparativoCalculatorTest ................... Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.145 s)
ComparativoControllerTest ................... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.315 s)
ComparativoServiceTest ...................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.477 s)
ConquistaCalculatorTest ..................... Tests run: 4, Failures: 0, Errors: 0, Skipped: 0 (0.018 s)
ConquistaControllerTest ..................... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.083 s)
ConquistaServiceTest ........................ Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.246 s)
GamificacaoDashboardIntegrationTest ......... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (6.046 s)
DemoDataSeederIntegrationTest ............... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (2.947 s)
DemoDataSeederTest .......................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.587 s)
AuthPerfilE2ETest ........................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (18.60 s)
ConquistasProgressoE2ETest .................. Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (16.45 s)
DashboardHidratacaoSonoTreinoE2ETest ........ Tests run: 4, Failures: 0, Errors: 0, Skipped: 0 (35.47 s)
DemoFluxoE2ETest ............................ Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (9.280 s)
SintomasRotinasLembretesE2ETest ............. Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (23.60 s)
HistoricoCalculosTest ....................... Tests run: 8, Failures: 0, Errors: 0, Skipped: 0 (0.011 s)
HistoricoServiceTest ........................ Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.005 s)
RestExceptionHandlerTest .................... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.050 s)
LembreteControllerTest ...................... Tests run: 4, Failures: 0, Errors: 0, Skipped: 0 (0.053 s)
MetaAguaCalculatorTest ...................... Tests run: 4, Failures: 0, Errors: 0, Skipped: 0 (0.007 s)
MetaAguaServiceTest ......................... Tests run: 6, Failures: 0, Errors: 0, Skipped: 0 (0.086 s)
MetaCalculatorTest .......................... Tests run: 4, Failures: 0, Errors: 0, Skipped: 0 (0.008 s)
MetaControllerTest .......................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.072 s)
MetaServiceTest ............................. Tests run: 4, Failures: 0, Errors: 0, Skipped: 0 (0.043 s)
MedidasCalculatorTest ....................... Tests run: 6, Failures: 0, Errors: 0, Skipped: 0 (0.015 s)
PerfilControllerTest ........................ Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.040 s)
PerfilMedidasIntegrationTest ................ Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.534 s)
PerfilServiceTest ........................... Tests run: 6, Failures: 0, Errors: 0, Skipped: 0 (0.031 s)
SugestoesCalculatorTest ..................... Tests run: 12, Failures: 0, Errors: 0, Skipped: 0 (0.036 s)
ProgressoControllerTest ..................... Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.019 s)
ProgressoServiceTest ........................ Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.005 s)
RegistrosMonitoramentoIntegrationTest ....... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.706 s)
ProximoPassoCalculatorTest .................. Tests run: 7, Failures: 0, Errors: 0, Skipped: 0 (0.017 s)
ProximoPassoControllerTest .................. Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.013 s)
ProximoPassoServiceTest ..................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.009 s)
RegistroAguaControllerTest .................. Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.011 s)
RegistroExercicioControllerTest ............. Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.015 s)
RegistroSonoControllerTest .................. Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.017 s)
RotinaControllerTest ........................ Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.027 s)
RotinaLembreteIntegrationTest ............... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.758 s)
RotinaServiceTest ........................... Tests run: 6, Failures: 0, Errors: 0, Skipped: 0 (0.023 s)
AuthControllerTest .......................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.026 s)
AuthUserIntegrationTest ..................... Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (1.772 s)
JwtAuthenticationFilterTest ................. Tests run: 5, Failures: 0, Errors: 0, Skipped: 0 (0.028 s)
JWTServiceTest .............................. Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.044 s)
RegistroSintomaControllerTest ............... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.052 s)
RegistroSintomaServiceTest .................. Tests run: 6, Failures: 0, Errors: 0, Skipped: 0 (0.026 s)
SintomaCalculatorTest ....................... Tests run: 17, Failures: 0, Errors: 0, Skipped: 0 (0.023 s)
SintomasIntegrationTest ..................... Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.335 s)
StreakCalculatorTest ........................ Tests run: 11, Failures: 0, Errors: 0, Skipped: 0 (0.017 s)
StreakControllerTest ........................ Tests run: 1, Failures: 0, Errors: 0, Skipped: 0 (0.008 s)
StreakServiceTest ........................... Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.011 s)
UserAccountServiceTest ...................... Tests run: 3, Failures: 0, Errors: 0, Skipped: 0 (0.020 s)
UserControllerTest .......................... Tests run: 5, Failures: 0, Errors: 0, Skipped: 0 (0.022 s)
UserDetailsServiceImplTest .................. Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 (0.006 s)
```

## Saída Integral do Terminal (`.\mvnw.cmd test`)

````text
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< br.simba:bem-estar >-------------------------
[INFO] Building  0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.5.0:resources (default-resources) @ bem-estar ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 45 resources from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.15.0:compile (default-compile) @ bem-estar ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.5.0:testResources (default-testResources) @ bem-estar ---
[INFO] Copying 2 resources from src\test\resources to target\test-classes
[INFO] 
[INFO] --- compiler:3.15.0:testCompile (default-testCompile) @ bem-estar ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- surefire:3.5.6:test (default-test) @ bem-estar ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running br.simba.bem_estar.BemEstarApplicationTests
20:13:47.276 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [br.simba.bem_estar.BemEstarApplicationTests]: BemEstarApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
20:13:47.587 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.BemEstarApplicationTests
20:13:47.781 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [br.simba.bem_estar.BemEstarApplicationTests]: BemEstarApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
20:13:47.783 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.BemEstarApplicationTests
20:13:48.033 [main] INFO org.springframework.boot.devtools.restart.RestartApplicationListener -- Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.1.1)

2026-11-16T20:13:48.480-03:00  INFO 2828 --- [simba-backend] [           main] b.s.bem_estar.BemEstarApplicationTests   : Starting BemEstarApplicationTests using Java 21.0.12.1 with PID 2828 (started by João Manoel in C:\Users\João Manoel\Documents\SIMBA\Sistema-Integrado-de-Monitoramento-do-Bem-estar-SIMBA-)
2026-11-16T20:13:48.483-03:00  INFO 2828 --- [simba-backend] [           main] b.s.bem_estar.BemEstarApplicationTests   : No active profile set, falling back to 1 default profile: "default"
2026-11-16T20:13:50.503-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:13:50.506-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2026-11-16T20:13:50.604-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.conquista.ConquistaUsuarioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.606-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.lembrete.LembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.609-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.612-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.613-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.perfil.PerfilRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.615-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroAgua.RegistroAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.616-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroExercicio.RegistroExercicioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.620-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroSono.RegistroSonoRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.621-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaLembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.621-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.624-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.sintoma.RegistroSintomaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.627-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.user.UserRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:13:50.628-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 111 ms. Found 0 JDBC repository interfaces.
2026-11-16T20:13:50.657-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:13:50.661-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-11-16T20:13:50.813-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 140 ms. Found 12 JPA repository interfaces.
2026-11-16T20:13:52.153-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-11-16T20:13:52.299-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.core                   : HHH000001: Hibernate ORM core version 7.4.5.Final
2026-11-16T20:13:55.120-03:00  INFO 2828 --- [simba-backend] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-11-16T20:13:55.350-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2026-11-16T20:13:56.115-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:simba user=SA
2026-11-16T20:13:56.122-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2026-11-16T20:13:56.227-03:00  WARN 2828 --- [simba-backend] [           main] org.hibernate.orm.deprecation            : HHH90000025: H2Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2026-11-16T20:13:56.329-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [jdbc:h2:mem:simba]
	Database driver: H2 JDBC Driver
	Database dialect: H2Dialect
	Database version: 2.4.240
	Default catalog/schema: SIMBA/PUBLIC
	Autocommit mode: undefined/unknown
	Isolation level: READ_COMMITTED [default READ_COMMITTED]
	JDBC fetch size: 100
	Pool: DataSourceConnectionProvider
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2026-11-16T20:13:59.673-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: 
    create table registro_sono (
        id bigint generated by default as identity,
        hora_acordar timestamp(6),
        hora_dormir timestamp(6),
        nota_sono integer,
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_conquista_usuario (
        id bigint generated by default as identity,
        codigo varchar(255),
        data_desbloqueio timestamp(6),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_lembretes (
        id bigint generated by default as identity,
        horario timestamp(6),
        mensagem varchar(255),
        titulo varchar(255),
        user_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_meta (
        id bigint generated by default as identity,
        alvo integer not null,
        concluida_em timestamp(6),
        data_inicio date,
        tipo enum ('AGUA_SEGUIDOS','SONO_SEGUIDOS','TREINO_SEGUIDOS','TREINO_TOTAL'),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_meta_agua (
        id bigint generated by default as identity,
        meta_ml integer not null,
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_perfil (
        id bigint generated by default as identity,
        altura float(53) not null,
        idade integer,
        peso float(53) not null,
        streak integer,
        primary key (id)
    )
Hibernate: 
    create table tb_registro_sintoma (
        id bigint generated by default as identity,
        atualizado_em timestamp(6),
        criado_em timestamp(6),
        data_registro date not null,
        dor enum ('FORTE','LEVE','MODERADA','NENHUMA') not null,
        energia integer not null,
        estresse integer not null,
        humor integer not null,
        locais_dor varchar(200),
        observacao varchar(300),
        sintomas varchar(200),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_registro_agua (
        id bigint generated by default as identity,
        data_hora timestamp(6),
        quantidade_ml float(53) not null,
        usuario bigint,
        primary key (id)
    )
Hibernate: 
    create table tb_registro_exercicio (
        id bigint generated by default as identity,
        data_hora timestamp(6),
        duracaominutos integer,
        gasto_calorico_extimado float(24) not null,
        modalidade varchar(255),
        usuario_id bigint,
        primary key (id)
    )
Hibernate: 
    create table tb_rotina (
        id uuid not null,
        ativa boolean not null,
        descricao varchar(255),
        nome varchar(255),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_rotina_lembrete (
        id uuid not null,
        dias_semana varchar(255),
        hora time(0),
        mensagem varchar(255),
        titulo varchar(255),
        rotina_id uuid not null,
        primary key (id)
    )
Hibernate: 
    create table tb_user (
        id bigint generated by default as identity,
        email varchar(255),
        name varchar(255),
        password varchar(255),
        username varchar(255),
        perfil_id bigint,
        primary key (id)
    )
Hibernate: 
    alter table if exists tb_conquista_usuario 
       drop constraint if exists UK7urgykphhl2nxmnxhhaphhvg4
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint UK7urgykphhl2nxmnxhhaphhvg4 unique (usuario_id, codigo)
Hibernate: 
    alter table if exists tb_meta_agua 
       drop constraint if exists UKds21df66vkauco8cyjbd5qtpl
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint UKds21df66vkauco8cyjbd5qtpl unique (usuario_id)
Hibernate: 
    alter table if exists tb_registro_sintoma 
       drop constraint if exists UKn34dxtuu0hiw14bwisqpb8hpu
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint UKn34dxtuu0hiw14bwisqpb8hpu unique (usuario_id, data_registro)
Hibernate: 
    alter table if exists tb_user 
       drop constraint if exists UKm34ag6o17txoob92uw6nm58v7
Hibernate: 
    alter table if exists tb_user 
       add constraint UKm34ag6o17txoob92uw6nm58v7 unique (perfil_id)
Hibernate: 
    alter table if exists registro_sono 
       add constraint FKeoc63g7udgi8noxal92x39fer 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint FKi6frifp7rytmadfx27m88hrfd 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_lembretes 
       add constraint FKeyypeufdfrqi0hv5gj2dhpsfb 
       foreign key (user_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_meta 
       add constraint FKscpuudtlp7ny3yrkkl4t9wien 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint FKnt07mfvvrujysgy1fs1wy5r69 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint FKpub79o4perq280o1hfh28nrug 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_registro_agua 
       add constraint FKojo8a4lpnvmws7i0um2ws6jsi 
       foreign key (usuario) 
       references tb_user
Hibernate: 
    alter table if exists tb_registro_exercicio 
       add constraint FKf6ark8hd303id249luu6epw9o 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_rotina 
       add constraint FKq5ls0ldk5rbgqeenxf2yxvp2i 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_rotina_lembrete 
       add constraint FKbguqtr3jmoei2qirxbw2mqnsp 
       foreign key (rotina_id) 
       references tb_rotina
Hibernate: 
    alter table if exists tb_user 
       add constraint FK4k43rk0msb0i8cphonpc88hxv 
       foreign key (perfil_id) 
       references tb_perfil
2026-11-16T20:13:59.793-03:00  INFO 2828 --- [simba-backend] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-11-16T20:13:59.954-03:00  INFO 2828 --- [simba-backend] [           main] o.s.d.j.r.query.QueryEnhancerFactories   : Hibernate is in classpath; If applicable, HQL parser will be used.
2026-11-16T20:14:00.777-03:00  INFO 2828 --- [simba-backend] [           main] eAuthenticationProviderManagerConfigurer : Global AuthenticationManager configured with AuthenticationProvider bean with name authenticationProvider
2026-11-16T20:14:00.779-03:00  WARN 2828 --- [simba-backend] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
2026-11-16T20:14:01.211-03:00  WARN 2828 --- [simba-backend] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2026-11-16T20:14:02.005-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-11-16T20:14:02.889-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.h.a.H2ConsoleAutoConfiguration     : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:simba'
2026-11-16T20:14:03.051-03:00  INFO 2828 --- [simba-backend] [           main] b.s.bem_estar.BemEstarApplicationTests   : Started BemEstarApplicationTests in 15.035 seconds (process running for 18.266)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.72 s -- in br.simba.bem_estar.BemEstarApplicationTests
[INFO] Running br.simba.bem_estar.comparativo.ComparativoCalculatorTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.145 s -- in br.simba.bem_estar.comparativo.ComparativoCalculatorTest
[INFO] Running br.simba.bem_estar.comparativo.ComparativoControllerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.315 s -- in br.simba.bem_estar.comparativo.ComparativoControllerTest
[INFO] Running br.simba.bem_estar.comparativo.ComparativoServiceTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.477 s -- in br.simba.bem_estar.comparativo.ComparativoServiceTest
[INFO] Running br.simba.bem_estar.conquista.ConquistaCalculatorTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 s -- in br.simba.bem_estar.conquista.ConquistaCalculatorTest
[INFO] Running br.simba.bem_estar.conquista.ConquistaControllerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.083 s -- in br.simba.bem_estar.conquista.ConquistaControllerTest
[INFO] Running br.simba.bem_estar.conquista.ConquistaServiceTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.246 s -- in br.simba.bem_estar.conquista.ConquistaServiceTest
[INFO] Running br.simba.bem_estar.conquista.GamificacaoDashboardIntegrationTest
2026-11-16T20:14:04.682-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.conquista.GamificacaoDashboardIntegrationTest]: GamificacaoDashboardIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:04.772-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.conquista.GamificacaoDashboardIntegrationTest
2026-11-16T20:14:04.774-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.conquista.GamificacaoDashboardIntegrationTest]: GamificacaoDashboardIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:04.775-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.BaseIntegrationTest]: BaseIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:04.780-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.conquista.GamificacaoDashboardIntegrationTest
2026-11-16T20:14:04.817-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.d.r.RestartApplicationListener     : Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.1.1)

2026-11-16T20:14:05.156-03:00  INFO 2828 --- [simba-backend] [           main] .b.c.GamificacaoDashboardIntegrationTest : Starting GamificacaoDashboardIntegrationTest using Java 21.0.12.1 with PID 2828 (started by João Manoel in C:\Users\João Manoel\Documents\SIMBA\Sistema-Integrado-de-Monitoramento-do-Bem-estar-SIMBA-)
2026-11-16T20:14:05.156-03:00  INFO 2828 --- [simba-backend] [           main] .b.c.GamificacaoDashboardIntegrationTest : No active profile set, falling back to 1 default profile: "default"
2026-11-16T20:14:05.708-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:14:05.709-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2026-11-16T20:14:05.730-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.conquista.ConquistaUsuarioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.731-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.lembrete.LembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.731-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.732-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.732-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.perfil.PerfilRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.732-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroAgua.RegistroAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.733-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroExercicio.RegistroExercicioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.734-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroSono.RegistroSonoRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.734-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaLembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.734-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.734-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.sintoma.RegistroSintomaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.734-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.user.UserRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:05.734-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 23 ms. Found 0 JDBC repository interfaces.
2026-11-16T20:14:05.738-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:14:05.738-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-11-16T20:14:05.805-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 63 ms. Found 12 JPA repository interfaces.
2026-11-16T20:14:06.022-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-11-16T20:14:06.107-03:00  INFO 2828 --- [simba-backend] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-11-16T20:14:06.114-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-2 - Starting...
2026-11-16T20:14:06.116-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-2 - Added connection conn10: url=jdbc:h2:mem:simba user=SA
2026-11-16T20:14:06.117-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-2 - Start completed.
2026-11-16T20:14:06.118-03:00  WARN 2828 --- [simba-backend] [           main] org.hibernate.orm.deprecation            : HHH90000025: H2Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2026-11-16T20:14:06.119-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [jdbc:h2:mem:simba]
	Database driver: H2 JDBC Driver
	Database dialect: H2Dialect
	Database version: 2.4.240
	Default catalog/schema: SIMBA/PUBLIC
	Autocommit mode: undefined/unknown
	Isolation level: READ_COMMITTED [default READ_COMMITTED]
	JDBC fetch size: 100
	Pool: DataSourceConnectionProvider
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2026-11-16T20:14:06.807-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: 
    alter table if exists tb_conquista_usuario 
       drop constraint if exists UK7urgykphhl2nxmnxhhaphhvg4
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint UK7urgykphhl2nxmnxhhaphhvg4 unique (usuario_id, codigo)
Hibernate: 
    alter table if exists tb_meta_agua 
       drop constraint if exists UKds21df66vkauco8cyjbd5qtpl
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint UKds21df66vkauco8cyjbd5qtpl unique (usuario_id)
Hibernate: 
    alter table if exists tb_registro_sintoma 
       drop constraint if exists UKn34dxtuu0hiw14bwisqpb8hpu
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint UKn34dxtuu0hiw14bwisqpb8hpu unique (usuario_id, data_registro)
2026-11-16T20:14:06.851-03:00  INFO 2828 --- [simba-backend] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-11-16T20:14:07.123-03:00  INFO 2828 --- [simba-backend] [           main] eAuthenticationProviderManagerConfigurer : Global AuthenticationManager configured with AuthenticationProvider bean with name authenticationProvider
2026-11-16T20:14:07.124-03:00  WARN 2828 --- [simba-backend] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
2026-11-16T20:14:07.401-03:00  WARN 2828 --- [simba-backend] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2026-11-16T20:14:07.833-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-11-16T20:14:08.116-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2026-11-16T20:14:08.116-03:00  INFO 2828 --- [simba-backend] [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2026-11-16T20:14:08.118-03:00  INFO 2828 --- [simba-backend] [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 2 ms
2026-11-16T20:14:08.130-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.h.a.H2ConsoleAutoConfiguration     : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:simba'
2026-11-16T20:14:08.161-03:00  INFO 2828 --- [simba-backend] [           main] .b.c.GamificacaoDashboardIntegrationTest : Started GamificacaoDashboardIntegrationTest in 3.344 seconds (process running for 23.375)
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_perfil
        (altura, idade, peso, streak, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta_agua
        (meta_ml, usuario_id, id) 
    values
        (?, ?, default)
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_meta_agua 
    where
        id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta_agua
        (meta_ml, usuario_id, id) 
    values
        (?, ?, default)
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.id=?
Hibernate: 
    update
        tb_meta 
    set
        alvo=?,
        concluida_em=?,
        data_inicio=?,
        tipo=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        count(*) 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    update
        tb_meta 
    set
        alvo=?,
        concluida_em=?,
        data_inicio=?,
        tipo=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    update
        tb_meta 
    set
        alvo=?,
        concluida_em=?,
        data_inicio=?,
        tipo=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.id=? 
        and mm1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_meta 
    where
        id=?
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.046 s -- in br.simba.bem_estar.conquista.GamificacaoDashboardIntegrationTest
[INFO] Running br.simba.bem_estar.demo.DemoDataSeederIntegrationTest
2026-11-16T20:14:10.733-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.demo.DemoDataSeederIntegrationTest]: DemoDataSeederIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:10.760-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.demo.DemoDataSeederIntegrationTest
2026-11-16T20:14:10.761-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.demo.DemoDataSeederIntegrationTest]: DemoDataSeederIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:10.763-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.demo.DemoDataSeederIntegrationTest
2026-11-16T20:14:10.767-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.d.r.RestartApplicationListener     : Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.1.1)

2026-11-16T20:14:10.821-03:00  INFO 2828 --- [simba-backend] [           main] b.s.b.d.DemoDataSeederIntegrationTest    : Starting DemoDataSeederIntegrationTest using Java 21.0.12.1 with PID 2828 (started by João Manoel in C:\Users\João Manoel\Documents\SIMBA\Sistema-Integrado-de-Monitoramento-do-Bem-estar-SIMBA-)
2026-11-16T20:14:10.821-03:00  INFO 2828 --- [simba-backend] [           main] b.s.b.d.DemoDataSeederIntegrationTest    : The following 1 profile is active: "demo"
2026-11-16T20:14:11.286-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:14:11.287-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.conquista.ConquistaUsuarioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.lembrete.LembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.perfil.PerfilRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroAgua.RegistroAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroExercicio.RegistroExercicioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroSono.RegistroSonoRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.304-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaLembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.305-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.305-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.sintoma.RegistroSintomaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.305-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.user.UserRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:11.305-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 15 ms. Found 0 JDBC repository interfaces.
2026-11-16T20:14:11.307-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:14:11.307-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-11-16T20:14:11.355-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 42 ms. Found 12 JPA repository interfaces.
2026-11-16T20:14:11.499-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-11-16T20:14:11.535-03:00  INFO 2828 --- [simba-backend] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-11-16T20:14:11.537-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-3 - Starting...
2026-11-16T20:14:11.538-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-3 - Added connection conn20: url=jdbc:h2:mem:simba user=SA
2026-11-16T20:14:11.538-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-3 - Start completed.
2026-11-16T20:14:11.539-03:00  WARN 2828 --- [simba-backend] [           main] org.hibernate.orm.deprecation            : HHH90000025: H2Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2026-11-16T20:14:11.539-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [jdbc:h2:mem:simba]
	Database driver: H2 JDBC Driver
	Database dialect: H2Dialect
	Database version: 2.4.240
	Default catalog/schema: SIMBA/PUBLIC
	Autocommit mode: undefined/unknown
	Isolation level: READ_COMMITTED [default READ_COMMITTED]
	JDBC fetch size: 100
	Pool: DataSourceConnectionProvider
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2026-11-16T20:14:11.748-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: 
    alter table if exists tb_conquista_usuario 
       drop constraint if exists UK7urgykphhl2nxmnxhhaphhvg4
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint UK7urgykphhl2nxmnxhhaphhvg4 unique (usuario_id, codigo)
Hibernate: 
    alter table if exists tb_meta_agua 
       drop constraint if exists UKds21df66vkauco8cyjbd5qtpl
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint UKds21df66vkauco8cyjbd5qtpl unique (usuario_id)
Hibernate: 
    alter table if exists tb_registro_sintoma 
       drop constraint if exists UKn34dxtuu0hiw14bwisqpb8hpu
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint UKn34dxtuu0hiw14bwisqpb8hpu unique (usuario_id, data_registro)
2026-11-16T20:14:11.761-03:00  INFO 2828 --- [simba-backend] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-11-16T20:14:11.947-03:00  INFO 2828 --- [simba-backend] [           main] eAuthenticationProviderManagerConfigurer : Global AuthenticationManager configured with AuthenticationProvider bean with name authenticationProvider
2026-11-16T20:14:11.948-03:00  WARN 2828 --- [simba-backend] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
2026-11-16T20:14:12.034-03:00  WARN 2828 --- [simba-backend] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2026-11-16T20:14:12.373-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-11-16T20:14:12.548-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2026-11-16T20:14:12.548-03:00  INFO 2828 --- [simba-backend] [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2026-11-16T20:14:12.551-03:00  INFO 2828 --- [simba-backend] [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 2 ms
2026-11-16T20:14:12.555-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.h.a.H2ConsoleAutoConfiguration     : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:simba'
2026-11-16T20:14:12.586-03:00  INFO 2828 --- [simba-backend] [           main] b.s.b.d.DemoDataSeederIntegrationTest    : Started DemoDataSeederIntegrationTest in 1.819 seconds (process running for 27.8)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_perfil
        (altura, idade, peso, streak, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
>>> [demo] Usuário criado: demo / demo123
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro>=? 
    order by
        rsm1_0.data_registro desc
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.947 s -- in br.simba.bem_estar.demo.DemoDataSeederIntegrationTest
[INFO] Running br.simba.bem_estar.demo.DemoDataSeederTest
>>> [demo] Usuário criado: demo / demo123
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.587 s -- in br.simba.bem_estar.demo.DemoDataSeederTest
[INFO] Running br.simba.bem_estar.e2e.AuthPerfilE2ETest
2026-11-16T20:14:14.274-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.AuthPerfilE2ETest]: AuthPerfilE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:14.302-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.AuthPerfilE2ETest
2026-11-16T20:14:14.303-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.AuthPerfilE2ETest]: AuthPerfilE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:14.305-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.BaseE2ETest]: BaseE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:14.306-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.AuthPerfilE2ETest
2026-11-16T20:14:14.312-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.d.r.RestartApplicationListener     : Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.1.1)

2026-11-16T20:14:14.351-03:00  INFO 2828 --- [simba-backend] [           main] b.simba.bem_estar.e2e.AuthPerfilE2ETest  : Starting AuthPerfilE2ETest using Java 21.0.12.1 with PID 2828 (started by João Manoel in C:\Users\João Manoel\Documents\SIMBA\Sistema-Integrado-de-Monitoramento-do-Bem-estar-SIMBA-)
2026-11-16T20:14:14.352-03:00  INFO 2828 --- [simba-backend] [           main] b.simba.bem_estar.e2e.AuthPerfilE2ETest  : No active profile set, falling back to 1 default profile: "default"
2026-11-16T20:14:14.696-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:14:14.696-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2026-11-16T20:14:14.715-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.conquista.ConquistaUsuarioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.715-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.lembrete.LembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.715-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.715-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.715-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.perfil.PerfilRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroAgua.RegistroAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroExercicio.RegistroExercicioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroSono.RegistroSonoRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaLembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.sintoma.RegistroSintomaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.user.UserRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:14:14.716-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 17 ms. Found 0 JDBC repository interfaces.
2026-11-16T20:14:14.719-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:14:14.719-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-11-16T20:14:14.758-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 36 ms. Found 12 JPA repository interfaces.
2026-11-16T20:14:15.084-03:00  INFO 2828 --- [simba-backend] [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat initialized with port 0 (http)
2026-11-16T20:14:15.110-03:00  INFO 2828 --- [simba-backend] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-11-16T20:14:15.110-03:00  INFO 2828 --- [simba-backend] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/11.0.24]
2026-11-16T20:14:15.193-03:00  INFO 2828 --- [simba-backend] [           main] b.w.c.s.WebApplicationContextInitializer : Root WebApplicationContext: initialization completed in 837 ms
2026-11-16T20:14:15.251-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-11-16T20:14:15.311-03:00  INFO 2828 --- [simba-backend] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-11-16T20:14:15.313-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-4 - Starting...
2026-11-16T20:14:15.314-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-4 - Added connection conn30: url=jdbc:h2:mem:simba user=SA
2026-11-16T20:14:15.315-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-4 - Start completed.
2026-11-16T20:14:15.316-03:00  WARN 2828 --- [simba-backend] [           main] org.hibernate.orm.deprecation            : HHH90000025: H2Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2026-11-16T20:14:15.316-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [jdbc:h2:mem:simba]
	Database driver: H2 JDBC Driver
	Database dialect: H2Dialect
	Database version: 2.4.240
	Default catalog/schema: SIMBA/PUBLIC
	Autocommit mode: undefined/unknown
	Isolation level: READ_COMMITTED [default READ_COMMITTED]
	JDBC fetch size: 100
	Pool: DataSourceConnectionProvider
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2026-11-16T20:14:15.726-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: 
    alter table if exists tb_conquista_usuario 
       drop constraint if exists UK7urgykphhl2nxmnxhhaphhvg4
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint UK7urgykphhl2nxmnxhhaphhvg4 unique (usuario_id, codigo)
Hibernate: 
    alter table if exists tb_meta_agua 
       drop constraint if exists UKds21df66vkauco8cyjbd5qtpl
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint UKds21df66vkauco8cyjbd5qtpl unique (usuario_id)
Hibernate: 
    alter table if exists tb_registro_sintoma 
       drop constraint if exists UKn34dxtuu0hiw14bwisqpb8hpu
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint UKn34dxtuu0hiw14bwisqpb8hpu unique (usuario_id, data_registro)
2026-11-16T20:14:15.741-03:00  INFO 2828 --- [simba-backend] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-11-16T20:14:15.950-03:00  INFO 2828 --- [simba-backend] [           main] eAuthenticationProviderManagerConfigurer : Global AuthenticationManager configured with AuthenticationProvider bean with name authenticationProvider
2026-11-16T20:14:15.951-03:00  WARN 2828 --- [simba-backend] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
2026-11-16T20:14:16.011-03:00  WARN 2828 --- [simba-backend] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2026-11-16T20:14:16.121-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-11-16T20:14:16.230-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.h.a.H2ConsoleAutoConfiguration     : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:simba'
2026-11-16T20:14:16.271-03:00  INFO 2828 --- [simba-backend] [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat started on port 58959 (http) with context path '/'
2026-11-16T20:14:16.275-03:00  INFO 2828 --- [simba-backend] [           main] b.simba.bem_estar.e2e.AuthPerfilE2ETest  : Started AuthPerfilE2ETest in 1.963 seconds (process running for 31.489)
2026-11-16T20:14:18.114-03:00  WARN 2828 --- [simba-backend] [           main] o.o.selenium.devtools.CdpVersionFinder   : Unable to find an exact match for CDP version 151, returning the closest version; found: 147; Please update to a Selenium version that supports CDP version 151
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
2026-11-16T20:14:18.430-03:00  INFO 2828 --- [simba-backend] [o-auto-1-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-11-16T20:14:18.430-03:00  INFO 2828 --- [simba-backend] [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-11-16T20:14:18.432-03:00  INFO 2828 --- [simba-backend] [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.email=?
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_perfil
        (altura, idade, peso, streak, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 18.60 s -- in br.simba.bem_estar.e2e.AuthPerfilE2ETest
[INFO] Running br.simba.bem_estar.e2e.ConquistasProgressoE2ETest
2026-11-16T20:14:32.874-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.ConquistasProgressoE2ETest]: ConquistasProgressoE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:32.876-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.ConquistasProgressoE2ETest
2026-11-16T20:14:32.877-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.ConquistasProgressoE2ETest]: ConquistasProgressoE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:32.877-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.BaseE2ETest]: BaseE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:32.878-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.ConquistasProgressoE2ETest
2026-11-16T20:14:34.342-03:00  WARN 2828 --- [simba-backend] [           main] o.o.selenium.devtools.CdpVersionFinder   : Unable to find an exact match for CDP version 151, returning the closest version; found: 147; Please update to a Selenium version that supports CDP version 151
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.id=? 
        and mm1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_meta 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.hora_acordar between ? and ? 
    order by
        rsm1_0.hora_acordar
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=? 
        and ram1_0.data_hora between ? and ? 
    order by
        ram1_0.data_hora
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=? 
        and rem1_0.data_hora between ? and ? 
    order by
        rem1_0.data_hora
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.hora_acordar between ? and ? 
    order by
        rsm1_0.hora_acordar
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=? 
        and ram1_0.data_hora between ? and ? 
    order by
        ram1_0.data_hora
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=? 
        and rem1_0.data_hora between ? and ? 
    order by
        rem1_0.data_hora
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.45 s -- in br.simba.bem_estar.e2e.ConquistasProgressoE2ETest
[INFO] Running br.simba.bem_estar.e2e.DashboardHidratacaoSonoTreinoE2ETest
2026-11-16T20:14:49.328-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.DashboardHidratacaoSonoTreinoE2ETest]: DashboardHidratacaoSonoTreinoE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:49.329-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.DashboardHidratacaoSonoTreinoE2ETest
2026-11-16T20:14:49.330-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.DashboardHidratacaoSonoTreinoE2ETest]: DashboardHidratacaoSonoTreinoE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:49.330-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.BaseE2ETest]: BaseE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:14:49.331-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.DashboardHidratacaoSonoTreinoE2ETest
2026-11-16T20:14:50.404-03:00  WARN 2828 --- [simba-backend] [           main] o.o.selenium.devtools.CdpVersionFinder   : Unable to find an exact match for CDP version 151, returning the closest version; found: 147; Please update to a Selenium version that supports CDP version 151
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    update
        tb_registro_agua 
    set
        data_hora=?,
        quantidade_ml=?,
        usuario=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    delete 
    from
        tb_registro_agua 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta_agua
        (meta_ml, usuario_id, id) 
    values
        (?, ?, default)
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_meta_agua 
    where
        id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    update
        registro_sono 
    set
        hora_acordar=?,
        hora_dormir=?,
        nota_sono=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    delete 
    from
        registro_sono 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    update
        tb_registro_exercicio 
    set
        data_hora=?,
        duracaominutos=?,
        gasto_calorico_extimado=?,
        modalidade=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    delete 
    from
        tb_registro_exercicio 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 35.47 s -- in br.simba.bem_estar.e2e.DashboardHidratacaoSonoTreinoE2ETest
[INFO] Running br.simba.bem_estar.e2e.DemoFluxoE2ETest
2026-11-16T20:15:24.804-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.DemoFluxoE2ETest]: DemoFluxoE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:24.807-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.DemoFluxoE2ETest
2026-11-16T20:15:24.808-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.DemoFluxoE2ETest]: DemoFluxoE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:24.808-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.BaseE2ETest]: BaseE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:24.809-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.DemoFluxoE2ETest
2026-11-16T20:15:24.816-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.d.r.RestartApplicationListener     : Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.1.1)

2026-11-16T20:15:24.865-03:00  INFO 2828 --- [simba-backend] [           main] b.simba.bem_estar.e2e.DemoFluxoE2ETest   : Starting DemoFluxoE2ETest using Java 21.0.12.1 with PID 2828 (started by João Manoel in C:\Users\João Manoel\Documents\SIMBA\Sistema-Integrado-de-Monitoramento-do-Bem-estar-SIMBA-)
2026-11-16T20:15:24.866-03:00  INFO 2828 --- [simba-backend] [           main] b.simba.bem_estar.e2e.DemoFluxoE2ETest   : The following 1 profile is active: "demo"
2026-11-16T20:15:25.198-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:15:25.198-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2026-11-16T20:15:25.215-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.conquista.ConquistaUsuarioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.lembrete.LembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.meta.MetaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.perfil.PerfilRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroAgua.RegistroAguaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroExercicio.RegistroExercicioRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.registroSono.RegistroSonoRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaLembreteRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.rotina.RotinaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.sintoma.RegistroSintomaRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface br.simba.bem_estar.user.UserRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2026-11-16T20:15:25.216-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 17 ms. Found 0 JDBC repository interfaces.
2026-11-16T20:15:25.219-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-11-16T20:15:25.219-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2026-11-16T20:15:25.273-03:00  INFO 2828 --- [simba-backend] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 52 ms. Found 12 JPA repository interfaces.
2026-11-16T20:15:25.375-03:00  INFO 2828 --- [simba-backend] [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat initialized with port 0 (http)
2026-11-16T20:15:25.376-03:00  INFO 2828 --- [simba-backend] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-11-16T20:15:25.377-03:00  INFO 2828 --- [simba-backend] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/11.0.24]
2026-11-16T20:15:25.428-03:00  INFO 2828 --- [simba-backend] [           main] b.w.c.s.WebApplicationContextInitializer : Root WebApplicationContext: initialization completed in 560 ms
2026-11-16T20:15:25.484-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.jpa                    : HHH008540: Processing PersistenceUnitInfo [name: default]
2026-11-16T20:15:25.523-03:00  INFO 2828 --- [simba-backend] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2026-11-16T20:15:25.524-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-5 - Starting...
2026-11-16T20:15:25.527-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-5 - Added connection conn40: url=jdbc:h2:mem:simba_demo_e2e user=SA
2026-11-16T20:15:25.528-03:00  INFO 2828 --- [simba-backend] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-5 - Start completed.
2026-11-16T20:15:25.529-03:00  WARN 2828 --- [simba-backend] [           main] org.hibernate.orm.deprecation            : HHH90000025: H2Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2026-11-16T20:15:25.530-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [jdbc:h2:mem:simba_demo_e2e]
	Database driver: H2 JDBC Driver
	Database dialect: H2Dialect
	Database version: 2.4.240
	Default catalog/schema: SIMBA_DEMO_E2E/PUBLIC
	Autocommit mode: undefined/unknown
	Isolation level: READ_COMMITTED [default READ_COMMITTED]
	JDBC fetch size: 100
	Pool: DataSourceConnectionProvider
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2026-11-16T20:15:25.776-03:00  INFO 2828 --- [simba-backend] [           main] org.hibernate.orm.core                   : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Hibernate: 
    create table registro_sono (
        id bigint generated by default as identity,
        hora_acordar timestamp(6),
        hora_dormir timestamp(6),
        nota_sono integer,
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_conquista_usuario (
        id bigint generated by default as identity,
        codigo varchar(255),
        data_desbloqueio timestamp(6),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_lembretes (
        id bigint generated by default as identity,
        horario timestamp(6),
        mensagem varchar(255),
        titulo varchar(255),
        user_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_meta (
        id bigint generated by default as identity,
        alvo integer not null,
        concluida_em timestamp(6),
        data_inicio date,
        tipo enum ('AGUA_SEGUIDOS','SONO_SEGUIDOS','TREINO_SEGUIDOS','TREINO_TOTAL'),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_meta_agua (
        id bigint generated by default as identity,
        meta_ml integer not null,
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_perfil (
        id bigint generated by default as identity,
        altura float(53) not null,
        idade integer,
        peso float(53) not null,
        streak integer,
        primary key (id)
    )
Hibernate: 
    create table tb_registro_sintoma (
        id bigint generated by default as identity,
        atualizado_em timestamp(6),
        criado_em timestamp(6),
        data_registro date not null,
        dor enum ('FORTE','LEVE','MODERADA','NENHUMA') not null,
        energia integer not null,
        estresse integer not null,
        humor integer not null,
        locais_dor varchar(200),
        observacao varchar(300),
        sintomas varchar(200),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_registro_agua (
        id bigint generated by default as identity,
        data_hora timestamp(6),
        quantidade_ml float(53) not null,
        usuario bigint,
        primary key (id)
    )
Hibernate: 
    create table tb_registro_exercicio (
        id bigint generated by default as identity,
        data_hora timestamp(6),
        duracaominutos integer,
        gasto_calorico_extimado float(24) not null,
        modalidade varchar(255),
        usuario_id bigint,
        primary key (id)
    )
Hibernate: 
    create table tb_rotina (
        id uuid not null,
        ativa boolean not null,
        descricao varchar(255),
        nome varchar(255),
        usuario_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table tb_rotina_lembrete (
        id uuid not null,
        dias_semana varchar(255),
        hora time(0),
        mensagem varchar(255),
        titulo varchar(255),
        rotina_id uuid not null,
        primary key (id)
    )
Hibernate: 
    create table tb_user (
        id bigint generated by default as identity,
        email varchar(255),
        name varchar(255),
        password varchar(255),
        username varchar(255),
        perfil_id bigint,
        primary key (id)
    )
Hibernate: 
    alter table if exists tb_conquista_usuario 
       drop constraint if exists UK7urgykphhl2nxmnxhhaphhvg4
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint UK7urgykphhl2nxmnxhhaphhvg4 unique (usuario_id, codigo)
Hibernate: 
    alter table if exists tb_meta_agua 
       drop constraint if exists UKds21df66vkauco8cyjbd5qtpl
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint UKds21df66vkauco8cyjbd5qtpl unique (usuario_id)
Hibernate: 
    alter table if exists tb_registro_sintoma 
       drop constraint if exists UKn34dxtuu0hiw14bwisqpb8hpu
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint UKn34dxtuu0hiw14bwisqpb8hpu unique (usuario_id, data_registro)
Hibernate: 
    alter table if exists tb_user 
       drop constraint if exists UKm34ag6o17txoob92uw6nm58v7
Hibernate: 
    alter table if exists tb_user 
       add constraint UKm34ag6o17txoob92uw6nm58v7 unique (perfil_id)
Hibernate: 
    alter table if exists registro_sono 
       add constraint FKeoc63g7udgi8noxal92x39fer 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_conquista_usuario 
       add constraint FKi6frifp7rytmadfx27m88hrfd 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_lembretes 
       add constraint FKeyypeufdfrqi0hv5gj2dhpsfb 
       foreign key (user_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_meta 
       add constraint FKscpuudtlp7ny3yrkkl4t9wien 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_meta_agua 
       add constraint FKnt07mfvvrujysgy1fs1wy5r69 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_registro_sintoma 
       add constraint FKpub79o4perq280o1hfh28nrug 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_registro_agua 
       add constraint FKojo8a4lpnvmws7i0um2ws6jsi 
       foreign key (usuario) 
       references tb_user
Hibernate: 
    alter table if exists tb_registro_exercicio 
       add constraint FKf6ark8hd303id249luu6epw9o 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_rotina 
       add constraint FKq5ls0ldk5rbgqeenxf2yxvp2i 
       foreign key (usuario_id) 
       references tb_user
Hibernate: 
    alter table if exists tb_rotina_lembrete 
       add constraint FKbguqtr3jmoei2qirxbw2mqnsp 
       foreign key (rotina_id) 
       references tb_rotina
Hibernate: 
    alter table if exists tb_user 
       add constraint FK4k43rk0msb0i8cphonpc88hxv 
       foreign key (perfil_id) 
       references tb_perfil
2026-11-16T20:15:25.808-03:00  INFO 2828 --- [simba-backend] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-11-16T20:15:26.017-03:00  INFO 2828 --- [simba-backend] [           main] eAuthenticationProviderManagerConfigurer : Global AuthenticationManager configured with AuthenticationProvider bean with name authenticationProvider
2026-11-16T20:15:26.017-03:00  WARN 2828 --- [simba-backend] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with an AuthenticationProvider bean. UserDetailsService beans will not be used by Spring Security for automatically configuring username/password login. Consider removing the AuthenticationProvider bean. Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
2026-11-16T20:15:26.102-03:00  WARN 2828 --- [simba-backend] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2026-11-16T20:15:26.330-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.w.a.WelcomePageHandlerMapping      : Adding welcome page: class path resource [static/index.html]
2026-11-16T20:15:26.663-03:00  INFO 2828 --- [simba-backend] [           main] o.s.b.h.a.H2ConsoleAutoConfiguration     : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:simba_demo_e2e'
2026-11-16T20:15:26.681-03:00  INFO 2828 --- [simba-backend] [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat started on port 63935 (http) with context path '/'
2026-11-16T20:15:26.684-03:00  INFO 2828 --- [simba-backend] [           main] b.simba.bem_estar.e2e.DemoFluxoE2ETest   : Started DemoFluxoE2ETest in 1.867 seconds (process running for 101.898)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_perfil
        (altura, idade, peso, streak, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
>>> [demo] Usuário criado: demo / demo123
2026-11-16T20:15:28.093-03:00  WARN 2828 --- [simba-backend] [           main] o.o.selenium.devtools.CdpVersionFinder   : Unable to find an exact match for CDP version 151, returning the closest version; found: 147; Please update to a Selenium version that supports CDP version 151
2026-11-16T20:15:28.226-03:00  INFO 2828 --- [simba-backend] [o-auto-2-exec-1] o.a.c.c.C.[Tomcat-1].[localhost].[/]     : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-11-16T20:15:28.226-03:00  INFO 2828 --- [simba-backend] [o-auto-2-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-11-16T20:15:28.228-03:00  INFO 2828 --- [simba-backend] [o-auto-2-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.hora_acordar between ? and ? 
    order by
        rsm1_0.hora_acordar
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=? 
        and ram1_0.data_hora between ? and ? 
    order by
        ram1_0.data_hora
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=? 
        and rem1_0.data_hora between ? and ? 
    order by
        rem1_0.data_hora
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro>=? 
    order by
        rsm1_0.data_registro desc
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 9.280 s -- in br.simba.bem_estar.e2e.DemoFluxoE2ETest
[INFO] Running br.simba.bem_estar.e2e.SintomasRotinasLembretesE2ETest
2026-11-16T20:15:34.085-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.SintomasRotinasLembretesE2ETest]: SintomasRotinasLembretesE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:34.088-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.SintomasRotinasLembretesE2ETest
2026-11-16T20:15:34.089-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.SintomasRotinasLembretesE2ETest]: SintomasRotinasLembretesE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:34.089-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.e2e.BaseE2ETest]: BaseE2ETest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:34.091-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.e2e.SintomasRotinasLembretesE2ETest
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro>=? 
    order by
        rsm1_0.data_registro desc
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro>=? 
    order by
        rsm1_0.data_registro desc
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    update
        tb_registro_sintoma 
    set
        atualizado_em=?,
        criado_em=?,
        data_registro=?,
        dor=?,
        energia=?,
        estresse=?,
        humor=?,
        locais_dor=?,
        observacao=?,
        sintomas=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro>=? 
    order by
        rsm1_0.data_registro desc
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_lembretes
        (horario, mensagem, titulo, user_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        re1_0.usuario_id,
        re1_0.id,
        re1_0.data_hora,
        re1_0.duracaominutos,
        re1_0.gasto_calorico_extimado,
        re1_0.modalidade 
    from
        tb_registro_exercicio re1_0 
    where
        re1_0.usuario_id=?
Hibernate: 
    select
        ra1_0.usuario,
        ra1_0.id,
        ra1_0.data_hora,
        ra1_0.quantidade_ml 
    from
        tb_registro_agua ra1_0 
    where
        ra1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        re1_0.usuario_id,
        re1_0.id,
        re1_0.data_hora,
        re1_0.duracaominutos,
        re1_0.gasto_calorico_extimado,
        re1_0.modalidade 
    from
        tb_registro_exercicio re1_0 
    where
        re1_0.usuario_id=?
Hibernate: 
    select
        ra1_0.usuario,
        ra1_0.id,
        ra1_0.data_hora,
        ra1_0.quantidade_ml 
    from
        tb_registro_agua ra1_0 
    where
        ra1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        re1_0.usuario_id,
        re1_0.id,
        re1_0.data_hora,
        re1_0.duracaominutos,
        re1_0.gasto_calorico_extimado,
        re1_0.modalidade 
    from
        tb_registro_exercicio re1_0 
    where
        re1_0.usuario_id=?
Hibernate: 
    select
        ra1_0.usuario,
        ra1_0.id,
        ra1_0.data_hora,
        ra1_0.quantidade_ml 
    from
        tb_registro_agua ra1_0 
    where
        ra1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        re1_0.usuario_id,
        re1_0.id,
        re1_0.data_hora,
        re1_0.duracaominutos,
        re1_0.gasto_calorico_extimado,
        re1_0.modalidade 
    from
        tb_registro_exercicio re1_0 
    where
        re1_0.usuario_id=?
Hibernate: 
    select
        ra1_0.usuario,
        ra1_0.id,
        ra1_0.data_hora,
        ra1_0.quantidade_ml 
    from
        tb_registro_agua ra1_0 
    where
        ra1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.perfil_id,
        u1_0.username 
    from
        tb_lembretes lm1_0 
    join
        tb_user u1_0 
            on u1_0.id=lm1_0.user_id 
    where
        lm1_0.id=?
Hibernate: 
    delete 
    from
        tb_lembretes 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    update
        tb_rotina 
    set
        ativa=?,
        descricao=?,
        nome=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    delete 
    from
        tb_rotina 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 23.60 s -- in br.simba.bem_estar.e2e.SintomasRotinasLembretesE2ETest
[INFO] Running br.simba.bem_estar.historico.HistoricoCalculosTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 s -- in br.simba.bem_estar.historico.HistoricoCalculosTest
[INFO] Running br.simba.bem_estar.historico.HistoricoServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 s -- in br.simba.bem_estar.historico.HistoricoServiceTest
[INFO] Running br.simba.bem_estar.infra.RestExceptionHandlerTest
2026-11-16T20:15:57.731-03:00  INFO 2828 --- [simba-backend] [           main] o.s.mock.web.MockServletContext          : Initializing Spring TestDispatcherServlet ''
2026-11-16T20:15:57.732-03:00  INFO 2828 --- [simba-backend] [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2026-11-16T20:15:57.732-03:00  INFO 2828 --- [simba-backend] [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 0 ms
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.050 s -- in br.simba.bem_estar.infra.RestExceptionHandlerTest
[INFO] Running br.simba.bem_estar.lembrete.LembreteControllerTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.053 s -- in br.simba.bem_estar.lembrete.LembreteControllerTest
[INFO] Running br.simba.bem_estar.meta.MetaAguaCalculatorTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 s -- in br.simba.bem_estar.meta.MetaAguaCalculatorTest
[INFO] Running br.simba.bem_estar.meta.MetaAguaServiceTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.086 s -- in br.simba.bem_estar.meta.MetaAguaServiceTest
[INFO] Running br.simba.bem_estar.meta.MetaCalculatorTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 s -- in br.simba.bem_estar.meta.MetaCalculatorTest
[INFO] Running br.simba.bem_estar.meta.MetaControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.072 s -- in br.simba.bem_estar.meta.MetaControllerTest
[INFO] Running br.simba.bem_estar.meta.MetaServiceTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.043 s -- in br.simba.bem_estar.meta.MetaServiceTest
[INFO] Running br.simba.bem_estar.perfil.MedidasCalculatorTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 s -- in br.simba.bem_estar.perfil.MedidasCalculatorTest
[INFO] Running br.simba.bem_estar.perfil.PerfilControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.040 s -- in br.simba.bem_estar.perfil.PerfilControllerTest
[INFO] Running br.simba.bem_estar.perfil.PerfilMedidasIntegrationTest
2026-11-16T20:15:58.105-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.perfil.PerfilMedidasIntegrationTest]: PerfilMedidasIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:58.140-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.perfil.PerfilMedidasIntegrationTest
2026-11-16T20:15:58.141-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.perfil.PerfilMedidasIntegrationTest]: PerfilMedidasIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:58.141-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.BaseIntegrationTest]: BaseIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:58.143-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.perfil.PerfilMedidasIntegrationTest
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_perfil
        (altura, idade, peso, streak, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    update
        tb_perfil 
    set
        altura=?,
        idade=?,
        peso=?,
        streak=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    update
        tb_perfil 
    set
        altura=?,
        idade=?,
        peso=?,
        streak=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.534 s -- in br.simba.bem_estar.perfil.PerfilMedidasIntegrationTest
[INFO] Running br.simba.bem_estar.perfil.PerfilServiceTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.031 s -- in br.simba.bem_estar.perfil.PerfilServiceTest
[INFO] Running br.simba.bem_estar.perfil.SugestoesCalculatorTest
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.036 s -- in br.simba.bem_estar.perfil.SugestoesCalculatorTest
[INFO] Running br.simba.bem_estar.progresso.ProgressoControllerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.019 s -- in br.simba.bem_estar.progresso.ProgressoControllerTest
[INFO] Running br.simba.bem_estar.progresso.ProgressoServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 s -- in br.simba.bem_estar.progresso.ProgressoServiceTest
[INFO] Running br.simba.bem_estar.progresso.RegistrosMonitoramentoIntegrationTest
2026-11-16T20:15:58.736-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.progresso.RegistrosMonitoramentoIntegrationTest]: RegistrosMonitoramentoIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:58.758-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.progresso.RegistrosMonitoramentoIntegrationTest
2026-11-16T20:15:58.760-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.progresso.RegistrosMonitoramentoIntegrationTest]: RegistrosMonitoramentoIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:58.760-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.BaseIntegrationTest]: BaseIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:58.762-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.progresso.RegistrosMonitoramentoIntegrationTest
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    update
        tb_registro_agua 
    set
        data_hora=?,
        quantidade_ml=?,
        usuario=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    update
        registro_sono 
    set
        hora_acordar=?,
        hora_dormir=?,
        nota_sono=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.hora_acordar between ? and ? 
    order by
        rsm1_0.hora_acordar
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=? 
        and ram1_0.data_hora between ? and ? 
    order by
        ram1_0.data_hora
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=? 
        and rem1_0.data_hora between ? and ? 
    order by
        rem1_0.data_hora
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    delete 
    from
        tb_registro_agua 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    delete 
    from
        registro_sono 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.id=?
Hibernate: 
    delete 
    from
        tb_registro_exercicio 
    where
        id=?
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.706 s -- in br.simba.bem_estar.progresso.RegistrosMonitoramentoIntegrationTest
[INFO] Running br.simba.bem_estar.proximopasso.ProximoPassoCalculatorTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 s -- in br.simba.bem_estar.proximopasso.ProximoPassoCalculatorTest
[INFO] Running br.simba.bem_estar.proximopasso.ProximoPassoControllerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.013 s -- in br.simba.bem_estar.proximopasso.ProximoPassoControllerTest
[INFO] Running br.simba.bem_estar.proximopasso.ProximoPassoServiceTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 s -- in br.simba.bem_estar.proximopasso.ProximoPassoServiceTest
[INFO] Running br.simba.bem_estar.registroAgua.RegistroAguaControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 s -- in br.simba.bem_estar.registroAgua.RegistroAguaControllerTest
[INFO] Running br.simba.bem_estar.registroExercicio.RegistroExercicioControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 s -- in br.simba.bem_estar.registroExercicio.RegistroExercicioControllerTest
[INFO] Running br.simba.bem_estar.registroSono.RegistroSonoControllerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 s -- in br.simba.bem_estar.registroSono.RegistroSonoControllerTest
[INFO] Running br.simba.bem_estar.rotina.RotinaControllerTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.027 s -- in br.simba.bem_estar.rotina.RotinaControllerTest
[INFO] Running br.simba.bem_estar.rotina.RotinaLembreteIntegrationTest
2026-11-16T20:15:59.568-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.rotina.RotinaLembreteIntegrationTest]: RotinaLembreteIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:59.593-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.rotina.RotinaLembreteIntegrationTest
2026-11-16T20:15:59.594-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.rotina.RotinaLembreteIntegrationTest]: RotinaLembreteIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:59.595-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.BaseIntegrationTest]: BaseIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:15:59.597-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.rotina.RotinaLembreteIntegrationTest
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_lembretes
        (horario, mensagem, titulo, user_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        re1_0.usuario_id,
        re1_0.id,
        re1_0.data_hora,
        re1_0.duracaominutos,
        re1_0.gasto_calorico_extimado,
        re1_0.modalidade 
    from
        tb_registro_exercicio re1_0 
    where
        re1_0.usuario_id=?
Hibernate: 
    select
        ra1_0.usuario,
        ra1_0.id,
        ra1_0.data_hora,
        ra1_0.quantidade_ml 
    from
        tb_registro_agua ra1_0 
    where
        ra1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        re1_0.usuario_id,
        re1_0.id,
        re1_0.data_hora,
        re1_0.duracaominutos,
        re1_0.gasto_calorico_extimado,
        re1_0.modalidade 
    from
        tb_registro_exercicio re1_0 
    where
        re1_0.usuario_id=?
Hibernate: 
    select
        ra1_0.usuario,
        ra1_0.id,
        ra1_0.data_hora,
        ra1_0.quantidade_ml 
    from
        tb_registro_agua ra1_0 
    where
        ra1_0.usuario=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.perfil_id,
        u1_0.username 
    from
        tb_lembretes lm1_0 
    join
        tb_user u1_0 
            on u1_0.id=lm1_0.user_id 
    where
        lm1_0.id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.perfil_id,
        u1_0.username 
    from
        tb_lembretes lm1_0 
    join
        tb_user u1_0 
            on u1_0.id=lm1_0.user_id 
    where
        lm1_0.id=?
Hibernate: 
    delete 
    from
        tb_lembretes 
    where
        id=?
Hibernate: 
    select
        count(*) 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    insert 
    into
        tb_rotina_lembrete
        (dias_semana, hora, mensagem, rotina_id, titulo, id) 
    values
        (?, ?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    update
        tb_rotina 
    set
        ativa=?,
        descricao=?,
        nome=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.id=? 
        and rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    delete 
    from
        tb_rotina_lembrete 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_rotina 
    where
        id=?
Hibernate: 
    select
        count(*) 
    from
        tb_rotina rm1_0
Hibernate: 
    select
        count(*) 
    from
        tb_rotina_lembrete rlm1_0
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.758 s -- in br.simba.bem_estar.rotina.RotinaLembreteIntegrationTest
[INFO] Running br.simba.bem_estar.rotina.RotinaServiceTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s -- in br.simba.bem_estar.rotina.RotinaServiceTest
[INFO] Running br.simba.bem_estar.security.AuthControllerTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 s -- in br.simba.bem_estar.security.AuthControllerTest
[INFO] Running br.simba.bem_estar.security.AuthUserIntegrationTest
2026-11-16T20:16:00.380-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.security.AuthUserIntegrationTest]: AuthUserIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:16:00.400-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.security.AuthUserIntegrationTest
2026-11-16T20:16:00.401-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.security.AuthUserIntegrationTest]: AuthUserIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:16:00.401-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.BaseIntegrationTest]: BaseIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:16:00.403-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.security.AuthUserIntegrationTest
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_perfil
        (altura, idade, peso, streak, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_agua
        (data_hora, quantidade_ml, usuario, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        registro_sono
        (hora_acordar, hora_dormir, nota_sono, usuario_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_registro_exercicio
        (data_hora, duracaominutos, gasto_calorico_extimado, modalidade, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta
        (alvo, concluida_em, data_inicio, tipo, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_meta_agua
        (meta_ml, usuario_id, id) 
    values
        (?, ?, default)
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_lembretes
        (horario, mensagem, titulo, user_id, id) 
    values
        (?, ?, ?, ?, default)
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
2026-11-16T20:16:00.677-03:00  WARN 2828 --- [simba-backend] [           main] b.s.b.infra.RestExceptionHandler         : Response already committed. Ignoring: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (501) exceeds the maximum allowed (500, from `StreamWriteConstraints.getMaxNestingDepth()`)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    insert 
    into
        tb_rotina
        (ativa, descricao, nome, usuario_id, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=? 
    order by
        rsm1_0.hora_dormir desc
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        pm1_0.id,
        u1_0.id,
        u1_0.email,
        u1_0.name,
        u1_0.password,
        u1_0.username,
        pm1_0.altura,
        pm1_0.idade,
        pm1_0.peso,
        pm1_0.streak 
    from
        tb_perfil pm1_0 
    left join
        tb_user u1_0 
            on pm1_0.id=u1_0.perfil_id 
    where
        pm1_0.id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_conquista_usuario
        (codigo, data_desbloqueio, usuario_id, id) 
    values
        (?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        ram1_0.id,
        ram1_0.data_hora,
        ram1_0.quantidade_ml,
        ram1_0.usuario 
    from
        tb_registro_agua ram1_0 
    where
        ram1_0.usuario=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.hora_acordar,
        rsm1_0.hora_dormir,
        rsm1_0.nota_sono,
        rsm1_0.usuario_id 
    from
        registro_sono rsm1_0 
    where
        rsm1_0.usuario_id=?
Hibernate: 
    select
        rem1_0.id,
        rem1_0.data_hora,
        rem1_0.duracaominutos,
        rem1_0.gasto_calorico_extimado,
        rem1_0.modalidade,
        rem1_0.usuario_id 
    from
        tb_registro_exercicio rem1_0 
    where
        rem1_0.usuario_id=?
Hibernate: 
    select
        mm1_0.id,
        mm1_0.alvo,
        mm1_0.concluida_em,
        mm1_0.data_inicio,
        mm1_0.tipo,
        mm1_0.usuario_id 
    from
        tb_meta mm1_0 
    where
        mm1_0.usuario_id=?
Hibernate: 
    select
        mam1_0.id,
        mam1_0.meta_ml,
        mam1_0.usuario_id 
    from
        tb_meta_agua mam1_0 
    where
        mam1_0.usuario_id=?
Hibernate: 
    select
        cum1_0.id,
        cum1_0.codigo,
        cum1_0.data_desbloqueio,
        cum1_0.usuario_id 
    from
        tb_conquista_usuario cum1_0 
    where
        cum1_0.usuario_id=?
Hibernate: 
    select
        lm1_0.id,
        lm1_0.horario,
        lm1_0.mensagem,
        lm1_0.titulo,
        lm1_0.user_id 
    from
        tb_lembretes lm1_0 
    where
        lm1_0.user_id=?
Hibernate: 
    select
        rm1_0.id,
        rm1_0.ativa,
        rm1_0.descricao,
        rm1_0.nome,
        rm1_0.usuario_id 
    from
        tb_rotina rm1_0 
    where
        rm1_0.usuario_id=?
Hibernate: 
    select
        l1_0.rotina_id,
        l1_0.id,
        l1_0.dias_semana,
        l1_0.hora,
        l1_0.mensagem,
        l1_0.titulo 
    from
        tb_rotina_lembrete l1_0 
    where
        l1_0.rotina_id=?
Hibernate: 
    delete 
    from
        tb_registro_agua 
    where
        id=?
Hibernate: 
    delete 
    from
        registro_sono 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_registro_exercicio 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_meta 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_meta_agua 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_conquista_usuario 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_lembretes 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_rotina 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_user 
    where
        id=?
Hibernate: 
    delete 
    from
        tb_perfil 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        count(*) 
    from
        tb_perfil pm1_0
Hibernate: 
    select
        count(*) 
    from
        tb_registro_agua ram1_0
Hibernate: 
    select
        count(*) 
    from
        registro_sono rsm1_0
Hibernate: 
    select
        count(*) 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    select
        count(*) 
    from
        tb_meta mm1_0
Hibernate: 
    select
        count(*) 
    from
        tb_meta_agua mam1_0
Hibernate: 
    select
        count(*) 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    select
        count(*) 
    from
        tb_lembretes lm1_0
Hibernate: 
    select
        count(*) 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.email=?
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    update
        tb_user 
    set
        email=?,
        name=?,
        password=?,
        perfil_id=?,
        username=? 
    where
        id=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.772 s -- in br.simba.bem_estar.security.AuthUserIntegrationTest
[INFO] Running br.simba.bem_estar.security.JwtAuthenticationFilterTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.028 s -- in br.simba.bem_estar.security.JwtAuthenticationFilterTest
[INFO] Running br.simba.bem_estar.security.JWTServiceTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.044 s -- in br.simba.bem_estar.security.JWTServiceTest
[INFO] Running br.simba.bem_estar.sintoma.RegistroSintomaControllerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.052 s -- in br.simba.bem_estar.sintoma.RegistroSintomaControllerTest
[INFO] Running br.simba.bem_estar.sintoma.RegistroSintomaServiceTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 s -- in br.simba.bem_estar.sintoma.RegistroSintomaServiceTest
[INFO] Running br.simba.bem_estar.sintoma.SintomaCalculatorTest
[INFO] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 s -- in br.simba.bem_estar.sintoma.SintomaCalculatorTest
[INFO] Running br.simba.bem_estar.sintoma.SintomasIntegrationTest
2026-11-16T20:16:02.332-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.sintoma.SintomasIntegrationTest]: SintomasIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:16:02.368-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.sintoma.SintomasIntegrationTest
2026-11-16T20:16:02.369-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.sintoma.SintomasIntegrationTest]: SintomasIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:16:02.369-03:00  INFO 2828 --- [simba-backend] [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [br.simba.bem_estar.BaseIntegrationTest]: BaseIntegrationTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2026-11-16T20:16:02.372-03:00  INFO 2828 --- [simba-backend] [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration br.simba.bem_estar.BemEstarApplication for test class br.simba.bem_estar.sintoma.SintomasIntegrationTest
Hibernate: 
    delete 
    from
        tb_rotina_lembrete rlm1_0
Hibernate: 
    delete 
    from
        tb_rotina rm1_0
Hibernate: 
    delete 
    from
        tb_lembretes lm1_0
Hibernate: 
    delete 
    from
        tb_conquista_usuario cum1_0
Hibernate: 
    delete 
    from
        tb_meta mm1_0
Hibernate: 
    delete 
    from
        tb_meta_agua mam1_0
Hibernate: 
    delete 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    delete 
    from
        tb_registro_agua ram1_0
Hibernate: 
    delete 
    from
        tb_registro_exercicio rem1_0
Hibernate: 
    delete 
    from
        registro_sono rsm1_0
Hibernate: 
    delete 
    from
        tb_user um1_0
Hibernate: 
    delete 
    from
        tb_perfil pm1_0
Hibernate: 
    insert 
    into
        tb_user
        (email, name, password, perfil_id, username, id) 
    values
        (?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    update
        tb_registro_sintoma 
    set
        atualizado_em=?,
        criado_em=?,
        data_registro=?,
        dor=?,
        energia=?,
        estresse=?,
        humor=?,
        locais_dor=?,
        observacao=?,
        sintomas=?,
        usuario_id=? 
    where
        id=?
Hibernate: 
    select
        count(*) 
    from
        tb_registro_sintoma rsm1_0
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro=?
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    insert 
    into
        tb_registro_sintoma
        (atualizado_em, criado_em, data_registro, dor, energia, estresse, humor, locais_dor, observacao, sintomas, usuario_id, id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default)
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        um1_0.id,
        um1_0.email,
        um1_0.name,
        um1_0.password,
        um1_0.perfil_id,
        um1_0.username 
    from
        tb_user um1_0 
    where
        um1_0.username=?
Hibernate: 
    select
        rsm1_0.id,
        rsm1_0.atualizado_em,
        rsm1_0.criado_em,
        rsm1_0.data_registro,
        rsm1_0.dor,
        rsm1_0.energia,
        rsm1_0.estresse,
        rsm1_0.humor,
        rsm1_0.locais_dor,
        rsm1_0.observacao,
        rsm1_0.sintomas,
        rsm1_0.usuario_id 
    from
        tb_registro_sintoma rsm1_0 
    where
        rsm1_0.usuario_id=? 
        and rsm1_0.data_registro>=? 
    order by
        rsm1_0.data_registro desc
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.335 s -- in br.simba.bem_estar.sintoma.SintomasIntegrationTest
[INFO] Running br.simba.bem_estar.streak.StreakCalculatorTest
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 s -- in br.simba.bem_estar.streak.StreakCalculatorTest
[INFO] Running br.simba.bem_estar.streak.StreakControllerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 s -- in br.simba.bem_estar.streak.StreakControllerTest
[INFO] Running br.simba.bem_estar.streak.StreakServiceTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 s -- in br.simba.bem_estar.streak.StreakServiceTest
[INFO] Running br.simba.bem_estar.user.UserAccountServiceTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.020 s -- in br.simba.bem_estar.user.UserAccountServiceTest
[INFO] Running br.simba.bem_estar.user.UserControllerTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 s -- in br.simba.bem_estar.user.UserControllerTest
[INFO] Running br.simba.bem_estar.user.UserDetailsServiceImplTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.006 s -- in br.simba.bem_estar.user.UserDetailsServiceImplTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 188, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:22 min
[INFO] Finished at: 2026-11-16T20:16:02-03:00
[INFO] ------------------------------------------------------------------------
````
