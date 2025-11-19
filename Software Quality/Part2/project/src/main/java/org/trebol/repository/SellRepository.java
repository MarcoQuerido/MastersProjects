package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.Sell;

/**
 * Spring Data JPA repository for the Sell entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {}
