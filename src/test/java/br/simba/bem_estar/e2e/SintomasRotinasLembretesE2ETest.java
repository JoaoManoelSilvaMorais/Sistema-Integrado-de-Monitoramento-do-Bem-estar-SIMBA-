package br.simba.bem_estar.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Testes Ponta a Ponta de Sinais Corporais, Rotinas e Lembretes pelas interfaces web.
 */
class SintomasRotinasLembretesE2ETest extends BaseE2ETest {

    @Test
    void sinaisCorporaisPreenchimentoEdicaoEHistoricoSemanal() {
        cadastrarEEntrarViaInterface("Gabriela Teles", "gabrielat", "gabi@simba.com", "senha123");
        abrir("/sintomas.html");

        esperarVisivel(By.id("formSintomas"));

        clicar(By.cssSelector(".sx-escala[data-campo='energia'] .sx-opcao[data-valor='4']"));
        clicar(By.cssSelector(".sx-escala[data-campo='humor'] .sx-opcao[data-valor='5']"));
        clicar(By.cssSelector(".sx-escala[data-campo='estresse'] .sx-opcao[data-valor='2']"));

        clicar(By.cssSelector("#opcoesDor .sx-segmento[data-valor='LEVE']"));
        WebElement localCabeca = esperarVisivel(By.cssSelector("#listaLocais input[value='CABECA']"));
        clicarElemento(localCabeca);
        clicar(By.id("btnLocais"));
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.id("listaLocais")));

        clicar(By.cssSelector("#opcoesSintomas .sx-chip[data-sintoma='CANSACO']"));
        preencher(By.id("observacao"), "Dormi um pouco tarde ontem");
        clicar(By.id("btnSalvar"));

        esperarVisivel(By.id("resumoHoje"));
        assertTrue(esperarVisivel(By.id("resumoDor")).getText().contains("Leve"));
        assertTrue(esperarVisivel(By.id("resumoDor")).getText().contains("Cabeça"));
        assertTrue(esperarVisivel(By.id("resumoSintomas")).getText().contains("Cansaço"));
        assertTrue(esperarVisivel(By.id("resumoObs")).getText().contains("Dormi um pouco tarde ontem"));

        esperarTexto(By.id("semanaDias"), "Respondeu 1 de 7 dias");
        assertEquals(1, driver.findElements(By.cssSelector("#listaHistorico .sx-dia")).size());

        // Edita o check-in de hoje removendo dor e marcando nenhum sintoma
        clicar(By.id("btnEditar"));
        esperarVisivel(By.id("formSintomas"));
        clicar(By.cssSelector("#opcoesDor .sx-segmento[data-valor='NENHUMA']"));
        clicar(By.cssSelector("#opcoesSintomas .sx-chip[data-sintoma='NENHUM']"));
        clicar(By.id("btnSalvar"));

        esperarVisivel(By.id("resumoHoje"));
        esperarTexto(By.id("resumoDor"), "Nenhuma");
        esperarTexto(By.id("resumoSintomas"), "Nenhum");
    }

    @Test
    void rotinasCriacaoLembreteRecorrenteAlternarStatusEExclusao() {
        cadastrarEEntrarViaInterface("Henrique Moura", "henriquem", "henrique@simba.com", "senha123");
        abrir("/rotinas.html");

        preencher(By.id("nome"), "Manhã produtiva");
        preencher(By.id("descricao"), "Água e alongamento");
        clicar(By.cssSelector("#formRotina button[type='submit']"));

        esperarTexto(By.id("totalRotinas"), "1");
        WebElement rotinaCard = esperarVisivel(By.cssSelector(".rotina-item"));
        assertTrue(rotinaCard.getText().contains("Manhã produtiva"));

        // Adiciona lembrete recorrente dentro da rotina (inputs de checkbox ficam ocultos dentro do label visível)
        preencher(By.cssSelector(".rotina-item form.form-lembrete input:not([type='time'])"), "Tomar água");
        preencherDataHora(By.cssSelector(".rotina-item form.form-lembrete input[type='time']"), "08:00");
        clicar(By.xpath("//article[contains(@class,'rotina-item')]//div[contains(@class,'dias-semana')]//label[input[@value='1']]"));
        clicar(By.xpath("//article[contains(@class,'rotina-item')]//div[contains(@class,'dias-semana')]//label[input[@value='3']]"));
        clicar(By.cssSelector(".rotina-item form.form-lembrete button[type='submit']"));

        WebElement lembreteItem = esperarVisivel(By.cssSelector(".rotina-item .lembrete-item"));
        assertTrue(lembreteItem.getText().contains("08:00"));
        assertTrue(lembreteItem.getText().contains("Tomar água"));

        // Desativa rotina
        clicar(By.cssSelector(".rotina-item .btn-status"));
        esperarVisivel(By.cssSelector(".rotina-item.inativa"));

        // Exclui lembrete da rotina e depois exclui a rotina inteira
        clicar(By.cssSelector(".rotina-item .lembrete-item .btn-excluir"));
        espera.until(ExpectedConditions.numberOfElementsToBe(
                By.cssSelector(".rotina-item .lembrete-item"), 0));

        clicar(By.cssSelector(".rotina-item .rotina-acoes .btn-excluir"));
        aceitarAlerta();
        esperarTexto(By.id("totalRotinas"), "0");
    }

    @Test
    void lembretesCriacaoNotificacaoHeaderEExclusao() {
        cadastrarEEntrarViaInterface("Isabela Pires", "isabelap", "isabela@simba.com", "senha123");
        abrir("/lembretes.html");

        String daquiDuasHoras = formatarDataHoraIso(LocalDateTime.now().plusHours(2));
        preencher(By.id("titulo"), "Alongar coluna");
        preencher(By.id("mensagem"), "Pausa de 5 minutos");
        preencherDataHora(By.id("horario"), daquiDuasHoras);
        clicar(By.cssSelector("#formLembrete button[type='submit']"));

        esperarTexto(By.id("totalLembretes"), "1");
        WebElement itemLembrete = esperarVisivel(By.cssSelector("#listaLembretes .reminder-item"));
        assertTrue(itemLembrete.getText().contains("Alongar coluna"));

        // Valida badge e dropdown de notificações do cabeçalho
        esperarTexto(By.id("badge-notificacao"), "1");
        clicar(By.id("btnNotificacao"));
        esperarTexto(By.id("dropdown-lista"), "Alongar coluna");

        // Exclui lembrete e confirma atualização do contador
        clicar(By.cssSelector("#listaLembretes .reminder-delete"));
        aceitarAlerta();
        esperarTexto(By.id("totalLembretes"), "0");
        esperarTexto(By.id("listaLembretes"), "Nenhum lembrete cadastrado");
    }
}
