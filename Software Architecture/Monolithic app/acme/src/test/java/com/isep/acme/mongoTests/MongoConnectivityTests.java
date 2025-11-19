package com.isep.acme.mongoTests;

import com.isep.acme.repositories.repositories_MongoDB.UserRepositoryMongo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoConnectivityTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    UserRepositoryMongo userRepositoryMongo;

    @Test
    public void testDatabaseConnection() {
        assertNotNull(userRepositoryMongo);
    }

    @Test
    public void testApiEndpoint() {
        String response = restTemplate.getForObject("/api/some-endpoint", String.class);
        assertEquals("ExpectedResponse", response);
    }
}
