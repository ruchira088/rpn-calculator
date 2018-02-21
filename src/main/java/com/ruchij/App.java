package com.ruchij;

public class App
{
    public static void main(String[] args) throws Exception
    {
        InputParser inputParser = new InputParser();
        System.out.println(inputParser.parse("1 3 +"));

        Calculator calculator = new Calculator();
        for (CalculatorInput input : inputParser.parse("5 1 1 + 1 1 undo")) {
            calculator.inputPush(input);
        }

        System.out.println(calculator);
    }
}
