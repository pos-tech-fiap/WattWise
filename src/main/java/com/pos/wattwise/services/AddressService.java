package com.pos.wattwise.services;

import com.pos.wattwise.models.Address;
import com.pos.wattwise.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return addressRepository.findById(id);
    }

    public Address update(UUID id, Address address) {
        return addressRepository.update(id, address);
    }

    public void delete(UUID id) {
        addressRepository.delete(id);
    }
}
