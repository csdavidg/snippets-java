package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParenthesisPairsTest {

    @Test
    public void testSolution(){
        ParenthesisPairs sut = new ParenthesisPairs();
        assertEquals(0, sut.solution(")()("));
        assertEquals(1, sut.solution(""));
        assertEquals(1, sut.solution("()()"));
        assertEquals(1, sut.solution("(()()()()()())"));
        assertEquals(0, sut.solution("("));
        assertEquals(0, sut.solution(")"));
    }

}
