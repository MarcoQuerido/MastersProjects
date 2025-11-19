package com.isep.acme.model.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventReviewDTO {

    private Long reviewId;
    private String approvalStatus;
    private Long userId;
    private String voteId;
    private String vote;

    @Override
    public String toString() {
        return "EventReviewDTO{" +
                "reviewId=" + reviewId +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", userId=" + userId +
                ", voteId='" + voteId + '\'' +
                ", vote='" + vote + '\'' +
                '}';
    }
}
