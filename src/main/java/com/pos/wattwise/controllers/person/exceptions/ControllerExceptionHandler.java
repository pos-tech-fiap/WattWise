package com.pos.wattwise.controllers.person.exceptions;

import com.pos.wattwise.services.address.exceptions.ControllerNotFoundException;
import com.pos.wattwise.services.address.exceptions.DatabaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    private DefaultError error = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entity Not found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DefaultError> database(DatabaseException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database error");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FormValidation> validation(MethodArgumentNotValidException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        FormValidation formValidation = new FormValidation();
        formValidation.setTimestamp(Instant.now());
        formValidation.setStatus(status.value());
        formValidation.setError("Database error");
        formValidation.setMessage(exception.getMessage());
        formValidation.setPath(request.getRequestURI());

        for (FieldError field : exception.getBindingResult().getFieldErrors()) {
            formValidation.addMessages(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(formValidation);
    }
}
