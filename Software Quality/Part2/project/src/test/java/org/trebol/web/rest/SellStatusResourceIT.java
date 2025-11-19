package org.trebol.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.trebol.IntegrationTest;
import org.trebol.domain.SellStatus;
import org.trebol.repository.SellStatusRepository;
import org.trebol.service.dto.SellStatusDTO;
import org.trebol.service.mapper.SellStatusMapper;

/**
 * Integration tests for the {@link SellStatusResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SellStatusResourceIT {

    private static final Integer DEFAULT_CODE = 1;
    private static final Integer UPDATED_CODE = 2;

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/sell-statuses";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SellStatusRepository sellStatusRepository;

    @Autowired
    private SellStatusMapper sellStatusMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSellStatusMockMvc;

    private SellStatus sellStatus;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SellStatus createEntity(EntityManager em) {
        SellStatus sellStatus = new SellStatus().code(DEFAULT_CODE).name(DEFAULT_NAME);
        return sellStatus;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SellStatus createUpdatedEntity(EntityManager em) {
        SellStatus sellStatus = new SellStatus().code(UPDATED_CODE).name(UPDATED_NAME);
        return sellStatus;
    }

    @BeforeEach
    public void initTest() {
        sellStatus = createEntity(em);
    }

    @Test
    @Transactional
    void createSellStatus() throws Exception {
        int databaseSizeBeforeCreate = sellStatusRepository.findAll().size();
        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);
        restSellStatusMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellStatusDTO)))
            .andExpect(status().isCreated());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeCreate + 1);
        SellStatus testSellStatus = sellStatusList.get(sellStatusList.size() - 1);
        assertThat(testSellStatus.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testSellStatus.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    void createSellStatusWithExistingId() throws Exception {
        // Create the SellStatus with an existing ID
        sellStatus.setId(1L);
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        int databaseSizeBeforeCreate = sellStatusRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSellStatusMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellStatusDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellStatusRepository.findAll().size();
        // set the field null
        sellStatus.setCode(null);

        // Create the SellStatus, which fails.
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        restSellStatusMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellStatusDTO)))
            .andExpect(status().isBadRequest());

        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellStatusRepository.findAll().size();
        // set the field null
        sellStatus.setName(null);

        // Create the SellStatus, which fails.
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        restSellStatusMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellStatusDTO)))
            .andExpect(status().isBadRequest());

        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllSellStatuses() throws Exception {
        // Initialize the database
        sellStatusRepository.saveAndFlush(sellStatus);

        // Get all the sellStatusList
        restSellStatusMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sellStatus.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }

    @Test
    @Transactional
    void getSellStatus() throws Exception {
        // Initialize the database
        sellStatusRepository.saveAndFlush(sellStatus);

        // Get the sellStatus
        restSellStatusMockMvc
            .perform(get(ENTITY_API_URL_ID, sellStatus.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sellStatus.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    void getNonExistingSellStatus() throws Exception {
        // Get the sellStatus
        restSellStatusMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSellStatus() throws Exception {
        // Initialize the database
        sellStatusRepository.saveAndFlush(sellStatus);

        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();

        // Update the sellStatus
        SellStatus updatedSellStatus = sellStatusRepository.findById(sellStatus.getId()).get();
        // Disconnect from session so that the updates on updatedSellStatus are not directly saved in db
        em.detach(updatedSellStatus);
        updatedSellStatus.code(UPDATED_CODE).name(UPDATED_NAME);
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(updatedSellStatus);

        restSellStatusMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sellStatusDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellStatusDTO))
            )
            .andExpect(status().isOk());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
        SellStatus testSellStatus = sellStatusList.get(sellStatusList.size() - 1);
        assertThat(testSellStatus.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testSellStatus.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void putNonExistingSellStatus() throws Exception {
        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();
        sellStatus.setId(count.incrementAndGet());

        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSellStatusMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sellStatusDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellStatusDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSellStatus() throws Exception {
        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();
        sellStatus.setId(count.incrementAndGet());

        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellStatusMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellStatusDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSellStatus() throws Exception {
        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();
        sellStatus.setId(count.incrementAndGet());

        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellStatusMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellStatusDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSellStatusWithPatch() throws Exception {
        // Initialize the database
        sellStatusRepository.saveAndFlush(sellStatus);

        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();

        // Update the sellStatus using partial update
        SellStatus partialUpdatedSellStatus = new SellStatus();
        partialUpdatedSellStatus.setId(sellStatus.getId());

        partialUpdatedSellStatus.name(UPDATED_NAME);

        restSellStatusMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSellStatus.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSellStatus))
            )
            .andExpect(status().isOk());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
        SellStatus testSellStatus = sellStatusList.get(sellStatusList.size() - 1);
        assertThat(testSellStatus.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testSellStatus.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void fullUpdateSellStatusWithPatch() throws Exception {
        // Initialize the database
        sellStatusRepository.saveAndFlush(sellStatus);

        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();

        // Update the sellStatus using partial update
        SellStatus partialUpdatedSellStatus = new SellStatus();
        partialUpdatedSellStatus.setId(sellStatus.getId());

        partialUpdatedSellStatus.code(UPDATED_CODE).name(UPDATED_NAME);

        restSellStatusMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSellStatus.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSellStatus))
            )
            .andExpect(status().isOk());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
        SellStatus testSellStatus = sellStatusList.get(sellStatusList.size() - 1);
        assertThat(testSellStatus.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testSellStatus.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void patchNonExistingSellStatus() throws Exception {
        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();
        sellStatus.setId(count.incrementAndGet());

        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSellStatusMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, sellStatusDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(sellStatusDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSellStatus() throws Exception {
        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();
        sellStatus.setId(count.incrementAndGet());

        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellStatusMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(sellStatusDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSellStatus() throws Exception {
        int databaseSizeBeforeUpdate = sellStatusRepository.findAll().size();
        sellStatus.setId(count.incrementAndGet());

        // Create the SellStatus
        SellStatusDTO sellStatusDTO = sellStatusMapper.toDto(sellStatus);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellStatusMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(sellStatusDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the SellStatus in the database
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSellStatus() throws Exception {
        // Initialize the database
        sellStatusRepository.saveAndFlush(sellStatus);

        int databaseSizeBeforeDelete = sellStatusRepository.findAll().size();

        // Delete the sellStatus
        restSellStatusMockMvc
            .perform(delete(ENTITY_API_URL_ID, sellStatus.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SellStatus> sellStatusList = sellStatusRepository.findAll();
        assertThat(sellStatusList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
