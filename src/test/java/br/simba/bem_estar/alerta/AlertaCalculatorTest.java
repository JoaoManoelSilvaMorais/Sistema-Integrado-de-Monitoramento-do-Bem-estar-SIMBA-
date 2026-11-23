package br.simba.bem_estar.alerta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.historico.Historico;

class AlertaCalculatorTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 11, 16);
    private static final int META = 2500;

    // ---------- auxiliares ----------

    /** Noite que termina de manhã em {@code dia}, com a duração e a nota informadas. */
    private static Historico.Sono noite(LocalDate dia, int horas, Integer nota) {
        LocalDateTime acordar = dia.atTime(7, 0);
        return new Historico.Sono(acordar.minusHours(horas), acordar, nota);
    }

    private static Historico.Agua agua(LocalDate dia, double ml) {
        return new Historico.Agua(dia.atTime(12, 0), ml);
    }

    private static Historico.Treino treino(LocalDate dia) {
        return new Historico.Treino("Corrida", 30, 300, dia.atTime(18, 0));
    }

    private static Historico historico(List<Historico.Agua> agua, List<Historico.Sono> sono,
            List<Historico.Treino> treinos) {
        return new Historico(agua, sono, treinos);
    }

    private static boolean temAlerta(List<AlertaDTO> alertas, TipoAlerta tipo) {
        return alertas.stream().anyMatch(a -> a.tipo() == tipo);
    }

    /** Quatro noites ruins seguidas, terminando em {@code ultimoDia}. */
    private static List<Historico.Sono> quatroNoitesRuins(LocalDate ultimoDia) {
        List<Historico.Sono> noites = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            noites.add(noite(ultimoDia.minusDays(i), 5, 2));
        }
        return noites;
    }

    // ---------- geral ----------

    @Test
    void historicoVazioNaoGeraAlertas() {
        var alertas = AlertaCalculator.calcular(historico(List.of(), List.of(), List.of()), META, HOJE);
        assertTrue(alertas.isEmpty());
    }

    @Test
    void alertaTrazOrientacaoEAvisoPreventivo() {
        var h = historico(List.of(), quatroNoitesRuins(HOJE), List.of());
        var alertas = AlertaCalculator.calcular(h, META, HOJE);
        assertEquals(1, alertas.size());
        assertFalse(alertas.get(0).titulo().isBlank());
        assertFalse(alertas.get(0).mensagem().isBlank());
        assertTrue(alertas.get(0).orientacao().contains("profissional de saúde"));
        assertTrue(AlertaCalculator.AVISO.contains("não substituem"));
    }

    // ---------- sono ----------

    @Test
    void quatroNoitesCurtasGeramAlertaDeSono() {
        var h = historico(List.of(), quatroNoitesRuins(HOJE.minusDays(1)), List.of());
        assertTrue(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    @Test
    void notaBaixaContaComoNoiteRuimMesmoComOitoHoras() {
        List<Historico.Sono> noites = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            noites.add(noite(HOJE.minusDays(i), 8, 1));
        }
        var h = historico(List.of(), noites, List.of());
        assertTrue(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    @Test
    void umaNoiteBoaEntreAsQuatroDesfazOAlerta() {
        List<Historico.Sono> noites = quatroNoitesRuins(HOJE);
        noites.set(2, noite(HOJE.minusDays(2), 8, 5));
        var h = historico(List.of(), noites, List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    @Test
    void menosDeQuatroNoitesNaoGeraAlerta() {
        List<Historico.Sono> noites = quatroNoitesRuins(HOJE).subList(0, 3);
        var h = historico(List.of(), noites, List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    @Test
    void noitesRuinsAntigasNaoGeramAlerta() {
        var h = historico(List.of(), quatroNoitesRuins(HOJE.minusDays(10)), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    @Test
    void cochiloNoMesmoDiaNaoViraUmaNoiteExtra() {
        // 3 noites ruins + um cochilo no mesmo dia da noite mais recente: continuam sendo 3 dias.
        List<Historico.Sono> noites = quatroNoitesRuins(HOJE).subList(0, 3);
        List<Historico.Sono> comCochilo = new ArrayList<>(noites);
        comCochilo.add(new Historico.Sono(HOJE.atTime(14, 0), HOJE.atTime(14, 40), 3));
        var h = historico(List.of(), comCochilo, List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    @Test
    void registroDeSonoSemHorarioEIgnorado() {
        List<Historico.Sono> noites = new ArrayList<>(quatroNoitesRuins(HOJE));
        noites.add(new Historico.Sono(null, null, 1));
        var h = historico(List.of(), noites, List.of());
        assertTrue(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.SONO));
    }

    // ---------- água ----------

    @Test
    void tresDiasAbaixoDeMetadeDaMetaGeramAlertaDeAgua() {
        var aguas = List.of(
                agua(HOJE.minusDays(1), 1000),
                agua(HOJE.minusDays(2), 800),
                agua(HOJE.minusDays(3), 1200));
        var h = historico(aguas, List.of(), List.of());
        assertTrue(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.AGUA));
    }

    @Test
    void umDiaComPelomenosMetadeDaMetaDesfazOAlerta() {
        var aguas = List.of(
                agua(HOJE.minusDays(1), 1000),
                agua(HOJE.minusDays(2), 1250), // exatamente 50%: não é "abaixo"
                agua(HOJE.minusDays(3), 1200));
        var h = historico(aguas, List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.AGUA));
    }

    @Test
    void aguaSomaOsRegistrosDoMesmoDia() {
        var aguas = List.of(
                agua(HOJE.minusDays(1), 800), agua(HOJE.minusDays(1), 800), // 1600 ml no dia
                agua(HOJE.minusDays(2), 500),
                agua(HOJE.minusDays(3), 500));
        var h = historico(aguas, List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.AGUA));
    }

    @Test
    void hojeAindaNaoContaParaAAgua() {
        var aguas = List.of(
                agua(HOJE, 100), // dia em andamento: ignorado
                agua(HOJE.minusDays(1), 1000),
                agua(HOJE.minusDays(2), 800));
        var h = historico(aguas, List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.AGUA));
    }

    @Test
    void diasSemRegistroDeAguaNaoContamComoDiaBaixo() {
        // Só 2 dias com registro: não há base para avisar.
        var aguas = List.of(agua(HOJE.minusDays(1), 100), agua(HOJE.minusDays(5), 100));
        var h = historico(aguas, List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.AGUA));
    }

    @Test
    void aguaAntigaNaoGeraAlerta() {
        var aguas = List.of(
                agua(HOJE.minusDays(10), 100),
                agua(HOJE.minusDays(11), 100),
                agua(HOJE.minusDays(12), 100));
        var h = historico(aguas, List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.AGUA));
    }

    @Test
    void metaInvalidaNaoGeraAlertaDeAgua() {
        var aguas = List.of(
                agua(HOJE.minusDays(1), 0.5),
                agua(HOJE.minusDays(2), 0.5),
                agua(HOJE.minusDays(3), 0.5));
        var h = historico(aguas, List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, 0, HOJE), TipoAlerta.AGUA));
    }

    // ---------- treino ----------

    /** Água todos os dias, de {@code diasAtras} dias atrás até ontem: só para simular tempo de uso. */
    private static List<Historico.Agua> usoDeAgua(int diasAtras) {
        List<Historico.Agua> aguas = new ArrayList<>();
        for (int i = diasAtras; i >= 1; i--) {
            aguas.add(agua(HOJE.minusDays(i), 2500));
        }
        return aguas;
    }

    @Test
    void catorzeDiasSemTreinoGeramAlertaParaQuemUsaHaMaisTempo() {
        var h = historico(usoDeAgua(20), List.of(), List.of(treino(HOJE.minusDays(20))));
        assertTrue(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.TREINO));
    }

    @Test
    void quemNuncaTreinouMasUsaHaMaisDeCatorzeDiasTambemRecebeAlerta() {
        var h = historico(usoDeAgua(20), List.of(), List.of());
        assertTrue(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.TREINO));
    }

    @Test
    void treinoRecenteDesfazOAlertaDeTreino() {
        var h = historico(usoDeAgua(20), List.of(), List.of(treino(HOJE.minusDays(5))));
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.TREINO));
    }

    @Test
    void treinoNoLimiteDeCatorzeDiasAindaContaComoRecente() {
        // Janela = hoje e os 13 dias anteriores (14 dias no total).
        var h = historico(usoDeAgua(20), List.of(), List.of(treino(HOJE.minusDays(13))));
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.TREINO));
    }

    @Test
    void quemUsaOAppHaPoucosDiasNaoRecebeAlertaDeTreino() {
        var h = historico(usoDeAgua(5), List.of(), List.of());
        assertFalse(temAlerta(AlertaCalculator.calcular(h, META, HOJE), TipoAlerta.TREINO));
    }

    // ---------- combinação ----------

    @Test
    void variosAlertasPodemAparecerJuntos() {
        // Sono ruim + água baixa nos últimos dias, e um mês sem treinar.
        List<Historico.Agua> aguas = new ArrayList<>(usoDeAgua(30));
        aguas.removeIf(a -> a.dataHora().toLocalDate().isAfter(HOJE.minusDays(4)));
        aguas.add(agua(HOJE.minusDays(1), 500));
        aguas.add(agua(HOJE.minusDays(2), 500));
        aguas.add(agua(HOJE.minusDays(3), 500));
        var h = historico(aguas, quatroNoitesRuins(HOJE.minusDays(1)), List.of());
        var alertas = AlertaCalculator.calcular(h, META, HOJE);
        assertEquals(3, alertas.size());
        assertTrue(temAlerta(alertas, TipoAlerta.SONO));
        assertTrue(temAlerta(alertas, TipoAlerta.AGUA));
        assertTrue(temAlerta(alertas, TipoAlerta.TREINO));
    }
}
