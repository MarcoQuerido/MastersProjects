package com.isep.acme.repositories.neo4j.impl;

import javax.annotation.Resource;

import com.isep.acme.model.AggregatedRating;
import com.isep.acme.model.ProdImage;
import com.isep.acme.model.Product;
import com.isep.acme.model.Rating;
import com.isep.acme.model.Review;
import com.isep.acme.model.User;
import com.isep.acme.model.neo4j.AggregatedRatingNeo4J;
import com.isep.acme.model.neo4j.ProdImageNeo4J;
import com.isep.acme.model.neo4j.ProductNeo4J;
import com.isep.acme.model.neo4j.RatingNeo4J;
import com.isep.acme.model.neo4j.ReviewNeo4J;
import com.isep.acme.model.neo4j.UserNeo4J;
import com.isep.acme.repositories.neo4j.AggregatedRatingRepositoryNeo4J;

public class ConversionUtils {

    public static User fromUserNeo4JToUser(UserNeo4J user) {
        return new User(user.getUsername(), user.getPassword(), user.getFullName(), user.getNif(), user.getMorada());
    }

    public static ProductNeo4J fromProductToProductNeo4J(Product product) {
        return new ProductNeo4J(product.getProductID(), product.getSku(), product.getDesignation(), product.getDescription());
    }

    public static Product fromProductNeo4JToProduct(ProductNeo4J product) {
        return new Product(product.getProductID(), product.getSku(), product.getDesignation(), product.getDescription());
    }

    public static RatingNeo4J fromRatingToRatingNeo4J(Rating rating) {
        return new RatingNeo4J(rating.getRate());
    }

    public static Rating fromRatingNeo4JToRating(RatingNeo4J rating) {
        return new Rating(rating.getRate());
    }

    public static ProdImageNeo4J fromProdImageToProdImageNeo4J(ProdImage prodImage) {
        return new ProdImageNeo4J(fromProductToProductNeo4J(prodImage.getProduct()), new byte[1]);
    }

    public static ProdImage fromProdImageNeo4JToProdImage(ProdImageNeo4J prodImage) {
        return new ProdImage(fromProductNeo4JToProduct(prodImage.getProductNeo4J()), null);
    }

    public static AggregatedRatingNeo4J fromAggregatedRatingToAggregatedRatingNeo4J(AggregatedRating aggregatedRating) {
        return new AggregatedRatingNeo4J(aggregatedRating.getAggregatedId(),
                fromProductToProductNeo4J(aggregatedRating.getProduct()));
    }
    public static AggregatedRating fromAggregatedRatingToAggregatedRatingNeo4J(AggregatedRatingNeo4J aggregatedRating) {
        return new AggregatedRating(aggregatedRating.getAggregatedId(),
                fromProductNeo4JToProduct(aggregatedRating.getProductId()));
    }

    public static UserNeo4J fromUserToUserNeo4J(User user) {
        return new UserNeo4J(user.getUsername(), user.getPassword(), user.getFullName(), user.getNif(), user.getMorada());
    }

    public static ReviewNeo4J fromReviewToReviewNeo4J(Review review) {
        return new ReviewNeo4J(review.getIdReview(), review.getVersion(), review.getApprovalStatus(), review.getReviewText(),
                review.getUpVote(), review.getDownVote(), "report", review.getPublishingDate(), review.getFunFact(),
                fromProductToProductNeo4J(review.getProduct()), fromRatingToRatingNeo4J(review.getRating()),
                fromUserToUserNeo4J(review.getUser()));
    }

    public static Review fromReviewNeo4JToReview(ReviewNeo4J review) {
        return new Review(review.getIdReview(), review.getVersion(), review.getApprovalStatus(), review.getReviewText(),
                review.getUpVote(), review.getDownVote(), "report", review.getPublishingDate(), review.getFunFact(),
                fromProductNeo4JToProduct(review.getProduct()), fromRatingNeo4JToRating(review.getRating()),
                fromUserNeo4JToUser(review.getUser()));
    }

}
