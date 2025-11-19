package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.SellStatus;

/**
 * Spring Data JPA repository for the SellStatus entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SellStatusRepository extends JpaRepository<SellStatus, Long> {}
