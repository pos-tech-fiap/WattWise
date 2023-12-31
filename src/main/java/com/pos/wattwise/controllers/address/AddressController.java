package com.pos.wattwise.controllers.address;

import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.services.address.AddressService;
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
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<Page<AddressDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AddressDTO> addresses = addressService.findAll(pageRequest);
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<AddressDTO>> find(String street, String neighborhood, String city, String state, String zipCode) {
        List<AddressDTO> addresses = addressService.find(street, neighborhood, city, state, zipCode);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @Valid AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressDTO));
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
