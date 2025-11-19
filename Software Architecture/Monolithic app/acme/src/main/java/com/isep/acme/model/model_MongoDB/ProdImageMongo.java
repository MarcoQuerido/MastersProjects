package com.isep.acme.model.model_MongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "prod_images") // Define the collection name
public class ProdImageMongo {

    @Id
    private String id; // Adjust the primary key type to String for MongoDB

    @Field("product_id")
    private String productId; // Use a String to store the product ID

    @Field
    private byte[] image; // Use a byte array to store the image data

    public ProdImageMongo(String productId, byte[] image) {
        this.productId = productId;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
