package com.isep.acme.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Embeddable
public class Vote {

    private String id;

    private String vote;

    @OneToOne
    private User user;

    protected Vote() {
    }

    public Vote(String id, String vote, User user) {
        this.id = id;
        this.vote = vote;
        this.user = user;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote1 = (Vote) o;
        return id.equals(vote1.id) && vote.equals(vote1.vote) && user.equals(vote1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vote, user);
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", vote='" + vote + '\'' +
                ", user=" + user.getUserId() +
                '}';
    }
}
