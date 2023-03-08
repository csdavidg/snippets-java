package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GenomicRangeQueryTest {

    @Test
    public void testSolution() {
        GenomicRangeQuery sut = new GenomicRangeQuery();
        assertArrayEquals(new int[]{2, 4, 1}, sut.solution("CAGCCTA",
                new int[]{2, 5, 0, 2}, new int[]{4, 5, 6, 2}));
    }
}
