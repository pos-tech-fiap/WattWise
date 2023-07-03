package com.pos.wattwise.services.address;

import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.repositories.address.AddressRepository;
import com.pos.wattwise.services.address.exceptions.ControllerNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Set<AddressDTO> findAll() {
        var addresses = addressRepository.findAll();
        return addresses.stream().map(AddressDTO::new).collect(Collectors.toSet());
    }

    public AddressDTO save(AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        address.setId(UUID.randomUUID());
        return new AddressDTO(addressRepository.save(address));
    }

    public AddressDTO findById(UUID id) {
        var address = addressRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Address not found"));
        return new AddressDTO(address);
    }

    public AddressDTO update(UUID id, AddressDTO addressDTO) {
        try {
            Address address = new Address();
            BeanUtils.copyProperties(addressDTO, address);
            return new AddressDTO(addressRepository.update(id, address));
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
