package com.pos.wattwise.models;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Objects;
import java.util.UUID;
public class ElectronicsModel {

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String model;
    @JsonProperty
    private String power;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectronicsModel that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ElectronicsModel() {
        this.id = UUID.randomUUID();
    }

    public boolean findOne(UUID id) {
        return this.id.equals(id);
    }

}
