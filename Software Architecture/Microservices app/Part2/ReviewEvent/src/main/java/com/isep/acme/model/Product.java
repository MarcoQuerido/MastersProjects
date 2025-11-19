package com.isep.acme.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Product {

    @Id
    private Long productID;

    @Column(nullable = false, unique = true)
    private String sku;

    protected Product() {
    }

    public Product(final Long productID, final String sku) {
        this.productID = Objects.requireNonNull(productID);
        setSku(sku);
    }

    public void setSku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is a mandatory attribute of Product.");
        }
        if (sku.length() != 12) {
            throw new IllegalArgumentException("SKU must be 12 characters long.");
        }

        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public ProductDTO toDto() {
        return new ProductDTO(this.productID, this.sku);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", sku='" + sku + '\'' +
                '}';
    }
}
