package com.isep.acme.services;

import com.isep.acme.model.Review;
import com.isep.acme.model.ReviewDTO;
import com.isep.acme.model.TemporaryVote;
import com.isep.acme.model.Vote;
import com.isep.acme.model.event.EventReviewDTO;
import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.TemporaryVoteRepository;
import com.isep.acme.repositories.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private TemporaryVoteRepository temporaryVoteRepository;

    @Override
    public Review addReview(Long reviewId, String reviewStatus, String voteId) {
        Optional<Review> existingReview = reviewRepository.findById(reviewId);

        if (existingReview.isPresent())
            throw new IllegalArgumentException(String.format("Review with %d already exists", reviewId));

        Review review = new Review(reviewId, reviewStatus);
        Review savedReview = reviewRepository.save(review);

        if (voteId != null) {
            Optional<TemporaryVote> temporaryVoteOpt = temporaryVoteRepository.findById(voteId);

            if (temporaryVoteOpt.isEmpty())
                throw new IllegalArgumentException(
                        String.format("TemporaryVote with id %s not found", voteId)
                );

            TemporaryVote temporaryVote = temporaryVoteOpt.get();

            Vote vote = new Vote(temporaryVote.getId(), temporaryVote.getVote(), temporaryVote.getUser(), review);

            voteRepository.save(vote);
            temporaryVoteRepository.delete(temporaryVote);
        }

        return savedReview;
    }

    @Override
    public Review updateReviewStatus(Long reviewId, String reviewStatus) {
        Optional<Review> existingReviewOpt = reviewRepository.findById(reviewId);

        if (existingReviewOpt.isEmpty())
            throw new IllegalArgumentException(String.format("Review with %d does not exist", reviewId));

        Review review = existingReviewOpt.get();

        review.setReviewStatus(reviewStatus);
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId) {
        Optional<Review> reviewToBeDeletedOpt = reviewRepository.findById(reviewId);
        if (reviewToBeDeletedOpt.isEmpty())
            throw new IllegalArgumentException(String.format("Unable to find review with id %d to delete", reviewId));

        Review reviewToBeDeleted = reviewToBeDeletedOpt.get();
        List<Vote> reviewVotes = voteRepository.findAllByReview(reviewToBeDeleted);

        voteRepository.deleteAll(reviewVotes);

        reviewRepository.delete(reviewToBeDeleted);
    }

    @Override
    @Transactional
    public List<ReviewDTO> getReviews() {

        Iterable<Review> reviewsIt = reviewRepository.findAll();
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review r : reviewsIt) {
            reviewDTOs.add(r.toDto());
        }

        return reviewDTOs;
    }

}
