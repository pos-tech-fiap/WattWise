package com.pos.wattwise.models;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;

public class ElectronicsModel {
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

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String model;
    @JsonProperty
    private String power;

    public ElectronicsModel() {
        this.id = UUID.randomUUID();
    }
}
