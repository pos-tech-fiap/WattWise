package com.pos.wattwise.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@EqualsAndHashCode(of = {"name"})
public class ElectrodomesticsModel {

    @JsonProperty
    UUID id;
    @Getter
    @Setter
    @JsonProperty
    private String name;
    @Getter
    @Setter
    @JsonProperty
    private String type;
    @Getter
    @Setter
    @JsonProperty
    private String power;

    public ElectrodomesticsModel() {
        this.id = UUID.randomUUID();
    }
}
