package com.pos.wattwise.dtos.person;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.pos.wattwise.models.person.Kinship;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PersonDTO {

    @JsonProperty
    @NotNull
    @NotEmpty
    private String name;

    @JsonProperty
    private String gender;

    @JsonProperty
    @NotNull
    private Date birthDate;

    @JsonProperty
    @Email
    private String email;

    @JsonProperty
    private Number phone;

    @JsonProperty
    private Kinship kinship;

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

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public Kinship getKinship() {
        return kinship;
    }

    public void setKinship(Kinship kinship) {
        this.kinship = kinship;
    }
}
