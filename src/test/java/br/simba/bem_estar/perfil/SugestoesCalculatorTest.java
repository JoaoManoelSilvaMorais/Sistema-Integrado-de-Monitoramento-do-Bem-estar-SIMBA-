package br.simba.bem_estar.perfil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/** .\mvnw test -Dtest=SugestoesCalculatorTest */
class SugestoesCalculatorTest {

    private static List<String> tipos(List<SugestaoMetaDTO> lista) {
        return lista.stream().map(SugestaoMetaDTO::tipo).toList();
    }

    private static SugestaoMetaDTO doTipo(List<SugestaoMetaDTO> lista, String tipo) {
        return lista.stream().filter(s -> s.tipo().equals(tipo)).findFirst().orElseThrow();
    }

    @Test
    void semPesoNaoSugereNada() {
        assertTrue(SugestoesCalculator.sugerir(null, null).isEmpty());
        assertTrue(SugestoesCalculator.sugerir(null, 1.80).isEmpty());
        assertTrue(SugestoesCalculator.sugerir(0.0, 1.80).isEmpty());
    }

    @Test
    void soComPesoSugereAguaEAtividade() {
        List<SugestaoMetaDTO> s = SugestoesCalculator.sugerir(75.0, null);
        assertEquals(List.of("AGUA", "ATIVIDADE"), tipos(s));
    }

    @Test
    void faixaSaudavelPelaAltura() {
        assertEquals(59.9, SugestoesCalculator.pesoMinimoSaudavel(1.80)); // 18,5 × 3,24 = 59,94
        assertEquals(80.7, SugestoesCalculator.pesoMaximoSaudavel(1.80)); // 24,9 × 3,24 = 80,676
    }

    @Test
    void pesoAdequadoSugereManter() {
        List<SugestaoMetaDTO> s = SugestoesCalculator.sugerir(75.0, 1.80);
        assertEquals(List.of("PESO", "AGUA", "ATIVIDADE"), tipos(s));
        assertEquals("Manter o peso entre 59,9 e 80,7 kg", doTipo(s, "PESO").titulo());
        assertEquals("Fazer 150 min de atividade por semana", doTipo(s, "ATIVIDADE").titulo());
    }

    @Test
    void abaixoDoPesoSugereGanhar() {
        // 50 kg e 1,75 m → mínimo saudável 56,7 kg (18,5 × 3,0625 = 56,66)
        List<SugestaoMetaDTO> s = SugestoesCalculator.sugerir(50.0, 1.75);
        assertEquals("Ganhar cerca de 6,7 kg", doTipo(s, "PESO").titulo());
        assertTrue(doTipo(s, "PESO").descricao().startsWith("Chegar a 56,7 kg"));
        assertEquals("Treinar força 2 ou 3 vezes por semana", doTipo(s, "ATIVIDADE").titulo());
    }

    @Test
    void sobrepesoSugerePerderCincoPorCento() {
        // 90 kg e 1,75 m → IMC 29,4 (sobrepeso); 5% = 4,5 kg → 85,5 kg
        List<SugestaoMetaDTO> s = SugestoesCalculator.sugerir(90.0, 1.75);
        assertEquals("Primeira meta: perder 4,5 kg", doTipo(s, "PESO").titulo());
        assertTrue(doTipo(s, "PESO").descricao().contains("chegando a 85,5 kg"));
        assertTrue(doTipo(s, "PESO").descricao().contains("de 56,7 a 76,3 kg"));
        assertEquals("Mexer-se de 150 a 300 min por semana", doTipo(s, "ATIVIDADE").titulo());
    }

    @Test
    void obesidadeTambemSugerePerderCincoPorCento() {
        // 120 kg e 1,70 m → IMC 41,5; 5% = 6 kg → 114 kg
        SugestaoMetaDTO peso = doTipo(SugestoesCalculator.sugerir(120.0, 1.70), "PESO");
        assertEquals("Primeira meta: perder 6 kg", peso.titulo());
        assertTrue(peso.descricao().contains("chegando a 114 kg"));
    }

    @Test
    void aguaUsaAMesmaMetaDoApp() {
        // 75 kg × 35 = 2625 → múltiplo de 50 mais próximo = 2650 ml; 11 copos de 250 ml
        SugestaoMetaDTO agua = doTipo(SugestoesCalculator.sugerir(75.0, 1.80), "AGUA");
        assertEquals("Beber 2.650 ml de água por dia", agua.titulo());
        assertTrue(agua.descricao().contains("11 copos"));
        // limitada a 5 L para pesos muito altos
        assertEquals("Beber 5.000 ml de água por dia", doTipo(SugestoesCalculator.sugerir(200.0, 1.90), "AGUA").titulo());
    }

    @Test
    void alturaMuitoAltaAceita() {
        // 2,90 m (novo limite de 3 m): faixa saudável 155,6 a 209,4 kg
        SugestaoMetaDTO peso = doTipo(SugestoesCalculator.sugerir(180.0, 2.90), "PESO");
        assertEquals("Manter o peso entre 155,6 e 209,4 kg", peso.titulo());
    }

    @Test
    void cadaSugestaoTrazAMetaDoApp() {
        // peso adequado: água 7 dias seguidos + 5 treinos; peso não tem meta no app
        List<SugestaoMetaDTO> s = SugestoesCalculator.sugerir(75.0, 1.80);
        SugestaoMetaDTO peso = doTipo(s, "PESO");
        assertNull(peso.metaTipo());
        assertNull(peso.metaAlvo());
        SugestaoMetaDTO agua = doTipo(s, "AGUA");
        assertEquals("AGUA_SEGUIDOS", agua.metaTipo());
        assertEquals(7, agua.metaAlvo());
        assertEquals("Bater a meta de água por 7 dias seguidos", agua.metaTitulo());
        SugestaoMetaDTO atividade = doTipo(s, "ATIVIDADE");
        assertEquals("TREINO_TOTAL", atividade.metaTipo());
        assertEquals(5, atividade.metaAlvo());
        assertEquals("Fazer 5 treinos", atividade.metaTitulo());
    }

    @Test
    void alvoDeTreinosMudaComAFaixa() {
        assertEquals(6, doTipo(SugestoesCalculator.sugerir(50.0, 1.75), "ATIVIDADE").metaAlvo());  // abaixo
        assertEquals(10, doTipo(SugestoesCalculator.sugerir(90.0, 1.75), "ATIVIDADE").metaAlvo()); // sobrepeso
        assertEquals(5, doTipo(SugestoesCalculator.sugerir(75.0, null), "ATIVIDADE").metaAlvo());  // só peso
    }

    @Test
    void alvosRespeitamOsLimitesDoTipoMeta() {
        // o POST /api/metas recusa alvo fora de min..max; as sugestões precisam caber
        for (double peso : new double[] {50, 75, 90, 120}) {
            for (SugestaoMetaDTO s : SugestoesCalculator.sugerir(peso, 1.75)) {
                if (s.metaTipo() == null) continue;
                br.simba.bem_estar.meta.TipoMeta t = br.simba.bem_estar.meta.TipoMeta.valueOf(s.metaTipo());
                assertTrue(s.metaAlvo() >= t.getMin() && s.metaAlvo() <= t.getMax(), s.metaTipo() + " " + s.metaAlvo());
            }
        }
    }
}
