package br.simba.bem_estar.rotina;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RotinaLembreteRepository extends JpaRepository<RotinaLembreteModel, UUID> {

    Optional<RotinaLembreteModel> findByIdAndRotinaId(UUID id, UUID rotinaId);
}
