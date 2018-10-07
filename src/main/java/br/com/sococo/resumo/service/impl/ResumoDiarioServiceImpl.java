package br.com.sococo.resumo.service.impl;

import br.com.sococo.resumo.service.ResumoDiarioService;
import br.com.sococo.resumo.domain.ResumoDiario;
import br.com.sococo.resumo.repository.ResumoDiarioRepository;
import br.com.sococo.resumo.service.dto.ResumoDiarioDTO;
import br.com.sococo.resumo.service.mapper.ResumoDiarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing ResumoDiario.
 */
@Service
@Transactional
public class ResumoDiarioServiceImpl implements ResumoDiarioService {

    private final Logger log = LoggerFactory.getLogger(ResumoDiarioServiceImpl.class);

    private final ResumoDiarioRepository resumoDiarioRepository;

    private final ResumoDiarioMapper resumoDiarioMapper;

    public ResumoDiarioServiceImpl(ResumoDiarioRepository resumoDiarioRepository, ResumoDiarioMapper resumoDiarioMapper) {
        this.resumoDiarioRepository = resumoDiarioRepository;
        this.resumoDiarioMapper = resumoDiarioMapper;
    }

    /**
     * Save a resumoDiario.
     *
     * @param resumoDiarioDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ResumoDiarioDTO save(ResumoDiarioDTO resumoDiarioDTO) {
        log.debug("Request to save ResumoDiario : {}", resumoDiarioDTO);

        ResumoDiario resumoDiario = resumoDiarioMapper.toEntity(resumoDiarioDTO);
        resumoDiario = resumoDiarioRepository.save(resumoDiario);
        return resumoDiarioMapper.toDto(resumoDiario);
    }

    /**
     * Get all the resumoDiarios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ResumoDiarioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ResumoDiarios");
        return resumoDiarioRepository.findAll(pageable)
            .map(resumoDiarioMapper::toDto);
    }


    /**
     * Get one resumoDiario by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ResumoDiarioDTO> findOne(Long id) {
        log.debug("Request to get ResumoDiario : {}", id);
        return resumoDiarioRepository.findById(id)
            .map(resumoDiarioMapper::toDto);
    }

    /**
     * Delete the resumoDiario by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ResumoDiario : {}", id);
        resumoDiarioRepository.deleteById(id);
    }
}
