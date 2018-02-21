package com.ruchij;

import com.ruchij.exceptions.InputParseException;

import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            try {
                calculator.input(input);
            } catch (InputParseException ex)
            {
                System.err.println(ex.getMessage());
                System.exit(1);
            }

            System.out.println("stack: " + calculator.result());
        }
    }
}
