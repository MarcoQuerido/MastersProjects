package com.isep.acme.repositories.repositories_MongoDB.impl;

import com.isep.acme.model.model_MongoDB.ProductMongo;
import com.isep.acme.model.model_MongoDB.ReviewMongo;
import com.isep.acme.model.model_MongoDB.UserMongo;
import com.isep.acme.repositories.repositories_MongoDB.ReviewRepositoryMongo;
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
public class ReviewRepositoryMongoImpl implements ReviewRepositoryMongo {

    /*@Autowired
    ReviewRepositoryMongo mongoRepository;

    public ReviewRepositoryMongoImpl(ReviewRepositoryMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }*/

    @Override
    public Optional<List<ReviewMongo>> findByProduct(ProductMongo product) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewMongo>> findByApprovalStatus(String status) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewMongo>> findByProductAndApprovalStatus(ProductMongo product, String status) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewMongo>> findByUser(UserMongo userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewMongo>> getRecommendedReviews(List<ReviewMongo> reviews) {
        return Optional.empty();
    }

    @Override
    public <S extends ReviewMongo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ReviewMongo> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<ReviewMongo> findAll() {
        return null;
    }

    @Override
    public Iterable<ReviewMongo> findAllById(Iterable<String> strings) {
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
    public void delete(ReviewMongo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends ReviewMongo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ReviewMongo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ReviewMongo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ReviewMongo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ReviewMongo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ReviewMongo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ReviewMongo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
