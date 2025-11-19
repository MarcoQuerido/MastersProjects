/*
package com.isep.acme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.isep.acme.property.DatabaseEnablerProperties;
import com.isep.acme.property.MongoDbProperties;
import com.isep.acme.property.Neo4JProperties;
import com.mongodb.client.MongoClient;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

public class DatabaseEnablerController extends Neo4jConfiguration{
    @Autowired
    private DatabaseEnablerProperties databaseEnablerProperties;
    @Autowired
    private MongoDbProperties mongoDbProperties;
    @Autowired
    private Neo4JProperties neo4JProperties;

    private String dataSourceHost;
    private String port;
    private String name;
    private String password;

    protected void applyProperties() {
        if (databaseEnablerProperties.getDatabaseInUse().equalsIgnoreCase("mongodb")) {
            dataSourceHost = mongoDbProperties.getDatabase();
            port = mongoDbProperties.getPort();
            name = mongoDbProperties.getUsername();
            password = mongoDbProperties.getPassword();
        } else if (databaseEnablerProperties.getDatabaseInUse().equalsIgnoreCase("neo4j")) {
            dataSourceHost = neo4JProperties.getDatabase();
            port = neo4JProperties.getPort();
            name = neo4JProperties.getUsername();
            password = neo4JProperties.getPassword();
        }
    }

    @Bean
    public void setupDatabase() {

    }
    @Bean
    public MongoClient mongoClient(MongoDbProperties properties) {
        return new MongoClient(properties.getDatasource(), properties.getPort());
    }
    @Bean
    public SessionFactory sessionFactory(DatabaseProperties properties) {
        // Configure and create a Neo4j SessionFactory here
    }

}
*/
