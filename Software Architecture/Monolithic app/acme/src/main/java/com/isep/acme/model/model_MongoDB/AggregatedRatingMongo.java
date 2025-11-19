package com.isep.acme.model.model_MongoDB;

import com.isep.acme.model.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "aggregated_ratings") // Define the collection name
public class AggregatedRatingMongo {

    @Id
    private String aggregatedId; // Adjust the primary key type to String for MongoDB

    @Field
    private double average;

    @Field
    private Product product;

    public AggregatedRatingMongo() {
        // Default constructor
    }

    public AggregatedRatingMongo(double average, Product product) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
