package com.pos.wattwise.dtos.address;

import com.pos.wattwise.dtos.electronic.ElectronicDTO;
import com.pos.wattwise.dtos.person.PersonDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.electronic.Electronic;
import com.pos.wattwise.models.person.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AddressDTO {

    private UUID id;
    @NotBlank
    private String street;
    @NotNull
    private Integer number;

    private String complement;

    private String neighborhood;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotNull
    private String zipCode;

    private List<PersonDTO> persons = new ArrayList<>();

    private List<ElectronicDTO> electronics = new ArrayList<>();

    public AddressDTO() {
    }

    public AddressDTO(UUID id, String street, Integer number, String complement, String neighborhood, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }

    public AddressDTO(Address address, Set<Person> persons, Set<Electronic> electronics) {
        this(address);
        persons.forEach(person -> this.persons.add(new PersonDTO(person)));
        electronics.forEach(electronic -> this.electronics.add(new ElectronicDTO(electronic)));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public List<PersonDTO> getPersons() {
        return persons;
    }

    public List<ElectronicDTO> getElectronics() {
        return electronics;
    }
}
