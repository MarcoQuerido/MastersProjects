package com.isep.acme.repositories;

import com.isep.acme.model.event.ReviewCommandEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCommandEventRepository extends MongoRepository<ReviewCommandEvent, String> {

}

