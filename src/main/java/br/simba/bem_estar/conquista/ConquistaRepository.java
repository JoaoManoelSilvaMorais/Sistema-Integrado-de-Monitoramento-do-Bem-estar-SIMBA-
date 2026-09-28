package br.simba.bem_estar.conquista;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConquistaRepository
        extends JpaRepository<Conquista, Long> {

    List<Conquista> findAllByUsernameOrderByIdAsc(String username);

    Optional<Conquista> findByUsernameAndCodigo(
            String username,
            String codigo);

    boolean existsByUsernameAndCodigo(
            String username,
            String codigo);
}
