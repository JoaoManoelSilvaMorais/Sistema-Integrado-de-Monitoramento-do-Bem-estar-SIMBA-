# Registro de alterações — SIMBA

Diário do que foi alterado no projeto, o que foi usado e como testar.
**Entradas novas ficam no topo.** Regra definida no `CLAUDE.md` §10.

<!--
MODELO (copie para o topo a cada entrega):

## AAAA-MM-DD — Título curto
**Pedido / história:** ...
**Alterado:**
- `caminho/arquivo` — o que mudou
**Usado:** ferramentas, bibliotecas, comandos, rotas, tabelas
**Como testar:**
1. ...
**Verificado:** o que foi rodado de verdade · **Não verificado:** o que falta
**Pendências / atenção:** ...
-->

---

## 2026-11-09 — Branch com todas as alterações (commits)
**Pedido:** criar uma branch com todas as alterações.
**Alterado (git):** branch `feature/sinais-corporais` (criada a partir de `main` em `fbe388c`) com 3 commits locais: `feat: Sinais Corporais…`, `feat: peso e altura no perfil…` e `docs: CLAUDE.md, ALTERACOES.md e .gitignore`. 42 arquivos, só inserções em relação à `main`.
**Usado:** git (commit). **Não** foi feito push.
**Como testar:** `git log --oneline -4` e `git diff --stat main..feature/sinais-corporais`. Para enviar: `git push -u origin feature/sinais-corporais`.
**Verificado:** `git status` limpo depois dos commits. **Atenção:** o `perfil.html` foi inteiro no commit do perfil (tem também o link do menu de Sinais Corporais).

## 2026-11-09 — Perfil: altura até 3 m + sugestões de metas pelo peso e altura
**Pedido:** aumentar a altura máxima para 3 metros e colocar sugestões de metas com base na altura e no peso.
**Alterado:**
- `perfil/MedidasCalculator.java` — altura máxima 2,5 → 3,0 m (mensagem "entre 80 e 300 cm").
- `perfil/SugestoesCalculator.java` (novo, Java puro) — sugestões: **peso** (faixa saudável = IMC 18,5–24,9 × altura²; abaixo → ganhar até o início da faixa; adequado → manter; sobrepeso/obesidade → primeira meta de perder 5%), **água** (mesma meta do `MetaAguaCalculator`, 35 ml/kg) e **atividade** (OMS: 150–300 min/semana; força para quem está abaixo do peso).
- `perfil/SugestaoMetaDTO.java` (novo) · `perfil/MedidasResponseDTO.java` — +lista `sugestoes`.
- `perfil/PerfilController.java` — +`GET /perfil/me/medidas/previa?peso=&altura=` (calcula sem salvar, valida os limites).
- `test/.../perfil/SugestoesCalculatorTest.java` (novo, 9 testes) · `MedidasCalculatorTest.java` — limites de 3 m.
- `static/perfil.html` — bloco "Sugestões de metas" no popup (com link "Criar meta" para Conquistas); aviso final trocado para "sugestões gerais, não substituem profissional de saúde". Só inserções no arquivo.
- `static/css/perfil-medidas.css` — estilos das sugestões (ícone colorido por tipo).
- `static/js/perfil-medidas.js` — limite 300 cm; sugestões atualizam enquanto digita (espera 350 ms, descarta respostas fora de ordem); ao abrir mostra as do que está salvo.
**Usado:** Spring, JUnit 5, `NumberFormat` pt-BR; Node (teste da API) e Edge headless (teste da tela).
**Como testar:** perfil demo → Meu perfil → Peso e altura → digitar 90 e 175 (sugere perder 4,5 kg, 3.150 ml de água, 150–300 min) → 50 kg (sugere ganhar 6,7 kg, treino de força) → altura 290 (aceita) / 310 (erro).
**Verificado:** 32 testes JUnit OK (6 medidas + 9 sugestões + 17 sintoma); `node --check`; app rodado (porta 8081): prévia para adequado/abaixo/sobrepeso/só peso/só altura/vazio, 2,90 m aceito, 3,10 m → 422, PUT com 2,95 m OK e devolve sugestões, sem token → 403; tela no Edge headless: sugestões trocam ao digitar, somem sem peso, 290 cm aceito, 310 cm dá erro, zero erro de JS. **Não verificado:** teste manual por pessoa; Firefox/Safari.
**Atenção:** as sugestões de peso usam regras gerais (OMS, perda inicial de 5%); não são orientação médica — o texto do popup diz isso.

## 2026-11-09 — Perfil: medidas num campo só + IMC colorido no popup
**Pedido:** deixar "Medidas corporais" como um único campo que abre o popup; no popup mostrar o IMC com a faixa em cores e um "?" explicando a conta.
**Alterado (só front; back-end igual):**
- `static/perfil.html` — seção virou um campo clicável com o resumo ("72,5 kg · 1,75 m · IMC 23,7 (Peso adequado)"); no modal entrou o bloco do IMC (valor, etiqueta da faixa, barra com as 4 faixas e marcador, legenda com os limites, "?" com a explicação).
- `static/css/perfil-medidas.css` — cores das faixas (azul abaixo, verde adequado, âmbar sobrepeso, vermelho obesidade), barra, marcador, explicação; modal de medidas rola por dentro em telas baixas.
- `static/js/perfil-medidas.js` — resumo no campo; IMC recalculado enquanto digita (mesma conta e faixas do `MedidasCalculator`); "?" mostra a conta com os números da pessoa.
**Usado:** HTML/CSS/JS puros, Font Awesome; Edge headless para testar.
**Como testar:** perfil demo → Meu perfil → campo "Peso e altura" → mudar o peso (50, 75, 85, 110) e ver a cor/faixa mudar → "?" → Salvar → F5.
**Verificado:** `node --check`; app rodado (porta 8081) e tela no Edge headless: seção com 1 campo só e resumo certo; IMC 23,7/23,1 adequado, 16,3 abaixo, 27,8 sobrepeso, 38,1 obesidade, vazio sem marcador; "?" mostra "75 ÷ (1,80 × 1,80) = 75 ÷ 3,24 = 23,1"; salvar e F5 mantêm; celular: modal rola por dentro, sem rolagem horizontal; zero erro de JS. **Não verificado:** teste manual por pessoa; Firefox/Safari (`color-mix` exige navegador de 2023 em diante — sem ele só a etiqueta fica sem fundo colorido).

## 2026-11-09 — Perfil: adicionar e editar peso e altura
**Pedido:** na aba Perfil, um campo para editar e adicionar peso e altura do usuário.
**Achado:** o cadastro não cria perfil e o `POST /perfil` antigo não ligava o perfil ao usuário (a ligação fica em `UserModel.perfil`), então usuário novo nunca conseguia ter peso/altura. As rotas antigas não foram alteradas (nenhuma tela usa).
**Alterado:**
- `perfil/MedidasCalculator.java` (novo, Java puro) — valida peso 20–350 kg e altura 0,80–2,50 m; IMC com 1 casa; faixas da OMS para adultos.
- `perfil/MedidasDTO.java`, `perfil/MedidasResponseDTO.java` (novos, `record`).
- `perfil/PerfilService.java` — +`buscarMedidas` e +`salvarMedidas` (cria o perfil e liga ao usuário se não existir; campo em branco = 0 = "não informado").
- `perfil/PerfilController.java` — +`GET /perfil/me/medidas` e +`PUT /perfil/me/medidas`.
- `test/.../perfil/MedidasCalculatorTest.java` (novo) — 6 testes.
- `static/perfil.html` — seção "MEDIDAS CORPORAIS" (Peso, Altura, IMC + botão "Adicionar/Editar peso e altura") e modal; só inserções.
- `static/js/perfil-medidas.js` e `static/css/perfil-medidas.css` (novos) — não mexem no `perfil.js` do colega; reaproveitam as classes e o aviso (`exibirMensagem`) da tela.
**Usado:** Spring/JPA, JUnit 5, Font Awesome; Node (teste da API) e Edge headless (teste da tela).
**Como testar:** subir com perfil demo → Meu perfil → seção Medidas corporais mostra 72,5 kg / 1,75 m / IMC 23,7 → "Editar peso e altura" → mudar para 80 e 180 → Salvar (aviso verde) → F5 → ir em Hidratação/Conquistas: a meta de água sugerida vira 2.800 ml.
**Verificado:** 23 testes JUnit OK (6 novos + 17 do sintoma); `node --check`; app rodado (porta 8081): API com usuário demo e com usuário recém-cadastrado sem perfil (cria e liga), meta de água sugerida mudou para 2.800 ml com 80 kg, erros 422 com mensagem, sem token 403; tela no Edge headless: "Não informado" para usuário novo, modal abre, altura 17 e peso "7a" dão erro no campo certo, "68,4" + "170" salvam (IMC 23,7), F5 mantém, Esc fecha, modal antigo "Editar informações" continua funcionando, celular sem rolagem horizontal, zero erro de JS. **Não verificado:** teste manual por pessoa; Firefox/Safari.
**Pendências / atenção:** README — `PerfilModel` já está no diagrama; dá para citar as novas rotas/IMC se quiser.

## 2026-11-09 — Sinais Corporais v3: boneco removido, campo "Onde dói?" com lista
**Pedido:** retirar totalmente o boneco da tela e usar só um campo que, ao clicar, mostra a lista de partes do corpo.
**Alterado:**
- `static/sintomas.html` — removido o quadro do boneco (SVG, Frente/Costas, botões extras); na pergunta de dor entrou o campo "Onde dói?" (botão + lista com caixas de marcar). Página volta a ter uma coluna.
- `static/css/sintomas.css` — removidos todos os estilos/animações do boneco e do quadro fixo; estilos do campo e da lista (2 colunas no computador, 1 no celular).
- `static/js/sintomas.js` — removido todo o código do boneco (cliques, expressões, animações); campo com lista: abre ao clicar, já abre sozinho ao escolher Leve/Moderada/Forte, fecha ao clicar fora ou com Esc, mostra no campo o que foi marcado ("Cabeça, Lombar"); "Nenhuma" esconde o campo e limpa os locais. Proteção para não quebrar se "Cancelar" for chamado sem registro de hoje.
- `sintoma/SintomaCalculator.java` — mensagem "Marque no boneco onde está doendo." → "Escolha onde está doendo." · `sintoma/LocalDor.java` — só o comentário.
**Usado:** HTML/CSS/JS puros (checkboxes nativos), Font Awesome; Edge headless via DevTools para testar.
**Como testar:** subir com perfil demo → Sinais Corporais → em "Está sentindo dor?" escolher Moderada (a lista abre) → marcar Cabeça e Lombar → clicar fora (fecha e o campo mostra "Cabeça, Lombar") → Salvar → F5 → Editar (campo volta preenchido).
**Verificado:** 17 testes JUnit OK; `node --check` OK; app rodado (porta 8081) e tela testada no Edge headless: nenhum boneco na página, 10 partes na lista, abre ao escolher a dor, salvar sem local mostra "Escolha onde está doendo." e marca o campo em vermelho, clicar fora e Esc fecham (foco volta ao campo), "Nenhuma" esconde e limpa, salvar → resumo → F5 mantém, Editar volta com as partes marcadas, celular em 1 coluna sem rolagem horizontal, zero erro de JS. **Não verificado:** teste manual por pessoa; Firefox/Safari.

## 2026-11-08 — Sinais Corporais v2: ícones, boneco fixo e animado
**Pedido:** tirar os emojis (usar ícones do projeto), boneco num quadro à direita que acompanha a rolagem, no estilo das referências (simples, com sombra e vida) e com animações de tempos em tempos (olhar para o lado, coçar a cabeça, respirar).
**Alterado (só a tela; back-end igual):**
- `static/sintomas.html` — layout em 2 colunas; boneco novo em SVG próprio (um só, com botão Frente/Costas), sombra em dois tons, careca com brilho, cueca azul-marinho, braço direito em 2 partes para coçar a cabeça.
- `static/css/sintomas.css` — quadro `position: sticky`; respiração e piscar contínuos; olhar/coçar/"ai"/virar por classe; no celular o quadro vai para o topo; respeita "reduzir movimento"; `[hidden]` corrigido para vencer `display:flex`.
- `static/js/sintomas.js` — ícones Font Awesome (bateria = energia, carinhas = humor, termômetro = estresse); boneco clicável no formulário e só leitura no resumo (mostra a dor de hoje); tocar no boneco sem escolher intensidade marca "Leve"; boca e pálpebras seguem humor/energia; animação aleatória a cada 5–10 s (pausa com a aba escondida).
**Usado:** SVG + CSS animations + SMIL (`animateTransform` para o braço), Font Awesome 6.5.2 (já no projeto), Edge headless via DevTools para testar.
**Como testar:** subir com perfil demo → Sinais Corporais → escolher energia/humor baixos (o rosto do boneco muda) → tocar na cabeça (dor vira "Leve") → Costas → tocar na lombar → rolar a página (o quadro fica parado à direita) → esperar uns segundos (olha para os lados / coça a cabeça) → Salvar → F5.
**Verificado:** `node --check`; app rodado (porta 8081) e tela testada no Edge headless: nenhum emoji, 15 ícones, boneco marca frente+costas, quadro continua no topo após rolar 1.539 px, salvar e recarregar mantêm a dor no boneco, celular sem rolagem horizontal, zero erro de JS; prints da animação de coçar e olhar. **Não verificado:** teste manual por pessoa; Firefox/Safari (SMIL funciona neles, mas não foi aberto).
**Atenção:** durante o teste, um `mvnw clean` meu recompilou a pasta `target` enquanto o app do dono estava rodando na 8080 — se algo estranho aparecer nele, é só reiniciar.

## 2026-11-08 — Sinais Corporais (questionário diário de saúde + histórico)
**Pedido / história:** Integrante 2. "Como usuário, quero responder todo dia um questionário rápido sobre como meu corpo está (energia, sono, dores, estresse etc.) e ver meu histórico, para perceber padrões no meu bem-estar." Branch `feature/sinais-corporais` (sem commit).
**Decisões do dono:** reenviar no mesmo dia **atualiza** o registro de hoje; **não** conta como dia ativo da ofensiva (StreakCalculator e conquistas intocados); sem rota de editar/excluir registro antigo; dor em **vários locais**, escolhidos num **boneco 2D clicável**.
**Alterado:**
- `sintoma/` (pacote novo) — `RegistroSintomaModel` (`tb_registro_sintoma`, único por usuário+dia), enums `NivelDor`/`LocalDor`/`Sintoma`, `RegistroSintomaRepository`, `RegistroSintomaService` (fuso America/Sao_Paulo), `RegistroSintomaController`, DTOs `record` e `SintomaCalculator` (Java puro: validação + resumo da semana).
- `src/test/java/.../sintoma/SintomaCalculatorTest.java` — 17 testes JUnit.
- `static/sintomas.html`, `css/sintomas.css`, `js/sintomas.js` — tela nova (questionário ou resumo de hoje com "Editar", boneco de frente/costas, resumo da semana, histórico em cards).
- `SecurityConfig.java` — +1 linha: `/sintomas.html` no `permitAll`.
- 9 telas (`index`, `hidratacao`, `sono`, `treinos`, `rotinas`, `lembretes`, `progresso`, `conquistas`, `perfil`) — só o link "Sinais Corporais" no menu, depois de Treinos.
- `DemoDataSeeder.java` — 17 respostas nos últimos 20 dias (hoje e ontem em aberto); `Random` próprio para não alterar os outros dados do demo.
**Usado:** Spring Data JPA, JUnit 5, Node 24 (`node --check` e script de teste da API), Edge headless via DevTools para prints da tela. Rotas: `POST /api/sintomas`, `GET /api/sintomas`, `GET /api/sintomas/hoje`.
**Como testar:**
1. `.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"` → entrar com demo / demo123.
2. Menu → **Sinais Corporais**: aparece o questionário (hoje não respondido) e embaixo 17 dias de histórico + "Sua semana" (dor de cabeça em 3 dias).
3. Responder; em Dor escolher "Moderada" → tocar na cabeça e nas costas do boneco → Salvar → aparece "Respondido!".
4. F5 → continua o resumo de hoje. "Editar" → muda algo → salva → continua 1 registro só para hoje.
5. Testes: `.\mvnw test -Dtest=SintomaCalculatorTest`.
**Verificado:** compilação e 17 testes OK; app rodado com perfil demo; API testada de verdade (POST cria, 2º POST atualiza o mesmo id, 5 erros → 422 com mensagem, sem token → 403); tela aberta no Edge headless: formulário, boneco (frente e costas marcam juntos), salvar, recarregar, celular sem rolagem horizontal, zero erro de JS; link presente nas 9 telas. **Não verificado:** clique manual feito por pessoa no navegador; Firefox/Safari; `BemEstarApplicationTests` (suíte completa) não foi rodada.
**Pendências / atenção:** README (diagrama de classes e caso de uso) aguarda confirmação do dono. Dois POSTs simultâneos no mesmo segundo podem dar erro 500 (a restrição única impede duplicar, mas não há tratamento amigável).

## 2026-11-08 — Regra de relatório + este arquivo
**Pedido:** ter sempre um feedback do que foi alterado, o que foi usado e como testar, documentado em arquivo.
**Alterado:**
- `CLAUDE.md` — nova seção §10 "Relatório obrigatório de cada entrega".
- `ALTERACOES.md` — criado (este arquivo), com as entradas de hoje.
**Usado:** só edição de texto.
**Como testar:** abrir o Claude Code (aqui ou no VS Code), pedir qualquer alteração e conferir que ele responde com as 4 partes e adiciona uma entrada no topo deste arquivo.
**Verificado:** arquivos criados · **Não verificado:** comportamento numa próxima sessão.

## 2026-11-08 — Commit do João puxado do GitHub
**Pedido:** atualizar o projeto com o GitHub.
**Alterado:** `git pull --ff-only` trouxe o commit `fbe388c` "correções gráficas: Sprint 1 N2" (18 arquivos do front, novo `js/notificacoes.js`).
**Usado:** git.
**Como testar:** `.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"`, entrar com demo/demo123 e passar pelas telas (dashboard, hidratação, lembretes, notificações).
**Verificado:** pull sem conflito; `node --check` OK em hidratacao/lembretes/metas/notificacoes/feedback/streak/script.js; dashboard ainda carrega leão, próximo passo, +250 ml e meta de água · **Não verificado:** app não foi executado.

## 2026-11-08 — Histórico do git recuperado
**Pedido:** o projeto tinha perdido o vínculo com o GitHub (o `.git` estava vazio, sem commits).
**Alterado:**
- `.git` — substituído pelo `.git` da cópia "consertando bosta" (com histórico e `origin` = GitHub do João). O vazio foi guardado em `..\..\descartavel\git-vazio-do-projeto-atual`.
- config local do git: `core.longpaths = true` (o caminho da pasta passa de 260 caracteres e o git não conseguia ler 2 arquivos Java).
**Usado:** git.
**Como testar:** `git status` (só deve mostrar alterações reais) e `git log --oneline -3`.
**Verificado:** `git status` limpo além das alterações de hoje; `main` em dia com `origin/main`.
**Pendências / atenção:** encurtar a pasta do projeto (ex.: `ZÉ RICARDO - Pratica\SIMBA`) com o app fechado; a pasta "consertando bosta" em `descartavel` pode ser apagada.

## 2026-11-08 — Organização da pasta da matéria
**Pedido:** deixar na pasta da matéria só a documentação e o projeto atual.
**Alterado (fora do repositório):** criadas `01 - Documentacao\` (Projeto, Disciplina, Protótipos e identidade visual) e `descartavel\` (cópias antigas de código, zips, versões antigas; explicado em `descartavel\LEIA-ME.txt`). Nada foi apagado.
**Usado:** PowerShell (mover arquivos, comparar por hash).
**Como testar:** abrir a pasta `ZÉ RICARDO - Pratica` e conferir as 3 pastas.
**Verificado:** estrutura final listada.

## 2026-11-08 — Skill graphify instalada e grafo gerado
**Pedido:** instalar a skill graphify (github.com/Graphify-Labs/graphify) para usar no projeto.
**Alterado:**
- `.gitignore` — adicionado `graphify-out/`.
- `graphify-out/` — grafo gerado (não vai para o git).
- Fora do projeto: pacote Python `graphifyy`, skill em `~/.claude/skills/graphify`, PATH do usuário com Python 3.13.
**Usado:** Python 3.13, pip, graphify 0.9.104 (`/graphify .`).
**Como testar:** abrir `graphify-out\graph.html` no navegador; perguntar com `/graphify query "..."`.
**Verificado:** grafo com 1.145 nós / 2.762 ligações / 45 comunidades.
**Pendências / atenção:** depois de mudar a pasta de lugar, rodar `/graphify . --force`.
