package com.example.snippets.demo.java11;

import java.util.stream.Stream;

public class JavaPerformanceTest {

    public static void main(String[] args) {
        Stream.iterate("_", s -> !s.isEmpty(), a -> a + a)
                .forEach(JavaPerformanceTest::printValueGenerated);
    }

    private static void printValueGenerated(String s) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
