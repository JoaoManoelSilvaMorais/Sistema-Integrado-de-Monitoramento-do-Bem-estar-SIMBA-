package br.simba.bem_estar.conquista;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import br.simba.bem_estar.BaseIntegrationTest;
import tools.jackson.databind.JsonNode;

class GamificacaoDashboardIntegrationTest extends BaseIntegrationTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Test
    void integracaoCompletaEntreRegistrosRotinasMetasConquistasStreakComparativoEProximoPasso()
            throws Exception {
        String token = registrarELogar("Samuel", "samuel", "samuel@simba.com", "senha123");
        LocalDate hoje = LocalDate.now(FUSO);
        LocalDate ontem = hoje.minusDays(1);

        // 1. Define peso no perfil e personaliza meta de água (2500 ml), testando reset com 0
        mockMvc.perform(put("/perfil/me/medidas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("peso", 80.0, "altura", 1.80))))
                .andExpect(status().isOk());

        mockMvc.perform(put("/api/metas/agua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("metaMl", 2500))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.metaMl").value(2500))
                .andExpect(jsonPath("$.personalizada").value(true));

        mockMvc.perform(put("/api/metas/agua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("metaMl", 0))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.metaMl").value(2800))
                .andExpect(jsonPath("$.personalizada").value(false));

        mockMvc.perform(put("/api/metas/agua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("metaMl", 2500))))
                .andExpect(status().isOk());

        // 2. Cria metas (e valida bloqueio de duplicidade 409)
        MvcResult metaTreinoRes = mockMvc.perform(post("/api/metas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("tipo", "TREINO_TOTAL", "alvo", 2))))
                .andExpect(status().isCreated())
                .andReturn();
        long metaTreinoId = objectMapper.readTree(metaTreinoRes.getResponse().getContentAsString())
                .get("id").asLong();

        mockMvc.perform(post("/api/metas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("tipo", "TREINO_TOTAL", "alvo", 5))))
                .andExpect(status().isConflict());

        MvcResult metaAguaSeguidosRes = mockMvc.perform(post("/api/metas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("tipo", "AGUA_SEGUIDOS", "alvo", 2))))
                .andExpect(status().isCreated())
                .andReturn();
        long metaAguaSeguidosId = objectMapper.readTree(metaAguaSeguidosRes.getResponse().getContentAsString())
                .get("id").asLong();
        // Simula meta criada ontem para contabilizar a sequência ontem + hoje
        var metaAguaModel = metaRepository.findById(metaAguaSeguidosId).orElseThrow();
        metaAguaModel.setDataInicio(ontem);
        metaRepository.save(metaAguaModel);

        // 3. Registra água ontem e hoje (2500 ml/dia), sono ontem->hoje (8h, nota 5),
        //    2 treinos hoje (1100 kcal no total) e 1 rotina com lembrete
        mockMvc.perform(post("/registroAgua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("quantidadeMl", 2500.0, "dataHora", ontem.atTime(10, 0).toString()))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/registroAgua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("quantidadeMl", 2500.0, "dataHora", hoje.atTime(10, 0).toString()))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/registrosono/")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "horaDormir", ontem.atTime(23, 0).toString(),
                                "horaAcordar", hoje.atTime(7, 0).toString(),
                                "notaSono", 5))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/registroexercicio")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "modalidade", "Corrida",
                                "duracaominutos", 45,
                                "gastoCaloricoExtimado", 600,
                                "dataHora", hoje.atTime(8, 0).toString()))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/registroexercicio")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "modalidade", "Musculação",
                                "duracaominutos", 50,
                                "gastoCaloricoExtimado", 500,
                                "dataHora", hoje.atTime(18, 0).toString()))))
                .andExpect(status().isOk());

        MvcResult rotinaRes = mockMvc.perform(post("/api/rotinas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("nome", "Saúde", "descricao", "Diária", "ativa", true))))
                .andExpect(status().isCreated())
                .andReturn();
        String rotinaId = objectMapper.readTree(rotinaRes.getResponse().getContentAsString()).get("id").asString();

        mockMvc.perform(post("/api/rotinas/" + rotinaId + "/lembretes")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "titulo", "Água",
                                "mensagem", "Beber",
                                "hora", LocalTime.of(9, 0).toString(),
                                "diasSemana", List.of(1, 3, 5)))))
                .andExpect(status().isCreated());

        // 4. Próximo passo antes de abrir conquistas/metas: detecta conquista "quase lá" (Atleta completo 2/3)
        //    e não deve gravar conquistas/metas no banco antecipadamente
        mockMvc.perform(get("/api/proximo-passo")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipo").value("quase"))
                .andExpect(jsonPath("$.texto", org.hamcrest.Matchers.containsString("Atleta completo")));
        org.junit.jupiter.api.Assertions.assertEquals(0, conquistaUsuarioRepository.count());

        // 5. Streak reflete 2 dias seguidos e todos os módulos ativos hoje
        mockMvc.perform(get("/api/streak")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.atual").value(2))
                .andExpect(jsonPath("$.maior").value(2))
                .andExpect(jsonPath("$.ativoHoje").value(true))
                .andExpect(jsonPath("$.emRisco").value(false))
                .andExpect(jsonPath("$.aguaHoje").value(true))
                .andExpect(jsonPath("$.sonoHoje").value(true))
                .andExpect(jsonPath("$.treinoHoje").value(true));

        // 6. Conquistas: 1ª chamada grava e marca nova=true; 2ª chamada retorna nova=false
        MvcResult conquistas1 = mockMvc.perform(get("/api/conquistas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(26))
                .andReturn();
        JsonNode c1Node = objectMapper.readTree(conquistas1.getResponse().getContentAsString());
        // Desbloqueadas esperadas: AGUA_PRIMEIRO_GOLE, AGUA_META_DIA, SONO_PRIMEIRA, SONO_8H,
        // SONO_NOTA_5, TREINO_PRIMEIRO, TREINO_KCAL, ROTINA_PRIMEIRA, ROTINA_LEMBRETE, DIA_COMPLETO = 10
        org.junit.jupiter.api.Assertions.assertEquals(10, c1Node.get("desbloqueadas").asInt());
        org.junit.jupiter.api.Assertions.assertTrue(
                acharConquista(c1Node, "DIA_COMPLETO").get("nova").asBoolean());

        MvcResult conquistas2 = mockMvc.perform(get("/api/conquistas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andReturn();
        JsonNode c2Node = objectMapper.readTree(conquistas2.getResponse().getContentAsString());
        org.junit.jupiter.api.Assertions.assertFalse(
                acharConquista(c2Node, "DIA_COMPLETO").get("nova").asBoolean());

        // 7. Metas: 1ª chamada conclui e marca nova=true; 2ª chamada mantém concluída com nova=false
        mockMvc.perform(get("/api/metas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].concluida").value(true))
                .andExpect(jsonPath("$[0].nova").value(true))
                .andExpect(jsonPath("$[1].concluida").value(true))
                .andExpect(jsonPath("$[1].nova").value(true));

        mockMvc.perform(get("/api/metas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nova").value(false));

        // 8. Comparativo semanal sobre os registros reais
        mockMvc.perform(get("/api/comparativo")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.agua.tendencia").value("novo"))
                .andExpect(jsonPath("$.sono.atual").value(8.0))
                .andExpect(jsonPath("$.treinos.atual").value(1.0))
                .andExpect(jsonPath("$.diasAtivos.atual").value(2.0));

        // Excluir meta concluída
        mockMvc.perform(delete("/api/metas/" + metaTreinoId)
                        .header("Authorization", bearer(token)))
                .andExpect(status().isNoContent());
    }

    private static JsonNode acharConquista(JsonNode root, String codigo) {
        for (JsonNode c : root.get("conquistas")) {
            if (codigo.equals(c.get("codigo").asString())) {
                return c;
            }
        }
        throw new AssertionError("Conquista não encontrada: " + codigo);
    }
}
