package com.example.snippets.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ReduceWithStreams {


    public static void main(String[] args) {

        Predicate<String> predicate = s -> s.length() > 3;
        var stream = Stream.iterate("-",
                s -> !s.isEmpty(), (s) -> s + s);
        var b1 = stream.peek(System.out::println).noneMatch(predicate);

        Stream.iterate("_", s -> !s.isEmpty(), a -> a + a)
                .forEach(s -> {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                });

        System.out.println(" MATCH " + b1);

        Stream.iterate(1, x -> ++x)
                .limit(5).map(x -> "" + x)
                .collect(Collectors.joining());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer valueReduced = nums.stream().reduce(1, (x, y) -> x * y);
        System.out.println("ALL VALUES " + valueReduced);

        Stream.iterate(1, n -> n < 10, n -> n + 1)
                .forEach(System.out::println);

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
