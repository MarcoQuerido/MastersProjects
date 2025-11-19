package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.Shipper;

/**
 * Spring Data JPA repository for the Shipper entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {}
