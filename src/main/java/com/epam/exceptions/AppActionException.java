package com.epam.exceptions;

public class AppActionException extends AppException {
    public AppActionException(String message, Exception cause) {
        super(message, cause);
    }

    public AppActionException(String message) {
        super(message);
    }
}