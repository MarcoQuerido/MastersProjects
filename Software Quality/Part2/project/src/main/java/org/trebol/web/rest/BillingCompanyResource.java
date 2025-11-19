package org.trebol.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trebol.repository.BillingCompanyRepository;
import org.trebol.service.BillingCompanyService;
import org.trebol.service.dto.BillingCompanyDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.BillingCompany}.
 */
@RestController
@RequestMapping("/api")
public class BillingCompanyResource {

    private final Logger log = LoggerFactory.getLogger(BillingCompanyResource.class);

    private static final String ENTITY_NAME = "billingCompany";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BillingCompanyService billingCompanyService;

    private final BillingCompanyRepository billingCompanyRepository;

    public BillingCompanyResource(BillingCompanyService billingCompanyService, BillingCompanyRepository billingCompanyRepository) {
        this.billingCompanyService = billingCompanyService;
        this.billingCompanyRepository = billingCompanyRepository;
    }

    /**
     * {@code POST  /billing-companies} : Create a new billingCompany.
     *
     * @param billingCompanyDTO the billingCompanyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new billingCompanyDTO, or with status {@code 400 (Bad Request)} if the billingCompany has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/billing-companies")
    public ResponseEntity<BillingCompanyDTO> createBillingCompany(@Valid @RequestBody BillingCompanyDTO billingCompanyDTO)
        throws URISyntaxException {
        log.debug("REST request to save BillingCompany : {}", billingCompanyDTO);
        if (billingCompanyDTO.getId() != null) {
            throw new BadRequestAlertException("A new billingCompany cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BillingCompanyDTO result = billingCompanyService.save(billingCompanyDTO);
        return ResponseEntity
            .created(new URI("/api/billing-companies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /billing-companies/:id} : Updates an existing billingCompany.
     *
     * @param id the id of the billingCompanyDTO to save.
     * @param billingCompanyDTO the billingCompanyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated billingCompanyDTO,
     * or with status {@code 400 (Bad Request)} if the billingCompanyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the billingCompanyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/billing-companies/{id}")
    public ResponseEntity<BillingCompanyDTO> updateBillingCompany(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody BillingCompanyDTO billingCompanyDTO
    ) throws URISyntaxException {
        log.debug("REST request to update BillingCompany : {}, {}", id, billingCompanyDTO);
        if (billingCompanyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, billingCompanyDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!billingCompanyRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        BillingCompanyDTO result = billingCompanyService.update(billingCompanyDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, billingCompanyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /billing-companies/:id} : Partial updates given fields of an existing billingCompany, field will ignore if it is null
     *
     * @param id the id of the billingCompanyDTO to save.
     * @param billingCompanyDTO the billingCompanyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated billingCompanyDTO,
     * or with status {@code 400 (Bad Request)} if the billingCompanyDTO is not valid,
     * or with status {@code 404 (Not Found)} if the billingCompanyDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the billingCompanyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/billing-companies/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<BillingCompanyDTO> partialUpdateBillingCompany(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody BillingCompanyDTO billingCompanyDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update BillingCompany partially : {}, {}", id, billingCompanyDTO);
        if (billingCompanyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, billingCompanyDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!billingCompanyRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<BillingCompanyDTO> result = billingCompanyService.partialUpdate(billingCompanyDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, billingCompanyDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /billing-companies} : get all the billingCompanies.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of billingCompanies in body.
     */
    @GetMapping("/billing-companies")
    public List<BillingCompanyDTO> getAllBillingCompanies() {
        log.debug("REST request to get all BillingCompanies");
        return billingCompanyService.findAll();
    }

    /**
     * {@code GET  /billing-companies/:id} : get the "id" billingCompany.
     *
     * @param id the id of the billingCompanyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the billingCompanyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/billing-companies/{id}")
    public ResponseEntity<BillingCompanyDTO> getBillingCompany(@PathVariable Long id) {
        log.debug("REST request to get BillingCompany : {}", id);
        Optional<BillingCompanyDTO> billingCompanyDTO = billingCompanyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(billingCompanyDTO);
    }

    /**
     * {@code DELETE  /billing-companies/:id} : delete the "id" billingCompany.
     *
     * @param id the id of the billingCompanyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/billing-companies/{id}")
    public ResponseEntity<Void> deleteBillingCompany(@PathVariable Long id) {
        log.debug("REST request to delete BillingCompany : {}", id);
        billingCompanyService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
