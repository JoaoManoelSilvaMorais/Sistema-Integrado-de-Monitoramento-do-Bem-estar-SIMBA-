package br.simba.bem_estar.sintoma;

/** Sintomas que podem ser marcados no questionário. NENHUM não combina com os outros. */
public enum Sintoma {

    DOR_DE_CABECA("Dor de cabeça"),
    CANSACO("Cansaço"),
    TONTURA("Tontura"),
    ENJOO("Enjoo"),
    INSONIA("Insônia"),
    FALTA_DE_AR("Falta de ar"),
    NENHUM("Nenhum");

    private final String rotulo;

    Sintoma(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }
}
