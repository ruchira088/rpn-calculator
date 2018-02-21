package com.ruchij.operations.numbers;

import com.ruchij.InputNumber;

import java.math.RoundingMode;

public class DivideOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(y.divide(x, 20, RoundingMode.CEILING));
    }
}
