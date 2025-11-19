package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.SalespersonDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.Salesperson}.
 */
public interface SalespersonService {
    /**
     * Save a salesperson.
     *
     * @param salespersonDTO the entity to save.
     * @return the persisted entity.
     */
    SalespersonDTO save(SalespersonDTO salespersonDTO);

    /**
     * Updates a salesperson.
     *
     * @param salespersonDTO the entity to update.
     * @return the persisted entity.
     */
    SalespersonDTO update(SalespersonDTO salespersonDTO);

    /**
     * Partially updates a salesperson.
     *
     * @param salespersonDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SalespersonDTO> partialUpdate(SalespersonDTO salespersonDTO);

    /**
     * Get all the salespeople.
     *
     * @return the list of entities.
     */
    List<SalespersonDTO> findAll();

    /**
     * Get the "id" salesperson.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SalespersonDTO> findOne(Long id);

    /**
     * Delete the "id" salesperson.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
