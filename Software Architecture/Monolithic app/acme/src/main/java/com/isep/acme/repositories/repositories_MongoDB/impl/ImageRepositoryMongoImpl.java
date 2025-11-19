package com.isep.acme.repositories.repositories_MongoDB.impl;

import com.isep.acme.model.model_MongoDB.ProdImageMongo;
import com.isep.acme.repositories.repositories_MongoDB.ImageRepositoryMongo;
import com.isep.acme.utils.ServiceUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public class ImageRepositoryMongoImpl implements ImageRepositoryMongo {

    /*@Autowired
    ImageRepositoryMongo mongoRepository;

    public ImageRepositoryMongoImpl(ImageRepositoryMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }
*/
    @Override
    public <S extends ProdImageMongo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProdImageMongo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<ProdImageMongo> findAll() {
        return null;
    }

    @Override
    public Iterable<ProdImageMongo> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ProdImageMongo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProdImageMongo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ProdImageMongo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProdImageMongo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProdImageMongo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProdImageMongo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProdImageMongo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ProdImageMongo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
