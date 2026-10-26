package br.simba.bem_estar.conquista;

/**
 * Catálogo fixo das conquistas do SIMBA. Para adicionar uma nova, basta
 * incluir uma linha aqui e o cálculo dela em ConquistaCalculator.
 *
 * meta    = valor que o usuário precisa atingir.
 * unidade = texto mostrado ao lado do progresso (ex.: "4/10 treinos").
 */
public enum Conquista {

    // ---- Hidratação ----
    AGUA_PRIMEIRO_GOLE("Primeiro gole", "Registre sua primeira água.", "Hidratação", "fa-glass-water", 1, ""),
    AGUA_META_DIA("Hidratado", "Bata a meta diária de água em um dia.", "Hidratação", "fa-droplet", ConquistaCalculator.META_AGUA_PADRAO_ML, "ml"),
    AGUA_SEMANA("Semana hidratada", "Bata a meta de água 7 dias seguidos.", "Hidratação", "fa-water", 7, "dias"),
    AGUA_50L("Poço da savana", "Acumule 50 litros de água registrados.", "Hidratação", "fa-bottle-water", 50, "L"),
    AGUA_10_DIAS("Oásis", "Bata a meta de água em 10 dias diferentes.", "Hidratação", "fa-seedling", 10, "dias"),
    AGUA_200L("Rio da savana", "Acumule 200 litros de água registrados.", "Hidratação", "fa-faucet-drip", 200, "L"),
    AGUA_30_DIAS("Fonte eterna", "Bata a meta de água em 30 dias diferentes.", "Hidratação", "fa-gem", 30, "dias"),

    // ---- Sono ----
    SONO_PRIMEIRA("Boa noite!", "Registre sua primeira noite de sono.", "Sono", "fa-moon", 1, ""),
    SONO_8H("Sono de rei", "Durma 8 horas ou mais em uma noite.", "Sono", "fa-bed", 8, "h"),
    SONO_NOTA_5("Noite perfeita", "Dê nota 5 para uma noite de sono.", "Sono", "fa-star", 5, ""),
    SONO_7_BOAS("Semana de descanso", "Durma 7 horas ou mais por 7 noites seguidas.", "Sono", "fa-cloud-moon", 7, "noites"),

    // ---- Treinos ----
    TREINO_PRIMEIRO("Primeiro suor", "Registre seu primeiro treino.", "Treinos", "fa-dumbbell", 1, ""),
    TREINO_10("Em ritmo", "Registre 10 treinos.", "Treinos", "fa-person-running", 10, "treinos"),
    TREINO_KCAL("Fornalha", "Queime 1000 kcal somando seus treinos.", "Treinos", "fa-fire", 1000, "kcal"),
    TREINO_VARIADO("Atleta completo", "Treine 3 modalidades diferentes.", "Treinos", "fa-shuffle", 3, "modalidades"),
    TREINO_30("Máquina", "Registre 30 treinos.", "Treinos", "fa-medal", 30, "treinos"),
    TREINO_KCAL_5000("Vulcão", "Queime 5000 kcal somando seus treinos.", "Treinos", "fa-mountain", 5000, "kcal"),

    // ---- Rotinas ----
    ROTINA_PRIMEIRA("Organizado", "Crie sua primeira rotina.", "Rotinas", "fa-calendar-check", 1, ""),
    ROTINA_LEMBRETE("Sempre lembrado", "Adicione um lembrete a uma rotina.", "Rotinas", "fa-bell", 1, ""),
    ROTINA_3_ATIVAS("Leão de rotina", "Mantenha 3 rotinas ativas ao mesmo tempo.", "Rotinas", "fa-list-check", 3, "rotinas"),

    // ---- Ofensiva (streak) ----
    STREAK_3("Esquentando", "Alcance 3 dias seguidos de ofensiva.", "Ofensiva", "fa-fire-flame-curved", 3, "dias"),
    STREAK_7("Uma semana de fogo", "Alcance 7 dias seguidos de ofensiva.", "Ofensiva", "fa-fire", 7, "dias"),
    STREAK_30("Rei da savana", "Alcance 30 dias seguidos de ofensiva.", "Ofensiva", "fa-crown", 30, "dias"),
    STREAK_60("Lenda da savana", "Alcance 60 dias de ofensiva.", "Ofensiva", "fa-trophy", 60, "dias"),
    STREAK_100("Imortal", "Alcance 100 dias de ofensiva.", "Ofensiva", "fa-infinity", 100, "dias"),

    // ---- Geral ----
    DIA_COMPLETO("Dia completo", "Registre água, sono e treino no mesmo dia.", "Geral", "fa-paw", 1, "");

    private final String nome;
    private final String descricao;
    private final String categoria;
    private final String icone;
    private final int meta;
    private final String unidade;

    Conquista(String nome, String descricao, String categoria, String icone, int meta, String unidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.icone = icone;
        this.meta = meta;
        this.unidade = unidade;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getCategoria() { return categoria; }
    public String getIcone() { return icone; }
    public int getMeta() { return meta; }
    public String getUnidade() { return unidade; }
}
