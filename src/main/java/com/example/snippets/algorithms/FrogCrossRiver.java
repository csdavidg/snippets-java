package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FrogCrossRiver {
    public int solution(int X, int[] A) {
        Map<Integer, Integer> values = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            values.putIfAbsent(A[i], i);
            if(values.size() == X){
                return i;
            }
        }
        return -1;
    }
}
