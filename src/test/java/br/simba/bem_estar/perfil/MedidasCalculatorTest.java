package br.simba.bem_estar.perfil;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.simba.bem_estar.exceptions.RegraDeNegocioException;

/** .\mvnw test -Dtest=MedidasCalculatorTest */
class MedidasCalculatorTest {

    @Test
    void aceitaValoresNormaisELimites() {
        assertDoesNotThrow(() -> MedidasCalculator.validar(72.5, 1.75));
        assertDoesNotThrow(() -> MedidasCalculator.validar(20.0, 0.8));
        assertDoesNotThrow(() -> MedidasCalculator.validar(350.0, 3.0));
        assertDoesNotThrow(() -> MedidasCalculator.validar(120.0, 2.51)); // acima do limite antigo
    }

    @Test
    void aceitaCamposEmBranco() {
        assertDoesNotThrow(() -> MedidasCalculator.validar(null, null));
        assertDoesNotThrow(() -> MedidasCalculator.validar(70.0, null));
        assertDoesNotThrow(() -> MedidasCalculator.validar(null, 1.70));
    }

    @Test
    void recusaForaDosLimites() {
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(19.9, 1.70));
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(350.1, 1.70));
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(0.0, 1.70));
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(-5.0, null));
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(70.0, 0.79));
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(70.0, 3.01));
        // altura digitada em cm por engano
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(70.0, 175.0));
        assertThrows(RegraDeNegocioException.class, () -> MedidasCalculator.validar(Double.NaN, null));
    }

    @Test
    void zeroNoBancoViraNulo() {
        assertNull(MedidasCalculator.ouNulo(0));
        assertEquals(70.0, MedidasCalculator.ouNulo(70));
    }

    @Test
    void imcComUmaCasaDecimal() {
        assertEquals(23.7, MedidasCalculator.imc(72.5, 1.75)); // 23,67…
        assertEquals(22.9, MedidasCalculator.imc(70.0, 1.75)); // 22,857…
        assertNull(MedidasCalculator.imc(null, 1.75));
        assertNull(MedidasCalculator.imc(70.0, null));
        assertNull(MedidasCalculator.imc(70.0, 0.0));
    }

    @Test
    void classificacaoNasFronteiras() {
        assertNull(MedidasCalculator.classificar(null));
        assertEquals("Abaixo do peso", MedidasCalculator.classificar(18.4));
        assertEquals("Peso adequado", MedidasCalculator.classificar(18.5));
        assertEquals("Peso adequado", MedidasCalculator.classificar(24.9));
        assertEquals("Sobrepeso", MedidasCalculator.classificar(25.0));
        assertEquals("Sobrepeso", MedidasCalculator.classificar(29.9));
        assertEquals("Obesidade", MedidasCalculator.classificar(30.0));
    }
}
