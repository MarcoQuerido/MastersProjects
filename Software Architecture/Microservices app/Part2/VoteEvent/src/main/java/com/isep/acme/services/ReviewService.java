package com.isep.acme.services;

import com.isep.acme.model.Review;
import com.isep.acme.model.ReviewDTO;
import com.isep.acme.model.event.EventReviewDTO;

import java.util.List;

public interface ReviewService {

    Review addReview(Long reviewId, String reviewStatus, String voteId);

    Review updateReviewStatus(Long reviewId, String reviewStatus);

    void deleteReview(Long reviewId);

    List<ReviewDTO> getReviews();

}
