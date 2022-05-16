package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    private MergeSort target = new MergeSort();

    /**
     * This method uses an approach that creates a new array for left and right
     */
    @Test
    public void testMergeSortWithHighSpaceComplexity() {
        int[] numbers = new int[]{1, 2, 4, 3, 5, 6};
        int[] result = target.WithHighSpaceComplexity(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);

        numbers = new int[]{6, 5, 4, 3, 2, 1};
        result = target.WithHighSpaceComplexity(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);

        numbers = new int[]{6, 5, 4, 4, 3, 2, 1};
        result = target.WithHighSpaceComplexity(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5, 6}, result);

    }

    /**
     * This method uses just one additional array
     */
    @Test
    public void testMergeSortMoreEfficient() {
        int[] numbers = new int[]{6, 5, 4, 3, 2, 1};
        int[] result = target.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);

        numbers = new int[]{1, 2, 4, 3, 5, 6};
        result = target.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);

        int n = 10000;
        numbers = new int[n];

        int num = n;
        for (int i = 0; i < n; i++) {
            numbers[i] = num;
            num--;
        }
        result = target.sort(numbers);
        int[] sortNumbers = Arrays.copyOf(numbers, numbers.length);
        assertArrayEquals(sortNumbers, result);
    }

    @Test
    public void testMergeMethod() {
        int[] left = new int[]{1, 2, 4};
        int[] right = new int[]{3, 5, 6};
        int[] result = target.merge(left, right);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);
    }

    @Test
    public void testMergeByReferenceMethod() {
        int[] numbers = new int[]{1, 2, 4, 3, 5, 6};
        int[] merge = new int[numbers.length];
        int low = 0;
        int high = numbers.length-1;
        int mid = (low + high) / 2;
        int[] result = target.mergeByReference(numbers, merge, low, mid, high);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, result);
    }


}