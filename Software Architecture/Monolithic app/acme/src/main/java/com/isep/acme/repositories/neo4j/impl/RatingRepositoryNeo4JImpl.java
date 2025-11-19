package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromRatingNeo4JToRating;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromRatingToRatingNeo4J;

import java.util.ArrayList;
import java.util.List;
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
    public <S extends Rating> S save(final S entity) {
        RatingNeo4J ratingNeo4J = fromRatingToRatingNeo4J(entity);
        pRepo.save(ratingNeo4J);
        return entity;
    }

    @Override
    public <S extends Rating> Iterable<S> saveAll(final Iterable<S> entities) {
        List<RatingNeo4J> ratingNeo4JList = new ArrayList<>();

        for (S entity : entities) {
            RatingNeo4J ratingNeo4J = fromRatingToRatingNeo4J(entity);
            ratingNeo4JList.add(ratingNeo4J);
        }

        pRepo.saveAll(ratingNeo4JList);
        return entities;
    }

    @Override
    public Optional<Rating> findById(final Long aLong) {
        Optional<RatingNeo4J> ratingNeo4JOptional = pRepo.findById(aLong);
        return ratingNeo4JOptional.map(ConversionUtils::fromRatingNeo4JToRating);


    }

    @Override
    public boolean existsById(final Long aLong) {
        return pRepo.existsById(aLong);
    }

    @Override
    public Iterable<Rating> findAll() {

        Iterable<RatingNeo4J> iterable = pRepo.findAll();
        List<Rating> ratings = new ArrayList<>();

        for (RatingNeo4J ratingNeo4J : iterable) {
            Rating rating = fromRatingNeo4JToRating(ratingNeo4J);
            ratings.add(rating);
        }

        return ratings;

    }

    @Override
    public Iterable<Rating> findAllById(final Iterable<Long> longs) {

        List<Rating> ratings = new ArrayList<>();
        for (Long ratingId : longs) {
            Optional<RatingNeo4J> ratingNeo4JOptional = pRepo.findById(ratingId);
            ratingNeo4JOptional.ifPresent(ratingNeo4J -> {
                Rating rating = fromRatingNeo4JToRating(ratingNeo4J);
                ratings.add(rating);
            });
        }
        return ratings;
    }

    @Override
    public long count() {
        return pRepo.count();
    }

    @Override
    public void deleteById(final Long aLong) {
        pRepo.deleteById(aLong);
    }

    @Override
    public void delete(final Rating entity) {
        pRepo.delete(fromRatingToRatingNeo4J(entity));
    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {
        for (Long ratingId : longs) {
            pRepo.deleteById(ratingId);
        }
    }

    @Override
    public void deleteAll(final Iterable<? extends Rating> entities) {
        for (Rating rating : entities) {
            RatingNeo4J reviewNeo4J = fromRatingToRatingNeo4J(rating);
            pRepo.delete(reviewNeo4J);
        }
    }

    @Override
    public void deleteAll() {
        pRepo.deleteAll();
    }
}
