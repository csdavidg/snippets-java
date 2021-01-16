package com.example.snippets.demo.others;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

public class ConstructString {

    public static void main(String[] args) {
        Stream.of("abcd", "abab").forEach(s -> System.out.println(stringConstruction(s)));
        //BiPredicate<String, List<String>> biPredicate = List::contains;
        BiPredicate<List<String>, String> biPredicateOk = List::contains;

        List<String> strings = Arrays.asList("abcd", "abab", "dasdaf", "asdasweqer", "dasfghwe");

        Comparable<String> comparable = String::length;

        String strComp = "ckals;kdla;s";

        int i = comparable.compareTo(strComp);

        Comparator<String> comp1 = (s1, s2) -> s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 : 0;

        Function<String, Comparator<String>> functionComparable =  (s1) ->  comp1;

//        Comparator<String> comparingStatic = Comparator.comparing()

    }

    static int stringConstruction(String s) {
        Set<Character> stringSet = stringToSetCharacter(s);
        return stringSet.size();
    }

    public static Set<Character> stringToSetCharacter(String word) {
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        return set;
    }
}
