const API_USUARIO = "/users/me";
const API_SENHA = "/users/me/password";

let usuarioAtual = null;


// ELEMENTOS DA PÁGINA
const avatarUsuario =
    document.getElementById("avatarUsuario");

const avatarPerfil =
    document.getElementById("avatarPerfil");

const loginButton =
    document.getElementById("loginButton");

const nomeInfo =
    document.getElementById("nomeInfo");

const usernameInfo =
    document.getElementById("usernameInfo");

const emailInfo =
    document.getElementById("emailInfo");


// MODAL DE DADOS
const modalDados =
    document.getElementById("modalDados");

const btnEditarDados =
    document.getElementById("btnEditarDados");

const btnFecharDados =
    document.getElementById("btnFecharDados");

const btnCancelarDados =
    document.getElementById("btnCancelarDados");

const formDados =
    document.getElementById("formDados");


const nomeInput =
    document.getElementById("nomeInput");

const usernameInput =
    document.getElementById("usernameInput");

const emailInput =
    document.getElementById("emailInput");

// MODAL DE SENHA
const modalSenha =
    document.getElementById("modalSenha");

const btnAlterarSenha =
    document.getElementById("btnAlterarSenha");

const btnFecharSenha =
    document.getElementById("btnFecharSenha");

const btnCancelarSenha =
    document.getElementById("btnCancelarSenha");

const formSenha =
    document.getElementById("formSenha");


const senhaAtualInput =
    document.getElementById("senhaAtual");

const novaSenhaInput =
    document.getElementById("novaSenha");

const confirmarSenhaInput =
    document.getElementById("confirmarSenha");

// AUTENTICAÇÃO
function obterToken() {

    return sessionStorage.getItem(
        "jwtToken"
    );
}


function headersAutenticacao() {

    const token = obterToken();

    return {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    };
}

// CARREGAR USUÁRIO
async function carregarUsuario() {

    const token = obterToken();


    if (!token) {

        exibirMensagem(
            "Você precisa estar conectado para acessar seu perfil.",
            "erro"
        );

        setTimeout(
            () => {
                window.location.href =
                    "entrar.html";
            },
            1200
        );

        return;
    }


    if (loginButton) {

        loginButton.style.display =
            "none";
    }


    try {

        const response =
            await fetch(
                API_USUARIO,
                {
                    headers:
                        headersAutenticacao()
                }
            );


        if (
            response.status === 401 ||
            response.status === 403
        ) {

            throw new Error(
                "Sessão inválida"
            );
        }


        if (!response.ok) {

            throw new Error(
                "Erro ao carregar usuário"
            );
        }


        usuarioAtual =
            await response.json();


        atualizarPerfilNaTela();


        sessionStorage.setItem(
            "usuarioLogado",
            JSON.stringify(
                usuarioAtual
            )
        );

    }
    catch (error) {

        console.error(
            "Erro ao carregar perfil:",
            error
        );


        exibirMensagem(
            "Não foi possível carregar seu perfil.",
            "erro"
        );

    }
}

// ATUALIZAR INFORMAÇÕES NA TELA
function atualizarPerfilNaTela() {

    if (!usuarioAtual) {
        return;
    }


    const nome =
        usuarioAtual.name ||
        usuarioAtual.username ||
        "Usuário";


    const username =
        usuarioAtual.username ||
        "";


    const email =
        usuarioAtual.email ||
        "";


    const inicial =
        nome
            .charAt(0)
            .toUpperCase();


    // AVATAR DO HEADER
    if (avatarUsuario) {

        avatarUsuario.textContent =
            inicial;
    }


    // AVATAR DO PERFIL
    if (avatarPerfil) {

        avatarPerfil.textContent =
            inicial;
    }


    // INFORMAÇÕES DA CONTA
    nomeInfo.textContent =
        nome;


    usernameInfo.textContent =
        username || "--";


    emailInfo.textContent =
        email || "--";
}

// ABRIR MODAL DE DADOS
function abrirModalDados() {

    if (!usuarioAtual) {
        return;
    }


    nomeInput.value =
        usuarioAtual.name || "";


    usernameInput.value =
        usuarioAtual.username || "";


    emailInput.value =
        usuarioAtual.email || "";


    modalDados
        .classList
        .add("active");
}

// FECHAR MODAL DE DADOS
function fecharModalDados() {

    modalDados
        .classList
        .remove("active");
}

// ABRIR MODAL DE SENHA
function abrirModalSenha() {

    formSenha.reset();


    modalSenha
        .classList
        .add("active");


    senhaAtualInput.focus();
}

// FECHAR MODAL DE SENHA
function fecharModalSenha() {

    modalSenha
        .classList
        .remove("active");


    formSenha.reset();
}

// SALVAR DADOS DO USUÁRIO
formDados.addEventListener(
    "submit",
    async function(event) {

        event.preventDefault();


        const nome =
            nomeInput.value.trim();


        const username =
            usernameInput.value.trim();


        const email =
            emailInput.value.trim();


        if (
            !nome ||
            !username ||
            !email
        ) {

            exibirMensagem(
                "Preencha todos os campos.",
                "erro"
            );

            return;
        }


        const dados = {

            name: nome,

            username: username,

            email: email

        };


        const botaoSalvar =
            formDados.querySelector(
                ".btn-salvar"
            );


        botaoSalvar.disabled =
            true;


        try {

            const response =
                await fetch(
                    API_USUARIO,
                    {
                        method: "PUT",

                        headers:
                            headersAutenticacao(),

                        body:
                            JSON.stringify(
                                dados
                            )
                    }
                );


            if (!response.ok) {

                const mensagem =
                    await lerMensagemErro(
                        response
                    );

                throw new Error(
                    mensagem
                );
            }


            const resposta =
                await response.json();

            usuarioAtual =
                resposta.usuario;

            if (resposta.token) {

                sessionStorage.setItem(
                    "jwtToken",
                    resposta.token
                );
            }


            sessionStorage.setItem(
                "usuarioLogado",
                JSON.stringify(
                    usuarioAtual
                )
            );


            atualizarPerfilNaTela();


            fecharModalDados();


            exibirMensagem(
                "Informações atualizadas com sucesso.",
                "sucesso"
            );

        }
        catch (error) {

            console.error(
                "Erro ao atualizar perfil:",
                error
            );


            exibirMensagem(
                error.message ||
                "Não foi possível atualizar as informações.",
                "erro"
            );

        }
        finally {

            botaoSalvar.disabled =
                false;
        }

    }
);

// ALTERAR SENHA
formSenha.addEventListener(
    "submit",
    async function(event) {

        event.preventDefault();


        const senhaAtual =
            senhaAtualInput.value;


        const novaSenha =
            novaSenhaInput.value;


        const confirmarSenha =
            confirmarSenhaInput.value;


        if (
            !senhaAtual ||
            !novaSenha ||
            !confirmarSenha
        ) {

            exibirMensagem(
                "Preencha todos os campos da senha.",
                "erro"
            );

            return;
        }


        if (
            novaSenha !==
            confirmarSenha
        ) {

            exibirMensagem(
                "As novas senhas não coincidem.",
                "erro"
            );

            return;
        }


        const dados = {

            senhaAtual:
                senhaAtual,

            novaSenha:
                novaSenha,

            confirmarSenha:
                confirmarSenha

        };


        const botaoSalvar =
            formSenha.querySelector(
                ".btn-salvar"
            );


        botaoSalvar.disabled =
            true;


        try {

            const response =
                await fetch(
                    API_SENHA,
                    {
                        method: "PUT",

                        headers:
                            headersAutenticacao(),

                        body:
                            JSON.stringify(
                                dados
                            )
                    }
                );


            const mensagem =
                await response.text();


            if (!response.ok) {

                throw new Error(
                    mensagem ||
                    "Não foi possível alterar a senha."
                );
            }


            fecharModalSenha();


            exibirMensagem(
                mensagem ||
                "Senha alterada com sucesso.",
                "sucesso"
            );

        }
        catch (error) {

            console.error(
                "Erro ao alterar senha:",
                error
            );


            exibirMensagem(
                error.message ||
                "Não foi possível alterar a senha.",
                "erro"
            );

        }
        finally {

            botaoSalvar.disabled =
                false;
        }

    }
);

// MOSTRAR / ESCONDER SENHA
const botoesMostrarSenha =
    document.querySelectorAll(
        ".btn-mostrar-senha"
    );


botoesMostrarSenha.forEach(
    botao => {

        botao.addEventListener(
            "click",
            () => {

                const inputId =
                    botao.dataset.input;


                const input =
                    document.getElementById(
                        inputId
                    );


                const icone =
                    botao.querySelector(
                        "i"
                    );


                if (
                    input.type ===
                    "password"
                ) {

                    input.type =
                        "text";


                    icone.classList.remove(
                        "fa-eye"
                    );


                    icone.classList.add(
                        "fa-eye-slash"
                    );

                }
                else {

                    input.type =
                        "password";


                    icone.classList.remove(
                        "fa-eye-slash"
                    );


                    icone.classList.add(
                        "fa-eye"
                    );

                }

            }
        );

    }
);

// MENSAGENS
function exibirMensagem(
    mensagem,
    tipo = "sucesso"
) {

    const container =
        document.getElementById(
            "perfilMensagem"
        );


    const texto =
        document.getElementById(
            "perfilMensagemTexto"
        );


    if (
        !container ||
        !texto
    ) {

        return;
    }


    texto.textContent =
        mensagem;


    container.classList.remove(
        "sucesso",
        "erro"
    );


    container.classList.add(
        "active",
        tipo
    );


    clearTimeout(
        window.perfilMensagemTimeout
    );


    window.perfilMensagemTimeout =
        setTimeout(
            () => {

                container
                    .classList
                    .remove(
                        "active",
                        "sucesso",
                        "erro"
                    );

            },
            4000
        );
}

// LER ERRO DO BACKEND
async function lerMensagemErro(
    response
) {

    try {

        const tipo =
            response.headers.get(
                "content-type"
            );


        if (
            tipo &&
            tipo.includes(
                "application/json"
            )
        ) {

            const dados =
                await response.json();


            return (
                dados.message ||
                dados.error ||
                "Não foi possível concluir a operação."
            );
        }


        const texto =
            await response.text();


        return (
            texto ||
            "Não foi possível concluir a operação."
        );

    }
    catch (error) {

        return (
            "Não foi possível concluir a operação."
        );
    }
}

// EVENTOS DOS MODAIS
btnEditarDados.addEventListener(
    "click",
    abrirModalDados
);


btnFecharDados.addEventListener(
    "click",
    fecharModalDados
);


btnCancelarDados.addEventListener(
    "click",
    fecharModalDados
);


btnAlterarSenha.addEventListener(
    "click",
    abrirModalSenha
);


btnFecharSenha.addEventListener(
    "click",
    fecharModalSenha
);


btnCancelarSenha.addEventListener(
    "click",
    fecharModalSenha
);

// FECHAR CLICANDO FORA
modalDados.addEventListener(
    "click",
    function(event) {

        if (
            event.target ===
            modalDados
        ) {

            fecharModalDados();
        }

    }
);


modalSenha.addEventListener(
    "click",
    function(event) {

        if (
            event.target ===
            modalSenha
        ) {

            fecharModalSenha();
        }

    }
);

// FECHAR COM ESC
document.addEventListener(
    "keydown",
    function(event) {

        if (
            event.key !==
            "Escape"
        ) {

            return;
        }


        if (
            modalDados
                .classList
                .contains(
                    "active"
                )
        ) {

            fecharModalDados();
        }


        if (
            modalSenha
                .classList
                .contains(
                    "active"
                )
        ) {

            fecharModalSenha();
        }

    }
);

// LOGOUT
const sair =
    document.getElementById(
        "sair"
    );


if (sair) {

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

// INICIAR PÁGINA
async function iniciarPagina() {

    await carregarUsuario();
}


iniciarPagina();