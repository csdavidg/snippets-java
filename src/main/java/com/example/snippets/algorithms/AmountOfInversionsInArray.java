package com.example.snippets.algorithms;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An array A consisting of N integers is given.
 * An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
 * https://app.codility.com/demo/results/trainingP7S5UP-RTJ/
 */
public class AmountOfInversionsInArray {

    Map<String, Integer> swaps = new HashMap<>();
    int c = 0;

    /**
     * Using merge sort algorithm
     */

    public int getAmountOfInversionsMergeSort(int[] numbers) {
        int[] merge = new int[numbers.length];
        return rSort(numbers, merge, 0, numbers.length - 1);
    }

    public int rSort(int[] numbers, int[] merge, int low, int high) {
        if (high <= low) {
            return 0;
        }
        int count = 0;
        int mid = (low + high) / 2;
        count += rSort(numbers, merge, low, mid);
        count += rSort(numbers, merge, mid + 1, high);
        count += mergeByReference(numbers, merge, low, mid, high);
        System.out.println(count);
        return count;
    }

    public int mergeByReference(int[] numbers, int[] merge, int low, int mid, int high) {

        int swaps = 0;

        System.arraycopy(numbers, low, merge, low, (high + 1 - low));
        int leftIdx = low;
        int leftZeroIn = 0;
        int rightIdx = mid + 1;

        for (int i = low; i <= high; i++) {

            if (leftIdx > mid) {
                numbers[i] = merge[rightIdx];
                rightIdx++;
            } else if (rightIdx > high) {
                numbers[i] = merge[leftIdx];
                leftIdx++;
            } else if (merge[leftIdx] <= merge[rightIdx]) {
                numbers[i] = merge[leftIdx];
                leftIdx++;
                leftZeroIn++;
            } else {
                numbers[i] = merge[rightIdx];
                rightIdx++;
                swaps += (mid + 1) - (low + leftZeroIn);
            }
        }

        return swaps;
    }

    /**
     * Using merge sort algorithm
     */


    public int getAmountOfInversions(int[] numbers) {


        int count = 0;

        for (int p = 0; p < numbers.length; p++) {
            int[] subInts = Arrays.copyOfRange(numbers, p + 1, numbers.length);
            Arrays.sort(subInts);

            int i = 0;
            int individualCount = 0;
            while (i < subInts.length && subInts[i] < numbers[p]) {
                individualCount++;
                i++;
            }
            count += individualCount;
        }

        return count;
    }

    public int getAmountOfInversionsCompletableFutures(int[] numbers) {
        return IntStream.rangeClosed(0, numbers.length)
                .mapToObj(p -> CompletableFuture.supplyAsync(() -> getCountInversions(numbers, p)))
                .collect(Collectors.toList())
                .stream().map(CompletableFuture::join)
                .reduce(Integer::sum).orElse(0);
    }

    public int getAmountOfInversionsParallel(int[] numbers) {
        return IntStream.rangeClosed(0, numbers.length)
                .parallel()
                .map(p -> getCountInversions(numbers, p))
                .sum();
    }

    public int getAmountOfInversionsBinarySearchApproach(int[] numbers) {

        int count = 0;

        for (int p = 0; p < numbers.length; p++) {
            int[] subInts = Arrays.copyOfRange(numbers, p + 1, numbers.length);
            Arrays.sort(subInts);

            if (subInts.length > 0) {
                int maxLength = subInts.length;
                int key = numbers[p];
                int searchResult = -1;
                int searchTimes = 0;

                if (key > subInts[0] && key < subInts[maxLength - 1]) {
                    while (searchResult < 0 && searchTimes < maxLength) {
                        searchResult = binarySearchLowerValue(subInts, key);
                        key++;
                        searchTimes++;
                    }

                    if (searchResult > 0) {
                        count += searchResult;
                    } else if (searchResult == -1) {
                        count += subInts.length;
                    }
                } else if (key > subInts[maxLength - 1]) {
                    count += subInts.length;
                }
            }
        }

        return count;
    }


    public int binarySearchLowerValue(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > numbers[mid]) {
                low = mid + 1;
            } else if (target < numbers[mid]) {
                high = mid - 1;
            } else {
                found = mid;
                high = mid - 1;
            }
        }

        return found;
    }

    private int getCountInversions(int[] numbers, int p) {
        int countInversions = 0;
        for (int q = p + 1; q < numbers.length; q++) {
            if (numbers[q] < numbers[p]) {
                countInversions++;
            }
        }
        return countInversions;
    }
}
