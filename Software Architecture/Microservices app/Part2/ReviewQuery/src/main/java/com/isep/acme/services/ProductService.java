package com.isep.acme.services;

import com.isep.acme.model.Product;
import com.isep.acme.model.Review;

import java.util.List;

public interface ProductService {

    Product addProduct(Long productId, String sku);

    List<Review> deleteProductBySku(String sku);

}
