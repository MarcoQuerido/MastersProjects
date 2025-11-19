package com.isep.acme.repositories.mongoDB;

import com.isep.acme.model.mongoDB.ReviewMongo;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//@Document(collection = "review")
//@Repository
//@Profile(ServiceUtils.MONGO_DB_PROFILE)
public interface ReviewRepositoryMongo extends MongoRepository<ReviewMongo, String> {

    Optional<List<ReviewMongo>> findByProduct(String productID);

    @Query("{'approval_status':'pending'}")
    Optional<List<ReviewMongo>> findByApprovalStatus(String status);

    @Query("{ 'product.$id': ?0, 'status': ?1 }")
    Optional<List<ReviewMongo>> findByProductIdAndApprovalStatus(String productID, String status);

    Optional<List<ReviewMongo>> findByUserID(String userId);

    @Query("SELECT r FROM ReviewMongo r WHERE r IN :reviews")
    Optional<List<ReviewMongo>> getRecommendedReviews(@Param("reviews") List<ReviewMongo> reviews);

    @Query("{ 'upvoteRatio': { $gte: ?0 }, 'totalVotes': { $gte: ?1 } }")
    Optional<List<ReviewMongo>> findReviewsWithAlgorithm1(double minUpvoteRatio, Integer minTotalVotes, Sort sort);

    @Query("{'approval_status':'pending'}")
    List<ReviewMongo> findByStatus(String active);

    Optional<List<ReviewMongo>> findByProductId(String productID);

    List<ReviewMongo> findByProductIdAndStatus(String productID, String status);
}
