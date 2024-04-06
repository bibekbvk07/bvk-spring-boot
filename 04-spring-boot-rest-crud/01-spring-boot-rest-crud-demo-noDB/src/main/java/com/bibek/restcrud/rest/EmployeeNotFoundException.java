package com.bibek.restcrud.rest;

public class EmployeeNotFoundException extends RuntimeException{
    // Will call parent constructor using super

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }
}
