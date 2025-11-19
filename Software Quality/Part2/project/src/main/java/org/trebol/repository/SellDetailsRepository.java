package org.trebol.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.trebol.domain.SellDetails;

/**
 * Spring Data JPA repository for the SellDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SellDetailsRepository extends JpaRepository<SellDetails, Long> {}
