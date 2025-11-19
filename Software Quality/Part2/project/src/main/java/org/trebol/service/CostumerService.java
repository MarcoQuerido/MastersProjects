package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.CostumerDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.Costumer}.
 */
public interface CostumerService {
    /**
     * Save a costumer.
     *
     * @param costumerDTO the entity to save.
     * @return the persisted entity.
     */
    CostumerDTO save(CostumerDTO costumerDTO);

    /**
     * Updates a costumer.
     *
     * @param costumerDTO the entity to update.
     * @return the persisted entity.
     */
    CostumerDTO update(CostumerDTO costumerDTO);

    /**
     * Partially updates a costumer.
     *
     * @param costumerDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CostumerDTO> partialUpdate(CostumerDTO costumerDTO);

    /**
     * Get all the costumers.
     *
     * @return the list of entities.
     */
    List<CostumerDTO> findAll();

    /**
     * Get the "id" costumer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CostumerDTO> findOne(Long id);

    /**
     * Delete the "id" costumer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
