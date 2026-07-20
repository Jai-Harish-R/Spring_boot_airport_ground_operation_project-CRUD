package com.example.fuel.Exception;

public class FuelNotFoundException extends RuntimeException{
    public FuelNotFoundException(String message){
        super(message);
    }
}
