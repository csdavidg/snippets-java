package com.example.snippets.algorithms;

import java.util.Arrays;

public class ArrayMissingNumber {


    public int solution(int[] arr){

        Arrays.sort(arr);
        int minVal = 1;
        for (int i = 0; i < arr.length; i++) {
            if(minVal == arr[i]){
                minVal++;
            }
        }
        return minVal;
    }

}
