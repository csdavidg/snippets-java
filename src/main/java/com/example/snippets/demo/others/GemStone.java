package com.example.snippets.demo.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GemStone {

    public static void main(String[] args) {
        String[] arr = {"basdfj", "asdlkjfdjsa", "bnafvfnsd", "oafhdlasd"};
        System.out.println(gemstones(arr));
    }

    public static int gemstones(String[] arr) {
        List<String> words = Arrays.stream(arr).sorted((s1, s2) -> {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() == s2.length()) {
                return 0;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());
        words.forEach(System.out::println);

        String lastWord = words.get(words.size() - 1);
        words.remove(lastWord);

        Set<String> longest = new HashSet<>(Arrays.asList(lastWord.split("")));
        int gemStone = 0;
        for (String s : longest) {
            long cant = words.stream().filter(word -> word.contains(s)).count();
            if (cant == words.size()) {
                gemStone++;
            }
        }
        return gemStone;
    }
}
