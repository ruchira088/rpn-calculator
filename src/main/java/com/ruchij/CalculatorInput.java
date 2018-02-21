package com.ruchij;

public interface CalculatorInput
{
    default public boolean isOperator() {
        return false;
    }
}
