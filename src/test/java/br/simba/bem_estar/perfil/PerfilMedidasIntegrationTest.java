package br.simba.bem_estar.perfil;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import br.simba.bem_estar.BaseIntegrationTest;

class PerfilMedidasIntegrationTest extends BaseIntegrationTest {

    @Test
    void perfilInicialSemMedidasEPreviaCalculamSemPersistir() throws Exception {
        String token = registrarELogar("Ana", "ana", "ana@simba.com", "senha123");

        mockMvc.perform(get("/perfil/me")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/perfil/me/medidas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.peso").value(nullValue()))
                .andExpect(jsonPath("$.altura").value(nullValue()))
                .andExpect(jsonPath("$.imc").value(nullValue()))
                .andExpect(jsonPath("$.sugestoes").isEmpty());

        // Prévia válida calcula IMC e sugestões sem criar perfil no banco
        mockMvc.perform(get("/perfil/me/medidas/previa")
                        .param("peso", "90")
                        .param("altura", "1.75")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imc").value(29.4))
                .andExpect(jsonPath("$.classificacaoImc").value("Sobrepeso"))
                .andExpect(jsonPath("$.sugestoes[*].tipo", hasItems("PESO", "AGUA", "ATIVIDADE")));

        mockMvc.perform(get("/perfil/me")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isNotFound());

        // Prévia inválida retorna 422 via RestExceptionHandler
        mockMvc.perform(get("/perfil/me/medidas/previa")
                        .param("peso", "10")
                        .header("Authorization", bearer(token)))
                .andExpect(status().is(422));
    }

    @Test
    void salvarMedidasCriaPerfilAtualizaMetaDeAguaSugeridaEPermiteLimparAltura() throws Exception {
        String token = registrarELogar("Bruno", "bruno", "bruno@simba.com", "senha123");

        // Antes de ter peso: meta sugerida padrão é 2000 ml
        mockMvc.perform(get("/api/metas/agua")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sugeridaMl").value(2000))
                .andExpect(jsonPath("$.metaMl").value(2000));

        // Salvar medidas cria e vincula PerfilModel ao usuário
        mockMvc.perform(put("/perfil/me/medidas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("peso", 90.0, "altura", 1.75))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imc").value(29.4))
                .andExpect(jsonPath("$.classificacaoImc").value("Sobrepeso"));

        // Meta de água sugerida acompanha automaticamente o peso salvo (90 * 35 = 3150)
        mockMvc.perform(get("/api/metas/agua")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sugeridaMl").value(3150))
                .andExpect(jsonPath("$.metaMl").value(3150))
                .andExpect(jsonPath("$.personalizada").value(false))
                .andExpect(jsonPath("$.pesoKg").value(90.0));

        // Atualiza peso e altura novamente pela rota /perfil/me/medidas
        mockMvc.perform(put("/perfil/me/medidas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("peso", 75.0, "altura", 1.80))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.peso").value(75.0))
                .andExpect(jsonPath("$.altura").value(1.80))
                .andExpect(jsonPath("$.imc").value(23.1))
                .andExpect(jsonPath("$.classificacaoImc").value("Peso adequado"));

        // Deixar altura em branco (null) grava 0 no banco e devolve null em /medidas
        Map<String, Object> apenasPeso = new HashMap<>();
        apenasPeso.put("peso", 72.5);
        apenasPeso.put("altura", null);
        mockMvc.perform(put("/perfil/me/medidas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(apenasPeso)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.peso").value(72.5))
                .andExpect(jsonPath("$.altura").value(nullValue()))
                .andExpect(jsonPath("$.imc").value(nullValue()));

        mockMvc.perform(get("/perfil/me/medidas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.peso").value(72.5))
                .andExpect(jsonPath("$.altura").value(nullValue()));
    }
}
