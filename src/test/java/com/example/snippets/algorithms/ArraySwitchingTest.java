package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySwitchingTest {

    private ArraySwitching target = new ArraySwitching();

    @Test
    public void test(){

        int result = target.solution(new int[]{7,-5, -5, -5,7,-1,7,-1,7,-1});
        assertEquals(6, result);

        result = target.solution(new int[]{3,2,3,2,3});
        assertEquals(5, result);

        result = target.solution(new int[]{7,4,-2,4,-2,-9});
        assertEquals(4, result);

        result = target.solution(new int[]{7,-5, -5, -5,7,-1,7});
        assertEquals(3, result);

        result = target.solution(new int[]{7,-5});
        assertEquals(2, result);

        result = target.solution(new int[]{7});
        assertEquals(1, result);


    }

}
