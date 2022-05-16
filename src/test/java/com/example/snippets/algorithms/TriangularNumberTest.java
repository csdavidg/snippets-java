package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangularNumberTest {

    private TriangularNumber target = new TriangularNumber();

    @Test
    public void test(){
        int number = target.calculateTriangularNumber(3);
        assertEquals(6, number);

        number = target.calculateTriangularNumber(4);
        assertEquals(10, number);

        number = target.calculateTriangularNumber(5);
        assertEquals(15, number);

        number = target.calculateTriangularNumber(6);
        assertEquals(21, number);

        number = target.calculateTriangularNumberRecursive(1000);
        assertEquals(500500, number);

    }

    @Test
    public void testRecursiveMethod(){
        int number = target.calculateTriangularNumberRecursive(3);
        assertEquals(6, number);

        number = target.calculateTriangularNumberRecursive(4);
        assertEquals(10, number);

        number = target.calculateTriangularNumberRecursive(5);
        assertEquals(15, number);

        number = target.calculateTriangularNumberRecursive(6);
        assertEquals(21, number);

        number = target.calculateTriangularNumberRecursive(1000);
        assertEquals(500500, number);

    }

}
