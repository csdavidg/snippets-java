package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinAVGSliceTest {

    @Test
    public void testSolution(){
        MinAVGSlice sut = new MinAVGSlice();
        assertEquals(1, sut.solution(new int[]{4,2,2,5,1,5,8}));
        assertEquals(0, sut.solution(new int[]{1,1}));
        assertEquals(4, sut.solution(new int[]{2,3,4,5,1,1,6,7,8,9,1}));
        assertEquals(3, sut.solution(new int[]{2,3,4,-5,-1,1,6,7,8,9,1}));

    }

}
