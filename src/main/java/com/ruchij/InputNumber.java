package com.ruchij;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InputNumber extends BigDecimal implements CalculatorInput
{
    public InputNumber(String p_number)
    {
        super(p_number);
    }

    public InputNumber(BigDecimal p_bigDecimal)
    {
        super(p_bigDecimal.toString());
    }

    @Override
    public boolean isOperator()
    {
        return false;
    }

    public String toString()
    {
        String string = super.toPlainString();

        if (scale() >= 1) {
            BigDecimal bigDecimal = new BigDecimal(string);
            string = bigDecimal.setScale(10, RoundingMode.DOWN).stripTrailingZeros().toPlainString();
        }

        return string;
    }
}
