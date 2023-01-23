package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisTournamentTest {


    @Test
    public void testTournament(){
        TennisTournament sut = new TennisTournament();
        assertEquals(3, sut.solution(10, 3));
        assertEquals(2, sut.solution(5, 3));

        assertEquals(3, sut.solution(20, 3));
        assertEquals(10, sut.solution(20, 11));
    }

}
