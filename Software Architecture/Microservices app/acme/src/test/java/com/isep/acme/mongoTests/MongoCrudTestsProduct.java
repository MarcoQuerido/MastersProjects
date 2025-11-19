package com.isep.acme.mongoTests;

import com.isep.acme.SkuGenerator1;
import com.isep.acme.model.mongoDB.ProductMongo;
import com.isep.acme.repositories.mongoDB.ProductRepositoryMongo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test") // Activate the test profile
public class MongoCrudTestsProduct {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    ProductRepositoryMongo productRepositoryMongo;


    @BeforeEach
    public void setUp() {
        // Drop database collections for a fresh state for each test case
        mongoTemplate.dropCollection(ProductMongo.class);
    }

    @Test
    public void testFindProductById() {
        // Create a new product
        ProductMongo product2 = new ProductMongo("k485b1l47h5b", "Produto1", "um produto");
        product2 = productRepositoryMongo.save(product2);

        // Find the product by ID
        ProductMongo foundProduct = productRepositoryMongo.findById(product2.getProductID()).orElse(null);

        // Check if the product was found
        assertNotNull(foundProduct);
        assertEquals(product2.getDesignation(), foundProduct.getDesignation());
    }

    @Test
    public void testSaveProduct() {
        // Create a new product
        ProductMongo product = new ProductMongo("c475e9l47f5b", "Produto2", "outro produto");
        // Save the product to the database
        product = productRepositoryMongo.save(product);
        // Check if the product was saved and has an ID
        assertNotNull(product.getProductID());
    }

    @Test
    public void testUpdateProductBySku() {
        // Define a SKU of the product to update
        String skuToUpdate = "z205bgo47hoc";

        // Create a sample product to update
        ProductMongo product = new ProductMongo("n385j1l17h8s", "Produto3", "ainda mais produto");
        product.setSku(skuToUpdate);
        product.setDescription("produto a atualizar");

        // Save the product
        productRepositoryMongo.save(product);

        // Verify that the product is saved
        Optional<ProductMongo> savedProduct = productRepositoryMongo.findBySku(skuToUpdate);
        assertTrue(savedProduct.isPresent());

        // Modify the product
        ProductMongo updatedProduct = savedProduct.get();
        updatedProduct.setDescription("descricao do produto atualizada");

        // Update the product in the repository
        productRepositoryMongo.save(updatedProduct);

        // Verify that the product is updated
        Optional<ProductMongo> retrievedProduct = productRepositoryMongo.findBySku(skuToUpdate);
        assertTrue(retrievedProduct.isPresent());
        assertEquals("descricao do produto atualizada", retrievedProduct.get().getDescription());
    }

    @Test
    public void testDeleteProductBySku() {
        // Define a SKU of the product to delete
        String skuToDelete = "h274h5l4563b";

        // Create a sample product to save
        ProductMongo product = new ProductMongo("b523h5l487kl", "Produto3", "mais um produto");
        product.setSku(skuToDelete);
        product.setDescription("produto a ser apagado");

        // Save the product
        productRepositoryMongo.save(product);

        // Verify that the product is saved
        Optional<ProductMongo> savedProduct = productRepositoryMongo.findBySku(skuToDelete);
        assertTrue(savedProduct.isPresent());

        // Delete the product by SKU
        productRepositoryMongo.deleteBySku(skuToDelete);

        // Verify that the product is deleted
        Optional<ProductMongo> deletedProduct = productRepositoryMongo.findBySku(skuToDelete);
        assertTrue(deletedProduct.isEmpty());
    }

    @Test
    public void testCreateProductWithSkuGenerator() {
        // Generate a new SKU using the SkuGenerator
        String newSku = SkuGenerator1.generateSku();

        // Create a sample product with the generated SKU
        ProductMongo product = new ProductMongo("x258f5l48475", "Produto Novo", "geraoo com skugenerator");
        product.setSku(newSku);
        product.setDescription("Sample Product");

        // Save the product
        productRepositoryMongo.save(product);

        // Verify that the product is saved
        Optional<ProductMongo> savedProduct = productRepositoryMongo.findBySku(newSku);
        assertTrue(savedProduct.isPresent());
        assertEquals(newSku, savedProduct.get().getSku());
    }
}
