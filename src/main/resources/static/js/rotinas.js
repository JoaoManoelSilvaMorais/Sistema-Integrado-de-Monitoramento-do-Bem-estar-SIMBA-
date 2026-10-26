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

const DIAS = [
    { iso: 1, curto: "Seg" }, { iso: 2, curto: "Ter" }, { iso: 3, curto: "Qua" },
    { iso: 4, curto: "Qui" }, { iso: 5, curto: "Sex" }, { iso: 6, curto: "Sáb" },
    { iso: 7, curto: "Dom" }
];
let rotinasCache = [];
const lembretesNotificados = new Set();

function descreverDias(dias) {
    if (dias.length === 7) return "Todos os dias";
    return DIAS.filter(d => dias.includes(d.iso)).map(d => d.curto).join(", ");
}

function criarFormLembrete(rotina) {
    const form = document.createElement("form");
    form.className = "form-lembrete";

    const titulo = document.createElement("input");
    titulo.placeholder = "Lembrete (ex.: Hora de treinar)";
    titulo.maxLength = 100;
    titulo.required = true;

    const hora = document.createElement("input");
    hora.type = "time";
    hora.required = true;

    const dias = document.createElement("div");
    dias.className = "dias-semana";
    DIAS.forEach(dia => {
        const label = document.createElement("label");
        const check = document.createElement("input");
        check.type = "checkbox";
        check.value = dia.iso;
        const texto = document.createElement("span");
        texto.textContent = dia.curto;
        label.append(check, texto);
        dias.appendChild(label);
    });

    const botao = document.createElement("button");
    botao.type = "submit";
    botao.className = "btn-add-lembrete";
    botao.innerHTML = '<i class="fa-solid fa-plus"></i> Adicionar lembrete';

    form.append(titulo, hora, dias, botao);
    form.addEventListener("submit", async evento => {
        evento.preventDefault();
        const selecionados = [...dias.querySelectorAll("input:checked")].map(c => Number(c.value));
        if (selecionados.length === 0) {
            mostrarMensagem("Escolha pelo menos um dia da semana.", true);
            return;
        }
        botao.disabled = true;
        try {
            await requisicao(`${API_ROTINAS}/${rotina.id}/lembretes`, {
                method: "POST",
                body: JSON.stringify({
                    titulo: titulo.value.trim(),
                    mensagem: "",
                    hora: hora.value,
                    diasSemana: selecionados
                })
            });
            mostrarMensagem("Lembrete adicionado.");
            await carregarRotinas();
        } catch (erro) {
            mostrarMensagem(erro.message, true);
            botao.disabled = false;
        }
    });
    return form;
}

function criarLembreteItem(rotina, lembrete) {
    const item = document.createElement("div");
    item.className = "lembrete-item";

    const hora = document.createElement("strong");
    hora.textContent = (lembrete.hora || "").slice(0, 5);

    const info = document.createElement("div");
    const titulo = document.createElement("span");
    titulo.className = "lembrete-titulo";
    titulo.textContent = lembrete.titulo;
    const dias = document.createElement("small");
    dias.textContent = descreverDias(lembrete.diasSemana);
    info.append(titulo, dias);

    const excluir = document.createElement("button");
    excluir.type = "button";
    excluir.className = "btn-excluir";
    excluir.title = "Remover lembrete";
    excluir.innerHTML = '<i class="fa-solid fa-xmark"></i>';
    excluir.addEventListener("click", async () => {
        try {
            await requisicao(`${API_ROTINAS}/${rotina.id}/lembretes/${lembrete.id}`, { method: "DELETE" });
            await carregarRotinas();
        } catch (erro) {
            mostrarMensagem(erro.message, true);
        }
    });

    item.append(hora, info, excluir);
    return item;
}

function criarRotinaElementar(rotina) {
    const item = document.createElement("article");
    item.className = `rotina-item${rotina.ativa ? "" : " inativa"}`;

    const topo = document.createElement("div");
    topo.className = "rotina-topo";

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
    topo.append(info, acoes);

    const secao = document.createElement("div");
    secao.className = "rotina-lembretes";
    const cabecalho = document.createElement("span");
    cabecalho.className = "label";
    cabecalho.textContent = "LEMBRETES DESTA ROTINA";
    secao.appendChild(cabecalho);

    if (rotina.lembretes.length === 0) {
        const vazio = document.createElement("p");
        vazio.className = "sem-lembretes";
        vazio.textContent = "Nenhum lembrete ainda. Adicione o horário e os dias da semana.";
        secao.appendChild(vazio);
    } else {
        rotina.lembretes.forEach(l => secao.appendChild(criarLembreteItem(rotina, l)));
    }
    secao.appendChild(criarFormLembrete(rotina));

    item.append(topo, secao);
    return item;
}

function renderizarRotinas(rotinas) {
    rotinasCache = rotinas;
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

function exibirToast(rotina, lembrete) {
    const container = document.getElementById("toast-container");
    if (!container) return;
    const toast = document.createElement("div");
    toast.className = "toast-notification";
    const titulo = document.createElement("strong");
    titulo.textContent = lembrete.titulo;
    const detalhe = document.createElement("span");
    detalhe.textContent = `Rotina: ${rotina.nome}`;
    toast.append(titulo, detalhe);
    container.appendChild(toast);
    setTimeout(() => toast.classList.add("show"), 10);
    setTimeout(() => {
        toast.classList.remove("show");
        setTimeout(() => toast.remove(), 300);
    }, 6000);
}

function verificarLembretes() {
    const agora = new Date();
    const diaIso = agora.getDay() === 0 ? 7 : agora.getDay();
    const hhmm = agora.toTimeString().slice(0, 5);
    const dataChave = agora.toDateString();
    rotinasCache.filter(r => r.ativa).forEach(rotina => {
        rotina.lembretes.forEach(lembrete => {
            const chave = `${lembrete.id}-${dataChave}`;
            if (lembrete.diasSemana.includes(diaIso)
                    && (lembrete.hora || "").slice(0, 5) === hhmm
                    && !lembretesNotificados.has(chave)) {
                lembretesNotificados.add(chave);
                exibirToast(rotina, lembrete);
            }
        });
    });
}

setInterval(verificarLembretes, 15000);

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
