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
import org.trebol.domain.Shipper;
import org.trebol.repository.ShipperRepository;
import org.trebol.service.dto.ShipperDTO;
import org.trebol.service.mapper.ShipperMapper;

/**
 * Integration tests for the {@link ShipperResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ShipperResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/shippers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private ShipperMapper shipperMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restShipperMockMvc;

    private Shipper shipper;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Shipper createEntity(EntityManager em) {
        Shipper shipper = new Shipper().name(DEFAULT_NAME);
        return shipper;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Shipper createUpdatedEntity(EntityManager em) {
        Shipper shipper = new Shipper().name(UPDATED_NAME);
        return shipper;
    }

    @BeforeEach
    public void initTest() {
        shipper = createEntity(em);
    }

    @Test
    @Transactional
    void createShipper() throws Exception {
        int databaseSizeBeforeCreate = shipperRepository.findAll().size();
        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);
        restShipperMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(shipperDTO)))
            .andExpect(status().isCreated());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeCreate + 1);
        Shipper testShipper = shipperList.get(shipperList.size() - 1);
        assertThat(testShipper.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    void createShipperWithExistingId() throws Exception {
        // Create the Shipper with an existing ID
        shipper.setId(1L);
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        int databaseSizeBeforeCreate = shipperRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restShipperMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(shipperDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = shipperRepository.findAll().size();
        // set the field null
        shipper.setName(null);

        // Create the Shipper, which fails.
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        restShipperMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(shipperDTO)))
            .andExpect(status().isBadRequest());

        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllShippers() throws Exception {
        // Initialize the database
        shipperRepository.saveAndFlush(shipper);

        // Get all the shipperList
        restShipperMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(shipper.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }

    @Test
    @Transactional
    void getShipper() throws Exception {
        // Initialize the database
        shipperRepository.saveAndFlush(shipper);

        // Get the shipper
        restShipperMockMvc
            .perform(get(ENTITY_API_URL_ID, shipper.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(shipper.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    void getNonExistingShipper() throws Exception {
        // Get the shipper
        restShipperMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingShipper() throws Exception {
        // Initialize the database
        shipperRepository.saveAndFlush(shipper);

        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();

        // Update the shipper
        Shipper updatedShipper = shipperRepository.findById(shipper.getId()).get();
        // Disconnect from session so that the updates on updatedShipper are not directly saved in db
        em.detach(updatedShipper);
        updatedShipper.name(UPDATED_NAME);
        ShipperDTO shipperDTO = shipperMapper.toDto(updatedShipper);

        restShipperMockMvc
            .perform(
                put(ENTITY_API_URL_ID, shipperDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(shipperDTO))
            )
            .andExpect(status().isOk());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
        Shipper testShipper = shipperList.get(shipperList.size() - 1);
        assertThat(testShipper.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void putNonExistingShipper() throws Exception {
        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();
        shipper.setId(count.incrementAndGet());

        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restShipperMockMvc
            .perform(
                put(ENTITY_API_URL_ID, shipperDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(shipperDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchShipper() throws Exception {
        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();
        shipper.setId(count.incrementAndGet());

        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restShipperMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(shipperDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamShipper() throws Exception {
        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();
        shipper.setId(count.incrementAndGet());

        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restShipperMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(shipperDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateShipperWithPatch() throws Exception {
        // Initialize the database
        shipperRepository.saveAndFlush(shipper);

        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();

        // Update the shipper using partial update
        Shipper partialUpdatedShipper = new Shipper();
        partialUpdatedShipper.setId(shipper.getId());

        restShipperMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedShipper.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedShipper))
            )
            .andExpect(status().isOk());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
        Shipper testShipper = shipperList.get(shipperList.size() - 1);
        assertThat(testShipper.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    void fullUpdateShipperWithPatch() throws Exception {
        // Initialize the database
        shipperRepository.saveAndFlush(shipper);

        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();

        // Update the shipper using partial update
        Shipper partialUpdatedShipper = new Shipper();
        partialUpdatedShipper.setId(shipper.getId());

        partialUpdatedShipper.name(UPDATED_NAME);

        restShipperMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedShipper.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedShipper))
            )
            .andExpect(status().isOk());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
        Shipper testShipper = shipperList.get(shipperList.size() - 1);
        assertThat(testShipper.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    void patchNonExistingShipper() throws Exception {
        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();
        shipper.setId(count.incrementAndGet());

        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restShipperMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, shipperDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(shipperDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchShipper() throws Exception {
        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();
        shipper.setId(count.incrementAndGet());

        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restShipperMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(shipperDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamShipper() throws Exception {
        int databaseSizeBeforeUpdate = shipperRepository.findAll().size();
        shipper.setId(count.incrementAndGet());

        // Create the Shipper
        ShipperDTO shipperDTO = shipperMapper.toDto(shipper);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restShipperMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(shipperDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Shipper in the database
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteShipper() throws Exception {
        // Initialize the database
        shipperRepository.saveAndFlush(shipper);

        int databaseSizeBeforeDelete = shipperRepository.findAll().size();

        // Delete the shipper
        restShipperMockMvc
            .perform(delete(ENTITY_API_URL_ID, shipper.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Shipper> shipperList = shipperRepository.findAll();
        assertThat(shipperList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
