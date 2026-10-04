package br.simba.bem_estar.registroExercicio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.simba.bem_estar.user.UserModel;

public interface RegistroExercicioRepository
        extends JpaRepository<RegistroExercicioModel, Long> {

    List<RegistroExercicioModel>
        findByUsuario(UserModel usuario);

    List<RegistroExercicioModel>
        findByUsuarioAndDataHoraBetweenOrderByDataHoraAsc(
            UserModel usuario,
            LocalDateTime inicio,
            LocalDateTime fim
        );
}