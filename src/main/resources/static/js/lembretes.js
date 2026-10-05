const API_URL = "/lembretes";
const token = sessionStorage.getItem("jwtToken");
const lembretesNotificados = new Set();

const form = document.getElementById("formLembrete");
const tituloInput = document.getElementById("titulo");
const mensagemInput = document.getElementById("mensagem");
const horarioInput = document.getElementById("horario");
const lista = document.getElementById("listaLembretes");
const total = document.getElementById("totalLembretes");
const proximoHorario = document.getElementById("proximoHorario");
const feedback = document.getElementById("feedback");
const atualizarButton = document.getElementById("atualizar");

function obterHeaders() {
    return {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    };
}

function redirecionarParaLogin() {
    sessionStorage.removeItem("jwtToken");
    sessionStorage.removeItem("usuarioLogado");
    window.location.href = "entrar.html";
}

function mostrarFeedback(mensagem, erro = false) {
    feedback.textContent = mensagem;
    feedback.classList.toggle("error", erro);
}

function obterData(horario) {
    const data = new Date(horario);
    return Number.isNaN(data.getTime()) ? null : data;
}

function formatarHorario(horario) {
    const data = obterData(horario);
    if (!data) return "Horário inválido";

    return data.toLocaleString("pt-BR", {
        day: "2-digit", month: "2-digit", year: "numeric", hour: "2-digit", minute: "2-digit"
    });
}

function criarEstadoVazio(mensagem) {
    const estado = document.createElement("div");
    estado.className = "empty-state";
    const icone = document.createElement("i");
    icone.className = "fa-regular fa-bell";
    const texto = document.createElement("p");
    texto.textContent = mensagem;
    estado.append(icone, texto);
    return estado;
}

function exibirToast(lembrete) {
    const container = document.getElementById('toast-container');
    if (!container) return;

    const toast = document.createElement('div');
    toast.className = 'toast-notification';
    toast.innerHTML = `
        <div style="display: flex; align-items: flex-start; gap: 10px;">
            <i class="fa-solid fa-bell" style="color: #f39c12; margin-top: 3px;"></i>
            <div>
                <strong style="display: block; font-size: 14px; color: #333; margin-bottom: 2px;">${lembrete.titulo}</strong>
                <span style="font-size: 12px; color: #666;">${lembrete.mensagem || 'É hora do seu lembrete!'}</span>
            </div>
        </div>
    `;
    
    container.appendChild(toast);
    setTimeout(() => toast.classList.add('show'), 10);
    setTimeout(() => {
        toast.classList.remove('show');
        setTimeout(() => toast.remove(), 300);
    }, 6000);
}

function iniciarMonitoramentoLembretes(lembretes) {
    setInterval(() => {
        const agora = new Date();
        lembretes.forEach(lembrete => {
            const horaLembrete = new Date(lembrete.horario);
            const diferenca = agora.getTime() - horaLembrete.getTime();
            
            if (diferenca >= 0 && diferenca <= 60000 && !lembretesNotificados.has(lembrete.id)) {
                lembretesNotificados.add(lembrete.id);
                exibirToast(lembrete);
            }
        });
    }, 10000); 
}

function renderizarLembretes(lembretes) {
    const ordenados = [...lembretes].sort((a, b) => {
        const primeiro = obterData(a.horario)?.getTime() ?? Number.MAX_SAFE_INTEGER;
        const segundo = obterData(b.horario)?.getTime() ?? Number.MAX_SAFE_INTEGER;
        return primeiro - segundo;
    });

    const futuros = ordenados.filter(l => (obterData(l.horario)?.getTime() ?? 0) >= Date.now());
    
    total.textContent = futuros.length;
    lista.replaceChildren();

    const badge = document.getElementById('badge-notificacao');
    const dropdownLista = document.getElementById('dropdown-lista');
    if (dropdownLista) dropdownLista.innerHTML = '';
    
    if (futuros.length > 0) {
        if (badge) {
            badge.textContent = futuros.length;
            badge.style.display = 'block';
        }
        
        if (dropdownLista) {
            futuros.forEach(lembrete => {
                const div = document.createElement('div');
                div.className = 'dropdown-item';
                div.onclick = () => window.location.href = 'lembretes.html';
                div.innerHTML = `
                    <span class="dropdown-item-title"><span style="color: #e74c3c; margin-right: 6px;">●</span>${lembrete.titulo}</span>
                    <span class="dropdown-item-time">${formatarHorario(lembrete.horario).slice(0, 16)}</span>
                `;
                dropdownLista.appendChild(div);
            });
        }
        
        proximoHorario.textContent = formatarHorario(futuros[0].horario).slice(-5);
    } else {
        if (badge) badge.style.display = 'none';
        if (dropdownLista) dropdownLista.innerHTML = '<div class="dropdown-empty">Não tem novas notificações</div>';
        proximoHorario.textContent = "--:--";
    }

    if (ordenados.length === 0) {
        lista.appendChild(criarEstadoVazio("Nenhum lembrete cadastrado."));
        return;
    }

    ordenados.forEach((lembrete) => {
        const item = document.createElement("article");
        item.className = "reminder-item";

        const horario = document.createElement("time");
        horario.className = "reminder-time";
        horario.dateTime = lembrete.horario;
        horario.textContent = formatarHorario(lembrete.horario);

        const conteudo = document.createElement("div");
        conteudo.className = "reminder-content";

        const titulo = document.createElement("strong");
        titulo.textContent = lembrete.titulo;
        conteudo.appendChild(titulo);

        if (lembrete.mensagem) {
            const mensagem = document.createElement("p");
            mensagem.textContent = lembrete.mensagem;
            conteudo.appendChild(mensagem);
        }

        const excluir = document.createElement("button");
        excluir.type = "button";
        excluir.className = "reminder-delete";
        excluir.title = "Excluir lembrete";
        excluir.setAttribute("aria-label", `Excluir ${lembrete.titulo}`);
        excluir.innerHTML = '<i class="fa-solid fa-trash-can"></i>';
        excluir.addEventListener("click", () => excluirLembrete(lembrete.id, excluir));

        item.append(horario, conteudo, excluir);
        lista.appendChild(item);
    });

    iniciarMonitoramentoLembretes(lembretes);
}

async function carregarLembretes() {
    lista.replaceChildren(criarEstadoVazio("Carregando lembretes..."));

    try {
        const resposta = await fetch(API_URL, { headers: obterHeaders() });
        if (resposta.status === 401 || resposta.status === 403) {
            redirecionarParaLogin();
            return;
        }
        if (!resposta.ok) throw new Error("Não foi possível carregar os lembretes.");

        renderizarLembretes(await resposta.json());
        mostrarFeedback("");
    } catch (erro) {
        lista.replaceChildren(criarEstadoVazio("Não foi possível carregar os lembretes."));
        mostrarFeedback(erro.message, true);
    }
}

async function excluirLembrete(id, botao) {
    if (!window.confirm("Excluir este lembrete?")) return;

    botao.disabled = true;
    try {
        const resposta = await fetch(`${API_URL}/${id}`, {
            method: "DELETE",
            headers: obterHeaders()
        });
        if (resposta.status === 401 || resposta.status === 403) {
            redirecionarParaLogin();
            return;
        }
        if (!resposta.ok) throw new Error("Não foi possível excluir o lembrete.");

        mostrarFeedback("Lembrete excluído.");
        await carregarLembretes();
    } catch (erro) {
        botao.disabled = false;
        mostrarFeedback(erro.message, true);
    }
}

form.addEventListener("submit", async (evento) => {
    evento.preventDefault();
    const botao = form.querySelector("button[type=submit]");
    botao.disabled = true;
    mostrarFeedback("");

    try {
        const resposta = await fetch(API_URL, {
            method: "POST",
            headers: obterHeaders(),
            body: JSON.stringify({
                titulo: tituloInput.value.trim(),
                mensagem: mensagemInput.value.trim(),
                horario: horarioInput.value
            })
        });
        if (resposta.status === 401 || resposta.status === 403) {
            redirecionarParaLogin();
            return;
        }
        if (!resposta.ok) throw new Error("Não foi possível salvar o lembrete.");

        form.reset();
        mostrarFeedback("Lembrete adicionado.");
        await carregarLembretes();
    } catch (erro) {
        mostrarFeedback(erro.message, true);
    } finally {
        botao.disabled = false;
    }
});

atualizarButton.addEventListener("click", carregarLembretes);

const btnSair = document.getElementById("sair");
if (btnSair) {
    btnSair.addEventListener("click", () => {
        sessionStorage.removeItem("jwtToken");
        sessionStorage.removeItem("usuarioLogado");
    });
}

const btnNotificacao = document.getElementById('btnNotificacao');
const dropdown = document.getElementById('dropdown-notificacoes');

if (btnNotificacao && dropdown) {
    btnNotificacao.addEventListener('click', (event) => {
        event.stopPropagation();
        dropdown.classList.toggle('show');
    });

    document.addEventListener('click', (event) => {
        if (!dropdown.contains(event.target)) {
            dropdown.classList.remove('show');
        }
    });
}

if (!token) {
    redirecionarParaLogin();
} else {
    const loginButton = document.getElementById("loginButton");
    if (loginButton) loginButton.style.display = "none";
    
    fetch("/users/me", { headers: { "Authorization": `Bearer ${token}` } })
        .then((resposta) => {
            if (!resposta.ok) throw new Error("Sessão expirada.");
            return resposta.json();
        })
        .then((usuario) => {
            const nome = usuario.name || usuario.username || "U";
            const avatar = document.getElementById("avatarUsuario");
            if (avatar) avatar.textContent = nome.charAt(0).toUpperCase();
        })
        .catch(redirecionarParaLogin);

    carregarLembretes();
}