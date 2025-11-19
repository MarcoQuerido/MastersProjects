package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.BillingCompany;

/**
 * Spring Data JPA repository for the BillingCompany entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BillingCompanyRepository extends JpaRepository<BillingCompany, Long> {}
