package com.isep.acme.repositories.repositories_MongoDB;

import com.isep.acme.model.model_MongoDB.UserMongo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

@Document(collection = "user")
public interface UserRepositoryMongo extends MongoRepository<UserMongo, String> {
    Optional<UserMongo> findByUsername(String username);
}
