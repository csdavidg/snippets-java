package com.example.snippets.elections;

import java.util.*;
import java.util.stream.Collectors;

public class ColombianElections {

    public List<String> findWinner(List<List<String>> votes) {

        TreeMap<String, Integer> results = new TreeMap<>();

        for (List<String> vote : votes) {
            int point = 3;
            for (String candidate : vote) {
                if (results.containsKey(candidate)) {
                    results.replace(candidate, results.get(candidate) + point);
                } else {
                    results.put(candidate, point);
                }
                point--;
            }
        }

        Comparator<Map.Entry<String, Integer>> mapCompare = (m1, m2) -> m2.getValue().compareTo(m1.getValue());

        return results.entrySet().stream()
                .sorted(mapCompare)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}