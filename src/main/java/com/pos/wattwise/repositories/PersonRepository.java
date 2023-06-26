package com.pos.wattwise.repositories;

import com.pos.wattwise.models.person.Person;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PersonRepository {

    private Set<Person> personRepository;

    public PersonRepository() {
        personRepository = new HashSet<>();
    }

    public Person save(Person person){
        personRepository.add(person);
        return person;
    }
}
