package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromRatingToRatingNeo4J;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.isep.acme.model.Rating;
import com.isep.acme.model.neo4j.RatingNeo4J;
import com.isep.acme.repositories.RatingRepository;
import com.isep.acme.repositories.neo4j.RatingRepositoryNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Profile(ServiceUtils.NEO4J_PROFILE)
public class RatingRepositoryNeo4JImpl implements RatingRepository {

    @Autowired
    RatingRepositoryNeo4J pRepo;

    @Override
    public Optional<Rating> findByRate(final Double rate) {
        Optional<RatingNeo4J> ratingNeo4JOptional = pRepo.findByRate(rate);
        return ratingNeo4JOptional.map(ConversionUtils::fromRatingNeo4JToRating);
    }

    @Override
    public void save(final Rating rating) {
        RatingNeo4J ratingNeo4J = fromRatingToRatingNeo4J(rating);
        pRepo.save(ratingNeo4J);
    }
}
