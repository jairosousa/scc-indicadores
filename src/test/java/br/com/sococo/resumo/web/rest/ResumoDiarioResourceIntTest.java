package br.com.sococo.resumo.web.rest;

import br.com.sococo.resumo.SccIndicadoresApp;

import br.com.sococo.resumo.domain.ResumoDiario;
import br.com.sococo.resumo.repository.ResumoDiarioRepository;
import br.com.sococo.resumo.service.ResumoDiarioService;
import br.com.sococo.resumo.service.dto.ResumoDiarioDTO;
import br.com.sococo.resumo.service.mapper.ResumoDiarioMapper;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static br.com.sococo.resumo.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ResumoDiarioResource REST controller.
 *
 * @see ResumoDiarioResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SccIndicadoresApp.class)
public class ResumoDiarioResourceIntTest {

    private static final LocalDate DEFAULT_DATA_LANCAMENTO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_LANCAMENTO = LocalDate.now(ZoneId.systemDefault());

    private static final Double DEFAULT_COCOS_PROCESSADOS = 1D;
    private static final Double UPDATED_COCOS_PROCESSADOS = 2D;

    private static final Double DEFAULT_COCOS_DESFIBRADOS = 1D;
    private static final Double UPDATED_COCOS_DESFIBRADOS = 2D;

    private static final Double DEFAULT_CRI = 1D;
    private static final Double UPDATED_CRI = 2D;

    private static final Double DEFAULT_FLOCOCO = 1D;
    private static final Double UPDATED_FLOCOCO = 2D;

    private static final Double DEFAULT_OLEO_INDUSTRIAL_TIPO_A = 1D;
    private static final Double UPDATED_OLEO_INDUSTRIAL_TIPO_A = 2D;

    private static final Double DEFAULT_OLEO_INDUSTRIAL_ETE = 1D;
    private static final Double UPDATED_OLEO_INDUSTRIAL_ETE = 2D;

    private static final Double DEFAULT_TORTA = 1D;
    private static final Double UPDATED_TORTA = 2D;

    private static final Double DEFAULT_AGUA_DE_COCO_SOCOCO = 1D;
    private static final Double UPDATED_AGUA_DE_COCO_SOCOCO = 2D;

    private static final Double DEFAULT_AGUA_DE_COCO_VERDE = 1D;
    private static final Double UPDATED_AGUA_DE_COCO_VERDE = 2D;

    private static final Double DEFAULT_CAIXA_PADRAO = 1D;
    private static final Double UPDATED_CAIXA_PADRAO = 2D;

    private static final Double DEFAULT_PORCENTAGEM_COCO_GERMINADO = 1D;
    private static final Double UPDATED_PORCENTAGEM_COCO_GERMINADO = 2D;

    private static final Double DEFAULT_TOTAL_DE_CACAMBAS = 1D;
    private static final Double UPDATED_TOTAL_DE_CACAMBAS = 2D;

    private static final Double DEFAULT_NUMERO_DE_FARDOS = 1D;
    private static final Double UPDATED_NUMERO_DE_FARDOS = 2D;

    private static final String DEFAULT_DIA_LANCAMENTO = "AAAAAAAAAA";
    private static final String UPDATED_DIA_LANCAMENTO = "BBBBBBBBBB";

    private static final String DEFAULT_MES_LANCAMENTO = "AAAAAAAAAA";
    private static final String UPDATED_MES_LANCAMENTO = "BBBBBBBBBB";

    private static final String DEFAULT_ANO_LANCAMENTO = "AAAAAAAAAA";
    private static final String UPDATED_ANO_LANCAMENTO = "BBBBBBBBBB";

    @Autowired
    private ResumoDiarioRepository resumoDiarioRepository;

    @Autowired
    private ResumoDiarioMapper resumoDiarioMapper;
    
    @Autowired
    private ResumoDiarioService resumoDiarioService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restResumoDiarioMockMvc;

    private ResumoDiario resumoDiario;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ResumoDiarioResource resumoDiarioResource = new ResumoDiarioResource(resumoDiarioService);
        this.restResumoDiarioMockMvc = MockMvcBuilders.standaloneSetup(resumoDiarioResource)
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
    public static ResumoDiario createEntity(EntityManager em) {
        ResumoDiario resumoDiario = new ResumoDiario()
            .dataLancamento(DEFAULT_DATA_LANCAMENTO)
            .cocosProcessados(DEFAULT_COCOS_PROCESSADOS)
            .cocosDesfibrados(DEFAULT_COCOS_DESFIBRADOS)
            .cri(DEFAULT_CRI)
            .flococo(DEFAULT_FLOCOCO)
            .oleoIndustrialTipoA(DEFAULT_OLEO_INDUSTRIAL_TIPO_A)
            .oleoIndustrialETE(DEFAULT_OLEO_INDUSTRIAL_ETE)
            .torta(DEFAULT_TORTA)
            .aguaDeCocoSococo(DEFAULT_AGUA_DE_COCO_SOCOCO)
            .aguaDeCocoVerde(DEFAULT_AGUA_DE_COCO_VERDE)
            .caixaPadrao(DEFAULT_CAIXA_PADRAO)
            .porcentagemCocoGerminado(DEFAULT_PORCENTAGEM_COCO_GERMINADO)
            .totalDeCacambas(DEFAULT_TOTAL_DE_CACAMBAS)
            .numeroDeFardos(DEFAULT_NUMERO_DE_FARDOS)
            .diaLancamento(DEFAULT_DIA_LANCAMENTO)
            .mesLancamento(DEFAULT_MES_LANCAMENTO)
            .anoLancamento(DEFAULT_ANO_LANCAMENTO);
        return resumoDiario;
    }

    @Before
    public void initTest() {
        resumoDiario = createEntity(em);
    }

    @Test
    @Transactional
    public void createResumoDiario() throws Exception {
        int databaseSizeBeforeCreate = resumoDiarioRepository.findAll().size();

        // Create the ResumoDiario
        ResumoDiarioDTO resumoDiarioDTO = resumoDiarioMapper.toDto(resumoDiario);
        restResumoDiarioMockMvc.perform(post("/api/resumo-diarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(resumoDiarioDTO)))
            .andExpect(status().isCreated());

        // Validate the ResumoDiario in the database
        List<ResumoDiario> resumoDiarioList = resumoDiarioRepository.findAll();
        assertThat(resumoDiarioList).hasSize(databaseSizeBeforeCreate + 1);
        ResumoDiario testResumoDiario = resumoDiarioList.get(resumoDiarioList.size() - 1);
        assertThat(testResumoDiario.getDataLancamento()).isEqualTo(DEFAULT_DATA_LANCAMENTO);
        assertThat(testResumoDiario.getCocosProcessados()).isEqualTo(DEFAULT_COCOS_PROCESSADOS);
        assertThat(testResumoDiario.getCocosDesfibrados()).isEqualTo(DEFAULT_COCOS_DESFIBRADOS);
        assertThat(testResumoDiario.getCri()).isEqualTo(DEFAULT_CRI);
        assertThat(testResumoDiario.getFlococo()).isEqualTo(DEFAULT_FLOCOCO);
        assertThat(testResumoDiario.getOleoIndustrialTipoA()).isEqualTo(DEFAULT_OLEO_INDUSTRIAL_TIPO_A);
        assertThat(testResumoDiario.getOleoIndustrialETE()).isEqualTo(DEFAULT_OLEO_INDUSTRIAL_ETE);
        assertThat(testResumoDiario.getTorta()).isEqualTo(DEFAULT_TORTA);
        assertThat(testResumoDiario.getAguaDeCocoSococo()).isEqualTo(DEFAULT_AGUA_DE_COCO_SOCOCO);
        assertThat(testResumoDiario.getAguaDeCocoVerde()).isEqualTo(DEFAULT_AGUA_DE_COCO_VERDE);
        assertThat(testResumoDiario.getCaixaPadrao()).isEqualTo(DEFAULT_CAIXA_PADRAO);
        assertThat(testResumoDiario.getPorcentagemCocoGerminado()).isEqualTo(DEFAULT_PORCENTAGEM_COCO_GERMINADO);
        assertThat(testResumoDiario.getTotalDeCacambas()).isEqualTo(DEFAULT_TOTAL_DE_CACAMBAS);
        assertThat(testResumoDiario.getNumeroDeFardos()).isEqualTo(DEFAULT_NUMERO_DE_FARDOS);
        assertThat(testResumoDiario.getDiaLancamento()).isEqualTo(DEFAULT_DIA_LANCAMENTO);
        assertThat(testResumoDiario.getMesLancamento()).isEqualTo(DEFAULT_MES_LANCAMENTO);
        assertThat(testResumoDiario.getAnoLancamento()).isEqualTo(DEFAULT_ANO_LANCAMENTO);
    }

    @Test
    @Transactional
    public void createResumoDiarioWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = resumoDiarioRepository.findAll().size();

        // Create the ResumoDiario with an existing ID
        resumoDiario.setId(1L);
        ResumoDiarioDTO resumoDiarioDTO = resumoDiarioMapper.toDto(resumoDiario);

        // An entity with an existing ID cannot be created, so this API call must fail
        restResumoDiarioMockMvc.perform(post("/api/resumo-diarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(resumoDiarioDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ResumoDiario in the database
        List<ResumoDiario> resumoDiarioList = resumoDiarioRepository.findAll();
        assertThat(resumoDiarioList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllResumoDiarios() throws Exception {
        // Initialize the database
        resumoDiarioRepository.saveAndFlush(resumoDiario);

        // Get all the resumoDiarioList
        restResumoDiarioMockMvc.perform(get("/api/resumo-diarios?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(resumoDiario.getId().intValue())))
            .andExpect(jsonPath("$.[*].dataLancamento").value(hasItem(DEFAULT_DATA_LANCAMENTO.toString())))
            .andExpect(jsonPath("$.[*].cocosProcessados").value(hasItem(DEFAULT_COCOS_PROCESSADOS.doubleValue())))
            .andExpect(jsonPath("$.[*].cocosDesfibrados").value(hasItem(DEFAULT_COCOS_DESFIBRADOS.doubleValue())))
            .andExpect(jsonPath("$.[*].cri").value(hasItem(DEFAULT_CRI.doubleValue())))
            .andExpect(jsonPath("$.[*].flococo").value(hasItem(DEFAULT_FLOCOCO.doubleValue())))
            .andExpect(jsonPath("$.[*].oleoIndustrialTipoA").value(hasItem(DEFAULT_OLEO_INDUSTRIAL_TIPO_A.doubleValue())))
            .andExpect(jsonPath("$.[*].oleoIndustrialETE").value(hasItem(DEFAULT_OLEO_INDUSTRIAL_ETE.doubleValue())))
            .andExpect(jsonPath("$.[*].torta").value(hasItem(DEFAULT_TORTA.doubleValue())))
            .andExpect(jsonPath("$.[*].aguaDeCocoSococo").value(hasItem(DEFAULT_AGUA_DE_COCO_SOCOCO.doubleValue())))
            .andExpect(jsonPath("$.[*].aguaDeCocoVerde").value(hasItem(DEFAULT_AGUA_DE_COCO_VERDE.doubleValue())))
            .andExpect(jsonPath("$.[*].caixaPadrao").value(hasItem(DEFAULT_CAIXA_PADRAO.doubleValue())))
            .andExpect(jsonPath("$.[*].porcentagemCocoGerminado").value(hasItem(DEFAULT_PORCENTAGEM_COCO_GERMINADO.doubleValue())))
            .andExpect(jsonPath("$.[*].totalDeCacambas").value(hasItem(DEFAULT_TOTAL_DE_CACAMBAS.doubleValue())))
            .andExpect(jsonPath("$.[*].numeroDeFardos").value(hasItem(DEFAULT_NUMERO_DE_FARDOS.doubleValue())))
            .andExpect(jsonPath("$.[*].diaLancamento").value(hasItem(DEFAULT_DIA_LANCAMENTO.toString())))
            .andExpect(jsonPath("$.[*].mesLancamento").value(hasItem(DEFAULT_MES_LANCAMENTO.toString())))
            .andExpect(jsonPath("$.[*].anoLancamento").value(hasItem(DEFAULT_ANO_LANCAMENTO.toString())));
    }
    
    @Test
    @Transactional
    public void getResumoDiario() throws Exception {
        // Initialize the database
        resumoDiarioRepository.saveAndFlush(resumoDiario);

        // Get the resumoDiario
        restResumoDiarioMockMvc.perform(get("/api/resumo-diarios/{id}", resumoDiario.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(resumoDiario.getId().intValue()))
            .andExpect(jsonPath("$.dataLancamento").value(DEFAULT_DATA_LANCAMENTO.toString()))
            .andExpect(jsonPath("$.cocosProcessados").value(DEFAULT_COCOS_PROCESSADOS.doubleValue()))
            .andExpect(jsonPath("$.cocosDesfibrados").value(DEFAULT_COCOS_DESFIBRADOS.doubleValue()))
            .andExpect(jsonPath("$.cri").value(DEFAULT_CRI.doubleValue()))
            .andExpect(jsonPath("$.flococo").value(DEFAULT_FLOCOCO.doubleValue()))
            .andExpect(jsonPath("$.oleoIndustrialTipoA").value(DEFAULT_OLEO_INDUSTRIAL_TIPO_A.doubleValue()))
            .andExpect(jsonPath("$.oleoIndustrialETE").value(DEFAULT_OLEO_INDUSTRIAL_ETE.doubleValue()))
            .andExpect(jsonPath("$.torta").value(DEFAULT_TORTA.doubleValue()))
            .andExpect(jsonPath("$.aguaDeCocoSococo").value(DEFAULT_AGUA_DE_COCO_SOCOCO.doubleValue()))
            .andExpect(jsonPath("$.aguaDeCocoVerde").value(DEFAULT_AGUA_DE_COCO_VERDE.doubleValue()))
            .andExpect(jsonPath("$.caixaPadrao").value(DEFAULT_CAIXA_PADRAO.doubleValue()))
            .andExpect(jsonPath("$.porcentagemCocoGerminado").value(DEFAULT_PORCENTAGEM_COCO_GERMINADO.doubleValue()))
            .andExpect(jsonPath("$.totalDeCacambas").value(DEFAULT_TOTAL_DE_CACAMBAS.doubleValue()))
            .andExpect(jsonPath("$.numeroDeFardos").value(DEFAULT_NUMERO_DE_FARDOS.doubleValue()))
            .andExpect(jsonPath("$.diaLancamento").value(DEFAULT_DIA_LANCAMENTO.toString()))
            .andExpect(jsonPath("$.mesLancamento").value(DEFAULT_MES_LANCAMENTO.toString()))
            .andExpect(jsonPath("$.anoLancamento").value(DEFAULT_ANO_LANCAMENTO.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingResumoDiario() throws Exception {
        // Get the resumoDiario
        restResumoDiarioMockMvc.perform(get("/api/resumo-diarios/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateResumoDiario() throws Exception {
        // Initialize the database
        resumoDiarioRepository.saveAndFlush(resumoDiario);

        int databaseSizeBeforeUpdate = resumoDiarioRepository.findAll().size();

        // Update the resumoDiario
        ResumoDiario updatedResumoDiario = resumoDiarioRepository.findById(resumoDiario.getId()).get();
        // Disconnect from session so that the updates on updatedResumoDiario are not directly saved in db
        em.detach(updatedResumoDiario);
        updatedResumoDiario
            .dataLancamento(UPDATED_DATA_LANCAMENTO)
            .cocosProcessados(UPDATED_COCOS_PROCESSADOS)
            .cocosDesfibrados(UPDATED_COCOS_DESFIBRADOS)
            .cri(UPDATED_CRI)
            .flococo(UPDATED_FLOCOCO)
            .oleoIndustrialTipoA(UPDATED_OLEO_INDUSTRIAL_TIPO_A)
            .oleoIndustrialETE(UPDATED_OLEO_INDUSTRIAL_ETE)
            .torta(UPDATED_TORTA)
            .aguaDeCocoSococo(UPDATED_AGUA_DE_COCO_SOCOCO)
            .aguaDeCocoVerde(UPDATED_AGUA_DE_COCO_VERDE)
            .caixaPadrao(UPDATED_CAIXA_PADRAO)
            .porcentagemCocoGerminado(UPDATED_PORCENTAGEM_COCO_GERMINADO)
            .totalDeCacambas(UPDATED_TOTAL_DE_CACAMBAS)
            .numeroDeFardos(UPDATED_NUMERO_DE_FARDOS)
            .diaLancamento(UPDATED_DIA_LANCAMENTO)
            .mesLancamento(UPDATED_MES_LANCAMENTO)
            .anoLancamento(UPDATED_ANO_LANCAMENTO);
        ResumoDiarioDTO resumoDiarioDTO = resumoDiarioMapper.toDto(updatedResumoDiario);

        restResumoDiarioMockMvc.perform(put("/api/resumo-diarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(resumoDiarioDTO)))
            .andExpect(status().isOk());

        // Validate the ResumoDiario in the database
        List<ResumoDiario> resumoDiarioList = resumoDiarioRepository.findAll();
        assertThat(resumoDiarioList).hasSize(databaseSizeBeforeUpdate);
        ResumoDiario testResumoDiario = resumoDiarioList.get(resumoDiarioList.size() - 1);
        assertThat(testResumoDiario.getDataLancamento()).isEqualTo(UPDATED_DATA_LANCAMENTO);
        assertThat(testResumoDiario.getCocosProcessados()).isEqualTo(UPDATED_COCOS_PROCESSADOS);
        assertThat(testResumoDiario.getCocosDesfibrados()).isEqualTo(UPDATED_COCOS_DESFIBRADOS);
        assertThat(testResumoDiario.getCri()).isEqualTo(UPDATED_CRI);
        assertThat(testResumoDiario.getFlococo()).isEqualTo(UPDATED_FLOCOCO);
        assertThat(testResumoDiario.getOleoIndustrialTipoA()).isEqualTo(UPDATED_OLEO_INDUSTRIAL_TIPO_A);
        assertThat(testResumoDiario.getOleoIndustrialETE()).isEqualTo(UPDATED_OLEO_INDUSTRIAL_ETE);
        assertThat(testResumoDiario.getTorta()).isEqualTo(UPDATED_TORTA);
        assertThat(testResumoDiario.getAguaDeCocoSococo()).isEqualTo(UPDATED_AGUA_DE_COCO_SOCOCO);
        assertThat(testResumoDiario.getAguaDeCocoVerde()).isEqualTo(UPDATED_AGUA_DE_COCO_VERDE);
        assertThat(testResumoDiario.getCaixaPadrao()).isEqualTo(UPDATED_CAIXA_PADRAO);
        assertThat(testResumoDiario.getPorcentagemCocoGerminado()).isEqualTo(UPDATED_PORCENTAGEM_COCO_GERMINADO);
        assertThat(testResumoDiario.getTotalDeCacambas()).isEqualTo(UPDATED_TOTAL_DE_CACAMBAS);
        assertThat(testResumoDiario.getNumeroDeFardos()).isEqualTo(UPDATED_NUMERO_DE_FARDOS);
        assertThat(testResumoDiario.getDiaLancamento()).isEqualTo(UPDATED_DIA_LANCAMENTO);
        assertThat(testResumoDiario.getMesLancamento()).isEqualTo(UPDATED_MES_LANCAMENTO);
        assertThat(testResumoDiario.getAnoLancamento()).isEqualTo(UPDATED_ANO_LANCAMENTO);
    }

    @Test
    @Transactional
    public void updateNonExistingResumoDiario() throws Exception {
        int databaseSizeBeforeUpdate = resumoDiarioRepository.findAll().size();

        // Create the ResumoDiario
        ResumoDiarioDTO resumoDiarioDTO = resumoDiarioMapper.toDto(resumoDiario);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResumoDiarioMockMvc.perform(put("/api/resumo-diarios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(resumoDiarioDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ResumoDiario in the database
        List<ResumoDiario> resumoDiarioList = resumoDiarioRepository.findAll();
        assertThat(resumoDiarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteResumoDiario() throws Exception {
        // Initialize the database
        resumoDiarioRepository.saveAndFlush(resumoDiario);

        int databaseSizeBeforeDelete = resumoDiarioRepository.findAll().size();

        // Get the resumoDiario
        restResumoDiarioMockMvc.perform(delete("/api/resumo-diarios/{id}", resumoDiario.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ResumoDiario> resumoDiarioList = resumoDiarioRepository.findAll();
        assertThat(resumoDiarioList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResumoDiario.class);
        ResumoDiario resumoDiario1 = new ResumoDiario();
        resumoDiario1.setId(1L);
        ResumoDiario resumoDiario2 = new ResumoDiario();
        resumoDiario2.setId(resumoDiario1.getId());
        assertThat(resumoDiario1).isEqualTo(resumoDiario2);
        resumoDiario2.setId(2L);
        assertThat(resumoDiario1).isNotEqualTo(resumoDiario2);
        resumoDiario1.setId(null);
        assertThat(resumoDiario1).isNotEqualTo(resumoDiario2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResumoDiarioDTO.class);
        ResumoDiarioDTO resumoDiarioDTO1 = new ResumoDiarioDTO();
        resumoDiarioDTO1.setId(1L);
        ResumoDiarioDTO resumoDiarioDTO2 = new ResumoDiarioDTO();
        assertThat(resumoDiarioDTO1).isNotEqualTo(resumoDiarioDTO2);
        resumoDiarioDTO2.setId(resumoDiarioDTO1.getId());
        assertThat(resumoDiarioDTO1).isEqualTo(resumoDiarioDTO2);
        resumoDiarioDTO2.setId(2L);
        assertThat(resumoDiarioDTO1).isNotEqualTo(resumoDiarioDTO2);
        resumoDiarioDTO1.setId(null);
        assertThat(resumoDiarioDTO1).isNotEqualTo(resumoDiarioDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(resumoDiarioMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(resumoDiarioMapper.fromId(null)).isNull();
    }
}
