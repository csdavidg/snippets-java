package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindTargetSumNumberTest {


    @Test
    public void testFindTargetSum(){
        FindTargetSumNumber sut = new FindTargetSumNumber();
        assertArrayEquals(new int[]{0,2}, sut.solution(7, new int[]{3,2,4}));
        assertArrayEquals(new int[]{2,3}, sut.solution(9, new int[]{3,2,4,5,8,9}));
        assertArrayEquals(new int[]{2,3}, sut.solution(6, new int[]{3,3,2,4,5,8,9}));
    }
}
