package com.love2java.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message)
    {
        super(message);
    }
}
