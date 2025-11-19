package com.isep.acme.model.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VoteEventDTO {

    private String voteId;
    private Long reviewId;
    private Long userId;
    private String productSku;
    private String vote;
    private String reviewText;
    private Double reviewRating;

    @Override
    public String toString() {
        return "VoteEventDTO{" +
                "voteID=" + voteId +
                ", reviewID=" + reviewId +
                ", userID=" + userId +
                ", productSku='" + productSku + '\'' +
                ", vote='" + vote + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewRating=" + reviewRating +
                '}';
    }
}