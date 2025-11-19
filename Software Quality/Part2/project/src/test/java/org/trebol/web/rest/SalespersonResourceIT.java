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
import org.trebol.domain.Person;
import org.trebol.domain.Salesperson;
import org.trebol.repository.SalespersonRepository;
import org.trebol.service.dto.SalespersonDTO;
import org.trebol.service.mapper.SalespersonMapper;

/**
 * Integration tests for the {@link SalespersonResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SalespersonResourceIT {

    private static final String ENTITY_API_URL = "/api/salespeople";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SalespersonRepository salespersonRepository;

    @Autowired
    private SalespersonMapper salespersonMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSalespersonMockMvc;

    private Salesperson salesperson;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Salesperson createEntity(EntityManager em) {
        Salesperson salesperson = new Salesperson();
        // Add required entity
        Person person;
        if (TestUtil.findAll(em, Person.class).isEmpty()) {
            person = PersonResourceIT.createEntity(em);
            em.persist(person);
            em.flush();
        } else {
            person = TestUtil.findAll(em, Person.class).get(0);
        }
        salesperson.setPerson(person);
        return salesperson;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Salesperson createUpdatedEntity(EntityManager em) {
        Salesperson salesperson = new Salesperson();
        // Add required entity
        Person person;
        if (TestUtil.findAll(em, Person.class).isEmpty()) {
            person = PersonResourceIT.createUpdatedEntity(em);
            em.persist(person);
            em.flush();
        } else {
            person = TestUtil.findAll(em, Person.class).get(0);
        }
        salesperson.setPerson(person);
        return salesperson;
    }

    @BeforeEach
    public void initTest() {
        salesperson = createEntity(em);
    }

    @Test
    @Transactional
    void createSalesperson() throws Exception {
        int databaseSizeBeforeCreate = salespersonRepository.findAll().size();
        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);
        restSalespersonMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isCreated());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeCreate + 1);
        Salesperson testSalesperson = salespersonList.get(salespersonList.size() - 1);
    }

    @Test
    @Transactional
    void createSalespersonWithExistingId() throws Exception {
        // Create the Salesperson with an existing ID
        salesperson.setId(1L);
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        int databaseSizeBeforeCreate = salespersonRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSalespersonMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllSalespeople() throws Exception {
        // Initialize the database
        salespersonRepository.saveAndFlush(salesperson);

        // Get all the salespersonList
        restSalespersonMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(salesperson.getId().intValue())));
    }

    @Test
    @Transactional
    void getSalesperson() throws Exception {
        // Initialize the database
        salespersonRepository.saveAndFlush(salesperson);

        // Get the salesperson
        restSalespersonMockMvc
            .perform(get(ENTITY_API_URL_ID, salesperson.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(salesperson.getId().intValue()));
    }

    @Test
    @Transactional
    void getNonExistingSalesperson() throws Exception {
        // Get the salesperson
        restSalespersonMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSalesperson() throws Exception {
        // Initialize the database
        salespersonRepository.saveAndFlush(salesperson);

        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();

        // Update the salesperson
        Salesperson updatedSalesperson = salespersonRepository.findById(salesperson.getId()).get();
        // Disconnect from session so that the updates on updatedSalesperson are not directly saved in db
        em.detach(updatedSalesperson);
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(updatedSalesperson);

        restSalespersonMockMvc
            .perform(
                put(ENTITY_API_URL_ID, salespersonDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isOk());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
        Salesperson testSalesperson = salespersonList.get(salespersonList.size() - 1);
    }

    @Test
    @Transactional
    void putNonExistingSalesperson() throws Exception {
        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();
        salesperson.setId(count.incrementAndGet());

        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSalespersonMockMvc
            .perform(
                put(ENTITY_API_URL_ID, salespersonDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSalesperson() throws Exception {
        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();
        salesperson.setId(count.incrementAndGet());

        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSalespersonMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSalesperson() throws Exception {
        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();
        salesperson.setId(count.incrementAndGet());

        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSalespersonMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(salespersonDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSalespersonWithPatch() throws Exception {
        // Initialize the database
        salespersonRepository.saveAndFlush(salesperson);

        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();

        // Update the salesperson using partial update
        Salesperson partialUpdatedSalesperson = new Salesperson();
        partialUpdatedSalesperson.setId(salesperson.getId());

        restSalespersonMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSalesperson.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesperson))
            )
            .andExpect(status().isOk());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
        Salesperson testSalesperson = salespersonList.get(salespersonList.size() - 1);
    }

    @Test
    @Transactional
    void fullUpdateSalespersonWithPatch() throws Exception {
        // Initialize the database
        salespersonRepository.saveAndFlush(salesperson);

        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();

        // Update the salesperson using partial update
        Salesperson partialUpdatedSalesperson = new Salesperson();
        partialUpdatedSalesperson.setId(salesperson.getId());

        restSalespersonMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSalesperson.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSalesperson))
            )
            .andExpect(status().isOk());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
        Salesperson testSalesperson = salespersonList.get(salespersonList.size() - 1);
    }

    @Test
    @Transactional
    void patchNonExistingSalesperson() throws Exception {
        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();
        salesperson.setId(count.incrementAndGet());

        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSalespersonMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, salespersonDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSalesperson() throws Exception {
        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();
        salesperson.setId(count.incrementAndGet());

        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSalespersonMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSalesperson() throws Exception {
        int databaseSizeBeforeUpdate = salespersonRepository.findAll().size();
        salesperson.setId(count.incrementAndGet());

        // Create the Salesperson
        SalespersonDTO salespersonDTO = salespersonMapper.toDto(salesperson);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSalespersonMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(salespersonDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Salesperson in the database
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSalesperson() throws Exception {
        // Initialize the database
        salespersonRepository.saveAndFlush(salesperson);

        int databaseSizeBeforeDelete = salespersonRepository.findAll().size();

        // Delete the salesperson
        restSalespersonMockMvc
            .perform(delete(ENTITY_API_URL_ID, salesperson.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Salesperson> salespersonList = salespersonRepository.findAll();
        assertThat(salespersonList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
