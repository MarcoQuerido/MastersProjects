package com.isep.acme.model;

import jakarta.persistence.*;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Review {

    @Id
    private Long id;

    @Setter
    private String reviewStatus;

    protected Review() {
    }

    public Review(final Long idReview) {
        this.id = Objects.requireNonNull(idReview);
        this.reviewStatus = "pending";
    }

    public Review(final Long idReview, String reviewStatus) {
        this.id = Objects.requireNonNull(idReview);
        this.reviewStatus = Objects.requireNonNull(reviewStatus);
    }

    public ReviewDTO toDto() {
        return new ReviewDTO(this.id, this.reviewStatus);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewStatus='" + reviewStatus + '\'' +
                '}';
    }
}
