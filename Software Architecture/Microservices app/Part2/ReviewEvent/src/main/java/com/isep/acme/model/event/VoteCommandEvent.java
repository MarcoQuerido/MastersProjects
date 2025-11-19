package com.isep.acme.model.event;

public class VoteCommandEvent {

    private String id;

    private VoteCommandEventTypeEnum type;

    private EventVoteDTO vote;

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
