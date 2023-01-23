package com.example.snippets.demo.streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountWordsInFIle {

    public static void main(String[] args) throws Exception {
        System.out.println(Math.round(2.5));
        //countUniqueWordsInAFile(args);
    }

    public static void countUniqueWordsInAFile(String args[]) throws Exception {
        Pattern separator = Pattern.compile("[\\s.,]+");

        // Let's first find out how many lines there are:
        long lineCount = Files.lines(Path.of("src/main/resources/letter.txt")).count();
        System.out.println("Found " + lineCount + " lines");

        // And how many total words:
        long wordCount = Files.lines(Path.of("src/main/resources/letter.txt"))
                .flatMap(ls -> separator.splitAsStream(ls)).count();
        System.out.println("Found " + wordCount + " words");

        // And finally, how many unique words:
        long uniqueCount = Files.lines(Path.of("src/main/resources/letter.txt"))
                .flatMap(ls -> separator.splitAsStream(ls))
                .distinct()
                .count();
        System.out.println("Found " + uniqueCount + " unique words");

        Map<String, Long> wordsMap = Files.lines(Path.of("src/main/resources/letter.txt"))
                .flatMap(ls -> separator.splitAsStream(ls))
                .map(w -> w.toLowerCase())
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        wordsMap.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 24)
                .map(e2 -> e2.getKey())
                .forEach(System.out::println);

        var num = wordsMap.values()
                .stream()
                .filter(e -> e == 1)
                .count();

        Map<String, Set<Integer>> wordsLength = wordsMap.keySet()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.mapping(String::length, Collectors.toSet())));

        Map<Integer, List<String>> wordsLengthSolution = wordsMap.keySet()
                .stream()
                .collect(Collectors.groupingBy(String::length));

        wordsLength.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        wordsLength.entrySet()
                .stream()
                .map(e -> Map.entry(e.getKey(), e.getValue().stream().findFirst().orElse(0)))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(2)
                .map(w -> w.getKey())
                .forEach(System.out::println);

    }
}
