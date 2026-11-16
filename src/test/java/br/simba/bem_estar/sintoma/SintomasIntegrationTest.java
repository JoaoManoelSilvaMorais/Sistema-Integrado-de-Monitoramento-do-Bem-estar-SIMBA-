package br.simba.bem_estar.sintoma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import br.simba.bem_estar.BaseIntegrationTest;
import br.simba.bem_estar.user.UserModel;

class SintomasIntegrationTest extends BaseIntegrationTest {

    private static final ZoneId FUSO = ZoneId.of("America/Sao_Paulo");

    @Test
    void questionarioDiarioValidaAtualizaMesmoDiaEMontaHistoricoComResumoSemanal() throws Exception {
        String token = registrarELogar("Marco", "marco", "marco@simba.com", "senha123");
        UserModel usuario = userRepository.findByUsername("marco").orElseThrow();

        // Ainda não respondido hoje
        mockMvc.perform(get("/api/sintomas/hoje")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.respondido").value(false))
                .andExpect(jsonPath("$.registro").doesNotExist());

        // Dor sem locais -> 422
        mockMvc.perform(post("/api/sintomas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "energia", 3,
                                "humor", 3,
                                "estresse", 4,
                                "dor", "MODERADA",
                                "locaisDor", List.of()))))
                .andExpect(status().is(422));

        // Primeira resposta do dia cria registro
        MvcResult primeira = mockMvc.perform(post("/api/sintomas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "energia", 2,
                                "humor", 3,
                                "estresse", 4,
                                "dor", "LEVE",
                                "locaisDor", List.of("CABECA", "LOMBAR"),
                                "sintomas", List.of("CANSACO"),
                                "observacao", "Dia corrido"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dor").value("LEVE"))
                .andExpect(jsonPath("$.locaisDor.length()").value(2))
                .andReturn();

        long idHoje = objectMapper.readTree(primeira.getResponse().getContentAsString()).get("id").asLong();

        // Segunda resposta no mesmo dia atualiza o mesmo registro sem duplicar
        mockMvc.perform(post("/api/sintomas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "energia", 3,
                                "humor", 4,
                                "estresse", 2,
                                "dor", "NENHUMA",
                                "sintomas", List.of("CANSACO")))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idHoje))
                .andExpect(jsonPath("$.dor").value("NENHUMA"))
                .andExpect(jsonPath("$.locaisDor").isEmpty());

        assertEquals(1, registroSintomaRepository.count());

        // Confirma /hoje respondido
        mockMvc.perform(get("/api/sintomas/hoje")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.respondido").value(true))
                .andExpect(jsonPath("$.registro.id").value(idHoje));

        // Adiciona 2 dias anteriores na semana para testar ordenação e resumo do histórico
        LocalDate hoje = LocalDate.now(FUSO);
        for (int diasAtras : new int[] {1, 2}) {
            RegistroSintomaModel anterior = new RegistroSintomaModel();
            anterior.setUsuario(usuario);
            anterior.setDataRegistro(hoje.minusDays(diasAtras));
            anterior.setEnergia(3);
            anterior.setHumor(3);
            anterior.setEstresse(2);
            anterior.setDor(NivelDor.LEVE);
            anterior.setLocaisDor("CABECA");
            anterior.setSintomas("CANSACO");
            anterior.setCriadoEm(hoje.minusDays(diasAtras).atTime(20, 0));
            anterior.setAtualizadoEm(anterior.getCriadoEm());
            registroSintomaRepository.save(anterior);
        }

        mockMvc.perform(get("/api/sintomas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registros.length()").value(3))
                .andExpect(jsonPath("$.registros[0].data").value(hoje.toString()))
                .andExpect(jsonPath("$.semana.diasRespondidos").value(3))
                .andExpect(jsonPath("$.semana.sintomaMaisFrequente").value("CANSACO"))
                .andExpect(jsonPath("$.semana.vezesSintomaMaisFrequente").value(3));
    }
}
