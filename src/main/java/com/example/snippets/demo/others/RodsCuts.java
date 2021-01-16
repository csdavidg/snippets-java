package com.example.snippets.demo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RodsCuts {

    public static void main(String[] args) {
        String input = "5 4 4 2 2 8";
        List<String> numbers = Arrays.asList(input.split(" "));
        List<Integer> lengths = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resulIntegers = rodOffcut(lengths);
        resulIntegers.stream().forEach(System.out::println);

    }


    public static List<Integer> rodOffcut(List<Integer> lengths) {
        Collections.sort(lengths);
        List<Integer> results = new ArrayList<>();
        while(!lengths.isEmpty()){
            int minLength = lengths.get(0);
            results.add(lengths.size());
            lengths = lengths.stream().map(n -> n-minLength).collect(Collectors.toList());
            lengths = lengths.stream().filter(n -> n > 0).collect(Collectors.toList());
        }
        return results;
    }
}
