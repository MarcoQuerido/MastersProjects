package com.isep.acme.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.Rating;

import java.util.Optional;

public interface RatingRepository{

    @Query("SELECT r FROM Rating r WHERE r.rate=:rate")
    Optional<Rating> findByRate(Double rate);

    void save(Rating rating);
}
