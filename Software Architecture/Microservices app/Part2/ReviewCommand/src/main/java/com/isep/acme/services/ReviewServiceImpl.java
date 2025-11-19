package com.isep.acme.services;

import java.lang.IllegalArgumentException;

import com.isep.acme.model.event.EventReviewDTO;
import com.isep.acme.model.event.ReviewCommandEvent;
import com.isep.acme.model.event.ReviewCommandEventTypeEnum;
import com.isep.acme.property.ResourceNotFoundException;
import com.isep.acme.publisher.ReviewCommandEventPublisher;
import com.isep.acme.repositories.ReviewCommandEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isep.acme.model.*;

import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;

    @Autowired
    ProductRepository pRepository;

    @Autowired
    UserRepository uRepository;

    @Autowired
    ReviewCommandEventRepository eventRepository;

    @Autowired
    ReviewCommandEventPublisher publisher;

    @Override
    public Review addReview(ReviewDTO reviewDTO) {

        final Optional<Product> productOpt = pRepository.findBySku(reviewDTO.getProductSku());
        if (productOpt.isEmpty())
            throw new ResourceNotFoundException(String.format("Product with sku %s not found", reviewDTO.getProductSku()));

        final Optional<User> userOpt = uRepository.findById(reviewDTO.getIdUser());
        if (userOpt.isEmpty())
            throw new ResourceNotFoundException(String.format("User with id %d not found", reviewDTO.getIdUser()));

        LocalDate publishingDate;
        if (reviewDTO.getPublishingDate() == null) {
            publishingDate = LocalDate.now();
        } else {
            publishingDate = LocalDate.parse(reviewDTO.getPublishingDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        Review review = new Review(reviewDTO.getIdReview(),
                0L,
                Optional.ofNullable(reviewDTO.getApprovalStatus()).orElse("pending"),
                reviewDTO.getReviewText(),
                new Rating(reviewDTO.getRating()),
                publishingDate,
                productOpt.get(),
                userOpt.get());

        reviewDTO.getUpVotes().forEach(upVoteDTO -> {
                    final Optional<User> voteUserOpt = uRepository.findById(reviewDTO.getIdUser());
                    if (voteUserOpt.isEmpty())
                        throw new ResourceNotFoundException(String.format("User with id %d not found", reviewDTO.getIdUser()));

                    review.addUpVote(new Vote(upVoteDTO.getId(), upVoteDTO.getVote(), voteUserOpt.get()));
                }
        );

        reviewDTO.getDownVotes().forEach(downVoteDTO -> {
                    final Optional<User> voteUserOpt = uRepository.findById(reviewDTO.getIdUser());
                    if (voteUserOpt.isEmpty())
                        throw new ResourceNotFoundException(String.format("User with id %d not found", reviewDTO.getIdUser()));

                    review.addUpVote(new Vote(downVoteDTO.getId(), downVoteDTO.getVote(), voteUserOpt.get()));
                }
        );

        return repository.save(review);
    }

//    @Override
//    public Review create(final CreateReviewDTO createReviewDTO, String sku) {
//
//        final Optional<Product> product = pRepository.findBySku(sku);
//        if (product.isEmpty())
//            throw new ResourceNotFoundException(String.format("Product with sku %s not found", sku));
//
//        final Optional<User> userOpt = uRepository.findById(createReviewDTO.getUserID());
//        if (userOpt.isEmpty())
//            throw new ResourceNotFoundException(String.format("User with id %d not found", createReviewDTO.getUserID()));
//
//        Rating rating = new Rating(createReviewDTO.getRating());
//
//        LocalDate date = LocalDate.now();
//
//        Review review = new Review(createReviewDTO.getReviewText(), rating, date, product.get(), userOpt.get());
//
//        return repository.save(review);
//    }

    @Override
    public Review createAndPublish(final CreateReviewDTO createReviewDTO, String sku) {

        ReviewDTO dto = ReviewDTO.builder()
                .idUser(createReviewDTO.getUserID())
                .reviewText(createReviewDTO.getReviewText())
                .rating(createReviewDTO.getRating())
                .productSku(sku)
                .build();

        Review review = addReview(dto);

        ReviewCommandEvent reviewEvent = new ReviewCommandEvent(ReviewCommandEventTypeEnum.REVIEW_CREATED,
                review.toEventDto());

        eventRepository.save(reviewEvent);

        publisher.publishEvent(reviewEvent);

        return review;
    }

    @Override
    public Review moderateReview(Long reviewID, String approved) throws ResourceNotFoundException, IllegalArgumentException {

        Optional<Review> r = repository.findById(reviewID);

        if (r.isEmpty()) {
            throw new ResourceNotFoundException("Review not found");
        }

        Boolean ap = r.get().setApprovalStatus(approved);

        if (!ap) {
            throw new IllegalArgumentException("Invalid status value");
        }

        return repository.save(r.get());
    }

    @Override
    public Review moderateReviewAndPublish(Long reviewID, String approved) throws ResourceNotFoundException, IllegalArgumentException {
        Review review = moderateReview(reviewID, approved);

        ReviewCommandEvent reviewEvent = new ReviewCommandEvent(ReviewCommandEventTypeEnum.REVIEW_MODERATED, review.toEventDto());
        eventRepository.save(reviewEvent);

        publisher.publishEvent(reviewEvent);

        return review;
    }

    @Override
    public void deleteReview(Long reviewId) {

        Optional<Review> rev = repository.findById(reviewId);

        if (rev.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Review with id %s not found", reviewId));
        }

        repository.deleteById(reviewId);
    }

    @Override
    public void deleteReviewAndPublish(Long reviewId) {
        deleteReview(reviewId);
        EventReviewDTO eventReviewDTO = EventReviewDTO.builder().reviewId(reviewId).build();

        ReviewCommandEvent reviewEvent = new ReviewCommandEvent(ReviewCommandEventTypeEnum.REVIEW_DELETED, eventReviewDTO);
        eventRepository.save(reviewEvent);

        publisher.publishEvent(reviewEvent);
    }

    @Override
    @Transactional
    public Review addVoteToReview(String id, String voteStr, Long userId, Long reviewId) {

        Optional<Review> reviewOpt = repository.findById(reviewId);

        if (reviewOpt.isEmpty())
            throw new IllegalArgumentException(String.format("Unable to find review with id %d", reviewId));

        Review review = reviewOpt.get();

        if (!"approved".equals(review.getApprovalStatus()))
            throw new IllegalArgumentException(String.format("Can't add vote review %d because it is not approved", reviewId));

        Optional<User> userOpt = uRepository.findById(userId);

        if (userOpt.isEmpty())
            throw new IllegalArgumentException(String.format("Unable to find user with id %d", userId));

        User user = userOpt.get();

        Vote vote = new Vote(id, voteStr, user);

        if ("upVote".equalsIgnoreCase(voteStr)) {
            review.addUpVote(vote);
        } else if ("downVote".equalsIgnoreCase(voteStr)) {
            review.addDownVote(vote);
        } else {
            throw new IllegalArgumentException(String.format("Vote must be upVote or downVote. Found %s", voteStr));
        }

        return repository.save(review);
    }

    private Review addVoteToReview(Review review, String id, String voteStr) {
        Vote vote = new Vote(id, voteStr, review.getUser());

        if ("upVote".equalsIgnoreCase(voteStr)) {
            review.addUpVote(vote);
        } else if ("downVote".equalsIgnoreCase(voteStr)) {
            review.addDownVote(vote);
        } else {
            throw new IllegalArgumentException(String.format("Vote must be upVote or downVote. Found %s", voteStr));
        }

        return repository.save(review);
    }

    @Override
    @Transactional
    public Review createWithVoteAndPublish(final CreateReviewDTO createReviewDTO, String sku, String voteStr, String voteId) {

        ReviewDTO dto = ReviewDTO.builder()
                .idUser(createReviewDTO.getUserID())
                .reviewText(createReviewDTO.getReviewText())
                .rating(createReviewDTO.getRating())
                .productSku(sku)
                .build();

        Review review = addReview(dto);
        review.setApprovalStatus("approved");

        Review savedReview = repository.save(review);

        Review reviewWithVote = addVoteToReview(savedReview, voteId, voteStr);

        ReviewCommandEvent reviewEvent = new ReviewCommandEvent(ReviewCommandEventTypeEnum.REVIEW_CREATED, reviewWithVote.toEventDtoWithVote(voteId, voteStr));

        eventRepository.save(reviewEvent);
        publisher.publishEvent(reviewEvent);

        return reviewWithVote;
    }
}