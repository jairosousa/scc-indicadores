package br.com.sococo.resumo.web.rest;

import br.com.sococo.resumo.domain.User;
import br.com.sococo.resumo.repository.UserRepository;
import br.com.sococo.resumo.security.SecurityUtils;
import br.com.sococo.resumo.service.MailService;
import br.com.sococo.resumo.service.ResumoDiarioService;
import br.com.sococo.resumo.service.dto.ResumoDiarioDTO;
import br.com.sococo.resumo.web.rest.errors.BadRequestAlertException;
import br.com.sococo.resumo.web.rest.util.HeaderUtil;
import br.com.sococo.resumo.web.rest.util.PaginationUtil;
import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ResumoDiario.
 */
@RestController
@RequestMapping("/api")
public class ResumoDiarioResource {

    private final Logger log = LoggerFactory.getLogger(ResumoDiarioResource.class);

    private static final String ENTITY_NAME = "resumoDiario";

    private final MailService mailService;

    private final ResumoDiarioService resumoDiarioService;

    private final UserRepository userRepository;

    public ResumoDiarioResource(MailService mailService, ResumoDiarioService resumoDiarioService, UserRepository userRepository) {
        this.mailService = mailService;
        this.resumoDiarioService = resumoDiarioService;
        this.userRepository = userRepository;
    }

    /**
     * POST  /resumo-diarios : Create a new resumoDiario.
     *
     * @param resumoDiarioDTO the resumoDiarioDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new resumoDiarioDTO, or with status 400 (Bad Request) if the resumoDiario has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/resumo-diarios")
    @Timed
    public ResponseEntity<ResumoDiarioDTO> createResumoDiario(@RequestBody ResumoDiarioDTO resumoDiarioDTO) throws URISyntaxException {
        log.debug("REST request to save ResumoDiario : {}", resumoDiarioDTO);
        if (resumoDiarioDTO.getId() != null) {
            throw new BadRequestAlertException("A new resumoDiario cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResumoDiarioDTO result = resumoDiarioService.save(resumoDiarioDTO);


        return ResponseEntity.created(new URI("/api/resumo-diarios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /resumo-diarios : Updates an existing resumoDiario.
     *
     * @param resumoDiarioDTO the resumoDiarioDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated resumoDiarioDTO,
     * or with status 400 (Bad Request) if the resumoDiarioDTO is not valid,
     * or with status 500 (Internal Server Error) if the resumoDiarioDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/resumo-diarios")
    @Timed
    public ResponseEntity<ResumoDiarioDTO> updateResumoDiario(@RequestBody ResumoDiarioDTO resumoDiarioDTO) throws URISyntaxException {
        log.debug("REST request to update ResumoDiario : {}", resumoDiarioDTO);
        if (resumoDiarioDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ResumoDiarioDTO result = resumoDiarioService.save(resumoDiarioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, resumoDiarioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /resumo-diarios : get all the resumoDiarios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of resumoDiarios in body
     */
    @GetMapping("/resumo-diarios")
    @Timed
    public ResponseEntity<List<ResumoDiarioDTO>> getAllResumoDiarios(Pageable pageable) {
        log.debug("REST request to get a page of ResumoDiarios");
        Page<ResumoDiarioDTO> page = resumoDiarioService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/resumo-diarios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /resumo-diarios/:id : get the "id" resumoDiario.
     *
     * @param id the id of the resumoDiarioDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the resumoDiarioDTO, or with status 404 (Not Found)
     */
    @GetMapping("/resumo-diarios/{id}")
    @Timed
    public ResponseEntity<ResumoDiarioDTO> getResumoDiario(@PathVariable Long id) {
        log.debug("REST request to get ResumoDiario : {}", id);
        Optional<ResumoDiarioDTO> resumoDiarioDTO = resumoDiarioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resumoDiarioDTO);
    }

    /**
     * DELETE  /resumo-diarios/:id : delete the "id" resumoDiario.
     *
     * @param id the id of the resumoDiarioDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/resumo-diarios/{id}")
    @Timed
    public ResponseEntity<Void> deleteResumoDiario(@PathVariable Long id) {
        log.debug("REST request to delete ResumoDiario : {}", id);
        resumoDiarioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }


}
