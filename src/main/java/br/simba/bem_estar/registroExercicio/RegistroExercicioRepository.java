package br.simba.bem_estar.registroExercicio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.simba.bem_estar.user.UserModel;
import java.util.List;

public interface RegistroExercicioRepository extends JpaRepository<RegistroExercicioModel ,Long>{
	List<RegistroExercicioModel> findByUsuario(UserModel usuario);
}
