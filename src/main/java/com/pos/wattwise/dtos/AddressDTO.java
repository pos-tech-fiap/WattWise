package com.pos.wattwise.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressDTO(@NotBlank String street, @NotNull Integer number, String complement, String neighborhood,
                         @NotBlank String city, @NotBlank String state, @NotNull Integer zipCode) {
}
