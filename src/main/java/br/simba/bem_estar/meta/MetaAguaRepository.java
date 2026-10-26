package br.simba.bem_estar.meta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaAguaRepository extends JpaRepository<MetaAguaModel, Long> {

    Optional<MetaAguaModel> findByUsuarioId(Long usuarioId);
}
