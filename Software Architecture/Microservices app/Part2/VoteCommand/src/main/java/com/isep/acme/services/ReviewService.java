package com.isep.acme.services;

import com.isep.acme.model.Review;

public interface ReviewService {

    Review addReview(Long reviewId, String reviewStatus, String voteId);

    Review updateReviewStatus(Long reviewId, String reviewStatus);

    void deleteReview(Long reviewId);

}
