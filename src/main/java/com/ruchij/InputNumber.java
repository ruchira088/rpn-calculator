package com.ruchij;

import java.math.BigDecimal;

public class InputNumber extends BigDecimal implements CalculatorInput
{
    public InputNumber(String p_number) {
        super(p_number);
    }

    public InputNumber(BigDecimal p_bigDecimal) {
        super(p_bigDecimal.toString());
    }
}
