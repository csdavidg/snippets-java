package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentTest {

    private Tournament target = new Tournament();

    @Test
    public void testTournamentWithEightTeams(){
        int[] values = {3,1,4,1,5,9,2,6};
        int champion = target.getChampion(values);
        assertEquals(9, champion);
    }

    @Test
    public void testTournamentWithSixteenTeams(){
        int[] values = {3,1,4,1,5,9,2,6,8,7,2,3,5,6,2,10,11};
        int champion = target.getChampion(values);
        assertEquals(11, champion);
    }

}
