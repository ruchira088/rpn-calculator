package com.ruchij.operations.arithmatic;

import com.ruchij.InputNumber;

public class MultiplyOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y) {
        return new InputNumber(x.multiply(y));
    }
}
