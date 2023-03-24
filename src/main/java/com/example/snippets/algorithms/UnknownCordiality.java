package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;

public class UnknownCordiality {


    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> nums = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            nums.merge(arr[i], 1, Integer::sum);
        }
        return nums.size() == nums.values().stream().distinct().count();
    }
    public int solution(int[] A) {

        double[] subSum = new double[A.length];
        subSum[0] = A[0];

        int p = 0;
        int q = 1;

        double minVal = 10000;
        int pos = A.length;
        boolean fillingArray = true;

        while(q < A.length){

            if(fillingArray){
                subSum[q] = subSum[q-1] + A[q];
            }

            double avg = 0;
            if(p == 0){
                avg =  (subSum[q] - 0) / (q - p + 1);
            } else {
                avg =  (subSum[q] - subSum[p-1]) / (q - p + 1);
            }
            if(avg < minVal){
                minVal = avg;
                pos = p;
            }
            q++;
            if(q == A.length){
                p++;
                q = p+1;
                fillingArray = false;
            }
        }

        return pos;
    }
}
