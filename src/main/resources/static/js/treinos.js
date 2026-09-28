const btnNovoTreino =
    document.getElementById("btnNovoTreino");

const modalOverlay =
    document.getElementById("modalOverlay");

const btnFecharModal =
    document.getElementById("btnFecharModal");

const btnCancelar =
    document.getElementById("btnCancelar");

const formTreino =
    document.getElementById("formTreino");

const listaTreinos =
    document.getElementById("listaTreinos");

const treinosVazio =
    document.getElementById("treinosVazio");

const tituloModal =
    document.getElementById("tituloModal");


const treinoId =
    document.getElementById("treinoId");

const modalidade =
    document.getElementById("modalidade");

const duracao =
    document.getElementById("duracao");

const gastoCalorico =
    document.getElementById("gastoCalorico");

const dataHora =
    document.getElementById("dataHora");


let treinos = [];

const token = sessionStorage.getItem("jwtToken");

function apiFetch(url, options = {}) {
    return fetch(url, {
        ...options,
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`,
            ...(options.headers || {})
        }
    });
}

function normalizarTreino(treino) {
    return {
        id: String(treino.id),
        modalidade: treino.modalidade,
        duracaoMinutos: Number(treino.duracaominutos),
        gastoCaloricoEstimado: Number(treino.gastoCaloricoExtimado || 0),
        dataHora: treino.dataHora
    };
}

async function carregarTreinos() {
    if (!token) {
        renderizarTreinos();
        return;
    }

    const response = await apiFetch("/registroexercicio");
    if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
    }

    treinos = (await response.json()).map(normalizarTreino);
    renderizarTreinos();
}

function abrirModal() {

    formTreino.reset();

    treinoId.value = "";

    tituloModal.textContent =
        "Registrar treino";


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

formTreino.addEventListener(
    "submit",
    async function(event) {

        event.preventDefault();


        const registro = {
            modalidade:
                modalidade.value,
            duracaominutos:
                Number(duracao.value),
            gastoCaloricoExtimado:
                Number(gastoCalorico.value) || 0,
            dataHora:
                dataHora.value
        };

        try {
            const url = treinoId.value
                ? `/registroexercicio/${treinoId.value}`
                : "/registroexercicio";
            const response = await apiFetch(url, {
                method: treinoId.value ? "PUT" : "POST",
                body: JSON.stringify(registro)
            });

            if (!response.ok) {
                throw new Error(`HTTP ${response.status}`);
            }

            await carregarTreinos();
            fecharModal();
        } catch (error) {
            console.error("Erro ao salvar treino:", error);
            alert("Não foi possível salvar o treino. Faça login novamente e tente outra vez.");
        }

    }
);

function editarTreino(id) {

    const treino =
        treinos.find(
            treino => treino.id === id
        );


    if (!treino) {
        return;
    }


    treinoId.value =
        treino.id;

    modalidade.value =
        treino.modalidade;

    duracao.value =
        treino.duracaoMinutos;

    gastoCalorico.value =
        treino.gastoCaloricoEstimado;

    dataHora.value =
        treino.dataHora;


    tituloModal.textContent =
        "Editar treino";


    modalOverlay.classList.add("active");

}

function excluirTreino(id) {

    const confirmar =
        confirm(
            "Deseja realmente excluir este treino?"
        );


    if (!confirmar) {
        return;
    }


    apiFetch(`/registroexercicio/${id}`, { method: "DELETE" })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP ${response.status}`);
            }
            return carregarTreinos();
        })
        .catch(error => {
            console.error("Erro ao excluir treino:", error);
            alert("Não foi possível excluir o treino.");
        });

}

function formatarData(data) {

    const dataObjeto =
        new Date(data);


    return dataObjeto.toLocaleString(
        "pt-BR",
        {
            day: "2-digit",
            month: "2-digit",
            year: "numeric",
            hour: "2-digit",
            minute: "2-digit"
        }
    );

}

function obterIcone(modalidade) {

    const modalidadeLower =
        modalidade.toLowerCase();


    if (
        modalidadeLower.includes("corrida") ||
        modalidadeLower.includes("caminhada")
    ) {

        return "fa-person-running";

    }


    if (
        modalidadeLower.includes("ciclismo")
    ) {

        return "fa-person-biking";

    }


    if (
        modalidadeLower.includes("natação")
    ) {

        return "fa-person-swimming";

    }


    if (
        modalidadeLower.includes("futebol")
    ) {

        return "fa-futbol";

    }


    return "fa-dumbbell";

}

function renderizarTreinos() {

    listaTreinos.innerHTML = "";


    if (treinos.length === 0) {

        treinosVazio.style.display =
            "flex";

    } else {

        treinosVazio.style.display =
            "none";

    }


    const treinosOrdenados =
        [...treinos].sort(

            (a, b) =>

                new Date(b.dataHora) -
                new Date(a.dataHora)

        );


    treinosOrdenados.forEach(
        treino => {

            const card =
                document.createElement("article");


            card.classList.add(
                "treino-card"
            );


            card.innerHTML = `

                <div class="treino-principal">

                    <div class="treino-icone">

                        <i
                            class="fa-solid
                            ${obterIcone(treino.modalidade)}"
                        ></i>

                    </div>


                    <div class="treino-info">

                        <h3>
                            ${treino.modalidade}
                        </h3>

                        <p>

                            <i
                                class="fa-regular
                                fa-calendar"
                            ></i>

                            ${formatarData(treino.dataHora)}

                        </p>

                    </div>

                </div>


                <div class="treino-dados">

                    <div class="treino-dado">

                        <span>
                            Duração
                        </span>

                        <strong>
                            ${treino.duracaoMinutos} min
                        </strong>

                    </div>


                    <div class="treino-dado">

                        <span>
                            Gasto estimado
                        </span>

                        <strong>
                            ${
                                treino.gastoCaloricoEstimado
                                    ? treino.gastoCaloricoEstimado
                                    : "--"
                            } kcal
                        </strong>

                    </div>

                </div>


                <div class="treino-acoes">

                    <button
                        class="btn-editar"
                        title="Editar treino"
                        onclick="
                            editarTreino('${treino.id}')
                        "
                    >

                        <i
                            class="fa-solid
                            fa-pen"
                        ></i>

                    </button>


                    <button
                        class="btn-excluir"
                        title="Excluir treino"
                        onclick="
                            excluirTreino('${treino.id}')
                        "
                    >

                        <i
                            class="fa-regular
                            fa-trash-can"
                        ></i>

                    </button>

                </div>

            `;


            listaTreinos.appendChild(card);

        }
    );


    atualizarResumo();

}

function atualizarResumo() {

    const totalTreinos =
        treinos.length;


    const tempoTotal =
        treinos.reduce(

            (total, treino) =>
                total +
                Number(treino.duracaoMinutos),

            0
        );


    const caloriasTotal =
        treinos.reduce(

            (total, treino) =>
                total +
                Number(
                    treino.gastoCaloricoEstimado || 0
                ),

            0
        );


    document
        .getElementById("totalTreinos")
        .textContent =
            totalTreinos;


    document
        .getElementById("tempoTotal")
        .textContent =
            `${tempoTotal} min`;


    document
        .getElementById("caloriasTotal")
        .textContent =
            `${caloriasTotal.toFixed(0)} kcal`;

}

btnNovoTreino.addEventListener(
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
            event.target === modalOverlay
        ) {

            fecharModal();

        }

    }
);


document.addEventListener(
    "keydown",
    function(event) {

        if (event.key === "Escape") {

            fecharModal();

        }

    }
);

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

carregarTreinos().catch(error => {
    console.error("Erro ao carregar treinos:", error);
    renderizarTreinos();
});