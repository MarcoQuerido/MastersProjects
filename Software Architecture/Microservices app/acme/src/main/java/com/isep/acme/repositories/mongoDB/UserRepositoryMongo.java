package com.isep.acme.repositories.mongoDB;

import com.isep.acme.model.mongoDB.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Document(collection = "user")
//@Repository
//@Profile(ServiceUtils.MONGO_DB_PROFILE)
public interface UserRepositoryMongo extends MongoRepository<UserMongo, String> {
    Optional<UserMongo> findById(String userId);

    Optional<UserMongo> findByUsername(String username);
}
