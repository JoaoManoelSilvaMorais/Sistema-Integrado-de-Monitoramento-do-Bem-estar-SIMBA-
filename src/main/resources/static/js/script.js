const sidebar = document.getElementById("sidebar");
const menuButton = document.getElementById("menuButton");
const overlay = document.getElementById("overlay");

menuButton.addEventListener("click", () => {
    sidebar.classList.toggle("open");
    overlay.classList.toggle("active");
});

overlay.addEventListener("click", () => {
    sidebar.classList.remove("open");
    overlay.classList.remove("active");
});

(function configurarAvatarPerfil() {

    const avatar =
        document.getElementById(
            "avatarUsuario"
        );

    if (!avatar) {
        return;
    }


    avatar.style.cursor =
        "pointer";


    avatar.setAttribute(
        "role",
        "button"
    );


    avatar.setAttribute(
        "tabindex",
        "0"
    );


    avatar.setAttribute(
        "title",
        "Meu perfil"
    );


    function abrirPerfil() {

        window.location.href =
            "perfil.html";
    }


    avatar.addEventListener(
        "click",
        abrirPerfil
    );


    avatar.addEventListener(
        "keydown",
        event => {

            if (
                event.key === "Enter" ||
                event.key === " "
            ) {

                event.preventDefault();

                abrirPerfil();
            }

        }
    );

})();