package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.*;
import com.isep.acme.model.mongoDB.*;

public class ConversionUtils {

    public static ProductMongo fromProductToProductMongo(Product product) {
        //return new ProductMongo(product.getProductID(), product.getSku(), product.getDesignation(), product.getDescription());
        return new ProductMongo(product.getSku(), product.getDesignation(), product.getDescription());
    }

    public static Product fromProductMongoToProduct(ProductMongo product) {
        return new Product(Long.parseLong(product.getProductID()), product.getSku(), product.getDesignation(), product.getDescription());
    }

    public static RatingMongo fromRatingToRatingMongo(Rating rating) {
        return new RatingMongo(rating.getRate());
    }

    public static Rating fromRatingMongoToRating(RatingMongo rating) {
        return new Rating(rating.getRate());
    }

    public static ProdImageMongo fromProdImageToProdImageMongo(ProdImage prodImage) {
        return new ProdImageMongo(fromProductToProductMongo(prodImage.getProduct()), new byte[1]);
    }

    public static ProdImage fromProdImageMongoToProdImage(ProdImageMongo prodImage) {
        return new ProdImage(fromProductMongoToProduct(prodImage.getProductMongo()), null);
    }

    public static AggregatedRatingMongo fromAggregatedRatingToAggregatedRatingMongo(AggregatedRating aggregatedRating) {
        return new AggregatedRatingMongo(Double.parseDouble(aggregatedRating.getAggregatedId().toString()),
                fromProductToProductMongo(aggregatedRating.getProduct()));
    }

    public static AggregatedRating fromAggregatedRatingMongoToAggregatedRating(AggregatedRatingMongo aggregatedRating) {
        return new AggregatedRating(aggregatedRating.getAverage(),
                fromProductMongoToProduct(aggregatedRating.getProductId()));
    }

    public static UserMongo fromUserToUserMongo(User user) {
        return new UserMongo(user.getUsername(), user.getPassword(), user.getFullName(), user.getNif(), user.getMorada());
    }

    public static User fromUserMongoToUser(UserMongo user) {
        return new User(user.getUsername(), user.getPassword(), user.getFullName(), user.getNif(), user.getMorada());
    }

    public static ReviewMongo fromReviewToReviewMongo(Review review) {
        return new ReviewMongo(review.getIdReview().toString(), review.getVersion(), review.getApprovalStatus(), review.getReviewText(),
                review.getUpVote(), review.getDownVote(), "report", review.getPublishingDate(), review.getFunFact(),
                fromProductToProductMongo(review.getProduct()), fromRatingToRatingMongo(review.getRating()),
                fromUserToUserMongo(review.getUser()));
    }

    public static Review fromReviewMongoToReview(ReviewMongo review) {
        return new Review(Long.parseLong(review.getIdReview()), review.getVersion(), review.getApprovalStatus(), review.getReviewText(),
                review.getUpVote(), review.getDownVote(), "report", review.getPublishingDate(), review.getFunFact(),
                fromProductMongoToProduct(review.getProduct()), fromRatingMongoToRating(review.getRating()),
                fromUserMongoToUser(review.getUser()));
    }
}
