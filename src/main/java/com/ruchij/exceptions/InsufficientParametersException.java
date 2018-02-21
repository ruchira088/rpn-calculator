package com.ruchij.exceptions;

public class InsufficientParametersException extends Exception
{
    public InsufficientParametersException(String message)
    {
        super(message);
    }

    public InsufficientParametersException() { }
}
