package br.simba.bem_estar.progresso;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import br.simba.bem_estar.BaseIntegrationTest;

class RegistrosMonitoramentoIntegrationTest extends BaseIntegrationTest {

    @Test
    void crudDeAguaSonoExercicioIsolamentoEntreUsuariosEConsultaDeProgresso() throws Exception {
        String tokenA = registrarELogar("Usuario A", "usera", "a@simba.com", "senha123");
        String tokenB = registrarELogar("Usuario B", "userb", "b@simba.com", "senha123");

        LocalDate hoje = LocalDate.of(2026, 11, 10);
        LocalDate ontem = hoje.minusDays(1);

        // ---- Água ----
        MvcResult aguaOntem = mockMvc.perform(post("/registroAgua")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "quantidadeMl", 1000.0,
                                "dataHora", ontem.atTime(10, 0).toString()))))
                .andExpect(status().isOk())
                .andReturn();
        long aguaOntemId = objectMapper.readTree(aguaOntem.getResponse().getContentAsString()).get("id").asLong();

        MvcResult aguaHoje = mockMvc.perform(post("/registroAgua")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "quantidadeMl", 500.0,
                                "dataHora", hoje.atTime(9, 0).toString()))))
                .andExpect(status().isOk())
                .andReturn();
        long aguaHojeId = objectMapper.readTree(aguaHoje.getResponse().getContentAsString()).get("id").asLong();

        mockMvc.perform(put("/registroAgua/" + aguaHojeId)
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "quantidadeMl", 750.0,
                                "dataHora", hoje.atTime(9, 30).toString()))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantidadeMl").value(750.0));

        // Isolamento: usuário B não vê nem altera água de A
        mockMvc.perform(get("/registroAgua")
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
        mockMvc.perform(get("/registroAgua/" + aguaOntemId)
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isForbidden());
        mockMvc.perform(delete("/registroAgua/" + aguaOntemId)
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isForbidden());
        mockMvc.perform(get("/registroAgua/999999")
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isNotFound());

        // ---- Sono ----
        mockMvc.perform(post("/registrosono/")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "horaDormir", hoje.atTime(8, 0).toString(),
                                "horaAcordar", hoje.atTime(6, 0).toString(),
                                "notaSono", 4))))
                .andExpect(status().is(422));

        MvcResult sonoRes = mockMvc.perform(post("/registrosono/")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "horaDormir", ontem.atTime(23, 0).toString(),
                                "horaAcordar", hoje.atTime(7, 0).toString(),
                                "notaSono", 4))))
                .andExpect(status().isOk())
                .andReturn();
        long sonoId = objectMapper.readTree(sonoRes.getResponse().getContentAsString()).get("id").asLong();

        mockMvc.perform(put("/registrosono/" + sonoId)
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "horaDormir", ontem.atTime(23, 0).toString(),
                                "horaAcordar", hoje.atTime(7, 0).toString(),
                                "notaSono", 5))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.notaSono").value(5));

        mockMvc.perform(get("/registrosono/")
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
        mockMvc.perform(get("/registrosono/" + sonoId)
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isForbidden());

        // ---- Exercícios ----
        mockMvc.perform(post("/registroexercicio")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "modalidade", "Corrida",
                                "duracaominutos", 0,
                                "gastoCaloricoExtimado", 200,
                                "dataHora", hoje.atTime(18, 0).toString()))))
                .andExpect(status().is(422));

        MvcResult exRes = mockMvc.perform(post("/registroexercicio")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "modalidade", "Corrida",
                                "duracaominutos", 35,
                                "gastoCaloricoExtimado", 320,
                                "dataHora", hoje.atTime(18, 0).toString()))))
                .andExpect(status().isOk())
                .andReturn();
        long exId = objectMapper.readTree(exRes.getResponse().getContentAsString()).get("id").asLong();

        mockMvc.perform(get("/registroexercicio/" + exId)
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isForbidden());

        // ---- Progresso consolidado ----
        mockMvc.perform(get("/progresso")
                        .param("inicio", ontem.toString())
                        .param("fim", hoje.toString())
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sono.length()").value(2))
                .andExpect(jsonPath("$.sono[0].horasSono").doesNotExist())
                .andExpect(jsonPath("$.sono[1].horasSono").value(8.0))
                .andExpect(jsonPath("$.sono[1].notaSono").value(5.0))
                .andExpect(jsonPath("$.hidratacao[0].quantidadeMl").value(1000.0))
                .andExpect(jsonPath("$.hidratacao[1].quantidadeMl").value(750.0))
                .andExpect(jsonPath("$.treinos[0].treinou").value(false))
                .andExpect(jsonPath("$.treinos[1].treinou").value(true))
                .andExpect(jsonPath("$.treinos[1].quantidadeTreinos").value(1));

        // Data inicial após data final
        mockMvc.perform(get("/progresso")
                        .param("inicio", hoje.toString())
                        .param("fim", ontem.toString())
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isInternalServerError());

        // Exclusão dos registros pelo dono
        mockMvc.perform(delete("/registroAgua/" + aguaHojeId)
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/registrosono/" + sonoId)
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/registroexercicio/" + exId)
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isOk());
    }
}
