package com.ruchij;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InputNumberTest
{
    @Test
    public void toNumberString()
    {
        assertEquals("100", new InputNumber("100").toString());
        assertEquals("900", new InputNumber("900.00").toString());
        assertEquals("1.2", new InputNumber("1.2000").toString());
        assertEquals("1.2001", new InputNumber("1.2001").toString());
        assertEquals("1.4142135623", new InputNumber("1.4142135623730950488").toString());
    }

}
