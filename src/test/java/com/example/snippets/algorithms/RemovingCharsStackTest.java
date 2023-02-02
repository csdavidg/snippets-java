package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemovingCharsStackTest {

    @Test
    public void testRemovingChars(){
        RemovingCharsStack sut = new RemovingCharsStack();
        assertEquals("a", sut.solution("abbcccb", 3));
        assertEquals("aba", sut.solution("aba", 1));
        assertEquals("bc", sut.solution("abbcaacabc", 2));

    }

    @Test
    public void testSpecificCase(){
        RemovingCharsStack sut = new RemovingCharsStack();
        //assertEquals("bc", sut.solution("abbcaacabc", 2));
        assertEquals("bc", sut.solution("aabc", 2));

    }
}
