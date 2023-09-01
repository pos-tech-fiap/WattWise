package com.pos.wattwise.services.address;

import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.dtos.electronic.ElectronicDTO;
import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.electronic.Electronic;
import com.pos.wattwise.models.person.Person;
import com.pos.wattwise.repositories.address.AddressRepository;
import com.pos.wattwise.repositories.electronic.ElectronicRepository;
import com.pos.wattwise.repositories.person.PersonRepository;
import com.pos.wattwise.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ElectronicRepository electronicRepository;

    @Transactional(readOnly = true)
    public Page<AddressDTO> findAll(PageRequest pageRequest) {
        Page<Address> addresses = addressRepository.findAll(pageRequest);
        return addresses.map(address -> new AddressDTO(address, address.getPersons(), address.getElectronics()));
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(UUID id) {
        var address = addressRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Address not found"));
        return new AddressDTO(address, address.getPersons(), address.getElectronics());
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> find(String street, String neighborhood, String city, String state, String zipCode) {
        List<Address> addresses = new ArrayList<>();
        if (street != null) {
            addresses.addAll(addressRepository.findByStreet(street));
        }
        if (neighborhood != null) {
            addresses.addAll(addressRepository.findByNeighborhood(neighborhood));
        }
        if (city != null) {
            addresses.addAll(addressRepository.findByCity(city));
        }
        if (state != null) {
            addresses.addAll(addressRepository.findByState(state));
        }
        if (zipCode != null) {
            addresses.addAll(addressRepository.findByZipCode(zipCode));
        }

        return addresses.stream().map(address -> new AddressDTO(address, address.getPersons(), address.getElectronics())).collect(Collectors.toList());
    }

    @Transactional
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = new Address();
        mapperDtoToEntity(addressDTO, address);
        var addressSaved = addressRepository.save(address);
        return new AddressDTO(addressSaved, addressSaved.getPersons(), address.getElectronics());
    }

    @Transactional
    public AddressDTO update(UUID id, AddressDTO addressDTO) {
        try {
            Address address = addressRepository.getOne(id);
            mapperDtoToEntity(addressDTO, address);
            return new AddressDTO(address, address.getPersons(), address.getElectronics());
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

        for (PersonDTO personDTO: dto.getPersons()) {
            Person person = personRepository.getOne(personDTO.getId());
            address.getPersons().add(person);
        }

        for (ElectronicDTO electronicDTO: dto.getElectronics()) {
            Electronic electronic = electronicRepository.getOne(electronicDTO.getId());
            address.getElectronics().add(electronic);
        }
    }
}
