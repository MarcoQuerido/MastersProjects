package com.isep.acme.repositories.neo4j;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isep.acme.model.neo4j.ProductNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public interface ProductRepositoryNeo4J extends Neo4jRepository<ProductNeo4J, Long> {
    List<ProductNeo4J> findByDesignation(String designation);

    Optional<ProductNeo4J> findBySku(String sku);

    @Query("MATCH (p:Product) RETURN p.sku AS {sku: $sku}, p.designation AS {designation: $designation}")
    Optional<ProductNeo4J> getCatalog(String sku, String designation);

    @Query("MATCH (p:Product) RETURN p.sku AS sku, p.designation AS designation, p.description AS description")
    List<ProductNeo4J> getDetails();

    @Transactional
    @Query("MATCH (p:Product {sku: $sku}) DETACH DELETE p")
    void deleteBySku(String sku);

    @Transactional
    @Query("MATCH (p:Product {sku: $sku}) SET p.sku = $newSku RETURN p")
    ProductNeo4J updateBySku(String sku, String newSku);

    /*  @Query("SELECT p FROM ProdImage p WHERE p.id=:id")
      Optional<Product> findById(Long  id); */

}

