package com.isep.acme.repositories.mongoDB.impl;

import com.isep.acme.model.AggregatedRating;
import com.isep.acme.model.Product;
import com.isep.acme.model.mongoDB.AggregatedRatingMongo;
import com.isep.acme.repositories.AggregatedRatingRepository;
import com.isep.acme.repositories.mongoDB.AggregatedRatingRepositoryMongo;
import com.isep.acme.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile(ServiceUtils.MONGO_DB_PROFILE)
public class AggregatedRatingRepositoryMongoImpl implements AggregatedRatingRepository {

    private final AggregatedRatingRepositoryMongo repo;

    @Autowired
    public AggregatedRatingRepositoryMongoImpl(@Lazy AggregatedRatingRepositoryMongo repo) {
        this.repo = repo;
    }

    @Override
    public Optional<AggregatedRating> findByProductId(Product product) {
        Optional<AggregatedRatingMongo> aggregatedRatingMongo = repo.findByProduct_ProductID(product.getProductID().toString());
        return aggregatedRatingMongo.map(ConversionUtils::fromAggregatedRatingMongoToAggregatedRating);
    }

    @Override
    public AggregatedRating save(AggregatedRating aggregatedRating) {
        AggregatedRatingMongo aggregatedRatingMongo = repo.save(ConversionUtils.fromAggregatedRatingToAggregatedRatingMongo(aggregatedRating));
        return ConversionUtils.fromAggregatedRatingMongoToAggregatedRating(aggregatedRatingMongo);
    }
}
