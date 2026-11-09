package br.simba.bem_estar.perfil;

import br.simba.bem_estar.exceptions.RegraDeNegocioException;

/**
 * Regras de peso e altura do perfil, em Java puro (sem Spring).
 * Peso em kg e altura em metros (mesmas unidades do PerfilModel).
 * No PerfilModel, 0 significa "não informado".
 */
public final class MedidasCalculator {

    public static final double PESO_MIN = 20;
    public static final double PESO_MAX = 350;
    public static final double ALTURA_MIN = 0.8;
    public static final double ALTURA_MAX = 3.0;

    private MedidasCalculator() {
    }

    /** Confere os valores enviados. Nulo = deixar em branco (permitido). */
    public static void validar(Double peso, Double altura) {
        if (peso != null && (peso.isNaN() || peso < PESO_MIN || peso > PESO_MAX)) {
            throw new RegraDeNegocioException(
                    "O peso deve estar entre " + (int) PESO_MIN + " e " + (int) PESO_MAX + " kg.");
        }
        if (altura != null && (altura.isNaN() || altura < ALTURA_MIN || altura > ALTURA_MAX)) {
            throw new RegraDeNegocioException("A altura deve estar entre 80 e 300 cm.");
        }
    }

    /** Converte o valor do banco (0 = não informado) para nulo. */
    public static Double ouNulo(double valor) {
        return valor > 0 ? valor : null;
    }

    /** IMC = peso / altura², com 1 casa decimal. Nulo se faltar peso ou altura. */
    public static Double imc(Double peso, Double altura) {
        if (peso == null || altura == null || peso <= 0 || altura <= 0) {
            return null;
        }
        return Math.round(peso / (altura * altura) * 10) / 10.0;
    }

    /** Faixas do IMC para adultos (OMS). */
    public static String classificar(Double imc) {
        if (imc == null) {
            return null;
        }
        if (imc < 18.5) {
            return "Abaixo do peso";
        }
        if (imc < 25) {
            return "Peso adequado";
        }
        if (imc < 30) {
            return "Sobrepeso";
        }
        return "Obesidade";
    }
}
