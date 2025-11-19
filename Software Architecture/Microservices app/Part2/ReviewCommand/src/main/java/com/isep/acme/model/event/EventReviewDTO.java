package com.isep.acme.model.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EventReviewDTO {

    private Long reviewId;
    private Long userId;
    private String voteId;
    private String vote;
    private String productSku;
    private String reviewText;
    private String publishingDate;
    private String approvalStatus;
    private Double rating;

    @Override
    public String toString() {
        return "EventReviewDTO{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", voteId='" + voteId + '\'' +
                ", productSku='" + productSku + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", publishingDate='" + publishingDate + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", rating=" + rating +
                '}';
    }
}
