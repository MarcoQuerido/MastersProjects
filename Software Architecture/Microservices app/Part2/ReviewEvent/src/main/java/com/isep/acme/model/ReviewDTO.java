package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    private Long idReview;
    private String productSku;
    private Long idUser;
    private String reviewText;
    private String publishingDate;
    private String approvalStatus;
    private Double rating;
    private List<VoteDTO> upVotes;
    private List<VoteDTO> downVotes;

}
