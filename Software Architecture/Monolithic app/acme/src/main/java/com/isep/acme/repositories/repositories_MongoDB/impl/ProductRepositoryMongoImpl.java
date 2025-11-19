package com.isep.acme.repositories.repositories_MongoDB.impl;

import com.isep.acme.model.model_MongoDB.ProductMongo;
import com.isep.acme.repositories.repositories_MongoDB.ProductRepositoryMongo;
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
public class ProductRepositoryMongoImpl implements ProductRepositoryMongo {

    /*@Autowired
    ProductRepositoryMongo mongoRepository;

    public ProductRepositoryMongoImpl(ProductRepositoryMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }*/

    @Override
    public List<ProductMongo> findByDesignation(String designation) {
        return null;
    }

    @Override
    public Optional<ProductMongo> findBySku(String sku) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductMongo> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void deleteBySku(String sku) {

    }

    @Override
    public <S extends ProductMongo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProductMongo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<ProductMongo> findAll() {
        return null;
    }

    @Override
    public Iterable<ProductMongo> findAllById(Iterable<String> strings) {
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
    public void delete(ProductMongo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductMongo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ProductMongo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductMongo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductMongo> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends ProductMongo> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ProductMongo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductMongo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductMongo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProductMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductMongo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductMongo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ProductMongo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
