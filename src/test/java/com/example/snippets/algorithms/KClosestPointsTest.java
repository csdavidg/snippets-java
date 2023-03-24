package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KClosestPointsTest {

    @Test
    public void testSolution() {
        KClosestPoints points = new KClosestPoints();
        assertArrayEquals(new int[][]{{-2, 2}}, points.solution(new int[][]{{1, 3}, {-2, 2}}, 1));
        assertArrayEquals(new int[][]{{-2, 4}, {3, 3}}, points.solution(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
        assertArrayEquals(new int[][]{{1, 1}, {-2, 4}, {3, 3}}, points.solution(new int[][]{{3, 3}, {5, -1}, {-2, 4}, {1, 1}}, 3));
    }

    @Test
    public void testSpecificSolution() {
        KClosestPoints points = new KClosestPoints();
        int[][] result = points.solution(new int[][]{{0, 1}, {1, 0}}, 2);
        for (int[] ints : result) {
            System.out.println(ints[0] + "," + ints[1]);
        }
    }
}
