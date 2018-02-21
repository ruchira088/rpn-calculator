package com.ruchij.operations;

import com.ruchij.Calculator;
import com.ruchij.exceptions.InsufficientParametersException;

public class UndoOperation implements CalculatorOperation
{
    @Override
    public void perform(Calculator p_calculator) throws InsufficientParametersException
    {
        p_calculator.undo();
    }
}
