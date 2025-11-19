package com.isep.acme.repositories.repositories_MongoDB;

import com.isep.acme.model.model_MongoDB.ProductMongo;
import com.isep.acme.model.model_MongoDB.ReviewMongo;
import com.isep.acme.model.model_MongoDB.UserMongo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Document(collection = "review")
public interface ReviewRepositoryMongo extends MongoRepository<ReviewMongo, String> {

    Optional<List<ReviewMongo>> findByProduct(ProductMongo product);

    Optional<List<ReviewMongo>> findByApprovalStatus(String status);

    Optional<List<ReviewMongo>> findByProductAndApprovalStatus(ProductMongo product, String status);

    Optional<List<ReviewMongo>> findByUser(UserMongo userId);

    @Query("SELECT r FROM ReviewMongo r WHERE r IN :reviews")
    Optional<List<ReviewMongo>> getRecommendedReviews(@Param("reviews") List<ReviewMongo> reviews);

}
