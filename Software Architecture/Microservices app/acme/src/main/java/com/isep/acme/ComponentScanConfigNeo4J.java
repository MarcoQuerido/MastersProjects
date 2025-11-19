package com.isep.acme;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.isep.acme.utils.ServiceUtils;

@Configuration
@Profile(ServiceUtils.NEO4J_PROFILE)
@ComponentScan(basePackages = "com.isep.acme.repositories.neo4j")
public class ComponentScanConfigNeo4J {

}
