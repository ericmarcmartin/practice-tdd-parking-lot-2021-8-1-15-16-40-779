package com.exceptions;

public class UnrecognizedParkingTicketException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Unrecognized parking ticket.";
    }
}