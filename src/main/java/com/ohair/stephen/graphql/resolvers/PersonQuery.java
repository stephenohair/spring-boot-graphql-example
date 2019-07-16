package com.ohair.stephen.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ohair.stephen.graphql.model.Person;
import com.ohair.stephen.graphql.repositories.PersonRepository;

@Component
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonRepository repo;

    public PersonQuery(PersonRepository repo) {
        this.repo = repo;
    }

    public Iterable<Person> allPeople() {
        return repo.findAll();
    }

}
