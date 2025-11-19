package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProductNeo4JToProduct;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProductToProductNeo4J;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.isep.acme.model.neo4j.ProductNeo4J;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.neo4j.ProductRepositoryNeo4J;
import com.isep.acme.model.Product;
import com.isep.acme.utils.ServiceUtils;

@Profile(ServiceUtils.NEO4J_PROFILE)
public class ProductRepositoryNeo4JImpl implements ProductRepository {
    @Autowired
    ProductRepositoryNeo4J pRepo;

    @Override
    public List<Product> findByDesignation(final String designation) {

        List<Product> products = new ArrayList<>();
        Iterable<ProductNeo4J> productNeo4Js = pRepo.findByDesignation(designation);
        productNeo4Js.forEach(productNeo4J -> products.add(fromProductNeo4JToProduct(productNeo4J)));
        return products;
    }

    @Override
    public Optional<Product> findBySku(final String sku) {

        Optional<ProductNeo4J> productNeo4JOptional = pRepo.findBySku(sku);
        return productNeo4JOptional.map(ConversionUtils::fromProductNeo4JToProduct);
    }

    @Override
    public Optional<Product> getCatalog(final String sku, final String designation) {
        Optional<ProductNeo4J> productNeo4Js = pRepo.getCatalog(sku, designation);
        return productNeo4Js.map(ConversionUtils::fromProductNeo4JToProduct);
    }

    @Override
    public void deleteBySku(final String sku) {
        pRepo.deleteBySku(sku);
    }

    @Override
    public Product updateBySku(final String sku) {

        Optional<ProductNeo4J> productNeo4JOptional = pRepo.findBySku(sku);
        if (productNeo4JOptional.isPresent()) {
            ProductNeo4J productNeo4J = productNeo4JOptional.get();
            pRepo.save(productNeo4J);
            return fromProductNeo4JToProduct(productNeo4J);
        }
        return null;
    }

    @Override
    public <S extends Product> S save(final S entity) {
        ProductNeo4J productNeo4J = fromProductToProductNeo4J(entity);
        pRepo.save(productNeo4J);
        return entity;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(final Iterable<S> entities) {
        List<ProductNeo4J> userNeo4jList = new ArrayList<>();
        for (S entity : entities) {
            ProductNeo4J userNeo4j = fromProductToProductNeo4J(entity);
            userNeo4jList.add(userNeo4j);
        }
        pRepo.saveAll(userNeo4jList);
        return entities;
    }

    @Override
    public Optional<Product> findById(final Long productID) {

        Optional<ProductNeo4J> productNeo4JOptional = pRepo.findById(productID);
        return productNeo4JOptional.map(ConversionUtils::fromProductNeo4JToProduct);
    }

    @Override
    public boolean existsById(final Long aLong) {
        return pRepo.existsById(aLong);
    }

    @Override
    public Iterable<Product> findAll() {

        Iterable<ProductNeo4J> iterable = pRepo.findAll();
        List<Product> products = new ArrayList<>();

        for (ProductNeo4J productNeo4J : iterable) {
            Product product = fromProductNeo4JToProduct(productNeo4J);
            products.add(product);
        }

        return products;

    }

    @Override
    public Iterable<Product> findAllById(final Iterable<Long> longs) {

        List<Product> products = new ArrayList<>();
        for (Long productId : longs) {
            Optional<ProductNeo4J> productNeo4JOptional = pRepo.findById(productId);
            productNeo4JOptional.ifPresent(productNeo4J -> {
                Product product = fromProductNeo4JToProduct(productNeo4J);
                products.add(product);
            });
        }
        return products;
    }

    @Override
    public long count() {
        return pRepo.count();
    }

    @Override
    public void deleteById(final Long aLong) {
        pRepo.deleteById(aLong);
    }

    @Override
    public void delete(final Product entity) {
        pRepo.delete(fromProductToProductNeo4J(entity));
    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {
        for (Long productId : longs) {
            pRepo.deleteById(productId);
        }
    }

    @Override
    public void deleteAll(final Iterable<? extends Product> entities) {
        for (Product product : entities) {
            ProductNeo4J productNeo4J = fromProductToProductNeo4J(product);
            pRepo.delete(productNeo4J);
        }
    }

    @Override
    public void deleteAll() {
        pRepo.deleteAll();
    }


}
