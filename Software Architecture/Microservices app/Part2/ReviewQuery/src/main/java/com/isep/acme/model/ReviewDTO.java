package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReviewDTO {

    private Long idReview;
    private String productSku;
    private Long idUser;
    private String reviewText;
    private String publishingDate;
    private String approvalStatus;
    private Double rating;

    @Builder.Default
    private List<VoteDTO> upVotes = new ArrayList<>();

    @Builder.Default
    private List<VoteDTO> downVotes = new ArrayList<>();

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "idReview=" + idReview +
                ", productSku='" + productSku + '\'' +
                ", idUser=" + idUser +
                ", reviewText='" + reviewText + '\'' +
                ", publishingDate='" + publishingDate + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", rating=" + rating +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                '}';
    }
}
