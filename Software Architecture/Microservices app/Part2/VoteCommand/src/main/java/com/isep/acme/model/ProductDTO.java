package com.isep.acme.model;

import org.springframework.data.annotation.PersistenceConstructor;

public class ProductDTO {

    private Long id;
    private String sku;

    @PersistenceConstructor
    public ProductDTO(Long id, String sku) {
        this.id = id;
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                '}';
    }
}
