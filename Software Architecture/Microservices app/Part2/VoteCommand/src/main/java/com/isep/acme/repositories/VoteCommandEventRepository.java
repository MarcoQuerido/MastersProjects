package com.isep.acme.repositories;

import com.isep.acme.model.event.VoteCommandEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteCommandEventRepository extends MongoRepository<VoteCommandEvent, String> {

}

