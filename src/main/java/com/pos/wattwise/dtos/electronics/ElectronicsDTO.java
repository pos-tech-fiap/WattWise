package com.pos.wattwise.dtos.electronics;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record ElectronicsDTO(
    @JsonProperty
    @NotBlank(message = "Name field is required!")
     String name,
    @JsonProperty
    @NotBlank(message = "Model field is required!")
    String model,
    @JsonProperty
    @NotBlank(message = "Power field is required!")
    String power
){
    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return model;
    }

    @Override
    public String power() {
        return power;
    }

}