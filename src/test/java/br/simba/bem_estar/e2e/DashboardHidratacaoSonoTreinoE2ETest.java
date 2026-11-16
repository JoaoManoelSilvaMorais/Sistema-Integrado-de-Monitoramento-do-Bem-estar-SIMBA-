package br.simba.bem_estar.e2e;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Testes Ponta a Ponta do Dashboard, Hidratação, Sono e Treinos pelas interfaces web.
 */
class DashboardHidratacaoSonoTreinoE2ETest extends BaseE2ETest {

    @Test
    void dashboardAdicaoRapidaDeAguaAtualizaResumoEStreak() {
        cadastrarEEntrarViaInterface("Carla Dias", "carladias", "carla@simba.com", "senha123");

        esperarTexto(By.id("nomeUsuario"), "Carla");
        esperarTexto(By.id("streakNumero"), "0");
        esperarVisivel(By.id("proximoPassoTexto"));

        clicar(By.id("btnAguaRapida"));

        esperarTexto(By.id("resumoAgua"), "0.3 L");
        esperarTexto(By.id("streakNumero"), "1");
    }

    @Test
    void hidratacaoFluxoCompletoAdicaoRapidaModalEdicaoExclusaoEMeta() {
        cadastrarEEntrarViaInterface("Diego Souza", "diegosouza", "diego@simba.com", "senha123");
        abrir("/hidratacao.html");

        // Adição rápida (+200 ml)
        clicar(By.cssSelector(".btn-agua-rapido[data-quantidade='200']"));
        esperarTexto(By.id("quantidadeHoje"), "200");

        // Modal de novo registro (+200 ml -> total 400)
        String agora = formatarDataHoraIso(LocalDateTime.now());
        clicar(By.id("btnAdicionarRegistro"));
        esperarVisivel(By.cssSelector("#modalOverlay.active"));
        preencher(By.id("quantidadeMl"), "200");
        preencherDataHora(By.id("dataHora"), agora);
        clicar(By.cssSelector("#formHidratacao .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalOverlay.active")));
        esperarTexto(By.id("quantidadeHoje"), "400");

        // Expande lançamentos do dia e edita um registro para 350 ml (200 + 350 = 550)
        clicar(By.cssSelector(".dia-card .btn-editar-dia"));
        esperarVisivel(By.cssSelector(".dia-card.aberto .btn-registro-editar"));
        clicar(By.cssSelector(".dia-card.aberto .btn-registro-editar"));
        esperarVisivel(By.cssSelector("#modalOverlay.active"));
        preencher(By.id("quantidadeMl"), "350");
        clicar(By.cssSelector("#formHidratacao .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalOverlay.active")));
        esperarTexto(By.id("quantidadeHoje"), "550");

        // Exclui um lançamento do dia e valida redução do total consumido (200 ou 350 ml)
        clicar(By.cssSelector(".dia-card .btn-editar-dia"));
        clicar(By.cssSelector(".dia-card.aberto .btn-registro-excluir"));
        aceitarAlerta();
        espera.until(d -> {
            String texto = d.findElement(By.id("quantidadeHoje")).getText();
            return texto.contains("200") || texto.contains("350");
        });

        // Personaliza meta diária de água e depois restaura meta sugerida
        clicar(By.id("btnEditarMetaAgua"));
        esperarVisivel(By.cssSelector("#modalMetaAgua.active"));
        preencher(By.id("metaAguaInput"), "2800");
        clicar(By.cssSelector("#formMetaAgua .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalMetaAgua.active")));
        esperarTexto(By.id("metaHoje"), "2.800");

        clicar(By.id("btnEditarMetaAgua"));
        esperarVisivel(By.cssSelector("#modalMetaAgua.active"));
        clicar(By.id("btnMetaAguaSugerida"));
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalMetaAgua.active")));
    }

    @Test
    void sonoFluxoCompletoPlanejadorRegistroEdicaoEExclusao() {
        cadastrarEEntrarViaInterface("Elena Gomes", "elenagomes", "elena@simba.com", "senha123");
        abrir("/sono.html");

        // Planejador de ciclos de sono
        preencherDataHora(By.id("horaPlanejada"), "07:00");
        clicar(By.id("btnCalcularSono"));
        esperarVisivel(By.cssSelector("#resultadoPlanejador.active"));
        assertTrue(esperarVisivel(By.id("horario5Ciclos")).getText().contains(":"));
        assertTrue(esperarVisivel(By.id("horario6Ciclos")).getText().contains(":"));
        assertTrue(esperarVisivel(By.id("horario7Ciclos")).getText().contains(":"));

        // Novo registro de sono
        String ontem = formatarDataHoraIso(LocalDate.now().minusDays(1).atTime(23, 0));
        String hoje = formatarDataHoraIso(LocalDate.now().atTime(7, 0));

        clicar(By.id("btnNovoSono"));
        esperarVisivel(By.cssSelector("#modalOverlay.active"));
        preencherDataHora(By.id("horaDormir"), ontem);
        preencherDataHora(By.id("horaAcordar"), hoje);
        clicar(By.cssSelector(".nota-button[data-nota='4']"));
        esperarTexto(By.id("duracaoCalculada"), "8h 00min");
        clicar(By.cssSelector("#formSono .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalOverlay.active")));
        esperarTexto(By.id("totalRegistros"), "1");
        WebElement cardSono = esperarVisivel(By.cssSelector(".sono-card"));
        assertTrue(cardSono.getText().contains("8h 00min"));
        assertTrue(cardSono.getText().contains("4/5"));

        // Edição da nota para 5/5
        clicar(By.cssSelector(".sono-card .btn-editar"));
        esperarVisivel(By.cssSelector("#modalOverlay.active"));
        clicar(By.cssSelector(".nota-button[data-nota='5']"));
        clicar(By.cssSelector("#formSono .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalOverlay.active")));
        esperarTexto(By.cssSelector(".sono-card"), "5/5");

        // Exclusão do registro
        clicar(By.cssSelector(".sono-card .btn-excluir"));
        aceitarAlerta();
        esperarTexto(By.id("totalRegistros"), "0");
        esperarVisivel(By.id("sonoVazio"));
    }

    @Test
    void treinosFluxoCompletoCadastroEdicaoEExclusao() {
        cadastrarEEntrarViaInterface("Fabio Rocha", "fabiorocha", "fabio@simba.com", "senha123");
        abrir("/treinos.html");

        String horarioTreino = formatarDataHoraIso(LocalDate.now().atTime(8, 30));
        clicar(By.id("btnNovoTreino"));
        esperarVisivel(By.cssSelector("#modalOverlay.active"));
        preencherSelectPorValor(By.id("modalidade"), "Corrida");
        preencher(By.id("duracao"), "45");
        preencher(By.id("gastoCalorico"), "420");
        preencherDataHora(By.id("dataHora"), horarioTreino);
        clicar(By.cssSelector("#formTreino .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalOverlay.active")));
        esperarTexto(By.id("totalTreinos"), "1");
        esperarTexto(By.id("tempoTotal"), "45 min");
        WebElement cardTreino = esperarVisivel(By.cssSelector(".treino-card"));
        assertTrue(cardTreino.getText().contains("Corrida"));

        // Edita duração e calorias
        clicar(By.cssSelector(".treino-card .btn-editar"));
        esperarVisivel(By.cssSelector("#modalOverlay.active"));
        preencher(By.id("duracao"), "60");
        preencher(By.id("gastoCalorico"), "550");
        clicar(By.cssSelector("#formTreino .btn-salvar"));

        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#modalOverlay.active")));
        esperarTexto(By.id("tempoTotal"), "60 min");

        // Exclui treino
        clicar(By.cssSelector(".treino-card .btn-excluir"));
        aceitarAlerta();
        esperarTexto(By.id("totalTreinos"), "0");
        esperarVisivel(By.id("treinosVazio"));
    }
}
