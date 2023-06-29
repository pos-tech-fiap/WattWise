package com.pos.wattwise.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record ElectrodomesticsDTO( @JsonProperty  @NotBlank(message = "Name can not be blank!") String name,
                                   @JsonProperty @NotBlank(message = "Type can not be blank!") String type,
                                   @JsonProperty @NotBlank(message = "Power can not be blank!") String power) {
}
