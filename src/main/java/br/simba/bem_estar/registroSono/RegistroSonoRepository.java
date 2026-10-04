package br.simba.bem_estar.registroSono;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroSonoRepository
        extends JpaRepository<RegistroSonoModel, Long> {

    List<RegistroSonoModel>
        findByUsuario_IdOrderByHoraDormirDesc(Long usuarioId);

    List<RegistroSonoModel>
        findByUsuario_IdAndHoraAcordarBetweenOrderByHoraAcordarAsc(
            Long usuarioId,
            LocalDateTime inicio,
            LocalDateTime fim
        );
}