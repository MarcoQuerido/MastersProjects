package com.isep.acme.services;

import com.isep.acme.model.event.VoteCommandEvent;
import com.isep.acme.model.event.VoteCommandEventType;
import com.isep.acme.model.event.VoteEventDTO;
import com.isep.acme.publisher.VoteCommandEventPublisher;
import com.isep.acme.publisher.VoteQueueCommandEventPublisher;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.TemporaryVoteRepository;
import com.isep.acme.repositories.UserRepository;
import com.isep.acme.repositories.VoteCommandEventRepository;
import com.isep.acme.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isep.acme.model.*;

import com.isep.acme.repositories.ReviewRepository;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    ProductRepository productRepository;

    @Autowired
    VoteCommandEventPublisher voteEventPublisher;

    @Autowired
    VoteQueueCommandEventPublisher voteQueueEventPublisher;

    @Autowired
    VoteCommandEventRepository eventRepository;

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
    public Vote addVoteToReviewAndPublish(Long reviewID, VoteDTO voteReviewDTO) {
        Vote vote = addVoteToReview(reviewID, voteReviewDTO);

        VoteEventDTO voteEventDTO = VoteEventDTO.builder()
                .voteId(vote.getId())
                .userId(vote.getUser().getUserId())
                .reviewId(reviewID)
                .vote(vote.getVote())
                .build();

        VoteCommandEvent voteEvent;

        if (voteReviewDTO.getVote().equalsIgnoreCase("upVote")) {
            voteEvent = new VoteCommandEvent(VoteCommandEventType.ADDED_UP_VOTE_TO_REVIEW, voteEventDTO);
        } else if (voteReviewDTO.getVote().equalsIgnoreCase("downVote")) {
            voteEvent = new VoteCommandEvent(VoteCommandEventType.ADDED_DOWN_VOTE_TO_REVIEW, voteEventDTO);
        } else {
            throw new IllegalArgumentException("The vote must be upVote or downVote");
        }

        eventRepository.save(voteEvent);
        voteEventPublisher.publishEvent(voteEvent);

        return vote;
    }

    @Override
    @Transactional
    public TemporaryVote addVoteWithoutReview(String voteId, String vote, Long userId, String productSku) {
        if (!vote.equalsIgnoreCase("upVote") && !vote.equalsIgnoreCase("downVote")) {
            throw new IllegalArgumentException("The vote must be upVote or downVote");
        }

        Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty())
            throw new IllegalArgumentException(String.format("User with id %d not found", userId));

        Optional<Product> product = this.productRepository.findBySku(productSku);

        if (product.isEmpty())
            throw new IllegalArgumentException(String.format("Product with sku %s not found", productSku));

        TemporaryVote temporaryVote;
        if (voteId != null) {
            temporaryVote = new TemporaryVote(voteId, vote, user.get());
        } else {
            temporaryVote = new TemporaryVote(vote, user.get());
        }

        return temporaryVoteRepository.save(temporaryVote);
    }

    @Override
    public TemporaryVote addVoteWithoutReviewAndPublish(CreateVoteReviewDTO voteReviewDTO) {
        TemporaryVote vote = addVoteWithoutReview(null, voteReviewDTO.getVote(), voteReviewDTO.getUserID(), voteReviewDTO.getProductSku());

        VoteEventDTO voteEventDTO = VoteEventDTO.builder()
                .voteId(vote.getId())
                .userId(vote.getUser().getUserId())
                .vote(vote.getVote())
                .productSku(voteReviewDTO.getProductSku())
                .reviewText(voteReviewDTO.getReviewText())
                .reviewRating(voteReviewDTO.getRating())
                .build();

        VoteCommandEvent voteEvent = new VoteCommandEvent(VoteCommandEventType.TEMPORARY_VOTE_CREATED, voteEventDTO);

        eventRepository.save(voteEvent);
        voteEventPublisher.publishEvent(voteEvent);
        voteQueueEventPublisher.publishEvent(voteEvent);

        return vote;
    }

}