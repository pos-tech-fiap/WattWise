package com.pos.wattwise.repositories.person.exception;


public class RepositoryException extends RuntimeException {

    public RepositoryException(String message, Throwable throwable) {
        super(message, throwable);

    }
}
