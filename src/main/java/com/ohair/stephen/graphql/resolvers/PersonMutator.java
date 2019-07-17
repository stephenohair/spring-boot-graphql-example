package com.ohair.stephen.graphql.resolvers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ohair.stephen.graphql.inputs.ChangeNameInput;
import com.ohair.stephen.graphql.inputs.CreatePersonInput;
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

    public Person changeName(ChangeNameInput i) {
        Person p = repo.findById(i.getId())
                .orElseThrow(() -> new PersonNotFoundException("person to update not found", i.getId()));
        Optional.of(i.getFirstName()).ifPresent(fn -> p.setFirstName(fn));
        Optional.of(i.getMiddleName()).ifPresent(fn -> p.setMiddleName(fn));
        Optional.of(i.getLastName()).ifPresent(fn -> p.setLastName(fn));
        return repo.save(p);
    }

}
