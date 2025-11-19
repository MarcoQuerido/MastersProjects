package com.isep.acme.repositories;

import com.isep.acme.model.Product;
import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.Review;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByProduct(Product p);

}
