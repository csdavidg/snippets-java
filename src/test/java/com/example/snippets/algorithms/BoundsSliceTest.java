package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoundsSliceTest {

    @Test
    public void testBoundsSlices(){
        BoundsSlice slice = new BoundsSlice();
        int bSlices = slice.solution(2, new int[]{3,5,7,6,3});
        assertEquals(9, bSlices);
    }
}
