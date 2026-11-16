package br.simba.bem_estar.rotina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import br.simba.bem_estar.BaseIntegrationTest;
import tools.jackson.databind.JsonNode;

class RotinaLembreteIntegrationTest extends BaseIntegrationTest {

    @Test
    void cicloCompletoDeRotinasLembretesRecorrentesEEstadoDeIsolamento() throws Exception {
        String tokenA = registrarELogar("Rubens", "rubens", "rubens@simba.com", "senha123");
        String tokenB = registrarELogar("Outro", "outro", "outro@simba.com", "senha123");

        // Validação de nome obrigatório
        mockMvc.perform(post("/api/rotinas")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("nome", "  ", "descricao", "desc"))))
                .andExpect(status().isBadRequest());

        // Criação com Location e ativa = true por padrão
        MvcResult criadaRes = mockMvc.perform(post("/api/rotinas")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("nome", "Treinos", "descricao", "Academia"))))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.nome").value("Treinos"))
                .andExpect(jsonPath("$.ativa").value(true))
                .andReturn();

        String rotinaId = objectMapper.readTree(criadaRes.getResponse().getContentAsString())
                .get("id").asString();

        // Dia inválido falha com 400
        mockMvc.perform(post("/api/rotinas/" + rotinaId + "/lembretes")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "titulo", "Treinar",
                                "mensagem", "Ir",
                                "hora", "18:00",
                                "diasSemana", List.of(8)))))
                .andExpect(status().isBadRequest());

        // Adiciona 2 lembretes em horários fora de ordem e com dias repetidos
        mockMvc.perform(post("/api/rotinas/" + rotinaId + "/lembretes")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "titulo", "Academia",
                                "mensagem", "Treino B",
                                "hora", "18:30",
                                "diasSemana", List.of(5, 1, 3, 1)))))
                .andExpect(status().isCreated());

        MvcResult comDoisRes = mockMvc.perform(post("/api/rotinas/" + rotinaId + "/lembretes")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "titulo", "Alongar",
                                "mensagem", "Manhã",
                                "hora", "07:00",
                                "diasSemana", List.of(1, 2, 3, 4, 5)))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.lembretes.length()").value(2))
                .andExpect(jsonPath("$.lembretes[0].titulo").value("Alongar"))
                .andExpect(jsonPath("$.lembretes[1].titulo").value("Academia"))
                .andExpect(jsonPath("$.lembretes[1].diasSemana[0]").value(1))
                .andExpect(jsonPath("$.lembretes[1].diasSemana[1]").value(3))
                .andExpect(jsonPath("$.lembretes[1].diasSemana[2]").value(5))
                .andReturn();

        JsonNode jsonComDois = objectMapper.readTree(comDoisRes.getResponse().getContentAsString());
        String lembreteManhaId = jsonComDois.get("lembretes").get(0).get("id").asString();

        // Atualiza rotina
        mockMvc.perform(put("/api/rotinas/" + rotinaId)
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("nome", "Treinos 2.0", "descricao", "Força", "ativa", false))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Treinos 2.0"))
                .andExpect(jsonPath("$.ativa").value(false));

        // Outro usuário não enxerga nem modifica a rotina
        mockMvc.perform(get("/api/rotinas")
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
        mockMvc.perform(delete("/api/rotinas/" + rotinaId)
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isNotFound());

        // Remove um lembrete específico e depois exclui a rotina em cascata
        mockMvc.perform(delete("/api/rotinas/" + rotinaId + "/lembretes/" + lembreteManhaId)
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lembretes.length()").value(1));

        mockMvc.perform(delete("/api/rotinas/" + rotinaId)
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isNoContent());

        assertEquals(0, rotinaRepository.count());
        assertEquals(0, rotinaLembreteRepository.count());
    }

    @Test
    void lembretesAvulsosCriamListamEProtegemContraOutroUsuario() throws Exception {
        String tokenA = registrarELogar("A", "usera", "a@simba.com", "senha123");
        String tokenB = registrarELogar("B", "userb", "b@simba.com", "senha123");

        mockMvc.perform(post("/lembretes")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("titulo", "   ", "mensagem", "x"))))
                .andExpect(status().is(422));

        MvcResult criado = mockMvc.perform(post("/lembretes")
                        .header("Authorization", bearer(tokenA))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "titulo", "Beber água",
                                "mensagem", "250 ml",
                                "horario", LocalDateTime.of(2026, 11, 16, 15, 0).toString()))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Beber água"))
                .andReturn();

        long id = objectMapper.readTree(criado.getResponse().getContentAsString()).get("id").asLong();

        mockMvc.perform(get("/lembretes")
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));

        mockMvc.perform(delete("/lembretes/" + id)
                        .header("Authorization", bearer(tokenB)))
                .andExpect(status().isForbidden());

        mockMvc.perform(delete("/lembretes/" + id)
                        .header("Authorization", bearer(tokenA)))
                .andExpect(status().isNoContent());

        assertEquals(0, lembreteRepository.count());
    }
}
