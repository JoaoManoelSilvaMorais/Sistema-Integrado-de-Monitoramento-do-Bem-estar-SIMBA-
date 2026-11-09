package br.simba.bem_estar.lembrete;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.simba.bem_estar.user.UserModel;

public interface LembreteRepository extends JpaRepository<LembreteModel, Long> {
    List<LembreteModel> findByUsuario(UserModel usuario);


    void deleteByUsuarioId(Long usuarioId);

}