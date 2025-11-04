package com.spring_pry.Proyecto.exception;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String message){
        super(message);
    }
}
