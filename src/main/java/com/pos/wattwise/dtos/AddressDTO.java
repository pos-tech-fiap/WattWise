package com.pos.wattwise.dtos;

public record AddressDTO(String street, Integer number, String complement, String neighborhood,
                         String city, String state, Integer zipCode) {
}
