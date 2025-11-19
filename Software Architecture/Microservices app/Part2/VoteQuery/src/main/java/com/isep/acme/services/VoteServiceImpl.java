package com.isep.acme.services;

import com.isep.acme.repositories.TemporaryVoteRepository;
import com.isep.acme.repositories.UserRepository;
import com.isep.acme.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isep.acme.model.*;

import com.isep.acme.repositories.ReviewRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    TemporaryVoteRepository temporaryVoteRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Vote addVoteToReview(Long reviewID, VoteDTO voteReviewDTO) {
        Optional<Review> review = this.reviewRepository.findById(reviewID);

        if (review.isEmpty())
            throw new IllegalArgumentException(String.format("Review with id %d not found", reviewID));

        if (!"approved".equals(review.get().getReviewStatus()))
            throw new IllegalArgumentException(String.format("Can't add vote review %d because it is not approved", reviewID));

        Optional<User> user = this.userRepository.findById(voteReviewDTO.getUserId());

        if (user.isEmpty())
            throw new IllegalArgumentException(String.format("User with id %d not found", voteReviewDTO.getUserId()));

        Vote vote = new Vote(voteReviewDTO.getVote(), user.get(), review.get());
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
    public TemporaryVote addVoteWithoutReview(String voteId, String vote, Long userId) {
        if (!vote.equalsIgnoreCase("upVote") && !vote.equalsIgnoreCase("downVote")) {
            throw new IllegalArgumentException("The vote must be upVote or downVote");
        }

        Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty())
            throw new IllegalArgumentException(String.format("User with id %d not found", userId));

        TemporaryVote temporaryVote;
        if (voteId != null) {
            temporaryVote = new TemporaryVote(voteId, vote, user.get());
        } else {
            temporaryVote = new TemporaryVote(vote, user.get());
        }

        return temporaryVoteRepository.save(temporaryVote);
    }

    @Override
    public List<Vote> getVotesOfReview(Long reviewID) {
        Optional<Review> review = reviewRepository.findById(reviewID);
        if (review.isEmpty())
            throw new IllegalArgumentException(String.format("Review with id %d not found", reviewID));

        return voteRepository.findAllByReview(review.get());
    }

    @Override
    public List<Vote> getVotes() {
        List<Vote> votesList = new ArrayList<>();
        Iterable<Vote> votesIt = voteRepository.findAll();
        votesIt.forEach(votesList::add);
        return votesList;
    }

}