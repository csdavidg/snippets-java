package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersPairsUsingQueueAndStacksTest {

    @Test
    public void testSolution(){
        CharactersPairsUsingQueueAndStacks sut = new CharactersPairsUsingQueueAndStacks();
        assertEquals(1, sut.solution("{[()()]}"));
        assertEquals(1, sut.solution("{}"));
        assertEquals(1, sut.solution("[{()}]"));
        assertEquals(0, sut.solution("{[)]}"));
        assertEquals(0, sut.solution("}"));
        assertEquals(0, sut.solution(""));
        assertEquals(0, sut.solution("[[]"));
        assertEquals(0, sut.solution("[[]}"));
        assertEquals(1, sut.solution("[[]]"));
        assertEquals(0, sut.solution("[{([{"));
        assertEquals(0, sut.solution("]})})"));
        assertEquals(0, sut.solution("dskasliopqdd"));
        assertEquals(1, sut.solution("[[{(((())))}]]"));
    }

    @Test
    public void testSpecificSolution(){
        CharactersPairsUsingQueueAndStacks sut = new CharactersPairsUsingQueueAndStacks();
        assertEquals(0, sut.solution(null));
    }

}
