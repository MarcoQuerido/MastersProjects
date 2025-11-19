package com.isep.acme.model.neo4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.isep.acme.model.Vote;
import lombok.Getter;
import lombok.Setter;

@Node("Review")
@Getter
@Setter
public class ReviewNeo4J {

    @Id
    @GeneratedValue
    private Long idReview;

    private long version;

    @Property
    private String approvalStatus;

    @Property
    private String reviewText;

    @Relationship(type = "UPVOTED")
    private List<Vote> upVote;

    @Relationship(type = "DOWNVOTED")
    private List<Vote> downVote;

    @Property
    private String report;

    @Property
    private LocalDate publishingDate;

    @Property
    private String funFact;

    @Relationship(type = "REVIEWS_PRODUCT")
    private ProductNeo4J product;

    @Relationship(type = "WRITTEN_BY")
    private UserNeo4J user;

    @Relationship(type = "HAS_RATING")
    private RatingNeo4J rating;

    public ReviewNeo4J(){}

    public ReviewNeo4J(final Long idReview, final long version, final String approvalStatus, final String reviewText, final LocalDate publishingDate, final String funFact) {
        this.idReview = Objects.requireNonNull(idReview);
        this.version = Objects.requireNonNull(version);
        setApprovalStatus(approvalStatus);
        setReviewText(reviewText);
        setPublishingDate(publishingDate);
        setFunFact(funFact);
    }

    public ReviewNeo4J(final Long idReview, final long version, final String approvalStatus, final  String reviewText, final List<Vote> upVote, final List<Vote> downVote, final String report, final LocalDate publishingDate, final String funFact, ProductNeo4J productNeo4J, RatingNeo4J rating, UserNeo4J userNeo4J) {
        this(idReview, version, approvalStatus, reviewText, publishingDate, funFact);

        setUpVote(upVote);
        setDownVote(downVote);
        setReport(report);
        setProduct(productNeo4J);
        setRating(rating);
        setUser(userNeo4J);

    }

    public ReviewNeo4J(final String reviewText, LocalDate publishingDate, ProductNeo4J productNeo4J, String funFact, RatingNeo4J rating, UserNeo4J userNeo4J) {
        setReviewText(reviewText);
        setProduct(productNeo4J);
        setPublishingDate(publishingDate);
        setApprovalStatus("pending");
        setFunFact(funFact);
        setRating(rating);
        setUser(userNeo4J);
        this.upVote = new ArrayList<>();
        this.downVote = new ArrayList<>();
    }

    public Long getIdReview() {
        return idReview;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public Boolean setApprovalStatus(String approvalStatus) {

        if( approvalStatus.equalsIgnoreCase("pending") ||
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

    public void setReport(String report) {
        if (report.length() > 2048) {
            throw new IllegalArgumentException("Report must not be greater than 2048 characters.");
        }
        this.report = report;
    }

    public RatingNeo4J getRating() {
        if(rating == null) {
            return new RatingNeo4J(0.0);
        }
        return rating;
    }


    public boolean addUpVote(Vote upVote) {

        if( !this.approvalStatus.equals("approved"))
            return false;

        if(!this.upVote.contains(upVote)){
            this.upVote.add(upVote);
            return true;
        }
        return false;
    }

    public boolean addDownVote(Vote downVote) {

        if( !this.approvalStatus.equals( "approved") )
            return false;

        if(!this.downVote.contains(downVote)){
            this.downVote.add(downVote);
            return true;
        }
        return false;
    }
}
