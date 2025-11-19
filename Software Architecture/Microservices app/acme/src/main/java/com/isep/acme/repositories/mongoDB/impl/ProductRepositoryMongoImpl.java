package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.Product;
import com.isep.acme.model.mongoDB.ProductMongo;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.mongoDB.ProductRepositoryMongo;
import com.isep.acme.utils.ServiceUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile(ServiceUtils.MONGO_DB_PROFILE)
public class ProductRepositoryMongoImpl implements ProductRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final ProductRepositoryMongo repo;

    @Autowired
    public ProductRepositoryMongoImpl(@Lazy ProductRepositoryMongo repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> findByDesignation(String designation) {
        List<ProductMongo> list = repo.findByDesignation(designation);
        return list.stream().map(ConversionUtils::fromProductMongoToProduct).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        Optional<ProductMongo> optional = repo.findBySku(sku);
        return optional.map(ConversionUtils::fromProductMongoToProduct);
    }

    @Override
    public Optional<Product> getCatalog(String sku, String description) {
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("sku").is(sku),
                Criteria.where("description").is(description)
        );

        Query query = new Query(criteria);
        ProductMongo productMongo = mongoTemplate.findOne(query, ProductMongo.class);

        return Optional.of(ConversionUtils.fromProductMongoToProduct(productMongo));
    }

    @Override
    public void deleteBySku(String sku) {
        Optional<ProductMongo> optional = repo.findBySku(sku);
        optional.ifPresent(productMongo -> repo.delete(productMongo));
    }

    @Override
    public Product updateBySku(String sku) {
        Optional<ProductMongo> optional = repo.findBySku(sku);
        if (optional.isPresent()) {
            ProductMongo productMongo = optional.get();
            repo.save(productMongo);
            return ConversionUtils.fromProductMongoToProduct(productMongo);
        }
        return null;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long productID) {
        Optional<ProductMongo> optional = repo.findById(productID.toString());
        return optional.map(ConversionUtils::fromProductMongoToProduct);
    }

    @Override
    public Product save(Product product) {
        ProductMongo productMongo = repo.save(ConversionUtils.fromProductToProductMongo(product));
        return ConversionUtils.fromProductMongoToProduct(productMongo);
    }
}