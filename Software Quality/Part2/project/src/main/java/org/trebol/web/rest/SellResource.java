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
import org.trebol.repository.SellRepository;
import org.trebol.service.SellService;
import org.trebol.service.dto.SellDTO;
import org.trebol.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.trebol.domain.Sell}.
 */
@RestController
@RequestMapping("/api")
public class SellResource {

    private final Logger log = LoggerFactory.getLogger(SellResource.class);

    private static final String ENTITY_NAME = "sell";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SellService sellService;

    private final SellRepository sellRepository;

    public SellResource(SellService sellService, SellRepository sellRepository) {
        this.sellService = sellService;
        this.sellRepository = sellRepository;
    }

    /**
     * {@code POST  /sells} : Create a new sell.
     *
     * @param sellDTO the sellDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sellDTO, or with status {@code 400 (Bad Request)} if the sell has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sells")
    public ResponseEntity<SellDTO> createSell(@Valid @RequestBody SellDTO sellDTO) throws URISyntaxException {
        log.debug("REST request to save Sell : {}", sellDTO);
        if (sellDTO.getId() != null) {
            throw new BadRequestAlertException("A new sell cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SellDTO result = sellService.save(sellDTO);
        return ResponseEntity
            .created(new URI("/api/sells/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sells/:id} : Updates an existing sell.
     *
     * @param id the id of the sellDTO to save.
     * @param sellDTO the sellDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sellDTO,
     * or with status {@code 400 (Bad Request)} if the sellDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sellDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sells/{id}")
    public ResponseEntity<SellDTO> updateSell(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SellDTO sellDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Sell : {}, {}", id, sellDTO);
        if (sellDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sellDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sellRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SellDTO result = sellService.update(sellDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sellDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /sells/:id} : Partial updates given fields of an existing sell, field will ignore if it is null
     *
     * @param id the id of the sellDTO to save.
     * @param sellDTO the sellDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sellDTO,
     * or with status {@code 400 (Bad Request)} if the sellDTO is not valid,
     * or with status {@code 404 (Not Found)} if the sellDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the sellDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/sells/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SellDTO> partialUpdateSell(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SellDTO sellDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Sell partially : {}, {}", id, sellDTO);
        if (sellDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, sellDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!sellRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SellDTO> result = sellService.partialUpdate(sellDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sellDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /sells} : get all the sells.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sells in body.
     */
    @GetMapping("/sells")
    public List<SellDTO> getAllSells() {
        log.debug("REST request to get all Sells");
        return sellService.findAll();
    }

    /**
     * {@code GET  /sells/:id} : get the "id" sell.
     *
     * @param id the id of the sellDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sellDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sells/{id}")
    public ResponseEntity<SellDTO> getSell(@PathVariable Long id) {
        log.debug("REST request to get Sell : {}", id);
        Optional<SellDTO> sellDTO = sellService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sellDTO);
    }

    /**
     * {@code DELETE  /sells/:id} : delete the "id" sell.
     *
     * @param id the id of the sellDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sells/{id}")
    public ResponseEntity<Void> deleteSell(@PathVariable Long id) {
        log.debug("REST request to delete Sell : {}", id);
        sellService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
