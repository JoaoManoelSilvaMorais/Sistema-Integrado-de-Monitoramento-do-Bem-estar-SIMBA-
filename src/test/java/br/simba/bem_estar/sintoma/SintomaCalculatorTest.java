package br.simba.bem_estar.sintoma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.exceptions.RegraDeNegocioException;

/** Testes da regra pura (sem Spring): rodam rápido com .\mvnw test -Dtest=SintomaCalculatorTest */
class SintomaCalculatorTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 11, 8);

    private static RegistroSintomaDTO dto(Integer e, Integer h, Integer s, String dor,
            List<String> locais, List<String> sintomas, String obs) {
        return new RegistroSintomaDTO(e, h, s, dor, locais, sintomas, obs);
    }

    private static RegistroSintomaDTO valido() {
        return dto(3, 4, 2, "NENHUMA", null, List.of("NENHUM"), null);
    }

    // ---------------------------------------------------------------- validação

    @Test
    void aceitaRespostaValidaSemDor() {
        SintomaCalculator.Respostas r = SintomaCalculator.validar(valido());
        assertEquals(3, r.energia());
        assertEquals(NivelDor.NENHUMA, r.dor());
        assertTrue(r.locaisDor().isEmpty());
        assertEquals(List.of(Sintoma.NENHUM), r.sintomas());
        assertNull(r.observacao());
    }

    @Test
    void notasNosLimitesSaoAceitas() {
        SintomaCalculator.validar(dto(1, 5, 1, "NENHUMA", null, null, null));
        SintomaCalculator.validar(dto(5, 1, 5, "NENHUMA", null, null, null));
    }

    @Test
    void notaForaDoIntervaloOuNulaDaErro() {
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(dto(0, 3, 3, "NENHUMA", null, null, null)));
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(dto(3, 6, 3, "NENHUMA", null, null, null)));
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(dto(3, 3, null, "NENHUMA", null, null, null)));
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(null));
    }

    @Test
    void dorObrigatoriaEValida() {
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(dto(3, 3, 3, null, null, null, null)));
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(dto(3, 3, 3, "  ", null, null, null)));
        assertThrows(RegraDeNegocioException.class, () -> SintomaCalculator.validar(dto(3, 3, 3, "MUITA", null, null, null)));
    }

    @Test
    void dorSemLocalDaErro() {
        assertThrows(RegraDeNegocioException.class,
                () -> SintomaCalculator.validar(dto(3, 3, 3, "LEVE", List.of(), null, null)));
        assertThrows(RegraDeNegocioException.class,
                () -> SintomaCalculator.validar(dto(3, 3, 3, "FORTE", null, null, null)));
    }

    @Test
    void variosLocaisSemRepeticaoEMinusculasAceitas() {
        SintomaCalculator.Respostas r = SintomaCalculator.validar(
                dto(3, 3, 3, "moderada", List.of("cabeca", "COSTAS", "CABECA"), null, null));
        assertEquals(NivelDor.MODERADA, r.dor());
        assertEquals(List.of(LocalDor.CABECA, LocalDor.COSTAS), r.locaisDor());
    }

    @Test
    void localInvalidoDaErro() {
        assertThrows(RegraDeNegocioException.class,
                () -> SintomaCalculator.validar(dto(3, 3, 3, "LEVE", List.of("JOELHO"), null, null)));
    }

    @Test
    void semDorIgnoraLocaisEnviados() {
        SintomaCalculator.Respostas r = SintomaCalculator.validar(
                dto(3, 3, 3, "NENHUMA", List.of("CABECA"), null, null));
        assertTrue(r.locaisDor().isEmpty());
    }

    @Test
    void nenhumJuntoComOutroSintomaDaErro() {
        assertThrows(RegraDeNegocioException.class,
                () -> SintomaCalculator.validar(dto(3, 3, 3, "NENHUMA", null, List.of("NENHUM", "CANSACO"), null)));
    }

    @Test
    void listaDeSintomasVaziaViraNenhum() {
        assertEquals(List.of(Sintoma.NENHUM),
                SintomaCalculator.validar(dto(3, 3, 3, "NENHUMA", null, List.of(), null)).sintomas());
    }

    @Test
    void observacaoLimiteDe300() {
        String ok = "a".repeat(300);
        assertEquals(ok, SintomaCalculator.validar(dto(3, 3, 3, "NENHUMA", null, null, "  " + ok + " ")).observacao());
        assertThrows(RegraDeNegocioException.class,
                () -> SintomaCalculator.validar(dto(3, 3, 3, "NENHUMA", null, null, "a".repeat(301))));
        assertNull(SintomaCalculator.validar(dto(3, 3, 3, "NENHUMA", null, null, "   ")).observacao());
    }

    // ---------------------------------------------------------------- texto <-> lista

    @Test
    void textoIdaEVolta() {
        String texto = SintomaCalculator.paraTexto(List.of(LocalDor.CABECA, LocalDor.PERNAS));
        assertEquals("CABECA,PERNAS", texto);
        assertEquals(List.of(LocalDor.CABECA, LocalDor.PERNAS), SintomaCalculator.deTexto(LocalDor.class, texto));
        assertEquals("", SintomaCalculator.paraTexto(List.of()));
        assertTrue(SintomaCalculator.deTexto(LocalDor.class, null).isEmpty());
        assertEquals(List.of(LocalDor.PEITO), SintomaCalculator.deTexto(LocalDor.class, "XYZ,PEITO"));
    }

    // ---------------------------------------------------------------- resumo

    private static SintomaCalculator.Dia dia(int diasAtras, int e, int h, int s, NivelDor dor, Sintoma... sintomas) {
        return new SintomaCalculator.Dia(HOJE.minusDays(diasAtras), e, h, s, dor, List.of(sintomas));
    }

    @Test
    void resumoVazio() {
        SintomaResumoDTO r = SintomaCalculator.resumirSemana(new ArrayList<>(), HOJE);
        assertEquals(0, r.diasRespondidos());
        assertNull(r.mediaEnergia());
        assertNull(r.sintomaMaisFrequente());
        assertTrue(r.mensagem().contains("alguns dias"));
        assertEquals(0, SintomaCalculator.resumirSemana(null, HOJE).diasRespondidos());
    }

    @Test
    void resumoIgnoraForaDaJanelaEFuturo() {
        List<SintomaCalculator.Dia> dias = List.of(
                dia(0, 4, 4, 2, NivelDor.NENHUMA, Sintoma.NENHUM),
                dia(6, 2, 2, 2, NivelDor.NENHUMA, Sintoma.NENHUM),   // ainda na janela
                dia(7, 1, 1, 5, NivelDor.FORTE, Sintoma.TONTURA),    // fora
                dia(-1, 1, 1, 5, NivelDor.FORTE, Sintoma.TONTURA));  // futuro
        SintomaResumoDTO r = SintomaCalculator.resumirSemana(dias, HOJE);
        assertEquals(2, r.diasRespondidos());
        assertEquals(3.0, r.mediaEnergia());
        assertEquals(0, r.diasComDor());
        assertNull(r.sintomaMaisFrequente());
    }

    @Test
    void mediaArredondadaEMaisFrequente() {
        List<SintomaCalculator.Dia> dias = List.of(
                dia(0, 3, 3, 2, NivelDor.LEVE, Sintoma.CANSACO, Sintoma.DOR_DE_CABECA),
                dia(1, 3, 4, 2, NivelDor.NENHUMA, Sintoma.CANSACO),
                dia(3, 4, 4, 3, NivelDor.MODERADA, Sintoma.DOR_DE_CABECA, Sintoma.CANSACO));
        SintomaResumoDTO r = SintomaCalculator.resumirSemana(dias, HOJE);
        assertEquals(3.3, r.mediaEnergia());
        assertEquals(3.7, r.mediaHumor());
        assertEquals(2, r.diasComDor());
        assertEquals("CANSACO", r.sintomaMaisFrequente());
        assertEquals(3, r.vezesSintomaMaisFrequente());
        assertTrue(r.mensagem().startsWith("Cansaço apareceu em 3 dias"));
    }

    @Test
    void empateUsaOrdemDoEnum() {
        List<SintomaCalculator.Dia> dias = List.of(
                dia(0, 3, 3, 2, NivelDor.NENHUMA, Sintoma.TONTURA),
                dia(1, 3, 3, 2, NivelDor.NENHUMA, Sintoma.DOR_DE_CABECA));
        assertEquals("DOR_DE_CABECA", SintomaCalculator.resumirSemana(dias, HOJE).sintomaMaisFrequente());
    }

    @Test
    void mensagensPorPrioridade() {
        assertTrue(SintomaCalculator.mensagem(3, 4, 4, 4.0, 5, Sintoma.CANSACO, 5).contains("estresse"));
        assertTrue(SintomaCalculator.mensagem(3, 4, 4, 2, 3, null, 0).contains("dor em 3 dias"));
        assertTrue(SintomaCalculator.mensagem(3, 2.5, 4, 2, 0, null, 0).contains("energia"));
        assertTrue(SintomaCalculator.mensagem(3, 4, 4, 2, 0, null, 0).contains("Semana boa"));
        assertTrue(SintomaCalculator.mensagem(2, 3, 3, 2, 0, Sintoma.ENJOO, 2).contains("2 de 7"));
    }
}
