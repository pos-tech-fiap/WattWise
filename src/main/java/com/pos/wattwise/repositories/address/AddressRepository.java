package com.pos.wattwise.repositories.address;

import com.pos.wattwise.models.address.Address;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AddressRepository {

    private Set<Address> addressesRepository;

    public AddressRepository() {
        addressesRepository = new LinkedHashSet<>();
    }

    public Set<Address> findAll() {
        return addressesRepository;
    }

    public Optional<Address> findById(UUID id) {
        return  addressesRepository.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Address save(Address address) {
        addressesRepository.add(address);
        return address;
    }

    public Address update(UUID id, Address address) {
        Address updatedAddress = addressesRepository.stream().filter(a -> a.getId().equals(id)).findFirst().get();
        updatedAddress.setStreet(address.getStreet());
        updatedAddress.setNumber(address.getNumber());
        updatedAddress.setComplement(address.getComplement());
        updatedAddress.setNeighborhood(address.getNeighborhood());
        updatedAddress.setCity(address.getCity());
        updatedAddress.setState(address.getState());
        updatedAddress.setZipCode(address.getZipCode());

        return updatedAddress;
    }

    public void delete(UUID id) {
        Address address = addressesRepository.stream().filter(a -> a.getId().equals(id)).findFirst().get();
        addressesRepository.remove(address);
    }
}