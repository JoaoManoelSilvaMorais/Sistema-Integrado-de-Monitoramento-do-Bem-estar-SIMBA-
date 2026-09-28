
package br.simba.bem_estar.conquista;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConquistaService {

    private final ConquistaRepository repository;

    public ConquistaService(ConquistaRepository repository) {
        this.repository = repository;
    }

    private record Modelo(
            String codigo,
            String titulo,
            String descricao,
            String icone) {
    }

    private static final List<Modelo> MODELOS = List.of(
        new Modelo(
            "PRIMEIRO_PASSO",
            "Primeiro passo",
            "Sua jornada de bem-estar come├ºou!",
            "fa-solid fa-flag"
        ),
        new Modelo(
            "HIDRATACAO",
            "Hidrata├º├úo em dia",
            "Conquista relacionada ├á hidrata├º├úo.",
            "fa-solid fa-droplet"
        ),
        new Modelo(
            "SONO",
            "Noite tranquila",
            "Conquista relacionada ao sono.",
            "fa-solid fa-moon"
        ),
        new Modelo(
            "TREINO",
            "Primeiro treino",
            "Conquista relacionada aos treinos.",
            "fa-solid fa-dumbbell"
        ),
        new Modelo(
            "DEDICACAO",
            "Dedica├º├úo",
            "Continue cuidando de voc├¬ e da sua rotina.",
            "fa-solid fa-trophy"
        )
    );

    @Transactional
    public List<Conquista> listar(String username) {
        criarConquistasIniciais(username);
        return repository.findAllByUsernameOrderByIdAsc(username);
    }

    @Transactional
    public Conquista buscarPorCodigo(
            String username,
            String codigo) {

        criarConquistasIniciais(username);

        return repository.findByUsernameAndCodigo(username, codigo)
                .orElseThrow(() ->
                    new IllegalArgumentException(
                        "Conquista n├úo encontrada."
                    )
                );
    }

    @Transactional
    public Conquista desbloquear(
            String username,
            String codigo) {

        Conquista conquista = buscarPorCodigo(username, codigo);

        conquista.desbloquear();

        return repository.save(conquista);
    }

    private void criarConquistasIniciais(String username) {
        for (Modelo modelo : MODELOS) {
            if (!repository.existsByUsernameAndCodigo(
                    username, modelo.codigo())) {

                Conquista conquista = new Conquista(
                    modelo.codigo(),
                    modelo.titulo(),
                    modelo.descricao(),
                    modelo.icone(),
                    username
                );

                repository.save(conquista);
            }
        }
    }
}
