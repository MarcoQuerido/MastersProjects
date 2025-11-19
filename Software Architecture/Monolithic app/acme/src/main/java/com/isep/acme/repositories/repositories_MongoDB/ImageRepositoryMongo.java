package com.isep.acme.repositories.repositories_MongoDB;

import com.isep.acme.model.model_MongoDB.ProdImageMongo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document(collection = "image")
public interface ImageRepositoryMongo extends MongoRepository<ProdImageMongo, Long> {
}
