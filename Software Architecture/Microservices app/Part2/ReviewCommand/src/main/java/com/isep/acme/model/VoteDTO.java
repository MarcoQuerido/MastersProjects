package com.isep.acme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class VoteDTO {

    private String id;
    private String vote;
    private Long userId;

    @Override
    public String toString() {
        return "VoteDTO{" +
                "id='" + id + '\'' +
                ", vote='" + vote + '\'' +
                ", userId=" + userId +
                '}';
    }
}
