package com.example.snippets.demo.others;

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        String[] dictionary = {"a", "b", "c", "d", "e", "f", "h", "i", "x", "y", "w", "z"};
        List<String> arrList = Arrays.asList(dictionary);
        Collections.sort(arrList);
        int resultSearch = Collections.binarySearch(arrList, "e");

        System.out.println("RESULT " + resultSearch + " val " + (resultSearch < arrList.size() && resultSearch >= 0? arrList.get(resultSearch):"VOID"));


        Collections.reverse(arrList);
        arrList.forEach(System.out::println);
        String[] query = {"a", "nark", "bs", "hack", "stair"};
        Map<String, Integer> result = new HashMap<>();
        for (String q: query) {
            int count = 0;
            for (String d: dictionary) {
                if((compareWords(q, d))){
                    count++;
                }
            }
            result.put(q, count);
        }
        System.out.println(result);
    }

    public static boolean compareWords(String query, String dictionary) {
        if (query.length() == dictionary.length()) {
            List<String> word1 = Arrays.asList(query.split(""));
            Collections.sort(word1);

            List<String> word2 = Arrays.asList(dictionary.split(""));
            Collections.sort(word2);

            return word1.equals(word2);
        }

        return false;
    }
}

