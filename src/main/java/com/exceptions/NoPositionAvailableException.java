package com.exceptions;

public class NoPositionAvailableException extends RuntimeException{
    @Override
    public String getMessage() {
        return "No available position.";
    }
}
