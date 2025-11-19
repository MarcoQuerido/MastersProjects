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
import org.trebol.repository.CostumerRepository;
import org.trebol.service.CostumerService;
import org.trebol.service.dto.CostumerDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.Costumer}.
 */
@RestController
@RequestMapping("/api")
public class CostumerResource {

    private final Logger log = LoggerFactory.getLogger(CostumerResource.class);

    private static final String ENTITY_NAME = "costumer";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CostumerService costumerService;

    private final CostumerRepository costumerRepository;

    public CostumerResource(CostumerService costumerService, CostumerRepository costumerRepository) {
        this.costumerService = costumerService;
        this.costumerRepository = costumerRepository;
    }

    /**
     * {@code POST  /costumers} : Create a new costumer.
     *
     * @param costumerDTO the costumerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new costumerDTO, or with status {@code 400 (Bad Request)} if the costumer has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/costumers")
    public ResponseEntity<CostumerDTO> createCostumer(@Valid @RequestBody CostumerDTO costumerDTO) throws URISyntaxException {
        log.debug("REST request to save Costumer : {}", costumerDTO);
        if (costumerDTO.getId() != null) {
            throw new BadRequestAlertException("A new costumer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CostumerDTO result = costumerService.save(costumerDTO);
        return ResponseEntity
            .created(new URI("/api/costumers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /costumers/:id} : Updates an existing costumer.
     *
     * @param id the id of the costumerDTO to save.
     * @param costumerDTO the costumerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated costumerDTO,
     * or with status {@code 400 (Bad Request)} if the costumerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the costumerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/costumers/{id}")
    public ResponseEntity<CostumerDTO> updateCostumer(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CostumerDTO costumerDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Costumer : {}, {}", id, costumerDTO);
        if (costumerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, costumerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!costumerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CostumerDTO result = costumerService.update(costumerDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, costumerDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /costumers/:id} : Partial updates given fields of an existing costumer, field will ignore if it is null
     *
     * @param id the id of the costumerDTO to save.
     * @param costumerDTO the costumerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated costumerDTO,
     * or with status {@code 400 (Bad Request)} if the costumerDTO is not valid,
     * or with status {@code 404 (Not Found)} if the costumerDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the costumerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/costumers/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CostumerDTO> partialUpdateCostumer(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CostumerDTO costumerDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Costumer partially : {}, {}", id, costumerDTO);
        if (costumerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, costumerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!costumerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CostumerDTO> result = costumerService.partialUpdate(costumerDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, costumerDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /costumers} : get all the costumers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of costumers in body.
     */
    @GetMapping("/costumers")
    public List<CostumerDTO> getAllCostumers() {
        log.debug("REST request to get all Costumers");
        return costumerService.findAll();
    }

    /**
     * {@code GET  /costumers/:id} : get the "id" costumer.
     *
     * @param id the id of the costumerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the costumerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/costumers/{id}")
    public ResponseEntity<CostumerDTO> getCostumer(@PathVariable Long id) {
        log.debug("REST request to get Costumer : {}", id);
        Optional<CostumerDTO> costumerDTO = costumerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(costumerDTO);
    }

    /**
     * {@code DELETE  /costumers/:id} : delete the "id" costumer.
     *
     * @param id the id of the costumerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/costumers/{id}")
    public ResponseEntity<Void> deleteCostumer(@PathVariable Long id) {
        log.debug("REST request to delete Costumer : {}", id);
        costumerService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
