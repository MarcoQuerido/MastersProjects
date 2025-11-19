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
import org.trebol.domain.Costumer;
import org.trebol.domain.Person;
import org.trebol.repository.CostumerRepository;
import org.trebol.service.dto.CostumerDTO;
import org.trebol.service.mapper.CostumerMapper;

/**
 * Integration tests for the {@link CostumerResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CostumerResourceIT {

    private static final String ENTITY_API_URL = "/api/costumers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private CostumerMapper costumerMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCostumerMockMvc;

    private Costumer costumer;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Costumer createEntity(EntityManager em) {
        Costumer costumer = new Costumer();
        // Add required entity
        Person person;
        if (TestUtil.findAll(em, Person.class).isEmpty()) {
            person = PersonResourceIT.createEntity(em);
            em.persist(person);
            em.flush();
        } else {
            person = TestUtil.findAll(em, Person.class).get(0);
        }
        costumer.setPerson(person);
        return costumer;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Costumer createUpdatedEntity(EntityManager em) {
        Costumer costumer = new Costumer();
        // Add required entity
        Person person;
        if (TestUtil.findAll(em, Person.class).isEmpty()) {
            person = PersonResourceIT.createUpdatedEntity(em);
            em.persist(person);
            em.flush();
        } else {
            person = TestUtil.findAll(em, Person.class).get(0);
        }
        costumer.setPerson(person);
        return costumer;
    }

    @BeforeEach
    public void initTest() {
        costumer = createEntity(em);
    }

    @Test
    @Transactional
    void createCostumer() throws Exception {
        int databaseSizeBeforeCreate = costumerRepository.findAll().size();
        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);
        restCostumerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(costumerDTO)))
            .andExpect(status().isCreated());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeCreate + 1);
        Costumer testCostumer = costumerList.get(costumerList.size() - 1);
    }

    @Test
    @Transactional
    void createCostumerWithExistingId() throws Exception {
        // Create the Costumer with an existing ID
        costumer.setId(1L);
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        int databaseSizeBeforeCreate = costumerRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCostumerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(costumerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllCostumers() throws Exception {
        // Initialize the database
        costumerRepository.saveAndFlush(costumer);

        // Get all the costumerList
        restCostumerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(costumer.getId().intValue())));
    }

    @Test
    @Transactional
    void getCostumer() throws Exception {
        // Initialize the database
        costumerRepository.saveAndFlush(costumer);

        // Get the costumer
        restCostumerMockMvc
            .perform(get(ENTITY_API_URL_ID, costumer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(costumer.getId().intValue()));
    }

    @Test
    @Transactional
    void getNonExistingCostumer() throws Exception {
        // Get the costumer
        restCostumerMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingCostumer() throws Exception {
        // Initialize the database
        costumerRepository.saveAndFlush(costumer);

        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();

        // Update the costumer
        Costumer updatedCostumer = costumerRepository.findById(costumer.getId()).get();
        // Disconnect from session so that the updates on updatedCostumer are not directly saved in db
        em.detach(updatedCostumer);
        CostumerDTO costumerDTO = costumerMapper.toDto(updatedCostumer);

        restCostumerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, costumerDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(costumerDTO))
            )
            .andExpect(status().isOk());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
        Costumer testCostumer = costumerList.get(costumerList.size() - 1);
    }

    @Test
    @Transactional
    void putNonExistingCostumer() throws Exception {
        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();
        costumer.setId(count.incrementAndGet());

        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCostumerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, costumerDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(costumerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCostumer() throws Exception {
        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();
        costumer.setId(count.incrementAndGet());

        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCostumerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(costumerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCostumer() throws Exception {
        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();
        costumer.setId(count.incrementAndGet());

        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCostumerMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(costumerDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCostumerWithPatch() throws Exception {
        // Initialize the database
        costumerRepository.saveAndFlush(costumer);

        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();

        // Update the costumer using partial update
        Costumer partialUpdatedCostumer = new Costumer();
        partialUpdatedCostumer.setId(costumer.getId());

        restCostumerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCostumer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCostumer))
            )
            .andExpect(status().isOk());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
        Costumer testCostumer = costumerList.get(costumerList.size() - 1);
    }

    @Test
    @Transactional
    void fullUpdateCostumerWithPatch() throws Exception {
        // Initialize the database
        costumerRepository.saveAndFlush(costumer);

        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();

        // Update the costumer using partial update
        Costumer partialUpdatedCostumer = new Costumer();
        partialUpdatedCostumer.setId(costumer.getId());

        restCostumerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCostumer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCostumer))
            )
            .andExpect(status().isOk());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
        Costumer testCostumer = costumerList.get(costumerList.size() - 1);
    }

    @Test
    @Transactional
    void patchNonExistingCostumer() throws Exception {
        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();
        costumer.setId(count.incrementAndGet());

        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCostumerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, costumerDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(costumerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCostumer() throws Exception {
        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();
        costumer.setId(count.incrementAndGet());

        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCostumerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(costumerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCostumer() throws Exception {
        int databaseSizeBeforeUpdate = costumerRepository.findAll().size();
        costumer.setId(count.incrementAndGet());

        // Create the Costumer
        CostumerDTO costumerDTO = costumerMapper.toDto(costumer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCostumerMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(costumerDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Costumer in the database
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCostumer() throws Exception {
        // Initialize the database
        costumerRepository.saveAndFlush(costumer);

        int databaseSizeBeforeDelete = costumerRepository.findAll().size();

        // Delete the costumer
        restCostumerMockMvc
            .perform(delete(ENTITY_API_URL_ID, costumer.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Costumer> costumerList = costumerRepository.findAll();
        assertThat(costumerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
