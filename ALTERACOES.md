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

## 2026-11-23 — Manual do usuário 1.1 + `.gitignore` revisado
**Pedido:** atualizar o manual do usuário em PDF e ver o que precisa ir para o `.gitignore` (arquivos do Claude etc.).
**Alterado:**
- `.gitignore` — novos: `.claude/` e `CLAUDE.local.md` (configurações locais do Claude Code; o `CLAUDE.md` da raiz continua no git de propósito), `node_modules/`, `npm-debug.log*`, `*.log`, `*.tmp`, `.env`, `.env.*`, `Thumbs.db`, `desktop.ini`, `.DS_Store`.
- `src/main/frontend/` — **tirada do git** (`git rm -r --cached`, os arquivos continuam no disco): só tinha `node_modules` (1.114 arquivos, 94 MB) que entrou por engano no commit "implementa notificacao de sono" e não é usado pelo projeto.
- `docs/manual-do-usuario/MANUAL-DO-USUARIO.md` (versão 1.1) — novo 2.2 Página de apresentação; 2.3 Iniciando o sistema com PostgreSQL (criar `config/simba-local.properties` e o banco `simba` na primeira vez) e "os dados ficam guardados" no lugar de "os dados são apagados"; 3.2 limite de 5 senhas erradas; 4.3 alertas no canto inferior; novo 5.5 Alertas de saúde (RF16/RF17, tabela das 3 regras + orientação + aviso preventivo); novo 6.5 alerta de hidratação; 7.4 aviso de sono com a orientação do RF17; novo 8.3 alerta de treino; Dúvidas frequentes: dados guardados, bloqueio de login, alertas. Figuras renumeradas (agora 24).
- `docs/manual-do-usuario/prints/` — novos `22-apresentacao.jpg`, `23-alertas-dashboard.jpg`, `24-alerta-hidratacao.jpg`, `25-aviso-sono.png`.
- `docs/manual-do-usuario/MANUAL-DO-USUARIO.pdf` — gerado de novo (39 páginas, com capa "Versão 1.1").
**Usado:** `git rm --cached`, `git check-ignore`; Python `markdown` + Edge headless (`--print-to-pdf`) para o PDF; PyMuPDF para conferir.
**Como testar:** abrir `docs\manual-do-usuario\MANUAL-DO-USUARIO.pdf` (itens 2.2, 2.3, 5.5, 6.5, 7.4, 8.3 e Dúvidas). No git: `git status` não mostra mais `.claude/` e mostra `src/main/frontend/...` como removidos do repositório.
**Verificado:** texto do PDF conferido (tem "Alertas de saúde", "Página de apresentação", "Muitas tentativas", "não substituem"; o único "são apagados" é o do Excluir conta, que é verdade); página dos alertas renderizada e conferida; `.claude/launch.json` e `node_modules` ignorados (`git check-ignore`). · **Não verificado:** a versão online do manual (Claude Docs) não foi atualizada — o PDF é a versão de entrega.
**Pendências / atenção:** quando fizer o commit, a remoção de `src/main/frontend/` vai junto (os colegas que derem pull ficam sem essa pasta no git, mas ninguém usa). Se quiser liberar 94 MB no disco, pode apagar a pasta `src\main\frontend` depois.

---

## 2026-11-23 — Aviso de sono do Pedro com a orientação do RF17
**Pedido:** colocar no aviso "Atenção com seu sono" (tela de Sono) a orientação de procurar um profissional e o aviso preventivo do RF17.
**Alterado:**
- `static/js/sono.js` (`mostrarAlertaSonoBaixa`) — 2 linhas novas no aviso: "Se isso continuar, vale conversar com um médico ou outro profissional de saúde." e "O SIMBA tem finalidade preventiva e de autocuidado. Estas orientações não substituem a avaliação nem o diagnóstico de um profissional de saúde." (mesmos textos do `AlertaCalculator`). O aviso fica 12 s na tela (antes 6 s), por ter mais texto. A regra de quando aparece não mudou.
- `static/css/sono.css` — estilos `.toast-orientacao` e `.toast-aviso`.
**Como testar:** Sono → registrar noites até a 3ª com nota 1 ou 2 → o aviso aparece no canto com a orientação e o aviso preventivo.
**Verificado:** `node --check js/sono.js`; `sono.html` aberta no Edge com o aviso disparado: os 4 textos aparecem e cabem no cartão. · **Não verificado:** o aviso aparecendo pelo fluxo real de registro com o app rodando.

---

## 2026-11-23 — Tela de Sono: fica só o aviso do Pedro
**Pedido:** na tela de Sono, deixar só o aviso que já existia ("Atenção com seu sono", do Pedro), sem o cartão novo do RF16.
**Alterado:**
- `static/sono.html` — tirados o `css/alertas.css` e o `js/alertas.js`.
- `static/js/alertas.js` — `sono.html` saiu da lista de telas; comentário explica a decisão.
**Continua igual:** a dashboard segue mostrando o alerta de sono do RF16 (com a orientação de procurar um profissional e o aviso preventivo do RF17); Hidratação e Treinos seguem com os seus.
**Como testar:** entrar com o demo → Sono não mostra o cartão no canto inferior direito; ao registrar a 3ª noite com nota 1 ou 2 aparece o aviso do Pedro. Dashboard continua com o cartão de sono.
**Verificado:** `node --check js/alertas.js`; `sono.html` sem referência aos alertas. · **Não verificado:** não subi o app de novo para esta mudança (é só a retirada de 2 linhas e de uma entrada da lista).
**Atenção:** o aviso do Pedro não traz o texto do RF17 (procurar um profissional + "não substitui avaliação"); esse texto aparece só no cartão da dashboard.

---

## 2026-11-23 — RF16 e RF17: alertas preventivos por métrica + orientação de saúde
**Pedido / história:** trazer as novidades do GitHub e implementar o RF16 (avisar quando sono, hidratação ou treinos ficam abaixo do esperado de forma recorrente) e o RF17 (sugerir procurar um profissional e deixar claro que o SIMBA é preventivo e não substitui avaliação nem diagnóstico), usando o `simba-alertas-rf16-rf17.patch` / `.zip` recebidos.
**Alterado:**
- GitHub: trazidos 3 commits novos da `main` (README atualizado com o Checkpoint 02, `docs/diagrama-casos-de-uso.jpg`, `docs/diagrama-classes.jpg` e 3 entradas neste arquivo). O trabalho local foi guardado com `git stash`, o pull foi feito e o trabalho voltou; o único conflito (este `ALTERACOES.md`) foi resolvido mantendo todas as entradas.
- Aplicado o **patch** (o zip não foi usado: ele traz `sono.html`, `hidratacao.html` e `treinos.html` inteiros de 16/11, que apagariam as mudanças feitas depois):
  - `alerta/AlertaCalculator.java` (novo, Java puro) — sono: últimas 4 noites registradas com menos de 7 h ou nota 1–2; água: últimos 3 dias com registro (sem contar hoje) abaixo de 50% da meta; treino: 14 dias sem treino para quem usa o app há 14+ dias. Sono e água só alertam se o problema for recente (até 3 dias). Texto fixo do RF17 em `AVISO`.
  - `alerta/AlertaService.java`, `AlertaController.java` (`GET /api/alertas`, só do usuário logado), `AlertaDTO`, `AlertasResponseDTO`, `TipoAlerta` (novos).
  - `static/js/alertas.js` + `static/css/alertas.css` (novos) — cartão no canto inferior direito com o que foi percebido, a orientação de procurar um profissional, o aviso preventivo e o botão "Entendi" (esconde aquele alerta no resto do dia). Atualiza sozinho depois de registrar algo.
  - `static/sono.html`, `hidratacao.html`, `treinos.html` — incluem o CSS e o JS dos alertas (1 linha cada).
  - `demo/DemoDataSeeder.java` — o demo agora tem as 4 últimas noites ruins e os 3 últimos dias com pouca água, para demonstrar os alertas (`CENARIO_ALERTAS = true`).
  - `test/.../alerta/AlertaCalculatorTest.java` (novo, 22 casos).
- **Ajuste meu:** `static/js/alertas.js` + `static/index.html` — a **dashboard mostra todos os alertas ativos** (o patch só mostrava dentro de cada tela; o RF16 pede para notificar a pessoa).
- `CLAUDE.md` — pacote `alerta` na tabela da §3.
**Usado:** `git fetch`, `git stash`, `git pull --ff-only`, `git apply`; JUnit; PostgreSQL temporário (porta 5433, já apagado) e Edge headless para os prints.
**Como testar:**
1. Como o banco agora guarda tudo, recrie o demo para pegar o cenário novo: no pgAdmin ou `psql`, `DROP DATABASE simba;` e `CREATE DATABASE simba;`.
2. `.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"` → entrar com `demo` / `demo123`.
3. Dashboard: aparecem 2 cartões ("Seu sono precisa de atenção" e "Hidratação abaixo do esperado"), cada um com a orientação de procurar um profissional e o aviso de que o SIMBA não substitui avaliação nem diagnóstico.
4. Sono mostra só o de sono; Hidratação só o de água; Treinos nenhum (o demo treinou recentemente). "Entendi" esconde o alerta no resto do dia.
**Verificado:** `mvnw clean test` completo — **219 testes, 0 falhas** (inclui os 22 novos). App rodado com PostgreSQL e o demo novo: `/api/alertas` devolve SONO e AGUA para o demo, lista vazia para um usuário novo e 403 sem login; dashboard com 2 cartões, Sono com 1, Hidratação com 1, Treinos com 0; "Entendi" some com o alerta. · **Não verificado:** o alerta de treino na tela (o demo não tem 14 dias sem treino; a regra está coberta pelos testes); no seu PostgreSQL da porta 5432.
**Pendências / atenção:** a tela de Sono já tinha o aviso do Pedro ("Atenção com seu sono", depois de 3 notas baixas) — agora os dois podem aparecer juntos. O `git stash` com o trabalho de antes do pull ficou guardado como cópia de segurança (`stash@{0}`); pode apagar com `git stash drop` depois de conferir. O manual do usuário ainda não fala dos alertas.

---

## 2026-11-23 — Segurança + troca do H2 pelo PostgreSQL
**Pedido:** fechar o `/h2-console`, exigir um `JWT_SECRET` próprio, trocar o H2 em memória pelo PostgreSQL instalado no PC, desligar o SQL no log e limitar tentativas de login/cadastro.
**Alterado:**
- `pom.xml` — removido `spring-boot-h2console`; H2 agora só em `test` (o driver do PostgreSQL já existia).
- `src/main/resources/application.properties` — banco PostgreSQL (`DB_URL`, `DB_USER`, `DB_PASSWORD`), console H2 desligado, `show-sql` desligado (liga com `SHOW_SQL=true`), `jwt.secret` sem valor padrão, lê `config/simba-local.properties`.
- `config/simba-local.properties` — **novo, fora do git**: senha do Postgres (falta você preencher) e um `JWT_SECRET` aleatório gerado para esta máquina.
- `config/simba-local.example.properties` — novo: modelo do arquivo acima (vai para o git, sem segredos).
- `.gitignore` — ignora `config/simba-local.properties`.
- `src/test/resources/application.properties` — novo: os testes continuam em H2 em memória, com chave JWT só de teste.
- `security/SecurityConfig.java` — tirado `/h2-console/**` do `permitAll` e a liberação de iframe (que era só para o console).
- `security/JWTService.java` — o app não inicia sem `JWT_SECRET`, com menos de 32 caracteres ou com a chave antiga que estava no GitHub (mensagem explica o que fazer).
- `security/LimiteTentativas.java` — novo (Java puro): conta tentativas por chave numa janela de tempo.
- `security/AuthController.java` — login: 5 senhas erradas em 15 min (usuário + IP) bloqueiam até 15 min; cadastro: 10 contas por hora por IP. Senha errada continua respondendo como antes (500).
- `exceptions/MuitasTentativasException.java` + `infra/RestExceptionHandler.java` — resposta 429 com a mensagem "Tente de novo em X minutos".
- `static/entrar.html`, `static/login.html` — mostram a mensagem do servidor quando der 429.
- `test/.../AuthControllerTest.java` — ajustado para o novo construtor + teste do bloqueio; `test/.../LimiteTentativasTest.java` — novo (8 casos, inclui a validação da chave JWT).
- `CLAUDE.md` — §2 e §6 atualizados (PostgreSQL, arquivo local, limites).
**Usado:** PostgreSQL 18 (instalado no PC), Spring `spring.config.import`, variáveis de ambiente, JUnit/Mockito. Para o teste, um PostgreSQL temporário na porta 5433 (já apagado).
**Como testar:**
1. Abrir `config\simba-local.properties` e trocar `coloque-aqui-a-senha-do-postgres` pela senha do usuário `postgres` (a que você definiu ao instalar).
2. Criar o banco (vai pedir a senha): `& "C:\Program Files\PostgreSQL\18\bin\createdb.exe" -U postgres -h localhost simba`
3. `.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"` → `http://localhost:8080` → entrar com `demo` / `demo123`.
4. Registrar água, parar o app (Ctrl+C), subir de novo: o registro continua lá.
5. Errar a senha 5 vezes: na 6ª aparece "Muitas tentativas de login erradas. Tente de novo em 15 minutos."
6. Abrir `http://localhost:8080/h2-console`: dá acesso negado.
**Verificado:** `mvnw test` completo: 197 testes, 0 falhas. App rodado num PostgreSQL 18 de verdade (porta 5433): demo carregado, todas as rotas principais respondendo 200, cadastro/login/registro de água ok, 6ª senha errada → 429, `/h2-console` → 403, e depois de reiniciar o app os dados continuaram lá. · **Não verificado:** no seu PostgreSQL da porta 5432 (precisa da sua senha); a tela de login mostrando o aviso de 429 no navegador (testado só pela API).
**Pendências / atenção:** o manual do usuário (item 2.2 e Dúvidas) ainda diz que os dados somem ao reiniciar — precisa atualizar. Cada colega precisa criar o próprio `config/simba-local.properties` a partir do modelo.

---

## 2026-11-22 — Página de apresentação: celular tirado do topo
**Pedido:** tirar o celular da primeira tela da apresentação.
**Alterado:**
- `static/inicio.html` — o celular com a dashboard saiu do topo; os avisos do app ("Ofensiva garantida hoje", "+250 ml registrado"…) continuam aparecendo um de cada vez, agora à direita, sobre o céu da savana (no celular, logo abaixo dos botões).
- `static/css/inicio.css` — regras do celular do topo trocadas por `.hero-lado`; a seção "O problema" voltou ao espaçamento normal (não precisa mais da folga para o celular invadindo).
**Como testar:** subir o app → `http://localhost:8080` → o topo mostra só o texto, a savana e os avisos trocando.
**Verificado:** capturas em 1440×860 e 390×844 de todas as seções; sem erros no console. · **Não verificado:** celular de verdade.

---

## 2026-11-22 — Página de apresentação: meio-termo entre as duas versões + animações criativas
**Pedido:** a passada "unslop" piorou a página. Desinstalar a skill unslop e fazer um meio-termo entre a versão nova e a antiga, com as animações criativas de volta.
**Alterado:**
- Skill `unslop` removida de `C:\Users\rubens\.claude\skills\unslop` (fora do projeto).
- `static/inicio.html` — base da versão nova (foto da savana do app no topo, celular real subindo da borda, ferramentas, "um dia no SIMBA", cartão da ofensiva, conquistas) com a personalidade da antiga: "num lugar só." em laranja itálico (sem o traço desenhado), os apps espalhados voltando a entrar no celular, o sol andando no céu ao rolar e a noite com estrelas, lua e o leão rei.
- `static/css/inicio.css` — reescrito no meio-termo: títulos em peso 600, botões laranja com leve sombra e "subida" no hover, ferramentas em cartões com ícone colorido, janelas e celulares com moldura.
- `static/js/inicio.js` — animações: avisos iguais aos do app saindo do celular um de cada vez (+250 ml, ofensiva garantida, conquista, lembrete), foto do topo se aproximando devagar, celular subindo ao abrir, revelar ao rolar em sequência, apps espalhados entrando no celular, sol → lua no arco ao rolar, contador da ofensiva 0 → 27 com o leão mudando de cara (pula a cada fase, destaca a fase atual e acende as pegadas; clicar no leão conta de novo), topo que ganha fundo ao rolar. Com "reduzir movimento" ligado, tudo aparece parado.
**Ficaram de fora (o que você não gostou):** árvore/morros desenhados em SVG, traço embaixo de "num lugar só", leão com ícones girando em volta.
**Usado:** HTML/CSS/JS puros, `IntersectionObserver`, `requestAnimationFrame`, leão SVG do `js/streak.js`. Capturas conferidas com Edge headless.
**Como testar:** subir o app → `http://localhost:8080` → esperar alguns segundos no topo (os avisos trocam) e rolar a página devagar; testar também no modo celular (F12).
**Verificado:** app rodando; capturas em 1440×860 e 390×844 de todas as seções (antes/depois das animações); sem erros no console. · **Não verificado:** celular de verdade; navegadores além do Edge/Chromium.

---

## 2026-11-22 — Página de apresentação: passada "unslop" (tira a cara de gerada)
**Pedido:** a árvore desenhada, o grifo em "num lugar só" e o leão com ícones girando ficaram com cara de "slop". Aplicar a correção na página inteira.
**Direção (aprovada):** caloroso, constante, encorajador; o mundo é a **foto da savana que o app já usa**; dois momentos ricos — a savana com o app subindo no topo e o leão da ofensiva —; assinatura: a pegada = dia com registro.
**Alterado:**
- `static/inicio.html` — mesmas seções, na mesma ordem. Topo: foto da savana em tela cheia, título sem grifo nem itálico, um botão principal e um secundário, e o celular com a dashboard real subindo e passando da borda. "O problema" virou uma tabela simples "Hoje você usa → No SIMBA" (5 lugares → 1 tela) no lugar dos cartões voando. Ferramentas em lista com ícones discretos + a dashboard numa janela reta. "Um dia no SIMBA" com régua de horários (sem sol andando). Ofensiva: o leão do app num cartão com o número de dias, as pegadas dos últimos 7 dias e as fases. Conquistas numa janela reta (sem pilha inclinada). Final em fundo terra, sem estrelas/lua.
- `static/css/inicio.css` — reescrito: rampa neutra de areia, um laranja de destaque (escurecido para o texto branco passar de 4,5:1), títulos em peso 500, botões de 48 px sem sombra 3D, espaçamento na grade de 4 px, raios encaixados, uma só animação de entrada no topo; tudo desliga com "reduzir movimento".
- `static/js/inicio.js` — reescrito: só o "Abrir o SIMBA" para quem já entrou e o número da ofensiva que sobe uma vez (0 → 27) com o leão mudando nas mesmas faixas do app.
- `static/img/inicio/comparativo.jpg` — removido (não é mais usado).
**Saiu:** árvore e morros em SVG, grifo, itálico, órbita de ícones, sol pulsando, leão flutuando, balão trocando, sol andando ao rolar, cartões voando, estrelas piscando, revelar em toda seção, pilha inclinada, botão 3D.
**Usado:** método/skill "unslop" (Damir Sokolovsky, CC BY 4.0); a foto da savana do Unsplash que o app já usava.
**Como testar:** subir o app → `http://localhost:8080` → rolar a página; testar também em F12 → modo celular.
**Verificado:** app rodando, 1440 px e 375 px, sem rolagem lateral, imagens carregando, sem erros no console. · **Não verificado:** celular de verdade; navegadores além do Edge/Chromium. A foto vem da internet (Unsplash): sem internet o topo fica só na cor de areia.

---

## 2026-11-22 — Página de apresentação refeita: "um dia na savana", com animações e prints do celular
**Pedido:** a primeira versão ficou parecida demais com a do Ziggur e os prints ficaram "soltos". Fazer algo com a cara do SIMBA, com prints do celular e animações criativas, mostrando o objetivo do app: **unir várias ferramentas para ajudar a pessoa a manter o foco numa vida mais saudável**.
**Alterado:**
- `static/inicio.html` — reescrita. A página segue um dia na savana (amanhecer → noite):
  1. Topo: "Tudo que cuida de você, num lugar só." (grifo desenhado na hora) + o leão Simba no centro de um sol, com as 8 ferramentas girando em volta; o leão troca de expressão e fala num balão.
  2. "O problema": cartões de "app de água", "planilha de treino", "despertador"… espalhados que voam para dentro de um celular com o SIMBA quando a seção aparece.
  3. "8 ferramentas, 1 objetivo": lista das ferramentas + os cartões reais da dashboard.
  4. "Um dia no SIMBA": 5 prints do celular (07:00 → 22:00); um sol anda num arco conforme a pessoa rola e vira lua no fim.
  5. "Todo leão começa pequeno": contador de 0 a 30 dias em que o leão muda de cara (início → feliz → animado → rei) e pegadas se acendem; clicar no leão conta de novo. Abaixo, o quadro real da ofensiva.
  6. "Motivo para voltar amanhã": conquistas, metas e comparativo reais em "pilha".
  7. Noite com estrelas piscando, lua e o leão rei: convite final.
- `static/css/inicio.css` — reescrito (céu muda de cor por seção, celulares desenhados em CSS, animações; tudo desliga com "reduzir movimento" do sistema).
- `static/js/inicio.js` — novo: animações (balão do leão, revelar ao rolar, apps entrando no celular, sol no arco, contador da ofensiva) e o "Abrir o SIMBA" para quem já entrou.
- `static/img/inicio/` — trocados os prints: 5 telas de celular (390×844, 3x) e 6 recortes em alta resolução (2x) de partes da dashboard, ofensiva, metas, conquistas e comparativo. Total ≈ 490 KB.
**Usado:** HTML/CSS/JS puros, `IntersectionObserver`, o leão SVG do `js/streak.js` (`window.SimbaLeao`), Edge headless (DevTools Protocol) para os prints, Pillow para recortar/comprimir. Os prints usam a conta `demo` (com 1,75 L de água registrada no dia para o leão aparecer feliz).
**Como testar:** subir o app → `http://localhost:8080` → rolar a página toda devagar; testar também com F12 → modo celular.
**Verificado:** app rodando; todas as seções aparecem e animam em 1366 px e 375 px; sem rolagem lateral no celular; sem erros no console. · **Não verificado:** navegadores além do Edge/Chromium; celular de verdade.

---

## 2026-11-22 — Página de apresentação + ordem das páginas (login obrigatório)
**Pedido:** ao abrir `localhost:8080` o app ia direto para o sistema sem login. Agora abre uma página de apresentação (inspirada na do Ziggur, mais simples) com Entrar / Criar conta, e as telas internas exigem login.
**Alterado:**
- `static/inicio.html` + `static/css/inicio.css` — novos: página de apresentação (topo com Entrar/Criar conta, chamada "Cuide de você. Todo dia.", print da dashboard, faixa com as funções, 5 seções com prints — Registros, Ofensiva, Rotinas, Progresso, Conquistas e metas —, convite final e rodapé simples). Quem já entrou vê "Abrir o SIMBA".
- `static/img/inicio/*.jpg` — 6 prints recortados e comprimidos (≈ 60 KB cada) para a página.
- `java/.../config/PaginasConfig.java` — novo: `/` agora mostra `inicio.html` (antes mostrava a dashboard).
- `java/.../security/SecurityConfig.java` — `/inicio.html` liberada no `permitAll`.
- `static/js/protecao.js` — novo: sem token (ou com token vencido) manda para `entrar.html`; o link "Sair" passa a apagar o token em todas as telas (antes algumas telas não apagavam).
- `static/index.html`, `hidratacao.html`, `sono.html`, `treinos.html`, `sintomas.html`, `rotinas.html`, `lembretes.html`, `progresso.html`, `conquistas.html`, `perfil.html` — 1 linha no `<head>`: `<script src="js/protecao.js"></script>`.
- `static/js/tutorial.js` — não abre sozinho em navegador de teste automático (`navigator.webdriver`), para não atrapalhar o teste Selenium `DemoFluxoE2ETest`.
**Usado:** `WebMvcConfigurer.addViewControllers` (Spring MVC), Google Fonts (Fraunces para os títulos), Pillow (Python) para recortar os prints. Nenhuma tabela ou dependência nova.
**Como testar:**
1. `.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"` → abrir `http://localhost:8080` → aparece a apresentação.
2. Sem entrar, abrir `http://localhost:8080/index.html` → vai para a tela Entrar.
3. Entrar com `demo` / `demo123` → dashboard. Clicar em Sair → volta ao Entrar; abrir `/index.html` de novo → pede login.
**Verificado:** app rodando; `/` abre a apresentação (1366 px e 375 px, sem rolagem lateral); as 10 telas internas redirecionam para o Entrar sem login; login pelo formulário abre a dashboard; Sair apaga o token; "Abrir o SIMBA" aparece para quem já entrou; `AuthUserIntegrationTest` passou (3/3). · **Não verificado:** a suíte inteira de testes (`mvnw test`) e o teste Selenium.
**Pendências / atenção:** a proteção das telas é no navegador; os dados já eram protegidos no servidor pelo JWT. O manual do usuário ainda não mostra a página de apresentação.

---

## 2026-11-22 — Manual do Usuário atualizado (tutorial + prints sem rodapé)
**Pedido:** atualizar o manual depois do tutorial de primeiro uso e da retirada do rodapé.
**Alterado:**
- `docs/manual-do-usuario/MANUAL-DO-USUARIO.md` — novo item 3.3 "Tutorial de primeiro uso" (passos e botões), "Sair" virou 3.4; novo 13.4 "Rever tutorial", "Excluir minha conta" virou 13.5; 2 perguntas novas nas dúvidas frequentes; figuras renumeradas (agora 20).
- `docs/manual-do-usuario/prints/` — todos os prints refeitos sem o rodapé; novos `20-tutorial-inicio.png` e `21-tutorial-destaque.png`; o print do perfil já mostra "Rever tutorial".
- `docs/manual-do-usuario/MANUAL-DO-USUARIO.pdf` — gerado de novo (35 páginas, com capa).
- Versão online (Claude Docs) — mesmo texto novo e prints trocados nas telas que tinham rodapé.
**Usado:** o mesmo processo da entrega do manual (Edge headless para prints e PDF, Python `markdown`).
**Como testar:** abrir o PDF: item 3.3 com as 2 figuras do tutorial, item 13.4, e nenhuma tela com "CTO - Mufasa Softwares".
**Verificado:** busca no texto do PDF sem o rodapé antigo; 22 imagens no PDF; capa sozinha na página 1. · **Não verificado:** na versão online a numeração das figuras não foi refeita (o PDF é a versão de entrega).

---

## 2026-11-22 — Rodapé "CTO - Mufasa Softwares© 2026" removido
**Pedido:** tirar a marca d'água do rodapé de todas as telas.
**Alterado:**
- `static/index.html`, `hidratacao.html`, `sono.html`, `treinos.html`, `rotinas.html`, `lembretes.html`, `progresso.html`, `conquistas.html`, `perfil.html` — removido o bloco `<footer>` com o texto. Nada mais mudou nessas telas (`entrar`, `login` e `sintomas` não tinham o rodapé).
**Usado:** script Python temporário que apaga só os `<footer>` com esse texto (mantém o fim de linha dos arquivos).
**Como testar:** subir o app, abrir cada tela do menu e rolar até o fim: o texto não aparece mais.
**Verificado:** busca no código sem nenhuma ocorrência; as 10 telas servidas pelo app sem o texto; tela Lembretes conferida no navegador. · **Não verificado:** a regra `footer` do CSS continua nos arquivos `.css` (sem efeito, não há mais `<footer>`).
**Pendências / atenção:** os prints do manual do usuário ainda mostram o rodapé antigo em algumas telas.

---

## 2026-11-22 — Tutorial de primeiro uso (o Simba guia o usuário)
**Pedido / história:** "Como usuário novo, quero ser guiado no primeiro acesso para entender o app e já começar minha ofensiva" (estilo Duolingo). Ajuda a manter o hábito: o tutorial termina convidando a fazer o primeiro registro.
**Alterado:**
- `static/js/tutorial.js` — novo: 9 passos na dashboard (boas-vindas, ofensiva, próximo passo, +250 ml, menu de registros, rotinas/lembretes, progresso/conquistas, perfil, final). Escurece a tela e destaca cada parte; botões Voltar / Próximo / Pular / X; teclado (setas e Esc); no celular abre o menu lateral sozinho e põe o cartão embaixo. O passo final tem "Beber 250 ml agora", que usa o mesmo botão "+ 250 ml" da dashboard. Abre sozinho só na primeira vez (por usuário, neste navegador: `localStorage` `simba.tutorial.<username>`); `index.html?tutorial=1` força abrir.
- `static/css/tutorial.css` — novo: visual do destaque e do cartão, com as variáveis de `style.css`.
- `static/js/streak.js` — 1 linha: expõe `window.SimbaLeao` para o tutorial usar o mesmo leão em SVG.
- `static/index.html` — inclui `css/tutorial.css` e `js/tutorial.js`.
- `static/perfil.html` — novo item "Rever tutorial" em Configurações (volta à dashboard com o tutorial aberto) + inclui `js/tutorial.js`.
**Usado:** JS e CSS puros (sem biblioteca), `localStorage` com `try/catch`, Font Awesome que já existia. Nenhuma rota, tabela ou dependência nova.
**Como testar:**
1. `.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"` → `http://localhost:8080/entrar.html` → `demo` / `demo123` (ou crie uma conta nova).
2. A dashboard abre com o Simba: "Oi! Eu sou o Simba". Clique em Vamos lá / Próximo até o fim e, no último passo, em "Beber 250 ml agora": a água entra e aparecem os avisos de ofensiva.
3. Recarregue a página (F5): o tutorial **não** abre de novo.
4. Meu perfil → "Rever tutorial": volta à dashboard com o tutorial aberto.
5. No celular (ou F12 → modo celular), os passos do menu abrem o menu lateral.
**Verificado:** rodei o app (perfil demo) e passei pelos 9 passos em 1366×820 e em 375×812; "Beber 250 ml agora" registrou a água (ofensiva 26 → 27); não reabre ao recarregar; "Rever tutorial" funciona; `node --check` ok; sem erros do tutorial no console. · **Não verificado:** celular de verdade (só emulado); navegadores além do Edge/Chromium.
**Pendências / atenção:** o "já visto" fica no navegador, então em outro computador o tutorial aparece de novo (é o comportamento mais simples; dá para guardar no banco depois). O manual do usuário ainda não cita o tutorial nem o item "Rever tutorial".

---

## 2026-11-22 — Manual do Usuário (fase de implantação)
**Pedido / história:** entrega da atividade de implantação: manual do usuário no estilo do manual do SEI, adaptado ao SIMBA, com prints das telas, em `.md` e `.pdf`.
**Alterado:**
- `docs/manual-do-usuario/MANUAL-DO-USUARIO.md` — novo: manual em 14 capítulos (visão geral, acesso, primeiro acesso, menu, Dashboard, Hidratação, Sono, Treinos, Rotinas/Lembretes, Sinais Corporais, Progresso, Conquistas/metas, Perfil, dúvidas frequentes) com 18 figuras.
- `docs/manual-do-usuario/MANUAL-DO-USUARIO.pdf` — novo: o mesmo conteúdo em PDF A4 (32 páginas, com capa).
- `docs/manual-do-usuario/prints/*.png` — novo: 18 prints das telas, feitos com a conta `demo`.
- `docs/manual-do-usuario/img/` — cópia do leão e do nome do SIMBA (`static/img`), usados na capa. A capa traz UEG, curso, disciplina, título, versão, equipe e data.
- Nenhum código do sistema foi alterado.
**Usado:** app rodando com o perfil `demo`; Microsoft Edge em modo headless (prints via DevTools Protocol e `--print-to-pdf`); Python `markdown` para gerar o HTML do PDF. Também existe uma versão online editável (Claude Docs) com o mesmo texto e os prints.
**Como testar:**
1. Abrir `docs\manual-do-usuario\MANUAL-DO-USUARIO.pdf` e conferir as páginas e figuras.
2. Seguir algum passo a passo do manual no app (`.\mvnw clean spring-boot:run "-Dspring-boot.run.profiles=demo"`, entrar com `demo` / `demo123`).
**Verificado:** os textos foram tirados do código atual da `main` e conferidos com os prints de cada tela; o PDF foi gerado com as 18 imagens. · **Não verificado:** os passos não foram clicados um a um (criar conta, salvar registros, excluir conta); a tela no celular não foi fotografada.
**Pendências / atenção:** os prints mostram dados da conta demo (datas de novembro/2026). Se o visual mudar, refazer os prints. Próximo passo pedido: tutorial guiado de primeiro uso.

---

## 2026-11-22 — Substituição dos diagramas Mermaid pelas imagens oficiais em `docs/`
**Pedido / história:** substituir os diagramas de Casos de Uso e de Classes em Mermaid no `README.md` pelas duas imagens oficiais enviadas (incluindo o ator em boneco palito).
**Alterado:**
- `docs/diagrama-casos-de-uso.jpg` — adicionada a imagem oficial do Diagrama de Casos de Uso.
- `docs/diagrama-classes.jpg` — adicionada a imagem oficial do Diagrama de Classes (análise).
- `README.md` — substituídos os blocos Mermaid da Seção 5 pelas referências às imagens `docs/diagrama-casos-de-uso.jpg` e `docs/diagrama-classes.jpg`.
- `ALTERACOES.md` — registrada a entrega no topo.
**Usado:** PowerShell (`Copy-Item`), Markdown.
**Como testar:**
1. Abrir `README.md` no preview Markdown do VS Code ou após `git push` no GitHub e conferir a exibição das duas imagens na Seção 5.
**Verificado:** existência e tamanho dos arquivos em `docs/` e `git status --short` · **Não verificado:** exibição na interface web do GitHub antes do push.
**Pendências / atenção:** lembrar de incluir a pasta `docs/` no próximo `git add` / `git commit`.

## 2026-11-22 — Correção dos diagramas UML de Casos de Uso e de Classes no README.md
**Pedido / história:** corrigir os diagramas de Casos de Uso e de Classes no `README.md` para condizerem fielmente com a sintaxe UML e com os diagramas oficiais da documentação.
**Alterado:**
- `README.md` — atualizado o Diagrama de Casos de Uso (`flowchart LR` com 1 ator `Usuário`, associações sem seta `---`, fronteira `SIMBA`, os 14 casos principais, os 4 complementares, nota sobre `«include» Autenticar-se` e setas `«include»`/`«extend»` corretas) e o Diagrama de Classes (`classDiagram` em `direction LR` com as 14 classes de análise, visibilidade `-`/`+`, multiplicidades `1`, `0..1`, `0..*`, composição `*--`, estereótipos `«enumeration»`/`«catálogo»`/`«calculado»` e dependências tracejadas `..>`).
**Usado:** inspeção visual das imagens oficiais dos diagramas UML do Checkpoint 02 e sintaxe Mermaid (`flowchart` e `classDiagram`).
**Como testar:**
1. Abrir `README.md` no preview Markdown do VS Code ou no GitHub e conferir a renderização dos dois diagramas na Seção 5 (*Modelagem do Sistema*).
**Verificado:** conferência elemento a elemento contra os diagramas enviados e sintaxe Mermaid · **Não verificado:** renderização visual no navegador do GitHub.
**Pendências / atenção:** nenhuma.

## 2026-11-22 — Atualização completa do README.md com a documentação do Checkpoint 02
**Pedido / história:** atualizar o `README.md` do projeto para condizer totalmente com a documentação final enviada (Checkpoint 02) e com o código atual do repositório.
**Alterado:**
- `README.md` — atualizado com identificação da disciplina/UEG/Mufasa Softwares, Documento de Visão v1.1, usuários e escopo real (entregue × fora do escopo), checklist completo de 28/28 requisitos (RF01–RF17 e RNF01–RNF11), papéis SCRUM e 20 Histórias de Usuário, leitura do Modelo Conceitual (BRModelo), diagramas UML de Casos de Uso e de Classes atualizados em Mermaid, arquitetura/tecnologias/pacotes/telas/endpoints REST, regras de negócio, instruções de execução (normal e perfil `demo`), resultados de testes (`188` testes / `55` classes), riscos/validação/resumo de entregas e histórico de contribuições das Sprints 1 a 7.
**Usado:** leitura direta da documentação enviada e inspeção de `pom.xml`, modelos JPA, controllers, calculators, `SecurityConfig`, `DemoDataSeeder`, `EXECUCAO-TESTES.md` e telas estáticas.
**Como testar:**
1. Abrir `README.md` na visualização Markdown (VS Code ou GitHub) e conferir que todas as seções, tabelas e diagramas Mermaid renderizam corretamente.
**Verificado:** revisão integral do `README.md` contra o código-fonte do repositório e a documentação enviada · **Não verificado:** renderização visual dos diagramas Mermaid diretamente no navegador do GitHub.
**Pendências / atenção:** nenhuma pendência de arquivo; caso novas entidades sejam adicionadas após o Checkpoint 02, atualizar o diagrama de classes no `README.md`.

---

## 2026-11-16 — Execução completa dos testes e exportação da saída do terminal para Markdown

### O que foi alterado
- Criado o arquivo [`EXECUCAO-TESTES.md`](EXECUCAO-TESTES.md) na raiz do repositório com o resumo das 55 classes de teste e a saída integral do terminal gerada por `.\mvnw.cmd test` (`188` testes passando).
- `src/main/resources/static/js/progresso.js`: adicionada verificação `typeof Chart === "undefined"` nas funções `criarGraficoSono` e `criarGraficoHidratacao` para que indisponibilidade ou atraso do script externo `Chart.js` não interrompa o preenchimento dos cards de resumo e do heatmap de treinos.
- `src/test/java/br/simba/bem_estar/e2e/ConquistasProgressoE2ETest.java`: aguardado o carregamento inicial de `#mediaHidratacaoResumo` antes de alternar o filtro para `7 dias`.

### Por que
Atender à solicitação de executar toda a suíte e exportar o log completo do terminal em Markdown, além de eliminar uma falha intermitente na tela de progresso quando o script externo do Chart.js não estava disponível no momento da renderização.

### O que foi usado
- Maven Wrapper (`.\mvnw.cmd test`) com JUnit 5, MockMvc e Selenium WebDriver (`EdgeDriver`).
- `node --check src/main/resources/static/js/progresso.js`.

### Como testar
```powershell
.\mvnw.cmd test
```
Consulte o log completo exportado em [`EXECUCAO-TESTES.md`](EXECUCAO-TESTES.md).

### Verificado × não verificado
- **Verificado:** `node --check src/main/resources/static/js/progresso.js` e `.\mvnw.cmd test` (fora do sandbox restrito para permitir loopback do Tomcat/WebDriver): `Tests run: 188, Failures: 0, Errors: 0, Skipped: 0` (`BUILD SUCCESS` em `02:22 min`, após a alteração final de código e teste).
- **Não verificado:** nada pendente para esta entrega.

---

## 2026-11-16 — Implementação de Selenium WebDriver e testes Ponta a Ponta (E2E) das interfaces web

### O que foi alterado
- `pom.xml`: adicionada a dependência `org.seleniumhq.selenium:selenium-java` em escopo `test` (versão gerenciada `4.43.0` pelo BOM do Spring Boot).
- Criada a base `src/test/java/br/simba/bem_estar/e2e/BaseE2ETest.java`: sobe a aplicação completa em porta aleatória (`@SpringBootTest(webEnvironment = RANDOM_PORT)`), inicializa o Microsoft Edge headless (`--headless=new` com `PageLoadStrategy.EAGER` e descoberta automática de `msedge.exe`), limpa armazenamento do navegador e banco H2 antes de cada teste e centraliza utilitários de espera, interação e autenticação pela interface.
- Criadas 5 classes de testes Ponta a Ponta cobrindo as 12 páginas HTML em `src/main/resources/static/`:
  - `AuthPerfilE2ETest.java` (`2` testes): validação de senhas divergentes em `login.html`, fluxo completo em `entrar.html`, `index.html` e `perfil.html` (edição de dados pessoais, modal de peso/altura com prévia de IMC e criação de meta sugerida, alteração de senha e logout com novo login).
  - `DashboardHidratacaoSonoTreinoE2ETest.java` (`4` testes): registro rápido `+250 ml` no dashboard com atualização de resumo/streak (`index.html`); adição rápida, criação, edição, exclusão e configuração/restauração de meta em `hidratacao.html`; planejador de ciclos e CRUD completo em `sono.html`; CRUD completo de atividade física em `treinos.html`.
  - `SintomasRotinasLembretesE2ETest.java` (`3` testes): check-in diário, seleção de dor/locais, sintomas, histórico e edição em `sintomas.html`; criação de rotina, lembrete recorrente por dia da semana, alternância de status e exclusões em `rotinas.html`; criação, atualização do sininho do cabeçalho e exclusão em `lembretes.html`.
  - `ConquistasProgressoE2ETest.java` (`2` testes): desbloqueio de conquistas, filtros e criação/remoção de metas em `conquistas.html`; resumo, comparativo semanal, troca de período e heatmap em `progresso.html`.
  - `DemoFluxoE2ETest.java` (`1` teste): fluxo completo autenticado como `demo / demo123` (`@ActiveProfiles("demo")` em banco H2 dedicado) percorrendo dashboard, conquistas, progresso, rotinas, sinais corporais e registro rápido de água.

### Por que
Para validar o funcionamento integrado entre telas HTML/JS/CSS, controle de sessão (`sessionStorage`), endpoints REST, regras de negócio e persistência no fluxo real do usuário no navegador.

### O que foi usado
- **Selenium WebDriver** (`org.seleniumhq.selenium:selenium-java` `4.43.0`) com `EdgeDriver` e Selenium Manager (driver cacheado localmente).
- **Microsoft Edge** instalado na máquina em modo headless (`--headless=new`).
- **Spring Boot Test** (`@SpringBootTest(webEnvironment = RANDOM_PORT)`) + **H2 em memória**.

### Como testar
- Todos os testes Ponta a Ponta:
  ```powershell
  .\mvnw.cmd test "-Dtest=*E2ETest"
  ```
- Suíte completa (unidade + integração + E2E):
  ```powershell
  .\mvnw.cmd test
  ```
  *(Em ambiente com sandbox de rede/loopback restrito, executar com permissão de socket local/rede para inicialização do Tomcat em porta aleatória e comunicação com o WebDriver.)*

### Verificado × não verificado
- **Verificado:** execução completa da suíte (testes de unidade, integração e os 12 testes E2E em navegador real).
- **Não verificado:** exclusão definitiva de conta no modal `#modalExcluirConta` (restringida ao nível de UI neste momento para priorizar o fluxo principal de edição, medidas e troca de senha) e execução nos navegadores Chrome/Firefox (ausentes no ambiente).

---

## 2026-11-16 — Suíte de testes de integração das funcionalidades
**Pedido / história:** escrever testes de integração para todas as funcionalidades da aplicação.
**Alterado:**
- `src/test/java/br/simba/bem_estar/BaseIntegrationTest.java` — base com `@SpringBootTest`, `@AutoConfigureMockMvc`, limpeza do H2 em ordem segura antes de cada teste e utilitários de cadastro/login JWT.
- `src/test/java/br/simba/bem_estar/security/AuthUserIntegrationTest.java` — 3 testes ponta a ponta cobrindo rotas públicas/protegidas, registro com BCrypt, login JWT, atualização de usuário com novo token, troca de senha e exclusão completa da conta em cascata.
- `src/test/java/br/simba/bem_estar/perfil/PerfilMedidasIntegrationTest.java` — 2 testes cobrindo medidas iniciais, prévia de IMC/sugestões sem gravar, persistência de peso/altura e reflexo automático na meta de água sugerida.
- `src/test/java/br/simba/bem_estar/progresso/RegistrosMonitoramentoIntegrationTest.java` — 1 teste cobrindo CRUD de hidratação, sono e treinos, bloqueio anti-IDOR entre usuários (403) e consolidação no `/progresso`.
- `src/test/java/br/simba/bem_estar/rotina/RotinaLembreteIntegrationTest.java` — 2 testes cobrindo rotinas com lembretes recorrentes (ordenação, deduplicação de dias, exclusão em cascata), lembretes avulsos e isolamento entre usuários.
- `src/test/java/br/simba/bem_estar/sintoma/SintomasIntegrationTest.java` — 1 teste cobrindo questionário diário (criação, atualização no mesmo dia sem duplicar, validações 422), status de hoje e resumo semanal do histórico.
- `src/test/java/br/simba/bem_estar/conquista/GamificacaoDashboardIntegrationTest.java` — 1 teste de integração cruzada cobrindo meta de água personalizada, metas, registros, rotina, streak, conquistas (desbloqueio + `nova`), comparativo semanal e próximo passo.
- `src/test/java/br/simba/bem_estar/demo/DemoDataSeederIntegrationTest.java` — 1 teste com `@ActiveProfiles("demo")` validando o seeding automático e a leitura de todas as telas com o usuário `demo`.
**Usado:** `@SpringBootTest`, `@AutoConfigureMockMvc`, `MockMvc`, H2 em memória, Spring Security + JWT, Jackson 3 (`tools.jackson.databind.ObjectMapper`), Maven (`.\mvnw.cmd test`).
**Como testar:**
1. Para rodar apenas os testes de integração: `.\mvnw.cmd test "-Dtest=*IntegrationTest"`.
2. Para rodar toda a suíte (unidade + integração): `.\mvnw.cmd test`.
3. Confira `Tests run: 176, Failures: 0, Errors: 0, Skipped: 0` e `BUILD SUCCESS`.
**Verificado:** testes de integração (`.\mvnw.cmd test -o "-Dtest=*IntegrationTest"`, 11/11 OK) e suíte completa (`.\mvnw.cmd test -o`, `Tests run: 176, Failures: 0, Errors: 0, Skipped: 0`). **Não verificado:** testes de interface no navegador (frontend).
**Pendências / atenção:** durante os testes foram observados três comportamentos já existentes na aplicação (não alterados): `POST /auth/login` com senha incorreta retorna HTTP 500 porque `RestExceptionHandler` captura `BadCredentialsException` como `RuntimeException`; `PUT /perfil/me` serializa relação bidirecional `PerfilModel <-> UserModel` (a tela atual usa `/perfil/me/medidas`); e `UserAccountService.excluirConta` ainda não exclui registros de `tb_registro_sintoma`.

## 2026-11-16 — JUnit configurado e suíte de testes de unidade para todo o projeto
**Pedido / história:** implementar o JUnit no projeto e escrever testes de unidade para as funcionalidades da aplicação.
**Alterado:**
- `pom.xml` — adicionadas explicitamente as dependências `spring-boot-starter-test` e `junit-jupiter` em escopo `test`.
- `src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker` e `org.mockito.plugins.MemberAccessor` — configurados `mock-maker-subclass` e `member-accessor-reflection` para o Mockito rodar sem attach dinâmico do agente no Java 21 (evita bloqueio/aviso em ambientes Windows com caminho acentuado).
- `src/test/java/br/simba/bem_estar/historico/` (`HistoricoCalculosTest`, `HistoricoServiceTest`) — 9 testes cobrindo agregação diária de água, metas, sono, boa noite, sequências e carregamento via repositórios.
- `src/test/java/br/simba/bem_estar/streak/` (`StreakCalculatorTest`, `StreakControllerTest`, `StreakServiceTest`) — 14 testes cobrindo ofensiva, janela semanal de 7 dias, tolerância de 2 faltas, risco/última chance, quebra e marcação dos registros de hoje.
- `src/test/java/br/simba/bem_estar/conquista/` (`ConquistaCalculatorTest`, `ConquistaServiceTest`, `ConquistaControllerTest`) — 8 testes cobrindo as 26 conquistas, meta personalizada de água, persistência sem duplicação e preservação de conquistas já desbloqueadas.
- `src/test/java/br/simba/bem_estar/meta/` (`MetaAguaCalculatorTest`, `MetaAguaServiceTest`, `MetaCalculatorTest`, `MetaServiceTest`, `MetaControllerTest`) — 20 testes cobrindo cálculo/limites de meta de água, criação/listagem/conclusão/exclusão de metas, limite de 5 ativas e duplicidade.
- `src/test/java/br/simba/bem_estar/comparativo/` (`ComparativoCalculatorTest`, `ComparativoServiceTest`, `ComparativoControllerTest`) — 6 testes cobrindo comparação entre últimos 7 dias e 7 anteriores e tendências (`subiu`, `caiu`, `igual`, `novo`, `sem`).
- `src/test/java/br/simba/bem_estar/proximopasso/` (`ProximoPassoCalculatorTest`, `ProximoPassoServiceTest`, `ProximoPassoControllerTest`) — 10 testes cobrindo prioridade de recomendações, formatação e consulta sem gravação.
- `src/test/java/br/simba/bem_estar/progresso/` (`ProgressoServiceTest`, `ProgressoControllerTest`) — 4 testes cobrindo séries contínuas de sono, água e treinos e validação de intervalo de datas.
- `src/test/java/br/simba/bem_estar/perfil/` (`PerfilServiceTest`, `PerfilControllerTest`) — 8 testes cobrindo CRUD de perfil, busca/salvamento de medidas, IMC e prévia sem salvar.
- `src/test/java/br/simba/bem_estar/rotina/` (`RotinaServiceTest`, `RotinaControllerTest`) — 9 testes cobrindo CRUD de rotinas, ordenação/validação de lembretes recorrentes e status HTTP.
- `src/test/java/br/simba/bem_estar/sintoma/` (`RegistroSintomaServiceTest`, `RegistroSintomaControllerTest`) — 7 testes cobrindo resposta diária (criar/atualizar), status de hoje e histórico de 30 dias.
- `src/test/java/br/simba/bem_estar/lembrete/LembreteControllerTest.java`, `registroAgua/RegistroAguaControllerTest.java`, `registroSono/RegistroSonoControllerTest.java`, `registroExercicio/RegistroExercicioControllerTest.java` — 11 testes cobrindo CRUD, validações e proteção contra acesso de outro usuário (`AcessoNegadoException`).
- `src/test/java/br/simba/bem_estar/security/` (`JWTServiceTest`, `JwtAuthenticationFilterTest`, `AuthControllerTest`) — 10 testes cobrindo geração/validação/expiração/adulteração de JWT, filtro de autenticação e registro/login.
- `src/test/java/br/simba/bem_estar/user/` (`UserDetailsServiceImplTest`, `UserAccountServiceTest`, `UserControllerTest`) — 10 testes cobrindo autenticação, atualização de perfil/emissão de novo token, troca de senha e exclusão completa da conta.
- `src/test/java/br/simba/bem_estar/infra/RestExceptionHandlerTest.java` e `demo/DemoDataSeederTest.java` — 3 testes cobrindo mapeamento global de exceções (422, 404, 403, 409, 500) e seeding do usuário demo.
**Usado:** JUnit Jupiter 6.0.3 (via Spring Boot 4.1.1), Mockito 5.23.0, Spring Test (`MockMvcBuilders.standaloneSetup`, `ReflectionTestUtils`, `MockHttpServletRequest`), Maven (`.\mvnw.cmd clean test`).
**Como testar:**
1. Na raiz do projeto, execute `.\mvnw.cmd clean test`.
2. Para rodar apenas uma classe específica, execute por exemplo `.\mvnw.cmd test -Dtest=StreakCalculatorTest`.
3. Confira o resumo final `Tests run: 165, Failures: 0, Errors: 0, Skipped: 0` e `BUILD SUCCESS`.
**Verificado:** suíte completa compilada e executada com `.\mvnw.cmd clean test -o` (`Tests run: 165, Failures: 0, Errors: 0, Skipped: 0` em 43 classes, incluindo `BemEstarApplicationTests`, os 35 testes existentes e os 129 novos testes de unidade). **Não verificado:** testes de integração HTTP ponta a ponta com servidor em execução e frontend.
**Pendências / atenção:** os arquivos em `src/test/resources/mockito-extensions/` configuram `mock-maker-subclass`, o que evita attach dinâmico no Java 21, mas não permite mockar classes `final` ou métodos estáticos (nenhum teste atual precisa disso).

## 2026-11-09 — Alerta após noites consecutivas de baixa qualidade
**Pedido / história:** avisar o usuário quando ele adicionar vários registros de sono com baixa qualidade.
**Alterado:**
- `src/main/resources/static/js/sono.js` — conta a sequência mais recente de notas 1 ou 2 e exibe um toast de alerta ao atingir 3 noites consecutivas, somente na transição para a situação de alerta.
**Usado:** JavaScript nativo, toast existente da tela de sono; nenhuma rota ou tabela nova.
**Como testar:**
1. Execute `.\mvnw spring-boot:run` e entre no app.
2. Em Sono, adicione três registros consecutivos com nota 1 ou 2.
3. Após o terceiro salvamento, confira o popup “Atenção com seu sono”.
**Verificado:** `node --check src/main/resources/static/js/sono.js`. **Não verificado:** fluxo manual no navegador e compilação do Spring Boot.
**Pendências / atenção:** notas 1 e 2 são tratadas como baixa qualidade; o alerta considera a sequência mais recente e não reaparece em cada novo registro enquanto a sequência já estiver alertada.

## 2026-11-09 — Sugestões de metas: botão "Criar meta" grava em Conquistas
**Pedido:** ao clicar em criar meta nas sugestões, salvar a meta de verdade na aba Conquistas.
**Alterado:**
- `perfil/SugestaoMetaDTO.java` — +`metaTipo`, `metaAlvo`, `metaTitulo` (a meta do app que o botão grava).
- `perfil/SugestoesCalculator.java` — água → `AGUA_SEGUIDOS` 7 dias; atividade → `TREINO_TOTAL` (5 treinos no peso adequado, 6 abaixo, 10 acima); peso → sem meta (o app não tem tipo de meta de peso).
- `test/.../perfil/SugestoesCalculatorTest.java` — +3 testes (mapeamento e alvos dentro dos limites do `TipoMeta`).
- `static/perfil.html` — link do topo do bloco: "Criar meta" → "Ver metas".
- `static/js/perfil-medidas.js` — botão "Criar meta: …" em cada sugestão com meta; grava via `POST /api/metas` (mesma rota da tela de Conquistas); ao abrir consulta `GET /api/metas` e mostra "Você já tem uma meta desse tipo ativa" quando for o caso; confirmação no próprio botão ("Meta criada! Ver em Conquistas"); erro do back-end (409/422) aparece embaixo do botão.
- `static/css/perfil-medidas.css` — estilos do botão e dos estados.
**Usado:** rotas existentes de metas (nenhuma regra de metas mudou), JUnit 5, Edge headless.
**Como testar:** criar um usuário novo (o demo já começa com metas de treino e de água ativas) → Meu perfil → Peso e altura → 90 kg / 175 cm → "Criar meta: Bater a meta de água por 7 dias seguidos" e "Criar meta: Fazer 10 treinos" → abrir Conquistas: as duas aparecem.
**Verificado:** 35 testes JUnit OK; `node --check`; app rodado (porta 8081) com usuário novo: os 2 cliques gravaram `AGUA_SEGUIDOS 7` e `TREINO_TOTAL 10` na API, botões viraram "Meta criada!", após F5 mostram "já ativa", Conquistas exibe as duas metas, zero erro de JS. **Não verificado:** teste manual por pessoa; Firefox/Safari.
**Atenção:** no usuário demo as duas sugestões aparecem como "já ativa" (o seeder cria metas `TREINO_TOTAL` e `AGUA_SEGUIDOS`). Para demonstrar, excluir essas metas em Conquistas antes ou usar um usuário novo. Ainda não commitado.

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
