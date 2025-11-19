package com.isep.acme.model.event;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class VoteCommandEvent {

    @Id
    private String id;

    private VoteCommandEventType type;

    private VoteEventDTO vote;

    @PersistenceConstructor
    public VoteCommandEvent(String id, VoteCommandEventType type, VoteEventDTO vote) {
        this.id = id;
        this.type = type;
        this.vote = vote;
    }

    public VoteCommandEvent(VoteCommandEventType type, VoteEventDTO vote) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.vote = vote;
    }

    public VoteCommandEventType getType() {
        return type;
    }

    public void setType(VoteCommandEventType type) {
        this.type = type;
    }

    public VoteEventDTO getVote() {
        return this.vote;
    }

    public void setVote(VoteEventDTO vote) {
        this.vote = vote;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProductCommandEvent{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", voteEventDTO=" + vote +
                '}';
    }
}
