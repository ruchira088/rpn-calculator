package com.ruchij.operations;

import com.ruchij.Calculator;
import com.ruchij.CalculatorInput;
import com.ruchij.exceptions.InsufficientParametersException;
import com.ruchij.operations.numbers.*;

public enum Operator implements CalculatorInput
{
    ADD("+", new AddOperation()),
    SUBTRACT("-", new SubtractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation()),
    SQRT("sqrt", new SqrtOperation()),
    UNDO("undo", new UndoOperation()),
    CLEAR("clear", new ClearOperation());

    private final CalculatorOperation m_calculatorOperation;
    private final String m_label;

    Operator(String p_label, CalculatorOperation p_calculatorOperation)
    {
        m_label = p_label;
        m_calculatorOperation = p_calculatorOperation;
    }

    public void perform(Calculator p_calculator) throws InsufficientParametersException
    {
        m_calculatorOperation.perform(p_calculator);
    }

    public String getLabel()
    {
        return m_label;
    }



    @Override
    public boolean isOperator()
    {
        return true;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
