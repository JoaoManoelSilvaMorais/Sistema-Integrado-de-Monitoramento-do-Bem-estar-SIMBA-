package br.simba.bem_estar.infra;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.DadosDuplicadosException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;

class RestExceptionHandlerTest {

    private MockMvc mockMvc;

    @RestController
    static class ControllerDeTeste {
        @GetMapping("/teste/negocio")
        void negocio() {
            throw new RegraDeNegocioException("Regra violada");
        }

        @GetMapping("/teste/nao-encontrado")
        void naoEncontrado() {
            throw new DadoNaoEncontradoException("Item ausente");
        }

        @GetMapping("/teste/acesso")
        void acesso() {
            throw new AcessoNegadoException("Sem permissão");
        }

        @GetMapping("/teste/duplicado")
        void duplicado() {
            throw new DadosDuplicadosException("Já cadastrado");
        }

        @GetMapping("/teste/interno")
        void interno() {
            throw new IllegalStateException("Detalhe sensível interno");
        }
    }

    @BeforeEach
    void configurarMockMvc() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ControllerDeTeste())
                .setControllerAdvice(new RestExceptionHandler())
                .build();
    }

    @Test
    void mapeiaExcecoesDoSistemaParaStatusHttpCorretos() throws Exception {
        mockMvc.perform(get("/teste/negocio"))
                .andExpect(status().is(422))
                .andExpect(jsonPath("$.message").value("Regra violada"));

        mockMvc.perform(get("/teste/nao-encontrado"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Item ausente"));

        mockMvc.perform(get("/teste/acesso"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("Sem permissão"));

        mockMvc.perform(get("/teste/duplicado"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("Já cadastrado"));

        mockMvc.perform(get("/teste/interno"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Ocorreu um erro interno inesperado no servidor."));
    }
}
