package com.example.snippets.demo.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SubSets {

    public static void main(String[] args) {
        //System.out.println(subsets(Arrays.asList(1, 4, 9)));
        System.out.println(recursiveFactorial(4));
        System.out.println(factorialTailRecursive(4));
    }

    static List<List<Integer>> subsets(List<Integer> list) {

        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subAns = subsets(rest);
        List<List<Integer>> subAns2 = insertAll(first, subAns);

        return concat(subAns, subAns2);
    }

    static List<List<Integer>> insertAll(Integer first,
                                         List<List<Integer>> subAns) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : subAns) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a,
                                      List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static int recursiveFactorial(int n) {
        return n == 1 ? 1 : n * recursiveFactorial(n - 1);
    }

    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long a, long b) -> a * b);
    }

    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    static long factorialHelper(long acc, long n) {
        if (n == 1) {
            return acc;
        } else {
            return factorialHelper(acc * n, n - 1);
        }
    }


}
