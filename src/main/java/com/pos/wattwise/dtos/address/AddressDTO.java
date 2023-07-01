package com.pos.wattwise.dtos.address;

import com.pos.wattwise.models.address.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddressDTO(UUID id, @NotBlank String street, @NotNull Integer number, String complement, String neighborhood,
                         @NotBlank String city, @NotBlank String state, @NotNull Integer zipCode) {

    public AddressDTO(Address address) {
        this(address.getId(), address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighborhood(),
                address.getCity(), address.getState(), address.getZipCode());
    }
}
