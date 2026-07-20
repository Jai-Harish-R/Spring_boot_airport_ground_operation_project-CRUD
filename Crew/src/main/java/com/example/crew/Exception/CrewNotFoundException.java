package com.example.crew.Exception;

public class CrewNotFoundException extends RuntimeException{
    public CrewNotFoundException(String msg){
        super(msg);
    }
}
