package com.ohair.stephen.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ohair.stephen.graphql.model.Person;
import com.ohair.stephen.graphql.repositories.PersonRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonRepository repo;

    public Person person(Long id) {
        return repo.findById(id).orElseThrow(() -> new PersonNotFoundException("person not found", id));
    }

    public Iterable<Person> allPeople() {
        return repo.findAll();
    }

}
