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
import org.trebol.repository.BillingTypeRepository;
import org.trebol.service.BillingTypeService;
import org.trebol.service.dto.BillingTypeDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.BillingType}.
 */
@RestController
@RequestMapping("/api")
public class BillingTypeResource {

    private final Logger log = LoggerFactory.getLogger(BillingTypeResource.class);

    private static final String ENTITY_NAME = "billingType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BillingTypeService billingTypeService;

    private final BillingTypeRepository billingTypeRepository;

    public BillingTypeResource(BillingTypeService billingTypeService, BillingTypeRepository billingTypeRepository) {
        this.billingTypeService = billingTypeService;
        this.billingTypeRepository = billingTypeRepository;
    }

    /**
     * {@code POST  /billing-types} : Create a new billingType.
     *
     * @param billingTypeDTO the billingTypeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new billingTypeDTO, or with status {@code 400 (Bad Request)} if the billingType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/billing-types")
    public ResponseEntity<BillingTypeDTO> createBillingType(@Valid @RequestBody BillingTypeDTO billingTypeDTO) throws URISyntaxException {
        log.debug("REST request to save BillingType : {}", billingTypeDTO);
        if (billingTypeDTO.getId() != null) {
            throw new BadRequestAlertException("A new billingType cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BillingTypeDTO result = billingTypeService.save(billingTypeDTO);
        return ResponseEntity
            .created(new URI("/api/billing-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /billing-types/:id} : Updates an existing billingType.
     *
     * @param id the id of the billingTypeDTO to save.
     * @param billingTypeDTO the billingTypeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated billingTypeDTO,
     * or with status {@code 400 (Bad Request)} if the billingTypeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the billingTypeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/billing-types/{id}")
    public ResponseEntity<BillingTypeDTO> updateBillingType(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody BillingTypeDTO billingTypeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update BillingType : {}, {}", id, billingTypeDTO);
        if (billingTypeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, billingTypeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!billingTypeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        BillingTypeDTO result = billingTypeService.update(billingTypeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, billingTypeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /billing-types/:id} : Partial updates given fields of an existing billingType, field will ignore if it is null
     *
     * @param id the id of the billingTypeDTO to save.
     * @param billingTypeDTO the billingTypeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated billingTypeDTO,
     * or with status {@code 400 (Bad Request)} if the billingTypeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the billingTypeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the billingTypeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/billing-types/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<BillingTypeDTO> partialUpdateBillingType(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody BillingTypeDTO billingTypeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update BillingType partially : {}, {}", id, billingTypeDTO);
        if (billingTypeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, billingTypeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!billingTypeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<BillingTypeDTO> result = billingTypeService.partialUpdate(billingTypeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, billingTypeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /billing-types} : get all the billingTypes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of billingTypes in body.
     */
    @GetMapping("/billing-types")
    public List<BillingTypeDTO> getAllBillingTypes() {
        log.debug("REST request to get all BillingTypes");
        return billingTypeService.findAll();
    }

    /**
     * {@code GET  /billing-types/:id} : get the "id" billingType.
     *
     * @param id the id of the billingTypeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the billingTypeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/billing-types/{id}")
    public ResponseEntity<BillingTypeDTO> getBillingType(@PathVariable Long id) {
        log.debug("REST request to get BillingType : {}", id);
        Optional<BillingTypeDTO> billingTypeDTO = billingTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(billingTypeDTO);
    }

    /**
     * {@code DELETE  /billing-types/:id} : delete the "id" billingType.
     *
     * @param id the id of the billingTypeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/billing-types/{id}")
    public ResponseEntity<Void> deleteBillingType(@PathVariable Long id) {
        log.debug("REST request to delete BillingType : {}", id);
        billingTypeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
