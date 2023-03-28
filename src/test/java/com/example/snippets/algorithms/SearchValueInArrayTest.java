package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SearchValueInArrayTest {

    SearchValueInArray sut = new SearchValueInArray();

    @Test
    public void testSolution() {
        int i = 10;
        int j = 5;

        i += (j * 5 + i) / j + 2;
        System.out.println(i);

        assertArrayEquals(new int[][]{{2, 1}},
                sut.lookForIndex(new int[][]{   {10, 20, 30, 40},
                                                {15, 25, 35, 45},
                                                {27, 29, 37, 48},
                                                {32, 33, 39, 50}}, 29));

        assertArrayEquals(new int[][]{{3, 3}},
                sut.lookForIndex(new int[][]{   {10, 20, 30, 40},
                                                {15, 25, 35, 45},
                                                {27, 29, 37, 48},
                                                {32, 33, 39, 50}}, 50));

        assertArrayEquals(new int[][]{{3, 4}},
                sut.lookForIndex(new int[][]{   {10, 20, 30, 40, 41},
                                                {15, 25, 35, 45, 51},
                                                {27, 29, 37, 48, 59},
                                                {32, 33, 39, 50, 61}}, 61));

        assertArrayEquals(new int[][]{{2, 1}},
                sut.lookForIndex(new int[][]{   {1,  2,  3,  4,  5},
                                                {6,  7,  8,  9,  10},
                                                {11, 12, 13, 14, 15},
                                                {16, 17, 18, 19, 20}}, 12));

        assertArrayEquals(new int[][]{{-1, -1}},
                sut.lookForIndex(new int[][]{   {1,  2,  3,  4,  5},
                                                {6,  7,  8,  9,  10},
                                                {11, 12, 13, 14, 15},
                                                {16, 17, 18, 19, 20}}, 21));

        assertArrayEquals(new int[][]{{0, 0}},
                sut.lookForIndex(new int[][]{   {1,  2,  3,  4,  5},
                                                {6,  7,  8,  9,  10},
                                                {11, 12, 13, 14, 15},
                                                {16, 17, 18, 19, 20}}, 1));
    }

}
