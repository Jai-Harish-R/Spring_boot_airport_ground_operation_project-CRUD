package com.example.operations.Exception;

public class FuelRequestNotFoundException extends RuntimeException{
    public FuelRequestNotFoundException(String msg){
        super(msg);
    }
}
