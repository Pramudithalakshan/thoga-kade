package edu.icet.ecom.exception;

public class DatabaseConnectionException extends RuntimeException{
    public DatabaseConnectionException(String message) {
        super(message, cause);
    }
}
