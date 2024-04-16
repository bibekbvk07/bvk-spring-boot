package com.bibek.mapping_demo.exceptions;

public class LaptopNotFoundException extends RuntimeException{

    public LaptopNotFoundException(String message) {
        super(message);
    }

    public LaptopNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LaptopNotFoundException(Throwable cause) {
        super(cause);
    }
}
