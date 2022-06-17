package com.example.snippets.others;

import com.example.snippets.elections.ColombianElections;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColombianElectionsTest {

    @Test
    public void firstTest(){
        ColombianElections target = new ColombianElections();

        List<List<String>> votes = new ArrayList<>();
        votes.add(List.of("A","B", "C"));
        votes.add(List.of("B", "C"));
        votes.add(List.of("D"));
        //B - 5
        //A - 3
        //C - 3
        //D - 3

        List<String> result = target.findWinner(votes);
        List<String> expectedValues = List.of("B", "A", "C", "D");
        assertEquals(expectedValues, result);

        votes = new ArrayList<>();
        votes.add(List.of("A"));
        votes.add(List.of("B", "D", "C"));
        votes.add(List.of("E", "C", "A"));
        votes.add(List.of("F", "D"));
        //A - 4
        //D - 4
        //B - 3
        //C - 3
        //E - 3
        //F - 3

        List<String> result2 = target.findWinner(votes);
        List<String> expectedValues2 = List.of("A","D", "B", "C", "E", "F");
        assertEquals(expectedValues2, result2);
    }

    @Test
    public void testSet(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(3);
        numbers.add(11);

        System.out.println(numbers);
    }

}