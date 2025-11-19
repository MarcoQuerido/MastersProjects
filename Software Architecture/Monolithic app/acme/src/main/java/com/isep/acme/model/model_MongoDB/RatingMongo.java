package com.isep.acme.model.model_MongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ratings") // Define the collection name
public class RatingMongo {

    @Id
    private String idRating; // Adjust the primary key type to String for MongoDB

    @Field
    private Double rate;

    public RatingMongo(Double rate) {
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
