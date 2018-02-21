package com.ruchij.operations.numbers;

import com.ruchij.Calculator;
import com.ruchij.InputNumber;
import com.ruchij.exceptions.InsufficientParametersException;

public abstract class ArithmeticOperation extends NumberOperation
{
    abstract InputNumber calculate(InputNumber x, InputNumber y);

    @Override
    public void perform(Calculator p_calculator) throws InsufficientParametersException
    {
        InputNumber x = popInputNumber(p_calculator);
        InputNumber y;

        try {
            y = popInputNumber(p_calculator);
        } catch (InsufficientParametersException ex) {
            p_calculator.push(x);
            throw ex;
        }

        p_calculator.push(calculate(x, y));
    }
}
