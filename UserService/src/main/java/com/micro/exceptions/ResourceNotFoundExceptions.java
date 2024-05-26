package com.micro.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException{

    public ResourceNotFoundExceptions(){
        super("User not found on server");
    }
    public ResourceNotFoundExceptions (String message) {
        super(message);
    }
}
