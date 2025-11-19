package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProdImageNeo4JToProdImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.isep.acme.model.ProdImage;
import com.isep.acme.model.neo4j.ProdImageNeo4J;
import com.isep.acme.repositories.ImageRepository;
import com.isep.acme.repositories.neo4j.ImageRepositoryNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Profile(ServiceUtils.NEO4J_PROFILE)
public class ImageRepositoryNeo4JImpl implements ImageRepository {
    @Autowired
    ImageRepositoryNeo4J pRepo;

    @Override
    public Optional<ProdImage> findById(final Long id) {
        Optional<ProdImageNeo4J> prodImageNeo4JOptional = pRepo.findById(id);
        return prodImageNeo4JOptional.map(ConversionUtils::fromProdImageNeo4JToProdImage);
    }

    @Override
    public Iterable<ProdImage> findAll() {
        Iterable<ProdImageNeo4J> iterable = pRepo.findAll();
        List<ProdImage> prodImages = new ArrayList<>();

        for (ProdImageNeo4J prodImageNeo4J : iterable) {
            ProdImage prodImage = fromProdImageNeo4JToProdImage(prodImageNeo4J);
            prodImages.add(prodImage);
        }

        return prodImages;
    }
}
