package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToDecimalTest {

    @Test
    public void testSolution(){
        RomanToDecimal sut = new RomanToDecimal();
        assertEquals(3, sut.romanToInt("III"));
        assertEquals(58, sut.romanToInt("LVIII"));
        assertEquals(45, sut.romanToInt("XLV"));
        assertEquals(99, sut.romanToInt("XCIX"));
        assertEquals(1994, sut.romanToInt("MCMXCIV"));
        assertEquals(3999, sut.romanToInt("MMMCMXCIX"));
    }

    @Test
    public void testCase(){
        RomanToDecimal sut = new RomanToDecimal();
        assertEquals(3999, sut.romanToInt("MMMCMXCIX"));
    }
}
