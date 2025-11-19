package com.isep.acme.repositories.repositories_MongoDB.impl;

import com.isep.acme.model.model_MongoDB.RatingMongo;
import com.isep.acme.repositories.repositories_MongoDB.RatingRepositoryMongo;
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
public class RatingRepositoryMongoImpl implements RatingRepositoryMongo {

    /*@Autowired
    RatingRepositoryMongo mongoRepository;

    public RatingRepositoryMongoImpl(RatingRepositoryMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }
*/
    @Override
    public Optional<RatingMongo> findByRate(Double rate) {
        return Optional.empty();
    }

    @Override
    public <S extends RatingMongo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RatingMongo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RatingMongo> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<RatingMongo> findAll() {
        return null;
    }

    @Override
    public Iterable<RatingMongo> findAllById(Iterable<String> strings) {
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
    public void delete(RatingMongo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends RatingMongo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<RatingMongo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RatingMongo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RatingMongo> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends RatingMongo> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends RatingMongo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RatingMongo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RatingMongo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RatingMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RatingMongo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RatingMongo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RatingMongo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
