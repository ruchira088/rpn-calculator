package com.ruchij;

public class App
{
    public static void main(String[] args) throws Exception
    {
        Calculator calculator = new Calculator();

        calculator.input("5 1 + undo undo");
        System.out.println(calculator);
    }
}
