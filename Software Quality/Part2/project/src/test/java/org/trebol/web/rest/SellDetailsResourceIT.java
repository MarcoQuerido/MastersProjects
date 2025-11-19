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
import org.trebol.domain.Product;
import org.trebol.domain.Sell;
import org.trebol.domain.SellDetails;
import org.trebol.repository.SellDetailsRepository;
import org.trebol.service.dto.SellDetailsDTO;
import org.trebol.service.mapper.SellDetailsMapper;

/**
 * Integration tests for the {@link SellDetailsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SellDetailsResourceIT {

    private static final Integer DEFAULT_UNITS = 1;
    private static final Integer UPDATED_UNITS = 2;

    private static final Integer DEFAULT_UNIT_VALUE = 1;
    private static final Integer UPDATED_UNIT_VALUE = 2;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/sell-details";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SellDetailsRepository sellDetailsRepository;

    @Autowired
    private SellDetailsMapper sellDetailsMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSellDetailsMockMvc;

    private SellDetails sellDetails;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SellDetails createEntity(EntityManager em) {
        SellDetails sellDetails = new SellDetails().units(DEFAULT_UNITS).unitValue(DEFAULT_UNIT_VALUE).description(DEFAULT_DESCRIPTION);
        // Add required entity
        Product product;
        if (TestUtil.findAll(em, Product.class).isEmpty()) {
            product = ProductResourceIT.createEntity(em);
            em.persist(product);
            em.flush();
        } else {
            product = TestUtil.findAll(em, Product.class).get(0);
        }
        sellDetails.setProduct(product);
        // Add required entity
        Sell sell;
        if (TestUtil.findAll(em, Sell.class).isEmpty()) {
            sell = SellResourceIT.createEntity(em);
            em.persist(sell);
            em.flush();
        } else {
            sell = TestUtil.findAll(em, Sell.class).get(0);
        }
        sellDetails.setSell(sell);
        return sellDetails;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SellDetails createUpdatedEntity(EntityManager em) {
        SellDetails sellDetails = new SellDetails().units(UPDATED_UNITS).unitValue(UPDATED_UNIT_VALUE).description(UPDATED_DESCRIPTION);
        // Add required entity
        Product product;
        if (TestUtil.findAll(em, Product.class).isEmpty()) {
            product = ProductResourceIT.createUpdatedEntity(em);
            em.persist(product);
            em.flush();
        } else {
            product = TestUtil.findAll(em, Product.class).get(0);
        }
        sellDetails.setProduct(product);
        // Add required entity
        Sell sell;
        if (TestUtil.findAll(em, Sell.class).isEmpty()) {
            sell = SellResourceIT.createUpdatedEntity(em);
            em.persist(sell);
            em.flush();
        } else {
            sell = TestUtil.findAll(em, Sell.class).get(0);
        }
        sellDetails.setSell(sell);
        return sellDetails;
    }

    @BeforeEach
    public void initTest() {
        sellDetails = createEntity(em);
    }

    @Test
    @Transactional
    void createSellDetails() throws Exception {
        int databaseSizeBeforeCreate = sellDetailsRepository.findAll().size();
        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);
        restSellDetailsMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isCreated());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        SellDetails testSellDetails = sellDetailsList.get(sellDetailsList.size() - 1);
        assertThat(testSellDetails.getUnits()).isEqualTo(DEFAULT_UNITS);
        assertThat(testSellDetails.getUnitValue()).isEqualTo(DEFAULT_UNIT_VALUE);
        assertThat(testSellDetails.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    @Transactional
    void createSellDetailsWithExistingId() throws Exception {
        // Create the SellDetails with an existing ID
        sellDetails.setId(1L);
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        int databaseSizeBeforeCreate = sellDetailsRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSellDetailsMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUnitsIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellDetailsRepository.findAll().size();
        // set the field null
        sellDetails.setUnits(null);

        // Create the SellDetails, which fails.
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        restSellDetailsMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUnitValueIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellDetailsRepository.findAll().size();
        // set the field null
        sellDetails.setUnitValue(null);

        // Create the SellDetails, which fails.
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        restSellDetailsMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDescriptionIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellDetailsRepository.findAll().size();
        // set the field null
        sellDetails.setDescription(null);

        // Create the SellDetails, which fails.
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        restSellDetailsMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllSellDetails() throws Exception {
        // Initialize the database
        sellDetailsRepository.saveAndFlush(sellDetails);

        // Get all the sellDetailsList
        restSellDetailsMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sellDetails.getId().intValue())))
            .andExpect(jsonPath("$.[*].units").value(hasItem(DEFAULT_UNITS)))
            .andExpect(jsonPath("$.[*].unitValue").value(hasItem(DEFAULT_UNIT_VALUE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));
    }

    @Test
    @Transactional
    void getSellDetails() throws Exception {
        // Initialize the database
        sellDetailsRepository.saveAndFlush(sellDetails);

        // Get the sellDetails
        restSellDetailsMockMvc
            .perform(get(ENTITY_API_URL_ID, sellDetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sellDetails.getId().intValue()))
            .andExpect(jsonPath("$.units").value(DEFAULT_UNITS))
            .andExpect(jsonPath("$.unitValue").value(DEFAULT_UNIT_VALUE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION));
    }

    @Test
    @Transactional
    void getNonExistingSellDetails() throws Exception {
        // Get the sellDetails
        restSellDetailsMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSellDetails() throws Exception {
        // Initialize the database
        sellDetailsRepository.saveAndFlush(sellDetails);

        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();

        // Update the sellDetails
        SellDetails updatedSellDetails = sellDetailsRepository.findById(sellDetails.getId()).get();
        // Disconnect from session so that the updates on updatedSellDetails are not directly saved in db
        em.detach(updatedSellDetails);
        updatedSellDetails.units(UPDATED_UNITS).unitValue(UPDATED_UNIT_VALUE).description(UPDATED_DESCRIPTION);
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(updatedSellDetails);

        restSellDetailsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sellDetailsDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isOk());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
        SellDetails testSellDetails = sellDetailsList.get(sellDetailsList.size() - 1);
        assertThat(testSellDetails.getUnits()).isEqualTo(UPDATED_UNITS);
        assertThat(testSellDetails.getUnitValue()).isEqualTo(UPDATED_UNIT_VALUE);
        assertThat(testSellDetails.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void putNonExistingSellDetails() throws Exception {
        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();
        sellDetails.setId(count.incrementAndGet());

        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSellDetailsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sellDetailsDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSellDetails() throws Exception {
        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();
        sellDetails.setId(count.incrementAndGet());

        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellDetailsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSellDetails() throws Exception {
        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();
        sellDetails.setId(count.incrementAndGet());

        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellDetailsMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSellDetailsWithPatch() throws Exception {
        // Initialize the database
        sellDetailsRepository.saveAndFlush(sellDetails);

        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();

        // Update the sellDetails using partial update
        SellDetails partialUpdatedSellDetails = new SellDetails();
        partialUpdatedSellDetails.setId(sellDetails.getId());

        partialUpdatedSellDetails.units(UPDATED_UNITS).description(UPDATED_DESCRIPTION);

        restSellDetailsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSellDetails.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSellDetails))
            )
            .andExpect(status().isOk());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
        SellDetails testSellDetails = sellDetailsList.get(sellDetailsList.size() - 1);
        assertThat(testSellDetails.getUnits()).isEqualTo(UPDATED_UNITS);
        assertThat(testSellDetails.getUnitValue()).isEqualTo(DEFAULT_UNIT_VALUE);
        assertThat(testSellDetails.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void fullUpdateSellDetailsWithPatch() throws Exception {
        // Initialize the database
        sellDetailsRepository.saveAndFlush(sellDetails);

        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();

        // Update the sellDetails using partial update
        SellDetails partialUpdatedSellDetails = new SellDetails();
        partialUpdatedSellDetails.setId(sellDetails.getId());

        partialUpdatedSellDetails.units(UPDATED_UNITS).unitValue(UPDATED_UNIT_VALUE).description(UPDATED_DESCRIPTION);

        restSellDetailsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSellDetails.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSellDetails))
            )
            .andExpect(status().isOk());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
        SellDetails testSellDetails = sellDetailsList.get(sellDetailsList.size() - 1);
        assertThat(testSellDetails.getUnits()).isEqualTo(UPDATED_UNITS);
        assertThat(testSellDetails.getUnitValue()).isEqualTo(UPDATED_UNIT_VALUE);
        assertThat(testSellDetails.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void patchNonExistingSellDetails() throws Exception {
        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();
        sellDetails.setId(count.incrementAndGet());

        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSellDetailsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, sellDetailsDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSellDetails() throws Exception {
        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();
        sellDetails.setId(count.incrementAndGet());

        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellDetailsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSellDetails() throws Exception {
        int databaseSizeBeforeUpdate = sellDetailsRepository.findAll().size();
        sellDetails.setId(count.incrementAndGet());

        // Create the SellDetails
        SellDetailsDTO sellDetailsDTO = sellDetailsMapper.toDto(sellDetails);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellDetailsMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(sellDetailsDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the SellDetails in the database
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSellDetails() throws Exception {
        // Initialize the database
        sellDetailsRepository.saveAndFlush(sellDetails);

        int databaseSizeBeforeDelete = sellDetailsRepository.findAll().size();

        // Delete the sellDetails
        restSellDetailsMockMvc
            .perform(delete(ENTITY_API_URL_ID, sellDetails.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SellDetails> sellDetailsList = sellDetailsRepository.findAll();
        assertThat(sellDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
