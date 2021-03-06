package com.ruchij.operations.numbers;

import com.ruchij.InputNumber;

public class AddOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(x.add(y));
    }
}
