package com.isep.acme.model.event;

import com.isep.acme.model.ProductDTO;

public class ProductCommandEvent {

    private String id;

    private ProductCommandEventTypeEnum type;

    private ProductDTO product;

    public ProductCommandEvent(String id, ProductCommandEventTypeEnum type, ProductDTO product) {
        this.id = id;
        this.type = type;
        this.product = product;
    }

    public ProductCommandEvent(ProductCommandEventTypeEnum type, ProductDTO product) {
        this.type = type;
        this.product = product;
    }

    public ProductCommandEventTypeEnum getType() {
        return type;
    }

    public void setType(ProductCommandEventTypeEnum type) {
        this.type = type;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProductCommandEvent{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", product=" + product +
                '}';
    }
}
