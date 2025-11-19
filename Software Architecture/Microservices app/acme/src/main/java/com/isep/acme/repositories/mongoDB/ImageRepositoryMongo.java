package com.isep.acme.repositories.mongoDB;

import com.isep.acme.model.mongoDB.ProdImageMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Document(collection = "image")
//@Repository
//@Profile(ServiceUtils.MONGO_DB_PROFILE)
public interface ImageRepositoryMongo extends MongoRepository<ProdImageMongo, Long> {
}
