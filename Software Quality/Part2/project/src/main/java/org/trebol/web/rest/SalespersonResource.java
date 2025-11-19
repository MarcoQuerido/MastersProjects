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
import org.trebol.repository.SalespersonRepository;
import org.trebol.service.SalespersonService;
import org.trebol.service.dto.SalespersonDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.Salesperson}.
 */
@RestController
@RequestMapping("/api")
public class SalespersonResource {

    private final Logger log = LoggerFactory.getLogger(SalespersonResource.class);

    private static final String ENTITY_NAME = "salesperson";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SalespersonService salespersonService;

    private final SalespersonRepository salespersonRepository;

    public SalespersonResource(SalespersonService salespersonService, SalespersonRepository salespersonRepository) {
        this.salespersonService = salespersonService;
        this.salespersonRepository = salespersonRepository;
    }

    /**
     * {@code POST  /salespeople} : Create a new salesperson.
     *
     * @param salespersonDTO the salespersonDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salespersonDTO, or with status {@code 400 (Bad Request)} if the salesperson has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/salespeople")
    public ResponseEntity<SalespersonDTO> createSalesperson(@Valid @RequestBody SalespersonDTO salespersonDTO) throws URISyntaxException {
        log.debug("REST request to save Salesperson : {}", salespersonDTO);
        if (salespersonDTO.getId() != null) {
            throw new BadRequestAlertException("A new salesperson cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SalespersonDTO result = salespersonService.save(salespersonDTO);
        return ResponseEntity
            .created(new URI("/api/salespeople/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /salespeople/:id} : Updates an existing salesperson.
     *
     * @param id the id of the salespersonDTO to save.
     * @param salespersonDTO the salespersonDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salespersonDTO,
     * or with status {@code 400 (Bad Request)} if the salespersonDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the salespersonDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/salespeople/{id}")
    public ResponseEntity<SalespersonDTO> updateSalesperson(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SalespersonDTO salespersonDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Salesperson : {}, {}", id, salespersonDTO);
        if (salespersonDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, salespersonDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!salespersonRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SalespersonDTO result = salespersonService.update(salespersonDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, salespersonDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /salespeople/:id} : Partial updates given fields of an existing salesperson, field will ignore if it is null
     *
     * @param id the id of the salespersonDTO to save.
     * @param salespersonDTO the salespersonDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated salespersonDTO,
     * or with status {@code 400 (Bad Request)} if the salespersonDTO is not valid,
     * or with status {@code 404 (Not Found)} if the salespersonDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the salespersonDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/salespeople/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SalespersonDTO> partialUpdateSalesperson(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SalespersonDTO salespersonDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Salesperson partially : {}, {}", id, salespersonDTO);
        if (salespersonDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, salespersonDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!salespersonRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SalespersonDTO> result = salespersonService.partialUpdate(salespersonDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, salespersonDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /salespeople} : get all the salespeople.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of salespeople in body.
     */
    @GetMapping("/salespeople")
    public List<SalespersonDTO> getAllSalespeople() {
        log.debug("REST request to get all Salespeople");
        return salespersonService.findAll();
    }

    /**
     * {@code GET  /salespeople/:id} : get the "id" salesperson.
     *
     * @param id the id of the salespersonDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the salespersonDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/salespeople/{id}")
    public ResponseEntity<SalespersonDTO> getSalesperson(@PathVariable Long id) {
        log.debug("REST request to get Salesperson : {}", id);
        Optional<SalespersonDTO> salespersonDTO = salespersonService.findOne(id);
        return ResponseUtil.wrapOrNotFound(salespersonDTO);
    }

    /**
     * {@code DELETE  /salespeople/:id} : delete the "id" salesperson.
     *
     * @param id the id of the salespersonDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/salespeople/{id}")
    public ResponseEntity<Void> deleteSalesperson(@PathVariable Long id) {
        log.debug("REST request to delete Salesperson : {}", id);
        salespersonService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
