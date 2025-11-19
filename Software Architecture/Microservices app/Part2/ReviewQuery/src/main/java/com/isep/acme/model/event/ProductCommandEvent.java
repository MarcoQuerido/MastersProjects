package com.isep.acme.model.event;

public class ProductCommandEvent {

    private String id;

    private ProductCommandEventTypeEnum type;

    private EventProductDTO product;

    public ProductCommandEvent(String id, ProductCommandEventTypeEnum type, EventProductDTO product) {
        this.id = id;
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
