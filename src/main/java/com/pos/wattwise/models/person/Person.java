package com.pos.wattwise.models.person;

import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.electronic.Electronic;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String gender;
    private Date birthDate;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Kinship kinship;

    @ManyToMany
    @JoinTable(
            name = "tb_person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "tb_person_electronic",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "electronic_id")
    )
    private Set<Electronic> electronics = new HashSet<>();

    public Person(){
    }

    public Person(UUID id, String name, String gender, Date birthDate, String email, String phone, Kinship kinship) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.kinship = kinship;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<Electronic> getElectronics() {
        return electronics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
