package com.pos.wattwise.services.address;

import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.repositories.address.AddressRepository;
import com.pos.wattwise.services.address.exceptions.ControllerNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public Page<AddressDTO> findAll(PageRequest pageRequest) {
        Page<Address> addresses = addressRepository.findAll(pageRequest);
        return addresses.map(AddressDTO::new);
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(UUID id) {
        var address = addressRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Address not found"));
        return new AddressDTO(address);
    }

    @Transactional
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = new Address();
        mapperDtoToEntity(addressDTO, address);
        return new AddressDTO(addressRepository.save(address));
    }

    @Transactional
    public AddressDTO update(UUID id, AddressDTO addressDTO) {
        try {
            Address address = addressRepository.getOne(id);
            mapperDtoToEntity(addressDTO, address);
            return addressDTO;
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Address not found, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            addressRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Address not found, id: " + id);
        }
    }

    private void mapperDtoToEntity(AddressDTO dto, Address address) {
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setComplement(dto.getComplement());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
    }
}
