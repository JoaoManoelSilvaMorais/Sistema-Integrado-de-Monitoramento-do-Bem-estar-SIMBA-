(function configurarNotificacoes() {
    const btnNotificacao = document.getElementById("btnNotificacao");
    const dropdown = document.getElementById("dropdown-notificacoes");
    const lista = document.getElementById("dropdown-lista");
    const badge = document.getElementById("badge-notificacao");

    if (!btnNotificacao || !dropdown || !lista || !badge) {
        return;
    }

    let carregando = false;
    let recarregarDepois = false;

    function obterToken() {
        try {
            return sessionStorage.getItem("jwtToken");
        } catch (erro) {
            return null;
        }
    }

    function formatarHorario(horario) {
        const data = new Date(horario);
        if (Number.isNaN(data.getTime())) {
            return "Horário inválido";
        }
        return data.toLocaleString("pt-BR", {
            day: "2-digit",
            month: "2-digit",
            hour: "2-digit",
            minute: "2-digit"
        });
    }

    function atualizarBadge(total) {
        badge.textContent = total > 99 ? "99+" : String(total);
        badge.style.display = total > 0 ? "block" : "none";
    }

    function mostrarVazio(mensagem) {
        const vazio = document.createElement("div");
        vazio.className = "dropdown-empty";
        vazio.textContent = mensagem;
        lista.replaceChildren(vazio);
    }

    function abrirLembretes() {
        window.location.href = "lembretes.html";
    }

    function criarItem(lembrete) {
        const item = document.createElement("div");
        item.className = "dropdown-item";
        item.setAttribute("role", "button");
        item.setAttribute("tabindex", "0");

        const titulo = document.createElement("span");
        titulo.className = "dropdown-item-title";

        const marcador = document.createElement("span");
        marcador.className = "dropdown-item-dot";
        marcador.setAttribute("aria-hidden", "true");
        marcador.textContent = "●";

        titulo.append(marcador, document.createTextNode(lembrete.titulo || "Lembrete"));

        const horario = document.createElement("span");
        horario.className = "dropdown-item-time";
        horario.textContent = formatarHorario(lembrete.horario);

        item.append(titulo, horario);
        item.addEventListener("click", abrirLembretes);
        item.addEventListener("keydown", evento => {
            if (evento.key === "Enter" || evento.key === " ") {
                evento.preventDefault();
                abrirLembretes();
            }
        });

        return item;
    }

    function renderizar(lembretes) {
        const futuros = lembretes
            .filter(lembrete => {
                const data = new Date(lembrete.horario);
                return !Number.isNaN(data.getTime()) && data.getTime() >= Date.now();
            })
            .sort((a, b) => new Date(a.horario) - new Date(b.horario));

        atualizarBadge(futuros.length);

        if (futuros.length === 0) {
            mostrarVazio("Não tem novas notificações");
            return;
        }

        lista.replaceChildren(...futuros.map(criarItem));
    }

    async function carregar() {
        if (carregando) {
            recarregarDepois = true;
            return;
        }

        const token = obterToken();
        if (!token) {
            atualizarBadge(0);
            mostrarVazio("Entre para ver suas notificações.");
            return;
        }

        carregando = true;

        try {
            const resposta = await fetch("/lembretes", {
                headers: { Authorization: `Bearer ${token}` }
            });

            if (resposta.status === 401 || resposta.status === 403) {
                atualizarBadge(0);
                mostrarVazio("Sessão expirada. Entre novamente.");
                return;
            }

            if (!resposta.ok) {
                throw new Error("Não foi possível carregar as notificações.");
            }

            const lembretes = await resposta.json();
            renderizar(Array.isArray(lembretes) ? lembretes : []);
        } catch (erro) {
            atualizarBadge(0);
            mostrarVazio("Não foi possível carregar as notificações.");
        } finally {
            carregando = false;
            if (recarregarDepois) {
                recarregarDepois = false;
                carregar();
            }
        }
    }

    function alternarDropdown(abrir) {
        const vaiAbrir = typeof abrir === "boolean"
            ? abrir
            : !dropdown.classList.contains("show");

        dropdown.classList.toggle("show", vaiAbrir);
        btnNotificacao.setAttribute("aria-expanded", String(vaiAbrir));

        if (vaiAbrir) {
            carregar();
        }
    }

    btnNotificacao.addEventListener("click", evento => {
        evento.stopPropagation();
        alternarDropdown();
    });

    document.addEventListener("click", evento => {
        if (!dropdown.classList.contains("show")) {
            return;
        }
        if (!dropdown.contains(evento.target) && !btnNotificacao.contains(evento.target)) {
            alternarDropdown(false);
        }
    });

    document.addEventListener("keydown", evento => {
        if (evento.key === "Escape" && dropdown.classList.contains("show")) {
            alternarDropdown(false);
            btnNotificacao.focus();
        }
    });

    document.addEventListener("simba:lembretes-atualizados", () => carregar());

    document.addEventListener("visibilitychange", () => {
        if (!document.hidden) {
            carregar();
        }
    });

    window.SimbaNotificacoes = {
        atualizar: () => carregar()
    };

    carregar();
})();
