package com.ruchij.operations;

import com.ruchij.Calculator;
import com.ruchij.exceptions.InsufficientParametersException;

public interface CalculatorOperation
{
    void perform(Calculator p_calculator) throws InsufficientParametersException;
}
