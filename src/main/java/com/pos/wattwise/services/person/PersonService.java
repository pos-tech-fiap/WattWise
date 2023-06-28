package com.pos.wattwise.services.person;

import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.person.Person;
import com.pos.wattwise.repositories.person.PersonRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> findById(UUID id) {
        return personRepository.findById(id);
    }

    public Set<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(PersonDTO createPersonDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(createPersonDTO, person);

        return personRepository.save(person);
    }

    public Person update(UUID id, PersonDTO personDto) {
        return personRepository.update(id, personDto);
    }

    public boolean delete(UUID id) {
        return personRepository.delete(id);
    }
}
