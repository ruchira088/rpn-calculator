package com.ruchij;

import com.ruchij.exceptions.InputParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest
{
    @Test
    public void testCase_1() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("5 2");

        assertEquals("5 2", calculator.result());
    }

    @Test
    public void testCase_2() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("2 sqrt");

        assertEquals("1.4142135623", calculator.result());

        calculator.input("clear 9 sqrt");

        assertEquals("3", calculator.result());
    }

    @Test
    public void testCase_3() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("5 2 -");

        assertEquals("3", calculator.result());

        calculator.input("3 -");

        assertEquals("0", calculator.result());

        calculator.input("clear");

        assertEquals("", calculator.result());
    }

    @Test
    public void testCase_4() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("5 4 3 2");

        assertEquals("5 4 3 2", calculator.result());

        calculator.input("undo undo *");

        assertEquals("20", calculator.result());

        calculator.input("5 *");

        assertEquals("100", calculator.result());

        calculator.input("undo");

        assertEquals("20 5", calculator.result());
    }

    @Test
    public void testCase_5() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("7 12 2 /");

        assertEquals("7 6", calculator.result());

        calculator.input("*");

        assertEquals("42", calculator.result());

        calculator.input("4 /");

        assertEquals("10.5", calculator.result());
    }

    @Test
    public void testCase_6() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("1 2 3 4 5");

        assertEquals("1 2 3 4 5", calculator.result());

        calculator.input("*");

        assertEquals("1 2 3 20", calculator.result());

        calculator.input("clear 3 4 -");

        assertEquals("-1", calculator.result());
    }

    @Test
    public void testCase_7() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("1 2 3 4 5");

        assertEquals("1 2 3 4 5", calculator.result());

        calculator.input("* * * *");

        assertEquals("120", calculator.result());
    }

    @Test
    public void testCase_8() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("1 2 3 * 5 + * * 6 5");

        assertEquals("operator * (position: 15): insufficient parameters\n11", calculator.result());
    }

    @Test
    public void testCase_9() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("1 2 3 * 5");

        assertEquals("1 6 5", calculator.result());

        calculator.input("+ * - 6 5");

        assertEquals("operator - (position: 5): insufficient parameters\n11", calculator.result());
    }

    @Test
    public void testCase_10() throws InputParseException
    {
        Calculator calculator = new Calculator();
        calculator.input("2 3 * 4");

        assertEquals("6 4", calculator.result());

        calculator.input("+ - 2 3");

        assertEquals("operator - (position: 3): insufficient parameters\n10", calculator.result());

        calculator.input("1 +");

        assertEquals("11", calculator.result());
    }

}
