package com.isep.acme.model;

import lombok.Getter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
public class Vote {

    @Id
    private String id;

    @ManyToOne
    private Review review;

    @OneToOne
    private User user;

    private String vote;

    protected Vote() {
    }

    public Vote(String id, String vote, User user, Review review) {
        this.id = id;
        setVote(vote);
        this.user = user;
        this.review = review;
    }

    public Vote(String vote, User user, Review review) {
        this.id = UUID.randomUUID().toString();
        setVote(vote);
        this.user = user;
        this.review = review;
    }

    public void setVote(String vote) {
        if (!vote.equalsIgnoreCase("upVote") && !vote.equalsIgnoreCase("downVote")) {
            throw new IllegalArgumentException(String.format("Vote must be upVote or downVote. Vote %s is not supported.", vote));
        }
        this.vote = vote;
    }

    public VoteDTO toDto() {
        return new VoteDTO(review.getId(), user.getUserId(), vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review, user, vote);
    }

}
