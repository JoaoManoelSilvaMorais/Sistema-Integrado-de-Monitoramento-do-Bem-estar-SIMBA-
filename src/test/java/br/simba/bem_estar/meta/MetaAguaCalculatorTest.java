package br.simba.bem_estar.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MetaAguaCalculatorTest {

    @Test
    void semPesoOuNegativoRetornaPadraoDe2000Ml() {
        assertEquals(2000, MetaAguaCalculator.sugerida(0));
        assertEquals(2000, MetaAguaCalculator.sugerida(-10));
    }

    @Test
    void calcula35MlPorKgArredondadoParaMultiploDe50() {
        // 72.5 * 35 = 2537.5 -> 2550
        assertEquals(2550, MetaAguaCalculator.sugerida(72.5));
        // 70 * 35 = 2450
        assertEquals(2450, MetaAguaCalculator.sugerida(70.0));
        // 80 * 35 = 2800
        assertEquals(2800, MetaAguaCalculator.sugerida(80.0));
    }

    @Test
    void respeitaPisoDe1500ETetoDe5000Ml() {
        assertEquals(1500, MetaAguaCalculator.sugerida(30.0));
        assertEquals(5000, MetaAguaCalculator.sugerida(200.0));
    }

    @Test
    void validaAceitaEntre500E8000Ml() {
        assertFalse(MetaAguaCalculator.valida(499));
        assertTrue(MetaAguaCalculator.valida(500));
        assertTrue(MetaAguaCalculator.valida(8000));
        assertFalse(MetaAguaCalculator.valida(8001));
    }
}
