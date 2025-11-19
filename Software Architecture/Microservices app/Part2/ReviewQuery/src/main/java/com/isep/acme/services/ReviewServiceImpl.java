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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<ReviewDTO> getReviewsOfProduct(String sku, String status) {

        Optional<Product> product = pRepository.findBySku(sku);
        if (product.isEmpty())
            throw new IllegalArgumentException(String.format("Unable to find Product with sku %s", sku));

        Optional<List<Review>> r = repository.findByProductIdStatus(product.get(), status);

        if (r.isEmpty()) return null;

        return r.get().stream().map(Review::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findPendingReview() {

        Optional<List<Review>> r = repository.findPendingReviews();

        if (r.isEmpty()) {
            return null;
        }

        return r.get().stream().map(Review::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findReviewsByUser(Long userID) {

        final Optional<User> user = uRepository.findById(userID);

        if (user.isEmpty())
            throw new IllegalArgumentException(String.format("Unable to find User with id %d", userID));

        Optional<List<Review>> r = repository.findByUserId(user.get());

        if (r.isEmpty()) return null;

        return r.get().stream().map(Review::toDto).collect(Collectors.toList());
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
}