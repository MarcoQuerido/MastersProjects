package org.trebol.service;

import java.util.List;
import java.util.Optional;
import org.trebol.service.dto.BillingCompanyDTO;

/**
 * Service Interface for managing {@link org.trebol.domain.BillingCompany}.
 */
public interface BillingCompanyService {
    /**
     * Save a billingCompany.
     *
     * @param billingCompanyDTO the entity to save.
     * @return the persisted entity.
     */
    BillingCompanyDTO save(BillingCompanyDTO billingCompanyDTO);

    /**
     * Updates a billingCompany.
     *
     * @param billingCompanyDTO the entity to update.
     * @return the persisted entity.
     */
    BillingCompanyDTO update(BillingCompanyDTO billingCompanyDTO);

    /**
     * Partially updates a billingCompany.
     *
     * @param billingCompanyDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BillingCompanyDTO> partialUpdate(BillingCompanyDTO billingCompanyDTO);

    /**
     * Get all the billingCompanies.
     *
     * @return the list of entities.
     */
    List<BillingCompanyDTO> findAll();

    /**
     * Get the "id" billingCompany.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BillingCompanyDTO> findOne(Long id);

    /**
     * Delete the "id" billingCompany.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
