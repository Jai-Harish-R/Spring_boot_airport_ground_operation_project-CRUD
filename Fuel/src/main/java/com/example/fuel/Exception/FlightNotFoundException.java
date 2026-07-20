package com.example.fuel.Exception;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String msg){
        super(msg);
    }
}
