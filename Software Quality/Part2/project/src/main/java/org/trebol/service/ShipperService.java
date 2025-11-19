package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.ShipperDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.Shipper}.
 */
public interface ShipperService {
    /**
     * Save a shipper.
     *
     * @param shipperDTO the entity to save.
     * @return the persisted entity.
     */
    ShipperDTO save(ShipperDTO shipperDTO);

    /**
     * Updates a shipper.
     *
     * @param shipperDTO the entity to update.
     * @return the persisted entity.
     */
    ShipperDTO update(ShipperDTO shipperDTO);

    /**
     * Partially updates a shipper.
     *
     * @param shipperDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ShipperDTO> partialUpdate(ShipperDTO shipperDTO);

    /**
     * Get all the shippers.
     *
     * @return the list of entities.
     */
    List<ShipperDTO> findAll();

    /**
     * Get the "id" shipper.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ShipperDTO> findOne(Long id);

    /**
     * Delete the "id" shipper.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
