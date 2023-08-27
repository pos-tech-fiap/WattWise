package com.pos.wattwise.models.address;

import com.pos.wattwise.models.electronic.Electronic;
import com.pos.wattwise.models.person.Person;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;

    private Integer number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    private String zipCode;

    @ManyToMany(mappedBy = "addresses")
    private Set<Person> persons = new HashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Electronic> electronics = new HashSet<>();

    public Address() {
    }

    public Address(UUID id, String street, String city, String zipCode, String state, Integer number, String complement, String neighborhood, Set<Electronic> electronics) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.electronics = electronics;
    }

    public UUID getId() {
        return id;
    }

    public Address setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Address setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public Address setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Address setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public Set<Electronic> getElectronics() {
        return electronics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
