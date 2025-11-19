package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromUserNeo4JToUser;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromUserToUserNeo4J;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.isep.acme.model.User;
import com.isep.acme.model.neo4j.UserNeo4J;
import com.isep.acme.repositories.UserRepository;
import com.isep.acme.repositories.neo4j.UserRepositoryNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Profile(ServiceUtils.NEO4J_PROFILE)
public class UserRepositoryNeo4JImpl implements UserRepository {

    @Autowired
    UserRepositoryNeo4J pRepo;

    @Override
    public <S extends User> S save(final S entity) {
        UserNeo4J userNeo4j = fromUserToUserNeo4J(entity);
        pRepo.save(userNeo4j);
        return entity;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(final Iterable<S> entities) {
        List<UserNeo4J> userNeo4jList = new ArrayList<>();

        for (S entity : entities) {
            UserNeo4J userNeo4j = fromUserToUserNeo4J(entity);
            userNeo4jList.add(userNeo4j);
        }

        pRepo.saveAll(userNeo4jList);
        return entities;
    }

    @Override
    public Optional<User> findById(final Long userId) {
        Optional<UserNeo4J> userNeo4JOptional = pRepo.findById(userId);
        return userNeo4JOptional.map(ConversionUtils::fromUserNeo4JToUser);
    }

    @Override
    public boolean existsById(final Long aLong) {
        return pRepo.existsById(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        Iterable<UserNeo4J> iterable = pRepo.findAll();
        List<User> users = new ArrayList<>();

        for (UserNeo4J userNeo4J : iterable) {
            User user = fromUserNeo4JToUser(userNeo4J);
            users.add(user);
        }

        return users;
    }

    @Override
    public Iterable<User> findAllById(final Iterable<Long> longs) {
        List<User> users = new ArrayList<>();
        for (Long userId : longs) {
            Optional<UserNeo4J> userNeo4JOptional = pRepo.findById(userId);
            userNeo4JOptional.ifPresent(userNeo4J -> {
                User user = fromUserNeo4JToUser(userNeo4J);
                users.add(user);
            });
        }
        return users;
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
    public void delete(final User entity) {
        pRepo.delete(fromUserToUserNeo4J(entity));
    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {
        for (Long userId : longs) {
            pRepo.deleteById(userId);
        }
    }

    @Override
    public void deleteAll(final Iterable<? extends User> entities) {
        for (User user : entities) {
            UserNeo4J userNeo4J = fromUserToUserNeo4J(user);
            pRepo.delete(userNeo4J);
        }
    }

    @Override
    public void deleteAll() {
        pRepo.deleteAll();
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        Optional<UserNeo4J> userNeo4J = pRepo.findByUsername(username);
        return userNeo4J.map(ConversionUtils::fromUserNeo4JToUser);
    }

}
