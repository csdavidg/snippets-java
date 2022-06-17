package com.example.snippets.algorithms;

import java.util.Arrays;

public class MinAbsSumOfArray {

    public int getMinAbsSum(int[] ints) {

        Arrays.sort(ints);
        int minAbs = Math.abs(ints[0] + ints[0]);
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] >= minAbs){
                break;
            }
            for (int j = i; j < ints.length; j++) {
                minAbs = Integer.min(minAbs, Math.abs(ints[i] + ints[j]));
            }
        }

        return minAbs;
    }
}
