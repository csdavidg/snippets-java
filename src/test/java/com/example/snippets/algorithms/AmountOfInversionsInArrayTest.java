package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmountOfInversionsInArrayTest {

    @Test
    public void testSearch(){
        AmountOfInversionsInArray target = new AmountOfInversionsInArray();
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9};
        int result = target.binarySearchLowerValue(numbers, 7);
        assertEquals(6,result);

        numbers = new int[]{1,2,3,4,4,5,6,7,8,9};
        result = target.binarySearchLowerValue(numbers, 4);
        assertEquals(3,result);

        numbers = new int[]{1,2,3,4,4,4,4,5,6,7,8,9};
        result = target.binarySearchLowerValue(numbers, 4);
        assertEquals(3,result);
    }

    @Test
    public void test(){
        AmountOfInversionsInArray target = new AmountOfInversionsInArray();

        int[] numbers = new int[]{-1,6,3,4,7,4};
        int totalInversions = target.getAmountOfInversions(numbers);
        assertEquals(4, totalInversions);

        numbers = new int[]{3,2,5,4,3};
        totalInversions = target.getAmountOfInversions(numbers);
        assertEquals(4, totalInversions);

        numbers = new int[]{1,2,3,4,5,6,7,8,9};
        totalInversions = target.getAmountOfInversions(numbers);
        assertEquals(0, totalInversions);

        numbers = new int[]{9,8,7,6,5,4,3,2,1};
        totalInversions = target.getAmountOfInversions(numbers);
        assertEquals(36, totalInversions);

        int n = 10000;
        numbers = new int[n];

        int num = n;
        for (int i = 0; i < n; i++) {
            numbers[i] = num;
            num--;
        }
        totalInversions = target.getAmountOfInversions(numbers);
        assertEquals(49995000, totalInversions);
    }

    @Test
    public void testBinarySearchApproach(){
        AmountOfInversionsInArray target = new AmountOfInversionsInArray();

        int[] numbers = new int[]{-1,6,3,4,7,4};
        int totalInversions = target.getAmountOfInversionsBinarySearchApproach(numbers);
        assertEquals(4, totalInversions);

        numbers = new int[]{3,2,5,4,3};
        totalInversions = target.getAmountOfInversionsBinarySearchApproach(numbers);
        assertEquals(4, totalInversions);

        numbers = new int[]{1,2,3,4,5,6,7,8,9};
        totalInversions = target.getAmountOfInversionsBinarySearchApproach(numbers);
        assertEquals(0, totalInversions);

        numbers = new int[]{9,8,7,6,5,4,3,2,1};
        totalInversions = target.getAmountOfInversionsBinarySearchApproach(numbers);
        assertEquals(36, totalInversions);

        int n = 10000;
        numbers = new int[n];

        int num = n;
        for (int i = 0; i < n; i++) {
            numbers[i] = num;
            num--;
        }
        totalInversions = target.getAmountOfInversionsBinarySearchApproach(numbers);
        assertEquals(49995000, totalInversions);
    }


    @Test
    public void testMergeSortApproach(){
        AmountOfInversionsInArray target = new AmountOfInversionsInArray();

        int[] numbers1 = new int[]{-1,6,3,4,7,4};
        int totalInversions1 = target.getAmountOfInversionsMergeSort(numbers1);
        assertEquals(4, totalInversions1);

        int[] numbers = new int[]{3,2,5,4,3};
        int totalInversions = target.getAmountOfInversionsMergeSort(numbers);
        assertEquals(4, totalInversions);

        int[] numbers3 = new int[]{9,8,7,6,5,4,3,2,1};

        int totalInversions3 = target.getAmountOfInversionsMergeSort(numbers3);
        assertEquals(36, totalInversions3);

       int [] numbers2 = new int[]{1,2,3,4,5,6,7,8,9};
        int totalInversions2 = target.getAmountOfInversionsMergeSort(numbers2);
        assertEquals(0, totalInversions2);


        int n = 10000;
        int[] numbers4 = new int[n];

        int num = n;
        for (int i = 0; i < n; i++) {
            numbers4[i] = num;
            num--;
        }
        int totalInversions4 = target.getAmountOfInversionsMergeSort(numbers4);
        assertEquals(49995000, totalInversions4);
    }


}
