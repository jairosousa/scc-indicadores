package br.com.sococo.resumo.service;

import br.com.sococo.resumo.service.dto.DestinatarioDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Destinatario.
 */
public interface DestinatarioService {

    /**
     * Save a destinatario.
     *
     * @param destinatarioDTO the entity to save
     * @return the persisted entity
     */
    DestinatarioDTO save(DestinatarioDTO destinatarioDTO);

    /**
     * Get all the destinatarios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<DestinatarioDTO> findAll(Pageable pageable);


    /**
     * Get the "id" destinatario.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<DestinatarioDTO> findOne(Long id);

    /**
     * Delete the "id" destinatario.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
