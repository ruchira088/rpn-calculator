package com.ruchij;

import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws Exception
    {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter input");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            calculator.input(input);

            System.out.println(calculator.result());
        }
    }
}
