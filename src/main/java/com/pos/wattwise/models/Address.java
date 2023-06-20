package com.pos.wattwise.models;


import java.util.Objects;

public class Address {

    private Long id;
    private String address;
    private String city;
    private String state;
    private Integer zipCode;

    public Address() {
    }

    public Address(Long id, String address, String city, Integer zipCode, String state) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public Address setZipCode(Integer zipCode) {
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
