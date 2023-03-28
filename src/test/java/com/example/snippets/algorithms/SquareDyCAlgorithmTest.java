package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SquareDyCAlgorithmTest {

    @Test
    public void testSolution(){
        SquareDyCAlgorithm sdyc = new SquareDyCAlgorithm();
        assertArrayEquals(new int[]{80,80}, sdyc.getMaxSize(new int[]{1680, 640}));
    }
}
