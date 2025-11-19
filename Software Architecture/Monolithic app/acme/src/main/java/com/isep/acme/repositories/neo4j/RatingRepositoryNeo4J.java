package com.isep.acme.repositories.neo4j;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.isep.acme.model.neo4j.RatingNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public interface RatingRepositoryNeo4J extends Neo4jRepository<RatingNeo4J, Long> {

    @Query("MATCH (r:Rating {rate: $rate}) RETURN r")
    Optional<RatingNeo4J> findByRate(Double rate);

}
