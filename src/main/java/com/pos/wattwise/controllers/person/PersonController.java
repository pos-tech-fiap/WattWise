package com.pos.wattwise.controllers.person;

import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.person.Kinship;
import com.pos.wattwise.services.person.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<Page<PersonDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok().body(personService.findAll(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<PersonDTO>> find(String name, String gender, String email, Kinship kinship) {
        return ResponseEntity.ok().body(personService.find(name, gender, email, kinship));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody @Valid PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable UUID id, @RequestBody @Valid PersonDTO personDTO) {
        return ResponseEntity.ok().body(personService.update(id, personDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        personService.delete(id);
        return ResponseEntity.ok().body("Person deleted successfully!");
    }
}
