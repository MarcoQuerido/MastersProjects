package com.isep.acme.model.event;

public class ReviewCommandEvent {

    private String id;

    private ReviewCommandEventType type;

    private EventReviewDTO review;

    public ReviewCommandEvent(String id, ReviewCommandEventType type, EventReviewDTO reviewEventDTO) {
        this.id = id;
        this.type = type;
        this.review = reviewEventDTO;
    }

    public ReviewCommandEventType getType() {
        return type;
    }

    public void setType(ReviewCommandEventType type) {
        this.type = type;
    }

    public EventReviewDTO getReview() {
        return review;
    }

    public void setReview(EventReviewDTO reviewEventDTO) {
        this.review = reviewEventDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReviewCommandEvent{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", eventReviewDTO=" + review +
                '}';
    }
}