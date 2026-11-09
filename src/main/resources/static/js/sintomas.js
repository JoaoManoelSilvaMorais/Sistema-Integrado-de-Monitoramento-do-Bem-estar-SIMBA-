/* =========================================================
   SINAIS CORPORAIS — questionário diário de saúde
   - GET  /api/sintomas/hoje → mostra o formulário ou o resumo de hoje
   - POST /api/sintomas      → salva (ou atualiza) o check-in de hoje
   - GET  /api/sintomas      → histórico dos últimos 30 dias + resumo da semana
   Dados do usuário só entram na tela via textContent (nada de innerHTML).
   ========================================================= */

(function () {

    // ------------------------------------------------------------------ textos e ícones

    // [classe do ícone Font Awesome, texto]
    const ESCALAS = {
        energia: [
            ["fa-solid fa-battery-empty", "Esgotado"],
            ["fa-solid fa-battery-quarter", "Baixa"],
            ["fa-solid fa-battery-half", "Normal"],
            ["fa-solid fa-battery-three-quarters", "Boa"],
            ["fa-solid fa-battery-full", "A mil"]
        ],
        humor: [
            ["fa-regular fa-face-sad-tear", "Péssimo"],
            ["fa-regular fa-face-frown", "Ruim"],
            ["fa-regular fa-face-meh", "Neutro"],
            ["fa-regular fa-face-smile", "Bom"],
            ["fa-regular fa-face-laugh-beam", "Ótimo"]
        ],
        estresse: [
            ["fa-solid fa-temperature-empty", "Tranquilo"],
            ["fa-solid fa-temperature-quarter", "Leve"],
            ["fa-solid fa-temperature-half", "Médio"],
            ["fa-solid fa-temperature-three-quarters", "Alto"],
            ["fa-solid fa-temperature-full", "Muito alto"]
        ]
    };

    const NIVEIS_DOR = {
        NENHUMA: "Nenhuma",
        LEVE: "Leve",
        MODERADA: "Moderada",
        FORTE: "Forte"
    };

    // Mesma ordem e códigos do enum LocalDor no back-end.
    const LOCAIS_DOR = {
        CABECA: "Cabeça",
        PESCOCO: "Pescoço",
        PEITO: "Peito",
        ESTOMAGO: "Estômago",
        BRACOS: "Braços",
        COSTAS: "Costas",
        LOMBAR: "Lombar",
        PERNAS: "Pernas",
        MUSCULOS: "Músculos em geral",
        OUTRO: "Outro"
    };

    const SINTOMAS = {
        DOR_DE_CABECA: "Dor de cabeça",
        CANSACO: "Cansaço",
        TONTURA: "Tontura",
        ENJOO: "Enjoo",
        INSONIA: "Insônia",
        FALTA_DE_AR: "Falta de ar",
        NENHUM: "Nenhum"
    };

    const DIAS_SEMANA = ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"];
    const TEXTO_SEM_LOCAL = "Toque para escolher as partes do corpo";

    // ------------------------------------------------------------------ estado

    const estado = {
        energia: null,
        humor: null,
        estresse: null,
        dor: null,
        locais: new Set(),
        sintomas: new Set()
    };

    let registroHoje = null;
    let dataHoje = null;

    // ------------------------------------------------------------------ elementos

    const $ = (id) => document.getElementById(id);

    const form = $("formSintomas");
    const resumoHoje = $("resumoHoje");
    const carregando = $("estadoCarregando");
    const erroForm = $("erroForm");
    const btnSalvar = $("btnSalvar");
    const btnCancelar = $("btnCancelar");
    const observacao = $("observacao");
    const campoLocais = $("campoLocais");
    const btnLocais = $("btnLocais");
    const painelLocais = $("listaLocais");

    // ------------------------------------------------------------------ token / API

    function obterToken() {
        try {
            return sessionStorage.getItem("jwtToken");
        } catch (e) {
            return null;
        }
    }

    function limparSessao() {
        try {
            sessionStorage.removeItem("jwtToken");
            sessionStorage.removeItem("usuarioLogado");
        } catch (e) {
            // sem acesso ao storage: nada a limpar
        }
    }

    class ErroApi extends Error {
        constructor(mensagem, status) {
            super(mensagem);
            this.status = status;
        }
    }

    async function api(caminho, opcoes) {
        const token = obterToken();
        const headers = { "Content-Type": "application/json" };
        if (token) {
            headers["Authorization"] = "Bearer " + token;
        }

        const resposta = await fetch(caminho, Object.assign({ headers: headers }, opcoes || {}));

        if (resposta.status === 401 || resposta.status === 403) {
            throw new ErroApi("Sua sessão expirou. Entre novamente.", resposta.status);
        }

        let corpo = null;
        try {
            corpo = await resposta.json();
        } catch (e) {
            corpo = null;
        }

        if (!resposta.ok) {
            const msg = corpo && corpo.message ? corpo.message : "Não foi possível completar a ação.";
            throw new ErroApi(msg, resposta.status);
        }
        return corpo;
    }

    // ------------------------------------------------------------------ helpers de DOM

    function criar(tag, classe, texto) {
        const el = document.createElement(tag);
        if (classe) el.className = classe;
        if (texto !== undefined && texto !== null) el.textContent = texto;
        return el;
    }

    function icone(classes) {
        const i = document.createElement("i");
        i.className = classes;
        i.setAttribute("aria-hidden", "true");
        return i;
    }

    function limpar(el) {
        while (el.firstChild) el.removeChild(el.firstChild);
    }

    function pontos(valor, extraClasse) {
        const wrap = criar("div", "sx-pontos" + (extraClasse ? " " + extraClasse : ""));
        for (let n = 1; n <= 5; n++) {
            wrap.appendChild(criar("span", n <= valor ? "cheio" : ""));
        }
        wrap.setAttribute("aria-label", valor + " de 5");
        return wrap;
    }

    /** "2026-11-08" → Date local (sem pular de dia por causa do fuso). */
    function lerData(texto) {
        const p = String(texto).split("-").map(Number);
        return new Date(p[0], p[1] - 1, p[2]);
    }

    function formatarData(texto) {
        const d = lerData(texto);
        const dd = String(d.getDate()).padStart(2, "0");
        const mm = String(d.getMonth() + 1).padStart(2, "0");
        return DIAS_SEMANA[d.getDay()] + ", " + dd + "/" + mm;
    }

    function rotuloLocal(codigo) { return LOCAIS_DOR[codigo] || codigo; }
    function rotuloSintoma(codigo) { return SINTOMAS[codigo] || codigo; }
    function formatarMedia(v) { return v === null || v === undefined ? "–" : String(v).replace(".", ","); }

    /** Lista os locais na ordem do enum, ex.: "Cabeça, Lombar". */
    function listaLocais(codigos) {
        return Object.keys(LOCAIS_DOR).filter((c) => codigos.indexOf(c) >= 0).map(rotuloLocal).join(", ");
    }

    // ------------------------------------------------------------------ montar o formulário

    function montarEscalas() {
        document.querySelectorAll(".sx-escala").forEach((grupo) => {
            const campo = grupo.dataset.campo;
            ESCALAS[campo].forEach((par, idx) => {
                const valor = idx + 1;
                const btn = criar("button", "sx-opcao");
                btn.type = "button";
                btn.setAttribute("role", "radio");
                btn.setAttribute("aria-checked", "false");
                btn.setAttribute("aria-label", valor + " - " + par[1]);
                btn.dataset.valor = String(valor);
                btn.appendChild(icone(par[0]));
                btn.appendChild(criar("span", "sx-txt", par[1]));
                btn.addEventListener("click", () => {
                    estado[campo] = valor;
                    atualizarEscala(campo);
                    esconderErro();
                });
                grupo.appendChild(btn);
            });
        });
    }

    function atualizarEscala(campo) {
        document.querySelectorAll('.sx-escala[data-campo="' + campo + '"] .sx-opcao').forEach((btn) => {
            btn.setAttribute("aria-checked", String(Number(btn.dataset.valor) === estado[campo]));
        });
    }

    function montarDor() {
        const grupo = $("opcoesDor");
        Object.keys(NIVEIS_DOR).forEach((codigo) => {
            const btn = criar("button", "sx-segmento", NIVEIS_DOR[codigo]);
            btn.type = "button";
            btn.setAttribute("role", "radio");
            btn.setAttribute("aria-checked", "false");
            btn.dataset.valor = codigo;
            btn.addEventListener("click", () => {
                const antes = estado.dor;
                estado.dor = codigo;
                if (codigo === "NENHUMA") {
                    estado.locais.clear();
                }
                atualizarDor();
                atualizarLocais();
                esconderErro();
                // Acabou de dizer que tem dor: já abre a lista para escolher onde.
                if (codigo !== "NENHUMA" && (!antes || antes === "NENHUMA") && estado.locais.size === 0) {
                    abrirLista();
                }
            });
            grupo.appendChild(btn);
        });
    }

    function atualizarDor() {
        document.querySelectorAll("#opcoesDor .sx-segmento").forEach((btn) => {
            btn.setAttribute("aria-checked", String(btn.dataset.valor === estado.dor));
        });
        const temDor = !!estado.dor && estado.dor !== "NENHUMA";
        campoLocais.hidden = !temDor;
        if (!temDor) fecharLista();
    }

    // ----- campo "Onde dói?": abre uma lista de partes do corpo com caixas de marcar -----

    function montarLocais() {
        Object.keys(LOCAIS_DOR).forEach((codigo) => {
            const item = criar("label", "sx-locais-item");
            const caixa = document.createElement("input");
            caixa.type = "checkbox";
            caixa.value = codigo;
            caixa.addEventListener("change", () => {
                if (caixa.checked) {
                    estado.locais.add(codigo);
                } else {
                    estado.locais.delete(codigo);
                }
                atualizarLocais();
                esconderErro();
            });
            item.appendChild(caixa);
            item.appendChild(criar("span", "", rotuloLocal(codigo)));
            painelLocais.appendChild(item);
        });

        btnLocais.addEventListener("click", () => {
            if (painelLocais.hidden) {
                abrirLista();
            } else {
                fecharLista();
            }
        });

        // Fecha ao clicar fora ou apertar Esc.
        document.addEventListener("click", (ev) => {
            // (o clique que escolhe a intensidade da dor é o que abre a lista; não pode fechá-la)
            const naDor = ev.target.closest && ev.target.closest("#opcoesDor");
            if (!painelLocais.hidden && !campoLocais.contains(ev.target) && !naDor) {
                fecharLista();
            }
        });
        campoLocais.addEventListener("keydown", (ev) => {
            if (ev.key === "Escape" && !painelLocais.hidden) {
                ev.preventDefault();
                fecharLista();
                btnLocais.focus();
            }
        });
    }

    function abrirLista() {
        painelLocais.hidden = false;
        btnLocais.setAttribute("aria-expanded", "true");
        const primeira = painelLocais.querySelector("input");
        if (primeira) primeira.focus({ preventScroll: true });
    }

    function fecharLista() {
        painelLocais.hidden = true;
        btnLocais.setAttribute("aria-expanded", "false");
    }

    function atualizarLocais() {
        painelLocais.querySelectorAll("input").forEach((caixa) => {
            caixa.checked = estado.locais.has(caixa.value);
        });
        const texto = listaLocais(Array.from(estado.locais));
        const span = $("textoLocais");
        span.textContent = texto || TEXTO_SEM_LOCAL;
        span.classList.toggle("vazio", !texto);
        campoLocais.classList.remove("erro");
    }

    function montarSintomas() {
        const grupo = $("opcoesSintomas");
        Object.keys(SINTOMAS).forEach((codigo) => {
            const chip = criar("button", "sx-chip");
            chip.type = "button";
            chip.dataset.sintoma = codigo;
            chip.setAttribute("aria-pressed", "false");
            chip.appendChild(icone("fa-solid fa-check"));
            chip.appendChild(document.createTextNode(SINTOMAS[codigo]));
            chip.addEventListener("click", () => alternarSintoma(codigo));
            grupo.appendChild(chip);
        });
    }

    function alternarSintoma(codigo) {
        if (estado.sintomas.has(codigo)) {
            estado.sintomas.delete(codigo);
        } else if (codigo === "NENHUM") {
            estado.sintomas.clear();
            estado.sintomas.add("NENHUM");
        } else {
            estado.sintomas.delete("NENHUM");
            estado.sintomas.add(codigo);
        }
        atualizarSintomas();
        esconderErro();
    }

    function atualizarSintomas() {
        document.querySelectorAll("#opcoesSintomas .sx-chip").forEach((chip) => {
            chip.setAttribute("aria-pressed", String(estado.sintomas.has(chip.dataset.sintoma)));
        });
    }

    function atualizarContador() {
        $("contadorObs").textContent = observacao.value.length + "/300";
    }

    function preencherFormulario(registro) {
        estado.energia = registro ? registro.energia : null;
        estado.humor = registro ? registro.humor : null;
        estado.estresse = registro ? registro.estresse : null;
        estado.dor = registro ? registro.dor : null;
        estado.locais = new Set(registro ? registro.locaisDor : []);
        estado.sintomas = new Set(registro ? registro.sintomas : []);
        observacao.value = registro && registro.observacao ? registro.observacao : "";

        ["energia", "humor", "estresse"].forEach(atualizarEscala);
        atualizarDor();
        atualizarLocais();
        atualizarSintomas();
        atualizarContador();
    }

    // ------------------------------------------------------------------ validação e envio

    function mostrarErro(msg) {
        erroForm.textContent = msg;
        erroForm.hidden = false;
    }

    function esconderErro() {
        erroForm.hidden = true;
    }

    /** Mesmas regras do SintomaCalculator, só para avisar antes de enviar. */
    function validar() {
        if (!estado.energia) return "Escolha sua energia de hoje.";
        if (!estado.humor) return "Escolha seu humor de hoje.";
        if (!estado.estresse) return "Escolha seu nível de estresse.";
        if (!estado.dor) return "Diga se está sentindo dor (pode ser \"Nenhuma\").";
        if (estado.dor !== "NENHUMA" && estado.locais.size === 0) {
            campoLocais.classList.add("erro");
            return "Escolha onde está doendo.";
        }
        if (observacao.value.trim().length > 300) return "A observação pode ter no máximo 300 caracteres.";
        return null;
    }

    async function enviar(ev) {
        ev.preventDefault();
        fecharLista();
        const problema = validar();
        if (problema) {
            mostrarErro(problema);
            return;
        }

        const corpo = {
            energia: estado.energia,
            humor: estado.humor,
            estresse: estado.estresse,
            dor: estado.dor,
            locaisDor: estado.dor === "NENHUMA" ? [] : Array.from(estado.locais),
            sintomas: estado.sintomas.size ? Array.from(estado.sintomas) : ["NENHUM"],
            observacao: observacao.value.trim() || null
        };

        btnSalvar.disabled = true;
        try {
            registroHoje = await api("/api/sintomas", { method: "POST", body: JSON.stringify(corpo) });
            mostrarResumoHoje();
            carregarHistorico();
        } catch (erro) {
            tratarErro(erro, true);
        } finally {
            btnSalvar.disabled = false;
        }
    }

    // ------------------------------------------------------------------ telas

    function mostrarFormulario(editando) {
        carregando.hidden = true;
        resumoHoje.hidden = true;
        form.hidden = false;
        esconderErro();
        $("formTitulo").textContent = editando ? "Editando o check-in de hoje" : "Leva menos de 1 minuto";
        $("btnSalvarTexto").textContent = editando ? "Salvar alterações" : "Salvar check-in";
        btnCancelar.hidden = !editando;
        preencherFormulario(editando ? registroHoje : null);
    }

    function mostrarResumoHoje() {
        if (!registroHoje) {
            mostrarFormulario(false);
            return;
        }
        fecharLista();
        carregando.hidden = true;
        form.hidden = true;
        resumoHoje.hidden = false;
        const r = registroHoje;

        const medidores = $("resumoMedidores");
        limpar(medidores);
        [["energia", "Energia"], ["humor", "Humor"], ["estresse", "Estresse"]].forEach((par) => {
            const valor = r[par[0]];
            const opcao = ESCALAS[par[0]][valor - 1];
            const box = criar("div", "sx-medidor");
            box.appendChild(criar("span", "sx-medidor-nome", par[1]));
            const linha = criar("span", "sx-medidor-valor");
            linha.appendChild(icone(opcao[0]));
            linha.appendChild(document.createTextNode(opcao[1]));
            box.appendChild(linha);
            box.appendChild(pontos(valor, par[0] === "estresse" ? "estresse" : ""));
            medidores.appendChild(box);
        });

        const dor = $("resumoDor");
        limpar(dor);
        dor.appendChild(criar("strong", "", "Dor:"));
        if (r.dor === "NENHUMA") {
            dor.appendChild(criar("span", "sx-tag", "Nenhuma"));
        } else {
            dor.appendChild(criar("span", "sx-tag dor", NIVEIS_DOR[r.dor] || r.dor));
            r.locaisDor.forEach((l) => dor.appendChild(criar("span", "sx-tag", rotuloLocal(l))));
        }

        const sint = $("resumoSintomas");
        limpar(sint);
        sint.appendChild(criar("strong", "", "Sintomas:"));
        r.sintomas.forEach((s) => sint.appendChild(criar("span", "sx-tag", rotuloSintoma(s))));

        const obs = $("resumoObs");
        obs.hidden = !r.observacao;
        obs.textContent = r.observacao ? "“" + r.observacao + "”" : "";
    }

    function renderizarSemana(semana) {
        $("semanaMensagem").textContent = semana.mensagem;
        $("mediaEnergia").textContent = formatarMedia(semana.mediaEnergia);
        $("mediaHumor").textContent = formatarMedia(semana.mediaHumor);
        $("mediaEstresse").textContent = formatarMedia(semana.mediaEstresse);
        $("semanaDias").textContent = "Respondeu " + semana.diasRespondidos + " de 7 dias";
        $("semanaDor").textContent = semana.diasComDor === 1
            ? "Sentiu dor em 1 dia" : "Sentiu dor em " + semana.diasComDor + " dias";
        $("semanaSintoma").textContent = semana.sintomaMaisFrequente
            ? "Mais frequente: " + rotuloSintoma(semana.sintomaMaisFrequente)
              + " (" + semana.vezesSintomaMaisFrequente + "x)"
            : "Nenhum sintoma frequente";
    }

    function renderizarHistorico(registros) {
        const lista = $("listaHistorico");
        limpar(lista);

        if (!registros.length) {
            lista.appendChild(criar("p", "sx-vazio",
                "Ainda não há respostas. Faça o check-in de hoje para começar seu histórico."));
            return;
        }

        registros.forEach((r) => {
            const card = criar("article", "sx-dia" + (r.data === dataHoje ? " hoje" : ""));

            const topo = criar("div", "sx-dia-topo");
            topo.appendChild(criar("strong", "", formatarData(r.data)));
            if (r.data === dataHoje) topo.appendChild(criar("span", "", "Hoje"));
            card.appendChild(topo);

            const mini = criar("div", "sx-mini");
            [["energia", "fa-solid fa-bolt"], ["humor", "fa-solid fa-face-smile"], ["estresse", "fa-solid fa-brain"]]
                .forEach((par) => {
                    const i = icone(par[1]);
                    i.setAttribute("title", par[0]);
                    mini.appendChild(i);
                    mini.appendChild(pontos(r[par[0]], par[0] === "estresse" ? "estresse" : ""));
                });
            card.appendChild(mini);

            const dor = criar("div", "sx-resumo-linha");
            if (r.dor === "NENHUMA") {
                dor.appendChild(criar("span", "sx-tag", "Sem dor"));
            } else {
                dor.appendChild(criar("span", "sx-tag dor", "Dor " + (NIVEIS_DOR[r.dor] || r.dor).toLowerCase()));
                dor.appendChild(criar("span", "", listaLocais(r.locaisDor)));
            }
            card.appendChild(dor);

            const sint = r.sintomas.filter((s) => s !== "NENHUM");
            if (sint.length) {
                const linha = criar("div", "sx-resumo-linha");
                sint.forEach((s) => linha.appendChild(criar("span", "sx-tag", rotuloSintoma(s))));
                card.appendChild(linha);
            }

            if (r.observacao) {
                card.appendChild(criar("p", "sx-dia-obs", "“" + r.observacao + "”"));
            }

            lista.appendChild(card);
        });
    }

    // ------------------------------------------------------------------ carregar dados

    function tratarErro(erro, noFormulario) {
        console.error(erro);
        if (erro instanceof ErroApi && (erro.status === 401 || erro.status === 403)) {
            mostrarAvisoLogin(erro.message);
            return;
        }
        if (noFormulario) {
            mostrarErro(erro.message || "Erro ao salvar.");
        } else {
            const aviso = $("avisoGeral");
            aviso.textContent = erro.message || "Não foi possível carregar os dados.";
            aviso.hidden = false;
        }
    }

    function mostrarAvisoLogin(mensagem) {
        limparSessao();
        const aviso = $("avisoGeral");
        limpar(aviso);
        aviso.appendChild(document.createTextNode((mensagem || "Você precisa entrar para responder.") + " "));
        const link = criar("a", "", "Entrar");
        link.href = "entrar.html";
        aviso.appendChild(link);
        aviso.hidden = false;
        carregando.hidden = true;
        form.hidden = true;
        resumoHoje.hidden = true;
        $("semanaMensagem").textContent = "Entre para ver sua semana.";
        limpar($("listaHistorico"));
    }

    async function carregarHoje() {
        try {
            const hoje = await api("/api/sintomas/hoje");
            dataHoje = hoje.data;
            $("formData").textContent = formatarData(hoje.data);
            registroHoje = hoje.registro;
            if (hoje.respondido) {
                mostrarResumoHoje();
            } else {
                mostrarFormulario(false);
            }
        } catch (erro) {
            carregando.hidden = true;
            tratarErro(erro, false);
        }
    }

    async function carregarHistorico() {
        try {
            const dados = await api("/api/sintomas");
            renderizarSemana(dados.semana);
            renderizarHistorico(dados.registros);
        } catch (erro) {
            if (!(erro instanceof ErroApi && (erro.status === 401 || erro.status === 403))) {
                limpar($("listaHistorico"));
                $("listaHistorico").appendChild(criar("p", "sx-vazio", "Não foi possível carregar o histórico."));
            }
            tratarErro(erro, false);
        }
    }

    async function carregarUsuario() {
        try {
            const usuario = await api("/users/me");
            const nome = (usuario && (usuario.name || usuario.username)) || "U";
            $("avatarUsuario").textContent = nome.charAt(0).toUpperCase();
        } catch (e) {
            // avatar fica com "U"
        }
    }

    // ------------------------------------------------------------------ início

    function iniciar() {
        montarEscalas();
        montarDor();
        montarLocais();
        montarSintomas();

        form.addEventListener("submit", enviar);
        observacao.addEventListener("input", atualizarContador);
        $("btnEditar").addEventListener("click", () => mostrarFormulario(true));
        btnCancelar.addEventListener("click", mostrarResumoHoje);
        $("sair").addEventListener("click", limparSessao);

        if (!obterToken()) {
            mostrarAvisoLogin("Você precisa entrar para responder o questionário.");
            return;
        }

        $("loginButton").style.display = "none";
        carregarUsuario();
        carregarHoje();
        carregarHistorico();
    }

    iniciar();

})();
