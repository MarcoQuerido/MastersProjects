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
import org.trebol.domain.BillingCompany;
import org.trebol.repository.BillingCompanyRepository;
import org.trebol.service.dto.BillingCompanyDTO;
import org.trebol.service.mapper.BillingCompanyMapper;

/**
 * Integration tests for the {@link BillingCompanyResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class BillingCompanyResourceIT {

    private static final String DEFAULT_ID_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_ID_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/billing-companies";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private BillingCompanyRepository billingCompanyRepository;

    @Autowired
    private BillingCompanyMapper billingCompanyMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBillingCompanyMockMvc;

    private BillingCompany billingCompany;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BillingCompany createEntity(EntityManager em) {
        BillingCompany billingCompany = new BillingCompany().idNumber(DEFAULT_ID_NUMBER).name(DEFAULT_NAME);
        return billingCompany;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BillingCompany createUpdatedEntity(EntityManager em) {
        BillingCompany billingCompany = new BillingCompany().idNumber(UPDATED_ID_NUMBER).name(UPDATED_NAME);
        return billingCompany;
    }

    @BeforeEach
    public void initTest() {
        billingCompany = createEntity(em);
    }

    @Test
    @Transactional
    void createBillingCompany() throws Exception {
        int databaseSizeBeforeCreate = billingCompanyRepository.findAll().size();
        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);
        restBillingCompanyMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isCreated());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeCreate + 1);
        BillingCompany testBillingCompany = billingCompanyList.get(billingCompanyList.size() - 1);
        assertThat(testBillingCompany.getIdNumber()).isEqualTo(DEFAULT_ID_NUMBER);
        assertThat(testBillingCompany.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    void createBillingCompanyWithExistingId() throws Exception {
        // Create the BillingCompany with an existing ID
        billingCompany.setId(1L);
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        int databaseSizeBeforeCreate = billingCompanyRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restBillingCompanyMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkIdNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = billingCompanyRepository.findAll().size();
        // set the field null
        billingCompany.setIdNumber(null);

        // Create the BillingCompany, which fails.
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        restBillingCompanyMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = billingCompanyRepository.findAll().size();
        // set the field null
        billingCompany.setName(null);

        // Create the BillingCompany, which fails.
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        restBillingCompanyMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllBillingCompanies() throws Exception {
        // Initialize the database
        billingCompanyRepository.saveAndFlush(billingCompany);

        // Get all the billingCompanyList
        restBillingCompanyMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(billingCompany.getId().intValue())))
            .andExpect(jsonPath("$.[*].idNumber").value(hasItem(DEFAULT_ID_NUMBER)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }

    @Test
    @Transactional
    void getBillingCompany() throws Exception {
        // Initialize the database
        billingCompanyRepository.saveAndFlush(billingCompany);

        // Get the billingCompany
        restBillingCompanyMockMvc
            .perform(get(ENTITY_API_URL_ID, billingCompany.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(billingCompany.getId().intValue()))
            .andExpect(jsonPath("$.idNumber").value(DEFAULT_ID_NUMBER))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    void getNonExistingBillingCompany() throws Exception {
        // Get the billingCompany
        restBillingCompanyMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingBillingCompany() throws Exception {
        // Initialize the database
        billingCompanyRepository.saveAndFlush(billingCompany);

        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();

        // Update the billingCompany
        BillingCompany updatedBillingCompany = billingCompanyRepository.findById(billingCompany.getId()).get();
        // Disconnect from session so that the updates on updatedBillingCompany are not directly saved in db
        em.detach(updatedBillingCompany);
        updatedBillingCompany.idNumber(UPDATED_ID_NUMBER).name(UPDATED_NAME);
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(updatedBillingCompany);

        restBillingCompanyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, billingCompanyDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isOk());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
        BillingCompany testBillingCompany = billingCompanyList.get(billingCompanyList.size() - 1);
        assertThat(testBillingCompany.getIdNumber()).isEqualTo(UPDATED_ID_NUMBER);
        assertThat(testBillingCompany.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void putNonExistingBillingCompany() throws Exception {
        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();
        billingCompany.setId(count.incrementAndGet());

        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBillingCompanyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, billingCompanyDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchBillingCompany() throws Exception {
        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();
        billingCompany.setId(count.incrementAndGet());

        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingCompanyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamBillingCompany() throws Exception {
        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();
        billingCompany.setId(count.incrementAndGet());

        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingCompanyMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateBillingCompanyWithPatch() throws Exception {
        // Initialize the database
        billingCompanyRepository.saveAndFlush(billingCompany);

        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();

        // Update the billingCompany using partial update
        BillingCompany partialUpdatedBillingCompany = new BillingCompany();
        partialUpdatedBillingCompany.setId(billingCompany.getId());

        partialUpdatedBillingCompany.idNumber(UPDATED_ID_NUMBER).name(UPDATED_NAME);

        restBillingCompanyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBillingCompany.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedBillingCompany))
            )
            .andExpect(status().isOk());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
        BillingCompany testBillingCompany = billingCompanyList.get(billingCompanyList.size() - 1);
        assertThat(testBillingCompany.getIdNumber()).isEqualTo(UPDATED_ID_NUMBER);
        assertThat(testBillingCompany.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void fullUpdateBillingCompanyWithPatch() throws Exception {
        // Initialize the database
        billingCompanyRepository.saveAndFlush(billingCompany);

        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();

        // Update the billingCompany using partial update
        BillingCompany partialUpdatedBillingCompany = new BillingCompany();
        partialUpdatedBillingCompany.setId(billingCompany.getId());

        partialUpdatedBillingCompany.idNumber(UPDATED_ID_NUMBER).name(UPDATED_NAME);

        restBillingCompanyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBillingCompany.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedBillingCompany))
            )
            .andExpect(status().isOk());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
        BillingCompany testBillingCompany = billingCompanyList.get(billingCompanyList.size() - 1);
        assertThat(testBillingCompany.getIdNumber()).isEqualTo(UPDATED_ID_NUMBER);
        assertThat(testBillingCompany.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void patchNonExistingBillingCompany() throws Exception {
        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();
        billingCompany.setId(count.incrementAndGet());

        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBillingCompanyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, billingCompanyDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchBillingCompany() throws Exception {
        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();
        billingCompany.setId(count.incrementAndGet());

        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingCompanyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamBillingCompany() throws Exception {
        int databaseSizeBeforeUpdate = billingCompanyRepository.findAll().size();
        billingCompany.setId(count.incrementAndGet());

        // Create the BillingCompany
        BillingCompanyDTO billingCompanyDTO = billingCompanyMapper.toDto(billingCompany);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBillingCompanyMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(billingCompanyDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BillingCompany in the database
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteBillingCompany() throws Exception {
        // Initialize the database
        billingCompanyRepository.saveAndFlush(billingCompany);

        int databaseSizeBeforeDelete = billingCompanyRepository.findAll().size();

        // Delete the billingCompany
        restBillingCompanyMockMvc
            .perform(delete(ENTITY_API_URL_ID, billingCompany.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BillingCompany> billingCompanyList = billingCompanyRepository.findAll();
        assertThat(billingCompanyList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
