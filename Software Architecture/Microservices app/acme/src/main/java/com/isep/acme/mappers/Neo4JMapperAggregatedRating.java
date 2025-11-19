package com.isep.acme.mappers;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.isep.acme.model.AggregatedRating;
import com.isep.acme.model.neo4j.AggregatedRatingNeo4J;

@Mapper
public interface Neo4JMapperAggregatedRating {
    Neo4JMapperAggregatedRating INSTANCE = Mappers.getMapper(Neo4JMapperAggregatedRating.class);

    AggregatedRating mapToDataModel(AggregatedRatingNeo4J aggregatedRating);

    AggregatedRatingNeo4J mapToNeo4JModel(AggregatedRating aggregatedRating);

    Iterable<AggregatedRating> mapToDataModelIterable(Iterable<AggregatedRatingNeo4J> aggregatedRatings);

    Iterable<AggregatedRatingNeo4J> mapToNeo4JModelIterable(Iterable<AggregatedRating> aggregatedRatings);

    Set<AggregatedRating> mapToDataModelSet(Set<AggregatedRatingNeo4J> aggregatedRatings);

    Set<AggregatedRatingNeo4J> mapToNeo4JModelSet(Set<AggregatedRating> aggregatedRatings);
}
