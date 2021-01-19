package com.example.snippets.demo.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SplitIteratorCountWords {

    private final static String SENTENCE = " Nel   mezzo del cammin  di nostra  vita " +
            "mi  ritrovai in una  selva oscura" +
            " ché la  dritta via era   smarrita ";

    public static void main(String[] args) {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println(countWords(stream.parallel()));
    }

    public static int countWords(Stream<Character> characters) {
        WordCounter totalWords = characters
                .reduce(new WordCounter(0, false), WordCounter::accumulate, WordCounter::combine);
        return totalWords.getCounter();
    }


}
