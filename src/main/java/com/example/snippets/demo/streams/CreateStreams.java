package com.example.snippets.demo.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreams {

    public static void main(String[] args) {
        IntStream streamOfNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6});
        readFileUsingStreams();
        flatMapOfLists();
    }

    private static void readFileUsingStreams() {
        try (Stream<String> lines = Files.lines(Paths.get("textFile.txt"),
                Charset.defaultCharset())) {
            /*List<String> uniqueWords = new ArrayList<>();
            lines.forEach(w -> {
                System.out.println(w);
                String[] line = w.split(" ");
                for (String s : line) {
                    if (!uniqueWords.contains(s)) {
                        uniqueWords.add(s);
                    }
                }
            });*/

            /*
             * MAP returns a stream of arrays (Stream<String[]>)
             * Stream<String[]> words = lines.map(l -> l.split(" "));
             */
//            System.out.println("STREAMS ---> " + lines.map(l -> l.split(" ")).distinct().count());

            /*
             * MAP returns a stream of stream (Stream<Stream<String>>)
             * Stream<Stream<String>> streamStream = lines.map(l -> Arrays.stream(l.split(" ")));
             */
            //System.out.println("STREAMS ---> " + lines.map(l -> Arrays.stream(l.split(" "))).distinct().count());

            System.out.println("STREAMS ---> " + lines.flatMap(l -> Arrays.stream(l.split(" "))).distinct().count());

//            System.out.println("Amount of unique words " + uniqueWords.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void flatMapOfLists() {
        List<String> names = Arrays.asList("Cristian", "David", "Sanchez", "Gonzalez");
        Map<String, List<String>> wordCharacters = new HashMap<>();
        for (String name : names) {
            wordCharacters.put(name, Arrays.asList(name.split("")));
        }

        System.out.println("Amount of unique letters ---> " + wordCharacters.values().stream().flatMap(Collection::stream).distinct().count());


    }
}
