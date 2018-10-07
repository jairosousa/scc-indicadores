package br.com.sococo.resumo.web.rest;

import br.com.sococo.resumo.SccIndicadoresApp;

import br.com.sococo.resumo.domain.Destinatario;
import br.com.sococo.resumo.repository.DestinatarioRepository;
import br.com.sococo.resumo.service.DestinatarioService;
import br.com.sococo.resumo.service.dto.DestinatarioDTO;
import br.com.sococo.resumo.service.mapper.DestinatarioMapper;
import br.com.sococo.resumo.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static br.com.sococo.resumo.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the DestinatarioResource REST controller.
 *
 * @see DestinatarioResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SccIndicadoresApp.class)
public class DestinatarioResourceIntTest {

    private static final String DEFAULT_NOME = "AAAAAAAAAA";
    private static final String UPDATED_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    @Autowired
    private DestinatarioRepository destinatarioRepository;

    @Autowired
    private DestinatarioMapper destinatarioMapper;
    
    @Autowired
    private DestinatarioService destinatarioService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDestinatarioMockMvc;

    private Destinatario destinatario;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DestinatarioResource destinatarioResource = new DestinatarioResource(destinatarioService);
        this.restDestinatarioMockMvc = MockMvcBuilders.standaloneSetup(destinatarioResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Destinatario createEntity(EntityManager em) {
        Destinatario destinatario = new Destinatario()
            .nome(DEFAULT_NOME)
            .email(DEFAULT_EMAIL);
        return destinatario;
    }

    @Before
    public void initTest() {
        destinatario = createEntity(em);
    }

    @Test
    @Transactional
    public void createDestinatario() throws Exception {
        int databaseSizeBeforeCreate = destinatarioRepository.findAll().size();

        // Create the Destinatario
        DestinatarioDTO destinatarioDTO = destinatarioMapper.toDto(destinatario);
        restDestinatarioMockMvc.perform(post("/api/destinatarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(destinatarioDTO)))
            .andExpect(status().isCreated());

        // Validate the Destinatario in the database
        List<Destinatario> destinatarioList = destinatarioRepository.findAll();
        assertThat(destinatarioList).hasSize(databaseSizeBeforeCreate + 1);
        Destinatario testDestinatario = destinatarioList.get(destinatarioList.size() - 1);
        assertThat(testDestinatario.getNome()).isEqualTo(DEFAULT_NOME);
        assertThat(testDestinatario.getEmail()).isEqualTo(DEFAULT_EMAIL);
    }

    @Test
    @Transactional
    public void createDestinatarioWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = destinatarioRepository.findAll().size();

        // Create the Destinatario with an existing ID
        destinatario.setId(1L);
        DestinatarioDTO destinatarioDTO = destinatarioMapper.toDto(destinatario);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDestinatarioMockMvc.perform(post("/api/destinatarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(destinatarioDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Destinatario in the database
        List<Destinatario> destinatarioList = destinatarioRepository.findAll();
        assertThat(destinatarioList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllDestinatarios() throws Exception {
        // Initialize the database
        destinatarioRepository.saveAndFlush(destinatario);

        // Get all the destinatarioList
        restDestinatarioMockMvc.perform(get("/api/destinatarios?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(destinatario.getId().intValue())))
            .andExpect(jsonPath("$.[*].nome").value(hasItem(DEFAULT_NOME.toString())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())));
    }
    
    @Test
    @Transactional
    public void getDestinatario() throws Exception {
        // Initialize the database
        destinatarioRepository.saveAndFlush(destinatario);

        // Get the destinatario
        restDestinatarioMockMvc.perform(get("/api/destinatarios/{id}", destinatario.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(destinatario.getId().intValue()))
            .andExpect(jsonPath("$.nome").value(DEFAULT_NOME.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDestinatario() throws Exception {
        // Get the destinatario
        restDestinatarioMockMvc.perform(get("/api/destinatarios/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDestinatario() throws Exception {
        // Initialize the database
        destinatarioRepository.saveAndFlush(destinatario);

        int databaseSizeBeforeUpdate = destinatarioRepository.findAll().size();

        // Update the destinatario
        Destinatario updatedDestinatario = destinatarioRepository.findById(destinatario.getId()).get();
        // Disconnect from session so that the updates on updatedDestinatario are not directly saved in db
        em.detach(updatedDestinatario);
        updatedDestinatario
            .nome(UPDATED_NOME)
            .email(UPDATED_EMAIL);
        DestinatarioDTO destinatarioDTO = destinatarioMapper.toDto(updatedDestinatario);

        restDestinatarioMockMvc.perform(put("/api/destinatarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(destinatarioDTO)))
            .andExpect(status().isOk());

        // Validate the Destinatario in the database
        List<Destinatario> destinatarioList = destinatarioRepository.findAll();
        assertThat(destinatarioList).hasSize(databaseSizeBeforeUpdate);
        Destinatario testDestinatario = destinatarioList.get(destinatarioList.size() - 1);
        assertThat(testDestinatario.getNome()).isEqualTo(UPDATED_NOME);
        assertThat(testDestinatario.getEmail()).isEqualTo(UPDATED_EMAIL);
    }

    @Test
    @Transactional
    public void updateNonExistingDestinatario() throws Exception {
        int databaseSizeBeforeUpdate = destinatarioRepository.findAll().size();

        // Create the Destinatario
        DestinatarioDTO destinatarioDTO = destinatarioMapper.toDto(destinatario);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDestinatarioMockMvc.perform(put("/api/destinatarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(destinatarioDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Destinatario in the database
        List<Destinatario> destinatarioList = destinatarioRepository.findAll();
        assertThat(destinatarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDestinatario() throws Exception {
        // Initialize the database
        destinatarioRepository.saveAndFlush(destinatario);

        int databaseSizeBeforeDelete = destinatarioRepository.findAll().size();

        // Get the destinatario
        restDestinatarioMockMvc.perform(delete("/api/destinatarios/{id}", destinatario.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Destinatario> destinatarioList = destinatarioRepository.findAll();
        assertThat(destinatarioList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Destinatario.class);
        Destinatario destinatario1 = new Destinatario();
        destinatario1.setId(1L);
        Destinatario destinatario2 = new Destinatario();
        destinatario2.setId(destinatario1.getId());
        assertThat(destinatario1).isEqualTo(destinatario2);
        destinatario2.setId(2L);
        assertThat(destinatario1).isNotEqualTo(destinatario2);
        destinatario1.setId(null);
        assertThat(destinatario1).isNotEqualTo(destinatario2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DestinatarioDTO.class);
        DestinatarioDTO destinatarioDTO1 = new DestinatarioDTO();
        destinatarioDTO1.setId(1L);
        DestinatarioDTO destinatarioDTO2 = new DestinatarioDTO();
        assertThat(destinatarioDTO1).isNotEqualTo(destinatarioDTO2);
        destinatarioDTO2.setId(destinatarioDTO1.getId());
        assertThat(destinatarioDTO1).isEqualTo(destinatarioDTO2);
        destinatarioDTO2.setId(2L);
        assertThat(destinatarioDTO1).isNotEqualTo(destinatarioDTO2);
        destinatarioDTO1.setId(null);
        assertThat(destinatarioDTO1).isNotEqualTo(destinatarioDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(destinatarioMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(destinatarioMapper.fromId(null)).isNull();
    }
}
