package com.pos.wattwise.controller;

import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.person.Person;
import com.pos.wattwise.service.person.PersonService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Optional<Person> person = personService.findById(id);
        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity findAll(){
        Set<Person> personSet = personService.findAll();
        return ResponseEntity.ok(personSet);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody @Valid PersonDTO createPersonDTO) {
        Person person = personService.create(createPersonDTO);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid PersonDTO createPersonDTO) {
        Person person = personService.update(id, createPersonDTO);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id){
        boolean deleted = personService.delete(id);
        if (!deleted) {
            return ResponseEntity.badRequest().body("Pessoa não encontrada");
        }
        return ResponseEntity.ok().body("Pessoa removida com sucesso");
    }
}
