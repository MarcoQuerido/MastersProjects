package com.isep.acme.services;

import com.isep.acme.model.*;

import java.util.List;

public interface ReviewService {

    Review addReview(ReviewDTO reviewDTO);

    Review moderateReview(Long reviewID, String approved);

    void deleteReview(Long reviewId);

    List<ReviewDTO> getReviewsOfProduct(String sku, String status);

    List<ReviewDTO> findPendingReview();

    List<ReviewDTO> findReviewsByUser(Long userID);

    Review addVoteToReview(String id, String voteStr, Long user, Long reviewId);


}
