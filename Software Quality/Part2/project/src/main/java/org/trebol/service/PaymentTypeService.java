package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.PaymentTypeDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.PaymentType}.
 */
public interface PaymentTypeService {
    /**
     * Save a paymentType.
     *
     * @param paymentTypeDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentTypeDTO save(PaymentTypeDTO paymentTypeDTO);

    /**
     * Updates a paymentType.
     *
     * @param paymentTypeDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentTypeDTO update(PaymentTypeDTO paymentTypeDTO);

    /**
     * Partially updates a paymentType.
     *
     * @param paymentTypeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentTypeDTO> partialUpdate(PaymentTypeDTO paymentTypeDTO);

    /**
     * Get all the paymentTypes.
     *
     * @return the list of entities.
     */
    List<PaymentTypeDTO> findAll();

    /**
     * Get the "id" paymentType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTypeDTO> findOne(Long id);

    /**
     * Delete the "id" paymentType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
