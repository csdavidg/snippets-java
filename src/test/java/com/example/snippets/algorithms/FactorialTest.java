package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {


    private Factorial target = new Factorial();

    @Test
    public void test(){
        int number = target.calculateFactorial(0);
        assertEquals(1, number);
        number = target.calculateFactorial(1);
        assertEquals(1, number);
        number = target.calculateFactorial(2);
        assertEquals(2, number);
        number = target.calculateFactorial(3);
        assertEquals(6, number);
        number = target.calculateFactorial(4);
        assertEquals(24, number);
        number = target.calculateFactorial(5);
        assertEquals(120, number);
        number = target.calculateFactorial(6);
        assertEquals(720, number);
        number = target.calculateFactorial(7);
        assertEquals(5040, number);
        number = target.calculateFactorial(8);
        assertEquals(40320, number);
        number = target.calculateFactorial(9);
        assertEquals(362880, number);
    }

    @Test
    public void testRecursive(){
        int number = target.calculateFactorialRecursive(0);
        assertEquals(1, number);
        number = target.calculateFactorialRecursive(1);
        assertEquals(1, number);
        number = target.calculateFactorialRecursive(2);
        assertEquals(2, number);
        number = target.calculateFactorialRecursive(3);
        assertEquals(6, number);
        number = target.calculateFactorialRecursive(4);
        assertEquals(24, number);
        number = target.calculateFactorialRecursive(5);
        assertEquals(120, number);
        number = target.calculateFactorialRecursive(6);
        assertEquals(720, number);
        number = target.calculateFactorialRecursive(7);
        assertEquals(5040, number);
        number = target.calculateFactorialRecursive(8);
        assertEquals(40320, number);
        number = target.calculateFactorialRecursive(9);
        assertEquals(362880, number);
    }

}
