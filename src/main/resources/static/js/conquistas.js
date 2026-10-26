/*
 * Tela de conquistas: busca /api/conquistas (que também desbloqueia as novas)
 * e mostra o resumo, os cards por categoria e um aviso para cada conquista nova.
 */
(function () {
    const API = "/api/conquistas";
    const ORDEM = ["Hidratação", "Sono", "Treinos", "Rotinas", "Ofensiva", "Geral"];

    const token = sessionStorage.getItem("jwtToken");
    let dados = null;
    let filtro = "todas";

    function criar(tag, classe, texto) {
        const e = document.createElement(tag);
        if (classe) e.className = classe;
        if (texto !== undefined) e.textContent = texto;
        return e;
    }

    function icone(classes) {
        const i = document.createElement("i");
        i.className = classes;
        return i;
    }

    function irParaLogin() {
        sessionStorage.removeItem("jwtToken");
        sessionStorage.removeItem("usuarioLogado");
        window.location.href = "entrar.html";
    }

    function mostrarMensagem(texto) {
        document.getElementById("mensagem").textContent = texto || "";
    }

    function formatarData(valor) {
        const data = new Date(valor);
        return Number.isNaN(data.getTime()) ? "" : data.toLocaleDateString("pt-BR");
    }

    function criarCard(c) {
        const card = criar("article", "conq-card " + (c.desbloqueada ? "desbloqueada" : "bloqueada"));

        const ic = criar("div", "conq-icone");
        ic.appendChild(icone("fa-solid " + (c.desbloqueada ? c.icone : "fa-lock")));

        const corpo = criar("div", "conq-corpo");
        const titulo = criar("h3", "", c.nome);
        if (c.nova) titulo.appendChild(criar("span", "conq-novo", "NOVA"));
        corpo.append(titulo, criar("p", "", c.descricao));

        if (c.desbloqueada) {
            const data = criar("small");
            data.append(icone("fa-solid fa-check"), document.createTextNode(" Desbloqueada em " + formatarData(c.dataDesbloqueio)));
            corpo.appendChild(data);
        } else if (c.progressoMeta > 1) {
            const barra = criar("div", "conq-barra");
            const preenchido = criar("span");
            preenchido.style.width = Math.round((c.progressoAtual / c.progressoMeta) * 100) + "%";
            barra.appendChild(preenchido);
            const texto = c.progressoAtual + "/" + c.progressoMeta + (c.unidade ? " " + c.unidade : "");
            corpo.append(barra, criar("small", "", texto));
        } else {
            const bloq = criar("small");
            bloq.append(icone("fa-solid fa-lock"), document.createTextNode(" Ainda bloqueada"));
            corpo.appendChild(bloq);
        }

        card.append(ic, corpo);
        return card;
    }

    function renderizar() {
        const lista = document.getElementById("listaConquistas");
        lista.replaceChildren();
        if (!dados) return;

        const visiveis = dados.conquistas.filter(c =>
            filtro === "todas" || (filtro === "desbloqueadas" ? c.desbloqueada : !c.desbloqueada));

        if (visiveis.length === 0) {
            lista.appendChild(criar("p", "conq-vazio",
                filtro === "desbloqueadas" ? "Nenhuma conquista desbloqueada ainda. Bora começar!" : "Você desbloqueou todas as conquistas!"));
            return;
        }

        const categorias = [...new Set(dados.conquistas.map(c => c.categoria))]
            .sort((a, b) => (ORDEM.indexOf(a) + 100) % 100 - (ORDEM.indexOf(b) + 100) % 100);

        categorias.forEach(nome => {
            const doGrupo = visiveis.filter(c => c.categoria === nome);
            if (doGrupo.length === 0) return;
            const total = dados.conquistas.filter(c => c.categoria === nome);
            const feitas = total.filter(c => c.desbloqueada).length;

            const secao = criar("section", "conq-categoria");
            const h2 = criar("h2", "", nome);
            h2.appendChild(criar("small", "", feitas + "/" + total.length));
            const grade = criar("div", "conq-grid");
            doGrupo.forEach(c => grade.appendChild(criarCard(c)));
            secao.append(h2, grade);
            lista.appendChild(secao);
        });
    }

    function renderizarResumo() {
        document.getElementById("totalDesbloqueadas").textContent = dados.desbloqueadas;
        document.getElementById("totalConquistas").textContent = dados.total;
        const pct = dados.total === 0 ? 0 : Math.round((dados.desbloqueadas / dados.total) * 100);
        document.getElementById("barraGeral").style.width = pct + "%";
        document.getElementById("textoResumo").textContent =
            dados.desbloqueadas === dados.total
                ? "Incrível! Você é lenda da savana."
                : pct + "% concluído. Faltam " + (dados.total - dados.desbloqueadas) + " conquistas.";
    }

    function avisar(conquista, atraso) {
        const container = document.getElementById("toast-container");
        if (!container) return;
        setTimeout(() => {
            const toast = criar("div", "toast-notification");
            const texto = criar("div");
            texto.append(criar("strong", "", "Conquista desbloqueada!"), criar("span", "", conquista.nome));
            toast.append(icone("fa-solid fa-trophy"), texto);
            container.appendChild(toast);
            setTimeout(() => toast.classList.add("show"), 10);
            setTimeout(() => {
                toast.classList.remove("show");
                setTimeout(() => toast.remove(), 300);
            }, 5000);
        }, atraso);
    }

    async function carregar() {
        const resposta = await fetch(API, { headers: { "Authorization": "Bearer " + token } });
        if (resposta.status === 401 || resposta.status === 403) { irParaLogin(); return; }
        if (!resposta.ok) throw new Error("Não foi possível carregar as conquistas.");
        dados = await resposta.json();
        renderizarResumo();
        renderizar();
        dados.conquistas.filter(c => c.nova).slice(0, 5).forEach((c, i) => avisar(c, 400 + i * 900));
    }

    function carregarUsuario() {
        fetch("/users/me", { headers: { "Authorization": "Bearer " + token } })
            .then(r => { if (!r.ok) throw new Error(); return r.json(); })
            .then(u => {
                document.getElementById("loginButton").style.display = "none";
                document.getElementById("avatarUsuario").textContent =
                    (u.name || u.username || "U").charAt(0).toUpperCase();
            })
            .catch(() => { /* a lista de conquistas já trata sessão expirada */ });
    }

    function iniciar() {
        if (!token) { irParaLogin(); return; }

        document.getElementById("filtros").addEventListener("click", evento => {
            const botao = evento.target.closest("button[data-filtro]");
            if (!botao) return;
            filtro = botao.dataset.filtro;
            document.querySelectorAll("#filtros button").forEach(b => b.classList.toggle("ativo", b === botao));
            renderizar();
        });

        const sair = document.getElementById("sair");
        if (sair) sair.addEventListener("click", () => {
            sessionStorage.removeItem("jwtToken");
            sessionStorage.removeItem("usuarioLogado");
        });

        carregarUsuario();
        carregar().catch(e => mostrarMensagem(e.message));
    }

    iniciar();
})();
