package com.example.snippets.demo.streams;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreams {

    private static int processValue(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        IntStream.of(1, 2, 3, 4, 5)
                .parallel()
                .map(ParallelStreams::processValue)
                .boxed()
                .collect(Collectors.toList())
                .forEach(System.out::println);
                //.forEachOrdered(System.out::println);
        System.out.println("Elapsed time " + ((System.currentTimeMillis() - start) / 1000));

        Optional<Integer> value = List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .unordered() // can help to improve performance depending on the situation
                .findFirst();
        value.ifPresent(v -> System.out.println("The value is " + v));

        Optional<Integer> value2 = List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .skip(2)
                .limit(2)
                .findFirst();

        value2.ifPresent(v -> System.out.println("The second value is " + v));

        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> (a - b)));

        System.out.println(List.of("w", "o", "l", "f")
                .parallelStream()
                .reduce("", String::concat));

        ConcurrentMap<Integer, List<String>> groupedData = List.of("w", "o", "l", "f")
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));

        System.out.println(Collectors.groupingByConcurrent(String::length).characteristics());
        System.out.println(Collectors.groupingBy(String::length).characteristics());


    }


}
