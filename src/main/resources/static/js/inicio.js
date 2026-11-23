/*
 * Animações da página de apresentação (inicio.html).
 * Usa o mesmo leão em SVG do app (js/streak.js → window.SimbaLeao).
 * Com "reduzir movimento" ligado no sistema, tudo aparece no estado final, sem animar.
 */
(function () {
    "use strict";

    const $ = id => document.getElementById(id);
    const calmo = window.matchMedia && window.matchMedia("(prefers-reduced-motion: reduce)").matches;
    const temObservador = "IntersectionObserver" in window;
    const leaoSVG = humor => (typeof window.SimbaLeao === "function" ? window.SimbaLeao(humor) : "");

    // ------------------------------------------------------------ quem já entrou vê "Abrir o SIMBA"
    let logado = false;
    try { logado = !!sessionStorage.getItem("jwtToken"); } catch (e) { /* sem armazenamento */ }
    if (logado) {
        document.querySelectorAll('a[href="entrar.html"]').forEach(a => a.remove());
        document.querySelectorAll('a[href="login.html"]').forEach(a => {
            a.setAttribute("href", "index.html");
            a.textContent = "Abrir o SIMBA";
        });
    }

    // ------------------------------------------------------------ topo ganha fundo ao rolar
    const topo = $("topo");
    const marcarTopo = () => topo.classList.toggle("rolou", window.scrollY > 24);
    window.addEventListener("scroll", marcarTopo, { passive: true });
    marcarTopo();

    // ------------------------------------------------------------ avisos do app saindo do celular, um de cada vez
    const avisos = [...$("avisos").children];
    if (!calmo) {
        let atual = -1;
        const proximo = () => {
            if (atual >= 0) {
                const velho = avisos[atual];
                velho.classList.remove("ativo");
                velho.classList.add("saindo");
                setTimeout(() => velho.classList.remove("saindo"), 500);
            }
            atual = (atual + 1) % avisos.length;
            avisos[atual].classList.add("ativo");
        };
        setTimeout(() => { proximo(); setInterval(proximo, 3200); }, 1500);
    }

    // ------------------------------------------------------------ leão da noite
    $("leaoNoite").innerHTML = leaoSVG("rei");

    // ------------------------------------------------------------ revelar ao rolar
    const revelar = document.querySelectorAll(".revelar");
    const mesa = $("mesa");
    if (calmo || !temObservador) {
        revelar.forEach(el => el.classList.add("visivel"));
        mesa.classList.add("junto");
    } else {
        const obs = new IntersectionObserver(entradas => {
            entradas.forEach(e => {
                if (!e.isIntersecting) return;
                e.target.classList.add("visivel");
                obs.unobserve(e.target);
            });
        }, { threshold: 0.15, rootMargin: "0px 0px -40px 0px" });
        revelar.forEach(el => obs.observe(el));

        // os "apps espalhados" entram no celular quando a mesa aparece
        new IntersectionObserver((entradas, o) => {
            if (!entradas[0].isIntersecting) return;
            setTimeout(() => mesa.classList.add("junto"), 500);
            o.disconnect();
        }, { threshold: 0.55 }).observe(mesa);
    }

    // ------------------------------------------------------------ um dia no SIMBA: o sol anda no arco e vira lua
    const dia = $("dia");
    const arco = $("arcoSol");
    const astro = $("astro");
    const iconeAstro = astro.querySelector("i");
    const tamanhoArco = arco.getTotalLength();

    function misturar(a, b, t) {
        const x = parseInt(a.slice(1), 16), y = parseInt(b.slice(1), 16);
        const c = s => Math.round(((x >> s) & 255) + (((y >> s) & 255) - ((x >> s) & 255)) * t);
        return "rgb(" + c(16) + "," + c(8) + "," + c(0) + ")";
    }

    function moverSol() {
        const r = dia.getBoundingClientRect();
        const vh = window.innerHeight;
        // 0 quando a seção entra por baixo da tela, 1 quando está saindo por cima
        const p = Math.min(1, Math.max(0, (vh - r.top) / (r.height + vh * 0.4)));
        const ponto = arco.getPointAtLength(p * tamanhoArco);
        const caixa = arco.ownerSVGElement.getBoundingClientRect();
        astro.style.left = (ponto.x / 1000) * caixa.width + "px";
        astro.style.top = (ponto.y / 200) * caixa.height + "px";
        const noite = p > 0.78;
        astro.classList.toggle("lua-fase", noite);
        iconeAstro.className = noite ? "fa-solid fa-moon" : "fa-solid fa-sun";
        // o céu da seção fica mais quente no fim do dia
        dia.style.backgroundColor = misturar("#fbf1e3", "#f6d3ad", p);
    }

    if (calmo) {
        moverSol();
    } else {
        let pedido = false;
        const agendar = () => {
            if (pedido) return;
            pedido = true;
            requestAnimationFrame(() => { pedido = false; moverSol(); });
        };
        window.addEventListener("scroll", agendar, { passive: true });
        window.addEventListener("resize", agendar);
        moverSol();
    }

    // ------------------------------------------------------------ ofensiva: contador de 0 a 27 com o leão mudando
    const FINAL = 27;
    const leao = $("contadorLeao");
    const numero = $("contadorDias");
    const unidade = $("contadorUnidade");
    const humor = $("contadorHumor");
    const pegadas = [...$("pegadas").children];
    const fases = [...$("fases").children];
    let humorAtual = "";

    // mesmas faixas do js/streak.js
    function fase(dias) {
        if (dias === 0) return ["inicio", "Começando"];
        if (dias < 7) return ["feliz", "Feliz"];
        if (dias < 30) return ["animado", "Animado"];
        return ["rei", "Rei da savana"];
    }

    function mostrar(dias) {
        numero.textContent = dias;
        unidade.textContent = dias === 1 ? "dia" : "dias";
        const [h, texto] = fase(dias);
        if (h !== humorAtual) {
            humorAtual = h;
            leao.innerHTML = leaoSVG(h); // SVG do próprio app, sem dado do usuário
            humor.textContent = texto;
            fases.forEach(f => f.classList.toggle("atual", f.dataset.fase === h));
            if (!calmo) {
                leao.classList.remove("pulo");
                void leao.offsetWidth; // reinicia a animação
                leao.classList.add("pulo");
            }
        }
        // as pegadas são os últimos 7 dias da sequência
        pegadas.forEach((p, i) => p.classList.toggle("cheia", dias >= FINAL - 6 + i));
    }

    let contando = false;
    function contar() {
        if (contando) return;
        contando = true;
        let d = 0;
        mostrar(0);
        const passo = () => {
            d++;
            mostrar(d);
            if (d < FINAL) setTimeout(passo, d < 7 ? 150 : 70);
            else contando = false;
        };
        setTimeout(passo, 400);
    }

    if (calmo || !temObservador) {
        mostrar(FINAL);
    } else {
        mostrar(0);
        new IntersectionObserver((entradas, o) => {
            if (!entradas[0].isIntersecting) return;
            contar();
            o.disconnect();
        }, { threshold: 0.5 }).observe($("contador"));
        leao.addEventListener("click", contar); // clicar no leão conta de novo
    }
})();
