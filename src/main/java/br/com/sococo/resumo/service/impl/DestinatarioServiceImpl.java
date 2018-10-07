package br.com.sococo.resumo.service.impl;

import br.com.sococo.resumo.service.DestinatarioService;
import br.com.sococo.resumo.domain.Destinatario;
import br.com.sococo.resumo.repository.DestinatarioRepository;
import br.com.sococo.resumo.service.dto.DestinatarioDTO;
import br.com.sococo.resumo.service.mapper.DestinatarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Destinatario.
 */
@Service
@Transactional
public class DestinatarioServiceImpl implements DestinatarioService {

    private final Logger log = LoggerFactory.getLogger(DestinatarioServiceImpl.class);

    private final DestinatarioRepository destinatarioRepository;

    private final DestinatarioMapper destinatarioMapper;

    public DestinatarioServiceImpl(DestinatarioRepository destinatarioRepository, DestinatarioMapper destinatarioMapper) {
        this.destinatarioRepository = destinatarioRepository;
        this.destinatarioMapper = destinatarioMapper;
    }

    /**
     * Save a destinatario.
     *
     * @param destinatarioDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DestinatarioDTO save(DestinatarioDTO destinatarioDTO) {
        log.debug("Request to save Destinatario : {}", destinatarioDTO);

        Destinatario destinatario = destinatarioMapper.toEntity(destinatarioDTO);
        destinatario = destinatarioRepository.save(destinatario);
        return destinatarioMapper.toDto(destinatario);
    }

    /**
     * Get all the destinatarios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DestinatarioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Destinatarios");
        return destinatarioRepository.findAll(pageable)
            .map(destinatarioMapper::toDto);
    }


    /**
     * Get one destinatario by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DestinatarioDTO> findOne(Long id) {
        log.debug("Request to get Destinatario : {}", id);
        return destinatarioRepository.findById(id)
            .map(destinatarioMapper::toDto);
    }

    /**
     * Delete the destinatario by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Destinatario : {}", id);
        destinatarioRepository.deleteById(id);
    }
}
