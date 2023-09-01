package com.pos.wattwise.models.electronic;

import com.pos.wattwise.models.address.Address;
import com.pos.wattwise.models.person.Person;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_electronic")
public class Electronic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String model;
    private String power;

    private double energyConsumption;
    
    @ManyToMany(mappedBy = "electronics")
    private Set<Person> persons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Electronic() {
    }

    public Electronic(UUID id, String name, String model, String power, Address address, double energyConsumption) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.power = power;
        this.address = address;
        this.energyConsumption = energyConsumption;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public double getEnergyConsumption() { return energyConsumption; }
    public void setEnergyConsumption(double energyConsumption) { this.energyConsumption = energyConsumption; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
