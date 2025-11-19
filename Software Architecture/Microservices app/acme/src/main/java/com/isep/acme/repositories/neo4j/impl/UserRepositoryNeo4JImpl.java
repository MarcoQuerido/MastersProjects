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
    public Optional<User> findById(final Long userId) {
        Optional<UserNeo4J> userNeo4JOptional = pRepo.findById(userId);
        return userNeo4JOptional.map(ConversionUtils::fromUserNeo4JToUser);
    }

    @Override
    public User getById(final Long userId) {
        return UserRepository.super.getById(userId);
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        Optional<UserNeo4J> userNeo4J = pRepo.findByUsername(username);
        return userNeo4J.map(ConversionUtils::fromUserNeo4JToUser);
    }
}
