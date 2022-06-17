package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinAbsSumOfArrayTest {

    private MinAbsSumOfArray target = new MinAbsSumOfArray();

    @Test
    public void test() {
        int result = target.getMinAbsSum(new int[]{1, 4, -3});
        assertEquals(1, result);

        result = target.getMinAbsSum(new int[]{-8,4,5,-10,3});
        assertEquals(3, result);

        result = target.getMinAbsSum(new int[]{-1000000000});
        assertEquals(2000000000, result);
    }
}
