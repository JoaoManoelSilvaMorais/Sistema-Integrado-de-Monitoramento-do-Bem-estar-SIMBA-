package br.simba.bem_estar.conquista;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConquistaRepository extends JpaRepository<Conquista, UUID> {
    Optional<Conquista> findByNome(String nome);
}
