package com.ruchij;

import com.ruchij.exceptions.InputParseException;
import com.ruchij.operations.Operator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class InputParser
{
    Optional<Operator> parseOperator(String p_label)
    {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getLabel().equalsIgnoreCase(p_label))
                .findAny();
    }

    Optional<InputNumber> parseNumber(String p_number)
    {
        try {
            return Optional.of(new InputNumber(p_number));
        }
        catch (NumberFormatException numberFormatException) {
            return Optional.empty();
        }
    }

    CalculatorInput parseValue(String p_input) throws InputParseException
    {
        CalculatorInput input = null;
        Optional<InputNumber> number = parseNumber(p_input);

        if (number.isPresent()) {
            input = number.get();
        }
        else {
            Optional<Operator> operator = parseOperator(p_input);

            if (operator.isPresent()) {
                input = operator.get();
            } else {
                throw new InputParseException(p_input);
            }
        }

        return input;
    }

    public LinkedList<CalculatorInput> parse(String p_input) throws InputParseException
    {
        String[] inputs = p_input.split(" ");
        LinkedList<CalculatorInput> linkedList = new LinkedList<>();

        for (String input : inputs) {
            linkedList.add(parseValue(input.trim()));
        }

        return linkedList;
    }
}
