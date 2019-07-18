package com.ohair.stephen.graphql.resolvers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ohair.stephen.graphql.exceptions.InvalidArgumentException;
import com.ohair.stephen.graphql.exceptions.PersonNotFoundException;
import com.ohair.stephen.graphql.inputs.CreatePersonInput;
import com.ohair.stephen.graphql.inputs.UpdateAgeInput;
import com.ohair.stephen.graphql.inputs.UpdateNameInput;
import com.ohair.stephen.graphql.model.Person;
import com.ohair.stephen.graphql.repositories.PersonRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PersonMutator implements GraphQLMutationResolver {

    private final PersonRepository repo;

    public Person createPerson(CreatePersonInput i) {
        Person p = new Person();
        p.setFirstName(i.getFirstName());
        p.setMiddleName(i.getMiddleName());
        p.setLastName(i.getLastName());
        return repo.save(p);
    }

    public boolean deletePerson(Long id) {
        repo.deleteById(id);
        return true;
    }

    public Person updateName(UpdateNameInput i) {
        Person p = repo.findById(i.getId())
                .orElseThrow(() -> new PersonNotFoundException("person to update not found", i.getId()));

        Optional.ofNullable(i.getFirstName())
                .orElseThrow(() -> new InvalidArgumentException("firstName cannot be null", i.getFirstName()));
        Optional.ofNullable(i.getLastName())
                .orElseThrow(() -> new InvalidArgumentException("lastName cannot be null", i.getLastName()));

        p.setFirstName(i.getFirstName());
        p.setMiddleName(i.getMiddleName());
        p.setMiddleName(i.getLastName());

        return repo.save(p);
    }

    public Person updateAge(UpdateAgeInput i) {
        Person p = repo.findById(i.getId())
                .orElseThrow(() -> new PersonNotFoundException("person to update not found", i.getId()));
        p.setAge(i.getAge());
        return repo.save(p);
    }

}
