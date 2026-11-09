package br.simba.bem_estar.sintoma;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroSintomaRepository extends JpaRepository<RegistroSintomaModel, Long> {

    Optional<RegistroSintomaModel> findByUsuarioIdAndDataRegistro(Long usuarioId, LocalDate dataRegistro);

    List<RegistroSintomaModel> findByUsuarioIdAndDataRegistroGreaterThanEqualOrderByDataRegistroDesc(
            Long usuarioId, LocalDate inicio);
}
