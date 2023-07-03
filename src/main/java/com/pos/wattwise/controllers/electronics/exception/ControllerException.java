package com.pos.wattwise.controllers.electronics.exception;

import com.pos.wattwise.repositories.exception.RepositoryException;
import com.pos.wattwise.services.electronics.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice

public class ControllerException extends  RuntimeException{
    private DefaultError error = new DefaultError();

    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<DefaultError> entityNotFound(RepositoryException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Repository error");
        error.setMessage(exception.getMessage());
        return ResponseEntity.status(status).body(this.error);
    }

}
