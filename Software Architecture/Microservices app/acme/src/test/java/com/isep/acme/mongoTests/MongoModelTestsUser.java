package com.isep.acme.mongoTests;

import com.isep.acme.model.mongoDB.UserMongo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MongoModelTestsUser {

    @Test
    public void testInvalidUsernameCreation() {
        assertThrows(IllegalArgumentException.class, () -> new UserMongo("", "password123", "John Doe", "123456789", "123 Main St"));
    }

    @Test
    public void testInvalidPasswordCreation() {
        assertThrows(IllegalArgumentException.class, () -> new UserMongo("JohnDoe", "", "John Doe", "123456789", "123 Main St"));
    }

    @Test
    public void testInvalidFullNameCreation() {
        assertThrows(IllegalArgumentException.class, () -> new UserMongo("JohnDoe", "password123", "", "123456789", "123 Main St"));
    }

    @Test
    public void testInvalidAddressCreation() {
        assertThrows(IllegalArgumentException.class, () -> new UserMongo("JohnDoe", "password123", "John Doe", "123456789", ""));
    }
}
