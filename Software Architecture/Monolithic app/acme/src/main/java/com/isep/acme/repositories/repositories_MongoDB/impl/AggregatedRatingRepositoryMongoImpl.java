package com.isep.acme.repositories.repositories_MongoDB.impl;

import com.isep.acme.model.model_MongoDB.AggregatedRatingMongo;
import com.isep.acme.model.model_MongoDB.ProductMongo;
import com.isep.acme.repositories.repositories_MongoDB.AggregatedRatingRepositoryMongo;
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
public class AggregatedRatingRepositoryMongoImpl implements AggregatedRatingRepositoryMongo {

/*  public AggregatedRatingRepositoryMongoImpl(AggregatedRatingRepositoryMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }*/

    @Override
    public Optional<AggregatedRatingMongo> findByProduct(ProductMongo product) {
        return Optional.empty();
    }

    @Override
    public <S extends AggregatedRatingMongo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AggregatedRatingMongo> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<AggregatedRatingMongo> findAll() {
        return null;
    }

    @Override
    public Iterable<AggregatedRatingMongo> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(AggregatedRatingMongo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends AggregatedRatingMongo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AggregatedRatingMongo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AggregatedRatingMongo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AggregatedRatingMongo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AggregatedRatingMongo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AggregatedRatingMongo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AggregatedRatingMongo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
