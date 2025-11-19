package com.isep.acme.model.event;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document
public class VoteCommandEvent {

//    @Id
    private String id;

    private VoteCommandEventTypeEnum type;

    private EventVoteDTO vote;

//    @PersistenceConstructor
    public VoteCommandEvent(String id, VoteCommandEventTypeEnum type, EventVoteDTO vote) {
        this.id = id;
        this.type = type;
        this.vote = vote;
    }

    public VoteCommandEventTypeEnum getType() {
        return type;
    }

    public void setType(VoteCommandEventTypeEnum type) {
        this.type = type;
    }

    public EventVoteDTO getVote() {
        return vote;
    }

    public void setVote(EventVoteDTO vote) {
        this.vote = vote;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "VoteCommandEvent{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", vote=" + vote +
                '}';
    }
}
