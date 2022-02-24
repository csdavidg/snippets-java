package com.example.snippets.demo.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralOperations {

    public static void printIntArrayVertical(int[] a) {
        System.out.println("");
        for (int i : a) {
            System.out.print(i);
        }
    }

    public static void printIntArrayHorizontal(int[] a) {
        for (int i : a) {
            System.out.print(i);
        }
    }

    public static void printStringArrayVertical(String[] a) {
        System.out.println("");
        for (String i : a) {
            System.out.print(i);
        }
    }

    public static void printStringArrayHorizontal(String[] a) {
        for (String i : a) {
            System.out.print(i + " ");
        }
    }

    public static void printSet(Set<?> a) {
        for (Object i : a) {
            System.out.print(i + " ");
        }
    }

    public static Set<Character> stringToSetCharacter(String word) {

        Stream<String> stream = Arrays.stream("SOME WORD".split(""));
        return Stream.of(word)
                .flatMap(a -> Arrays.stream(a.split("")))
                .map(a -> a.charAt(0))
                .collect(Collectors.toSet());
    }

    public static String buildPattern(String s) {

        Map<String, Integer> values = getStringIntegerMap(s);

        String pattern = values.entrySet().stream()
                .map(e -> e.getKey().concat("{" + e.getValue() + "}").concat("|"))
                .collect(Collectors.joining());

        return pattern.substring(0, pattern.length() - 1);

    }

    public static void main(String[] args) {
        String wordsToCount = "Cristian";
        Map<String, Integer> wordCount = getStringIntegerMap(wordsToCount);
        wordCount.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static Map<String, Integer> getStringIntegerMap(String s) {
        String[] base = s.split("");
        Arrays.sort(base);

        Map<String, Integer> values = new HashMap<>();
        for (String letter : base) {
            values.computeIfPresent(letter, (k, v) -> ++v);
            //values.computeIfAbsent(letter, k -> k.length());//BETTER IF THE VALUE REQUIRES THE KEY TO BE CALCULATED
            values.putIfAbsent(letter, 1);//BETTER IF IT'S A FIXED VALUE

            /* THIS CODE WAS IMPROVED BY THE ABOVE CODE

            if (values.containsKey(letter)) {
                Integer amount = values.get(letter) + 1;
                values.put(letter, amount);
            } else {
                values.put(letter, 1);
            }*/
        }
        return values;
    }

    public static Set<Integer> intArrayToSet(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet());
    }
}
