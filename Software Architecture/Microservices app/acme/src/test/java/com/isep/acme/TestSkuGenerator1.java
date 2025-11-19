package com.isep.acme;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestSkuGenerator1 {

    @Test
    void testGenerateSku() {
        // Generate SKUs and ensure they have the correct length
        for (int i = 0; i < 100; i++) {
            String sku = SkuGenerator1.generateSku();
            assertNotNull(sku);
            assertEquals(12, sku.length());
        }
    }

    @Test
    void testGeneratedSkusAreUnique() {
        // Generate a set of SKUs and ensure they are all unique
        Set<String> generatedSkus = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            String sku = SkuGenerator1.generateSku();
            assertTrue(generatedSkus.add(sku));
        }
    }
}
