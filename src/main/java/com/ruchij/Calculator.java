package com.ruchij;

import com.ruchij.exceptions.InputParseException;
import com.ruchij.exceptions.InsufficientParametersException;
import com.ruchij.operations.Operator;

import java.util.LinkedList;
import java.util.Stack;

public class Calculator
{
    private Stack<CalculatorInput> m_currentStack;
    private LinkedList<Calculator> m_history;

    Calculator() {
        this(new Stack<>(), new LinkedList<>());
    }

    private Calculator(Stack<CalculatorInput> p_currentStack, LinkedList<Calculator> p_history) {
        m_currentStack = p_currentStack;
        m_history = p_history;
    }

    public void input(String p_input) throws InputParseException, InsufficientParametersException {
        InputParser inputParser = new InputParser();

        for (CalculatorInput input : inputParser.parse(p_input)) {
            Calculator current = clone();
            push(input);

            if (input != Operator.UNDO) {
                m_history.push(current);
            }

        }
    }

    public void push(CalculatorInput p_calculatorInput) throws InsufficientParametersException
    {
        if (p_calculatorInput.isOperator()) {
            Operator operator = (Operator) p_calculatorInput;
            operator.perform(this);

        } else {
            m_currentStack.push(p_calculatorInput);
        }
    }

    public CalculatorInput pop() {
        return m_currentStack.pop();
    }

    public Calculator clear() {
        m_history.push(clone());
        m_currentStack = new Stack<>();

        return this;
    }

    public Calculator undo() {
        Calculator undoCalculator = m_history.pop();

        m_currentStack = undoCalculator.m_currentStack;
        m_history = undoCalculator.m_history;

        return this;
    }

    public Calculator clone() {
        return new Calculator(
                (Stack<CalculatorInput>) m_currentStack.clone(),
                (LinkedList<Calculator>)  m_history.clone()
        );
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "m_stack=" + m_currentStack +
                '}';
    }
}
