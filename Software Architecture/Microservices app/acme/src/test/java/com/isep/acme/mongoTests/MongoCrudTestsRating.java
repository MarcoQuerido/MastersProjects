package com.isep.acme.mongoTests;

import com.isep.acme.model.mongoDB.RatingMongo;
import com.isep.acme.repositories.mongoDB.RatingRepositoryMongo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test") // Activate the test profile
public class MongoCrudTestsRating {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RatingRepositoryMongo ratingRepository;

    @BeforeEach
    public void setUp() {
        // Drop database collections for a fresh state for each test case
        mongoTemplate.dropCollection(RatingMongo.class);
    }

    @Test
    public void testSaveRating() {
        RatingMongo rating = new RatingMongo(4.4);
        RatingMongo savedRating = ratingRepository.save(rating);
        assertNotNull(savedRating);
        assertNotNull(savedRating.getIdRating());
    }

    @Test
    public void testFindById() {
        RatingMongo rating = new RatingMongo(4.1);
        RatingMongo savedRating = mongoTemplate.insert(rating);
        Optional<RatingMongo> foundRating = ratingRepository.findById(savedRating.getIdRating());
        assertTrue(foundRating.isPresent());
        assertEquals(savedRating.getIdRating(), foundRating.get().getIdRating());
    }

    @Test
    public void testFindByRate() {
        Double rate = 1.2;
        RatingMongo rating = new RatingMongo(1.2);
        mongoTemplate.insert(rating);
        Optional<RatingMongo> foundRating = ratingRepository.findByRate(rate);
        assertTrue(foundRating.isPresent());
        assertEquals(rate, foundRating.get().getRate());
    }

    @Test
    public void testUpdateRating() {
        RatingMongo rating = new RatingMongo(2.3);
        RatingMongo savedRating = mongoTemplate.insert(rating);
        savedRating.setRate(9.0);
        RatingMongo updatedRating = ratingRepository.save(savedRating);
        assertEquals(9.0, updatedRating.getRate());
    }

    @Test
    public void testDeleteRating() {
        RatingMongo rating = new RatingMongo(2.6);
        RatingMongo savedRating = mongoTemplate.insert(rating);
        ratingRepository.delete(savedRating);
        Optional<RatingMongo> deletedRating = ratingRepository.findById(savedRating.getIdRating());
        assertFalse(deletedRating.isPresent());
    }

    @Test
    public void testDeleteRatingById() {
        RatingMongo rating = new RatingMongo(5.0);
        RatingMongo savedRating = mongoTemplate.insert(rating);
        ratingRepository.deleteById(savedRating.getIdRating());
        Optional<RatingMongo> deletedRating = ratingRepository.findById(savedRating.getIdRating());
        assertFalse(deletedRating.isPresent());
    }

    @Test
    public void testDeleteAllRatings() {
        mongoTemplate.insert(new RatingMongo(9.0));
        mongoTemplate.insert(new RatingMongo(8.0));
        ratingRepository.deleteAll();
        List<RatingMongo> ratings = ratingRepository.findAll();
        assertTrue(ratings.isEmpty());
    }
}
