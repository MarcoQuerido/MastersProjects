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
    private ProductRepository repository;

    @Override
    public Optional<ProductDTO> findBySku(String sku) {
        final Optional<Product> product = repository.findBySku(sku);

        if (product.isEmpty())
            return Optional.empty();
        else
            return Optional.of(product.get().toDto());
    }


    @Override
    public Iterable<ProductDTO> findByDesignation(final String designation) {
        Iterable<Product> p = repository.findByDesignation(designation);
        List<ProductDTO> pDto = new ArrayList();
        for (Product pd : p) {
            pDto.add(pd.toDto());
        }

        return pDto;
    }

    @Override
    public Iterable<ProductDTO> getCatalog() {
        Iterable<Product> p = repository.findAll();
        List<ProductDTO> pDto = new ArrayList();
        for (Product pd : p) {
            pDto.add(pd.toDto());
        }

        return pDto;
    }

    @Override
    public ProductDTO create(final ProductDTO productDTO) {
        final Product p = new Product(productDTO.getSku(),
                productDTO.getDesignation(),
                productDTO.getDescription(),
                productDTO.getImageUrl());

        return repository.save(p).toDto();
    }

    @Override
    public ProductDTO updateBySku(String sku, ProductDTO productDTO) {

        final Optional<Product> productToUpdateOpt = repository.findBySku(sku);

        if (productToUpdateOpt.isEmpty()) return null;

        Product productToUpdate = productToUpdateOpt.get();
        productToUpdate.setDescription(productDTO.getDescription());
        productToUpdate.setDesignation(productDTO.getDesignation());
        productToUpdate.setImageURL(productDTO.getImageUrl());

        Product productUpdated = repository.save(productToUpdate);

        return productUpdated.toDto();
    }

    @Override
    public void deleteBySku(String sku) {
        Optional<Product> optProduct = repository.findBySku(sku);

        if (optProduct.isPresent()) {
            repository.delete(optProduct.get());
        } else {
            throw new IllegalArgumentException(String.format("Unable to delete product with sku %s", sku));
        }
    }
}
