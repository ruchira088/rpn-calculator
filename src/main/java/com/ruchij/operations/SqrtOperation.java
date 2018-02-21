package com.ruchij.operations;

import com.ruchij.Calculator;
import com.ruchij.InputNumber;
import com.ruchij.exceptions.InsufficientParametersException;
import com.ruchij.operations.arithmatic.NumberOperation;

import java.math.BigDecimal;

public class SqrtOperation extends NumberOperation
{
    @Override
    public void perform(Calculator p_calculator) throws InsufficientParametersException {
        InputNumber inputNumber = popInputNumber(p_calculator);
        p_calculator.push(new InputNumber(new BigDecimal(Math.sqrt(inputNumber.doubleValue()))));
    }
}
