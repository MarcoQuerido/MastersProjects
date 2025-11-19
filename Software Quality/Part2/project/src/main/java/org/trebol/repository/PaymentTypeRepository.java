package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.PaymentType;

/**
 * Spring Data JPA repository for the PaymentType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {}
