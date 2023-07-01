package com.pos.wattwise.controllers.address;

import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.services.address.AddressService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Set<AddressDTO>> findAll() {
        return ResponseEntity.ok().body(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @Valid AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(addressService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable UUID id, @RequestBody @Valid AddressDTO addressDTO) {
        return ResponseEntity.ok().body(addressService.update(id, addressDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        addressService.delete(id);
        return ResponseEntity.ok().body("Address deleted successfully!");
    }

}
