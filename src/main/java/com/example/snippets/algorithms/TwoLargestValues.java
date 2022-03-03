package com.example.snippets.algorithms;

import java.util.Arrays;

public class TwoLargestValues {

    public int[] getTwoLargestValuesInArray(int[] arr) {
        if(arr.length <=1 ){
            return arr;
        }
//        int[] arr = {1, 2, 3, 4, 5};
//        Arrays.fill(res, arr[0]);
        int[] res = {arr[0], arr[1]};

        for (int val : arr) {
            if (val > res[1]) {
                res[0] = res[1];
                res[1] = val;
            }
        }
        return res;
    }

}
