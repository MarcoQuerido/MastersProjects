package com.isep.acme.repositories.neo4j;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.isep.acme.model.neo4j.UserNeo4J;
import com.isep.acme.utils.ServiceUtils;

@CacheConfig(cacheNames = "users_neo")
@Repository
@Profile(ServiceUtils.NEO4J_PROFILE)
public interface UserRepositoryNeo4J extends Neo4jRepository<UserNeo4J, Long> {
    @Override
    @CacheEvict(cacheNames = "users_neo", key = "#p0.userId")
    <S extends UserNeo4J> S save(S entity);

    @Override
    @Cacheable
    Optional<UserNeo4J> findById(Long userId);

    @Cacheable
    Optional<UserNeo4J> findByUsername(String username);

}