package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    private Long id;
    private String reviewStatus;
}
