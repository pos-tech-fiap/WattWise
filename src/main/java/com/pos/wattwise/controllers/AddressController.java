package com.pos.wattwise.controllers;

import com.pos.wattwise.dtos.AddressDTO;
import com.pos.wattwise.models.Address;
import com.pos.wattwise.repositories.AddressRepository;
import com.pos.wattwise.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<Set<Address>> findAll() {
        return ResponseEntity.ok().body(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody @Valid AddressDTO addressDTO) {
        var address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(addressService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Address> update(@PathVariable UUID id, @RequestBody @Valid AddressDTO addressDTO) {
        var address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        return ResponseEntity.ok().body(addressService.update(id, address));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        addressService.delete(id);
        return ResponseEntity.ok().body("Address deleted successfully!");
    }

}
