package com.isep.acme.model.mongoDB;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "prod_images")
public class ProdImageMongo {

    @Id
    private String imageId;

    @DBRef
    private ProductMongo product;

    @Field
    private byte[] image;

    public ProdImageMongo(ProductMongo product, byte[] image) {
        this.product = product;
        this.image = image;
    }

    public String getId() {
        return imageId;
    }

    public String getProductId() {
        return product.getProductID();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ProductMongo getProductMongo() {
        return product;
    }
}
