package com.isep.acme.services;

import java.lang.IllegalArgumentException;

import com.isep.acme.property.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isep.acme.model.*;

import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;

    @Autowired
    ProductRepository pRepository;

    @Autowired
    UserRepository uRepository;

    @Override
    public Review addReview(ReviewDTO reviewDTO) {

        final Optional<Product> productOpt = pRepository.findBySku(reviewDTO.getProductSku());
        if (productOpt.isEmpty()) return null;

        final Optional<User> userOpt = uRepository.findById(reviewDTO.getIdUser());
        if (userOpt.isEmpty()) return null;

        Review review = new Review(reviewDTO.getIdReview(),
                0L,
                reviewDTO.getReviewText(),
                new Rating(reviewDTO.getRating()),
                LocalDate.parse(reviewDTO.getPublishingDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                productOpt.get(),
                userOpt.get());

        return repository.save(review);
    }

    @Override
    public Review create(final CreateReviewDTO createReviewDTO, String sku) {

        final Optional<Product> product = pRepository.findBySku(sku);
        if (product.isEmpty()) return null;

        final Optional<User> userOpt = uRepository.findById(createReviewDTO.getUserID());
        if (userOpt.isEmpty()) return null;

        Rating rating = new Rating(createReviewDTO.getRating());

        LocalDate date = LocalDate.now();

        Review review = new Review(createReviewDTO.getReviewText(), rating, date, product.get(), userOpt.get());

        review = repository.save(review);

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
    public void deleteReview(Long reviewId) {

        Optional<Review> rev = repository.findById(reviewId);

        if (rev.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Review with id %s not found", reviewId));
        }

        repository.deleteById(reviewId);
    }

    @Override
    @Transactional
    public Review addVoteToReview(String id, String voteStr, Long userId, Long reviewId) {

        Optional<Review> reviewOpt = repository.findById(reviewId);

        if (reviewOpt.isEmpty())
            throw new IllegalArgumentException(String.format("Unable to find review with id %d", reviewId));

        Review review = reviewOpt.get();

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

    @Override
    @Transactional
    public List<ReviewDTO> getReviews() {

        Iterable<Review> reviewsIt = repository.findAll();
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review r : reviewsIt) {
            reviewDTOs.add(r.toDto());
        }

        return reviewDTOs;
    }
}