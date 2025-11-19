package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.Salesperson;

/**
 * Spring Data JPA repository for the Salesperson entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {}
