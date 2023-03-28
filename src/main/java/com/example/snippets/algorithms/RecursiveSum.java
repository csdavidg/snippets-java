package com.example.snippets.algorithms;

import java.util.Arrays;

public class RecursiveSum {

    public int sum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        return arr[arr.length - 1] + sum(Arrays.copyOf(arr, arr.length - 1));
    }

    public int countMembersInArray(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        return 1 + countMembersInArray(Arrays.copyOf(arr, arr.length - 1));
    }

    public int maxNumber(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = maxNumber(Arrays.copyOf(arr, arr.length - 1));
        if(arr[arr.length - 1] > max){
            return arr[arr.length - 1];
        }
        return max;
    }
}
