package com.isep.acme.services;

import com.isep.acme.model.*;

import java.util.List;

public interface ReviewService {

    Review addReview(ReviewDTO reviewDTO);

    Review create(CreateReviewDTO createReviewDTO, String sku);

    Review moderateReview(Long reviewID, String approved);

    void deleteReview(Long reviewId);

    Review addVoteToReview(String id, String voteStr, Long user, Long reviewId);

    List<ReviewDTO> getReviews();

}
