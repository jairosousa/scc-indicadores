package br.com.sococo.resumo.service;

import br.com.sococo.resumo.service.dto.ResumoDiarioDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ResumoDiario.
 */
public interface ResumoDiarioService {

    /**
     * Save a resumoDiario.
     *
     * @param resumoDiarioDTO the entity to save
     * @return the persisted entity
     */
    ResumoDiarioDTO save(ResumoDiarioDTO resumoDiarioDTO);

    /**
     * Get all the resumoDiarios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ResumoDiarioDTO> findAll(Pageable pageable);


    /**
     * Get the "id" resumoDiario.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ResumoDiarioDTO> findOne(Long id);

    /**
     * Delete the "id" resumoDiario.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
