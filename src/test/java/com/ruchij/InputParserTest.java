package com.ruchij;

import static org.junit.Assert.assertEquals;

import com.ruchij.exceptions.InputParseException;
import com.ruchij.operations.Operator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class InputParserTest
{
    private final InputParser m_inputParser = new InputParser();

    @Test
    public void parseNumber()
    {
        assertEquals(
                m_inputParser.parseNumber("7"),
                Optional.of(new InputNumber("7"))
        );
    }

    @Test
    public void failToParseNumber()
    {
        assertEquals(
                m_inputParser.parseNumber("as"),
                Optional.empty()
        );
    }

    @Test
    public void parseAddOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("+"),
                Optional.of(Operator.ADD)
        );
    }

    @Test
    public void parseSubtractOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("-"),
                Optional.of(Operator.SUBTRACT)
        );
    }

    @Test
    public void parseMultiplyOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("*"),
                Optional.of(Operator.MULTIPLY)
        );
    }

    @Test
    public void parseDivideOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("/"),
                Optional.of(Operator.DIVIDE)
        );
    }

    @Test
    public void parseClearOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("clear"),
                Optional.of(Operator.CLEAR)
        );
    }

    @Test
    public void parseUndoOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("undo"),
                Optional.of(Operator.UNDO)
        );
    }

    @Test
    public void parseSqrtOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("sqrt"),
                Optional.of(Operator.SQRT)
        );
    }

    @Test
    public void failToParseOperator()
    {
        assertEquals(
                m_inputParser.parseOperator("something"),
                Optional.empty()
        );
    }

    @Test
    public void parseValue() throws InputParseException
    {
        assertEquals(
                m_inputParser.parseValue("1"),
                new InputNumber("1")
        );

        assertEquals(
                m_inputParser.parseValue("+"),
                Operator.ADD
        );
    }

    @Test
    public void parse() throws InputParseException
    {
        assertEquals(
            m_inputParser.parse("1 + 3"),
            TestUtils.createLinkedList(
                    new InputNumber("1"),
                    Operator.ADD,
                    new InputNumber("3")
            )
        );

        assertEquals(
                m_inputParser.parse("clear undo 3 sqrt"),
                TestUtils.createLinkedList(
                        Operator.CLEAR,
                        Operator.UNDO,
                        new InputNumber("3"),
                        Operator.SQRT
                )
        );
    }

    @Test
    public void throwException()
    {
        try {
            m_inputParser.parseValue("a");
        }
        catch (InputParseException exception) {
            return;
        }

        Assert.fail("Should have thrown an InputParseException exception");
    }
}
