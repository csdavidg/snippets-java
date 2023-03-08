package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayMissingNumberTest {

    @Test
    public void testSolution() {
        ArrayMissingNumber sut = new ArrayMissingNumber();
        assertEquals(1, sut.solution(new int[]{2, 3, 4, 5}));
    }

}
