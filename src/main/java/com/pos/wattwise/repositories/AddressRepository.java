package com.pos.wattwise.repositories;

import com.pos.wattwise.models.Address;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AddressRepository {

    private Set<Address> addressRepository;

    public AddressRepository() {
        addressRepository = new LinkedHashSet<>();
    }

    public Set<Address> findAll() {
        return addressRepository;
    }

    public Address findById(UUID id) {
        return  addressRepository.stream().filter(a -> a.getId().equals(id)).findFirst().get();
    }

    public Address save(Address address) {
        addressRepository.add(address);
        return address;
    }

    public Address update(UUID id, Address address) {
        Address updatedAddress = addressRepository.stream().filter(a -> a.getId().equals(id)).findFirst().get();
        updatedAddress.setStreet(address.getStreet());
        updatedAddress.setNumber(address.getNumber());
        updatedAddress.setComplement(address.getComplement());
        updatedAddress.setNeighborhood(address.getNeighborhood());
        updatedAddress.setCity(address.getCity());
        updatedAddress.setState(address.getState());
        updatedAddress.setZipCode(address.getZipCode());

        return updatedAddress;
    }
}
