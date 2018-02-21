package com.ruchij;

import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void simpleTest() throws Exception {
        Calculator calculator = new Calculator();
        calculator.input("5 1 1 +");
    }

}
