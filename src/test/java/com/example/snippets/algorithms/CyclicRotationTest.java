package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CyclicRotationTest {

    @Test
    public void testSolution() {
        CyclicRotation sut = new CyclicRotation();
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, sut.solution(new int[]{3, 8, 9, 7, 6}, 3));
        assertArrayEquals(new int[]{0, 0, 0}, sut.solution(new int[]{0, 0, 0}, 1));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sut.solution(new int[]{1, 2, 3, 4}, 4));
        assertArrayEquals(new int[]{4, 1, 2, 3}, sut.solution(new int[]{1, 2, 3, 4}, 5));
        assertArrayEquals(new int[]{4, 1, 2, 3}, sut.solution(new int[]{1, 2, 3, 4}, 9));
        assertArrayEquals(new int[]{3, 4, 1, 2}, sut.solution(new int[]{1, 2, 3, 4}, 10));
        assertArrayEquals(new int[0], sut.solution(new int[0], 2));
        assertArrayEquals(new int[]{1, 2, 3, 4}, sut.solution(new int[]{1, 2, 3, 4}, 4));
        assertArrayEquals(new int[1], sut.solution(new int[1], 2));
    }

    @Test
    public void testSpecificCase(){
        CyclicRotation sut = new CyclicRotation();
        assertArrayEquals(new int[]{1, 2, 3, 4}, sut.solution(new int[]{1, 2, 3, 4}, 4));
        assertArrayEquals(new int[1], sut.solution(new int[1], 2));
    }
}
