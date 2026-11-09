package br.simba.bem_estar.perfil;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.simba.bem_estar.meta.MetaAguaCalculator;
import br.simba.bem_estar.meta.TipoMeta;

/**
 * Sugestões de metas a partir do peso (kg) e da altura (m), em Java puro (sem Spring).
 *
 * - PESO: faixa saudável para a altura = IMC 18,5 a 24,9 × altura².
 *   Abaixo → ganhar até o início da faixa; adequado → manter na faixa;
 *   sobrepeso/obesidade → primeira meta de perder 5% do peso (meta inicial comum e realista).
 * - AGUA: a mesma meta sugerida do app (MetaAguaCalculator: 35 ml por kg, de 1,5 a 5 L).
 * - ATIVIDADE: recomendação da OMS para adultos — 150 a 300 min/semana de atividade moderada.
 *
 * Cada sugestão pode vir com a meta do app que o botão "Criar meta" grava:
 * - AGUA → AGUA_SEGUIDOS por 7 dias;
 * - ATIVIDADE → TREINO_TOTAL (5 treinos no peso adequado, 6 abaixo do peso, 10 acima);
 * - PESO → nenhuma (o app ainda não tem tipo de meta de peso).
 *
 * São sugestões gerais, não substituem um profissional de saúde.
 */
public final class SugestoesCalculator {

    public static final double IMC_MIN_SAUDAVEL = 18.5;
    public static final double IMC_MAX_SAUDAVEL = 24.9;
    public static final double PERDA_INICIAL = 0.05; // 5%
    public static final int DIAS_META_AGUA = 7;
    public static final int TREINOS_ADEQUADO = 5;
    public static final int TREINOS_ABAIXO = 6;
    public static final int TREINOS_ACIMA = 10;

    private static final Locale BR = Locale.forLanguageTag("pt-BR");

    private SugestoesCalculator() {
    }

    /** Peso mínimo saudável para a altura (1 casa). */
    public static double pesoMinimoSaudavel(double altura) {
        return arredondar(IMC_MIN_SAUDAVEL * altura * altura);
    }

    /** Peso máximo saudável para a altura (1 casa). */
    public static double pesoMaximoSaudavel(double altura) {
        return arredondar(IMC_MAX_SAUDAVEL * altura * altura);
    }

    /**
     * Lista de sugestões. Sem peso → nada. Só com peso → água e atividade.
     * Com peso e altura → também a meta de peso.
     */
    public static List<SugestaoMetaDTO> sugerir(Double peso, Double altura) {
        List<SugestaoMetaDTO> lista = new ArrayList<>();
        if (peso == null || peso <= 0) {
            return lista;
        }

        Double imc = MedidasCalculator.imc(peso, altura);
        String faixa = MedidasCalculator.classificar(imc);
        boolean acima = "Sobrepeso".equals(faixa) || "Obesidade".equals(faixa);

        // 1) Peso (precisa da altura)
        if (imc != null) {
            double min = pesoMinimoSaudavel(altura);
            double max = pesoMaximoSaudavel(altura);
            String faixaTexto = "A faixa saudável para " + numero(altura, 2) + " m é de "
                    + numero(min, 1) + " a " + numero(max, 1) + " kg.";

            if ("Abaixo do peso".equals(faixa)) {
                double ganhar = arredondar(min - peso);
                lista.add(semMeta("PESO", "fa-solid fa-arrow-trend-up",
                        "Ganhar cerca de " + numero(ganhar, 1) + " kg",
                        "Chegar a " + numero(min, 1) + " kg, o início da faixa saudável. " + faixaTexto));
            } else if (acima) {
                double perder = arredondar(peso * PERDA_INICIAL);
                double alvo = arredondar(peso - perder);
                lista.add(semMeta("PESO", "fa-solid fa-arrow-trend-down",
                        "Primeira meta: perder " + numero(perder, 1) + " kg",
                        "São 5% do seu peso, chegando a " + numero(alvo, 1) + " kg. Metas pequenas são mais fáceis de manter. "
                                + faixaTexto));
            } else {
                lista.add(semMeta("PESO", "fa-solid fa-scale-balanced",
                        "Manter o peso entre " + numero(min, 1) + " e " + numero(max, 1) + " kg",
                        "Você está na faixa saudável para a sua altura. Continue com a rotina!"));
            }
        }

        // 2) Água (só precisa do peso)
        int aguaMl = MetaAguaCalculator.sugerida(peso);
        int copos = (int) Math.ceil(aguaMl / 250.0);
        lista.add(comMeta("AGUA", "fa-solid fa-droplet",
                "Beber " + numero(aguaMl, 0) + " ml de água por dia",
                "Cerca de 35 ml por kg, ou uns " + copos + " copos de 250 ml. É a meta de água sugerida pelo app.",
                TipoMeta.AGUA_SEGUIDOS, DIAS_META_AGUA));

        // 3) Atividade física (OMS)
        if (acima) {
            lista.add(comMeta("ATIVIDADE", "fa-solid fa-person-running",
                    "Mexer-se de 150 a 300 min por semana",
                    "Ex.: 40 min em 5 dias. Mais perto de 300 min ajuda a perder peso. Comece aos poucos.",
                    TipoMeta.TREINO_TOTAL, TREINOS_ACIMA));
        } else if ("Abaixo do peso".equals(faixa)) {
            lista.add(comMeta("ATIVIDADE", "fa-solid fa-dumbbell",
                    "Treinar força 2 ou 3 vezes por semana",
                    "Ajuda a ganhar massa muscular. Some 150 min de atividade moderada na semana.",
                    TipoMeta.TREINO_TOTAL, TREINOS_ABAIXO));
        } else {
            lista.add(comMeta("ATIVIDADE", "fa-solid fa-person-walking",
                    "Fazer 150 min de atividade por semana",
                    "Ex.: 30 min em 5 dias, como uma caminhada rápida. É a recomendação da OMS para adultos.",
                    TipoMeta.TREINO_TOTAL, TREINOS_ADEQUADO));
        }

        return lista;
    }

    private static SugestaoMetaDTO semMeta(String tipo, String icone, String titulo, String descricao) {
        return new SugestaoMetaDTO(tipo, icone, titulo, descricao, null, null, null);
    }

    private static SugestaoMetaDTO comMeta(String tipo, String icone, String titulo, String descricao,
            TipoMeta meta, int alvo) {
        return new SugestaoMetaDTO(tipo, icone, titulo, descricao, meta.name(), alvo, meta.titulo(alvo));
    }

    private static double arredondar(double valor) {
        return Math.round(valor * 10) / 10.0;
    }

    /** Número no formato brasileiro (vírgula), sem casas sobrando: 72 → "72", 72.5 → "72,5". */
    private static String numero(double valor, int casasMax) {
        NumberFormat f = NumberFormat.getNumberInstance(BR);
        f.setMinimumFractionDigits(valor == Math.rint(valor) ? 0 : (casasMax == 2 ? 2 : 1));
        f.setMaximumFractionDigits(casasMax);
        f.setRoundingMode(RoundingMode.HALF_UP);
        return f.format(valor);
    }
}
