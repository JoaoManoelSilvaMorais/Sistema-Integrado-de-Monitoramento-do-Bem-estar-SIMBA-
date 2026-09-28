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
