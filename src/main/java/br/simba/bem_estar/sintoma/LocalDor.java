package br.simba.bem_estar.sintoma;

/** Onde a pessoa sente dor (aparecem na lista "Onde dói?" do questionário). */
public enum LocalDor {

    CABECA("Cabeça"),
    PESCOCO("Pescoço"),
    PEITO("Peito"),
    ESTOMAGO("Estômago"),
    BRACOS("Braços"),
    COSTAS("Costas"),
    LOMBAR("Lombar"),
    PERNAS("Pernas"),
    MUSCULOS("Músculos em geral"),
    OUTRO("Outro");

    private final String rotulo;

    LocalDor(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }
}
