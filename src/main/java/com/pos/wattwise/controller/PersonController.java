package com.pos.wattwise.controller;

import com.pos.wattwise.dtos.person.CreatePersonDTO;
import com.pos.wattwise.models.person.Person;
import com.pos.wattwise.service.person.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody CreatePersonDTO createPersonDTO) {
        Person person = personService.create(createPersonDTO);
        return ResponseEntity.ok(person);
    }
}
