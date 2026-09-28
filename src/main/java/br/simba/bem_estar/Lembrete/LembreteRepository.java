package br.simba.bem_estar.Lembrete;

import br.simba.bem_estar.model.LembreteModel;
import br.simba.bem_estar.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LembreteRepository extends JpaRepository<LembreteModel, Long> {
    List<LembreteModel> findByUsuario(UserModel usuario);
}