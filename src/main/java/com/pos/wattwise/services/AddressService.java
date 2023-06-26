package com.pos.wattwise.services;

import com.pos.wattwise.models.Address;
import com.pos.wattwise.repositories.AddressRepository;
import com.pos.wattwise.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Set<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address save(Address address) {
        address.setId(UUID.randomUUID());
        return addressRepository.save(address);
    }

    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Address not found"));
    }

    public Address update(UUID id, Address address) {
        try {
            return addressRepository.update(id, address);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Address not found, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            addressRepository.delete(id);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Address not found, id: " + id);
        }
    }
}
