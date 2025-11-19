package com.isep.acme.repositories.neo4j.impl;

import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromAggregatedRatingToAggregatedRatingNeo4J;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromReviewNeo4JToReview;
import static com.isep.acme.repositories.neo4j.impl.ConversionUtils.fromReviewToReviewNeo4J;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.isep.acme.model.AggregatedRating;
import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.neo4j.AggregatedRatingNeo4J;
import com.isep.acme.model.neo4j.ReviewNeo4J;
import com.isep.acme.repositories.AggregatedRatingRepository;
import com.isep.acme.repositories.neo4j.AggregatedRatingRepositoryNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Profile(ServiceUtils.NEO4J_PROFILE)
public class AggregatedRatingRepositoryNeo4JImpl implements AggregatedRatingRepository {
    @Autowired
    AggregatedRatingRepositoryNeo4J pRepo;

    @Override
    public Optional<AggregatedRating> findByProductId(final Product product) {
        Optional<AggregatedRatingNeo4J> aggregatedRatingNeo4JOptional = pRepo.findByProductId(product.getProductID());
        return aggregatedRatingNeo4JOptional.map(ConversionUtils::fromAggregatedRatingToAggregatedRatingNeo4J);
    }

    @Override
    public <S extends AggregatedRating> S save(final S entity) {
        AggregatedRatingNeo4J aggregatedRatingNeo4J = fromAggregatedRatingToAggregatedRatingNeo4J(entity);
        pRepo.save(aggregatedRatingNeo4J);
        return entity;
    }

    @Override
    public <S extends AggregatedRating> Iterable<S> saveAll(final Iterable<S> entities) {
        List<AggregatedRatingNeo4J> aggregatedRatingNeo4JList = new ArrayList<>();

        for (S entity : entities) {
            AggregatedRatingNeo4J aggregatedRatingNeo4J = fromAggregatedRatingToAggregatedRatingNeo4J(entity);
            aggregatedRatingNeo4JList.add(aggregatedRatingNeo4J);
        }

        pRepo.saveAll(aggregatedRatingNeo4JList);
        return entities;
    }

    @Override
    public Optional<AggregatedRating> findById(final Long aLong) {
        Optional<AggregatedRatingNeo4J> aggregatedRatingNeo4JOptional = pRepo.findById(aLong);
        return aggregatedRatingNeo4JOptional.map(ConversionUtils::fromAggregatedRatingToAggregatedRatingNeo4J);

    }

    @Override
    public boolean existsById(final Long aLong) {
        return pRepo.existsById(aLong);
    }

    @Override
    public Iterable<AggregatedRating> findAll() {
        Iterable<AggregatedRatingNeo4J> iterable = pRepo.findAll();
        List<AggregatedRating> aggregatedRatings = new ArrayList<>();

        for (AggregatedRatingNeo4J aggregatedRatingNeo4J : iterable) {
            AggregatedRating aggregatedRating = fromAggregatedRatingToAggregatedRatingNeo4J(aggregatedRatingNeo4J);
            aggregatedRatings.add(aggregatedRating);
        }

        return aggregatedRatings;

    }

    @Override
    public Iterable<AggregatedRating> findAllById(final Iterable<Long> longs) {
        List<AggregatedRating> aggregatedRatings = new ArrayList<>();
        for (Long aggregatedRatingId : longs) {
            Optional<AggregatedRatingNeo4J> aggregatedRatingNeo4JOptional = pRepo.findById(aggregatedRatingId);
            aggregatedRatingNeo4JOptional.ifPresent(aggregatedRatingNeo4J -> {
                AggregatedRating aggregatedRating = fromAggregatedRatingToAggregatedRatingNeo4J(aggregatedRatingNeo4J);
                aggregatedRatings.add(aggregatedRating);
            });
        }
        return aggregatedRatings;
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
    public void delete(final AggregatedRating entity) {
        pRepo.delete(fromAggregatedRatingToAggregatedRatingNeo4J(entity));
    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {
        for (Long aggregatedRatingId : longs) {
            pRepo.deleteById(aggregatedRatingId);
        }
    }

    @Override
    public void deleteAll(final Iterable<? extends AggregatedRating> entities) {
        for (AggregatedRating review : entities) {
            AggregatedRatingNeo4J reviewNeo4J = fromAggregatedRatingToAggregatedRatingNeo4J(review);
            pRepo.delete(reviewNeo4J);
        }
    }

    @Override
    public void deleteAll() {
        pRepo.deleteAll();
    }
}
