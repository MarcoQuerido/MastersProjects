package com.isep.acme.repositories;

import com.isep.acme.model.Review;
import com.isep.acme.model.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, String> {

    List<Vote> findAllByReview(Review review);
}
