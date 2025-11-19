package com.isep.acme.model;

import com.isep.acme.model.event.EventReviewDTO;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private long version;

    @Column(nullable = false)
    private String approvalStatus;

    @Column(nullable = false)
    private String reviewText;

    @ElementCollection
    @Column(nullable = true)
    private Set<Vote> upVotes;

    @ElementCollection
    @Column(nullable = true)
    private Set<Vote> downVotes;

    @Column(nullable = false)
    @Embedded
    private Rating rating;

    @Column(nullable = false)
    private LocalDate publishingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Review() {
    }

    public Review(String reviewText, Rating rating, LocalDate publishingDate, Product product, User user) {
        this.upVotes = new HashSet<>();
        this.downVotes = new HashSet<>();
        setApprovalStatus("pending");
        setReviewText(reviewText);
        setRating(rating);
        setPublishingDate(publishingDate);
        setProduct(product);
        setUser(user);
    }

    public Review(Long id, Long version, String reviewText, Rating rating, LocalDate publishingDate, Product product, User user) {
        this.id = id;
        this.version = version;
        this.upVotes = new HashSet<>();
        this.downVotes = new HashSet<>();
        setApprovalStatus("pending");
        setReviewText(reviewText);
        setRating(rating);
        setPublishingDate(publishingDate);
        setProduct(product);
        setUser(user);
    }

    public Review(Long id, Long version, String approvalStatus, String reviewText, Rating rating, LocalDate publishingDate, Product product, User user) {
        this.id = id;
        this.version = version;
        this.upVotes = new HashSet<>();
        this.downVotes = new HashSet<>();
        setApprovalStatus(approvalStatus);
        setReviewText(reviewText);
        setRating(rating);
        setPublishingDate(publishingDate);
        setProduct(product);
        setUser(user);
    }

    public Long getIdReview() {
        return id;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public Boolean setApprovalStatus(String approvalStatus) {

        if (approvalStatus.equalsIgnoreCase("pending") ||
                approvalStatus.equalsIgnoreCase("approved") ||
                approvalStatus.equalsIgnoreCase("rejected")) {

            this.approvalStatus = approvalStatus;
            return true;
        }
        return false;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        if (reviewText == null || reviewText.isBlank()) {
            throw new IllegalArgumentException("Review Text is a mandatory attribute of Review.");
        }
        if (reviewText.length() > 2048) {
            throw new IllegalArgumentException("Review Text must not be greater than 2048 characters.");
        }

        this.reviewText = reviewText;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public long getVersion() {
        return version;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rating getRating() {
        if (rating == null) {
            return new Rating(0.0);
        }
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


    public void setUpVotes(Set<Vote> upVote) {
        this.upVotes = upVote;
    }


    public void setDownVotes(Set<Vote> downVote) {
        this.downVotes = downVote;
    }

    public boolean addUpVote(Vote upVote) {
        return this.upVotes.add(upVote);
    }

    public boolean addDownVote(Vote downVote) {
        return this.downVotes.add(downVote);
    }

    public ReviewDTO toDto() {
        return new ReviewDTO(this.getIdReview(),
                this.getProduct().getSku(),
                this.getUser().getUserId(),
                this.getReviewText(),
                this.getPublishingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                this.getApprovalStatus(),
                this.getRating().getRate(),
                this.getUpVotes().stream()
                        .map(upVote -> new VoteDTO(upVote.getId(), upVote.getVote(), upVote.getUser().getUserId()))
                        .collect(Collectors.toList()),
                this.getDownVotes().stream()
                        .map(downVote -> new VoteDTO(downVote.getId(), downVote.getVote(), downVote.getUser().getUserId()))
                        .collect(Collectors.toList()));
    }

    public Set<Vote> getUpVotes() {
        return this.upVotes;
    }

    public Set<Vote> getDownVotes() {
        return this.downVotes;
    }

    public EventReviewDTO toEventDto() {
        return EventReviewDTO.builder()
                .reviewId(this.getIdReview())
                .userId(this.getUser().getUserId())
                .productSku(this.getProduct().getSku())
                .reviewText(this.getReviewText())
                .publishingDate(this.getPublishingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .approvalStatus(this.getApprovalStatus())
                .rating(this.getRating().getRate())
                .build();
    }

    public EventReviewDTO toEventDtoWithVoteId(String voteId) {
        return EventReviewDTO.builder()
                .reviewId(this.getIdReview())
                .userId(this.getUser().getUserId())
                .productSku(this.getProduct().getSku())
                .reviewText(this.getReviewText())
                .publishingDate(this.getPublishingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .approvalStatus(this.getApprovalStatus())
                .rating(this.getRating().getRate())
                .voteId(voteId)
                .build();
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", version=" + version +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", rating=" + rating +
                ", publishingDate=" + publishingDate +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
