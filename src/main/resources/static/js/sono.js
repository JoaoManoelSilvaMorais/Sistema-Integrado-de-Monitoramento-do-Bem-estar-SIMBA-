const API_URL = "/registrosono";

const btnNovoSono =
    document.getElementById("btnNovoSono");

const modalOverlay =
    document.getElementById("modalOverlay");

const btnFecharModal =
    document.getElementById("btnFecharModal");

const btnCancelar =
    document.getElementById("btnCancelar");

const formSono =
    document.getElementById("formSono");

const tituloModal =
    document.getElementById("tituloModal");

const registroId =
    document.getElementById("registroId");

const horaDormirInput =
    document.getElementById("horaDormir");

const horaAcordarInput =
    document.getElementById("horaAcordar");

const notaSonoInput =
    document.getElementById("notaSono");

const duracaoCalculada =
    document.getElementById("duracaoCalculada");

const listaSono =
    document.getElementById("listaSono");

const sonoVazio =
    document.getElementById("sonoVazio");

const totalRegistros =
    document.getElementById("totalRegistros");

const mediaSono =
    document.getElementById("mediaSono");

const mediaNota =
    document.getElementById("mediaNota");

const ultimaNoite =
    document.getElementById("ultimaNoite");

const ultimaNota =
    document.getElementById("ultimaNota");

const notaButtons =
    document.querySelectorAll(".nota-button");


let registrosSono = [];

let usuarioAtual = null;

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

async function carregarUsuario() {

    const token = obterToken();

    if (!token) {
        return;
    }

    document
        .getElementById("loginButton")
        .style.display = "none";


    try {

        const response =
            await fetch("/users/me", {

                headers: {
                    "Authorization":
                        `Bearer ${token}`
                }

            });


        if (!response.ok) {

            throw new Error(
                "Não foi possível carregar o usuário."
            );

        }


        usuarioAtual =
            await response.json();


        const nome =
            usuarioAtual.name ||
            usuarioAtual.username ||
            "U";


        document
            .getElementById("avatarUsuario")
            .textContent =
                nome
                    .charAt(0)
                    .toUpperCase();

    }
    catch (error) {

        console.error(error);

    }

}

const horaPlanejada =
    document.getElementById("horaPlanejada");

const btnCalcularSono =
    document.getElementById("btnCalcularSono");

const resultadoPlanejador =
    document.getElementById("resultadoPlanejador");


btnCalcularSono.addEventListener(
    "click",
    calcularHorariosSono
);


function calcularHorariosSono() {

    if (!horaPlanejada.value) {

        alert(
            "Informe o horário em que pretende dormir."
        );

        return;

    }


    const [hora, minuto] =
        horaPlanejada.value
            .split(":")
            .map(Number);


    const horarioBase =
        new Date();


    horarioBase.setHours(
        hora,
        minuto,
        0,
        0
    );

    horarioBase.setMinutes(
        horarioBase.getMinutes() + 15
    );


    document
        .getElementById("horario5Ciclos")
        .textContent =
            calcularCiclo(
                horarioBase,
                5
            );


    document
        .getElementById("horario6Ciclos")
        .textContent =
            calcularCiclo(
                horarioBase,
                6
            );


    document
        .getElementById("horario7Ciclos")
        .textContent =
            calcularCiclo(
                horarioBase,
                7
            );


    resultadoPlanejador
        .classList
        .add("active");

}


function calcularCiclo(
    horarioInicial,
    ciclos
) {

    const data =
        new Date(
            horarioInicial.getTime()
        );

    data.setMinutes(

        data.getMinutes() +
        ciclos * 90

    );


    return data
        .toLocaleTimeString(
            "pt-BR",
            {
                hour: "2-digit",
                minute: "2-digit"
            }
        );

}

function abrirModal() {

    formSono.reset();

    registroId.value = "";

    notaSonoInput.value = "";

    duracaoCalculada.textContent =
        "--h --min";

    tituloModal.textContent =
        "Registrar sono";


    limparNotaSelecionada();

    preencherDatasPadrao();


    modalOverlay
        .classList
        .add("active");

}


function fecharModal() {

    modalOverlay
        .classList
        .remove("active");

}


function preencherDatasPadrao() {

    const agora =
        new Date();

    const ontem =
        new Date(agora);


    ontem.setDate(
        ontem.getDate() - 1
    );


    ontem.setHours(
        23,
        0,
        0,
        0
    );


    const hoje =
        new Date(agora);


    hoje.setHours(
        7,
        0,
        0,
        0
    );


    horaDormirInput.value =
        formatarParaInput(ontem);


    horaAcordarInput.value =
        formatarParaInput(hoje);


    atualizarDuracaoPreview();

}

notaButtons.forEach(button => {

    button.addEventListener(
        "click",
        () => {

            limparNotaSelecionada();


            button.classList.add(
                "active"
            );


            notaSonoInput.value =
                button.dataset.nota;

        }
    );

});


function limparNotaSelecionada() {

    notaButtons.forEach(
        button => {

            button.classList.remove(
                "active"
            );

        }
    );

}


function selecionarNota(nota) {

    limparNotaSelecionada();


    const button =
        document.querySelector(
            `.nota-button[data-nota="${nota}"]`
        );


    if (button) {

        button.classList.add(
            "active"
        );

    }


    notaSonoInput.value =
        nota;

}

horaDormirInput.addEventListener(
    "change",
    atualizarDuracaoPreview
);


horaAcordarInput.addEventListener(
    "change",
    atualizarDuracaoPreview
);


function atualizarDuracaoPreview() {

    if (
        !horaDormirInput.value ||
        !horaAcordarInput.value
    ) {

        duracaoCalculada.textContent =
            "--h --min";

        return;

    }


    const minutos =
        calcularDuracaoMinutos(
            horaDormirInput.value,
            horaAcordarInput.value
        );


    if (minutos <= 0) {

        duracaoCalculada.textContent =
            "Horários inválidos";

        return;

    }


    duracaoCalculada.textContent =
        formatarDuracao(minutos);

}


function calcularDuracaoMinutos(
    inicio,
    fim
) {

    const horaInicio =
        new Date(inicio);

    const horaFim =
        new Date(fim);


    return Math.floor(

        (
            horaFim -
            horaInicio
        ) / 60000

    );

}


function formatarDuracao(minutos) {

    if (
        minutos <= 0 ||
        isNaN(minutos)
    ) {

        return "0h 00min";

    }


    const horas =
        Math.floor(
            minutos / 60
        );


    const minutosRestantes =
        minutos % 60;


    return (
        `${horas}h ` +
        `${String(minutosRestantes)
            .padStart(2, "0")}min`
    );

}

formSono.addEventListener(
    "submit",
    async function(event) {

        event.preventDefault();


        const horaDormir =
            horaDormirInput.value;

        const horaAcordar =
            horaAcordarInput.value;

        const notaSono =
            Number(
                notaSonoInput.value
            );


        const duracao =
            calcularDuracaoMinutos(
                horaDormir,
                horaAcordar
            );


        if (duracao <= 0) {

            alert(
                "A hora de acordar deve ser posterior à hora de dormir."
            );

            return;

        }


        if (
            !notaSono ||
            notaSono < 1 ||
            notaSono > 5
        ) {

            alert(
                "Selecione uma nota para sua noite de sono."
            );

            return;

        }


        if (
            !usuarioAtual ||
            !usuarioAtual.id
        ) {

            alert(
                "Não foi possível identificar o usuário."
            );

            return;

        }


        const registro = {

            horaDormir:
                horaDormir,

            horaAcordar:
                horaAcordar,

            notaSono:
                notaSono,

            usuario: {
                id:
                    usuarioAtual.id
            }

        };


        try {

            let response;


            if (registroId.value) {

                response =
                    await fetch(

                        `${API_URL}/${registroId.value}`,

                        {
                            method: "PUT",

                            headers:
                                headersAutenticacao(),

                            body:
                                JSON.stringify(
                                    registro
                                )
                        }

                    );

            }
            else {

                response =
                    await fetch(

                        `${API_URL}/`,

                        {
                            method: "POST",

                            headers:
                                headersAutenticacao(),

                            body:
                                JSON.stringify(
                                    registro
                                )
                        }

                    );

            }


            if (!response.ok) {

                throw new Error(
                    "Não foi possível salvar o registro."
                );

            }


            fecharModal();

            await carregarRegistros();

        }
        catch (error) {

            console.error(error);

            alert(
                "Erro ao salvar o registro de sono."
            );

        }

    }
);

async function carregarRegistros() {

    if (
        !usuarioAtual ||
        !usuarioAtual.id
    ) {

        registrosSono = [];

        renderizarRegistros();

        return;

    }


    try {

        const response =
            await fetch(

                `${API_URL}/usuario/${usuarioAtual.id}`,

                {
                    headers:
                        headersAutenticacao()
                }

            );


        if (!response.ok) {

            throw new Error(
                "Erro ao carregar registros."
            );

        }


        registrosSono =
            await response.json();


        renderizarRegistros();

    }
    catch (error) {

        console.error(error);

        registrosSono = [];

        renderizarRegistros();

    }

}

function editarRegistro(id) {

    const registro =
        registrosSono.find(
            item =>
                String(item.id) ===
                String(id)
        );


    if (!registro) {
        return;
    }


    registroId.value =
        registro.id;


    horaDormirInput.value =
        converterParaInput(
            registro.horaDormir
        );


    horaAcordarInput.value =
        converterParaInput(
            registro.horaAcordar
        );


    selecionarNota(
        registro.notaSono
    );


    tituloModal.textContent =
        "Editar registro de sono";


    atualizarDuracaoPreview();


    modalOverlay
        .classList
        .add("active");

}

async function excluirRegistro(id) {

    const confirmar =
        confirm(
            "Deseja realmente excluir este registro de sono?"
        );


    if (!confirmar) {
        return;
    }


    try {

        const response =
            await fetch(

                `${API_URL}/${id}`,

                {
                    method: "DELETE",

                    headers:
                        headersAutenticacao()
                }

            );


        if (!response.ok) {

            throw new Error(
                "Erro ao excluir registro."
            );

        }


        await carregarRegistros();

    }
    catch (error) {

        console.error(error);

        alert(
            "Não foi possível excluir o registro."
        );

    }

}

function renderizarRegistros() {

    listaSono.innerHTML = "";


    if (
        !registrosSono ||
        registrosSono.length === 0
    ) {

        sonoVazio.style.display =
            "flex";

        atualizarResumo();

        return;

    }


    sonoVazio.style.display =
        "none";


    const registrosOrdenados =
        [...registrosSono].sort(

            (a, b) =>

                new Date(b.horaDormir) -
                new Date(a.horaDormir)

        );


    registrosOrdenados.forEach(
        registro => {

            const duracao =
                calcularDuracaoMinutos(
                    registro.horaDormir,
                    registro.horaAcordar
                );


            const card =
                document.createElement(
                    "article"
                );


            card.classList.add(
                "sono-card"
            );


            card.innerHTML = `

                <div class="sono-principal">

                    <div class="sono-icone">

                        <i class="fa-solid fa-moon"></i>

                    </div>


                    <div class="sono-info">

                        <h3>
                            ${formatarNoite(registro.horaDormir)}
                        </h3>

                        <p>
                            Dormiu às
                            ${formatarHora(registro.horaDormir)}
                            •
                            Acordou às
                            ${formatarHora(registro.horaAcordar)}
                        </p>

                    </div>

                </div>


                <div class="sono-dados">

                    <div class="sono-dado">

                        <span>
                            Duração
                        </span>

                        <strong>
                            ${formatarDuracao(duracao)}
                        </strong>

                    </div>


                    <div class="sono-dado">

                        <span>
                            Nota
                        </span>

                        <strong>
                            <i class="fa-solid fa-star"></i>
                            ${registro.notaSono}/5
                        </strong>

                    </div>

                </div>


                <div class="sono-acoes">

                    <button
                        class="btn-editar"
                        title="Editar registro"
                        onclick="editarRegistro('${registro.id}')"
                    >

                        <i class="fa-solid fa-pen"></i>

                    </button>


                    <button
                        class="btn-excluir"
                        title="Excluir registro"
                        onclick="excluirRegistro('${registro.id}')"
                    >

                        <i class="fa-regular fa-trash-can"></i>

                    </button>

                </div>

            `;


            listaSono.appendChild(
                card
            );

        }
    );


    atualizarResumo();

}

function atualizarResumo() {

    totalRegistros.textContent =
        registrosSono.length;


    if (
        registrosSono.length === 0
    ) {

        mediaSono.textContent =
            "0h 00min";

        mediaNota.textContent =
            "-- / 5";

        ultimaNoite.textContent =
            "--";

        ultimaNota.textContent =
            "Sem registros";

        return;

    }


    let somaDuracao = 0;

    let somaNotas = 0;


    registrosSono.forEach(
        registro => {

            somaDuracao +=
                calcularDuracaoMinutos(

                    registro.horaDormir,

                    registro.horaAcordar

                );


            somaNotas +=
                Number(
                    registro.notaSono || 0
                );

        }
    );


    const mediaDuracao =
        Math.floor(

            somaDuracao /
            registrosSono.length

        );


    const notaMedia =
        somaNotas /
        registrosSono.length;


    mediaSono.textContent =
        formatarDuracao(
            mediaDuracao
        );


    mediaNota.textContent =
        `${notaMedia.toFixed(1)} / 5`;


    const ultimoRegistro =
        [...registrosSono].sort(

            (a, b) =>

                new Date(b.horaDormir) -
                new Date(a.horaDormir)

        )[0];


    const duracaoUltimaNoite =
        calcularDuracaoMinutos(

            ultimoRegistro.horaDormir,

            ultimoRegistro.horaAcordar

        );


    ultimaNoite.textContent =
        formatarDuracao(
            duracaoUltimaNoite
        );


    ultimaNota.textContent =
        `Nota ${ultimoRegistro.notaSono}/5`;

}

function formatarHora(dataTexto) {

    return new Date(dataTexto)
        .toLocaleTimeString(
            "pt-BR",
            {
                hour: "2-digit",
                minute: "2-digit"
            }
        );

}


function formatarNoite(dataTexto) {

    const data =
        new Date(dataTexto);


    return (
        "Noite de " +
        data.toLocaleDateString(
            "pt-BR",
            {
                day: "2-digit",
                month: "2-digit",
                year: "numeric"
            }
        )
    );

}


function formatarParaInput(data) {

    const ano =
        data.getFullYear();

    const mes =
        String(
            data.getMonth() + 1
        )
        .padStart(2, "0");

    const dia =
        String(
            data.getDate()
        )
        .padStart(2, "0");

    const hora =
        String(
            data.getHours()
        )
        .padStart(2, "0");

    const minuto =
        String(
            data.getMinutes()
        )
        .padStart(2, "0");


    return (
        `${ano}-${mes}-${dia}` +
        `T${hora}:${minuto}`
    );

}

function converterParaInput(dataTexto) {

    return formatarParaInput(
        new Date(dataTexto)
    );

}

btnNovoSono.addEventListener(
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

async function iniciarPagina() {

    await carregarUsuario();

    await carregarRegistros();

}


iniciarPagina();