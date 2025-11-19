package com.isep.acme.model.mongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public class ProductMongo {

    @Id
    private String productID;

    @Field
    private String sku;

    @Field
    private String designation;

    @Field
    private String description;

    public ProductMongo(String sku, String designation, String description) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be empty");
        }

        if (designation == null || designation.trim().isEmpty()) {
            throw new IllegalArgumentException("Designation cannot be empty");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        //this.productID = productID;
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
