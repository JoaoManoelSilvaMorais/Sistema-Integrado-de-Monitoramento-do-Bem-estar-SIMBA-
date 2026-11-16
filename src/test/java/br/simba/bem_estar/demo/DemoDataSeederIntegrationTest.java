package br.simba.bem_estar.demo;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("demo")
class DemoDataSeederIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void perfilDemoPopulaDadosEIntegraTodasAsTelasDeLeitura() throws Exception {
        String token = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                Map.of("username", "demo", "password", "demo123"))))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        String bearer = "Bearer " + token;

        // Ontem ficou sem registro e hoje ainda está em aberto -> ofensiva em risco (dia 1)
        mockMvc.perform(get("/api/streak").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.atual", greaterThan(0)))
                .andExpect(jsonPath("$.emRisco").value(true))
                .andExpect(jsonPath("$.diaRisco").value(1))
                .andExpect(jsonPath("$.ultimaChance").value(false));

        mockMvc.perform(get("/api/proximo-passo").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipo").value("risco"));

        mockMvc.perform(get("/api/rotinas").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));

        mockMvc.perform(get("/api/metas").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        mockMvc.perform(get("/api/metas/agua").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pesoKg").value(72.5))
                .andExpect(jsonPath("$.sugeridaMl").value(2550));

        mockMvc.perform(get("/api/conquistas").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(26))
                .andExpect(jsonPath("$.desbloqueadas", greaterThan(0)));

        mockMvc.perform(get("/api/sintomas").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registros.length()").value(17));

        mockMvc.perform(get("/api/comparativo").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.agua.atual", greaterThan(0.0)));
    }
}
