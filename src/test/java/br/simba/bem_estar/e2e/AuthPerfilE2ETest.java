package br.simba.bem_estar.e2e;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Testes Ponta a Ponta de cadastro, login, edição de perfil, medidas/IMC com criação
 * de meta sugerida, alteração de senha e logout pelas telas web reais.
 */
class AuthPerfilE2ETest extends BaseE2ETest {

    @Test
    void cadastroComSenhasDivergentesExibeToastDeErro() {
        abrir("/login.html");

        preencher(By.id("nome"), "Ana Paula");
        preencher(By.id("username"), "anapaula");
        preencher(By.id("email"), "ana@simba.com");
        preencher(By.id("senha"), "senha123");
        preencher(By.id("confirma_senha"), "outra123");
        clicar(By.cssSelector("button.btn-submit"));

        WebElement toastErro = esperarVisivel(By.cssSelector(".toast.erro"));
        assertTrue(toastErro.getText().contains("As senhas não coincidem"));
        assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @Test
    void fluxoCompletoCadastroLoginPerfilMedidasTrocaSenhaELogout() {
        cadastrarViaInterface("Lucas Lima", "lucaslima", "lucas@simba.com", "segredo123");

        // Senha incorreta exibe feedback visual e mantém o usuário na tela de entrada
        abrir("/entrar.html");
        preencher(By.id("username"), "lucaslima");
        preencher(By.id("senha"), "errada999");
        clicar(By.cssSelector("button.btn-submit"));
        WebElement toastLoginErro = esperarVisivel(By.cssSelector(".toast.erro"));
        assertTrue(toastLoginErro.getText().contains("Não foi possível entrar"));

        // Login válido redireciona ao dashboard autenticado
        entrarViaInterface("lucaslima", "segredo123");
        esperarTexto(By.id("nomeUsuario"), "Lucas");
        assertTrue(espera.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loginButton"))));

        // Navega para a tela de perfil clicando no avatar do cabeçalho
        clicar(By.id("avatarUsuario"));
        esperarUrlContendo("perfil.html");
        esperarTexto(By.id("nomeInfo"), "Lucas Lima");
        esperarTexto(By.id("usernameInfo"), "lucaslima");

        // Edita informações pessoais pelo modal e valida novo token/dados exibidos
        clicar(By.id("btnEditarDados"));
        esperarVisivel(By.cssSelector("#modalDados.active"));
        preencher(By.id("nomeInput"), "Lucas Atualizado");
        preencher(By.id("usernameInput"), "lucasnovo");
        preencher(By.id("emailInput"), "lucas.novo@simba.com");
        clicar(By.cssSelector("#formDados button[type='submit']"));

        esperarTexto(By.id("nomeInfo"), "Lucas Atualizado");
        esperarTexto(By.id("usernameInfo"), "lucasnovo");
        esperarTexto(By.id("emailInfo"), "lucas.novo@simba.com");

        // Abre modal de Peso e Altura, confere cálculo prévio de IMC, cria meta sugerida e salva
        clicar(By.id("btnEditarMedidas"));
        esperarVisivel(By.cssSelector("#modalMedidas.active"));
        preencher(By.id("pesoInput"), "75");
        preencher(By.id("alturaInput"), "180");

        espera.until(d -> d.findElement(By.id("imcValor")).getText().contains("23"));
        assertTrue(esperarVisivel(By.id("imcFaixa")).getText().toLowerCase().contains("adequado"));

        WebElement btnCriarMeta = esperarClicavel(By.cssSelector("#sugestoesLista .sugestao-btn"));
        clicarElemento(btnCriarMeta);
        esperarVisivel(By.cssSelector("#sugestoesLista .sugestao-meta-ativa"));

        clicar(By.id("btnSalvarMedidas"));
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalMedidas.active")));
        espera.until(d -> d.findElement(By.id("resumoMedidas")).getText().contains("75"));

        // Altera a senha pelo modal
        clicar(By.id("btnAlterarSenha"));
        esperarVisivel(By.cssSelector("#modalSenha.active"));
        preencher(By.id("senhaAtual"), "segredo123");
        preencher(By.id("novaSenha"), "novaSenha456");
        preencher(By.id("confirmarSenha"), "novaSenha456");
        clicar(By.cssSelector("#formSenha button[type='submit']"));
        esperarTexto(By.id("perfilMensagemTexto"), "sucesso");

        // Sai pela opção do menu lateral e autentica com as novas credenciais
        clicar(By.id("sair"));
        esperarUrlContendo("entrar.html");
        Object tokenAposSaida = ((JavascriptExecutor) driver).executeScript(
                "return sessionStorage.getItem('jwtToken');");
        assertNull(tokenAposSaida);

        entrarViaInterface("lucasnovo", "novaSenha456");
        esperarTexto(By.id("nomeUsuario"), "Lucas Atualizado");
    }
}
