package com.isep.acme.repositories.neo4j;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.isep.acme.model.neo4j.AggregatedRatingNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public interface AggregatedRatingRepositoryNeo4J extends Neo4jRepository<AggregatedRatingNeo4J, Long> {

    @Query("MATCH (a:AggregatedRating)-[:AGGREGATES]->(p:Product {productId: $productId}) " +
            "RETURN a")
    Optional<AggregatedRatingNeo4J> findByProductId(Long productId);

}
