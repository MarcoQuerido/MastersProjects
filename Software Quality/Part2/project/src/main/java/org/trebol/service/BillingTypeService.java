package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.BillingTypeDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.BillingType}.
 */
public interface BillingTypeService {
    /**
     * Save a billingType.
     *
     * @param billingTypeDTO the entity to save.
     * @return the persisted entity.
     */
    BillingTypeDTO save(BillingTypeDTO billingTypeDTO);

    /**
     * Updates a billingType.
     *
     * @param billingTypeDTO the entity to update.
     * @return the persisted entity.
     */
    BillingTypeDTO update(BillingTypeDTO billingTypeDTO);

    /**
     * Partially updates a billingType.
     *
     * @param billingTypeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BillingTypeDTO> partialUpdate(BillingTypeDTO billingTypeDTO);

    /**
     * Get all the billingTypes.
     *
     * @return the list of entities.
     */
    List<BillingTypeDTO> findAll();

    /**
     * Get the "id" billingType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BillingTypeDTO> findOne(Long id);

    /**
     * Delete the "id" billingType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
