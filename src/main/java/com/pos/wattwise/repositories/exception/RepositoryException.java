package com.pos.wattwise.repositories.exception;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
