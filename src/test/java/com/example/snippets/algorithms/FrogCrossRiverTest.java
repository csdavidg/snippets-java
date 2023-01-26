package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrogCrossRiverTest {


    @Test
    public void baseCase(){
        int[] data = new int[] {1,3,1,4,2,3,5,4};
        FrogCrossRiver sut = new FrogCrossRiver();
        assertEquals(6, sut.solution(5, data));

        data = new int[] {1,3,1,4,2,3,3,4};
        assertEquals(-1, sut.solution(5, data));

        data = new int[] {1,3,5,4,2,3,3,4};
        assertEquals(4, sut.solution(5, data));

    }
}
