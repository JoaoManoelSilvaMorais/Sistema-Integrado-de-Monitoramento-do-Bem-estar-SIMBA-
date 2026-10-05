const API_PROGRESSO = "/progresso";

let graficoSono = null;
let graficoHidratacao = null;

let dadosProgresso = null;

// AUTENTICAÇÃO
function obterToken() {
    return sessionStorage.getItem("jwtToken");
}


function headersAutenticacao() {

    const token = obterToken();

    const headers = {
        "Content-Type": "application/json"
    };

    if (token) {
        headers["Authorization"] =
            `Bearer ${token}`;
    }

    return headers;
}

// USUÁRIO
async function carregarUsuario() {

    const token = obterToken();

    if (!token) {

        exibirMensagem(
            "Faça login para visualizar seu progresso."
        );

        return false;
    }


    const loginButton =
        document.getElementById("loginButton");


    if (loginButton) {
        loginButton.style.display = "none";
    }


    try {

        const response =
            await fetch(
                "/users/me",
                {
                    headers: {
                        "Authorization":
                            `Bearer ${token}`
                    }
                }
            );


        if (!response.ok) {

            throw new Error(
                "Não foi possível carregar o usuário."
            );
        }


        const usuario =
            await response.json();


        const nome =
            usuario.name ||
            usuario.username ||
            "U";


        const avatar =
            document.getElementById(
                "avatarUsuario"
            );


        if (avatar) {

            avatar.textContent =
                nome
                    .charAt(0)
                    .toUpperCase();
        }


        return true;

    }
    catch (error) {

        console.error(error);

        exibirMensagem(
            "Não foi possível identificar o usuário."
        );

        return false;
    }
}

// CARREGAR PROGRESSO
async function carregarProgresso(dias = 30) {

    const token = obterToken();

    if (!token) {
        return;
    }


    definirCarregamento(true);

    ocultarMensagem();


    try {

        const fim =
            new Date();

        const inicio =
            new Date();


        inicio.setDate(
            inicio.getDate() - (dias - 1)
        );


        const inicioFormatado =
            formatarDataAPI(inicio);

        const fimFormatado =
            formatarDataAPI(fim);


        const url =
            `${API_PROGRESSO}` +
            `?inicio=${inicioFormatado}` +
            `&fim=${fimFormatado}`;


        const response =
            await fetch(
                url,
                {
                    headers:
                        headersAutenticacao()
                }
            );


        if (response.status === 401 ||
            response.status === 403) {

            throw new Error(
                "Sessão inválida."
            );
        }


        if (!response.ok) {

            throw new Error(
                "Erro ao carregar progresso."
            );
        }


        dadosProgresso =
            await response.json();


        atualizarTela(
            dadosProgresso,
            dias
        );

    }
    catch (error) {

        console.error(error);

        limparTela();

        exibirMensagem(
            "Não foi possível carregar os dados de progresso."
        );
    }
    finally {

        definirCarregamento(false);
    }
}

// ATUALIZAR TELA
function atualizarTela(
    dados,
    dias
) {

    const sono =
        dados.sono || [];

    const hidratacao =
        dados.hidratacao || [];

    const treinos =
        dados.treinos || [];


    atualizarResumo(
        sono,
        hidratacao,
        treinos,
        dias
    );


    criarGraficoSono(sono);

    criarGraficoHidratacao(
        hidratacao
    );

    criarHeatmapTreinos(
        treinos
    );
}

// CARDS DE RESUMO
function atualizarResumo(
    sono,
    hidratacao,
    treinos,
    dias
) {

    // MÉDIA DE SONO
    const registrosSonoValidos =
        sono.filter(
            item =>
                item.horasSono !== null &&
                item.horasSono !== undefined
        );


    const mediaHorasSono =
        calcularMedia(
            registrosSonoValidos.map(
                item => item.horasSono
            )
        );


    document
        .getElementById(
            "mediaSonoResumo"
        )
        .textContent =
            mediaHorasSono === null
                ? "--"
                : formatarHoras(
                    mediaHorasSono
                );

    // NOTA MÉDIA
    const notasValidas =
        sono
            .filter(
                item =>
                    item.notaSono !== null &&
                    item.notaSono !== undefined
            )
            .map(
                item => item.notaSono
            );


    const mediaNota =
        calcularMedia(
            notasValidas
        );


    document
        .getElementById(
            "mediaNotaSonoResumo"
        )
        .textContent =
            mediaNota === null
                ? "--"
                : `${mediaNota.toFixed(1)} / 5`;

    // MÉDIA DE HIDRATAÇÃO
    const valoresAgua =
        hidratacao.map(
            item =>
                Number(
                    item.quantidadeMl || 0
                )
        );


    const mediaAgua =
        calcularMedia(
            valoresAgua
        );


    document
        .getElementById(
            "mediaHidratacaoResumo"
        )
        .textContent =
            mediaAgua === null
                ? "--"
                : `${Math.round(mediaAgua)} ml`;

    // DIAS COM TREINO
    const diasComTreino =
        treinos.filter(
            item => item.treinou
        ).length;


    document
        .getElementById(
            "diasTreinoResumo"
        )
        .textContent =
            diasComTreino;


    const descricaoTreino =
        document.getElementById(
            "diasTreinoDescricao"
        );


    if (descricaoTreino) {

        descricaoTreino.textContent =
            `em ${dias} dias`;
    }

    // TOTAL DE TREINOS
    const totalTreinos =
        treinos.reduce(
            (total, item) =>
                total +
                Number(
                    item.quantidadeTreinos || 0
                ),
            0
        );


    document
        .getElementById(
            "totalTreinos"
        )
        .textContent =
            totalTreinos;
}

// GRÁFICO DE SONO
function criarGraficoSono(sono) {

    const canvas =
        document.getElementById("graficoSono");

    if (!canvas) {
        return;
    }

    if (graficoSono) {
        graficoSono.destroy();
    }

    const labels =
        sono.map(item =>
            formatarDataGrafico(item.data)
        );

    const horas =
        sono.map(item => item.horasSono);

    const notas =
        sono.map(item => item.notaSono);

    graficoSono = new Chart(canvas, {
        data: {
            labels: labels,
            datasets: [
                {
                    type: "bar",
                    label: "Horas de sono",
                    data: horas,
                    backgroundColor: "rgba(140, 101, 173, 0.55)",
                    borderColor: "#8c65ad",
                    borderWidth: 1,
                    borderRadius: 8,
                    yAxisID: "yHoras"
                },
                {
                    type: "line",
                    label: "Nota do sono",
                    data: notas,
                    borderColor: "#df7225",
                    backgroundColor: "#df7225",
                    pointBackgroundColor: "#df7225",
                    pointBorderColor: "#df7225",
                    borderWidth: 2,
                    tension: 0,
                    spanGaps: true,
                    pointRadius: 4,
                    pointHoverRadius: 5,
                    yAxisID: "yNota"
                }
            ]
        },

        options: {
            responsive: true,
            maintainAspectRatio: false,

            interaction: {
                mode: "index",
                intersect: false
            },

            plugins: {
                legend: {
                    display: false
                },

                tooltip: {
                    callbacks: {
                        label: function(context) {
                            if (context.raw === null) {
                                return context.dataset.label + ": sem registro";
                            }

                            if (context.dataset.yAxisID === "yHoras") {
                                return "Horas de sono: " + formatarHoras(context.raw);
                            }

                            return "Nota do sono: " + Number(context.raw).toFixed(1) + "/5";
                        }
                    }
                }
            },

            scales: {
                x: {
                    grid: {
                        display: false
                    },
                    ticks: {
                        color: "#7d8985",
                        maxRotation: 0,
                        autoSkip: true,
                        maxTicksLimit: 12
                    }
                },

                yHoras: {
                    position: "left",
                    beginAtZero: true,
                    suggestedMax: 10,
                    grid: {
                        color: "rgba(113, 56, 25, 0.07)"
                    },
                    ticks: {
                        color: "#7d8985",
                        callback: value => `${value}h`
                    },
                    title: {
                        display: true,
                        text: "Horas de sono",
                        color: "#8c65ad"
                    }
                },

                yNota: {
                    position: "right",
                    min: 0,
                    max: 5,
                    grid: {
                        drawOnChartArea: false
                    },
                    ticks: {
                        stepSize: 1,
                        color: "#7d8985"
                    },
                    title: {
                        display: true,
                        text: "Nota",
                        color: "#df7225"
                    }
                }
            }
        }
    });
}

// GRÁFICO DE HIDRATAÇÃO
function criarGraficoHidratacao(
    hidratacao
) {

    const canvas =
        document.getElementById(
            "graficoHidratacao"
        );


    if (!canvas) {
        return;
    }


    if (graficoHidratacao) {

        graficoHidratacao.destroy();
    }


    const labels =
        hidratacao.map(
            item =>
                formatarDataGrafico(
                    item.data
                )
        );


    const valores =
        hidratacao.map(
            item =>
                Number(
                    item.quantidadeMl || 0
                )
        );


    graficoHidratacao =
        new Chart(
            canvas,
            {

                type: "line",

                data: {

                    labels: labels,

                    datasets: [

                        {

                            label:
                                "Água consumida",

                            data:
                                valores,

                            borderColor:
                                "#4d8ca3",

                            backgroundColor:
                                "rgba(77, 140, 163, 0.12)",

                            fill: true,

                            borderWidth: 2,

                            tension: 0.35,

                            pointRadius: 3,

                            pointHoverRadius: 5,

                            pointBackgroundColor:
                                "#4d8ca3",

                            pointBorderColor:
                                "#4d8ca3"

                        }

                    ]

                },


                options: {

                    responsive: true,

                    maintainAspectRatio:
                        false,


                    interaction: {

                        mode: "index",

                        intersect: false

                    },


                    plugins: {

                        legend: {
                            display: false
                        },


                        tooltip: {

                            callbacks: {

                                label:
                                    context =>
                                        `${Math.round(
                                            context.raw
                                        )} ml`

                            }

                        }

                    },


                    scales: {

                        x: {

                            grid: {
                                display: false
                            },

                            ticks: {

                                color:
                                    "#7d8985",

                                maxRotation: 0,

                                autoSkip: true,

                                maxTicksLimit: 12

                            }

                        },


                        y: {

                            beginAtZero: true,

                            grid: {

                                color:
                                    "rgba(113, 56, 25, 0.07)"

                            },

                            ticks: {

                                color:
                                    "#7d8985",

                                callback:
                                    value =>
                                        `${value} ml`

                            },

                            title: {

                                display: true,

                                text:
                                    "Quantidade de água",

                                color:
                                    "#4d8ca3"
                            }

                        }

                    }

                }

            }
        );
}

// HEATMAP DE TREINOS
function criarHeatmapTreinos(
    treinos
) {

    const container =
        document.getElementById(
            "heatmapTreinos"
        );


    const mesesContainer =
        document.getElementById(
            "heatmapMeses"
        );


    if (
        !container ||
        !mesesContainer
    ) {

        return;
    }


    container.innerHTML = "";

    mesesContainer.innerHTML = "";


    if (
        !treinos ||
        treinos.length === 0
    ) {

        return;
    }


    const registros =
        [...treinos].sort(
            (a, b) =>
                a.data.localeCompare(
                    b.data
                )
        );


    const primeiraData =
        criarDataLocal(
            registros[0].data
        );

    const deslocamentoInicial =
        (primeiraData.getDay() + 6)
        % 7;

    // ESPAÇOS ANTES DO PRIMEIRO DIA
    for (
        let i = 0;
        i < deslocamentoInicial;
        i++
    ) {

        const vazio =
            document.createElement(
                "span"
            );

        vazio.classList.add(
            "heatmap-dia"
        );

        vazio.style.visibility =
            "hidden";

        container.appendChild(
            vazio
        );
    }

    // DIAS
    registros.forEach(
        registro => {

            const quadrado =
                document.createElement(
                    "span"
                );


            quadrado.classList.add(
                "heatmap-dia"
            );


            const quantidade =
                Number(
                    registro
                        .quantidadeTreinos ||
                    0
                );


            let nivel = "vazio";


            if (quantidade === 1) {

                nivel =
                    "nivel-1";

            }
            else if (
                quantidade === 2
            ) {

                nivel =
                    "nivel-2";

            }
            else if (
                quantidade >= 3
            ) {

                nivel =
                    "nivel-3";
            }


            quadrado.classList.add(
                nivel
            );


            quadrado.dataset.tooltip =
                criarTooltipTreino(
                    registro.data,
                    quantidade
                );


            container.appendChild(
                quadrado
            );
        }
    );



    criarMesesHeatmap(
        registros,
        deslocamentoInicial
    );
}

// MESES DO HEATMAP
function criarMesesHeatmap(
    registros,
    deslocamentoInicial
) {

    const mesesContainer =
        document.getElementById(
            "heatmapMeses"
        );


    if (!mesesContainer) {
        return;
    }


    const totalCelulas =
        deslocamentoInicial +
        registros.length;


    const totalSemanas =
        Math.ceil(
            totalCelulas / 7
        );


    mesesContainer.style.display =
        "grid";

    mesesContainer.style.gridTemplateColumns =
        `repeat(${totalSemanas}, 14px)`;

    mesesContainer.style.columnGap =
        "5px";


    let ultimoMes = -1;

    let ultimaColuna = -1;


    registros.forEach(
        (registro, indice) => {

            const data =
                criarDataLocal(
                    registro.data
                );


            const mes =
                data.getMonth();


            const coluna =
                Math.floor(
                    (
                        deslocamentoInicial +
                        indice
                    ) / 7
                ) + 1;


            if (
                mes !== ultimoMes &&
                coluna !== ultimaColuna
            ) {

                const label =
                    document.createElement(
                        "span"
                    );


                label.textContent =
                    obterNomeMes(
                        mes
                    );


                label.style.gridColumn =
                    `${coluna} / span 4`;

                label.style.whiteSpace =
                    "nowrap";


                mesesContainer.appendChild(
                    label
                );


                ultimoMes =
                    mes;

                ultimaColuna =
                    coluna;
            }

        }
    );
}

// FILTROS
function configurarFiltros() {

    const botoes =
        document.querySelectorAll(
            ".periodo-btn"
        );


    botoes.forEach(
        botao => {

            botao.addEventListener(
                "click",
                async () => {

                    botoes.forEach(
                        item =>
                            item.classList
                                .remove(
                                    "active"
                                )
                    );


                    botao
                        .classList
                        .add(
                            "active"
                        );


                    const dias =
                        Number(
                            botao.dataset.dias
                        );


                    await carregarProgresso(
                        dias
                    );
                }
            );

        }
    );
}

// FUNÇÕES AUXILIARES
function calcularMedia(
    valores
) {

    if (
        !valores ||
        valores.length === 0
    ) {

        return null;
    }


    const soma =
        valores.reduce(
            (total, valor) =>
                total +
                Number(valor),
            0
        );


    return soma /
        valores.length;
}



function formatarHoras(
    horasDecimais
) {

    if (
        horasDecimais === null ||
        horasDecimais === undefined ||
        isNaN(horasDecimais)
    ) {

        return "--";
    }


    let horas =
        Math.floor(
            horasDecimais
        );


    let minutos =
        Math.round(
            (
                horasDecimais -
                horas
            ) * 60
        );


    if (minutos === 60) {

        horas++;

        minutos = 0;
    }


    return (
        `${horas}h ` +
        `${String(minutos)
            .padStart(2, "0")}min`
    );
}



function formatarDataAPI(
    data
) {

    const ano =
        data.getFullYear();


    const mes =
        String(
            data.getMonth() + 1
        )
        .padStart(
            2,
            "0"
        );


    const dia =
        String(
            data.getDate()
        )
        .padStart(
            2,
            "0"
        );


    return (
        `${ano}-${mes}-${dia}`
    );
}



function criarDataLocal(
    dataTexto
) {

    const partes =
        dataTexto
            .split("-")
            .map(Number);


    return new Date(
        partes[0],
        partes[1] - 1,
        partes[2]
    );
}



function formatarDataGrafico(
    dataTexto
) {

    const data =
        criarDataLocal(
            dataTexto
        );


    return data
        .toLocaleDateString(
            "pt-BR",
            {
                day: "2-digit",
                month: "2-digit"
            }
        );
}



function formatarDataCompleta(
    dataTexto
) {

    const data =
        criarDataLocal(
            dataTexto
        );


    return data
        .toLocaleDateString(
            "pt-BR"
        );
}



function criarTooltipTreino(
    data,
    quantidade
) {

    const dataFormatada =
        formatarDataCompleta(
            data
        );


    if (quantidade === 0) {

        return (
            `${dataFormatada} • ` +
            "Sem treino"
        );
    }


    if (quantidade === 1) {

        return (
            `${dataFormatada} • ` +
            "1 treino"
        );
    }


    return (
        `${dataFormatada} • ` +
        `${quantidade} treinos`
    );
}



function obterNomeMes(
    mes
) {

    const meses = [
        "Jan",
        "Fev",
        "Mar",
        "Abr",
        "Mai",
        "Jun",
        "Jul",
        "Ago",
        "Set",
        "Out",
        "Nov",
        "Dez"
    ];


    return meses[mes];
}

// ESTADO DE CARREGAMENTO
function definirCarregamento(
    carregando
) {

    const main =
        document.querySelector(
            ".progresso-main"
        );


    if (!main) {
        return;
    }


    if (carregando) {

        main.classList.add(
            "carregando"
        );

    }
    else {

        main.classList.remove(
            "carregando"
        );
    }
}

// MENSAGENS
function exibirMensagem(
    mensagem
) {

    const container =
        document.getElementById(
            "progressoMensagem"
        );


    const texto =
        document.getElementById(
            "progressoMensagemTexto"
        );


    if (
        !container ||
        !texto
    ) {

        return;
    }


    texto.textContent =
        mensagem;


    container.classList.add(
        "active"
    );
}



function ocultarMensagem() {

    const container =
        document.getElementById(
            "progressoMensagem"
        );


    if (container) {

        container.classList.remove(
            "active"
        );
    }
}

// LIMPAR TELA EM CASO DE ERRO
function limparTela() {

    document
        .getElementById(
            "mediaSonoResumo"
        )
        .textContent =
            "--";


    document
        .getElementById(
            "mediaHidratacaoResumo"
        )
        .textContent =
            "--";


    document
        .getElementById(
            "diasTreinoResumo"
        )
        .textContent =
            "--";


    document
        .getElementById(
            "mediaNotaSonoResumo"
        )
        .textContent =
            "--";


    document
        .getElementById(
            "totalTreinos"
        )
        .textContent =
            "0";


    document
        .getElementById(
            "heatmapTreinos"
        )
        .innerHTML =
            "";


    document
        .getElementById(
            "heatmapMeses"
        )
        .innerHTML =
            "";


    if (graficoSono) {

        graficoSono.destroy();

        graficoSono = null;
    }


    if (graficoHidratacao) {

        graficoHidratacao.destroy();

        graficoHidratacao = null;
    }
}

// LOGOUT
function configurarLogout() {

    const sair =
        document.getElementById(
            "sair"
        );


    if (!sair) {
        return;
    }


    sair.addEventListener(
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
}

async function iniciarPagina() {

    configurarFiltros();

    configurarLogout();


    const usuarioCarregado =
        await carregarUsuario();


    if (!usuarioCarregado) {
        return;
    }


    await carregarProgresso(30);
}


iniciarPagina();