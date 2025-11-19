package com.isep.acme.repositories.neo4j.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.isep.acme.mappers.Neo4JMapperAggregatedRating;
import com.isep.acme.model.AggregatedRating;
import com.isep.acme.model.Product;
import com.isep.acme.model.neo4j.AggregatedRatingNeo4J;
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
    public AggregatedRating save(final AggregatedRating aggregatedRating) {
        return Neo4JMapperAggregatedRating.INSTANCE.mapToDataModel(
                pRepo.save(Neo4JMapperAggregatedRating.INSTANCE.mapToNeo4JModel(aggregatedRating)));
    }
}
