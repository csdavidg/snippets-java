package com.example.snippets.demo.others;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInterfaceUsage {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("As", "King", "Queen", "Trevor");
        getSizes(words, String::length).forEach(System.out::println);
    }

    private static <T, R> List<R> getSizes(List<T> words, Function<T, R> function) {
        return words.stream().map(function).collect(Collectors.toList());
    }

}
