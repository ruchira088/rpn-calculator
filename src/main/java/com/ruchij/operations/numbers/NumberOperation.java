package com.ruchij.operations.numbers;

import com.ruchij.Calculator;
import com.ruchij.CalculatorInput;
import com.ruchij.InputNumber;
import com.ruchij.exceptions.InsufficientParametersException;
import com.ruchij.operations.CalculatorOperation;

import java.util.EmptyStackException;

abstract class NumberOperation implements CalculatorOperation
{
    InputNumber popInputNumber(Calculator p_calculator) throws InsufficientParametersException
    {
        try {
            CalculatorInput input = p_calculator.pop();
            return (InputNumber) input;
        }
        catch (EmptyStackException exception) {
            throw new InsufficientParametersException();
        }
    }
}
