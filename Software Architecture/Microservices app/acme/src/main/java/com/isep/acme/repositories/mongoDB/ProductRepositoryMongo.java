package com.isep.acme.repositories.mongoDB;

import com.isep.acme.model.mongoDB.ProductMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

//@Document(collection = "product")
//@Repository
//@Profile(ServiceUtils.MONGO_DB_PROFILE)
public interface ProductRepositoryMongo extends MongoRepository<ProductMongo, String> {

    List<ProductMongo> findByDesignation(String designation);
    Optional<ProductMongo> findBySku(String sku);
    Optional<ProductMongo> findById(String id);
    void deleteBySku(String sku);

    ProductMongo updateBySku(String sku, String newSku);
}
