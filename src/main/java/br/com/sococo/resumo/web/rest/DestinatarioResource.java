package br.com.sococo.resumo.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.sococo.resumo.service.DestinatarioService;
import br.com.sococo.resumo.web.rest.errors.BadRequestAlertException;
import br.com.sococo.resumo.web.rest.util.HeaderUtil;
import br.com.sococo.resumo.web.rest.util.PaginationUtil;
import br.com.sococo.resumo.service.dto.DestinatarioDTO;
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
 * REST controller for managing Destinatario.
 */
@RestController
@RequestMapping("/api")
public class DestinatarioResource {

    private final Logger log = LoggerFactory.getLogger(DestinatarioResource.class);

    private static final String ENTITY_NAME = "destinatario";

    private final DestinatarioService destinatarioService;

    public DestinatarioResource(DestinatarioService destinatarioService) {
        this.destinatarioService = destinatarioService;
    }

    /**
     * POST  /destinatarios : Create a new destinatario.
     *
     * @param destinatarioDTO the destinatarioDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new destinatarioDTO, or with status 400 (Bad Request) if the destinatario has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/destinatarios")
    @Timed
    public ResponseEntity<DestinatarioDTO> createDestinatario(@RequestBody DestinatarioDTO destinatarioDTO) throws URISyntaxException {
        log.debug("REST request to save Destinatario : {}", destinatarioDTO);
        if (destinatarioDTO.getId() != null) {
            throw new BadRequestAlertException("A new destinatario cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DestinatarioDTO result = destinatarioService.save(destinatarioDTO);
        return ResponseEntity.created(new URI("/api/destinatarios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /destinatarios : Updates an existing destinatario.
     *
     * @param destinatarioDTO the destinatarioDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated destinatarioDTO,
     * or with status 400 (Bad Request) if the destinatarioDTO is not valid,
     * or with status 500 (Internal Server Error) if the destinatarioDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/destinatarios")
    @Timed
    public ResponseEntity<DestinatarioDTO> updateDestinatario(@RequestBody DestinatarioDTO destinatarioDTO) throws URISyntaxException {
        log.debug("REST request to update Destinatario : {}", destinatarioDTO);
        if (destinatarioDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DestinatarioDTO result = destinatarioService.save(destinatarioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, destinatarioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /destinatarios : get all the destinatarios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of destinatarios in body
     */
    @GetMapping("/destinatarios")
    @Timed
    public ResponseEntity<List<DestinatarioDTO>> getAllDestinatarios(Pageable pageable) {
        log.debug("REST request to get a page of Destinatarios");
        Page<DestinatarioDTO> page = destinatarioService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/destinatarios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /destinatarios/:id : get the "id" destinatario.
     *
     * @param id the id of the destinatarioDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the destinatarioDTO, or with status 404 (Not Found)
     */
    @GetMapping("/destinatarios/{id}")
    @Timed
    public ResponseEntity<DestinatarioDTO> getDestinatario(@PathVariable Long id) {
        log.debug("REST request to get Destinatario : {}", id);
        Optional<DestinatarioDTO> destinatarioDTO = destinatarioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(destinatarioDTO);
    }

    /**
     * DELETE  /destinatarios/:id : delete the "id" destinatario.
     *
     * @param id the id of the destinatarioDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/destinatarios/{id}")
    @Timed
    public ResponseEntity<Void> deleteDestinatario(@PathVariable Long id) {
        log.debug("REST request to delete Destinatario : {}", id);
        destinatarioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
