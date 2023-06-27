package com.pos.wattwise.controller;

import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.person.Person;
import com.pos.wattwise.service.person.PersonService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody @Valid PersonDTO createPersonDTO) {
        Person person = personService.create(createPersonDTO);
        return ResponseEntity.ok(person);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Person> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid PersonDTO createPersonDTO) {
        Person person = personService.update(id, createPersonDTO);
        return ResponseEntity.ok(person);
    }
}
