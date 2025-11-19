package com.isep.acme.repositories.repositories_MongoDB;

import com.isep.acme.model.model_MongoDB.RatingMongo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

@Document(collection = "rating")
public interface RatingRepositoryMongo extends MongoRepository<RatingMongo, String> {

    Optional<RatingMongo> findByRate(Double rate);
}
