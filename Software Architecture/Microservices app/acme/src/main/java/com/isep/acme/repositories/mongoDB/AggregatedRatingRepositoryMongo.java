package com.isep.acme.repositories.mongoDB;

import com.isep.acme.model.mongoDB.AggregatedRatingMongo;
import com.isep.acme.model.mongoDB.ProductMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Document(collection = "aggregatedRating")
//@Repository
//@Profile(ServiceUtils.MONGO_DB_PROFILE)
public interface AggregatedRatingRepositoryMongo extends MongoRepository<AggregatedRatingMongo, String> {
    Optional<AggregatedRatingMongo> findByProduct(ProductMongo product);
    Optional<AggregatedRatingMongo> findByProductID(String product);
    Optional<AggregatedRatingMongo> findByProduct_ProductID(String productID);
}
