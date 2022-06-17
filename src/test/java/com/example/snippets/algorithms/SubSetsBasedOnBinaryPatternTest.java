package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubSetsBasedOnBinaryPatternTest {

    private SubSetsBasedOnBinaryPattern target = new SubSetsBasedOnBinaryPattern();

    @Test
    public void firstTest(){
        target.getSubSets(new int[]{3, 9, 2});
        assertEquals(1, 1);
    }

    @Test
    public void firstTestRecursive(){
        List<Integer> result = target.recursiveSubsSet(List.of(3, 9, 2));
        System.out.println(result);
        assertEquals(1, 1);
    }

}
