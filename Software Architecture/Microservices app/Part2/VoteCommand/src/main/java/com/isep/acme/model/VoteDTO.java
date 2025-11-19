package com.isep.acme.model;

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
public class VoteDTO {

    private Long reviewId;
    private Long userId;
    private String vote;

    @Override
    public String toString() {
        return "VoteDTO{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", vote='" + vote + '\'' +
                '}';
    }
}