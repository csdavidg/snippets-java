package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinValArrayTest {

    @Test
    public void testSolution(){
        MinValArray sut = new MinValArray();
        assertEquals(5, sut.solution(new int[]{1,3,6,4,1,2}));
        assertEquals(1, sut.solution(new int[]{-1,-3}));
        assertEquals(4, sut.solution(new int[]{1, 3, 2}));
        assertEquals(4, sut.solution(new int[]{1, 3, 2, 5}));
        assertEquals(4, sut.solution(new int[]{-10,-3, 1, 2, 3}));
        assertEquals(100001, sut.solution(IntStream.rangeClosed(1, 100000).toArray()));
    }

    @Test
    public void testSpecificCase(){
        MinValArray sut = new MinValArray();
        assertEquals(5, sut.solution(new int[]{1,3,6,4,1,2}));
    }

}
