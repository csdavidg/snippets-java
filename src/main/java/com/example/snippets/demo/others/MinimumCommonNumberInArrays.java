package com.example.snippets.demo.others;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class MinimumCommonNumberInArrays {


    public static void main(String[] args) {

        Integer[] arr1 = {5, 6, 1, 1, 4};
        Integer[] arr2 = {2, 3, 5, 6};
        Integer[] arr3 = {1, 2, 3, 4};

        Stream.of(Stream.of(arr1).collect(groupingBy(a -> a.getClass().getSimpleName())));
        Map<Integer, Long> collect = Stream.of(Stream.of(arr1).collect(toSet()),
                Stream.of(arr2).collect(toSet()),
                Stream.of(arr3).collect(toSet()))
                .flatMap(Collection::stream)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(3L))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("The arrays don't have common values"))
        );


    }

}
