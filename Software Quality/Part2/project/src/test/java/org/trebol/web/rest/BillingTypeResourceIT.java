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
import org.trebol.domain.BillingType;
import org.trebol.repository.BillingTypeRepository;
import org.trebol.service.dto.BillingTypeDTO;
import org.trebol.service.mapper.BillingTypeMapper;

/**
 * Integration tests for the {@link BillingTypeResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class BillingTypeResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/billing-types";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private BillingTypeRepository billingTypeRepository;

    @Autowired
    private BillingTypeMapper billingTypeMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBillingTypeMockMvc;

    private BillingType billingType;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BillingType createEntity(EntityManager em) {
        BillingType billingType = new BillingType().name(DEFAULT_NAME);
        return billingType;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BillingType createUpdatedEntity(EntityManager em) {
        BillingType billingType = new BillingType().name(UPDATED_NAME);
        return billingType;
    }

    @BeforeEach
    public void initTest() {
        billingType = createEntity(em);
    }

    @Test
    @Transactional
    void createBillingType() throws Exception {
        int databaseSizeBeforeCreate = billingTypeRepository.findAll().size();
        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);
        restBillingTypeMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isCreated());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeCreate + 1);
        BillingType testBillingType = billingTypeList.get(billingTypeList.size() - 1);
        assertThat(testBillingType.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    void createBillingTypeWithExistingId() throws Exception {
        // Create the BillingType with an existing ID
        billingType.setId(1L);
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        int databaseSizeBeforeCreate = billingTypeRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restBillingTypeMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = billingTypeRepository.findAll().size();
        // set the field null
        billingType.setName(null);

        // Create the BillingType, which fails.
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        restBillingTypeMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isBadRequest());

        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllBillingTypes() throws Exception {
        // Initialize the database
        billingTypeRepository.saveAndFlush(billingType);

        // Get all the billingTypeList
        restBillingTypeMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(billingType.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }

    @Test
    @Transactional
    void getBillingType() throws Exception {
        // Initialize the database
        billingTypeRepository.saveAndFlush(billingType);

        // Get the billingType
        restBillingTypeMockMvc
            .perform(get(ENTITY_API_URL_ID, billingType.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(billingType.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    void getNonExistingBillingType() throws Exception {
        // Get the billingType
        restBillingTypeMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingBillingType() throws Exception {
        // Initialize the database
        billingTypeRepository.saveAndFlush(billingType);

        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();

        // Update the billingType
        BillingType updatedBillingType = billingTypeRepository.findById(billingType.getId()).get();
        // Disconnect from session so that the updates on updatedBillingType are not directly saved in db
        em.detach(updatedBillingType);
        updatedBillingType.name(UPDATED_NAME);
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(updatedBillingType);

        restBillingTypeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, billingTypeDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isOk());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
        BillingType testBillingType = billingTypeList.get(billingTypeList.size() - 1);
        assertThat(testBillingType.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void putNonExistingBillingType() throws Exception {
        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();
        billingType.setId(count.incrementAndGet());

        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBillingTypeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, billingTypeDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchBillingType() throws Exception {
        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();
        billingType.setId(count.incrementAndGet());

        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingTypeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamBillingType() throws Exception {
        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();
        billingType.setId(count.incrementAndGet());

        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingTypeMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingTypeDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateBillingTypeWithPatch() throws Exception {
        // Initialize the database
        billingTypeRepository.saveAndFlush(billingType);

        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();

        // Update the billingType using partial update
        BillingType partialUpdatedBillingType = new BillingType();
        partialUpdatedBillingType.setId(billingType.getId());

        restBillingTypeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBillingType.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedBillingType))
            )
            .andExpect(status().isOk());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
        BillingType testBillingType = billingTypeList.get(billingTypeList.size() - 1);
        assertThat(testBillingType.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    void fullUpdateBillingTypeWithPatch() throws Exception {
        // Initialize the database
        billingTypeRepository.saveAndFlush(billingType);

        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();

        // Update the billingType using partial update
        BillingType partialUpdatedBillingType = new BillingType();
        partialUpdatedBillingType.setId(billingType.getId());

        partialUpdatedBillingType.name(UPDATED_NAME);

        restBillingTypeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBillingType.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedBillingType))
            )
            .andExpect(status().isOk());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
        BillingType testBillingType = billingTypeList.get(billingTypeList.size() - 1);
        assertThat(testBillingType.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void patchNonExistingBillingType() throws Exception {
        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();
        billingType.setId(count.incrementAndGet());

        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBillingTypeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, billingTypeDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchBillingType() throws Exception {
        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();
        billingType.setId(count.incrementAndGet());

        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingTypeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamBillingType() throws Exception {
        int databaseSizeBeforeUpdate = billingTypeRepository.findAll().size();
        billingType.setId(count.incrementAndGet());

        // Create the BillingType
        BillingTypeDTO billingTypeDTO = billingTypeMapper.toDto(billingType);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingTypeMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(billingTypeDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BillingType in the database
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteBillingType() throws Exception {
        // Initialize the database
        billingTypeRepository.saveAndFlush(billingType);

        int databaseSizeBeforeDelete = billingTypeRepository.findAll().size();

        // Delete the billingType
        restBillingTypeMockMvc
            .perform(delete(ENTITY_API_URL_ID, billingType.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BillingType> billingTypeList = billingTypeRepository.findAll();
        assertThat(billingTypeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
