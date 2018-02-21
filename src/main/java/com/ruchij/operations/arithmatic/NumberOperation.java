package com.ruchij.operations.arithmatic;

import com.ruchij.Calculator;
import com.ruchij.CalculatorInput;
import com.ruchij.InputNumber;
import com.ruchij.exceptions.InsufficientParametersException;
import com.ruchij.operations.CalculatorOperation;

public abstract class NumberOperation implements CalculatorOperation
{
    protected InputNumber popInputNumber(Calculator p_calculator) throws InsufficientParametersException {
        CalculatorInput input = p_calculator.pop();

        if (input.isOperator()) {
            throw new InsufficientParametersException();
        } else {
            return (InputNumber) input;
        }
    }
}
