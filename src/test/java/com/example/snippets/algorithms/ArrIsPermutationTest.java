package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrIsPermutationTest {

    @Test
    public void testSolution() {
        ArrIsPermutation sut = new ArrIsPermutation();
        assertEquals(1, sut.solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, sut.solution(new int[]{4, 1, 3}));
        assertEquals(1, sut.solution(new int[]{4, 1, 3, 2, 5}));
        assertEquals(0, sut.solution(new int[]{4, 1, 3, 2, 9}));
        assertEquals(0, sut.solution(new int[]{1, 1, 4}));
        assertEquals(0, sut.solution(new int[]{1, 2, 1, 6}));
        assertEquals(0, sut.solution(new int[]{4, 4, 1, 1}));
    }
}
