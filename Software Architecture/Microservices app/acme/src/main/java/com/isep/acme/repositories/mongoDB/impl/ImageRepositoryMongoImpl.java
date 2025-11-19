package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.ProdImage;
import com.isep.acme.repositories.ImageRepository;
import com.isep.acme.utils.ServiceUtils;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile(ServiceUtils.MONGO_DB_PROFILE)
public class ImageRepositoryMongoImpl implements ImageRepository {

    @Override
    public Optional<ProdImage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<ProdImage> findAll() {
        return null;
    }
}
