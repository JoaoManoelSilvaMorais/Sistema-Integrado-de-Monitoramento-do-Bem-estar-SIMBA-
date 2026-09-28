const btnOutroValor =
    document.getElementById("btnOutroValor");

const modalOverlay =
    document.getElementById("modalOverlay");

const btnFecharModal =
    document.getElementById("btnFecharModal");

const btnCancelar =
    document.getElementById("btnCancelar");

const formHidratacao =
    document.getElementById("formHidratacao");

const listaHidratacao =
    document.getElementById("listaHidratacao");

const hidratacaoVazio =
    document.getElementById("hidratacaoVazio");

const tituloModal =
    document.getElementById("tituloModal");

const registroAguaId =
    document.getElementById("registroAguaId");

const quantidadeMl =
    document.getElementById("quantidadeMl");

const dataHora =
    document.getElementById("dataHora");


/*
    Meta temporária do front-end.

    Depois, quando vocês adicionarem metaAguaMl ao PerfilModel,
    este valor pode vir do backend.
*/
const META_DIARIA_ML = 3000;


/*
    Mantém a mesma abordagem da tela de Treinos:
    o front salva localmente enquanto o backend da funcionalidade
    ainda não estiver conectado.

    O id é numérico para ficar compatível com Long no Java.
*/
let registrosAgua = [];


let diaAberto = null;


/* =========================================================
   MODAL
   ========================================================= */

function abrirModal() {

    formHidratacao.reset();

    registroAguaId.value = "";

    tituloModal.textContent =
        "Registrar água";

    definirDataAtual();

    modalOverlay.classList.add("active");

}


function fecharModal() {

    modalOverlay.classList.remove("active");

}


function definirDataAtual() {

    const agora = new Date();

    const ano =
        agora.getFullYear();

    const mes =
        String(agora.getMonth() + 1)
        .padStart(2, "0");

    const dia =
        String(agora.getDate())
        .padStart(2, "0");

    const hora =
        String(agora.getHours())
        .padStart(2, "0");

    const minuto =
        String(agora.getMinutes())
        .padStart(2, "0");

    dataHora.value =
        `${ano}-${mes}-${dia}T${hora}:${minuto}`;

}


/* =========================================================
   ID NUMÉRICO (COMPATÍVEL COM Long)
   ========================================================= */

function gerarLongId() {

    const maiorId =
        registrosAgua.reduce(

            (maior, registro) =>
                Math.max(
                    maior,
                    Number(registro.id) || 0
                ),

            0

        );

    return Math.max(
        Date.now(),
        maiorId + 1
    );

}


/* =========================================================
   SALVAR / EDITAR
   ========================================================= */

formHidratacao.addEventListener(

    "submit",

    async function(event) {

        event.preventDefault();

        const registro = {
            quantidadeMl: Number(quantidadeMl.value),
            dataHora: dataHora.value
        };

        try {
            const url = registroAguaId.value
                ? `/registroAgua/${registroAguaId.value}`
                : "/registroAgua";
            const resposta = await fetch(url, {
                method: registroAguaId.value ? "PUT" : "POST",
                headers: headersAutenticacao(),
                body: JSON.stringify(registro)
            });
            verificarResposta(resposta);
            diaAberto = obterChaveData(registro.dataHora);
            fecharModal();
            await carregarRegistrosAgua();
        } catch (erro) {
            alert(erro.message);
        }

    }

);


function editarRegistroAgua(id) {

    const registro =
        registrosAgua.find(

            item =>
                Number(item.id) ===
                Number(id)

        );


    if (!registro) {
        return;
    }


    registroAguaId.value =
        registro.id;

    quantidadeMl.value =
        registro.quantidadeMl;

    dataHora.value =
        String(registro.dataHora).slice(0, 16);


    tituloModal.textContent =
        "Editar registro";


    modalOverlay.classList.add("active");

}


async function excluirRegistroAgua(id) {

    const confirmar =
        confirm(
            "Deseja realmente excluir este registro de água?"
        );


    if (!confirmar) {
        return;
    }


    try {
        const resposta = await fetch(`/registroAgua/${id}`, {
            method: "DELETE",
            headers: headersAutenticacao()
        });
        verificarResposta(resposta);
        await carregarRegistrosAgua();
    } catch (erro) {
        alert(erro.message);
    }

}


/* =========================================================
   ADIÇÃO RÁPIDA
   ========================================================= */

async function adicionarAguaRapido(valor) {

    const agora =
        new Date();

    const registro = {
        quantidadeMl: Number(valor),
        dataHora: formatarDataHoraInput(agora)
    };

    try {
        const resposta = await fetch("/registroAgua", {
            method: "POST",
            headers: headersAutenticacao(),
            body: JSON.stringify(registro)
        });
        verificarResposta(resposta);
        diaAberto = obterChaveData(registro.dataHora);
        await carregarRegistrosAgua();
    } catch (erro) {
        alert(erro.message);
    }

}


document
    .querySelectorAll(".btn-agua-rapido")
    .forEach(

        botao => {

            botao.addEventListener(

                "click",

                () => {

                    adicionarAguaRapido(
                        Number(
                            botao.dataset.quantidade
                        )
                    );

                }

            );

        }

    );


/* =========================================================
   LOCAL STORAGE
   ========================================================= */

/* =========================================================
   DATAS
   ========================================================= */

function formatarDataHoraInput(data) {

    const ano =
        data.getFullYear();

    const mes =
        String(data.getMonth() + 1)
        .padStart(2, "0");

    const dia =
        String(data.getDate())
        .padStart(2, "0");

    const hora =
        String(data.getHours())
        .padStart(2, "0");

    const minuto =
        String(data.getMinutes())
        .padStart(2, "0");


    return (
        `${ano}-${mes}-${dia}` +
        `T${hora}:${minuto}`
    );

}


function obterChaveData(dataHoraRegistro) {

    return String(
        dataHoraRegistro
    ).substring(0, 10);

}


function criarDataLocal(chaveData) {

    const partes =
        chaveData
            .split("-")
            .map(Number);


    return new Date(
        partes[0],
        partes[1] - 1,
        partes[2]
    );

}


function obterChaveHoje() {

    const hoje =
        new Date();


    return (
        `${hoje.getFullYear()}-` +
        `${String(hoje.getMonth() + 1).padStart(2, "0")}-` +
        `${String(hoje.getDate()).padStart(2, "0")}`
    );

}


function formatarHora(dataHoraRegistro) {

    const data =
        new Date(
            dataHoraRegistro
        );


    return data.toLocaleTimeString(

        "pt-BR",

        {
            hour: "2-digit",
            minute: "2-digit"
        }

    );

}


function formatarDataCard(chaveData) {

    const data =
        criarDataLocal(
            chaveData
        );


    const hoje =
        obterChaveHoje();


    const ontem =
        new Date();

    ontem.setDate(
        ontem.getDate() - 1
    );


    const chaveOntem =
        (
            `${ontem.getFullYear()}-` +
            `${String(ontem.getMonth() + 1).padStart(2, "0")}-` +
            `${String(ontem.getDate()).padStart(2, "0")}`
        );


    const dataCurta =
        data.toLocaleDateString(

            "pt-BR",

            {
                day: "2-digit",
                month: "2-digit"
            }

        );


    if (chaveData === hoje) {

        return `Hoje, ${dataCurta}`;

    }


    if (chaveData === chaveOntem) {

        return `Ontem, ${dataCurta}`;

    }


    return data.toLocaleDateString(

        "pt-BR",

        {
            weekday: "long",
            day: "2-digit",
            month: "2-digit"
        }

    );

}


/* =========================================================
   CÁLCULOS
   ========================================================= */

function calcularPorcentagem(total) {
    if (!Number(total)) {
        return 0;
    }

    return Math.round(
        (Number(total) / META_DIARIA_ML) * 100
    );
}

function totalDoDia(chaveData) {

    return registrosAgua

        .filter(

            registro =>
                obterChaveData(
                    registro.dataHora
                ) ===
                chaveData

        )

        .reduce(

            (total, registro) =>
                total +
                Number(
                    registro.quantidadeMl
                ),

            0

        );

}


/* =========================================================
   RESUMO DE HOJE
   ========================================================= */

function atualizarResumoHoje() {

    const hoje =
        obterChaveHoje();


    const totalHoje =
        totalDoDia(
            hoje
        );


    const porcentagem =
        calcularPorcentagem(
            totalHoje
        );


    document
        .getElementById("quantidadeHoje")
        .textContent =
            totalHoje.toLocaleString(
                "pt-BR"
            );


    document
        .getElementById("metaHoje")
        .textContent =
            META_DIARIA_ML.toLocaleString(
                "pt-BR"
            );


    document
        .getElementById("porcentagemHoje")
        .textContent =
            `${porcentagem}%`;


    document
        .getElementById("circuloHoje")
        .style
        .setProperty(
            "--progresso",
            Math.min(
                porcentagem,
                100
            )
        );

}


/* =========================================================
   ÚLTIMOS 7 DIAS
   ========================================================= */

function atualizarGraficoSemanal() {

    const hoje =
        new Date();

    hoje.setHours(
        0,
        0,
        0,
        0
    );


    const dias =
        [];


    for (
        let i = 6;
        i >= 0;
        i--
    ) {

        const data =
            new Date(
                hoje
            );

        data.setDate(
            hoje.getDate() - i
        );


        const chave =
            (
                `${data.getFullYear()}-` +
                `${String(data.getMonth() + 1).padStart(2, "0")}-` +
                `${String(data.getDate()).padStart(2, "0")}`
            );


        dias.push({

            data: data,

            chave: chave,

            total:
                totalDoDia(
                    chave
                )

        });

    }


    const totalSemana =
        dias.reduce(

            (soma, dia) =>
                soma + dia.total,

            0

        );


    const media =
        Math.round(
            totalSemana /
            dias.length
        );


    const diasMeta =
        dias.filter(

            dia =>
                dia.total >=
                META_DIARIA_ML

        ).length;


    document
        .getElementById("mediaSemanal")
        .textContent =
            `${media.toLocaleString("pt-BR")} ml`;


    document
        .getElementById("diasMetaAtingida")
        .textContent =
            `${diasMeta}/7 dias`;


    const maiorValor =
        Math.max(

            META_DIARIA_ML,

            ...dias.map(
                dia => dia.total
            ),

            1

        );


    document
        .getElementById("graficoMaximo")
        .textContent =
            `${maiorValor.toLocaleString("pt-BR")} ml`;


    const largura =
        700;

    const topo =
        28;

    const base =
        192;

    const altura =
        base - topo;

    const distancia =
        largura /
        (dias.length - 1);


    const pontos =
        dias.map(

            (dia, indice) => {

                const x =
                    indice *
                    distancia;

                const proporcao =
                    dia.total /
                    maiorValor;

                const y =
                    base -
                    (
                        proporcao *
                        altura
                    );


                return {

                    ...dia,

                    x:
                        Number(
                            x.toFixed(2)
                        ),

                    y:
                        Number(
                            y.toFixed(2)
                        )

                };

            }

        );


    const textoPontos =
        pontos

            .map(

                ponto =>
                    `${ponto.x},${ponto.y}`

            )

            .join(" ");


    document
        .getElementById("linhaGrafico")
        .setAttribute(
            "points",
            textoPontos
        );


    document
        .getElementById("areaGrafico")
        .setAttribute(

            "points",

            (
                `0,${base} ` +
                `${textoPontos} ` +
                `${largura},${base}`
            )

        );


    document
        .getElementById("pontosGrafico")
        .innerHTML =

            pontos

                .map(

                    ponto => `

                        <circle
                            class="ponto-grafico"
                            cx="${ponto.x}"
                            cy="${ponto.y}"
                            r="6"
                        >
                            <title>
                                ${ponto.data.toLocaleDateString("pt-BR")}:
                                ${ponto.total.toLocaleString("pt-BR")} ml
                            </title>
                        </circle>

                    `

                )

                .join("");


    document
        .getElementById("graficoDias")
        .innerHTML =

            dias

                .map(

                    dia => {

                        const nomeDia =
                            dia.data

                                .toLocaleDateString(

                                    "pt-BR",

                                    {
                                        weekday: "short"
                                    }

                                )

                                .replace(
                                    ".",
                                    ""
                                );


                        const numeroDia =
                            String(
                                dia.data.getDate()
                            )
                            .padStart(
                                2,
                                "0"
                            );


                        return `

                            <div class="grafico-dia">

                                <strong>
                                    ${nomeDia}
                                </strong>

                                <span>
                                    ${numeroDia}
                                </span>

                            </div>

                        `;

                    }

                )

                .join("");

}


/* =========================================================
   AGRUPAMENTO POR DIA
   ========================================================= */

function agruparRegistrosPorDia() {

    const grupos =
        {};


    registrosAgua.forEach(

        registro => {

            const chave =
                obterChaveData(
                    registro.dataHora
                );


            if (!grupos[chave]) {

                grupos[chave] =
                    [];

            }


            grupos[chave].push(
                registro
            );

        }

    );


    return Object
        .entries(
            grupos
        )
        .map(

            ([chave, registros]) => {

                return {

                    chave: chave,

                    registros: registros,

                    total:
                        registros.reduce(

                            (soma, registro) =>
                                soma +
                                Number(
                                    registro.quantidadeMl
                                ),

                            0

                        )

                };

            }

        )
        .sort(

            (a, b) =>
                b.chave.localeCompare(
                    a.chave
                )

        );

}


/* =========================================================
   ABRIR / FECHAR UM DIA
   ========================================================= */

function alternarDia(chaveData) {

    if (diaAberto === chaveData) {

        diaAberto =
            null;

    } else {

        diaAberto =
            chaveData;

    }


    renderizarRegistros();

}


/*
    O botão de editar do card diário não edita um "dia",
    porque o banco terá vários RegistroAgua naquele dia.

    Então ele abre o histórico daquele dia.
    A edição real acontece em cada lançamento individual.
*/
function editarDia(chaveData) {

    diaAberto =
        chaveData;

    renderizarRegistros();

}


async function excluirDia(chaveData) {

    const registrosDoDia =
        registrosAgua.filter(

            registro =>
                obterChaveData(
                    registro.dataHora
                ) ===
                chaveData

        );


    if (
        registrosDoDia.length === 0
    ) {
        return;
    }


    const confirmar =
        confirm(
            "Deseja realmente excluir todos os registros deste dia?"
        );


    if (!confirmar) {
        return;
    }


    if (
        diaAberto ===
        chaveData
    ) {

        diaAberto =
            null;

    }


    try {
        await Promise.all(
            registrosDoDia.map(registro =>
                fetch(`/registroAgua/${registro.id}`, {
                    method: "DELETE",
                    headers: headersAutenticacao()
                }).then(verificarResposta)
            )
        );
        await carregarRegistrosAgua();
    } catch (erro) {
        alert(erro.message);
    }

}


/* =========================================================
   RENDERIZAÇÃO DOS CARDS
   ========================================================= */

function renderizarRegistros() {

    listaHidratacao.innerHTML =
        "";


    const grupos =
        agruparRegistrosPorDia();


    if (
        grupos.length === 0
    ) {

        hidratacaoVazio.style.display =
            "flex";

        return;

    }


    hidratacaoVazio.style.display =
        "none";


    grupos.forEach(

        grupo => {

            const porcentagem =
                calcularPorcentagem(
                    grupo.total
                );


            const card =
                document.createElement(
                    "article"
                );


            card.classList.add(
                "dia-card"
            );


            if (
                diaAberto ===
                grupo.chave
            ) {

                card.classList.add(
                    "aberto"
                );

            }


            const registrosOrdenados =
                [...grupo.registros]

                    .sort(

                        (a, b) =>
                            new Date(
                                b.dataHora
                            ) -
                            new Date(
                                a.dataHora
                            )

                    );


            card.innerHTML = `

                <div class="dia-card-topo">

                    <button
                        type="button"
                        class="dia-toggle"
                        onclick="alternarDia('${grupo.chave}')"
                    >

                        <div class="dia-data">

                            <i
                                class="fa-regular
                                fa-calendar"
                            ></i>

                            ${formatarDataCard(grupo.chave)}

                            <i
                                class="fa-solid
                                fa-chevron-down
                                chevron-dia"
                            ></i>

                        </div>

                        <div class="dia-total">

                            <strong>
                                ${grupo.total.toLocaleString("pt-BR")} ml
                            </strong>

                            <span>
                                consumidos no dia
                            </span>

                        </div>

                        <div class="dia-meta">

                            <i class="fa-solid fa-droplet"></i>

                            ${porcentagem}% da meta diária
                            ·
                            ${grupo.registros.length}
                            ${grupo.registros.length === 1
                                ? "registro"
                                : "registros"}

                        </div>

                    </button>

                    <div class="dia-lateral">

                        <div
                            class="
                                progresso-circulo
                                progresso-circulo-pequeno
                            "
                            style="
                                --progresso:
                                ${Math.min(porcentagem, 100)}
                            "
                        >

                            <div class="progresso-centro">
                                ${porcentagem}%
                            </div>

                        </div>

                        <div class="dia-acoes">

                            <button
                                class="btn-editar-dia"
                                type="button"
                                title="Ver e editar registros"
                                onclick="editarDia('${grupo.chave}')"
                            >

                                <i class="fa-solid fa-pen"></i>

                            </button>

                            <button
                                class="btn-excluir-dia"
                                type="button"
                                title="Excluir registros do dia"
                                onclick="excluirDia('${grupo.chave}')"
                            >

                                <i class="fa-regular fa-trash-can"></i>

                            </button>

                        </div>

                    </div>

                </div>

                <div class="dia-detalhes">

                    <div class="dia-detalhes-titulo">
                        Registros do dia
                    </div>

                    <div class="lista-registros-dia">

                        ${registrosOrdenados

                            .map(

                                registro => `

                                    <div class="registro-agua">

                                        <div class="registro-agua-icone">

                                            <i
                                                class="fa-solid
                                                fa-droplet"
                                            ></i>

                                        </div>

                                        <span class="registro-agua-hora">

                                            ${formatarHora(registro.dataHora)}

                                        </span>

                                        <strong class="registro-agua-quantidade">

                                            ${Number(registro.quantidadeMl).toLocaleString("pt-BR")} ml

                                        </strong>

                                        <div class="registro-agua-acoes">

                                            <button
                                                class="btn-registro-editar"
                                                type="button"
                                                title="Editar registro"
                                                onclick="editarRegistroAgua(${Number(registro.id)})"
                                            >

                                                <i class="fa-solid fa-pen"></i>

                                            </button>

                                            <button
                                                class="btn-registro-excluir"
                                                type="button"
                                                title="Excluir registro"
                                                onclick="excluirRegistroAgua(${Number(registro.id)})"
                                            >

                                                <i class="fa-regular fa-trash-can"></i>

                                            </button>

                                        </div>

                                    </div>

                                `

                            )

                            .join("")}

                    </div>

                </div>

            `;


            listaHidratacao.appendChild(
                card
            );

        }

    );

}


/* =========================================================
   RENDER GERAL
   ========================================================= */

function renderizarHidratacao() {

    atualizarResumoHoje();

    atualizarGraficoSemanal();

    renderizarRegistros();

}


/* =========================================================
   EVENTOS DO MODAL
   ========================================================= */

btnOutroValor.addEventListener(

    "click",

    abrirModal

);


btnFecharModal.addEventListener(

    "click",

    fecharModal

);


btnCancelar.addEventListener(

    "click",

    fecharModal

);


modalOverlay.addEventListener(

    "click",

    function(event) {

        if (
            event.target ===
            modalOverlay
        ) {

            fecharModal();

        }

    }

);


document.addEventListener(

    "keydown",

    function(event) {

        if (
            event.key ===
            "Escape"
        ) {

            fecharModal();

        }

    }

);


/* =========================================================
   LOGIN / USUÁRIO
   Mesma integração usada em treinos.js
   ========================================================= */

const token =
    sessionStorage.getItem("jwtToken");

function headersAutenticacao() {
    return {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    };
}

function verificarResposta(response) {
    if (response.status === 401) {
        sessionStorage.removeItem("jwtToken");
        sessionStorage.removeItem("usuarioLogado");
        window.location.href = "entrar.html";
        throw new Error("Sua sessão expirou. Entre novamente.");
    }
    if (response.status === 403) {
        throw new Error("Você não tem permissão para alterar este registro.");
    }
    if (!response.ok) {
        throw new Error("Não foi possível salvar o registro de água.");
    }
    return response;
}

async function carregarRegistrosAgua() {
    if (!token) {
        return;
    }

    const response = await fetch("/registroAgua", {
        headers: headersAutenticacao()
    });
    verificarResposta(response);
    registrosAgua = await response.json();
    renderizarHidratacao();
}


if (token) {

    document
        .getElementById("loginButton")
        .style.display =
            "none";


    fetch("/users/me", {

        headers: {

            "Authorization":
                `Bearer ${token}`

        }

    })

    .then(response => {

        if (!response.ok) {

            throw new Error(
                `HTTP ${response.status}`
            );

        }

        return response.json();

    })

    .then(usuario => {

        const nome =
            usuario.name ||
            usuario.username ||
            "U";


        document
            .getElementById("avatarUsuario")
            .textContent =
                nome
                    .charAt(0)
                    .toUpperCase();

    })

    .then(() => carregarRegistrosAgua())
    .catch(() => {

        sessionStorage.removeItem(
            "jwtToken"
        );

        sessionStorage.removeItem(
            "usuarioLogado"
        );

    });

}


document
    .getElementById("sair")
    .addEventListener(

        "click",

        () => {

            sessionStorage.removeItem(
                "jwtToken"
            );

            sessionStorage.removeItem(
                "usuarioLogado"
            );

        }

    );


/* =========================================================
   INICIALIZAÇÃO
   ========================================================= */

if (!token) {
    renderizarHidratacao();
}
