package com.isep.acme.model.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventVoteDTO {

    private String voteId;
    private Long reviewId;
    private Long userId;
    private String productSku;
    private String vote;
    private String reviewText;
    private Double reviewRating;

    @Override
    public String toString() {
        return "EventVoteDTO{" +
                "voteId='" + voteId + '\'' +
                ", reviewId=" + reviewId +
                ", userId=" + userId +
                ", productSku='" + productSku + '\'' +
                ", vote='" + vote + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewRating=" + reviewRating +
                '}';
    }
}
