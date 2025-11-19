package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateVoteReviewDTO {

    private Long userID;
    private String productSku;
    private String vote;
    private String reviewText;
    private Double rating;

}