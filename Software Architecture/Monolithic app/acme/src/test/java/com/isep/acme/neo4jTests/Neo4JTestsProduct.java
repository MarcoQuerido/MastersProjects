package com.isep.acme.neo4jTests;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;

import com.isep.acme.SkuGenerator1;
import com.isep.acme.model.Product;
import com.isep.acme.model.neo4j.ProductNeo4J;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.neo4j.ProductRepositoryNeo4J;

@DataNeo4jTest
@TestPropertySource(locations = { "classpath:./config/.env_neo" })
public class Neo4JTestsProduct {


    @Autowired
    ProductRepository productRepositoryNeo4J;


//    @BeforeEach
//    public void setUp() {
//        // Drop database collections for a fresh state for each test case
//        productRepositoryNeo4J.deleteAll(ProductNeo4J.class);
//    }

    @Test
    public void testFindProductById() {
        // Create a new product
//        Product product2 = new Product(1L, "k485b1l47h5b", "Produto1", "um produto");
//        product2 = productRepositoryNeo4J.save(product2);
//
//        // Find the product by ID
//        Product foundProduct = productRepositoryNeo4J.findById(product2.getProductID()).orElse(null);
//
//        // Check if the product was found
//        assertNotNull(foundProduct);
//        assertEquals(product2.getDesignation(), foundProduct.getDesignation());
    }

}
