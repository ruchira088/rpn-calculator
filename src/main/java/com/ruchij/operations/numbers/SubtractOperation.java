package com.ruchij.operations.numbers;

import com.ruchij.InputNumber;

public class SubtractOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(y.subtract(x));
    }
}
