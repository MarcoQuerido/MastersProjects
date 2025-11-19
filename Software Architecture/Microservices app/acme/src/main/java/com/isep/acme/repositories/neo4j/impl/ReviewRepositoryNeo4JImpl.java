package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromReviewNeo4JToReview;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromReviewToReviewNeo4J;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.User;
import com.isep.acme.model.neo4j.ReviewNeo4J;
import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.neo4j.ReviewRepositoryNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Profile(ServiceUtils.NEO4J_PROFILE)
public class ReviewRepositoryNeo4JImpl implements ReviewRepository {

    @Autowired
    ReviewRepositoryNeo4J pRepo;

    @Override
    public Optional<List<Review>> findByProductId(final Product product) {

        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewNeo4J>> reviewNeo4JsOptional = pRepo.findByProductId(product.getProductID());

        if (reviewNeo4JsOptional.isPresent()) {
            List<ReviewNeo4J> reviewNeo4Js = reviewNeo4JsOptional.get();
            reviewNeo4Js.forEach(reviewNeo4J -> reviews.add(ConversionUtils.fromReviewNeo4JToReview(reviewNeo4J)));
        }

        return Optional.of(reviews);
    }

    @Override
    public Optional<List<Review>> findPendingReviews() {

        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewNeo4J>> reviewNeo4JsOptional = pRepo.findPendingReviews();

        if (reviewNeo4JsOptional.isPresent()) {
            List<ReviewNeo4J> reviewNeo4Js = reviewNeo4JsOptional.get();
            reviewNeo4Js.forEach(reviewNeo4J -> reviews.add(ConversionUtils.fromReviewNeo4JToReview(reviewNeo4J)));
        }

        return Optional.of(reviews);

    }

    @Override
    public Optional<List<Review>> findActiveReviews() {

        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewNeo4J>> reviewNeo4JsOptional = pRepo.findActiveReviews();

        if (reviewNeo4JsOptional.isPresent()) {
            List<ReviewNeo4J> reviewNeo4Js = reviewNeo4JsOptional.get();
            reviewNeo4Js.forEach(reviewNeo4J -> reviews.add(ConversionUtils.fromReviewNeo4JToReview(reviewNeo4J)));
        }

        return Optional.of(reviews);

    }

    @Override
    public Optional<List<Review>> findByProductIdStatus(final Product product, final String status) {

        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewNeo4J>> reviewNeo4JsOptional = pRepo.findByProductIdStatus(product.getProductID(), status);

        if (reviewNeo4JsOptional.isPresent()) {
            List<ReviewNeo4J> reviewNeo4Js = reviewNeo4JsOptional.get();
            reviewNeo4Js.forEach(reviewNeo4J -> reviews.add(ConversionUtils.fromReviewNeo4JToReview(reviewNeo4J)));
        }

        return Optional.of(reviews);
    }

    @Override
    public Optional<List<Review>> findByUserId(final User user) {
        List<Review> reviews = new ArrayList<>();
        Optional<List<ReviewNeo4J>> reviewNeo4JsOptional = pRepo.findByUserId(user.getUserId());

        if (reviewNeo4JsOptional.isPresent()) {
            List<ReviewNeo4J> reviewNeo4Js = reviewNeo4JsOptional.get();
            reviewNeo4Js.forEach(reviewNeo4J -> reviews.add(ConversionUtils.fromReviewNeo4JToReview(reviewNeo4J)));
        }

        return Optional.of(reviews);
    }

    @Override
    public Review save(final Review review) {
        ReviewNeo4J reviewNeo4J = fromReviewToReviewNeo4J(review);
        pRepo.save(reviewNeo4J);
        return review;
    }

    @Override
    public Optional<Review> findById(final Long reviewID) {
        Optional<ReviewNeo4J> reviewNeo4JOptional = pRepo.findById(reviewID);
        return reviewNeo4JOptional.map(ConversionUtils::fromReviewNeo4JToReview);
    }

    @Override
    public void delete(final Review r) {
        pRepo.delete(fromReviewToReviewNeo4J(r));
    }

    @Override
    public Iterable<Review> findAll() {
        Iterable<ReviewNeo4J> iterable = pRepo.findAll();
        List<Review> reviews = new ArrayList<>();

        for (ReviewNeo4J reviewNeo4J : iterable) {
            Review review = fromReviewNeo4JToReview(reviewNeo4J);
            reviews.add(review);
        }

        return reviews;
    }

    @Override
    public Optional<List<Review>> findReviewsWithAlgorithm1(double minUpvoteRatio, Integer minTotalVotes) {
        return Optional.empty();
    }
}
