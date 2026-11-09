/* =========================================================
   PERFIL — adicionar/editar peso e altura (com IMC)
   - GET /perfil/me/medidas → { peso (kg), altura (m), imc, classificacaoImc } (nulo = não informado)
   - PUT /perfil/me/medidas → mesmo formato; cria o perfil se ainda não existir
   Na tela fica só um campo com o resumo; ao clicar abre o modal com peso, altura e IMC
   (o IMC atualiza enquanto digita, com a barra colorida das faixas e o "?" explicando a conta).
   Arquivo separado do perfil.js (de outro integrante) para não mexer nele.
   ========================================================= */

(function () {

    const $ = (id) => document.getElementById(id);

    const modal = $("modalMedidas");
    const form = $("formMedidas");
    const pesoInput = $("pesoInput");
    const alturaInput = $("alturaInput");
    const erro = $("medidasErro");
    const btnSalvar = $("btnSalvarMedidas");

    if (!modal || !form) {
        return;
    }

    let medidas = { peso: null, altura: null, imc: null, classificacaoImc: null };

    // Faixas da OMS para adultos — mesmas do MedidasCalculator (back-end).
    // [classe CSS, texto, IMC inicial e final usados para posicionar o marcador na barra]
    const FAIXAS = [
        { classe: "abaixo",    texto: "Abaixo do peso", de: 15,   ate: 18.5 },
        { classe: "adequado",  texto: "Peso adequado",  de: 18.5, ate: 25 },
        { classe: "sobrepeso", texto: "Sobrepeso",      de: 25,   ate: 30 },
        { classe: "obesidade", texto: "Obesidade",      de: 30,   ate: 40 }
    ];

    // ------------------------------------------------------------------ API

    function obterToken() {
        try {
            return sessionStorage.getItem("jwtToken");
        } catch (e) {
            return null;
        }
    }

    async function api(metodo, corpo) {
        const token = obterToken();
        if (!token) {
            throw new Error("Entre na sua conta para salvar suas medidas.");
        }
        const resposta = await fetch("/perfil/me/medidas", {
            method: metodo,
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + token
            },
            body: corpo ? JSON.stringify(corpo) : undefined
        });

        let dados = null;
        try {
            dados = await resposta.json();
        } catch (e) {
            dados = null;
        }

        if (resposta.status === 401 || resposta.status === 403) {
            throw new Error("Sua sessão expirou. Entre novamente.");
        }
        if (!resposta.ok) {
            throw new Error(dados && dados.message ? dados.message : "Não foi possível salvar suas medidas.");
        }
        return dados;
    }

    function avisar(texto, tipo) {
        if (typeof window.exibirMensagem === "function") {
            window.exibirMensagem(texto, tipo);
        }
    }

    // ------------------------------------------------------------------ contas e formatação

    function numeroBR(valor, casas) {
        return Number(valor).toLocaleString("pt-BR", {
            minimumFractionDigits: casas,
            maximumFractionDigits: casas
        });
    }

    function formatarPeso(peso) {
        return numeroBR(peso, Number.isInteger(peso) ? 0 : 1) + " kg";
    }

    /** IMC = peso ÷ (altura × altura), com 1 casa — igual ao back-end. */
    function calcularImc(peso, altura) {
        if (!peso || !altura) return null;
        return Math.round(peso / (altura * altura) * 10) / 10;
    }

    function faixaDo(imc) {
        if (imc === null) return null;
        if (imc < 18.5) return FAIXAS[0];
        if (imc < 25) return FAIXAS[1];
        if (imc < 30) return FAIXAS[2];
        return FAIXAS[3];
    }

    /** Posição do marcador (0–100%): cada faixa ocupa 1/4 da barra. */
    function posicaoMarcador(imc, faixa) {
        const indice = FAIXAS.indexOf(faixa);
        const dentro = Math.min(Math.max((imc - faixa.de) / (faixa.ate - faixa.de), 0), 1);
        return (indice + dentro) * 25;
    }

    // ------------------------------------------------------------------ campo único na tela

    function renderizarResumo() {
        const temPeso = medidas.peso !== null && medidas.peso !== undefined;
        const temAltura = medidas.altura !== null && medidas.altura !== undefined;
        const partes = [];
        if (temPeso) partes.push(formatarPeso(medidas.peso));
        if (temAltura) partes.push(numeroBR(medidas.altura, 2) + " m");
        if (medidas.imc !== null && medidas.imc !== undefined) {
            partes.push("IMC " + numeroBR(medidas.imc, 1) + " (" + medidas.classificacaoImc + ")");
        }

        $("btnMedidasTitulo").textContent = temPeso || temAltura ? "Peso e altura" : "Adicionar peso e altura";
        $("resumoMedidas").textContent = partes.length
            ? partes.join(" · ")
            : "Toque para informar seu peso e sua altura";
    }

    // ------------------------------------------------------------------ IMC no modal (ao vivo)

    function atualizarImc() {
        const peso = lerNumero(pesoInput);
        const alturaCm = lerNumero(alturaInput);
        const pesoOk = peso !== null && !Number.isNaN(peso) && peso >= 20 && peso <= 350;
        const alturaOk = alturaCm !== null && !Number.isNaN(alturaCm) && alturaCm >= 80 && alturaCm <= 300;
        const altura = alturaOk ? alturaCm / 100 : null;

        const imc = pesoOk && alturaOk ? calcularImc(peso, altura) : null;
        const faixa = faixaDo(imc);
        const bloco = $("imcBloco");
        const marcador = $("imcMarcador");

        FAIXAS.forEach((f) => bloco.classList.remove(f.classe));

        if (faixa) {
            bloco.classList.add(faixa.classe);
            $("imcValor").textContent = numeroBR(imc, 1);
            $("imcFaixa").textContent = faixa.texto;
            marcador.hidden = false;
            marcador.style.left = posicaoMarcador(imc, faixa) + "%";
            $("imcExemplo").textContent = "Com seus dados: " + numeroBR(peso, Number.isInteger(peso) ? 0 : 1)
                + " ÷ (" + numeroBR(altura, 2) + " × " + numeroBR(altura, 2) + ") = "
                + numeroBR(peso, Number.isInteger(peso) ? 0 : 1) + " ÷ " + numeroBR(altura * altura, 2)
                + " = " + numeroBR(imc, 1);
        } else {
            $("imcValor").textContent = "--";
            $("imcFaixa").textContent = "Preencha peso e altura";
            marcador.hidden = true;
            $("imcExemplo").textContent = "Ex.: 75 kg e 1,80 m → 75 ÷ (1,80 × 1,80) = 75 ÷ 3,24 = 23,1";
        }
    }

    function alternarAjuda() {
        const ajuda = $("imcAjuda");
        const btn = $("btnAjudaImc");
        ajuda.hidden = !ajuda.hidden;
        btn.setAttribute("aria-expanded", String(!ajuda.hidden));
    }

    // ------------------------------------------------------------------ sugestões de metas

    // As regras ficam no back-end (SugestoesCalculator); aqui só pedimos a prévia e mostramos.
    let esperaSugestoes = null;
    let pedidoAtual = 0;

    function renderizarSugestoes(lista) {
        const ul = $("sugestoesLista");
        while (ul.firstChild) ul.removeChild(ul.firstChild);
        ul.classList.remove("carregando");

        $("sugestoesVazio").hidden = !!(lista && lista.length);
        (lista || []).forEach((s) => {
            const li = document.createElement("li");
            li.className = "sugestao " + String(s.tipo || "").toLowerCase();

            const icone = document.createElement("span");
            icone.className = "sugestao-icone";
            const i = document.createElement("i");
            i.className = s.icone || "fa-solid fa-bullseye";
            i.setAttribute("aria-hidden", "true");
            icone.appendChild(i);

            const texto = document.createElement("div");
            const titulo = document.createElement("strong");
            titulo.textContent = s.titulo;
            const desc = document.createElement("p");
            desc.textContent = s.descricao;
            texto.appendChild(titulo);
            texto.appendChild(desc);

            li.appendChild(icone);
            li.appendChild(texto);
            ul.appendChild(li);
        });
    }

    /** Pede ao back-end as sugestões para o que está digitado (com uma pequena espera). */
    function atualizarSugestoes() {
        clearTimeout(esperaSugestoes);

        const peso = lerNumero(pesoInput);
        const alturaCm = lerNumero(alturaInput);
        const pesoOk = peso !== null && !Number.isNaN(peso) && peso >= 20 && peso <= 350;
        const alturaOk = alturaCm !== null && !Number.isNaN(alturaCm) && alturaCm >= 80 && alturaCm <= 300;

        if (!pesoOk) {
            pedidoAtual++;
            renderizarSugestoes([]);
            return;
        }

        $("sugestoesLista").classList.add("carregando");
        esperaSugestoes = setTimeout(async () => {
            const meuPedido = ++pedidoAtual;
            const params = new URLSearchParams({ peso: String(Math.round(peso * 10) / 10) });
            if (alturaOk) params.set("altura", String(Math.round(alturaCm) / 100));
            try {
                const token = obterToken();
                const resposta = await fetch("/perfil/me/medidas/previa?" + params.toString(), {
                    headers: { "Authorization": "Bearer " + token }
                });
                if (!resposta.ok) throw new Error("HTTP " + resposta.status);
                const dados = await resposta.json();
                if (meuPedido === pedidoAtual) renderizarSugestoes(dados.sugestoes);
            } catch (e) {
                console.error(e);
                if (meuPedido === pedidoAtual) {
                    renderizarSugestoes([]);
                    $("sugestoesVazio").textContent = "Não foi possível carregar as sugestões agora.";
                }
            }
        }, 350);
    }

    // ------------------------------------------------------------------ modal

    function abrir() {
        esconderErro();
        pesoInput.value = medidas.peso !== null && medidas.peso !== undefined
            ? String(medidas.peso).replace(".", ",") : "";
        alturaInput.value = medidas.altura !== null && medidas.altura !== undefined
            ? String(Math.round(medidas.altura * 100)) : "";
        $("imcAjuda").hidden = true;
        $("btnAjudaImc").setAttribute("aria-expanded", "false");
        atualizarImc();
        // já mostra as sugestões das medidas salvas (vêm junto do GET/PUT)
        $("sugestoesVazio").textContent = "Preencha seu peso (e sua altura) para ver sugestões.";
        pedidoAtual++;
        renderizarSugestoes(medidas.sugestoes || []);
        modal.classList.add("active");
        pesoInput.focus();
    }

    function fechar() {
        modal.classList.remove("active");
    }

    function mostrarErro(texto, campo) {
        erro.textContent = texto;
        erro.hidden = false;
        [pesoInput, alturaInput].forEach((i) => i.classList.toggle("invalido", i === campo));
        if (campo) campo.focus();
    }

    function esconderErro() {
        erro.hidden = true;
        pesoInput.classList.remove("invalido");
        alturaInput.classList.remove("invalido");
    }

    /**
     * Lê o campo (texto com teclado numérico); aceita "72,5" ou "72.5".
     * Vazio → null; qualquer outra coisa (letras, "1.2.3") → NaN, para mostrar erro
     * em vez de salvar em branco sem avisar.
     */
    function lerNumero(input) {
        const texto = String(input.value || "").trim();
        if (texto === "") {
            return null;
        }
        if (!/^\d{1,3}([.,]\d{1,2})?$/.test(texto)) {
            return NaN;
        }
        return Number(texto.replace(",", "."));
    }

    async function salvar(ev) {
        ev.preventDefault();
        esconderErro();

        const peso = lerNumero(pesoInput);
        const alturaCm = lerNumero(alturaInput);

        // Mesmas regras do MedidasCalculator, só para avisar antes de enviar.
        if (peso !== null && (Number.isNaN(peso) || peso < 20 || peso > 350)) {
            mostrarErro("O peso deve estar entre 20 e 350 kg.", pesoInput);
            return;
        }
        if (alturaCm !== null && (Number.isNaN(alturaCm) || alturaCm < 80 || alturaCm > 300)) {
            mostrarErro("A altura deve estar entre 80 e 300 cm.", alturaInput);
            return;
        }

        const corpo = {
            peso: peso === null ? null : Math.round(peso * 10) / 10,
            altura: alturaCm === null ? null : Math.round(alturaCm) / 100
        };

        btnSalvar.disabled = true;
        try {
            medidas = await api("PUT", corpo);
            renderizarResumo();
            fechar();
            avisar("Medidas salvas com sucesso!", "sucesso");
        } catch (e) {
            mostrarErro(e.message, null);
        } finally {
            btnSalvar.disabled = false;
        }
    }

    async function carregar() {
        if (obterToken()) {
            try {
                medidas = await api("GET");
            } catch (e) {
                console.error(e);
            }
        }
        renderizarResumo();
    }

    // ------------------------------------------------------------------ eventos

    $("btnEditarMedidas").addEventListener("click", abrir);
    $("btnFecharMedidas").addEventListener("click", fechar);
    $("btnCancelarMedidas").addEventListener("click", fechar);
    $("btnAjudaImc").addEventListener("click", alternarAjuda);
    form.addEventListener("submit", salvar);
    [pesoInput, alturaInput].forEach((i) => i.addEventListener("input", () => {
        esconderErro();
        atualizarImc();
        $("sugestoesVazio").textContent = "Preencha seu peso (e sua altura) para ver sugestões.";
        atualizarSugestoes();
    }));

    // fecha ao clicar no fundo escuro ou apertar Esc
    modal.addEventListener("click", (ev) => {
        if (ev.target === modal) fechar();
    });
    document.addEventListener("keydown", (ev) => {
        if (ev.key === "Escape" && modal.classList.contains("active")) fechar();
    });

    carregar();

})();
