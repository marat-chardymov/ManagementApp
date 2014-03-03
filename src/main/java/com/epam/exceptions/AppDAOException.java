package com.epam.exceptions;

public class AppDAOException extends AppException{
    public AppDAOException(String message, Exception cause) {
        super(message, cause);
    }

    public AppDAOException(String s) {
        super(s);
    }
}
