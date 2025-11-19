package com.isep.acme.mongoTests;

import com.isep.acme.model.mongoDB.RatingMongo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MongoModelTestsRating {

    @Test
    public void testInvalidRatingCreationWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> new RatingMongo(null));
    }
}
