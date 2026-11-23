/*
 * Proteção das telas internas do SIMBA.
 *
 * Incluir no <head> de toda tela que exige login (antes dos outros scripts):
 *     <script src="js/protecao.js"></script>
 *
 * - Sem token (ou com token vencido), manda para a tela Entrar antes de mostrar a página.
 * - O link "Sair" (#sair) passa a apagar o token em todas as telas.
 *
 * O back-end continua protegendo os dados (JWT); isto só evita mostrar uma tela vazia
 * para quem não entrou.
 */
(function () {
    "use strict";

    function lerToken() {
        try { return sessionStorage.getItem("jwtToken"); } catch (e) { return null; }
    }

    function limparSessao() {
        try {
            sessionStorage.removeItem("jwtToken");
            sessionStorage.removeItem("usuarioLogado");
        } catch (e) { /* sem armazenamento: nada a limpar */ }
    }

    // O JWT tem 3 partes; a do meio traz "exp" (segundos desde 1970).
    function tokenVencido(token) {
        try {
            const parte = token.split(".")[1].replace(/-/g, "+").replace(/_/g, "/");
            const dados = JSON.parse(atob(parte));
            return typeof dados.exp === "number" && dados.exp * 1000 <= Date.now();
        } catch (e) {
            return false; // formato inesperado: deixa o back-end decidir
        }
    }

    const token = lerToken();
    if (!token || tokenVencido(token)) {
        limparSessao();
        location.replace("entrar.html");
        return;
    }

    document.addEventListener("DOMContentLoaded", function () {
        const sair = document.getElementById("sair");
        if (sair) sair.addEventListener("click", limparSessao);
    });
})();
