package com.example.demo.exception;

import com.example.demo.service.StarWarsService;

public class StarWarsNotFound  extends RuntimeException{
    private String message;

    public StarWarsNotFound(String message){
        super(message);
        this.message = message;
    }

    public StarWarsNotFound(){

    }
}
