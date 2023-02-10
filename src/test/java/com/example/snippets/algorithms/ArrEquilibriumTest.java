package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrEquilibriumTest {

    @Test
    public void testSolution(){
        ArrEquilibrium sut = new ArrEquilibrium();
        assertEquals(1, sut.solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(0, sut.solution(new int[]{1, 1}));
        assertEquals(9, sut.solution(new int[]{10, 1}));
        assertEquals(9, sut.solution(new int[]{-10, -1}));
    }

    @Test
    public void testSolutionSpecific(){
        ArrEquilibrium sut = new ArrEquilibrium();
        assertEquals(11, sut.solution(new int[]{-10, 1}));
    }
}
