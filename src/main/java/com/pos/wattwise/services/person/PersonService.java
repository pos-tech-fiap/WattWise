package com.pos.wattwise.services.person;

import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.dtos.electronic.ElectronicDTO;
import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.electronic.Electronic;
import com.pos.wattwise.models.person.Kinship;
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
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ElectronicRepository electronicRepository;

    @Transactional(readOnly = true)
    public Page<PersonDTO> findAll(PageRequest pageRequest) {
        Page<Person> personas = personRepository.findAll(pageRequest);
        return personas.map(person -> new PersonDTO(person, person.getAddresses(), person.getElectronics()));
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(UUID id) {
        var person = personRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Person not found"));
        return new PersonDTO(person, person.getAddresses(), person.getElectronics());
    }

    @Transactional(readOnly = true)
    public List<PersonDTO> find(String name, String gender, String email, Kinship kinship) {
        List<Person> personList = new ArrayList<>();
        if (name != null) {
            personList.addAll(personRepository.findByName(name));
        }

        if (gender != null) {
            personList.addAll(personRepository.findByGender(gender));
        }

        if (email != null) {
            personList.addAll(personRepository.findByEmail(email));
        }

        if (kinship != null) {
            personList.addAll(personRepository.findByKinship(kinship));
        }

        return personList.stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public PersonDTO save(PersonDTO personDTO) {
        Person person = new Person();
        mapperDtoToEntity(personDTO, person);
        var personSaved = personRepository.save(person);
        return new PersonDTO(personSaved, personSaved.getAddresses(), personSaved.getElectronics());
    }

    @Transactional
    public PersonDTO update(UUID id, PersonDTO personDTO) {
        try {
            Person person = personRepository.getOne(id);
            mapperDtoToEntity(personDTO, person);
            return new PersonDTO(person, person.getAddresses(), person.getElectronics());
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Person not found, id: " + id);
        }
    }

    public void delete(UUID id) {
        try {
            personRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new ControllerNotFoundException("Person not found, id: " + id);
        }
    }

    private void mapperDtoToEntity(PersonDTO dto, Person person) {
        person.setName(dto.getName());
        person.setGender(dto.getGender());
        person.setBirthDate(dto.getBirthDate());
        person.setEmail(dto.getEmail());
        person.setPhone(dto.getPhone());
        person.setKinship(dto.getKinship());

        for (AddressDTO addressDTO: dto.getAddresses()) {
            Address address = addressRepository.getOne(addressDTO.getId());
            person.getAddresses().add(address);
        }

        for (ElectronicDTO electronicDTO: dto.getElectronics()) {
            Electronic electronic = electronicRepository.getOne(electronicDTO.getId());
            person.getElectronics().add(electronic);
        }
    }
}
