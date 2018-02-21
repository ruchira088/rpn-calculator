package com.ruchij;

import com.ruchij.exceptions.InputParseException;
import com.ruchij.exceptions.InsufficientParametersException;
import com.ruchij.operations.Operator;

import java.util.LinkedList;
import java.util.Stack;

public class Calculator
{
    private Stack<InputNumber> m_currentStack = new Stack<>();
    private LinkedList<CalculatorInput> m_inputHistory = new LinkedList<>();
    private InsufficientParametersException m_warning = null;

    public void input(String p_input) throws InputParseException
    {
        InputParser inputParser = new InputParser();
        int currentStackLength = m_inputHistory.size();

        try {
            pushAll(inputParser.parse(p_input));
        } catch (InsufficientParametersException exception)
        {
            int offset = 2 * (m_inputHistory.size() - currentStackLength) - 1;
            Operator operator = (Operator) m_inputHistory.getLast();

            m_warning = new InsufficientParametersException(
                    "operator " + operator.getLabel() + " (position: " + offset + "): insufficient parameters"
            );
        }

    }

    private void pushAll(LinkedList<CalculatorInput> p_calculatorInputs) throws InsufficientParametersException
    {
        for (CalculatorInput input : p_calculatorInputs)
        {
            m_inputHistory.add(input);
            push(input);
        }
    }

    public void push(CalculatorInput p_calculatorInput) throws InsufficientParametersException
    {
        if (p_calculatorInput.isOperator()) {
            Operator operator = (Operator) p_calculatorInput;
            operator.perform(this);

        } else {
            m_currentStack.push((InputNumber) p_calculatorInput);
        }
    }

    public CalculatorInput pop()
    {
        return m_currentStack.pop();
    }

    public void clear()
    {
        m_currentStack = new Stack<>();
    }

    public void undo() throws InsufficientParametersException
    {
        m_currentStack = new Stack<>();

        m_inputHistory.removeLast();
        m_inputHistory.removeLast();

        LinkedList<CalculatorInput> input = (LinkedList<CalculatorInput>)  m_inputHistory.clone();

        m_inputHistory = new LinkedList<>();
        pushAll(input);
    }

    public String result()
    {
        String string = m_currentStack.toString()
                .replace("[", "")
                .replace("]", "")
                .replaceAll(",", "");

        if (m_warning != null) {
            string = m_warning.getMessage() + "\n" + string;
            m_warning = null;
        }

        return string;
    }
}
