package com.isep.acme.model.mongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ratings")
public class RatingMongo {

    @Id
    private String idRating;

    @Field
    private Double rate;

    public RatingMongo(Double rate) {
        if (rate == null) {
            throw new IllegalArgumentException("Rate cannot be null");
        }
        this.rate = rate;
    }

    public String getIdRating() {
        return idRating;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
