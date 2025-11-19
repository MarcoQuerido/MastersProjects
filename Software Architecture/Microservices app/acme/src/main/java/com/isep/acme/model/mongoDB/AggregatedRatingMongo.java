package com.isep.acme.model.mongoDB;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "aggregated_ratings")
public class AggregatedRatingMongo {

    @Id
    private String aggregatedId;

    @Field
    private double average;

    @Field
    private ProductMongo product;

    public AggregatedRatingMongo() {
        // Default constructor
    }

    public AggregatedRatingMongo(double average, ProductMongo product) {
        this.average = average;
        this.product = product;
    }

    public String getAggregatedId() {
        return aggregatedId;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public ProductMongo getProduct() {
        return product;
    }

    public void setProduct(ProductMongo product) {
        this.product = product;
    }

    public ProductMongo getProductID() {
        return product;
    }

    public ProductMongo getProductId() {
        return product;
    }
}
