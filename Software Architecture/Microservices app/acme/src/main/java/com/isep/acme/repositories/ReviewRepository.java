package com.isep.acme.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.User;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository{

    //Optional<Review> findById(Long productId);

    @Query("SELECT r FROM Review r WHERE r.product=:product ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByProductId(Product product);


    @Query("SELECT r FROM Review r WHERE r.approvalStatus='pending'")
    Optional<List<Review>> findPendingReviews();

    @Query("SELECT r FROM Review r WHERE r.approvalStatus='active'")
    Optional<List<Review>> findActiveReviews();

    @Query("SELECT r FROM Review r WHERE r.product=:product AND r.approvalStatus=:status ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByProductIdStatus(Product product, String status);

    @Query("SELECT r FROM Review r WHERE r.user=:user ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByUserId(User user);

    Review save(Review review);

    Optional<Review> findById(Long reviewID);

    void delete(Review r);

    Iterable<Review> findAll();

    @Query("SELECT r " +
            "FROM Reviews r " +
            "WHERE (SIZE(r.upVote) * 1.0) / (SIZE(r.upVote) + SIZE(r.downVote))  >= :minUpvoteRatio " +
            "AND (SIZE(r.upVote) + SIZE(r.downVote)) >= :minTotalVotes " +
            "ORDER BY SIZE(r.upVote) DESC")
    Optional<List<Review>> findReviewsWithAlgorithm1(double minUpvoteRatio, Integer minTotalVotes);

}
