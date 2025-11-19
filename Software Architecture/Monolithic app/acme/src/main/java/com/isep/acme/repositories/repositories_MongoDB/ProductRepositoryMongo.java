package com.isep.acme.repositories.repositories_MongoDB;

import com.isep.acme.model.model_MongoDB.ProductMongo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

@Document(collection = "product")
public interface ProductRepositoryMongo extends MongoRepository<ProductMongo, String> {

    List<ProductMongo> findByDesignation(String designation);
    Optional<ProductMongo> findBySku(String sku);
    Optional<ProductMongo> findById(String id);
    void deleteBySku(String sku);
}
