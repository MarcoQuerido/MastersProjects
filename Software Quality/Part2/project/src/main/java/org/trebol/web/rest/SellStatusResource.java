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
import org.trebol.repository.SellStatusRepository;
import org.trebol.service.SellStatusService;
import org.trebol.service.dto.SellStatusDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.SellStatus}.
 */
@RestController
@RequestMapping("/api")
public class SellStatusResource {

    private final Logger log = LoggerFactory.getLogger(SellStatusResource.class);

    private static final String ENTITY_NAME = "sellStatus";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SellStatusService sellStatusService;

    private final SellStatusRepository sellStatusRepository;

    public SellStatusResource(SellStatusService sellStatusService, SellStatusRepository sellStatusRepository) {
        this.sellStatusService = sellStatusService;
        this.sellStatusRepository = sellStatusRepository;
    }

    /**
     * {@code POST  /sell-statuses} : Create a new sellStatus.
     *
     * @param sellStatusDTO the sellStatusDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sellStatusDTO, or with status {@code 400 (Bad Request)} if the sellStatus has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sell-statuses")
    public ResponseEntity<SellStatusDTO> createSellStatus(@Valid @RequestBody SellStatusDTO sellStatusDTO) throws URISyntaxException {
        log.debug("REST request to save SellStatus : {}", sellStatusDTO);
        if (sellStatusDTO.getId() != null) {
            throw new BadRequestAlertException("A new sellStatus cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SellStatusDTO result = sellStatusService.save(sellStatusDTO);
        return ResponseEntity
            .created(new URI("/api/sell-statuses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sell-statuses/:id} : Updates an existing sellStatus.
     *
     * @param id the id of the sellStatusDTO to save.
     * @param sellStatusDTO the sellStatusDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sellStatusDTO,
     * or with status {@code 400 (Bad Request)} if the sellStatusDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sellStatusDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sell-statuses/{id}")
    public ResponseEntity<SellStatusDTO> updateSellStatus(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SellStatusDTO sellStatusDTO
    ) throws URISyntaxException {
        log.debug("REST request to update SellStatus : {}, {}", id, sellStatusDTO);
        if (sellStatusDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sellStatusDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sellStatusRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SellStatusDTO result = sellStatusService.update(sellStatusDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sellStatusDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /sell-statuses/:id} : Partial updates given fields of an existing sellStatus, field will ignore if it is null
     *
     * @param id the id of the sellStatusDTO to save.
     * @param sellStatusDTO the sellStatusDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sellStatusDTO,
     * or with status {@code 400 (Bad Request)} if the sellStatusDTO is not valid,
     * or with status {@code 404 (Not Found)} if the sellStatusDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the sellStatusDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/sell-statuses/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SellStatusDTO> partialUpdateSellStatus(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SellStatusDTO sellStatusDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update SellStatus partially : {}, {}", id, sellStatusDTO);
        if (sellStatusDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sellStatusDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sellStatusRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SellStatusDTO> result = sellStatusService.partialUpdate(sellStatusDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sellStatusDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /sell-statuses} : get all the sellStatuses.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sellStatuses in body.
     */
    @GetMapping("/sell-statuses")
    public List<SellStatusDTO> getAllSellStatuses() {
        log.debug("REST request to get all SellStatuses");
        return sellStatusService.findAll();
    }

    /**
     * {@code GET  /sell-statuses/:id} : get the "id" sellStatus.
     *
     * @param id the id of the sellStatusDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sellStatusDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sell-statuses/{id}")
    public ResponseEntity<SellStatusDTO> getSellStatus(@PathVariable Long id) {
        log.debug("REST request to get SellStatus : {}", id);
        Optional<SellStatusDTO> sellStatusDTO = sellStatusService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sellStatusDTO);
    }

    /**
     * {@code DELETE  /sell-statuses/:id} : delete the "id" sellStatus.
     *
     * @param id the id of the sellStatusDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sell-statuses/{id}")
    public ResponseEntity<Void> deleteSellStatus(@PathVariable Long id) {
        log.debug("REST request to delete SellStatus : {}", id);
        sellStatusService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
