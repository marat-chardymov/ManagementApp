package com.epam.exceptions;

public class AppException extends Exception {

    public AppException(String message, Exception cause) {
        super(message, cause);
    }
    public AppException(String message){
        super(message);
    }
}