package br.simba.bem_estar.registroAgua;

import org.springframework.data.jpa.repository.JpaRepository;
import br.simba.bem_estar.user.UserModel;
import java.util.List;

public interface RegistroAguaRepository extends JpaRepository<RegistroAguaModel,Long>{
	List<RegistroAguaModel> findByUsuario(UserModel usuario);
}
