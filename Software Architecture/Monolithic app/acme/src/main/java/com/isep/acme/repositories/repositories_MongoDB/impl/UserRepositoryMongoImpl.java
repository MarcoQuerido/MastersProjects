package com.isep.acme.repositories.repositories_MongoDB.impl;

import com.isep.acme.model.model_MongoDB.UserMongo;
import com.isep.acme.repositories.repositories_MongoDB.UserRepositoryMongo;
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
public class UserRepositoryMongoImpl implements UserRepositoryMongo {

    /*@Autowired
    UserRepositoryMongo mongoRepository;

    public UserRepositoryMongoImpl(UserRepositoryMongo mongoRepository) {
        this.mongoRepository = mongoRepository;
    }
*/
    @Override
    public Optional<UserMongo> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public <S extends UserMongo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends UserMongo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UserMongo> findById(String aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String aLong) {
        return false;
    }

    @Override
    public List<UserMongo> findAll() {
        return null;
    }

    @Override
    public Iterable<UserMongo> findAllById(Iterable<String> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String aLong) {

    }

    @Override
    public void delete(UserMongo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserMongo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserMongo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserMongo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserMongo> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends UserMongo> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends UserMongo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserMongo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserMongo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserMongo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserMongo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserMongo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UserMongo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
