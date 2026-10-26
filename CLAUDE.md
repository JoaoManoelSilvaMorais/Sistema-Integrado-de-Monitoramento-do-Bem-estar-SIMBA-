# CLAUDE.md — SIMBA

Este arquivo é lido no início de cada sessão. Leia tudo antes de mexer no código.
Responda sempre em **português do Brasil**, de forma simples e direta.

---

## 1. A ideia do programa (leia primeiro)

**SIMBA — Sistema Integrado de Monitoramento do Bem-estar Automatizado.**
Projeto acadêmico do curso de Sistemas de Informação da UEG (disciplina *Práticas Interdisciplinares*),
equipe **Mufasa Softwares** (mascote: um leão; "simba" = leão). Equipe: João Manoel, Samuel (CTO), Pedro Lucas, Marco Túlio, Rubens.

**O problema:** ansiedade, burnout, sedentarismo e sobrecarga mental, agravados por termos
os dados de saúde espalhados em vários apps. **A solução:** um único app web simples onde a pessoa
registra **água, sono e treinos**, organiza **rotinas** com **lembretes**, e é **motivada a manter
uma rotina saudável** com ofensiva (streak), conquistas, metas e comparativos.

**O objetivo real do produto não é só guardar dados: é a pessoa continuar voltando todo dia.**
Por isso toda decisão de funcionalidade deve responder: *isso ajuda o usuário a manter o hábito?*

### O que o usuário faz no app
| Módulo | O que é |
|---|---|
| **Hidratação** | Registra quantos ml bebeu e quando. Tem meta diária **personalizada** (ver §4.4). |
| **Sono** | Registra hora de dormir/acordar e nota de 1 a 5. |
| **Treinos** | Registra modalidade, minutos e gasto calórico estimado. |
| **Rotina** | Uma rotina (ex.: "Treinos", "Leitura", "Estudo") **agrupa lembretes**; cada lembrete tem **horário + dias da semana** em que se repete. É a ideia original do Rubens: *rotina treinos → dentro dela, lembretes de quando treinar, repetindo nos dias escolhidos*. |
| **Lembretes** | Lembretes avulsos com data/hora (módulo antigo do grupo, continua existindo). |
| **Progresso** | Gráficos de sono, hidratação e treinos + **comparativo com a semana passada**. |
| **Ofensiva (streak)** | Quadro de destaque na dashboard com o leãozinho em SVG, que muda de emoção/frase conforme a situação. |
| **Conquistas** | 26 conquistas desbloqueáveis automaticamente (+ metas do usuário). |
| **Metas** | O usuário escolhe um desafio ("treinar 5 dias seguidos") e o app atualiza o progresso sozinho. |
| **Dashboard** | Resumo do dia, "próximo passo" sugerido, botão rápido **+250 ml**, ofensiva. |
| **Perfil** | Peso, altura, idade (o peso alimenta a meta de água sugerida). |

Escopo futuro citado no README (ainda **não** feito): alimentação, dados clínicos (pressão, frequência cardíaca),
medicamentos, orientações preditivas/alertas, perfil "Suporte".

---

## 2. Stack e como rodar

- **Java 25**, **Spring Boot 4.1.1**, Spring Data JPA (Hibernate 7), Spring Security + **JWT**, Maven (`mvnw`).
- Banco **H2 em memória** (`jdbc:h2:mem:simba`, `ddl-auto=update`) → **os dados somem a cada reinício**. (O README cita PostgreSQL como destino; hoje é H2 para prototipagem.)
- Frontend **estático** em `src/main/resources/static` (HTML + CSS + JS puro, sem framework). Token JWT em `sessionStorage.jwtToken`.
- Máquina do dono do projeto: **Windows** (PowerShell). Comandos:

```powershell
.\mvnw clean spring-boot:run                                   # uso normal
.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo" # com usuário demo (demo / demo123)
```

Aplicação em `http://localhost:8080` (entrar pela `entrar.html`).

### Perfil `demo`
`demo/DemoDataSeeder.java` (só com o perfil `demo`) cria o usuário **demo / demo123** com ~30 dias de uso:
sono, água, treinos, 4 rotinas com lembretes, **3 dias sem registro** (provam a tolerância da ofensiva) e 2 metas.
Mantenha o seeder atualizado quando criar uma entidade/funcionalidade nova que dependa de histórico.

---

## 3. Estrutura do código

Pacote base: `src/main/java/br/simba/bem_estar/` (nomes de pacote **em minúsculas**, exceto os legados `registroAgua`, `registroSono`, `registroExercicio`).

| Pacote | Responsabilidade |
|---|---|
| `user`, `perfil`, `security` | Usuário, perfil biométrico, JWT, `SecurityConfig` (libera páginas `.html`, `/css/**`, `/js/**`, `/img/**`; o resto exige token). |
| `registroAgua` `registroSono` `registroExercicio` | CRUD dos registros (`/registroAgua`, `/registrosono/`, `/registroexercicio`). |
| `Lembrete` → deve ser **`lembrete`** | Lembretes avulsos (`/lembretes`). Ver armadilha §6.1. |
| `rotina` | Rotinas + `RotinaLembreteModel` (hora + `diasSemana` como "1,3,5", 1 = segunda … 7 = domingo). `/api/rotinas`. |
| `progresso` | Dados dos gráficos (`/progresso`). |
| `historico` | **Camada compartilhada**: `HistoricoService.carregar(usuario)` lê água/sono/treino uma vez e `HistoricoCalculos` tem as contas (água por dia, dias de treino, maior sequência…). Streak, conquistas, metas e comparativo usam isto. **Não duplique essas contas.** |
| `streak` | `StreakCalculator` (regra da ofensiva), `StreakDTO`, `GET /api/streak`. |
| `conquista` | `Conquista` (enum, 26), `ConquistaCalculator`, `ConquistaService`, `GET /api/conquistas`. Guarda as desbloqueadas em `tb_conquista_usuario`. |
| `meta` | Metas do usuário (`tb_meta`) + meta de água (`tb_meta_agua`). `/api/metas`, `/api/metas/agua`. |
| `comparativo` | Últimos 7 dias × 7 anteriores. `GET /api/comparativo`. |
| `proximopasso` | Escolhe **uma** sugestão para a dashboard. `GET /api/proximo-passo`. |
| `exceptions` | `RestExceptionHandler` global (§5). |
| `demo` | Seeder do perfil `demo`. |

Padrão de cada módulo novo: `Model` + `Repository` + `Service` + `Controller` + `DTO` (records) e, quando há
regra de negócio, uma classe **`*Calculator` em Java puro** (sem Spring), fácil de testar.

Frontend (`src/main/resources/static`): uma página `.html` + `css/<pagina>.css` + `js/<pagina>.js` por tela.
Compartilhados: `css/style.css` (variáveis `--green --dark --muted --border --glass`), `js/script.js` (menu),
`js/feedback.js` (avisos ao registrar), `js/streak.js` + `css/streak.css` (leão e ofensiva),
`js/metas.js` (metas na tela de conquistas), `js/comparativo.js` (Progresso), `css/metas.css`, `css/feedback.css`.

---

## 4. Regras de negócio (não mude sem o dono pedir)

### 4.1 Dia ativo
Um dia é **ativo** se tem **qualquer** registro (água, sono ou treino). Sono conta no dia em que a pessoa **acordou**.
Fuso: `America/Sao_Paulo`.

### 4.2 Ofensiva (streak) — com tolerância
- A ofensiva só **quebra** se houver **mais de 2 faltas seguidas** ou **mais de 2 faltas dentro de uma janela de 7 dias**.
- Depois da **primeira falta** a ofensiva entra **"em risco"** (`diaRisco` 1 ou 2); no 2º dia seguido sem registro é a **`ultimaChance`**.
  O leão fica com **cara de medo** e as frases mudam. "Hoje ainda sem registro" **não** conta como falta.
- Emoções do leão (`js/streak.js`): início, triste (zerou), **medo** (em risco), preocupado, feliz, animado (≥ 7 dias), rei (≥ 30 dias).
- `PerfilModel.streak` é legado e **não é usado**; a fonte é `StreakCalculator`.

### 4.3 Conquistas (26)
Categorias: Hidratação, Sono, Treinos, Rotinas, Ofensiva, Geral. Desbloqueio automático ao abrir `/api/conquistas`
(que grava as novas e marca `nova = true` uma vez). "Boa noite de sono" = **≥ 7 h**. Metas de água usam a **meta personalizada**.
Para criar outra: adicione no enum `Conquista` e a regra em `ConquistaCalculator` (ícone FontAwesome, categoria, meta, unidade).

### 4.4 Meta de água personalizada
`MetaAguaCalculator`: sugerida = **35 ml × peso (kg)**, limitada a 1500–5000 ml (2000 se não há peso). O usuário pode definir a sua
(500–8000 ml) em Conquistas → "Meta de água" ou voltar à sugerida. Dashboard e Hidratação leem `GET /api/metas/agua`.

### 4.5 Metas do usuário
Tipos (`TipoMeta`): `TREINO_SEGUIDOS`, `AGUA_SEGUIDOS`, `SONO_SEGUIDOS`, `TREINO_TOTAL`. Só contam registros **a partir do dia da criação**.
Máx. 5 ativas, sem duplicar tipo ativo. Ao concluir, vira `concluidaEm` e aparece "Aumentar desafio" (usa `alvoSugerido`).

### 4.6 Comparativo semanal
Média de água/dia, média de horas de sono, dias com treino e dias ativos: últimos 7 dias × 7 anteriores.
Tendências: `subiu`, `caiu`, `igual`, `novo`, `sem`. Ex.: "Você bebeu 12% a mais que na semana passada."

### 4.7 Próximo passo (dashboard)
Prioridade: **ofensiva em risco > "quase lá" (meta a 1 do alvo ou ≥ 80%; conquista ≥ 50%) > água de hoje > meta ativa > conquista mais próxima > tudo em dia**.

### 4.8 Feedback imediato
`js/feedback.js` embrulha `window.fetch`: quando um **POST** em `/registroAgua`, `/registrosono` ou `/registroexercicio` dá certo,
consulta streak/conquistas/metas e mostra avisos (ofensiva do dia, conquista nova, meta concluída). Para ativar numa tela nova,
basta incluir `css/feedback.css` e `js/feedback.js` **antes** dos outros scripts.

---

## 5. Convenções

- **Nomes em português** (classes, métodos, variáveis, mensagens). Mensagens ao usuário em pt-BR.
- Simples, mas funcional. Siga o padrão que já existe; não introduza framework novo (nada de React/Lombok se o projeto não usa).
- **Edições mínimas em arquivos dos colegas** (ex.: `hidratacao.js`, `sono.js`, `treinos.js`): prefira um arquivo novo a reescrever.
- Regras em classes `*Calculator` puras (sem Spring); controllers finos; DTOs como `record`.
- Erros: lançar `RegraDeNegocioException` (422), `DadoNaoEncontradoException` (404), `AcessoNegadoException` (403) ou
  `DadosDuplicadosException` (409). O `RestExceptionHandler` devolve `{status, message}` e o front mostra `message`.
- Sempre filtrar dados **pelo usuário autenticado** (`authentication.getName()`); nunca confiar em id vindo do front.
- Front: sem `innerHTML` com dado do usuário (use `textContent`); envolver `sessionStorage`/`localStorage` em `try/catch`; cards novos reutilizam as variáveis de `style.css`.
- Novas páginas `.html` precisam ser liberadas no `SecurityConfig` (lista `permitAll`) e ganhar link no menu lateral de **todas** as telas.

---

## 6. Armadilhas conhecidas

1. **Pasta `Lembrete` x `lembrete`:** o pacote declarado é `...lembrete` mas a pasta veio como `Lembrete`. No Windows isso
   funciona por um tempo e depois quebra a inicialização ("declared package does not match expected package"). Renomear em duas etapas
   (`git mv Lembrete tmp && git mv tmp lembrete`), apagar `target` e rodar `.\mvnw clean spring-boot:run`.
2. **H2 em memória:** reiniciar apaga tudo. Para teste use o perfil `demo`.
3. **Meta de água antiga:** existiam 2000 ml (dashboard) e 3000 ml (`hidratacao.js`) fixos. Agora ambos leem `/api/metas/agua`; os valores fixos são só fallback.
4. **Código escrito sem compilar:** a primeira versão destas funcionalidades (ofensiva v2, conquistas v2, metas, comparativo, próximo passo, feedback) foi
   escrita num ambiente sem Maven/Spring. A lógica pura foi testada (117 casos) e as telas testadas com jsdom,
   mas **as classes Spring (`*Service`, `*Controller`, `*Model`, `*Repository`) ainda precisam ser compiladas**. Se `mvnw` reclamar, corrija
   (provavelmente import/assinatura) — não reescreva a regra.
5. `spring-boot-starter-data-jdbc` gera avisos de repositório no log; são ruído, não erro.

---

## 7. Como testar

- Backend/regras: não há testes automatizados além de `BemEstarApplicationTests`. Ao mexer em um `*Calculator`, escreva o teste como
  um arquivo único (`java Teste.java`, com a classe de teste primeiro e as classes puras coladas depois, sem `package`/`import`) ou, melhor,
  JUnit em `src/test/java` espelhando o pacote. Cubra: vazio, limites, datas nulas/futuras, e a regra de tolerância da ofensiva.
- Front: `node --check js/arquivo.js`; telas com jsdom (stub de `fetch`).
- Fluxo manual: subir com `-Dspring-boot.run.profiles=demo`, entrar com `demo/demo123`, conferir dashboard (leão, próximo passo, +250 ml),
  Conquistas (metas e meta de água) e Progresso (comparativo). Registrar algo deve mostrar avisos no canto superior direito.

---

## 8. Documentação acadêmica (como Claude Code deve se comportar)

O SIMBA é avaliado na disciplina **Prática Interdisciplinar de Sistemas de Informação (UEG)**. O que existe/é usado:

- **README.md** (neste repositório): visão do projeto, objetivos, atores, **diagrama de caso de uso** e **diagrama de classes** (Mermaid), escopo da versão 1.0, tecnologias, equipe. É a documentação viva do código.
- **Documento de visão**, **plano de ensino**, **formulário respondido pela equipe**, **backlog de 14 histórias de usuário** (a equipe já concluiu a **Sprint 5**) e
  **slides da 1ª versão** (avaliada em 10 pontos por 10 critérios; funcionalidades vale 2,0 e funcionamento/integração 1,5): ficam **fora do repositório**
  com o dono. Se ele colocar esses arquivos numa pasta `docs/`, leia-os antes de decidir escopo.

Regras para o futuro:
1. **Mantenha o README coerente com o código.** Ao criar/alterar entidade, atualize o *diagrama de classes* (hoje ele ainda não mostra
   `RotinaLembreteModel`, `ConquistaUsuarioModel`, `MetaModel`, `MetaAguaModel`; e `LembreteModel`/`RotinaModel` devem refletir o código atual). Ao criar funcionalidade
   de usuário, confira o *caso de uso* e a lista de *Funcionalidades e Escopo*. Faça isso **só quando o dono pedir ou ao concluir uma entrega**, avisando o que mudou.
2. **Trabalhe por história de usuário:** antes de implementar, diga qual necessidade do usuário a mudança atende e como o dono pode demonstrar isso
   (importante para a nota de "funcionalidades" e "funcionamento/integração": o que aparece na tela precisa **funcionar de ponta a ponta**).
3. Não declare uma funcionalidade "pronta" se não foi rodada; diga o que foi e o que não foi verificado.
4. Se pedirem material de apresentação/documentação, use **só** o que o código e os documentos do dono sustentam — não invente métricas, requisitos nem histórias.

---

## 9. Como o dono prefere trabalhar

- **Explique o plano antes de codar** quando ele pedir ("me explica antes de mandar qualquer coisa").
- **Simples mas funcional**, seguindo o que o projeto já faz; se o jeito simples for frágil, faça o melhor e explique.
- Ele testa na própria máquina Windows; seja **honesto** sobre o que não foi compilado/rodado.
- Entregue com instruções curtas de teste e os pontos de atenção.
