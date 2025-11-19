package com.isep.acme.model.neo4j;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Getter;
import lombok.Setter;

@Node("AggregatedRating")
@Getter
@Setter
public class AggregatedRatingNeo4J {

    @Id
    @GeneratedValue
    private Long aggregatedId;

    @Property
    private double average;

    @Relationship(type = "HAS_PRODUCT")
    private ProductNeo4J productId;

    public AggregatedRatingNeo4J() {}

    public AggregatedRatingNeo4J(double average, ProductNeo4J productNeo4J) {
        this.average = average;
        this.productId = productNeo4J;
    }

}
