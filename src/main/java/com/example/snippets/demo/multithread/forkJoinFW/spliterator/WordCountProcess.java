package com.example.snippets.demo.multithread.forkJoinFW.spliterator;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCountProcess {

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

    private static int countWords(Stream<Character> stream) {
        /*WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                (WordCounter w, Character c) -> w.accumulate(c),
                (WordCounter w, WordCounter c) -> w.combine(c));*/

        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static void main(String[] args) {
        final String SENTENCE =
                " Nel   mezzo del cammin  di nostra  vita " +
                        "mi  ritrovai in una  selva oscura" +
                        " ché la  dritta via era   smarrita ";
        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
        System.out.println("########################");
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");

        System.out.println("########################");
        System.out.println("PARALLEL");
        Stream<Character> parallelStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(parallelStream.parallel()) + " words");

        System.out.println("########################");
        System.out.println("CUSTOM SPLITERATOR");
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> parallelStreamSIT = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(parallelStreamSIT) + " words");

    }

}
