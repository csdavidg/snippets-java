package com.example.snippets.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinValArray {

    public int solution(int[] A) {
        TreeMap<Integer, Integer> nums = new TreeMap<>();
        for (int i = 0; i <= A.length; i++) {
            nums.put(i+1, i+1);
        }

        for (int i = 0; i < A.length; i++) {
            nums.remove(A[i]);
        }
        return nums.firstKey();
    }

    public int optimalSolution(int[] A) {
        Arrays.sort(A);

        int minVal = 1;
        for (int i = 0; i < A.length; i++) {
            if(minVal == A[i]){
                minVal++;
            }
        }
        return minVal;
    }
}
