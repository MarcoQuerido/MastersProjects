package com.isep.acme.model.event;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductCommandEvent {

    @Id
    private String id;

    private ProductCommandEventTypeEnum type;

    private EventProductDTO product;

    @PersistenceConstructor
    public ProductCommandEvent(String id, ProductCommandEventTypeEnum type, EventProductDTO product) {
        this.id = id;
        this.type = type;
        this.product = product;
    }

    public ProductCommandEvent(ProductCommandEventTypeEnum type, EventProductDTO product) {
        this.type = type;
        this.product = product;
    }

    public ProductCommandEventTypeEnum getType() {
        return type;
    }

    public void setType(ProductCommandEventTypeEnum type) {
        this.type = type;
    }

    public EventProductDTO getProduct() {
        return product;
    }

    public void setProduct(EventProductDTO product) {
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
