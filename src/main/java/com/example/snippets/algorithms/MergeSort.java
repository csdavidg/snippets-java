package com.example.snippets.algorithms;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] numbers) {
        int[] merge = new int[numbers.length];
        return rSort(numbers, merge, 0, numbers.length - 1);
    }

    public int[] rSort(int[] numbers, int[] merge, int low, int high) {
        if (high <= low) {
            return numbers;
        }
        int mid = (low + high) / 2;
        rSort(numbers, merge, low, mid);
        rSort(numbers, merge, mid + 1, high);
        return mergeByReference(numbers, merge, low, mid, high);

    }

    public int[] mergeByReference(int[] numbers, int[] merge, int low, int mid, int high) {

        System.arraycopy(numbers,low,merge,low,(high+1-low));
        int leftIdx = low;
        int rightIdx = mid + 1;

        for (int i = low; i <= high; i++) {

            if (leftIdx > mid) {
                System.arraycopy(merge,rightIdx,numbers,i,(high+1-rightIdx));
                return numbers;
            } else if (rightIdx > high) {
                System.arraycopy(merge,leftIdx,numbers,i,(mid+1-leftIdx));
                return numbers;
            } else if (merge[rightIdx] < merge[leftIdx]) {
                numbers[i] = merge[rightIdx];
                rightIdx++;
            } else {
                numbers[i] = merge[leftIdx];
                leftIdx++;
            }
        }

        return numbers;
    }


    /**
     * First approach using a higher space complexity
     *
     * @param numbers
     * @return
     */

    public int[] WithHighSpaceComplexity(int[] numbers) {

        if (numbers.length <= 1) {
            return numbers;
        }

        int low = 0;
        int high = numbers.length;
        int mid = (low + high) / 2;
        int[] left = WithHighSpaceComplexity(Arrays.copyOfRange(numbers, low, mid));
        int[] right = WithHighSpaceComplexity(Arrays.copyOfRange(numbers, mid, high));
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {

        int leftIdx = 0;
        int rightIdx = 0;
        int[] merge = new int[left.length + right.length];

        for (int i = 0; i < merge.length; i++) {

            if (right[rightIdx] < left[leftIdx]) {
                merge[i] = right[rightIdx];
                rightIdx++;
            } else {
                merge[i] = left[leftIdx];
                leftIdx++;
            }

            if (leftIdx == left.length) {
                System.arraycopy(right, rightIdx, merge, ++i, right.length-rightIdx);
                return merge;
            }

            if (rightIdx == right.length) {
                System.arraycopy(left, leftIdx, merge, ++i, left.length-leftIdx);
                return merge;
            }
        }

        return merge;
    }

}
