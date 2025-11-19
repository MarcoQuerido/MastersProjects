package com.isep.acme.services;

import com.isep.acme.model.*;

public interface ReviewService {

    Review addReview(ReviewDTO reviewDTO);

    Review createAndPublish(CreateReviewDTO createReviewDTO, String sku);

    Review moderateReview(Long reviewID, String approved);

    Review moderateReviewAndPublish(Long reviewID, String approved);

    void deleteReview(Long reviewId);

    void deleteReviewAndPublish(Long reviewId);

    Review addVoteToReview(String id, String voteStr, Long user, Long reviewId);

    Review createWithVoteAndPublish(final CreateReviewDTO createReviewDTO, String sku, String voteStr, String voteId);

}
