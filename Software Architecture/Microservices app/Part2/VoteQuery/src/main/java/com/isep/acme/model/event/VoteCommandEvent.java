package com.isep.acme.model.event;

public class VoteCommandEvent {

    private String id;

    private VoteCommandEventType type;

    private VoteEventDTO vote;

    public VoteCommandEvent(String id, VoteCommandEventType type, VoteEventDTO vote) {
        this.id = id;
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

    public void setId(String id) {
        this.id = id;
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
