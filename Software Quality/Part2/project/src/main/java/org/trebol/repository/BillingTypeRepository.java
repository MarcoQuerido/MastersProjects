package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.BillingType;

/**
 * Spring Data JPA repository for the BillingType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BillingTypeRepository extends JpaRepository<BillingType, Long> {}
