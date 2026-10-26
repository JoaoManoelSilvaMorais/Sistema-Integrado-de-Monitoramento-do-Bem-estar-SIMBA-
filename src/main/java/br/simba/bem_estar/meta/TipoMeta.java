package br.simba.bem_estar.meta;

/**
 * Tipos de meta que o usuário pode criar. O progresso é calculado sozinho a partir
 * dos registros feitos a partir do dia em que a meta foi criada.
 *
 * modelo  = texto do título ({n} vira o alvo).
 * passo   = quanto o desafio sobe ao usar "Aumentar desafio" depois de concluir.
 */
public enum TipoMeta {

    TREINO_SEGUIDOS("Treinar {n} dias seguidos", "dias", "fa-dumbbell", 2, 60, 5, 1),
    AGUA_SEGUIDOS("Bater a meta de água por {n} dias seguidos", "dias", "fa-droplet", 2, 60, 5, 1),
    SONO_SEGUIDOS("Dormir 7 h ou mais por {n} noites seguidas", "noites", "fa-moon", 2, 60, 5, 1),
    TREINO_TOTAL("Fazer {n} treinos", "treinos", "fa-person-running", 2, 300, 10, 5);

    private final String modelo;
    private final String unidade;
    private final String icone;
    private final int min;
    private final int max;
    private final int padrao;
    private final int passo;

    TipoMeta(String modelo, String unidade, String icone, int min, int max, int padrao, int passo) {
        this.modelo = modelo;
        this.unidade = unidade;
        this.icone = icone;
        this.min = min;
        this.max = max;
        this.padrao = padrao;
        this.passo = passo;
    }

    public String titulo(int alvo) { return modelo.replace("{n}", String.valueOf(alvo)); }
    public String getUnidade() { return unidade; }
    public String getIcone() { return icone; }
    public int getMin() { return min; }
    public int getMax() { return max; }
    public int getPadrao() { return padrao; }
    public int getPasso() { return passo; }
}
