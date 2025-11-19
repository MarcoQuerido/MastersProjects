package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.SellDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.Sell}.
 */
public interface SellService {
    /**
     * Save a sell.
     *
     * @param sellDTO the entity to save.
     * @return the persisted entity.
     */
    SellDTO save(SellDTO sellDTO);

    /**
     * Updates a sell.
     *
     * @param sellDTO the entity to update.
     * @return the persisted entity.
     */
    SellDTO update(SellDTO sellDTO);

    /**
     * Partially updates a sell.
     *
     * @param sellDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SellDTO> partialUpdate(SellDTO sellDTO);

    /**
     * Get all the sells.
     *
     * @return the list of entities.
     */
    List<SellDTO> findAll();

    /**
     * Get the "id" sell.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SellDTO> findOne(Long id);

    /**
     * Delete the "id" sell.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
