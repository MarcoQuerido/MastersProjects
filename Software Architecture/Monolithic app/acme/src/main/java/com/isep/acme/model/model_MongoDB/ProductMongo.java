package com.isep.acme.model.model_MongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products") // Define the collection name
public class ProductMongo {

    @Id
    private String productID; // Adjust the primary key type to String for MongoDB

    @Field
    private String sku;

    @Field
    private String designation;

    @Field
    private String description;

    public ProductMongo(String sku, String designation, String description) {
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateProduct(ProductMongo p) {
        this.designation = p.designation;
        this.description = p.description;
    }
}
