package com.ruchij.operations;

import com.ruchij.Calculator;

public class UndoOperation implements CalculatorOperation {
    @Override
    public void perform(Calculator p_calculator) {
        p_calculator.undo();
    }
}
