package com.isep.acme.services;

import java.util.List;
import java.util.Optional;

import com.isep.acme.model.ProductDTO;

public interface ProductService {

    Optional<ProductDTO> findBySku(final String sku);

    List<ProductDTO> findByDesignation(final String designation);

    List<ProductDTO> getCatalog();

    ProductDTO create(final ProductDTO productDTO);

    ProductDTO updateBySku(final String sku, final ProductDTO productDTO);

    void deleteBySku(final String sku);

}
