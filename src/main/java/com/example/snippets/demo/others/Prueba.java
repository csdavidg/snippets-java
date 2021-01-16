package com.example.snippets.demo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 6, 6, 5, 6, 5,6,6, 3, 4, 1, 2, 2, 1);
        System.out.println(arr.size());
        System.out.println(longestSubarray(arr));
    }


    public static int longestSubarray(List<Integer> arr) {
        // Write your code here
        List<Integer> subArr = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int maxSize = 0;
        for (Integer num : arr) {
            if (validateDifference(subArr, num)) {
                maxSize++;
                if (!subArr.contains(num)) {
                    subArr.add(num);
                }
            } else {
                sizes.add(maxSize);
                maxSize = 1;
                subArr.clear();
                subArr.add(num);
            }
        }
        sizes.add(maxSize);
        return sizes.stream().mapToInt(v -> v).max().orElse(0);

    }

    public static boolean validateDifference(List<Integer> integerList, int actual) {
        for (Integer num : integerList) {
            int result = actual - num;
            result = (result < 0) ? result * -1 : result;
            if (result > 1) {
                return false;
            }
        }
        return true;
    }
}
