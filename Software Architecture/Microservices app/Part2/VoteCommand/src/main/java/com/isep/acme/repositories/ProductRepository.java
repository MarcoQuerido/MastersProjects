package com.isep.acme.repositories;

import com.isep.acme.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findBySku(String sku);

    @Transactional
    void deleteBySku(String sku);

}

