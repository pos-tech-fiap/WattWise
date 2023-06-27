package com.pos.wattwise.service.person;

import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.person.Person;
import com.pos.wattwise.repositories.PersonRepository;

import jakarta.validation.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    private void validateCreate(Person person) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Person>> violationSet = validator.validate(person);
        Map<Path, String> violationMap = violationSet.stream().collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));

        if (!violationMap.isEmpty()) {
            throw new ValidationException("error");
        }
    }
}
