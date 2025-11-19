package com.isep.acme.model;

import lombok.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
@Getter
public class Product {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    protected Product() {
    }

    public Product(final Long productID, final String sku) {
        this.id = Objects.requireNonNull(productID);
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

}
