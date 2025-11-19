package com.isep.acme.repositories.neo4j;

import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.isep.acme.model.neo4j.ProdImageNeo4J;
import com.isep.acme.utils.ServiceUtils;

@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public interface ImageRepositoryNeo4J extends Neo4jRepository<ProdImageNeo4J, Long> {
}
