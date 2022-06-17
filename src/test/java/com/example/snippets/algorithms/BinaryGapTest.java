package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryGapTest {

    private BinaryGap target = new BinaryGap();


    @Test
    public void test(){
        int result = target.calculateBinaryGap(9);
        assertEquals(2, result);

        result = target.calculateBinaryGap(529);
        assertEquals(4, result);

        result = target.calculateBinaryGap(20);
        assertEquals(1, result);

        result = target.calculateBinaryGap(15);
        assertEquals(0, result);

    }

}
