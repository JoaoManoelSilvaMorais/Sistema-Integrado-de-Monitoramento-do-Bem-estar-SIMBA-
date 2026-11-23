/*
 * Alertas preventivos (RF16 e RF17).
 * Consulta /api/alertas e mostra, na tela de Hidratação ou Treinos, o aviso daquela
 * métrica quando ela está abaixo do esperado, com a orientação de procurar um profissional
 * de saúde e o lembrete de que o SIMBA não substitui avaliação ou diagnóstico.
 *
 * Na tela de Sono fica só o aviso que já existia em js/sono.js ("Atenção com seu sono"),
 * por decisão da equipe; o alerta de sono continua aparecendo na dashboard.
 *
 * Na dashboard (index.html) mostra todos os alertas ativos, para a pessoa ser avisada mesmo
 * sem abrir a tela da métrica.
 *
 * Não mexe nos scripts das telas: descobre a tela pelo nome do arquivo e "escuta" os fetch()
 * de registro para atualizar o aviso depois que a pessoa salva, edita ou exclui algo.
 */
(function () {
    const TODOS = "TODOS";
    const TELAS = { "hidratacao.html": "AGUA", "treinos.html": "TREINO", "index.html": TODOS };
    const ICONES = { SONO: "fa-moon", AGUA: "fa-droplet", TREINO: "fa-dumbbell" };
    const ROTAS = ["/registroagua", "/registrosono", "/registroexercicio"];

    function tipoDaTela() {
        const arquivo = String(window.location.pathname).split("/").pop().toLowerCase();
        return TELAS[arquivo] || null;
    }

    function ehEscritaDeRegistro(url, metodo) {
        if (String(metodo || "GET").toUpperCase() === "GET") return false;
        const caminho = String(url).split("?")[0].toLowerCase().replace(/\/+$/, "");
        return ROTAS.some(rota => caminho.includes(rota));
    }

    function chaveDispensa(tipo) {
        const h = new Date();
        return "simbaAlertaDispensado-" + tipo + "-" + h.getFullYear() + "-" + (h.getMonth() + 1) + "-" + h.getDate();
    }

    function foiDispensado(tipo) {
        try { return sessionStorage.getItem(chaveDispensa(tipo)) === "1"; } catch (e) { return false; }
    }

    function dispensar(tipo) {
        try { sessionStorage.setItem(chaveDispensa(tipo), "1"); } catch (e) { /* segue sem lembrar */ }
    }

    function container() {
        let c = document.getElementById("simba-alertas");
        if (!c) {
            c = document.createElement("div");
            c.id = "simba-alertas";
            c.className = "simba-alertas";
            c.setAttribute("aria-live", "polite");
            document.body.appendChild(c);
        }
        return c;
    }

    function criarCartao(alerta, aviso) {
        const cartao = document.createElement("section");
        cartao.className = "simba-alerta";
        cartao.setAttribute("role", "status");

        const icone = document.createElement("i");
        icone.className = "fa-solid " + (ICONES[alerta.tipo] || "fa-triangle-exclamation");
        icone.setAttribute("aria-hidden", "true");

        const corpo = document.createElement("div");
        corpo.className = "simba-alerta-corpo";

        const titulo = document.createElement("strong");
        titulo.textContent = alerta.titulo;

        const mensagem = document.createElement("p");
        mensagem.textContent = alerta.mensagem;

        const orientacao = document.createElement("p");
        orientacao.className = "simba-alerta-orientacao";
        orientacao.textContent = alerta.orientacao;

        const nota = document.createElement("small");
        nota.textContent = aviso;

        const botao = document.createElement("button");
        botao.type = "button";
        botao.className = "simba-alerta-fechar";
        botao.textContent = "Entendi";
        botao.addEventListener("click", () => {
            dispensar(alerta.tipo);
            cartao.remove();
        });

        corpo.append(titulo, mensagem, orientacao, nota, botao);
        cartao.append(icone, corpo);
        return cartao;
    }

    function desenhar(dados, tipo) {
        const c = container();
        c.textContent = "";
        if (!dados || !Array.isArray(dados.alertas)) return;
        dados.alertas
            .filter(a => (tipo === TODOS || a.tipo === tipo) && !foiDispensado(a.tipo))
            .forEach(a => c.appendChild(criarCartao(a, dados.aviso || "")));
    }

    async function carregar() {
        const tipo = tipoDaTela();
        if (!tipo) return;
        let token = null;
        try { token = sessionStorage.getItem("jwtToken"); } catch (e) { /* sem token */ }
        if (!token) return;
        try {
            const resposta = await nativo("/api/alertas", { headers: { "Authorization": "Bearer " + token } });
            if (!resposta.ok) return;
            desenhar(await resposta.json(), tipo);
        } catch (e) {
            // Sem rede ou erro do servidor: o aviso é um extra, a tela continua funcionando.
        }
    }

    const nativo = window.fetch.bind(window);
    window.fetch = function (entrada, opcoes) {
        const url = typeof entrada === "string" ? entrada : (entrada && entrada.url) || "";
        const metodo = (opcoes && opcoes.method) || (entrada && entrada.method) || "GET";
        const promessa = nativo(entrada, opcoes);
        if (ehEscritaDeRegistro(url, metodo)) {
            promessa.then(r => { if (r && r.ok) setTimeout(carregar, 600); }).catch(() => { });
        }
        return promessa;
    };

    if (typeof document !== "undefined") {
        if (document.readyState === "loading") {
            document.addEventListener("DOMContentLoaded", carregar);
        } else {
            carregar();
        }
    }

    if (typeof module !== "undefined" && module.exports) module.exports = { ehEscritaDeRegistro, tipoDaTela };
})();
