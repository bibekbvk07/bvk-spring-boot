package com.bibek.restcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlesException(EmployeeNotFoundException exc){
        // Create an EmployeeErrorResponse object
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setLocalDateTime(LocalDateTime.now());

        // Return a ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add an exception handler using @ExceptionHandler to catch any exception
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlesException(Exception exc){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
