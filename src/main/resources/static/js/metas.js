/*
 * Metas do usuário (ex.: "treinar 5 dias seguidos") da tela de conquistas.
 * O progresso é calculado pelo backend (/api/metas); aqui só mostramos e criamos.
 */
(function () {
    const TIPOS = [
        { id: "TREINO_SEGUIDOS", nome: "Treinar X dias seguidos", min: 2, max: 60, padrao: 5 },
        { id: "AGUA_SEGUIDOS", nome: "Bater a meta de água X dias seguidos", min: 2, max: 60, padrao: 5 },
        { id: "SONO_SEGUIDOS", nome: "Dormir 7 h ou mais X noites seguidas", min: 2, max: 60, padrao: 5 },
        { id: "TREINO_TOTAL", nome: "Fazer X treinos", min: 2, max: 300, padrao: 10 }
    ];
    const token = sessionStorage.getItem("jwtToken");
    if (!token || !document.getElementById("metas")) return;

    function criar(tag, classe, texto) {
        const e = document.createElement(tag);
        if (classe) e.className = classe;
        if (texto !== undefined) e.textContent = texto;
        return e;
    }

    async function chamar(url, metodo, corpo) {
        const resposta = await fetch(url, {
            method: metodo || "GET",
            headers: { "Content-Type": "application/json", "Authorization": "Bearer " + token },
            body: corpo ? JSON.stringify(corpo) : undefined
        });
        if (!resposta.ok) {
            let msg = "Não foi possível concluir (erro " + resposta.status + ").";
            try { const j = await resposta.json(); if (j.message) msg = j.message; } catch (e) { /* mantém */ }
            throw new Error(msg);
        }
        return resposta.status === 204 ? null : resposta.json();
    }

    function dizer(id, texto) { document.getElementById(id).textContent = texto || ""; }

    // ---------- metas ----------
    function itemMeta(m) {
        const item = criar("div", "meta-item" + (m.concluida ? " concluida" : ""));
        const ic = criar("div", "meta-icone");
        const i = criar("i", "fa-solid " + (m.concluida ? "fa-check" : m.icone));
        ic.appendChild(i);

        const corpo = criar("div", "meta-corpo");
        const titulo = criar("strong", "", m.titulo);
        if (m.nova) titulo.appendChild(criar("span", "conq-novo", "CONCLUÍDA!"));
        corpo.appendChild(titulo);
        const barra = criar("div", "conq-barra");
        const cheio = criar("span");
        cheio.style.width = Math.min(100, Math.round((m.progressoAtual / m.alvo) * 100)) + "%";
        barra.appendChild(cheio);
        const detalhe = m.concluida
            ? "Concluída! Que tal um desafio maior?"
            : m.progressoAtual + "/" + m.alvo + " " + m.unidade + (m.melhor > m.progressoAtual ? " · melhor sequência: " + m.melhor : "");
        corpo.append(barra, criar("small", "", detalhe));

        const acoes = criar("div", "meta-acoes");
        if (m.concluida) {
            const mais = criar("button", "", "Aumentar desafio");
            mais.type = "button";
            mais.addEventListener("click", () => aumentar(m));
            acoes.appendChild(mais);
        }
        const excluir = criar("button", "", m.concluida ? "Remover" : "Excluir");
        excluir.type = "button";
        excluir.addEventListener("click", () => excluirMeta(m));
        acoes.appendChild(excluir);

        item.append(ic, corpo, acoes);
        return item;
    }

    function mostrarMetas(lista) {
        const caixa = document.getElementById("listaMetas");
        caixa.replaceChildren();
        if (!lista.length) {
            caixa.appendChild(criar("p", "metas-msg", "Você ainda não tem metas. Crie a primeira abaixo!"));
            return;
        }
        lista.forEach(m => caixa.appendChild(itemMeta(m)));
    }

    async function carregarMetas() {
        mostrarMetas(await chamar("/api/metas"));
    }

    async function aumentar(m) {
        try {
            await chamar("/api/metas/" + m.id, "DELETE");
            await chamar("/api/metas", "POST", { tipo: m.tipo, alvo: m.alvoSugerido });
            dizer("msgMetas", "Novo desafio criado: " + m.alvoSugerido + " " + m.unidade + "!");
            await carregarMetas();
        } catch (e) { dizer("msgMetas", e.message); }
    }

    async function excluirMeta(m) {
        if (!confirm("Remover a meta \"" + m.titulo + "\"?")) return;
        try {
            await chamar("/api/metas/" + m.id, "DELETE");
            dizer("msgMetas", "Meta removida.");
            await carregarMetas();
        } catch (e) { dizer("msgMetas", e.message); }
    }

    function prepararFormMeta() {
        const select = document.getElementById("tipoMeta");
        const alvo = document.getElementById("alvoMeta");
        TIPOS.forEach(t => select.appendChild(new Option(t.nome, t.id)));
        const ajustar = () => {
            const t = TIPOS.find(x => x.id === select.value);
            alvo.min = t.min; alvo.max = t.max; alvo.value = t.padrao;
        };
        select.addEventListener("change", ajustar);
        ajustar();
        document.getElementById("formMeta").addEventListener("submit", async evento => {
            evento.preventDefault();
            try {
                await chamar("/api/metas", "POST", { tipo: select.value, alvo: Number(alvo.value) });
                dizer("msgMetas", "Meta criada! O progresso conta a partir de hoje.");
                await carregarMetas();
            } catch (e) { dizer("msgMetas", e.message); }
        });
    }

    prepararFormMeta();
    carregarMetas().catch(e => dizer("msgMetas", e.message));
})();
