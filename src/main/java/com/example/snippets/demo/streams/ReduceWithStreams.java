package com.example.snippets.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceWithStreams {


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> countingValuesWithMapAndReduce
                = nums.stream().map(a -> 1).reduce(Integer::sum);

        System.out.println("SUM WITH REDUCE " + countingValuesWithMapAndReduce.get());

        Integer sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        Optional<Integer> maxVal = nums.stream().reduce(Integer::max);
        maxVal.ifPresent((n) -> System.out.println("Max " + n));

        List<Integer> emptyNumbers = new ArrayList<>();
        Optional<Integer> optionalSum = emptyNumbers.stream().reduce(Integer::sum);
        //optionalSum.orElseThrow(() -> new IllegalArgumentException("No value present"));

        System.out.println("DROP WHILE");
        nums.stream().dropWhile(n -> n < 5).forEach(System.out::println);

        System.out.println("TAKE WHILE");
        nums.stream().takeWhile(n -> n < 5).forEach(System.out::println);

        System.out.println("SKIP");
        nums.stream().skip(3).forEach(System.out::println);
    }
}
