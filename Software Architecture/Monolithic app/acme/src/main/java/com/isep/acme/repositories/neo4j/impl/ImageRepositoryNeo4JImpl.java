package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProdImageNeo4JToProdImage;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromProdImageToProdImageNeo4J;

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
    public <S extends ProdImage> S save(final S entity) {
        ProdImageNeo4J prodImageNeo4J = fromProdImageToProdImageNeo4J(entity);
        pRepo.save(prodImageNeo4J);
        return entity;
    }

    @Override
    public <S extends ProdImage> Iterable<S> saveAll(final Iterable<S> entities) {
        List<ProdImageNeo4J> prodImageNeo4JList = new ArrayList<>();

        for (S entity : entities) {
            ProdImageNeo4J prodImageNeo4J = fromProdImageToProdImageNeo4J(entity);
            prodImageNeo4JList.add(prodImageNeo4J);
        }

        pRepo.saveAll(prodImageNeo4JList);
        return entities;
    }

    @Override
    public Optional<ProdImage> findById(final Long aLong) {

        Optional<ProdImageNeo4J> prodImageNeo4JOptional = pRepo.findById(aLong);
        return prodImageNeo4JOptional.map(ConversionUtils::fromProdImageNeo4JToProdImage);

    }

    @Override
    public boolean existsById(final Long aLong) {
        return pRepo.existsById(aLong);
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

    @Override
    public Iterable<ProdImage> findAllById(final Iterable<Long> longs) {

        List<ProdImage> prodImages = new ArrayList<>();
        for (Long prodImageId : longs) {
            Optional<ProdImageNeo4J> prodImageNeo4JOptional = pRepo.findById(prodImageId);
            prodImageNeo4JOptional.ifPresent(prodImageNeo4J -> {
                ProdImage prodImage = fromProdImageNeo4JToProdImage(prodImageNeo4J);
                prodImages.add(prodImage);
            });
        }
        return prodImages;
    }

    @Override
    public long count() {
        return pRepo.count();
    }

    @Override
    public void deleteById(final Long aLong) {
        pRepo.deleteById(aLong);
    }

    @Override
    public void delete(final ProdImage entity) {
        pRepo.delete(fromProdImageToProdImageNeo4J(entity));
    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {
        for (Long prodImageId : longs) {
            pRepo.deleteById(prodImageId);
        }
    }

    @Override
    public void deleteAll(final Iterable<? extends ProdImage> entities) {
        for (ProdImage prodImage : entities) {
            ProdImageNeo4J prodImageNeo4J = fromProdImageToProdImageNeo4J(prodImage);
            pRepo.delete(prodImageNeo4J);
        }
    }

    @Override
    public void deleteAll() {
        pRepo.deleteAll();
    }
}
