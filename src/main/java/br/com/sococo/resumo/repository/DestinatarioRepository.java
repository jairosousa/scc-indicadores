package br.com.sococo.resumo.repository;

import br.com.sococo.resumo.domain.Destinatario;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Destinatario entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {

}
