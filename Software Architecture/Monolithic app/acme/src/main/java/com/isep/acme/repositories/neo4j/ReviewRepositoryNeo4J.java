package com.isep.acme.repositories.neo4j;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.isep.acme.model.neo4j.ReviewNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public interface ReviewRepositoryNeo4J extends Neo4jRepository<ReviewNeo4J, Long> {

    //Optional<Review> findById(Long productId);
    @Query("MATCH (r:Review)-[:REVIEWS_PRODUCT]->(p:Product {productId: $productId}) " +
            "RETURN r ORDER BY r.publishingDate DESC")
    Optional<List<ReviewNeo4J>> findByProductId(Long productId);

    @Query("MATCH (r:Review) WHERE r.approvalStatus='pending' " +
            "RETURN r")
    Optional<List<ReviewNeo4J>> findPendingReviews();

    @Query("MATCH (r:Review) WHERE r.approvalStatus='active' " +
            "RETURN r")
    Optional<List<ReviewNeo4J>> findActiveReviews();

    @Query("MATCH (r:Review)-[:REVIEWS_PRODUCT]->(p:Product {productId: $productId}) " +
            "WHERE r.approvalStatus=$status " +
            "RETURN r ORDER BY r.publishingDate DESC")
    Optional<List<ReviewNeo4J>> findByProductIdStatus(Long productId, String status);

    @Query("MATCH (r:Review)-[:WRITTEN_BY]->(u:User {userId: $userId}) " +
            "RETURN r ORDER BY r.publishingDate DESC")
    Optional<List<ReviewNeo4J>> findByUserId(Long userId);
}
