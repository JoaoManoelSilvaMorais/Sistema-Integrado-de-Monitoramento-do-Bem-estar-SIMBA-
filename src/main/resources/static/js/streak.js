/*
 * Quadro de STREAK da dashboard: busca /api/streak e mostra o número de dias,
 * um leãozinho em SVG (a expressão muda conforme a situação) e uma frase.
 * Tudo dentro de uma função para não conflitar com as variáveis do index.html.
 */
(function () {
    const COR = {
        fundo: "#fff1de", jubaEscura: "#713b1d", jubaClara: "#8f4c25", gap: "#fff1de",
        rosto: "#f4c58a", focinho: "#fdeccf", orelha: "#e9a15f", tinta: "#4a2410",
        bochecha: "#f08a5d", ouro: "#f5b82e", ouroEscuro: "#e09a1a", agua: "#7cc3e8"
    };

    function estrela(x, y, r, classe) {
        const c = r / 4;
        return `<path class="${classe || ""}" fill="${COR.ouro}" d="M${x} ${y - r} L${x + c} ${y - c} L${x + r} ${y} L${x + c} ${y + c} L${x} ${y + r} L${x - c} ${y + c} L${x - r} ${y} L${x - c} ${y - c}Z"/>`;
    }

    function traco(d, largura) {
        return `<path d="${d}" fill="none" stroke="${COR.tinta}" stroke-width="${largura}" stroke-linecap="round" stroke-linejoin="round"/>`;
    }

    function olho(x, y, r, brilho) {
        return `<circle cx="${x}" cy="${y}" r="${r}" fill="${COR.tinta}"/>`
            + `<circle cx="${x + r * 0.35}" cy="${y - r * 0.35}" r="${r * 0.38}" fill="#fff"/>`
            + (brilho ? `<circle cx="${x - r * 0.4}" cy="${y + r * 0.4}" r="${r * 0.18}" fill="#fff"/>` : "");
    }

    const BOCA_ABERTA = `<path d="M84 135 Q100 160 116 135 Z" fill="${COR.tinta}"/>`
        + `<path d="M92 148 Q100 141 108 148 Q100 156 92 148Z" fill="${COR.bochecha}"/>`;

    // Partes do rosto que mudam de acordo com a emoção.
    const HUMORES = {
        inicio: () =>
            traco("M66 101 Q76 108 86 101", 5) + traco("M114 101 Q124 108 134 101", 5)
            + traco("M92 138 Q100 143 108 138", 4)
            + traco("M157 84 h13 l-13 15 h13", 3.5).replace(COR.tinta, COR.gap)
            + traco("M171 63 h9 l-9 11 h9", 3).replace(COR.tinta, COR.gap),
        triste: () =>
            olho(76, 100, 8.5, true) + olho(124, 100, 8.5, true)
            + traco("M62 90 L88 80", 4.5) + traco("M138 90 L112 80", 4.5)
            + traco("M86 143 Q100 129 114 143", 4)
            + `<path d="M64 108 Q72 120 64 126 Q56 120 64 108Z" fill="${COR.agua}"/>`,
        preocupado: () =>
            olho(76, 99, 8, false) + olho(124, 99, 8, false)
            + traco("M64 91 L88 83", 4.5) + traco("M136 91 L112 83", 4.5)
            + traco("M86 140 Q93 133 100 140 Q107 147 114 140", 4)
            + `<path d="M152 64 Q163 82 152 90 Q141 82 152 64Z" fill="${COR.agua}"/>`,
        medo: () =>
            olho(76, 100, 10.5, true) + olho(124, 100, 10.5, true)
            + traco("M62 82 L88 90", 4.5) + traco("M138 82 L112 90", 4.5)
            + `<ellipse cx="100" cy="143" rx="9" ry="7" fill="${COR.tinta}"/>`
            + `<path d="M150 62 Q161 80 150 88 Q139 80 150 62Z" fill="${COR.agua}"/>`
            + `<path d="M48 70 Q58 86 48 94 Q38 86 48 70Z" fill="${COR.agua}"/>`
            + traco("M30 110 l-8 4 l8 4 l-8 4", 3),
        feliz: () =>
            traco("M66 101 Q76 87 86 101", 5.5) + traco("M114 101 Q124 87 134 101", 5.5)
            + traco("M84 136 Q100 152 116 136", 4.5),
        animado: () =>
            olho(76, 98, 9, false) + olho(124, 98, 9, false)
            + traco("M66 84 Q76 77 86 84", 4) + traco("M114 84 Q124 77 134 84", 4)
            + BOCA_ABERTA
            + estrela(28, 56, 9, "brilho") + estrela(176, 44, 7, "brilho b2") + estrela(170, 150, 6, "brilho b3"),
        rei: () =>
            olho(76, 100, 8.5, false) + olho(124, 100, 8.5, false)
            + `<rect x="66" y="90" width="20" height="9.5" fill="${COR.rosto}"/><rect x="114" y="90" width="20" height="9.5" fill="${COR.rosto}"/>`
            + traco("M66 99.5 H86", 3) + traco("M114 99.5 H134", 3)
            + traco("M64 87 Q76 80 88 85", 4.5) + traco("M136 87 Q124 80 112 85", 4.5)
            + traco("M86 138 Q106 152 120 131", 4.5)
            + estrela(26, 70, 8, "brilho") + estrela(176, 60, 8, "brilho b2")
            + `<g stroke="${COR.jubaEscura}" stroke-width="3.5" stroke-linejoin="round">`
            + `<path d="M70 44 L76 12 L91 30 L100 6 L109 30 L124 12 L130 44 Z" fill="${COR.ouro}"/>`
            + `<rect x="70" y="40" width="60" height="10" rx="3" fill="${COR.ouroEscuro}"/></g>`
            + `<circle cx="100" cy="45" r="2.6" fill="${COR.jubaEscura}"/>`
    };

    function leaoSVG(humor) {
        const partes = HUMORES[humor] || HUMORES.feliz;
        let juba = "";
        for (let i = 0; i < 12; i++) {
            const ang = (i * 30 - 90) * Math.PI / 180;
            juba += `<circle cx="${(100 + 66 * Math.cos(ang)).toFixed(1)}" cy="${(104 + 66 * Math.sin(ang)).toFixed(1)}" r="24"/>`;
        }
        return `<svg class="leao" data-humor="${humor}" viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Leão ${humor}">`
            + `<circle cx="100" cy="100" r="98" fill="${COR.fundo}"/>`
            + `<g fill="${COR.jubaEscura}">${juba}<circle cx="100" cy="104" r="70"/></g>`
            + `<circle cx="100" cy="104" r="60" fill="${COR.jubaClara}"/>`
            + `<circle cx="56" cy="52" r="17" fill="${COR.rosto}"/><circle cx="56" cy="52" r="9" fill="${COR.orelha}"/>`
            + `<circle cx="144" cy="52" r="17" fill="${COR.rosto}"/><circle cx="144" cy="52" r="9" fill="${COR.orelha}"/>`
            + `<ellipse cx="100" cy="108" rx="56" ry="52" fill="${COR.gap}"/>`
            + `<ellipse cx="100" cy="108" rx="52" ry="48" fill="${COR.rosto}"/>`
            + `<ellipse cx="100" cy="129" rx="27" ry="20" fill="${COR.focinho}"/>`
            + `<ellipse cx="66" cy="121" rx="9" ry="6" fill="${COR.bochecha}" opacity=".45"/>`
            + `<ellipse cx="134" cy="121" rx="9" ry="6" fill="${COR.bochecha}" opacity=".45"/>`
            + `<path d="M90 116 h20 q1 9 -10 12 q-11 -3 -10 -12z" fill="${COR.tinta}"/>`
            + traco("M100 127 V134", 3.5)
            + partes()
            + `</svg>`;
    }

    const FRASES = {
        inicio: ["Todo leão começa pequeno. Registre algo hoje!", "Sua ofensiva começa no primeiro registro.", "Que tal começar agora? Um copo d'água já conta!"],
        triste: ["Sua ofensiva zerou, mas todo leão se levanta.", "Recomeçar faz parte. Registre algo hoje!", "Seu recorde foi de {maior} dias. Bora superar?"],
        preocupado: ["Ainda dá tempo! Registre algo hoje.", "Não deixe sua ofensiva de {atual} dias escapar!", "O dia está acabando... um registro já salva a ofensiva."],
        medo: ["Ofensiva em risco! Registre algo hoje para salvá-la.", "Já faltou um dia... não deixe a ofensiva de {atual} dias cair!", "Sem pânico, mas o leão está com medo. Um registro resolve!"],
        ultimaChance: ["ÚLTIMA CHANCE! Registre algo hoje ou a ofensiva de {atual} dias acaba.", "O leão não aguenta mais um dia sem registro. Salve a ofensiva!"],
        pendente: ["Novo dia! Registre algo para manter a ofensiva.", "Sua ofensiva de {atual} dias espera por você hoje."],
        feliz: ["Boa! Mais um dia na conta.", "Ofensiva em andamento, continue assim!", "Hoje já está garantido. Até amanhã!"],
        animado: ["Uma semana ou mais! Você está voando.", "Que ritmo! O leão está orgulhoso.", "{atual} dias seguidos. Isso é constância!"],
        rei: ["Rei da savana! {atual} dias seguidos.", "Lenda! Nem o Mufasa faria melhor.", "Um mês de ofensiva. Respeito total."]
    };

    // Decide a emoção do leão (humor) e o grupo de frases (situacao).
    function situacao(dados, hora) {
        const { atual, maior, ativoHoje } = dados;
        if (dados.emRisco && !ativoHoje) return { humor: "medo", frases: dados.ultimaChance ? "ultimaChance" : "medo" };
        if (atual === 0) return maior === 0
            ? { humor: "inicio", frases: "inicio" }
            : { humor: "triste", frases: "triste" };
        if (!ativoHoje) return hora >= 18
            ? { humor: "preocupado", frases: "preocupado" }
            : { humor: "feliz", frases: "pendente" };
        if (atual >= 30) return { humor: "rei", frases: "rei" };
        if (atual >= 7) return { humor: "animado", frases: "animado" };
        return { humor: "feliz", frases: "feliz" };
    }

    function escolherFrase(grupo, dados, dia) {
        const lista = FRASES[grupo];
        const texto = lista[(dia + dados.atual) % lista.length];
        return texto.replace("{atual}", dados.atual).replace("{maior}", dados.maior);
    }

    function chip(icone, texto) {
        const span = document.createElement("span");
        span.className = "streak-chip";
        const i = document.createElement("i");
        i.className = icone;
        span.append(i, document.createTextNode(" " + texto));
        return span;
    }

    function preencher(dados) {
        const agora = new Date();
        const s = situacao(dados, agora.getHours());

        document.getElementById("streakLeao").innerHTML = leaoSVG(s.humor);
        document.getElementById("streakNumero").textContent = dados.atual;
        document.getElementById("streakUnidade").textContent = dados.atual === 1 ? "dia" : "dias";
        document.getElementById("streakFrase").textContent = escolherFrase(s.frases, dados, agora.getDate());

        const chips = document.getElementById("streakChips");
        chips.replaceChildren();
        if (dados.ativoHoje && dados.atual >= 3 && dados.atual === dados.maior) {
            chips.appendChild(chip("fa-solid fa-trophy", "Novo recorde!"));
        }
        if (dados.emRisco && !dados.ativoHoje) {
            chips.appendChild(chip("fa-solid fa-triangle-exclamation",
                dados.ultimaChance ? "Última chance!" : "Ofensiva em risco (dia " + dados.diaRisco + " de 2)"));
        }
        chips.appendChild(dados.ativoHoje
            ? chip("fa-solid fa-circle-check", "Registrado hoje")
            : chip("fa-regular fa-circle", "Falta registrar hoje"));
        chips.appendChild(chip("fa-solid fa-medal", "Maior sequência: " + dados.maior + (dados.maior === 1 ? " dia" : " dias")));
    }

    function iniciar() {
        const card = document.getElementById("cardStreak");
        if (!card) return;
        const token = sessionStorage.getItem("jwtToken");
        if (!token) { card.hidden = true; return; }

        fetch("/api/streak", { headers: { "Authorization": "Bearer " + token } })
            .then(r => { if (!r.ok) throw new Error("HTTP " + r.status); return r.json(); })
            .then(preencher)
            .catch(() => { card.hidden = true; }); // sem streak, a dashboard continua normal
    }

    if (typeof module !== "undefined" && module.exports) {
        module.exports = { leaoSVG, situacao, escolherFrase, HUMORES, FRASES };
    } else {
        iniciar();
        window.atualizarStreak = iniciar; // a dashboard chama depois do "+250 ml"
    }
})();
