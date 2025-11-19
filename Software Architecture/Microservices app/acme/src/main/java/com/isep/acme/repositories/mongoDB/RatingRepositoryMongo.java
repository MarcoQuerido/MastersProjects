package com.isep.acme.repositories.mongoDB;

import com.isep.acme.model.mongoDB.RatingMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Document(collection = "rating")
//@Repository
//@Profile(ServiceUtils.MONGO_DB_PROFILE)
public interface RatingRepositoryMongo extends MongoRepository<RatingMongo, String> {

    Optional<RatingMongo> findByRate(Double rate);
}
