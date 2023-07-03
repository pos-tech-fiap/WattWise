package com.pos.wattwise.services.address.exceptions;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String message) {
        super(message);
    }
}
