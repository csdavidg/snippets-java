package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;

public class ArrIsPermutation {

    public int solution(int[] A) {
        long sumVals = 0;
        long total = (long) A.length * (A.length + 1) / 2;

        Map<Integer, Integer> uniqueValues = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (uniqueValues.putIfAbsent(A[i], i) == null) {
                sumVals += A[i];
            } else {
                return 0;
            }
        }

        return (sumVals == total) ? 1 : 0;
    }
}
