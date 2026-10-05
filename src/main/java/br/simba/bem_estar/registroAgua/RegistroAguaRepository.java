package br.simba.bem_estar.registroAgua;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.simba.bem_estar.user.UserModel;

public interface RegistroAguaRepository
        extends JpaRepository<RegistroAguaModel, Long> {

    List<RegistroAguaModel>
        findByUsuario(UserModel usuario);

    List<RegistroAguaModel>
        findByUsuarioAndDataHoraBetweenOrderByDataHoraAsc(
            UserModel usuario,
            LocalDateTime inicio,
            LocalDateTime fim
        );
}