package br.simba.bem_estar.sintoma;

/** Intensidade da dor informada no questionário diário. */
public enum NivelDor {

    NENHUMA("Nenhuma"),
    LEVE("Leve"),
    MODERADA("Moderada"),
    FORTE("Forte");

    private final String rotulo;

    NivelDor(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }
}
