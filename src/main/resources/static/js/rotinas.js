const API_ROTINAS = "/api/rotinas";
const token = sessionStorage.getItem("jwtToken");
const listaRotinas = document.getElementById("listaRotinas");
const totalRotinas = document.getElementById("totalRotinas");
const formRotina = document.getElementById("formRotina");
const mensagem = document.getElementById("mensagem");

function headersAutenticacao() {
    return {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    };
}

function mostrarMensagem(texto, erro = false) {
    mensagem.textContent = texto;
    mensagem.classList.toggle("erro", erro);
}

function redirecionarParaLogin() {
    sessionStorage.removeItem("jwtToken");
    sessionStorage.removeItem("usuarioLogado");
    window.location.href = "entrar.html";
}

async function requisicao(url, opcoes = {}) {
    const resposta = await fetch(url, {
        ...opcoes,
        headers: { ...headersAutenticacao(), ...(opcoes.headers || {}) }
    });
    if (resposta.status === 401 || resposta.status === 403) {
        redirecionarParaLogin();
        throw new Error("Sessão expirada.");
    }
    if (!resposta.ok) {
        const texto = await resposta.text();
        throw new Error(texto || "Não foi possível concluir a operação.");
    }
    return resposta.status === 204 ? null : resposta.json();
}

function criarRotinaElementar(rotina) {
    const item = document.createElement("article");
    item.className = `rotina-item${rotina.ativa ? "" : " inativa"}`;

    const info = document.createElement("div");
    info.className = "rotina-info";
    const titulo = document.createElement("h3");
    titulo.textContent = rotina.nome;
    const descricao = document.createElement("p");
    descricao.textContent = rotina.descricao || "Sem descrição.";
    info.append(titulo, descricao);

    const acoes = document.createElement("div");
    acoes.className = "rotina-acoes";
    const status = document.createElement("button");
    status.className = "btn-status";
    status.type = "button";
    status.title = rotina.ativa ? "Desativar rotina" : "Ativar rotina";
    status.innerHTML = rotina.ativa
        ? '<i class="fa-solid fa-toggle-on"></i>'
        : '<i class="fa-solid fa-toggle-off"></i>';
    status.addEventListener("click", () => alternarRotina(rotina));

    const excluir = document.createElement("button");
    excluir.className = "btn-excluir";
    excluir.type = "button";
    excluir.title = "Excluir rotina";
    excluir.innerHTML = '<i class="fa-solid fa-trash"></i>';
    excluir.addEventListener("click", () => excluirRotina(rotina.id));
    acoes.append(status, excluir);
    item.append(info, acoes);
    return item;
}

function renderizarRotinas(rotinas) {
    totalRotinas.textContent = rotinas.length;
    listaRotinas.replaceChildren();
    if (rotinas.length === 0) {
        const vazio = document.createElement("p");
        vazio.className = "estado-vazio";
        vazio.textContent = "Você ainda não cadastrou nenhuma rotina.";
        listaRotinas.appendChild(vazio);
        return;
    }
    rotinas.forEach(rotina => listaRotinas.appendChild(criarRotinaElementar(rotina)));
}

async function carregarRotinas() {
    try {
        renderizarRotinas([]);
        const rotinas = await requisicao(API_ROTINAS);
        renderizarRotinas(rotinas);
    } catch (erro) {
        mostrarMensagem(erro.message, true);
    }
}

async function alternarRotina(rotina) {
    try {
        const atualizada = await requisicao(`${API_ROTINAS}/${rotina.id}`, {
            method: "PUT",
            body: JSON.stringify({
                nome: rotina.nome,
                descricao: rotina.descricao,
                ativa: !rotina.ativa
            })
        });
        const itens = [...document.querySelectorAll(".rotina-item")];
        await carregarRotinas();
        mostrarMensagem(`${atualizada.nome} ${atualizada.ativa ? "ativada" : "desativada"}.`);
    } catch (erro) {
        mostrarMensagem(erro.message, true);
    }
}

async function excluirRotina(id) {
    if (!window.confirm("Deseja excluir esta rotina?")) return;
    try {
        await requisicao(`${API_ROTINAS}/${id}`, { method: "DELETE" });
        mostrarMensagem("Rotina excluída.");
        await carregarRotinas();
    } catch (erro) {
        mostrarMensagem(erro.message, true);
    }
}

formRotina.addEventListener("submit", async evento => {
    evento.preventDefault();
    const botao = formRotina.querySelector("button[type=submit]");
    botao.disabled = true;
    try {
        await requisicao(API_ROTINAS, {
            method: "POST",
            body: JSON.stringify({
                nome: document.getElementById("nome").value.trim(),
                descricao: document.getElementById("descricao").value.trim(),
                ativa: true
            })
        });
        formRotina.reset();
        mostrarMensagem("Rotina criada com sucesso.");
        await carregarRotinas();
    } catch (erro) {
        mostrarMensagem(erro.message, true);
    } finally {
        botao.disabled = false;
    }
});

if (!token) {
    redirecionarParaLogin();
} else {
    requisicao("/users/me")
        .then(usuario => {
            document.getElementById("loginButton").style.display = "none";
            document.getElementById("avatarUsuario").textContent =
                (usuario.name || usuario.username || "U").charAt(0).toUpperCase();
        })
        .then(carregarRotinas)
        .catch(erro => mostrarMensagem(erro.message, true));
}
