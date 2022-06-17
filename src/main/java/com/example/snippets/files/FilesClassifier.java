package com.example.snippets.files;

import java.util.*;
import java.util.stream.Collectors;

public class FilesClassifier {

    public Map<Long, List<String>> classifyFiles(List<File> files, int topN) {

        long totalSize = files.stream()
                .mapToLong(File::getSize)
                .sum();


        Map<Group, Long> collectionsGroup = files.stream()
                .collect(Collectors.groupingBy(File::getCollection, Collectors.summingLong(File::getSize)));

        Comparator<Map.Entry<Group, Long>> compareValues = (v1, v2) -> v2.getValue().compareTo(v1.getValue());

        List<Group> groupSorted = collectionsGroup.entrySet().stream()
                .filter(e -> !e.getKey().equals(Group.NONE))
                .sorted(compareValues)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Size" + totalSize);
        System.out.println("Collections ::: ");

        groupSorted.stream().limit(topN).forEach(System.out::print);


        return Map.of(totalSize, groupSorted.stream()
                .limit(topN)
                        .map(Enum::name)
                .collect(Collectors.toList()));

        /*List<String> finalGroups = new ArrayList<>();
        int i = 0;
        while(i < topN){
            Map.Entry<Group, Long> max = collectionsGroup.entrySet().stream()
                    .filter(e -> !e.getKey().equals(Group.NONE))
                    .max(Map.Entry.comparingByValue())
                    .orElseThrow(() -> new IllegalArgumentException("No more values found"));
            finalGroups.add(max.getKey().name());
            collectionsGroup.remove(max.getKey());
            i++;
        }*/

    }
}
