package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.Costumer;

/**
 * Spring Data JPA repository for the Costumer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {}
