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
import org.trebol.repository.SellDetailsRepository;
import org.trebol.service.SellDetailsService;
import org.trebol.service.dto.SellDetailsDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.SellDetails}.
 */
@RestController
@RequestMapping("/api")
public class SellDetailsResource {

    private final Logger log = LoggerFactory.getLogger(SellDetailsResource.class);

    private static final String ENTITY_NAME = "sellDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SellDetailsService sellDetailsService;

    private final SellDetailsRepository sellDetailsRepository;

    public SellDetailsResource(SellDetailsService sellDetailsService, SellDetailsRepository sellDetailsRepository) {
        this.sellDetailsService = sellDetailsService;
        this.sellDetailsRepository = sellDetailsRepository;
    }

    /**
     * {@code POST  /sell-details} : Create a new sellDetails.
     *
     * @param sellDetailsDTO the sellDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sellDetailsDTO, or with status {@code 400 (Bad Request)} if the sellDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sell-details")
    public ResponseEntity<SellDetailsDTO> createSellDetails(@Valid @RequestBody SellDetailsDTO sellDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save SellDetails : {}", sellDetailsDTO);
        if (sellDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new sellDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SellDetailsDTO result = sellDetailsService.save(sellDetailsDTO);
        return ResponseEntity
            .created(new URI("/api/sell-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sell-details/:id} : Updates an existing sellDetails.
     *
     * @param id the id of the sellDetailsDTO to save.
     * @param sellDetailsDTO the sellDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sellDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the sellDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sellDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sell-details/{id}")
    public ResponseEntity<SellDetailsDTO> updateSellDetails(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SellDetailsDTO sellDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update SellDetails : {}, {}", id, sellDetailsDTO);
        if (sellDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sellDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sellDetailsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SellDetailsDTO result = sellDetailsService.update(sellDetailsDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sellDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /sell-details/:id} : Partial updates given fields of an existing sellDetails, field will ignore if it is null
     *
     * @param id the id of the sellDetailsDTO to save.
     * @param sellDetailsDTO the sellDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sellDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the sellDetailsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the sellDetailsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the sellDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/sell-details/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SellDetailsDTO> partialUpdateSellDetails(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SellDetailsDTO sellDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update SellDetails partially : {}, {}", id, sellDetailsDTO);
        if (sellDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sellDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sellDetailsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SellDetailsDTO> result = sellDetailsService.partialUpdate(sellDetailsDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sellDetailsDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /sell-details} : get all the sellDetails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sellDetails in body.
     */
    @GetMapping("/sell-details")
    public List<SellDetailsDTO> getAllSellDetails() {
        log.debug("REST request to get all SellDetails");
        return sellDetailsService.findAll();
    }

    /**
     * {@code GET  /sell-details/:id} : get the "id" sellDetails.
     *
     * @param id the id of the sellDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sellDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sell-details/{id}")
    public ResponseEntity<SellDetailsDTO> getSellDetails(@PathVariable Long id) {
        log.debug("REST request to get SellDetails : {}", id);
        Optional<SellDetailsDTO> sellDetailsDTO = sellDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sellDetailsDTO);
    }

    /**
     * {@code DELETE  /sell-details/:id} : delete the "id" sellDetails.
     *
     * @param id the id of the sellDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sell-details/{id}")
    public ResponseEntity<Void> deleteSellDetails(@PathVariable Long id) {
        log.debug("REST request to delete SellDetails : {}", id);
        sellDetailsService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
