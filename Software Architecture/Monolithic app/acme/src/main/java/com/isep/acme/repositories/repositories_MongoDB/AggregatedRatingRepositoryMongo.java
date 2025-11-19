package com.isep.acme.repositories.repositories_MongoDB;

import com.isep.acme.model.model_MongoDB.AggregatedRatingMongo;
import com.isep.acme.model.model_MongoDB.ProductMongo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Document(collection = "aggregatedRating")
public interface AggregatedRatingRepositoryMongo extends MongoRepository<AggregatedRatingMongo, String> {
    Optional<AggregatedRatingMongo> findByProduct(ProductMongo product);
}
