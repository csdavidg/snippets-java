package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveSumTest {

    @Test
    public void testRecursiveSum() {
        RecursiveSum recursiveSum = new RecursiveSum();
        //assertEquals(21, recursiveSum.sum(new int[]{9,3,4,5}));
        int[] arr = new int[]{9,3,4,5,3,5,6,7,10};
        assertEquals(Arrays.stream(arr).sum(), recursiveSum.sum(arr));
    }

    @Test
    public void testRecursiveCount() {
        RecursiveSum recursiveSum = new RecursiveSum();
        assertEquals(4, recursiveSum.countMembersInArray(new int[]{9,3,4,5}));
    }

    @Test
    public void testRecursiveMaxNumber() {
        RecursiveSum recursiveSum = new RecursiveSum();
        assertEquals(9, recursiveSum.maxNumber(new int[]{9,3,4,5}));
    }
}
