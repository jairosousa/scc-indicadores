package br.com.sococo.resumo.repository;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ResumoDiario entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResumoDiarioRepository extends JpaRepository<ResumoDiario, Long> {

}
