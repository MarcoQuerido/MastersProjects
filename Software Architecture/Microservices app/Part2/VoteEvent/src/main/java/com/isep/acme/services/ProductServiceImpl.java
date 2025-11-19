package com.isep.acme.services;

import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository pRepository;

    @Override
    public Product addProduct(Long productId, String sku) {
        final Optional<Product> product = pRepository.findBySku(sku);
        if (product.isPresent())
            throw new IllegalArgumentException(String.format("Product with sku %s already exists", sku));

        Product p = new Product(productId, sku);

        return pRepository.save(p);
    }

    @Override
    public void deleteProductBySku(String sku) {
        Optional<Product> prod = pRepository.findBySku(sku);

        if (prod.isEmpty())
            throw new IllegalArgumentException(String.format("Product with sku %s not found", sku));

        pRepository.deleteBySku(sku);
    }

    @Override
    public List<ProductDTO> getProducts() {
        Iterable<Product> products = pRepository.findAll();

        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product p : products) {
            productDTOs.add(p.toDto());
        }

        return productDTOs;
    }

}