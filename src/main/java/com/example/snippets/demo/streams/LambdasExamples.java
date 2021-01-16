package com.example.snippets.demo.streams;

import java.util.*;
import java.util.function.Function;

public class LambdasExamples {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("zbcd", "xbab", "dasdaf", "asdasweqer", "aasfghwe");

//        Function<String, Integer> function = (s) -> s.length();
        Function<String, Integer> function = String::length;
//        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
//        Comparator<String> comparator = Comparator.comparing(String::length);
        Comparator<String> comparator = customComparing(String::length);
        Collections.sort(strings, comparator.reversed());

        strings.forEach(System.out::println);
    }

    static Comparator<String> customComparing(Function<String, Integer> var0) {
        Objects.requireNonNull(var0);
        return (String s1, String s2) -> var0.apply(s1).compareTo(var0.apply(s2));
        /*return (Comparator)((Serializable)((var1x, var2x) -> {
            return ((Comparable)var0.apply(var1x)).compareTo(var0.apply(var2x));
        }));*/
    }


}
