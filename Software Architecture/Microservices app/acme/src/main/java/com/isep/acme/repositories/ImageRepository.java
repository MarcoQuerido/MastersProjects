package com.isep.acme.repositories;

import java.util.Optional;

import com.isep.acme.model.ProdImage;

public interface ImageRepository{
    Optional<ProdImage> findById(Long id);

    Iterable<ProdImage> findAll();
}
