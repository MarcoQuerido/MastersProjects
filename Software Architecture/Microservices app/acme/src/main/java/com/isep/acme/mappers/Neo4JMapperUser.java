package com.isep.acme.mappers;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.isep.acme.model.User;
import com.isep.acme.model.neo4j.UserNeo4J;

@Mapper
public interface Neo4JMapperUser {
    Neo4JMapperUser INSTANCE = Mappers.getMapper(Neo4JMapperUser.class);

    User mapToDataModel(UserNeo4J user);

    UserNeo4J mapToNeo4JModel(User user);

    Iterable<User> mapToDataModelIterable(Iterable<UserNeo4J> users);

    Iterable<UserNeo4J> mapToNeo4JModelIterable(Iterable<User> users);

    Set<User> mapToDataModelSet(Set<UserNeo4J> users);

    Set<UserNeo4J> mapToNeo4JModelSet(Set<User> users);
}
