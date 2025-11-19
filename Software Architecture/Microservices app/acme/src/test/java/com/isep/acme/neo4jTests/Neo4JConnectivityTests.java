package com.isep.acme.neo4jTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import com.isep.acme.repositories.neo4j.UserRepositoryNeo4J;

@DataNeo4jTest
@TestPropertySource(locations = { "classpath:./config/.env_neo" })
@ComponentScan("com.isep.acme.repositories.neo4j")
public class Neo4JConnectivityTests {

    @Autowired
    UserRepositoryNeo4J userRepositoryNeo4J;

    @Test
    public void testDatabaseConnection() {
        assertNotNull(userRepositoryNeo4J);
    }

    @Test
    public void testApiEndpoint() {
//        String response = restTemplate.getForObject("/api/some-endpoint", String.class);
//        assertEquals("ExpectedResponse", response);
    }
}
