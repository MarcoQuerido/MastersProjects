package com.isep.acme.model;

import lombok.Getter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
public class TemporaryVote {

    @Id
    private String id;

    @OneToOne
    private User user;

    private String vote;

    protected TemporaryVote() {
    }

    public TemporaryVote(String id, String vote, User user) {
        this.id = id;
        setVote(vote);
        this.user = user;
    }

    public TemporaryVote(String vote, User user) {
        this.id = UUID.randomUUID().toString();
        setVote(vote);
        this.user = user;
    }

    public void setVote(String vote) {
        if (!vote.equalsIgnoreCase("upVote") && !vote.equalsIgnoreCase("downVote")) {
            throw new IllegalArgumentException(String.format("Vote must be upVote or downVote. Vote %s is not supported.", vote));
        }
        this.vote = vote;
    }

    public VoteDTO toDto() {
        return new VoteDTO(null, user.getUserId(), vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, vote);
    }

}
