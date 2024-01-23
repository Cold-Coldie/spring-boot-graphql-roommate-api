package com.coldie.roommategraphqlapi.exception;

public class RoommateNotFoundException extends RuntimeException {
    public RoommateNotFoundException(String message) {
        super(message);
    }
}
