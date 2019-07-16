package com.ohair.stephen.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ohair.stephen.graphql.model")
public class GraphQLSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLSpringBootApp.class, args);
    }
}
