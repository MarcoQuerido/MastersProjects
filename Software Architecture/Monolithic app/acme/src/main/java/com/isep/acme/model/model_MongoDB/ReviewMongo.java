package com.isep.acme.model.model_MongoDB;

import com.isep.acme.model.Rating;
import com.isep.acme.model.Review;
import com.isep.acme.model.Vote;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Document
public class ReviewMongo {

    @Id
    private String id;  // MongoDB ObjectId
    @Field
    private long version;
    @Field
    private String approvalStatus;
    @Field
    private String reviewText;
    @Field
    private List<Vote> upVote;
    @Field
    private List<Vote> downVote;
    @Field
    private String report;
    @Field
    private LocalDate publishingDate;
    @Field
    private String funFact;

    @Lazy
    private ProductMongo product;  // Reference to Product's id

    @Lazy
    private UserMongo user;  // Reference to User's id
    @Field
    private Rating rating;
    @Field
    private String votes;

    // Create a Logger
    Logger logger = Logger.getLogger(ReviewMongo.class.getName());

    public ReviewMongo() {
        // Default constructor is required for MongoDB documents
    }

    public ReviewMongo(String approvalStatus, String reviewText, LocalDate publishingDate, String funFact) {
        this.version = 0;  // Set the initial version to 0
        setApprovalStatus(approvalStatus);
        setReviewText(reviewText);
        setPublishingDate(publishingDate);
        setFunFact(funFact);
        this.upVote = new ArrayList<>();
        this.downVote = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(){
        this.id = id;
    }
    public long getVersion() {
        return version;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        if (approvalStatus.equalsIgnoreCase("pending") ||
                approvalStatus.equalsIgnoreCase("approved") ||
                approvalStatus.equalsIgnoreCase("rejected")) {
            this.approvalStatus = approvalStatus;
        } else {
            logger.log(Level.SEVERE, "invalid approval status received");
        }
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        if (reviewText == null || reviewText.isBlank()) {
            logger.log(Level.SEVERE, "review text is empty");
        }
        if (reviewText.length() > 2048) {
            logger.log(Level.SEVERE, "review text size is too big");
        }
        this.reviewText = reviewText;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        if (report.length() > 2048) {
            logger.log(Level.SEVERE, "report size is too big");
        }
        this.report = report;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public ProductMongo getProduct() {
        return product;
    }

    public void setProduct(ProductMongo product) {
        this.product = product;
    }

    public UserMongo getUser() {
        return user;
    }

    public void setUser(UserMongo user) {
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

    public List<Vote> getUpVote() {
        return upVote;
    }

    public void setUpVote(List<Vote> upVote) {
        this.upVote = upVote;
    }

    public List<Vote> getDownVote() {
        return downVote;
    }

    public void setDownVote(List<Vote> downVote) {
        this.downVote = downVote;
    }

    public boolean addUpVote(Vote upVote) {
        if (!this.approvalStatus.equals("approved")) {
            return false;
        }
        if (!this.upVote.contains(upVote)) {
            this.upVote.add(upVote);
            return true;
        }
        return false;
    }

    public boolean addDownVote(Vote downVote) {
        if (!this.approvalStatus.equals("approved")) {
            return false;
        }
        if (!this.downVote.contains(downVote)) {
            this.downVote.add(downVote);
            return true;
        }
        return false;
    }

    public double getUpvotePercentage() {
        if (upVote.isEmpty()) {
            return 0.0;
        }

        int totalVotes = upVote.size();
        int upvoteCount = 0;

        for (Vote vote : upVote) {
            String voteValue = vote.getVote();
            if (voteValue.equalsIgnoreCase("up")) {
                upvoteCount++;
            }
        }

        return (double) upvoteCount / totalVotes * 100;
    }

    public static List<ReviewMongo> getRecommendedReviews(List<ReviewMongo> reviews) {
        List<ReviewMongo> recommendedReviews = new ArrayList<>();
        for (ReviewMongo review : reviews) {
            if (review.getUpvotePercentage() >= 65.0) {
                recommendedReviews.add(review);
            }
        }

        // Sort recommended reviews by upvote percentage (descending order)
        recommendedReviews.sort((r1, r2) -> Double.compare(r2.getUpvotePercentage(), r1.getUpvotePercentage()));

        return recommendedReviews;
    }
}
