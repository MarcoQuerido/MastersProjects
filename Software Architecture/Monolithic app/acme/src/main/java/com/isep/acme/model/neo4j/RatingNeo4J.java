package com.isep.acme.model.neo4j;

import java.util.Objects;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Getter;
import lombok.Setter;

@Node("Rating")
@Getter
@Setter
public class RatingNeo4J {

    @Id
    @GeneratedValue
    private Long idRating;

    private long version;

    @Property
    private Double rate;

    public RatingNeo4J(){}

    public RatingNeo4J(Long idRating, long version, Double rate) {
        this.idRating = Objects.requireNonNull(idRating);
        this.version = Objects.requireNonNull(version);
        setRate(rate);
    }

    public RatingNeo4J(Double rate) {
        setRate(rate);
    }

}
