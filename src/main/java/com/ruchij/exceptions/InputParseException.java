package com.ruchij.exceptions;

public class InputParseException extends Exception
{
    public InputParseException(String p_input)
    {
        super("Unable to parse: " + p_input);
    }
}
