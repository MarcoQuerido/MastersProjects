package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.SellStatusDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.SellStatus}.
 */
public interface SellStatusService {
    /**
     * Save a sellStatus.
     *
     * @param sellStatusDTO the entity to save.
     * @return the persisted entity.
     */
    SellStatusDTO save(SellStatusDTO sellStatusDTO);

    /**
     * Updates a sellStatus.
     *
     * @param sellStatusDTO the entity to update.
     * @return the persisted entity.
     */
    SellStatusDTO update(SellStatusDTO sellStatusDTO);

    /**
     * Partially updates a sellStatus.
     *
     * @param sellStatusDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SellStatusDTO> partialUpdate(SellStatusDTO sellStatusDTO);

    /**
     * Get all the sellStatuses.
     *
     * @return the list of entities.
     */
    List<SellStatusDTO> findAll();

    /**
     * Get the "id" sellStatus.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SellStatusDTO> findOne(Long id);

    /**
     * Delete the "id" sellStatus.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
