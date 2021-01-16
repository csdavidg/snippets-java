package com.example.snippets.demo.others;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfThrones {

    public static void main(String[] args) {
        System.out.println(gameOfThrones("AABBCD"));
    }

    public static String gameOfThrones(String s) {
        String[] sArr = s.split("");

        Map<String, Long> lettersGrouped = Stream.of(sArr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (lettersGrouped.values().stream().filter(n -> n%2 != 0).count() > 1)? "NO" : "YES";
    }
}
