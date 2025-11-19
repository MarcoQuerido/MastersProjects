package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.Rating;
import com.isep.acme.model.mongoDB.RatingMongo;
import com.isep.acme.repositories.RatingRepository;
import com.isep.acme.repositories.mongoDB.RatingRepositoryMongo;
import com.isep.acme.utils.ServiceUtils;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile(ServiceUtils.MONGO_DB_PROFILE)
public class RatingRepositoryMongoImpl implements RatingRepository {

    RatingRepositoryMongo repo;

    @Override
    public Optional<Rating> findByRate(Double rate) {
        Optional<RatingMongo> optional = repo.findByRate(rate);
        return optional.map(ConversionUtils::fromRatingMongoToRating);
    }

    @Override
    public void save(Rating rating) {
        RatingMongo ratingMongo = ConversionUtils.fromRatingToRatingMongo(rating);
        repo.save(ratingMongo);
    }
}
