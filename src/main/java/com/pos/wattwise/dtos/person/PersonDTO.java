package com.pos.wattwise.dtos.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pos.wattwise.dtos.address.AddressDTO;
import com.pos.wattwise.dtos.electronic.ElectronicDTO;
import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.electronic.Electronic;
import com.pos.wattwise.models.person.Kinship;
import com.pos.wattwise.models.person.Person;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.*;

public class PersonDTO {

    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    private String gender;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Email
    private String email;

    private String phone;

    private Kinship kinship;

    private List<AddressDTO> addresses = new ArrayList<>();

    private List<ElectronicDTO> electronics = new ArrayList<>();

    public PersonDTO() {
    }

    public PersonDTO(UUID id, String name, String gender, Date birthDate, String email, String phone, Kinship kinship) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.kinship = kinship;
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.gender = person.getGender();
        this.birthDate = person.getBirthDate();
        this.email = person.getEmail();
        this.phone = person.getPhone();
        this.kinship = person.getKinship();
    }

    public PersonDTO(Person person, Set<Address> addresses, Set<Electronic> electronics) {
        this(person);
        addresses.forEach(address -> this.addresses.add(new AddressDTO(address)));
        electronics.forEach(electronic -> this.electronics.add(new ElectronicDTO(electronic)));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Kinship getKinship() {
        return kinship;
    }

    public void setKinship(Kinship kinship) {
        this.kinship = kinship;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public List<ElectronicDTO> getElectronics() {
        return electronics;
    }
}
