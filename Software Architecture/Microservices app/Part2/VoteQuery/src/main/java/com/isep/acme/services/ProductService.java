package com.isep.acme.services;

import com.isep.acme.model.Product;

public interface ProductService {

    Product addProduct(Long productId, String sku);

    void deleteProductBySku(String sku);

}
