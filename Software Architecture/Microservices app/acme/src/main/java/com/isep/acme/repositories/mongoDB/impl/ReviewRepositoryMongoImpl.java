package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.User;
import com.isep.acme.model.mongoDB.ReviewMongo;
import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.mongoDB.ReviewRepositoryMongo;
import com.isep.acme.utils.ServiceUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile(ServiceUtils.MONGO_DB_PROFILE)
public class ReviewRepositoryMongoImpl implements ReviewRepository {

    @Autowired
    ReviewRepositoryMongo repo;

    @Override
    public Optional<List<Review>> findByProductId(Product product) {
        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewMongo>> optional = repo.findByProductId(product.getProductID().toString());

        if (optional.isPresent()) {
            List<ReviewMongo> reviewM = optional.get();
            reviewM.forEach(reviewMongo -> reviews.add(ConversionUtils.fromReviewMongoToReview(reviewMongo)));
        }

        return Optional.of(reviews);
    }

    @Override
    public Optional<List<Review>> findPendingReviews() {
        List<ReviewMongo> pendingReviewMongoList = repo.findByStatus("PENDING");
        List<Review> pendingReviewList = pendingReviewMongoList.stream()
                .map(ConversionUtils::fromReviewMongoToReview)
                .collect(Collectors.toList());
        return Optional.of(pendingReviewList);
    }

    @Override
    public Optional<List<Review>> findActiveReviews() {
        List<ReviewMongo> activeReviewMongoList = repo.findByStatus("ACTIVE");
        List<Review> activeReviewList = activeReviewMongoList.stream()
                .map(ConversionUtils::fromReviewMongoToReview)
                .collect(Collectors.toList());
        return Optional.of(activeReviewList);
    }

    @Override
    public Optional<List<Review>> findByProductIdStatus(Product product, String status) {
        List<ReviewMongo> reviewMongoList = repo.findByProductIdAndStatus(product.getProductID().toString(), status);
        List<Review> reviewList = reviewMongoList.stream()
                .map(ConversionUtils::fromReviewMongoToReview)
                .collect(Collectors.toList());
        return Optional.of(reviewList);
    }

    @Override
    public Optional<List<Review>> findByUserId(User user) {
        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewMongo>> optional = repo.findByUserID(user.getUserId().toString());

        if (optional.isPresent()) {
            List<ReviewMongo> reviewMongoList = optional.get();
            reviewMongoList.forEach(reviewMongo -> reviews.add(ConversionUtils.fromReviewMongoToReview(reviewMongo)));
        }

        return Optional.of(reviews);
    }

    @Override
    public Review save(Review review) {
        ReviewMongo reviewMongo = repo.save(ConversionUtils.fromReviewToReviewMongo(review));
        return ConversionUtils.fromReviewMongoToReview(reviewMongo);
    }

    @Override
    public Optional<Review> findById(Long reviewID) {
        Optional<ReviewMongo> optional = repo.findById(reviewID.toString());
        return optional.map(ConversionUtils::fromReviewMongoToReview);
    }

    @Override
    public void delete(Review r) {
        repo.delete(ConversionUtils.fromReviewToReviewMongo(r));
    }

    @Override
    public Iterable<Review> findAll() {
        Iterable<ReviewMongo> iterable = repo.findAll();
        List<Review> reviews = new ArrayList<>();

        for (ReviewMongo reviewMongo : iterable) {
            Review review = ConversionUtils.fromReviewMongoToReview(reviewMongo);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Optional<List<Review>> findReviewsWithAlgorithm1(double minUpvoteRatio, Integer minTotalVotes) {
        Sort sort = Sort.by(Sort.Order.desc("upVote.size"));
        Optional<List<ReviewMongo>> listOptional = repo.findReviewsWithAlgorithm1(minUpvoteRatio, minTotalVotes, sort);
        return listOptional.map(reviews -> reviews.stream().map(ConversionUtils::fromReviewMongoToReview).collect(Collectors.toList()));
    }
}
