package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProductNeo4JToProduct;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProductToProductNeo4J;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
    public Optional<Product> getCatalog(final String sku, final String description) {
        Optional<ProductNeo4J> productNeo4Js = pRepo.getCatalog(sku, description);
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
    public Optional<Product> findById(final Long productID) {

        Optional<ProductNeo4J> productNeo4JOptional = pRepo.findById(productID);
        return productNeo4JOptional.map(ConversionUtils::fromProductNeo4JToProduct);
    }

    @Override
    @Transactional
    public Product save(final Product p) {
        ProductNeo4J productNeo4J = fromProductToProductNeo4J(p);
        pRepo.save(productNeo4J);
        return p;
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
}
