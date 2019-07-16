package com.ohair.stephen.graphql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ohair.stephen.graphql.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
