package br.simba.bem_estar.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

/**
 * Teste Ponta a Ponta com o perfil {@code demo}, validando o usuário pré-carregado
 * ({@code demo / demo123}) em todas as telas principais.
 */
@ActiveProfiles("demo")
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:simba_demo_e2e;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"
})
class DemoFluxoE2ETest extends BaseE2ETest {

    @Override
    protected boolean deveLimparBancoAntesDoTeste() {
        return false;
    }

    @Test
    void usuarioDemoNavegaPelasTelasPopuladasEInterageComDashboard() {
        entrarViaInterface("demo", "demo123");

        // Dashboard inicial mostra ofensiva pré-populada e sugestão de próximo passo
        espera.until(d -> {
            String streak = d.findElement(By.id("streakNumero")).getText().trim();
            return !streak.isEmpty() && !streak.equals("0") && !streak.equals("--");
        });
        assertTrue(!esperarVisivel(By.id("proximoPassoTexto")).getText().isBlank());

        // Tela de Conquistas & Metas
        abrir("/conquistas.html");
        esperarTexto(By.id("totalConquistas"), "26");
        espera.until(d -> Integer.parseInt(d.findElement(By.id("totalDesbloqueadas")).getText().trim()) > 0);
        espera.until(d -> d.findElements(By.cssSelector("#listaMetas .meta-item")).size() == 2);

        // Tela de Progresso & Comparativo
        abrir("/progresso.html");
        espera.until(d -> d.findElements(By.cssSelector("#comparativoGrade .comparativo-card")).size() == 4);
        assertTrue(!esperarVisivel(By.id("mediaSonoResumo")).getText().isBlank());

        // Tela de Rotinas
        abrir("/rotinas.html");
        esperarTexto(By.id("totalRotinas"), "4");
        assertEquals(4, driver.findElements(By.cssSelector("#listaRotinas .rotina-item")).size());

        // Tela de Sinais Corporais (histórico semântico populado)
        abrir("/sintomas.html");
        espera.until(d -> d.findElements(By.cssSelector("#listaHistorico .sx-dia")).size() == 17);

        // Volta ao Dashboard e realiza registro rápido de água para salvar a ofensiva do dia
        abrir("/index.html");
        esperarVisivel(By.id("btnAguaRapida"));
        clicar(By.id("btnAguaRapida"));
        esperarTexto(By.id("resumoAgua"), "0.3 L");
    }
}
