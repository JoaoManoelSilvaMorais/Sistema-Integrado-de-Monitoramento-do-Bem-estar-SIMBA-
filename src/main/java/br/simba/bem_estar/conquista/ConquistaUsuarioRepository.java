package br.simba.bem_estar.conquista;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConquistaUsuarioRepository extends JpaRepository<ConquistaUsuarioModel, Long> {

    List<ConquistaUsuarioModel> findByUsuarioId(Long usuarioId);
}
