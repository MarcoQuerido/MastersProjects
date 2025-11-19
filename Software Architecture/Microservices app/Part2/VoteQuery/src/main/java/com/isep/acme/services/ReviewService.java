package com.isep.acme.services;

import com.isep.acme.model.Review;
import com.isep.acme.model.event.EventReviewDTO;

public interface ReviewService {

    Review addReview(Long reviewId, String reviewStatus, String voteId);

    Review updateReviewStatus(Long reviewId, String reviewStatus);

    void deleteReview(Long reviewId);

}
