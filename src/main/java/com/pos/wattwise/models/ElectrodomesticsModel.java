package com.pos.wattwise.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class ElectrodomesticsModel {

    @JsonProperty
    UUID id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String type;

    @JsonProperty
    private String power;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectrodomesticsModel that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public ElectrodomesticsModel() {
        this.id = UUID.randomUUID();
    }
}
