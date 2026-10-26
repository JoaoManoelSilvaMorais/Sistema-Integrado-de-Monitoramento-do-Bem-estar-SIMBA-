package br.simba.bem_estar.meta;

/** Cálculo da meta de água sugerida (sem dependência de banco ou Spring). */
public final class MetaAguaCalculator {

    public static final int PADRAO_ML = 2000;
    public static final int MIN_ML = 500;
    public static final int MAX_ML = 8000;
    private static final int ML_POR_KG = 35;

    private MetaAguaCalculator() {
    }

    /** Cerca de 35 ml por kg, arredondado para múltiplos de 50 ml e limitado entre 1,5 e 5 L. */
    public static int sugerida(double pesoKg) {
        if (pesoKg <= 0) {
            return PADRAO_ML;
        }
        int arredondado = (int) (Math.round(pesoKg * ML_POR_KG / 50.0) * 50);
        return Math.max(1500, Math.min(5000, arredondado));
    }

    public static boolean valida(int metaMl) {
        return metaMl >= MIN_ML && metaMl <= MAX_ML;
    }
}
