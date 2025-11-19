package org.trebol.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
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
import org.trebol.domain.Customer;
import org.trebol.domain.PaymentType;
import org.trebol.domain.Sell;
import org.trebol.domain.SellStatus;
import org.trebol.repository.SellRepository;
import org.trebol.service.dto.SellDTO;
import org.trebol.service.mapper.SellMapper;

/**
 * Integration tests for the {@link SellResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SellResourceIT {

    private static final Instant DEFAULT_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_TOTAL_ITEMS = 1;
    private static final Integer UPDATED_TOTAL_ITEMS = 2;

    private static final Integer DEFAULT_NET_VALUE = 1;
    private static final Integer UPDATED_NET_VALUE = 2;

    private static final Integer DEFAULT_TRANSPORT_VALUE = 1;
    private static final Integer UPDATED_TRANSPORT_VALUE = 2;

    private static final Integer DEFAULT_TAXES_VALUE = 1;
    private static final Integer UPDATED_TAXES_VALUE = 2;

    private static final Integer DEFAULT_TOTAL_VALUE = 1;
    private static final Integer UPDATED_TOTAL_VALUE = 2;

    private static final String DEFAULT_TRANSACTION_TOKEN = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    private static final String UPDATED_TRANSACTION_TOKEN = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/sells";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SellRepository sellRepository;

    @Autowired
    private SellMapper sellMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSellMockMvc;

    private Sell sell;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Sell createEntity(EntityManager em) {
        Sell sell = new Sell()
            .date(DEFAULT_DATE)
            .totalItems(DEFAULT_TOTAL_ITEMS)
            .netValue(DEFAULT_NET_VALUE)
            .transportValue(DEFAULT_TRANSPORT_VALUE)
            .taxesValue(DEFAULT_TAXES_VALUE)
            .totalValue(DEFAULT_TOTAL_VALUE)
            .transactionToken(DEFAULT_TRANSACTION_TOKEN);
        // Add required entity
        Customer customer;
        if (TestUtil.findAll(em, Customer.class).isEmpty()) {
            customer = CustomerResourceIT.createEntity(em);
            em.persist(customer);
            em.flush();
        } else {
            customer = TestUtil.findAll(em, Customer.class).get(0);
        }
        sell.setCostumer(customer);
        // Add required entity
        PaymentType paymentType;
        if (TestUtil.findAll(em, PaymentType.class).isEmpty()) {
            paymentType = PaymentTypeResourceIT.createEntity(em);
            em.persist(paymentType);
            em.flush();
        } else {
            paymentType = TestUtil.findAll(em, PaymentType.class).get(0);
        }
        sell.setPaymentType(paymentType);
        // Add required entity
        SellStatus sellStatus;
        if (TestUtil.findAll(em, SellStatus.class).isEmpty()) {
            sellStatus = SellStatusResourceIT.createEntity(em);
            em.persist(sellStatus);
            em.flush();
        } else {
            sellStatus = TestUtil.findAll(em, SellStatus.class).get(0);
        }
        sell.setStatus(sellStatus);
        // Add required entity
        BillingType billingType;
        if (TestUtil.findAll(em, BillingType.class).isEmpty()) {
            billingType = BillingTypeResourceIT.createEntity(em);
            em.persist(billingType);
            em.flush();
        } else {
            billingType = TestUtil.findAll(em, BillingType.class).get(0);
        }
        sell.setBillingType(billingType);
        return sell;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Sell createUpdatedEntity(EntityManager em) {
        Sell sell = new Sell()
            .date(UPDATED_DATE)
            .totalItems(UPDATED_TOTAL_ITEMS)
            .netValue(UPDATED_NET_VALUE)
            .transportValue(UPDATED_TRANSPORT_VALUE)
            .taxesValue(UPDATED_TAXES_VALUE)
            .totalValue(UPDATED_TOTAL_VALUE)
            .transactionToken(UPDATED_TRANSACTION_TOKEN);
        // Add required entity
        Customer customer;
        if (TestUtil.findAll(em, Customer.class).isEmpty()) {
            customer = CustomerResourceIT.createUpdatedEntity(em);
            em.persist(customer);
            em.flush();
        } else {
            customer = TestUtil.findAll(em, Customer.class).get(0);
        }
        sell.setCostumer(customer);
        // Add required entity
        PaymentType paymentType;
        if (TestUtil.findAll(em, PaymentType.class).isEmpty()) {
            paymentType = PaymentTypeResourceIT.createUpdatedEntity(em);
            em.persist(paymentType);
            em.flush();
        } else {
            paymentType = TestUtil.findAll(em, PaymentType.class).get(0);
        }
        sell.setPaymentType(paymentType);
        // Add required entity
        SellStatus sellStatus;
        if (TestUtil.findAll(em, SellStatus.class).isEmpty()) {
            sellStatus = SellStatusResourceIT.createUpdatedEntity(em);
            em.persist(sellStatus);
            em.flush();
        } else {
            sellStatus = TestUtil.findAll(em, SellStatus.class).get(0);
        }
        sell.setStatus(sellStatus);
        // Add required entity
        BillingType billingType;
        if (TestUtil.findAll(em, BillingType.class).isEmpty()) {
            billingType = BillingTypeResourceIT.createUpdatedEntity(em);
            em.persist(billingType);
            em.flush();
        } else {
            billingType = TestUtil.findAll(em, BillingType.class).get(0);
        }
        sell.setBillingType(billingType);
        return sell;
    }

    @BeforeEach
    public void initTest() {
        sell = createEntity(em);
    }

    @Test
    @Transactional
    void createSell() throws Exception {
        int databaseSizeBeforeCreate = sellRepository.findAll().size();
        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);
        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isCreated());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeCreate + 1);
        Sell testSell = sellList.get(sellList.size() - 1);
        assertThat(testSell.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testSell.getTotalItems()).isEqualTo(DEFAULT_TOTAL_ITEMS);
        assertThat(testSell.getNetValue()).isEqualTo(DEFAULT_NET_VALUE);
        assertThat(testSell.getTransportValue()).isEqualTo(DEFAULT_TRANSPORT_VALUE);
        assertThat(testSell.getTaxesValue()).isEqualTo(DEFAULT_TAXES_VALUE);
        assertThat(testSell.getTotalValue()).isEqualTo(DEFAULT_TOTAL_VALUE);
        assertThat(testSell.getTransactionToken()).isEqualTo(DEFAULT_TRANSACTION_TOKEN);
    }

    @Test
    @Transactional
    void createSellWithExistingId() throws Exception {
        // Create the Sell with an existing ID
        sell.setId(1L);
        SellDTO sellDTO = sellMapper.toDto(sell);

        int databaseSizeBeforeCreate = sellRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellRepository.findAll().size();
        // set the field null
        sell.setDate(null);

        // Create the Sell, which fails.
        SellDTO sellDTO = sellMapper.toDto(sell);

        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTotalItemsIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellRepository.findAll().size();
        // set the field null
        sell.setTotalItems(null);

        // Create the Sell, which fails.
        SellDTO sellDTO = sellMapper.toDto(sell);

        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNetValueIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellRepository.findAll().size();
        // set the field null
        sell.setNetValue(null);

        // Create the Sell, which fails.
        SellDTO sellDTO = sellMapper.toDto(sell);

        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTransportValueIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellRepository.findAll().size();
        // set the field null
        sell.setTransportValue(null);

        // Create the Sell, which fails.
        SellDTO sellDTO = sellMapper.toDto(sell);

        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTaxesValueIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellRepository.findAll().size();
        // set the field null
        sell.setTaxesValue(null);

        // Create the Sell, which fails.
        SellDTO sellDTO = sellMapper.toDto(sell);

        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTotalValueIsRequired() throws Exception {
        int databaseSizeBeforeTest = sellRepository.findAll().size();
        // set the field null
        sell.setTotalValue(null);

        // Create the Sell, which fails.
        SellDTO sellDTO = sellMapper.toDto(sell);

        restSellMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isBadRequest());

        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllSells() throws Exception {
        // Initialize the database
        sellRepository.saveAndFlush(sell);

        // Get all the sellList
        restSellMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sell.getId().intValue())))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].totalItems").value(hasItem(DEFAULT_TOTAL_ITEMS)))
            .andExpect(jsonPath("$.[*].netValue").value(hasItem(DEFAULT_NET_VALUE)))
            .andExpect(jsonPath("$.[*].transportValue").value(hasItem(DEFAULT_TRANSPORT_VALUE)))
            .andExpect(jsonPath("$.[*].taxesValue").value(hasItem(DEFAULT_TAXES_VALUE)))
            .andExpect(jsonPath("$.[*].totalValue").value(hasItem(DEFAULT_TOTAL_VALUE)))
            .andExpect(jsonPath("$.[*].transactionToken").value(hasItem(DEFAULT_TRANSACTION_TOKEN)));
    }

    @Test
    @Transactional
    void getSell() throws Exception {
        // Initialize the database
        sellRepository.saveAndFlush(sell);

        // Get the sell
        restSellMockMvc
            .perform(get(ENTITY_API_URL_ID, sell.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sell.getId().intValue()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.totalItems").value(DEFAULT_TOTAL_ITEMS))
            .andExpect(jsonPath("$.netValue").value(DEFAULT_NET_VALUE))
            .andExpect(jsonPath("$.transportValue").value(DEFAULT_TRANSPORT_VALUE))
            .andExpect(jsonPath("$.taxesValue").value(DEFAULT_TAXES_VALUE))
            .andExpect(jsonPath("$.totalValue").value(DEFAULT_TOTAL_VALUE))
            .andExpect(jsonPath("$.transactionToken").value(DEFAULT_TRANSACTION_TOKEN));
    }

    @Test
    @Transactional
    void getNonExistingSell() throws Exception {
        // Get the sell
        restSellMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSell() throws Exception {
        // Initialize the database
        sellRepository.saveAndFlush(sell);

        int databaseSizeBeforeUpdate = sellRepository.findAll().size();

        // Update the sell
        Sell updatedSell = sellRepository.findById(sell.getId()).get();
        // Disconnect from session so that the updates on updatedSell are not directly saved in db
        em.detach(updatedSell);
        updatedSell
            .date(UPDATED_DATE)
            .totalItems(UPDATED_TOTAL_ITEMS)
            .netValue(UPDATED_NET_VALUE)
            .transportValue(UPDATED_TRANSPORT_VALUE)
            .taxesValue(UPDATED_TAXES_VALUE)
            .totalValue(UPDATED_TOTAL_VALUE)
            .transactionToken(UPDATED_TRANSACTION_TOKEN);
        SellDTO sellDTO = sellMapper.toDto(updatedSell);

        restSellMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sellDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellDTO))
            )
            .andExpect(status().isOk());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
        Sell testSell = sellList.get(sellList.size() - 1);
        assertThat(testSell.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testSell.getTotalItems()).isEqualTo(UPDATED_TOTAL_ITEMS);
        assertThat(testSell.getNetValue()).isEqualTo(UPDATED_NET_VALUE);
        assertThat(testSell.getTransportValue()).isEqualTo(UPDATED_TRANSPORT_VALUE);
        assertThat(testSell.getTaxesValue()).isEqualTo(UPDATED_TAXES_VALUE);
        assertThat(testSell.getTotalValue()).isEqualTo(UPDATED_TOTAL_VALUE);
        assertThat(testSell.getTransactionToken()).isEqualTo(UPDATED_TRANSACTION_TOKEN);
    }

    @Test
    @Transactional
    void putNonExistingSell() throws Exception {
        int databaseSizeBeforeUpdate = sellRepository.findAll().size();
        sell.setId(count.incrementAndGet());

        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSellMockMvc
            .perform(
                put(ENTITY_API_URL_ID, sellDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSell() throws Exception {
        int databaseSizeBeforeUpdate = sellRepository.findAll().size();
        sell.setId(count.incrementAndGet());

        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(sellDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSell() throws Exception {
        int databaseSizeBeforeUpdate = sellRepository.findAll().size();
        sell.setId(count.incrementAndGet());

        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSellWithPatch() throws Exception {
        // Initialize the database
        sellRepository.saveAndFlush(sell);

        int databaseSizeBeforeUpdate = sellRepository.findAll().size();

        // Update the sell using partial update
        Sell partialUpdatedSell = new Sell();
        partialUpdatedSell.setId(sell.getId());

        partialUpdatedSell.taxesValue(UPDATED_TAXES_VALUE).totalValue(UPDATED_TOTAL_VALUE);

        restSellMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSell.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSell))
            )
            .andExpect(status().isOk());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
        Sell testSell = sellList.get(sellList.size() - 1);
        assertThat(testSell.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testSell.getTotalItems()).isEqualTo(DEFAULT_TOTAL_ITEMS);
        assertThat(testSell.getNetValue()).isEqualTo(DEFAULT_NET_VALUE);
        assertThat(testSell.getTransportValue()).isEqualTo(DEFAULT_TRANSPORT_VALUE);
        assertThat(testSell.getTaxesValue()).isEqualTo(UPDATED_TAXES_VALUE);
        assertThat(testSell.getTotalValue()).isEqualTo(UPDATED_TOTAL_VALUE);
        assertThat(testSell.getTransactionToken()).isEqualTo(DEFAULT_TRANSACTION_TOKEN);
    }

    @Test
    @Transactional
    void fullUpdateSellWithPatch() throws Exception {
        // Initialize the database
        sellRepository.saveAndFlush(sell);

        int databaseSizeBeforeUpdate = sellRepository.findAll().size();

        // Update the sell using partial update
        Sell partialUpdatedSell = new Sell();
        partialUpdatedSell.setId(sell.getId());

        partialUpdatedSell
            .date(UPDATED_DATE)
            .totalItems(UPDATED_TOTAL_ITEMS)
            .netValue(UPDATED_NET_VALUE)
            .transportValue(UPDATED_TRANSPORT_VALUE)
            .taxesValue(UPDATED_TAXES_VALUE)
            .totalValue(UPDATED_TOTAL_VALUE)
            .transactionToken(UPDATED_TRANSACTION_TOKEN);

        restSellMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSell.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSell))
            )
            .andExpect(status().isOk());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
        Sell testSell = sellList.get(sellList.size() - 1);
        assertThat(testSell.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testSell.getTotalItems()).isEqualTo(UPDATED_TOTAL_ITEMS);
        assertThat(testSell.getNetValue()).isEqualTo(UPDATED_NET_VALUE);
        assertThat(testSell.getTransportValue()).isEqualTo(UPDATED_TRANSPORT_VALUE);
        assertThat(testSell.getTaxesValue()).isEqualTo(UPDATED_TAXES_VALUE);
        assertThat(testSell.getTotalValue()).isEqualTo(UPDATED_TOTAL_VALUE);
        assertThat(testSell.getTransactionToken()).isEqualTo(UPDATED_TRANSACTION_TOKEN);
    }

    @Test
    @Transactional
    void patchNonExistingSell() throws Exception {
        int databaseSizeBeforeUpdate = sellRepository.findAll().size();
        sell.setId(count.incrementAndGet());

        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSellMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, sellDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(sellDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSell() throws Exception {
        int databaseSizeBeforeUpdate = sellRepository.findAll().size();
        sell.setId(count.incrementAndGet());

        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(sellDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSell() throws Exception {
        int databaseSizeBeforeUpdate = sellRepository.findAll().size();
        sell.setId(count.incrementAndGet());

        // Create the Sell
        SellDTO sellDTO = sellMapper.toDto(sell);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSellMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(sellDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Sell in the database
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSell() throws Exception {
        // Initialize the database
        sellRepository.saveAndFlush(sell);

        int databaseSizeBeforeDelete = sellRepository.findAll().size();

        // Delete the sell
        restSellMockMvc
            .perform(delete(ENTITY_API_URL_ID, sell.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Sell> sellList = sellRepository.findAll();
        assertThat(sellList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
