/*
 * Comparativo semanal da tela de Progresso: busca /api/comparativo
 * (últimos 7 dias x 7 dias anteriores) e mostra uma frase por indicador.
 */
(function () {
    function num(v, casas) {
        return Number(v).toLocaleString("pt-BR", { maximumFractionDigits: casas, minimumFractionDigits: 0 });
    }

    // Monta o texto de cada card. "m" é { atual, anterior, variacaoPct, tendencia }.
    function frase(nome, m, formatar) {
        const pct = m.variacaoPct == null ? null : Math.abs(m.variacaoPct);
        switch (m.tendencia) {
            case "subiu": return "Você " + nome.mais + " " + pct + "% a mais que na semana passada.";
            case "caiu": return "Você " + nome.mais + " " + pct + "% a menos que na semana passada.";
            case "igual": return "Igual à semana passada. Constância é tudo!";
            case "novo": return "Semana passada não houve registros. Ótimo começo!";
            default: return "Sem registros nas duas semanas ainda.";
        }
    }

    const ITENS = [
        { chave: "agua", titulo: "Água", icone: "fa-droplet", mais: "bebeu",
            valor: m => num(m.atual, 0) + " ml/dia", antes: m => num(m.anterior, 0) + " ml/dia" },
        { chave: "sono", titulo: "Sono", icone: "fa-moon", mais: "dormiu",
            valor: m => num(m.atual, 1) + " h/noite", antes: m => num(m.anterior, 1) + " h/noite" },
        { chave: "treinos", titulo: "Treinos", icone: "fa-dumbbell", mais: "treinou",
            valor: m => num(m.atual, 0) + " dias", antes: m => num(m.anterior, 0) + " dias" },
        { chave: "diasAtivos", titulo: "Dias ativos", icone: "fa-fire", mais: "registrou",
            valor: m => num(m.atual, 0) + " de 7", antes: m => num(m.anterior, 0) + " de 7" }
    ];

    function criar(tag, classe, texto) {
        const e = document.createElement(tag);
        if (classe) e.className = classe;
        if (texto !== undefined) e.textContent = texto;
        return e;
    }

    function renderizar(dados) {
        const grade = document.getElementById("comparativoGrade");
        grade.replaceChildren();
        ITENS.forEach(item => {
            const m = dados[item.chave];
            if (!m) return;
            const card = criar("article", "comparativo-card " + m.tendencia);
            const topo = criar("div", "comparativo-topo");
            const ic = criar("i", "fa-solid " + item.icone);
            topo.append(ic, criar("span", "", item.titulo));
            const seta = m.tendencia === "subiu" ? "▲" : m.tendencia === "caiu" ? "▼" : "";
            const pct = m.variacaoPct == null || !seta ? "" : " " + seta + " " + Math.abs(m.variacaoPct) + "%";
            card.append(
                topo,
                criar("strong", "", item.valor(m) + pct),
                criar("small", "", "Antes: " + item.antes(m)),
                criar("p", "", frase(item, m))
            );
            grade.appendChild(card);
        });
        document.getElementById("comparativo").hidden = false;
    }

    function iniciar() {
        const token = sessionStorage.getItem("jwtToken");
        if (!token || !document.getElementById("comparativo")) return;
        fetch("/api/comparativo", { headers: { "Authorization": "Bearer " + token } })
            .then(r => { if (!r.ok) throw new Error(); return r.json(); })
            .then(renderizar)
            .catch(() => { /* sem comparativo, a tela continua normal */ });
    }

    if (typeof module !== "undefined" && module.exports) module.exports = { frase, renderizar };
    else iniciar();
})();
