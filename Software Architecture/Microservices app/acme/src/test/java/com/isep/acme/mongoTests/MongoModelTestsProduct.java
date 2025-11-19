package com.isep.acme.mongoTests;

import com.isep.acme.model.mongoDB.ProductMongo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MongoModelTestsProduct {

    @Test
    public void testInvalidSkuCreation() {
        assertThrows(IllegalArgumentException.class, () -> new ProductMongo("", "Sample Product", "Description"));
    }

    @Test
    public void testInvalidDesignationCreation() {
        assertThrows(IllegalArgumentException.class, () -> new ProductMongo("SKU111", "", "Description"));
    }

    @Test
    public void testInvalidDescriptionCreation() {
        assertThrows(IllegalArgumentException.class, () -> new ProductMongo("SKU111", "Sample Product", ""));
    }

    @Test
    public void testDesignationBlankValidation() {
        assertThrows(IllegalArgumentException.class, () -> new ProductMongo("SKU12345", "", "Description"));
    }

    @Test
    public void testDescriptionBlankValidation() {
        String longDescription = "";
        assertThrows(IllegalArgumentException.class, () -> new ProductMongo("SKU12345", "Sample Product", longDescription));
    }
}
