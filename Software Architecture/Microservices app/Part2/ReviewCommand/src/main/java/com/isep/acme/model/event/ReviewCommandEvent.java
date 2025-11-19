package com.isep.acme.model.event;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class ReviewCommandEvent {

    @Id
    private String id;

    private ReviewCommandEventTypeEnum type;

    private EventReviewDTO review;

    @PersistenceConstructor
    public ReviewCommandEvent(String id, ReviewCommandEventTypeEnum type, EventReviewDTO review) {
        this.id = id;
        this.type = type;
        this.review = review;
    }

    public ReviewCommandEvent(ReviewCommandEventTypeEnum type, EventReviewDTO review) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.review = review;
    }

    public ReviewCommandEventTypeEnum getType() {
        return type;
    }

    public void setType(ReviewCommandEventTypeEnum type) {
        this.type = type;
    }

    public EventReviewDTO getReview() {
        return review;
    }

    public void setReview(EventReviewDTO review) {
        this.review = review;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReviewCommandEvent{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", review=" + review +
                '}';
    }
}
