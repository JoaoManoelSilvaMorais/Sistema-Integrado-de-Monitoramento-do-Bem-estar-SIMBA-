/*
 * Feedback imediato ao registrar água, sono ou treino.
 * Em vez de mexer nos arquivos de cada tela, este script "escuta" os fetch():
 * quando um POST em /registroAgua, /registrosono ou /registroexercicio dá certo,
 * ele consulta /api/streak, /api/conquistas e /api/metas e mostra um aviso para
 * o que for novo (ofensiva do dia, conquista desbloqueada, meta concluída).
 */
(function () {
    const ROTAS = ["/registroagua", "/registrosono", "/registroexercicio"];

    function ehRegistro(url, metodo) {
        if (String(metodo || "GET").toUpperCase() !== "POST") return false;
        const caminho = String(url).split("?")[0].toLowerCase().replace(/\/+$/, "");
        return ROTAS.some(rota => caminho.endsWith(rota));
    }

    function container() {
        let c = document.getElementById("simba-toasts");
        if (!c) {
            c = document.createElement("div");
            c.id = "simba-toasts";
            c.className = "simba-toasts";
            document.body.appendChild(c);
        }
        return c;
    }

    function aviso(icone, titulo, texto, atraso) {
        setTimeout(() => {
            const toast = document.createElement("div");
            toast.className = "simba-toast";
            const i = document.createElement("i");
            i.className = "fa-solid " + icone;
            const corpo = document.createElement("div");
            const forte = document.createElement("strong");
            forte.textContent = titulo;
            const span = document.createElement("span");
            span.textContent = texto;
            corpo.append(forte, span);
            toast.append(i, corpo);
            container().appendChild(toast);
            setTimeout(() => toast.classList.add("show"), 10);
            setTimeout(() => {
                toast.classList.remove("show");
                setTimeout(() => toast.remove(), 300);
            }, 5000);
        }, atraso);
    }

    function buscar(url) {
        const token = sessionStorage.getItem("jwtToken");
        return nativo(url, { headers: { "Authorization": "Bearer " + token } })
            .then(r => r.ok ? r.json() : null)
            .catch(() => null);
    }

    function chaveDoDia() {
        const h = new Date();
        return "simbaOfensivaAvisada-" + h.getFullYear() + "-" + (h.getMonth() + 1) + "-" + h.getDate();
    }

    async function darFeedback() {
        if (!sessionStorage.getItem("jwtToken")) return;
        const [streak, conquistas, metas] = await Promise.all([
            buscar("/api/streak"), buscar("/api/conquistas"), buscar("/api/metas")
        ]);
        let n = 0;

        if (streak && streak.ativoHoje) {
            let jaAvisou = false;
            try { jaAvisou = sessionStorage.getItem(chaveDoDia()) === "1"; } catch (e) { /* ok */ }
            if (!jaAvisou) {
                try { sessionStorage.setItem(chaveDoDia(), "1"); } catch (e) { /* ok */ }
                const dias = streak.atual + (streak.atual === 1 ? " dia" : " dias");
                aviso("fa-fire", "Ofensiva garantida hoje!", "Você está com " + dias + " seguidos.", 300 + 900 * n++);
            }
        }
        if (conquistas && Array.isArray(conquistas.conquistas)) {
            conquistas.conquistas.filter(c => c.nova).slice(0, 3)
                .forEach(c => aviso("fa-trophy", "Conquista desbloqueada!", c.nome, 300 + 900 * n++));
        }
        if (Array.isArray(metas)) {
            metas.filter(m => m.nova).slice(0, 2)
                .forEach(m => aviso("fa-bullseye", "Meta concluída!", m.titulo, 300 + 900 * n++));
        }
    }

    const nativo = window.fetch.bind(window);
    window.fetch = function (entrada, opcoes) {
        const url = typeof entrada === "string" ? entrada : (entrada && entrada.url) || "";
        const metodo = (opcoes && opcoes.method) || (entrada && entrada.method) || "GET";
        const promessa = nativo(entrada, opcoes);
        if (ehRegistro(url, metodo)) {
            promessa.then(r => { if (r && r.ok) setTimeout(darFeedback, 200); }).catch(() => { });
        }
        return promessa;
    };

    if (typeof module !== "undefined" && module.exports) module.exports = { ehRegistro };
})();
