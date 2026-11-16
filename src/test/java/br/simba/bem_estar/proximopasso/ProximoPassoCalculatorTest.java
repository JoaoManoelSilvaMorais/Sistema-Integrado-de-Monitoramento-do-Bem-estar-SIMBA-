package br.simba.bem_estar.proximopasso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.conquista.ConquistaDTO;
import br.simba.bem_estar.meta.MetaDTO;
import br.simba.bem_estar.streak.StreakDTO;

class ProximoPassoCalculatorTest {

    private static StreakDTO streak(boolean emRisco, boolean ultimaChance, int atual,
            boolean aguaHoje, boolean sonoHoje, boolean treinoHoje) {
        return new StreakDTO(atual, atual, aguaHoje || sonoHoje || treinoHoje,
                emRisco, emRisco ? (ultimaChance ? 2 : 1) : 0, ultimaChance,
                aguaHoje, sonoHoje, treinoHoje);
    }

    private static MetaDTO meta(String titulo, int atual, int alvo, String unidade, boolean concluida) {
        return new MetaDTO(1L, "TREINO_TOTAL", titulo, "fa-dumbbell", alvo, atual, atual,
                unidade, concluida, LocalDate.of(2026, 11, 1), null, false, alvo + 5);
    }

    private static ConquistaDTO conquista(String nome, int atual, int meta, String unidade, boolean desbloqueada) {
        return new ConquistaDTO("COD", nome, "desc", "Cat", "fa-trophy",
                desbloqueada, null, atual, meta, unidade, false);
    }

    @Test
    void ofensivaEmRiscoTemPrioridadeMaximaEEscolhePaginaFaltante() {
        StreakDTO sRisco = streak(true, false, 1, false, true, true);
        ProximoPassoDTO p1 = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(sRisco, 0, 2000, List.of(), List.of()));

        assertEquals("risco", p1.tipo());
        assertEquals("hidratacao.html", p1.link());
        assertTrue(p1.texto().contains("1 dia está em risco"));

        StreakDTO sUltima = streak(true, true, 5, true, false, true);
        ProximoPassoDTO p2 = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(sUltima, 2000, 2000, List.of(), List.of()));

        assertEquals("risco", p2.tipo());
        assertEquals("sono.html", p2.link());
        assertTrue(p2.texto().contains("Última chance"));
        assertTrue(p2.texto().contains("5 dias"));

        StreakDTO sSoFaltaTreino = streak(true, false, 3, true, true, false);
        assertEquals("treinos.html", ProximoPassoCalculator.paginaParaRegistrar(sSoFaltaTreino));
    }

    @Test
    void quaseLaPriorizaMetaOuConquistaMaisAdiantada() {
        StreakDTO ok = streak(false, false, 3, true, false, false);
        MetaDTO metaQuase = meta("Fazer 5 treinos", 4, 5, "treinos", false); // 80% e falta 1
        ConquistaDTO conquistaMenos = conquista("Em ritmo", 8, 10, "treinos", false); // 80% (empate favorece meta)

        ProximoPassoDTO passoMeta = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 0, 2000, List.of(metaQuase), List.of(conquistaMenos)));

        assertEquals("quase", passoMeta.tipo());
        assertEquals("conquistas.html#metas", passoMeta.link());
        assertTrue(passoMeta.texto().contains("Falta 1 treino para sua meta"));

        // Conquista a 90% vence meta a 80%
        ConquistaDTO conquista90 = conquista("Oásis", 9, 10, "dias", false);
        ProximoPassoDTO passoConquista = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 0, 2000, List.of(metaQuase), List.of(conquista90)));

        assertEquals("quase", passoConquista.tipo());
        assertEquals("conquistas.html", passoConquista.link());
        assertTrue(passoConquista.texto().contains("Falta 1 dia para a conquista Oásis"));
    }

    @Test
    void aguaDeHojeVemDepoisDeQuaseLa() {
        StreakDTO ok = streak(false, false, 1, false, false, false);

        ProximoPassoDTO zeroAgua = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 0, 2500, List.of(), List.of()));
        assertEquals("agua", zeroAgua.tipo());
        assertEquals("hidratacao.html", zeroAgua.link());
        assertTrue(zeroAgua.texto().contains("2.500 ml"));

        ProximoPassoDTO parcial = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 1800, 2500, List.of(), List.of()));
        assertEquals("agua", parcial.tipo());
        assertTrue(parcial.texto().contains("700 ml"));
    }

    @Test
    void metaAtivaVemQuandoAguaEstaBatida() {
        StreakDTO ok = streak(false, false, 2, true, false, false);
        MetaDTO ativa = meta("Fazer 10 treinos", 3, 10, "treinos", false);
        MetaDTO concluida = meta("Fazer 5 treinos", 5, 5, "treinos", true);

        ProximoPassoDTO passo = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 2000, 2000, List.of(concluida, ativa), List.of()));

        assertEquals("meta", passo.tipo());
        assertTrue(passo.texto().contains("3/10 treinos"));
    }

    @Test
    void conquistaProximaQuandoNaoHaMetaAtiva() {
        StreakDTO ok = streak(false, false, 2, true, false, false);
        ConquistaDTO cinquentaPorCento = conquista("Fornalha", 500, 1000, "kcal", false);
        ConquistaDTO ignoradaMeta1 = conquista("Primeiro gole", 0, 1, "", false);

        ProximoPassoDTO passo = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 2000, 2000, List.of(), List.of(ignoradaMeta1, cinquentaPorCento)));

        assertEquals("conquista", passo.tipo());
        assertTrue(passo.texto().contains("Faltam 500 kcal para a conquista Fornalha"));
    }

    @Test
    void tudoEmDiaQuandoNaoHaPendencias() {
        StreakDTO ok = streak(false, false, 5, true, true, true);

        ProximoPassoDTO passo = ProximoPassoCalculator.escolher(
                new ProximoPassoCalculator.Entrada(ok, 2200, 2000, List.of(), List.of()));

        assertEquals("ok", passo.tipo());
        assertNull(passo.link());
    }

    @Test
    void formatacoesAuxiliaresDeFaltamEMl() {
        assertEquals("Falta 1 dia", ProximoPassoCalculator.faltam(1, "dias"));
        assertEquals("Faltam 3 dias", ProximoPassoCalculator.faltam(3, "dias"));
        assertEquals("Falta 1 ml", ProximoPassoCalculator.faltam(1, "ml"));
        assertEquals("Faltam 500", ProximoPassoCalculator.faltam(500, null));

        assertEquals("750 ml", ProximoPassoCalculator.ml(750));
        assertEquals("2.050 ml", ProximoPassoCalculator.ml(2050));
    }
}
