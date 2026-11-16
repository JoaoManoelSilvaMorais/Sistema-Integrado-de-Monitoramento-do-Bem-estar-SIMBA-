package br.simba.bem_estar.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MvcResult;

import br.simba.bem_estar.BaseIntegrationTest;
import br.simba.bem_estar.user.UserModel;

class AuthUserIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void endpointsProtegidosExigemTokenValidoEPaginasPublicasSaoLiberadas() throws Exception {
        mockMvc.perform(get("/users/me")).andExpect(status().isForbidden());
        mockMvc.perform(get("/api/metas")).andExpect(status().isForbidden());
        mockMvc.perform(get("/api/sintomas")).andExpect(status().isForbidden());
        mockMvc.perform(get("/api/rotinas")).andExpect(status().isForbidden());
        mockMvc.perform(get("/registroAgua")).andExpect(status().isForbidden());

        mockMvc.perform(get("/users/me")
                        .header("Authorization", "Bearer token.invalido.aqui"))
                .andExpect(status().isForbidden());

        mockMvc.perform(get("/entrar.html")).andExpect(status().isOk());
        mockMvc.perform(get("/index.html")).andExpect(status().isOk());
    }

    @Test
    void cicloCompletoDeCadastroLoginAtualizacaoDePerfilETrocaDeSenha() throws Exception {
        registrarUsuario("João Manoel", "joao", "joao@simba.com", "senha123");

        UserModel salvo = userRepository.findByUsername("joao").orElseThrow();
        assertNotEquals("senha123", salvo.getPassword());
        assertTrue(passwordEncoder.matches("senha123", salvo.getPassword()));

        // Login com senha errada falha (BadCredentialsException tratada pelo RestExceptionHandler)
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("username", "joao", "password", "errada"))))
                .andExpect(status().isInternalServerError());

        String token = autenticar("joao", "senha123");

        // Consulta usuário atual sem expor senha
        mockMvc.perform(get("/users/me")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("João Manoel"))
                .andExpect(jsonPath("$.username").value("joao"))
                .andExpect(jsonPath("$.email").value("joao@simba.com"))
                .andExpect(jsonPath("$.password").doesNotExist());

        // Atualiza dados e recebe novo JWT para o novo username
        MvcResult atualizacao = mockMvc.perform(put("/users/me")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "name", "João Atualizado",
                                "username", "joao_silva",
                                "email", "joao.silva@simba.com"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.usuario.username").value("joao_silva"))
                .andExpect(jsonPath("$.token").isNotEmpty())
                .andReturn();

        String novoToken = objectMapper.readTree(atualizacao.getResponse().getContentAsString())
                .get("token").asString();

        mockMvc.perform(get("/users/me")
                        .header("Authorization", bearer(novoToken)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("joao_silva"));

        // Troca de senha com validação e novo login
        mockMvc.perform(put("/users/me/password")
                        .header("Authorization", bearer(novoToken))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "senhaAtual", "errada",
                                "novaSenha", "nova123",
                                "confirmarSenha", "nova123"))))
                .andExpect(status().isBadRequest());

        mockMvc.perform(put("/users/me/password")
                        .header("Authorization", bearer(novoToken))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "senhaAtual", "senha123",
                                "novaSenha", "nova456",
                                "confirmarSenha", "nova456"))))
                .andExpect(status().isOk());

        String tokenPosTroca = autenticar("joao_silva", "nova456");
        assertFalse(tokenPosTroca.isBlank());
    }

    @Test
    void excluirContaRemoveUsuarioPerfilETodosOsRegistrosRelacionados() throws Exception {
        String token = registrarELogar("Maria", "maria", "maria@simba.com", "segredo1");

        // Popula dados em vários módulos para garantir exclusão em cascata sem erro de FK
        mockMvc.perform(put("/perfil/me/medidas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("peso", 65.0, "altura", 1.68))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/registroAgua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "quantidadeMl", 500,
                                "dataHora", LocalDateTime.now().toString()))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/registrosono/")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "horaDormir", LocalDateTime.now().minusHours(8).toString(),
                                "horaAcordar", LocalDateTime.now().toString(),
                                "notaSono", 5))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/registroexercicio")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "modalidade", "Corrida",
                                "duracaominutos", 30,
                                "gastoCaloricoExtimado", 280,
                                "dataHora", LocalDateTime.now().toString()))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/metas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("tipo", "TREINO_TOTAL", "alvo", 5))))
                .andExpect(status().isCreated());

        mockMvc.perform(put("/api/metas/agua")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("metaMl", 2400))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/lembretes")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "titulo", "Remédio",
                                "mensagem", "Tomar",
                                "horario", LocalDateTime.now().plusHours(1).toString()))))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/rotinas")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("nome", "Treinos", "descricao", "Semana", "ativa", true))))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/api/conquistas")
                        .header("Authorization", bearer(token)))
                .andExpect(status().isOk());

        // Senha incorreta não apaga conta
        mockMvc.perform(delete("/users/me")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("senha", "errada"))))
                .andExpect(status().isUnauthorized());

        // Senha correta exclui tudo (obs.: registros de sintoma não são usados neste teste;
        // UserAccountService ainda não apaga tb_registro_sintoma)
        mockMvc.perform(delete("/users/me")
                        .header("Authorization", bearer(token))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of("senha", "segredo1"))))
                .andExpect(status().isNoContent());

        assertTrue(userRepository.findByUsername("maria").isEmpty());
        assertEquals(0, perfilRepository.count());
        assertEquals(0, registroAguaRepository.count());
        assertEquals(0, registroSonoRepository.count());
        assertEquals(0, registroExercicioRepository.count());
        assertEquals(0, metaRepository.count());
        assertEquals(0, metaAguaRepository.count());
        assertEquals(0, conquistaUsuarioRepository.count());
        assertEquals(0, lembreteRepository.count());
        assertEquals(0, rotinaRepository.count());
    }
}
