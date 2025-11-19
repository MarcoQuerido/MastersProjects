package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.User;
import com.isep.acme.model.mongoDB.UserMongo;
import com.isep.acme.repositories.UserRepository;
import com.isep.acme.repositories.mongoDB.UserRepositoryMongo;
import com.isep.acme.utils.ServiceUtils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile(ServiceUtils.MONGO_DB_PROFILE)
public class UserRepositoryMongoImpl implements UserRepository {

    UserRepositoryMongo repo;

    @Override
    public <S extends User> S save(S entity) {
        UserMongo userMongo = ConversionUtils.fromUserToUserMongo(entity);
        repo.save(userMongo);
        return entity;
    }

    @Override
    @Cacheable
    public Optional<User> findById(Long userId) {
        Optional<UserMongo> optional = repo.findById(userId.toString());
        return optional.map(ConversionUtils::fromUserMongoToUser);
    }

    @Override
    @Cacheable
    public Optional<User> findByUsername(String username) {
        Optional<UserMongo> optional = repo.findByUsername(username);
        return optional.map(ConversionUtils::fromUserMongoToUser);
    }
}
