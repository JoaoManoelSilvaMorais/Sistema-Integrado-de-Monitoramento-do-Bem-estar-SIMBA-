package br.simba.bem_estar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.simba.bem_estar.conquista.ConquistaUsuarioRepository;
import br.simba.bem_estar.lembrete.LembreteRepository;
import br.simba.bem_estar.meta.MetaAguaRepository;
import br.simba.bem_estar.meta.MetaRepository;
import br.simba.bem_estar.perfil.PerfilRepository;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.rotina.RotinaLembreteRepository;
import br.simba.bem_estar.rotina.RotinaRepository;
import br.simba.bem_estar.sintoma.RegistroSintomaRepository;
import br.simba.bem_estar.user.UserRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Base compartilhada para os testes de integração (contexto Spring único em cache,
 * H2 em memória limpo antes de cada teste e utilitários de cadastro/autenticação JWT).
 */
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected RotinaLembreteRepository rotinaLembreteRepository;
    @Autowired
    protected RotinaRepository rotinaRepository;
    @Autowired
    protected LembreteRepository lembreteRepository;
    @Autowired
    protected ConquistaUsuarioRepository conquistaUsuarioRepository;
    @Autowired
    protected MetaRepository metaRepository;
    @Autowired
    protected MetaAguaRepository metaAguaRepository;
    @Autowired
    protected RegistroSintomaRepository registroSintomaRepository;
    @Autowired
    protected RegistroAguaRepository registroAguaRepository;
    @Autowired
    protected RegistroExercicioRepository registroExercicioRepository;
    @Autowired
    protected RegistroSonoRepository registroSonoRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected PerfilRepository perfilRepository;

    @BeforeEach
    void limparBanco() {
        rotinaLembreteRepository.deleteAllInBatch();
        rotinaRepository.deleteAllInBatch();
        lembreteRepository.deleteAllInBatch();
        conquistaUsuarioRepository.deleteAllInBatch();
        metaRepository.deleteAllInBatch();
        metaAguaRepository.deleteAllInBatch();
        registroSintomaRepository.deleteAllInBatch();
        registroAguaRepository.deleteAllInBatch();
        registroExercicioRepository.deleteAllInBatch();
        registroSonoRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
        perfilRepository.deleteAllInBatch();
    }

    protected String json(Object objeto) {
        return objectMapper.writeValueAsString(objeto);
    }

    protected void registrarUsuario(String nome, String username, String email, String senha) throws Exception {
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "name", nome,
                                "username", username,
                                "email", email,
                                "password", senha))))
                .andExpect(status().isOk());
    }

    protected String autenticar(String username, String senha) throws Exception {
        return mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(Map.of(
                                "username", username,
                                "password", senha))))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    protected String registrarELogar(String nome, String username, String email, String senha) throws Exception {
        registrarUsuario(nome, username, email, senha);
        return autenticar(username, senha);
    }

    protected String bearer(String token) {
        return "Bearer " + token;
    }
}
