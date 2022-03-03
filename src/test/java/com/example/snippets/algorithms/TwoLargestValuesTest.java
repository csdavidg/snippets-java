package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoLargestValuesTest {

    private TwoLargestValues target = new TwoLargestValues();

    @Test
    public void testMethod() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] result = target.getTwoLargestValuesInArray(arr);
        assertArrayEquals(new int[]{6, 7}, result);

        arr = new int[]{-1,-2,0};
        result = target.getTwoLargestValuesInArray(arr);
        assertArrayEquals(new int[]{-1, 0}, result);

        arr = new int[]{20,-2,100, -10, 0};
        result = target.getTwoLargestValuesInArray(arr);
        assertArrayEquals(new int[]{20, 100}, result);

        arr = new int[]{15, 19, 20, 18, 17, 16};
        result = target.getTwoLargestValuesInArray(arr);
        assertArrayEquals(new int[]{19, 20}, result);

        arr = new int[]{10};
        result = target.getTwoLargestValuesInArray(arr);
        assertArrayEquals(new int[]{10}, result);

        arr = new int[]{10, 8};
        result = target.getTwoLargestValuesInArray(arr);
        assertArrayEquals(new int[]{8, 10}, result);

    }

}
