package br.simba.bem_estar.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Testes Ponta a Ponta de Conquistas, Metas Pessoais e Progresso pelas interfaces web.
 */
class ConquistasProgressoE2ETest extends BaseE2ETest {

    @Test
    void conquistasMetasCriacaoExclusaoEFiltrosAposRegistrarAgua() {
        cadastrarEEntrarViaInterface("João Pedro", "joaopedro", "jp@simba.com", "senha123");

        // Registra +250 ml rápido no dashboard para desbloquear a primeira conquista de água
        clicar(By.id("btnAguaRapida"));
        esperarTexto(By.id("resumoAgua"), "0.3 L");

        abrir("/conquistas.html");
        esperarTexto(By.id("totalConquistas"), "26");
        espera.until(d -> {
            String texto = d.findElement(By.id("totalDesbloqueadas")).getText();
            return !texto.equals("--") && Integer.parseInt(texto.trim()) >= 1;
        });

        // Cria uma meta pessoal pelo formulário
        preencherSelectPorValor(By.id("tipoMeta"), "AGUA_SEGUIDOS");
        preencher(By.id("alvoMeta"), "7");
        clicar(By.cssSelector("#formMeta button[type='submit']"));

        esperarTexto(By.id("msgMetas"), "Meta criada");
        WebElement metaItem = esperarVisivel(By.cssSelector("#listaMetas .meta-item"));
        assertTrue(metaItem.getText().contains("0/7"));

        // Filtra apenas conquistas desbloqueadas e depois apenas bloqueadas
        clicar(By.cssSelector("#filtros button[data-filtro='desbloqueadas']"));
        int totalDesbloqueadas = driver.findElements(By.cssSelector("#listaConquistas .conq-card.desbloqueada")).size();
        assertTrue(totalDesbloqueadas >= 1);
        assertEquals(0, driver.findElements(By.cssSelector("#listaConquistas .conq-card.bloqueada")).size());

        clicar(By.cssSelector("#filtros button[data-filtro='bloqueadas']"));
        assertTrue(driver.findElements(By.cssSelector("#listaConquistas .conq-card.bloqueada")).size() > 0);
        assertEquals(0, driver.findElements(By.cssSelector("#listaConquistas .conq-card.desbloqueada")).size());

        // Remove a meta criada
        clicar(By.cssSelector("#listaMetas .meta-item .meta-acoes button"));
        aceitarAlerta();
        esperarTexto(By.id("msgMetas"), "Meta removida");
        espera.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#listaMetas .meta-item"), 0));
    }

    @Test
    void progressoExibeResumoComparativoSemanalETrocaPeriodo() {
        cadastrarEEntrarViaInterface("Karina Alves", "karinaalves", "karina@simba.com", "senha123");

        // Gera atividade real pela UI antes de abrir Progresso
        clicar(By.id("btnAguaRapida"));
        esperarTexto(By.id("resumoAgua"), "0.3 L");

        abrir("/progresso.html");
        esperarVisivel(By.id("mediaHidratacaoResumo"));
        espera.until(d -> d.findElements(By.cssSelector("#comparativoGrade .comparativo-card")).size() == 4);

        WebElement botao7Dias = esperarClicavel(By.cssSelector("#periodoFiltro .periodo-btn[data-dias='7']"));
        clicarElemento(botao7Dias);
        espera.until(d -> d.findElement(By.cssSelector("#periodoFiltro .periodo-btn[data-dias='7']"))
                .getAttribute("class").contains("active"));

        assertTrue(esperarVisivel(By.id("comparativo")).isDisplayed());
        assertTrue(esperarVisivel(By.id("heatmapTreinos")).isDisplayed());
    }
}
