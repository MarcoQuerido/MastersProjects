package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.SellDetailsDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.SellDetails}.
 */
public interface SellDetailsService {
    /**
     * Save a sellDetails.
     *
     * @param sellDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    SellDetailsDTO save(SellDetailsDTO sellDetailsDTO);

    /**
     * Updates a sellDetails.
     *
     * @param sellDetailsDTO the entity to update.
     * @return the persisted entity.
     */
    SellDetailsDTO update(SellDetailsDTO sellDetailsDTO);

    /**
     * Partially updates a sellDetails.
     *
     * @param sellDetailsDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SellDetailsDTO> partialUpdate(SellDetailsDTO sellDetailsDTO);

    /**
     * Get all the sellDetails.
     *
     * @return the list of entities.
     */
    List<SellDetailsDTO> findAll();

    /**
     * Get the "id" sellDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SellDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" sellDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
