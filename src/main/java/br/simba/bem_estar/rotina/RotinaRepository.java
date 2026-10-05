package br.simba.bem_estar.rotina;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RotinaRepository extends JpaRepository<RotinaModel, UUID> {

    List<RotinaModel> findByUsuarioId(Long usuarioId);

    java.util.Optional<RotinaModel> findByIdAndUsuarioId(UUID id, Long usuarioId);
}
