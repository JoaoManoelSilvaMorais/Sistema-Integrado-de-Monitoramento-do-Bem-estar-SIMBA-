/*
 * Tutorial de primeiro uso (dashboard).
 *
 * O leão Simba guia o usuário pelas partes principais do app, destacando cada uma.
 * - Abre sozinho na primeira vez que o usuário entra na dashboard (neste navegador).
 * - Pode ser revisto em Meu perfil → "Rever tutorial" (abre index.html?tutorial=1).
 * - Guarda "já visto" no localStorage, por nome de usuário: simba.tutorial.<username>.
 *
 * Para incluir numa tela: css/tutorial.css + js/tutorial.js (depois de js/streak.js).
 */
(function () {
    "use strict";

    const PASSOS = [
        {
            humor: "feliz",
            titulo: "Oi! Eu sou o Simba",
            texto: "Vou te mostrar o app em menos de 1 minuto. Aqui você cuida da sua água, do seu sono e dos seus treinos, tudo num lugar só."
        },
        {
            alvo: "#cardStreak",
            humor: "animado",
            titulo: "Sua ofensiva",
            texto: "Cada dia em que você registra qualquer coisa conta para a ofensiva. Eu mudo de cara conforme você vai: feliz, animado... e com medo se você sumir!"
        },
        {
            alvo: ".card.welcome",
            humor: "feliz",
            titulo: "Próximo passo",
            texto: "Aqui eu sempre te sugiro uma coisa para fazer agora. É só clicar na sugestão."
        },
        {
            alvo: "#cardHidratacao",
            humor: "feliz",
            titulo: "Registro rápido",
            texto: "Bebeu um copo d'água? Clique em + 250 ml e pronto. A barra mostra quanto falta para a sua meta do dia."
        },
        {
            alvo: ".sidebar nav a[href='hidratacao.html'], .sidebar nav a[href='sono.html'], .sidebar nav a[href='treinos.html'], .sidebar nav a[href='sintomas.html']",
            menu: true,
            humor: "feliz",
            titulo: "Seus registros",
            texto: "Pelo menu você registra água, noites de sono, treinos e como seu corpo está hoje (Sinais Corporais)."
        },
        {
            alvo: ".sidebar nav a[href='rotinas.html'], .sidebar nav a[href='lembretes.html']",
            menu: true,
            humor: "feliz",
            titulo: "Rotinas e lembretes",
            texto: "Crie uma rotina, como \"Treinos\", e coloque lembretes que se repetem nos dias da semana que você escolher."
        },
        {
            alvo: ".sidebar nav a[href='progresso.html'], .sidebar nav a[href='conquistas.html']",
            menu: true,
            humor: "rei",
            titulo: "Progresso e conquistas",
            texto: "Veja seus gráficos, compare com a semana passada, desbloqueie 26 conquistas e crie metas, como \"treinar 5 dias seguidos\"."
        },
        {
            alvo: ".sidebar .bottom-menu a[href='perfil.html']",
            menu: true,
            humor: "feliz",
            titulo: "Meu perfil",
            texto: "Coloque seu peso e sua altura. Com o peso eu calculo a quantidade de água ideal para você."
        },
        {
            humor: "animado",
            titulo: "Tudo pronto!",
            texto: "Que tal começar sua ofensiva agora? Um copo d'água já conta.",
            final: true
        }
    ];

    const MARGEM = 8;          // espaço entre o destaque e o elemento
    const MOBILE = 750;        // mesmo ponto em que o menu lateral some (style.css)

    let indice = 0;
    let raiz, destaque, cartao, elTitulo, elTexto, elLeao, elContador, elPontos, btnVoltar, btnProximo, btnAgua;
    let menuAbertoPeloTutorial = false;

    // ------------------------------------------------------------ armazenamento

    function usuarioAtual() {
        try {
            const u = JSON.parse(sessionStorage.getItem("usuarioLogado") || "null");
            return u && (u.username || u.name) ? (u.username || u.name) : null;
        } catch (e) {
            return null;
        }
    }

    function chave() {
        return "simba.tutorial." + (usuarioAtual() || "anonimo");
    }

    function jaViu() {
        try { return localStorage.getItem(chave()) === "visto"; } catch (e) { return false; }
    }

    function marcarVisto() {
        try { localStorage.setItem(chave(), "visto"); } catch (e) { /* sem armazenamento: tudo bem */ }
    }

    function logado() {
        try { return !!sessionStorage.getItem("jwtToken"); } catch (e) { return false; }
    }

    // ------------------------------------------------------------ montagem

    function criar(tag, classe, texto) {
        const el = document.createElement(tag);
        if (classe) el.className = classe;
        if (texto) el.textContent = texto;
        return el;
    }

    function montar() {
        raiz = criar("div", "tut-raiz");
        raiz.setAttribute("role", "dialog");
        raiz.setAttribute("aria-modal", "true");
        raiz.setAttribute("aria-labelledby", "tutTitulo");

        destaque = criar("div", "tut-destaque");
        cartao = criar("div", "tut-cartao");

        const fechar = criar("button", "tut-fechar");
        fechar.type = "button";
        fechar.setAttribute("aria-label", "Pular tutorial");
        fechar.title = "Pular tutorial";
        fechar.innerHTML = '<i class="fa-solid fa-xmark"></i>';
        fechar.addEventListener("click", encerrar);

        const topo = criar("div", "tut-topo");
        elLeao = criar("div", "tut-leao");
        const textos = criar("div", "tut-textos");
        elContador = criar("span", "tut-contador");
        elTitulo = criar("h2", "tut-titulo");
        elTitulo.id = "tutTitulo";
        elTexto = criar("p", "tut-texto");
        elTexto.setAttribute("aria-live", "polite");
        textos.append(elContador, elTitulo, elTexto);
        topo.append(elLeao, textos);

        elPontos = criar("div", "tut-pontos");
        PASSOS.forEach(() => elPontos.appendChild(criar("span", "tut-ponto")));

        const acoes = criar("div", "tut-acoes");
        const pular = criar("button", "tut-link", "Pular");
        pular.type = "button";
        pular.addEventListener("click", encerrar);

        btnVoltar = criar("button", "tut-btn tut-btn-sec", "Voltar");
        btnVoltar.type = "button";
        btnVoltar.addEventListener("click", () => ir(indice - 1));

        btnAgua = criar("button", "tut-btn");
        btnAgua.type = "button";
        btnAgua.innerHTML = '<i class="fa-solid fa-glass-water"></i> Beber 250 ml agora';
        btnAgua.addEventListener("click", beberAgua);

        btnProximo = criar("button", "tut-btn", "Próximo");
        btnProximo.type = "button";
        btnProximo.addEventListener("click", () => (PASSOS[indice].final ? encerrar() : ir(indice + 1)));

        acoes.append(pular, btnVoltar, btnProximo, btnAgua);
        cartao.append(fechar, topo, elPontos, acoes);
        raiz.append(destaque, cartao);
        document.body.appendChild(raiz);

        document.addEventListener("keydown", teclado);
        window.addEventListener("resize", posicionar);
        window.addEventListener("scroll", posicionar, { passive: true });
    }

    function teclado(ev) {
        if (!raiz) return;
        if (ev.key === "Escape") encerrar();
        else if (ev.key === "ArrowRight" && !PASSOS[indice].final) ir(indice + 1);
        else if (ev.key === "ArrowLeft" && indice > 0) ir(indice - 1);
    }

    function desenharLeao(humor) {
        elLeao.textContent = "";
        if (typeof window.SimbaLeao === "function") {
            elLeao.innerHTML = window.SimbaLeao(humor); // SVG gerado pelo próprio app, sem dado do usuário
        } else {
            const img = criar("img");
            img.src = "img/LeaoLogoPNG.png";
            img.alt = "Simba";
            elLeao.appendChild(img);
        }
    }

    // ------------------------------------------------------------ navegação

    function alvos(passo) {
        if (!passo.alvo) return [];
        return [...document.querySelectorAll(passo.alvo)].filter(el => el.getClientRects().length);
    }

    function telaPequena() {
        return window.innerWidth <= MOBILE;
    }

    function abrirMenu(abrir) {
        const sidebar = document.getElementById("sidebar");
        if (!sidebar || !telaPequena()) return;
        if (abrir && !sidebar.classList.contains("open")) {
            sidebar.classList.add("open");
            menuAbertoPeloTutorial = true;
        } else if (!abrir && menuAbertoPeloTutorial) {
            sidebar.classList.remove("open");
            menuAbertoPeloTutorial = false;
        }
    }

    function ir(novo) {
        if (novo < 0 || novo >= PASSOS.length) return;
        indice = novo;
        const passo = PASSOS[indice];

        abrirMenu(!!passo.menu);
        desenharLeao(passo.humor);
        elContador.textContent = (indice + 1) + " de " + PASSOS.length;
        elTitulo.textContent = passo.titulo;
        elTexto.textContent = passo.texto;
        [...elPontos.children].forEach((p, i) => p.classList.toggle("ativo", i === indice));

        // no passo final o convite para beber água vira o botão principal
        const temAgua = !!passo.final && !!document.getElementById("btnAguaRapida");
        btnVoltar.hidden = indice === 0 || passo.final;
        btnAgua.hidden = !temAgua;
        btnProximo.classList.toggle("tut-btn-sec", temAgua);
        btnProximo.textContent = passo.final ? (temAgua ? "Agora não" : "Começar") : (indice === 0 ? "Vamos lá" : "Próximo");

        const els = alvos(passo);
        if (els.length && !passo.menu) {
            if (telaPequena()) {
                // celular: o cartão fica embaixo, então o elemento sobe para o topo da tela
                const topo = els[0].getBoundingClientRect().top + window.scrollY - 24;
                window.scrollTo({ top: Math.max(0, topo), behavior: "smooth" });
            } else {
                els[0].scrollIntoView({ block: "center", behavior: "smooth" });
            }
            setTimeout(posicionar, 450);
        }
        // o menu do celular desliza em 0,2 s
        setTimeout(posicionar, passo.menu ? 260 : 0);
        posicionar();
        (temAgua ? btnAgua : btnProximo).focus({ preventScroll: true });
    }

    function posicionar() {
        if (!raiz) return;
        const passo = PASSOS[indice];
        const els = alvos(passo);

        if (!els.length) {
            raiz.classList.add("tut-sem-alvo");
            destaque.style.cssText = "";
            cartao.classList.add("tut-centro");
            cartao.classList.remove("tut-rodape");
            cartao.style.top = cartao.style.left = "";
            return;
        }
        raiz.classList.remove("tut-sem-alvo");

        // retângulo que envolve todos os elementos do passo
        const r = els.map(el => el.getBoundingClientRect()).reduce((a, b) => ({
            left: Math.min(a.left, b.left), top: Math.min(a.top, b.top),
            right: Math.max(a.right, b.right), bottom: Math.max(a.bottom, b.bottom)
        }));
        const x = r.left - MARGEM, y = r.top - MARGEM;
        const w = r.right - r.left + MARGEM * 2, h = r.bottom - r.top + MARGEM * 2;
        destaque.style.left = x + "px";
        destaque.style.top = y + "px";
        destaque.style.width = w + "px";
        destaque.style.height = h + "px";

        if (telaPequena()) {
            // no celular o cartão fica fixo embaixo da tela
            cartao.classList.add("tut-centro", "tut-rodape");
            cartao.style.top = cartao.style.left = "";
            return;
        }
        cartao.classList.remove("tut-centro", "tut-rodape");

        const cw = cartao.offsetWidth, ch = cartao.offsetHeight;
        const vw = window.innerWidth, vh = window.innerHeight;
        let top, left;

        if (passo.menu) {
            // menu lateral: cartão à direita do destaque
            left = x + w + 16;
            top = Math.min(Math.max(16, y), vh - ch - 16);
        } else if (y + h + 16 + ch <= vh - 16) {
            top = y + h + 16;                       // embaixo
            left = x;
        } else if (y - 16 - ch >= 16) {
            top = y - 16 - ch;                      // em cima
            left = x;
        } else {
            top = Math.max(16, vh - ch - 16);       // não cabe: canto de baixo
            left = x + w + 16 + cw <= vw ? x + w + 16 : x;
        }
        left = Math.min(Math.max(16, left), vw - cw - 16);
        cartao.style.top = top + "px";
        cartao.style.left = left + "px";
    }

    // ------------------------------------------------------------ ações

    function beberAgua() {
        const botao = document.getElementById("btnAguaRapida");
        encerrar();
        if (botao) botao.click(); // usa o mesmo fluxo do "+ 250 ml" da dashboard (com avisos de ofensiva)
    }

    function iniciar() {
        if (raiz) return;
        montar();
        document.body.classList.add("tut-ativo");
        ir(0);
    }

    function encerrar() {
        marcarVisto();
        abrirMenu(false);
        document.removeEventListener("keydown", teclado);
        window.removeEventListener("resize", posicionar);
        window.removeEventListener("scroll", posicionar);
        document.body.classList.remove("tut-ativo");
        if (raiz) raiz.remove();
        raiz = null;
        // tira o ?tutorial=1 da barra de endereço para não abrir de novo ao recarregar
        if (/[?&]tutorial=1/.test(location.search) && history.replaceState) {
            history.replaceState(null, "", location.pathname);
        }
    }

    // ------------------------------------------------------------ início

    window.SimbaTutorial = {
        iniciar: iniciar,
        // usado em Meu perfil → "Rever tutorial"
        rever: function () {
            try { localStorage.removeItem(chave()); } catch (e) { /* ignora */ }
            location.href = "index.html?tutorial=1";
        }
    };

    const naDashboard = !!document.getElementById("cardStreak");
    if (!naDashboard || !logado()) return;

    const pedido = /[?&]tutorial=1/.test(location.search);
    // navegador controlado por teste automático (Selenium): não abre sozinho para não cobrir a tela
    const automatizado = navigator.webdriver === true;
    if (pedido || (!jaViu() && !automatizado)) {
        // espera a dashboard carregar os dados para os cartões já estarem no tamanho final
        const comecar = () => setTimeout(iniciar, 900);
        if (document.readyState === "complete") comecar();
        else window.addEventListener("load", comecar);
    }
})();
