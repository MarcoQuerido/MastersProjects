package com.isep.acme.mongoTests;

import com.isep.acme.model.mongoDB.UserMongo;
import com.isep.acme.repositories.mongoDB.UserRepositoryMongo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test") // Activate the test profile
public class MongoCrudTestsUser {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    UserRepositoryMongo userRepository;

    @BeforeEach
    void setUp() {
        mongoTemplate.dropCollection(UserMongo.class);
    }

    @Test
    void testCreateUser() {
        UserMongo user = new UserMongo("testuser", "password", "testuser", "123456789", "some address");
        user.setId("1");
        UserMongo savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
    }

    @Test
    void testReadUser() {
        UserMongo user = new UserMongo("testuser", "password", "testuser", "123456789", "some address");
        user.setId("2");
        UserMongo savedUser = userRepository.save(user);
        Optional<UserMongo> foundUser = userRepository.findById(savedUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals(savedUser.getUsername(), foundUser.get().getUsername());
    }

    @Test
    void testUpdateUser() {
        UserMongo user = new UserMongo("testuser", "password", "testuser", "123456789", "some address");
        user.setId("3");
        UserMongo savedUser = userRepository.save(user);
        savedUser.setFullname("updateduser");
        UserMongo updatedUser = userRepository.save(savedUser);
        assertEquals("updateduser", updatedUser.getFullName());
    }

    @Test
    void testDeleteUser() {
        UserMongo user = new UserMongo("testuser", "password", "testuser", "123456789", "some address");
        user.setId("4");
        UserMongo savedUser = userRepository.save(user);
        savedUser.setId("5");
        userRepository.delete(savedUser);
        Optional<UserMongo> deletedUser = userRepository.findById(savedUser.getId());
        assertFalse(deletedUser.isPresent());
    }

    @Test
    void testFindAllUsers() {
        UserMongo user = new UserMongo("testuser", "password", "testuser", "123456789", "some address");
        user.setId("6");
        userRepository.save(user);
        UserMongo anotherUser = new UserMongo("testuser2", "password", "testuser", "123456789", "some address");
        anotherUser.setId("7");
        anotherUser.setUsername("testuser");
        anotherUser.setPassword("password");
        anotherUser.setNif("123456789");
        anotherUser.setMorada("Some address");
        userRepository.save(anotherUser);

        List<UserMongo> users = userRepository.findAll();
        assertTrue(users.size() >= 2);
    }

    @Test
    void testFindByUsername() {
        UserMongo user = new UserMongo("testuser", "password", "testuser", "123456789", "some address");
        user.setId("8");
        userRepository.save(user);
        Optional<UserMongo> foundUser = userRepository.findByUsername(user.getUsername());
        assertTrue(foundUser.isPresent());
        assertEquals(user.getUsername(), foundUser.get().getUsername());
    }
}
