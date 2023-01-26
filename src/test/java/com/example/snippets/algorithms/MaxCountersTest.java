package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxCountersTest {

    @Test
    public void testMaxCounters() throws Exception {
        MaxCounters sut = new MaxCounters();

        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, sut.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        assertArrayEquals(new int[]{5, 4, 4, 5, 4}, sut.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 6, 1, 4}));
        assertArrayEquals(new int[]{5, 6, 5, 5, 5}, sut.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 6, 1, 4, 6, 2}));
        assertArrayEquals(new int[]{4, 4, 4, 4, 4}, sut.solution(5, new int[]{6, 1, 6, 3, 4, 5, 5, 3, 3, 6}));
        assertArrayEquals(new int[]{2}, sut.solution(1, new int[]{1, 2, 1, 2}));
        assertArrayEquals(new int[]{2, 2}, sut.solution(2, new int[]{1, 2, 1, 2}));

        assertArrayEquals(new int[]{0, 0}, sut.solution(2, new int[]{3, 3, 3, 3}));//
        assertArrayEquals(new int[]{1, 1}, sut.solution(2, new int[]{1, 3, 3, 3, 3}));
    }

}
