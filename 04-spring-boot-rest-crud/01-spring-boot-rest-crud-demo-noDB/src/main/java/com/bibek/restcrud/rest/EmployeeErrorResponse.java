package com.bibek.restcrud.rest;

import java.time.LocalDateTime;

public class EmployeeErrorResponse {

    // Define a private fields
    private int status;
    private String message;
    private long timeStamp;
    private LocalDateTime localDateTime;

    // Define a no-args constructor
    public EmployeeErrorResponse() {
    }

    // Define a constructor
    public EmployeeErrorResponse(int status, String message, long timeStamp, LocalDateTime localDateTime) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.localDateTime = localDateTime;
    }

    // Define a getter and setter

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
